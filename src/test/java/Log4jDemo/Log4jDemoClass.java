package Log4jDemo;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jDemoClass {
   public static void main(String[] args) {
      Logger logger = Logger.getLogger("Log4jDemoClass");
      PropertyConfigurator.configure("/Users/royalfiish/IdeaProjects/UdemyAppium/log4g.properties");
      logger.debug("This is debug");
      logger.info("This is info");
      logger.warn("This is warn");
      logger.error("this is error");
      logger.fatal("This is fatal");
   }
}
