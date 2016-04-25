package CloudTesting;

import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class SuauceLabsNativeIOS {
   private DesiredCapabilities capabilities = DesiredCapabilities.iphone();
   private IOSDriver driver;
   private String url = new Scanner(new File("/Users/royalfiish/IdeaProjects/UdemyAppium/src/test/java/CloudTesting/url")).nextLine();

   public SuauceLabsNativeIOS() throws FileNotFoundException {
   }


   @Before
   public void setUp() throws MalformedURLException {
      capabilities.setCapability("platformName", "iOS");
      capabilities.setCapability("platformVersion", "9.1");
      capabilities.setCapability("appiumVersion", "1.5.1");
      capabilities.setCapability("deviceName", "iPhone Simulator");
      capabilities.setCapability("browserName", "");
      capabilities.setCapability("app", "sauce-storage:UICatalog.zip");

      driver = new IOSDriver(new URL(url), capabilities);
   }

   @Test
   public void Test() throws InterruptedException {
      WebDriverWait wait = new WebDriverWait(driver, 25);

      TouchAction touchAction = new TouchAction(driver);
      //Open pickers screen
      WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[6]")));

      touchAction.tap(element).perform();

      //Choose Serena Auroux
      String nameToTest = "Serena Auroux";
      String numberToTest = "3";

      Thread.sleep(3000L);

      driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAPicker[1]/UIAPickerWheel[1]")).sendKeys(nameToTest);
      driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAPicker[1]/UIAPickerWheel[2]")).sendKeys(numberToTest);
      String result = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAStaticText[1]")).getText();
      Thread.sleep(3000L);

      Assert.assertEquals(nameToTest + " - " + numberToTest, result);
      driver.quit();
   }
}
