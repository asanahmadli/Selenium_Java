package day40;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**Excel File--->Workbook--->Sheets--->Row--->Cells*/
public class ReadingDataFromExcel {

    public static void main(String[] args) throws IOException {

        FileInputStream file = new FileInputStream("testdata/Data.xlsx"); //open file in reading mode

        XSSFWorkbook workbook = new XSSFWorkbook(file);     //open workbook

        XSSFSheet sheet = workbook.getSheet("Sheet1");  //open sheet name or getSheetAt() index of sheet start from zero

        int rowNumber = sheet.getLastRowNum();
        System.out.println(rowNumber);
       String str = String.valueOf(sheet.getRow(0).getCell(0));
        System.out.println(str);

    }
}
