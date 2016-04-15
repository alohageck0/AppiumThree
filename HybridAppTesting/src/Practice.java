import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class Practice {

   DesiredCapabilities capabilities = new DesiredCapabilities();

   @Test
   public void Test() {
      capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
      capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
      capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 20);

   }

}
