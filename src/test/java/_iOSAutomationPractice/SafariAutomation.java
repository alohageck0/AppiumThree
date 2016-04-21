package _iOSAutomationPractice;

import com.github.genium_framework.appium.support.server.AppiumServer;
import com.github.genium_framework.server.ServerArguments;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class SafariAutomation {
   private DesiredCapabilities capabilities = new DesiredCapabilities();
   //   private File app = new File("/Users/royalfiish/IdeaProjects/UdemyAppium/src/test/java/_iOSAutomationPractice/UICatalog.app");
   private IOSDriver driver;
   private ServerArguments serverArguments = new ServerArguments();
   private AppiumServer appiumServer;

   @Before
   public void setUp() throws MalformedURLException {

      capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.3");
      capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 4s");
      capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
      driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);


   }

   @Test
   public void Test() {
      driver.get("http://yahoo.com");
   }
}
