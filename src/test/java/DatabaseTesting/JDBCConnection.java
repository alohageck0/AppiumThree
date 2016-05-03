package DatabaseTesting;

import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
   public static void main(String[] args) throws SQLException {
      DriverManager.getConnection("jdbc:mysql://" + "localhost:3306" + "/QADBT", "root", "8wyN#7GO;XPB");
   }
}
