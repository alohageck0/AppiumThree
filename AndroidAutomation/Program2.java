import com.github.genium_framework.appium.support.server.AppiumServer;
import com.github.genium_framework.server.ServerArguments;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Program2 {
   private ServerArguments serverArguments = new ServerArguments();
   private AppiumServer appiumServer;

   @Before
   public void startUp() {
      serverArguments = new ServerArguments();
      serverArguments.setArgument("--address", "127.0.0.1");

      serverArguments.setArgument("--no-reset", true);

      serverArguments.setArgument("--local-timezone", true);
      serverArguments.setArgument("--device-ready-timeout", "10");
      appiumServer = new AppiumServer(serverArguments);
      appiumServer.startServer();
   }

   @After
   public void cleanUp() {
      appiumServer.stopServer();
   }

   @Test
   public void test() throws MalformedURLException {
      File appDir = new File("src");
      File app = new File(appDir, "ApiDemos-debug.apk");
      DesiredCapabilities cap = new DesiredCapabilities();
      cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
      cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Moto");
      cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 20);
      cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
      AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
//      driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

      driver.scrollTo("Preference").click();
      List<WebElement> a = driver.findElements(By.id("android:id/text1"));
      System.out.println(a.get(8).getText());
   }

}
