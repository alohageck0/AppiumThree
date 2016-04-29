package DataDriven;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelDriver {
   public static FileInputStream file;
   public static XSSFWorkbook workbook;
   public static XSSFSheet sheet;
   public static XSSFRow row;
   public static XSSFCell cell;

   public static void main(String[] args) throws IOException {
      file = new FileInputStream("/Users/royalfiish/IdeaProjects/UdemyAppium/data.xlsx");
      workbook = new XSSFWorkbook(file);
      String val = getCellData(1, 1);
      System.out.println(val);

//      setCellData(2,2, "Hello new data");
//      val = getCellData(2, 2);
//      System.out.println(val);


   }

   public static String getCellData(int rowNum, int colNum) {
      sheet = workbook.getSheet("usernames");
      row = sheet.getRow(rowNum);
      cell = row.getCell(colNum);
      return cell.getStringCellValue();
   }
   public static String setCellData(int rowNum, int colNum, String text) {
      sheet = workbook.getSheet("script");
      row = sheet.getRow(rowNum);
      cell = row.getCell(colNum);
      cell.setCellValue(text);
      return cell.getStringCellValue();
   }
}
