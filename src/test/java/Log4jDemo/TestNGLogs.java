package Log4jDemo;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNGLogs {
   Logger logger;

   @BeforeSuite
   public void setUp() {
      logger = Logger.getLogger("TestNGLogs");
      PropertyConfigurator.configure("/Users/royalfiish/IdeaProjects/UdemyAppium/log4g.properties");
   }

   @Test
   public void test1() {
      System.out.println("Test 1");
      logger.info("test1 pass");
   }

   @Test
   public void test2() {
      Assert.assertEquals(false, true);
      logger.info("test2 pass");

   }

   @Test(dependsOnMethods = {"test2"})
   public void test3() {
      System.out.println("Was executed");
      logger.info("test3 pass");

   }
}
