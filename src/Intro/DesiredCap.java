package Intro;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class DesiredCap {
//   public static void main(String[] args) throws MalformedURLException {
//      test();
//   }

   @Test
   public void test() throws MalformedURLException, InterruptedException {
      File appDir = new File("src");
      File app = new File(appDir, "BookMyShow.apk");
// should be in every script
      DesiredCapabilities cap = new DesiredCapabilities();
      cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
      cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Moto");
      cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 100);
      cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
      AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
      driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
      driver.findElementById("com.bt.bms:id/btnLogin").click();
   }
}
