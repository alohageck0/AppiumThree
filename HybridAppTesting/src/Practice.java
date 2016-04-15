import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Practice {

   DesiredCapabilities capabilities = new DesiredCapabilities();

   @Test
   public void Test() throws MalformedURLException {
      File appDir = new File("src");
      File app = new File(appDir, "selendroid-test-app.apk");

      capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
      capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
      capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 20);
      capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

      AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);


   }

}
