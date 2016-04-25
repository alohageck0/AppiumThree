package CloudTesting;

import io.appium.java_client.ios.IOSDriver;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class SuaceLabsSafariIOS {
   private DesiredCapabilities capabilities = DesiredCapabilities.iphone();
   private IOSDriver driver;
   private String url = new Scanner(new File("/Users/royalfiish/IdeaProjects/UdemyAppium/src/test/java/CloudTesting/url")).nextLine();

   public SuaceLabsSafariIOS() throws FileNotFoundException {
   }

   @Before
   public void setUp() throws MalformedURLException {
      capabilities.setCapability("platformName", "iOS");
      capabilities.setCapability("platformVersion", "9.1");
      capabilities.setCapability("appiumVersion", "1.5.1");
      capabilities.setCapability("deviceName", "iPhone Simulator");
      capabilities.setCapability("browserName", "safari");

      driver = new IOSDriver(new URL(url), capabilities);
   }

   @Test
   public void test() throws InterruptedException {
      driver.get("http://udemy.com");

   }


}
