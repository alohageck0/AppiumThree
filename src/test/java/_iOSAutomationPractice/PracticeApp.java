package _iOSAutomationPractice;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class PracticeApp {
   DesiredCapabilities capabilities = new DesiredCapabilities();
   File app = new File("/Users/royalfiish/IdeaProjects/UdemyAppium/src/test/java/_iOSAutomationPractice/UICatalog.app");
   IOSDriver driver;

   @Before
   public void setUp() throws MalformedURLException {
      capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
      capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.3");
      capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 4s");
      capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
      driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

   }

   @After
   public void cleanUp() {
      driver.close();
   }

   @Test
   public void Test() throws MalformedURLException {


   }
}
