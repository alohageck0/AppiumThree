package DataDriven;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelDriver {
   public static XSSFWorkbook workbook;
   public static XSSFSheet sheet;
   public static XSSFRow row;
   public static XSSFCell cell;

   public static void main(String[] args) throws IOException {
      FileInputStream file = new FileInputStream("/Users/royalfiish/IdeaProjects/UdemyAppium/data.xlsx");
      workbook = new XSSFWorkbook(file);
      getCellData(2, 2);
   }

   public static void getCellData(int rowNum, int colNum) {
      sheet = workbook.getSheet("script");
      row = sheet.getRow(rowNum);
      cell = row.getCell(colNum);
      String val = cell.getStringCellValue();
      System.out.println(val);
   }
}
