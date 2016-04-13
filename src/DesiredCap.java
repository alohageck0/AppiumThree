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
import java.util.concurrent.TimeUnit;


public class DesiredCap {
   private ServerArguments serverArguments = new ServerArguments();
   private AppiumServer _appiumServer;

   @Before
   public void startUp() {
      serverArguments = new ServerArguments();
      serverArguments.setArgument("--address", "127.0.0.1");

      serverArguments.setArgument("--no-reset", true);

      serverArguments.setArgument("--local-timezone", true);
      _appiumServer = new AppiumServer(serverArguments);
      _appiumServer.startServer();
   }

   @After
   public void cleanUp() {
      _appiumServer.stopServer();
//      System.out.println(_appiumServer.isServerRunning());
   }

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
      driver.findElementById("com.bt.bms:id/signUp").click();
      int size = driver.findElements(By.className("android.widget.EditText")).size();
//      System.out.println(size);
      List<WebElement> a = driver.findElements(By.className("android.widget.EditText"));
      List<WebElement> b = driver.findElements(By.className("android.widget.RelativeLayout"));
      a.get(0).sendKeys("Appium");
      a.get(1).sendKeys("Testing");
      a.get(2).sendKeys("test@gmail.com");
      b.get(0).sendKeys("password");
      a.get(4).sendKeys("23423423423");
      driver.findElementById("com.bt.bms:id/action_icon").click();
   }
}
