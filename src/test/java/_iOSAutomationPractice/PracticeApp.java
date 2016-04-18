package _iOSAutomationPractice;

import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class PracticeApp {
   @Before
   public void setUp() {
      File app = new File("/Users/royalfiish/IdeaProjects/UdemyAppium/src/test/java/_iOSAutomationPractice/UICatalog.app");
      DesiredCapabilities capabilities = new DesiredCapabilities();
      capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
      capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.3");
      capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPad 2");
      capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
   }

   @Test
   public void Test() {


   }
}
