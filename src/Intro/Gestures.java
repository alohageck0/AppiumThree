package Intro;

import com.github.genium_framework.appium.support.server.AppiumServer;
import com.github.genium_framework.server.ServerArguments;
import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class Gestures {
   private ServerArguments serverArguments = new ServerArguments();
   private AppiumServer _appiumServer;

   @Before
   public void startUp() {
      serverArguments = new ServerArguments();
      serverArguments.setArgument("--address", "127.0.0.1");

      serverArguments.setArgument("--no-reset", true);

      serverArguments.setArgument("--local-timezone", true);
      serverArguments.setArgument("--device-ready-timeout", "10");

      _appiumServer = new AppiumServer(serverArguments);
      _appiumServer.startServer();
   }

   @After
   public void cleanUp() {
      _appiumServer.stopServer();
   }

   @Test
   public void test() throws MalformedURLException, InterruptedException {
      File appDir = new File("src");
      File app = new File(appDir, "BookMyShow.apk");
      DesiredCapabilities cap = new DesiredCapabilities();
      cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
      cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Moto");
      cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 200);
      cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
      cap.setCapability(MobileCapabilityType.FULL_RESET, true);
      AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

      driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

      driver.findElementById("com.bt.bms:id/btnNoThanks").click();
      driver.findElementById("com.bt.bms:id/dismiss").click();
      MobileElement abc = (MobileElement) driver.findElement(By.className("android.widget.CheckedTextView"));

      abc.swipe(SwipeElementDirection.UP, 2000);


   }
}
