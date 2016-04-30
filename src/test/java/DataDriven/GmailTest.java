package DataDriven;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

public class GmailTest {
   public static XSSFWorkbook workbook = null;
   public static XSSFSheet sheet = null;
   public static XSSFRow row = null;
   public static XSSFCell cell = null;
   WebDriver driver = null;

   @DataProvider
   public Object[][] getData() throws IOException {
      FileInputStream file = new FileInputStream("/Users/royalfiish/IdeaProjects/UdemyAppium/data.xlsx");
      workbook = new XSSFWorkbook(file);
      sheet = workbook.getSheet("usernames");
      System.out.println("First row number = " + sheet.getFirstRowNum() + "\nLast row number = " + sheet.getLastRowNum());

      int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum() + 1;
      int columnCount = sheet.getRow(0).getLastCellNum();

      System.out.println("Row count is " + rowCount + "\nColumn count is " + columnCount);

      Object[][] data = new Object[rowCount - 1][columnCount];

//      for (int i=1;i<=rowCount;i++){
//         for (int j=)
//      }
      return data;
   }


}
