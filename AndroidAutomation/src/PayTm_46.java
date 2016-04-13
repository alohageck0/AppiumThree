import com.github.genium_framework.appium.support.server.AppiumServer;
import com.github.genium_framework.server.ServerArguments;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class PayTm_46 {
   private ServerArguments serverArguments = new ServerArguments();
   private AppiumServer appiumServer;

   @Before
   public void startUp() {
      serverArguments.setArgument("--address", "127.0.0.1");
//      serverArguments.setArgument("--no-reset", true);
      serverArguments.setArgument("--local-timezone", true);
      serverArguments.setArgument("--device-ready-timeout", "100");
      appiumServer = new AppiumServer(serverArguments);
      appiumServer.startServer();
   }

   @After
   public void cleanUp() {
      appiumServer.stopServer();
   }

   @Test
   public void test() throws MalformedURLException, InterruptedException {
      File appDir = new File("src");
      File app = new File(appDir, "base.apk");


      DesiredCapabilities cap = new DesiredCapabilities();
      cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
      cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
      cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 200);
      cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
//      cap.setCapability("appPackage", "com.raaga.android");
//      cap.setCapability("appActivity", "com.raaga.android.SplashScreen");
//      cap.setCapability(MobileCapabilityType.NO_RESET, true);
      cap.setCapability("deviceReadyTimeout", 40);

      AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
      Thread.sleep(7000);

      try {
         driver.swipe(50, 100, 60, 120, 1000);
      } catch (Exception e) {
         e.printStackTrace();
      }
      driver.findElementById("net.one97.paytm:id/edit_no").sendKeys("2768539");

      TouchAction touchAction = new TouchAction(driver);
      touchAction.tap(driver.findElementById("net.one97.paytm:id/lyt_mob_op")).perform();
      driver.scrollTo("Vodafone");
      touchAction.tap(driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Vodafone\")")).perform();
//      driver.scrollTo("Mumbai");
      driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Mumbai\").instance(0))");
      touchAction.tap(driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Mumbai\")")).perform();

   }
}
