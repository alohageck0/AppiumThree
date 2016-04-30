package DataDriven;

import org.apache.poi.ss.usermodel.Cell;
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


   //    @Test(dataProvider = )
//    public void test(){
//
//    }
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

      for (int i = 1; i <= rowCount; i++) {
         for (int j = 0; j <= columnCount; j++) {
            data[i - 1][j] = getCellData("usernames", i, j);
//            data[i - 1][j] = sheet.getRow(i).getCell(j).getRawValue();
         }
      }
      return data;
   }

   public String getCellData(String sheetName, int rowNumber, int columnNumber) {
      try {
         if (rowNumber <= 0)
            return "";
         int index = workbook.getSheetIndex(sheetName);
         if (index == -1) {
            return "";
         }
         sheet = workbook.getSheetAt(index);
         row = sheet.getRow(rowNumber - 1);
         if (row == null) {
            return "";
         }
         cell = row.getCell(columnNumber);
         if (cell == null) {
            return "";
         }
         if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
            return cell.getStringCellValue();
         } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC || cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
            return String.valueOf(cell.getNumericCellValue());
         } else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
            return "";
         } else {
            return String.valueOf(cell.getBooleanCellValue());
         }
      } catch (Exception e) {
         e.printStackTrace();
         return "does not exist in *.xls";
      }
   }

}
