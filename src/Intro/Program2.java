package Intro;

import com.github.genium_framework.appium.support.server.AppiumServer;
import com.github.genium_framework.server.ServerArguments;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Program2 {
   private ServerArguments serverArguments = new ServerArguments();
   private AppiumServer appiumServer;

   @Before
   public void startUp() {
      serverArguments = new ServerArguments();
      serverArguments.setArgument("--address", "127.0.0.1");

      serverArguments.setArgument("--no-reset", true);

      serverArguments.setArgument("--local-timezone", true);
      appiumServer = new AppiumServer(serverArguments);
      appiumServer.startServer();
   }

   @After
   public void cleanUp() {
      appiumServer.stopServer();
   }

   @Test
   public void test() {

   }
}
