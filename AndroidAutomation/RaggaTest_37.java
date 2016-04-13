import com.github.genium_framework.appium.support.server.AppiumServer;
import com.github.genium_framework.server.ServerArguments;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class RaggaTest_37 {
   private ServerArguments serverArguments = new ServerArguments();
   private AppiumServer appiumServer;

//   @Before
//   public void startUp() {
//      serverArguments = new ServerArguments();
//      serverArguments.setArgument("--address", "127.0.0.1");
//
//      serverArguments.setArgument("--no-reset", true);
//
//      serverArguments.setArgument("--local-timezone", true);
//      serverArguments.setArgument("--device-ready-timeout", "10");
//      appiumServer = new AppiumServer(serverArguments);
//      appiumServer.startServer();
//   }
//
//   @After
//   public void cleanUp() {
//      appiumServer.stopServer();
//   }

   @Test
   public void test() throws MalformedURLException {
      File appDir = new File("src");
      File app = new File(appDir, "base.apk");


      DesiredCapabilities cap = new DesiredCapabilities();
      cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
      cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
      cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 200);
      cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
      cap.setCapability(MobileCapabilityType.NO_RESET, true);

      AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

      driver.scrollTo("Trending");


      WebElement trendingButton = driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Trending\")");
      TouchAction touchAction = new TouchAction(driver);
      touchAction.tap(trendingButton).perform();
      String screenTitle = driver.findElementById("com.raaga.android:id/music_album_title").getText();
      Assert.assertEquals("Trending", screenTitle);

//      System.out.println(driver.getContext());

      driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Sitamma Vakitlo\").instance(0))");
      List<WebElement> songs = driver.findElementsByClassName("android.widget.TextView");
      for (WebElement s : songs) {
         if (s.getText().equals("Sitamma Vakitlo")) {
            touchAction.tap(s).perform();
            break;
         }
      }
      WebElement playAllButton = driver.findElementById("com.raaga.android:id/controls_play_song");
      touchAction.tap(playAllButton).perform();

   }
}
