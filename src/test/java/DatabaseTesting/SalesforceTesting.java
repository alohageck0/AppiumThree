package DatabaseTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.Properties;

public class SalesforceTesting {
   private ResultSet resultSet;
   WebDriver driver = null;

   @BeforeSuite
   public void setUp() throws SQLException {
      String host = "localhost";
      String port = "3306";
      String database = "QADBT";

      Properties p = new Properties();
      p.setProperty("user", "root");
      p.setProperty("password", "8wyN#7GO;XPB");
      p.setProperty("verifyServerCertificate", "false");
      p.setProperty("useSSL", "false");
      p.setProperty("serverTimezone", "UTC");

      Connection connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, p);

      Statement s = connection.createStatement();
      resultSet = s.executeQuery("select * from Credentials where scenario='zerobalancecard';");
   }

   @BeforeMethod
   public void openDriver() {
      driver = new FirefoxDriver();
      driver.get("https://login.salesforce.com");
   }

   @Test
   public void testLogin() {

   }
}
