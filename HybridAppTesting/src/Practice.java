import com.github.genium_framework.appium.support.server.AppiumServer;
import com.github.genium_framework.server.ServerArguments;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;

public class Practice {
   private ServerArguments serverArguments = new ServerArguments();
   private AppiumServer appiumServer;
   private DesiredCapabilities capabilities = new DesiredCapabilities();

   @Before
   public void startUp() {
      serverArguments = new ServerArguments();
      serverArguments.setArgument("--address", "127.0.0.1");

//      serverArguments.setArgument("--no-reset", true);

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
   public void Test() throws MalformedURLException, InterruptedException {
      File appDir = new File("src");
      File app = new File(appDir, "employee-directory.apk");

      capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
      capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
      capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 20);
      capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

      AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

//      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
      Thread.sleep(8000);

      driver.findElement(By.className("android.widget.EditText")).sendKeys("Paul");
      Set<String> set = driver.getContextHandles();
      System.out.println(set.size());

      List<WebElement> people = driver.findElements(By.className("android.view.View"));
      driver.findElementByAndroidUIAutomator("new UiSelector().descriptionContains(\"Jones\")").click();

      set = driver.getContextHandles();
//      System.out.println(set.size());
      //next

   }

}
