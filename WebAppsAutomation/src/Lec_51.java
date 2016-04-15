import com.github.genium_framework.appium.support.server.AppiumServer;
import com.github.genium_framework.server.ServerArguments;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Lec_51 {
   private ServerArguments serverArguments = new ServerArguments();
   private AppiumServer appiumServer;
//
//   @Before
//   public void startUp() {
//      serverArguments.setArgument("--address", "127.0.0.1");
////      serverArguments.setArgument("--no-reset", true);
//      serverArguments.setArgument("--local-timezone", true);
//      serverArguments.setArgument("--device-ready-timeout", "100");
//      appiumServer = new AppiumServer(serverArguments);
//      appiumServer.startServer();
//   }
//
//   @After
//   public void cleanUp() {
//      appiumServer.stopServer();
//   }

   @Test
   public void test() throws MalformedURLException, InterruptedException {
      File appDir = new File("src");
//      File app = new File(appDir, "base.apk");


      DesiredCapabilities cap = new DesiredCapabilities();
      cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
      cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
      cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
      cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 200);
//      cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
//      cap.setCapability(MobileCapabilityType.NO_RESET, true);
      cap.setCapability("deviceReadyTimeout", 40);

      AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

      driver.get("http://udemy.com");
      Thread.sleep(3000);
      driver.findElementByCssSelector(".white-link.ud_i_search.fxac").click();
      Thread.sleep(2000);
      driver.findElementByCssSelector(".dropdown-menu.search-v4-wrap.ud-angular-loaded").click();

//      JavascriptExecutor jse = (JavascriptExecutor) driver;
//      jse.executeScript("document.getElementsByName('src')[0].setAttribute('type', 'text');");
//      jse.executeScript("document.getElementByXpath('//*[@id=\"searchbox\"]/input[2]').setAttribute('type', 'text');");
//      driver.findElement(By.xpath("//*[@id=\"searchbox\"]/input[2]")).clear();
      driver.findElement(By.xpath("//*[@id=\"searchbox\"]/input[2]")).sendKeys("soapui");


//      driver.findElement(By.xpath("//form[@id='searchbox']/input[1]")).sendKeys("soapui");
////      driver.findElementByXPath("html/body/div[1]/div/div[1]/div[3]/div[2]/div/form/input[1]").click();
//      Thread.sleep(2000);
////      driver.findElementByCssSelector(".dropdown-menu.search-v4-wrap.ud-angular-loaded").sendKeys("sdfsd");
//
////      driver.findElementByClassName("ng-pristine ng-valid ng-valid-maxlength").sendKeys("sdsd");
//      driver.findElementById("searchbox").sendKeys("dwdwd");
//
//      driver.findElementByCssSelector(".ud_i_search.search-btn").click();
//      List<WebElement> titles = driver.findElementsByCssSelector(".title.bold.fs15-force.ng-binding");
//      System.out.println(titles.get(0).getText());

   }
}
