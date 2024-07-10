package day40;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class WritingDynamicDataIntoExcel {

    public static void main(String[] args) throws IOException {


        //below code check if file exist it will write into file but if not it will create the file
        FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\dynamic.xlsx");

        //1.create workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        //create sheet
        XSSFSheet sheet = workbook.createSheet("DynamicData");

        Scanner scan = new Scanner(System.in);

        System.out.println("How many rows?");
        int noOfRows = scan.nextInt();

        System.out.println("How many cells?");
        int noOfCells = scan.nextInt();

        for(int i=0;i<noOfRows;i++){

            Row row = sheet.createRow(i);

            for(int j=0;j<noOfCells;j++){
                Cell cell = row.createCell(j);
                cell.setCellValue(scan.next());
            }
        }

        workbook.write(file);
        workbook.close();
        file.close();

    }
}
