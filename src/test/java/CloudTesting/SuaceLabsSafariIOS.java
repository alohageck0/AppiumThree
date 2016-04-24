package CloudTesting;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SuaceLabsSafariIOS {
   DesiredCapabilities capabilities = DesiredCapabilities.iphone();

   @Before
   public void setUp() {
      capabilities.setCapability("platformName", "iOS");
      capabilities.setCapability("platformVersion", "7.1");
      capabilities.setCapability("appiumVersion", "1.3.4");
      capabilities.setCapability("deviceName", "iPhone Simulator");
      capabilities.setCapability("browserName", "Safari");

   }

   @Test
   public void test() {

   }


}
