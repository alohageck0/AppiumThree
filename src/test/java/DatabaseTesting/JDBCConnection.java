package DatabaseTesting;

import java.sql.*;
import java.util.Properties;

public class JDBCConnection {
   public static void main(String[] args) throws SQLException {
      String host = "localhost";
      String port = "3306";
      String database = "QADBT";

      Properties p = new Properties();
      p.setProperty("user", "root");
      p.setProperty("password", "8wyN#7GO;XPB");
      p.setProperty("verifyServerCertificate", "false");
      p.setProperty("useSSL", "false");
      p.setProperty("serverTimezone","UTC");

      Connection connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, p);

      Statement s = connection.createStatement();
      ResultSet resultSet = s.executeQuery("select * from Credentials where scenario='zerobalancecard';");

      while (resultSet.next()) {
         System.out.println(resultSet.getString("username"));
         System.out.println(resultSet.getString("password"));
      }

   }
}
