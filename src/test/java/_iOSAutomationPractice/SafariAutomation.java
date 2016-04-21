package _iOSAutomationPractice;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class SafariAutomation {
   private DesiredCapabilities capabilities = new DesiredCapabilities();
   private IOSDriver driver;

   @Before
   public void setUp() throws MalformedURLException {

      capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.3");
      capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 4s");
      capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
      driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);


   }

   @Test
   public void Test() {
      driver.get("http://gmail.com");
      driver.findElementByName("Email").sendKeys("Test");
      driver.findElementByName("Passwd").sendKeys("Test");
      driver.findElementByName("signIn").click();

   }
}
