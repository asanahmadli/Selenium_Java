package day40;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

/**
 * Excel File--->Workbook--->Sheets--->Row--->Cells
 */
public class ReadingDataFromExcel {

    public static void main(String[] args) throws IOException {

        FileInputStream file = new FileInputStream("testdata/Data.xlsx"); //open file in reading mode

        XSSFWorkbook workbook = new XSSFWorkbook(file);     //open workbook

        XSSFSheet sheet = workbook.getSheet("Sheet1");  //open sheet name or getSheetAt() index of sheet start from zero


//        //iterate sheet all rows
//        Iterator<Row> rowIterator = sheet.rowIterator();
//
//        while (rowIterator.hasNext()) {
//            Row row = rowIterator.next();
//            //iterate cell
//            Iterator<Cell> cellIterator = row.cellIterator();
//            while (cellIterator.hasNext()) {
//                Cell cell = cellIterator.next();
//                switch (cell.getCellType()) {
//                    case STRING:
//                        System.out.print(cell.getStringCellValue() + "\t \t");
//                        break;
//                    case NUMERIC:
//                        System.out.print(cell.getNumericCellValue() + "\t \t");
//                        break;
//                    case BOOLEAN:
//                        System.out.print(cell.getBooleanCellValue() + "\t \t");
//                        break;
//                    case FORMULA:
//                        System.out.print(cell.getCellFormula() + "\t \t");
//                        break;
//                    default:
//                        System.out.print("Unknown value" + "\t \t");
//                }
//            }
//            System.out.println();
//        }


        //second approach print any number of cells

//        for(Row row:sheet){
//
//            for(int j=0;j<row.getLastCellNum();j++){
//                Cell cell = row.getCell(j);
//                switch (cell.getCellType()){
//                    case STRING:
//                        System.out.print(cell.getStringCellValue()+"\t");
//                        break;
//                    case NUMERIC:
//                        System.out.print(cell.getNumericCellValue()+"\t");
//                        break;
//                    case BOOLEAN:
//                        System.out.print(cell.getBooleanCellValue()+"\t");
//                        break;
//                    case FORMULA:
//                        System.out.print(cell.getCellFormula()+"\t");
//                        break;
//                    default:
//                        System.out.print("Unknown value"+"\t");
//                }
//            }
//            System.out.println();
//        }


        //third approach

        //find total row numbers
        int totalRows = sheet.getLastRowNum();

        //find total cell numbers in first row
        int totalCells = sheet.getRow(0).getLastCellNum();

        for (int i = 0; i < totalRows; i++) {

            //create rows
            Row row = sheet.getRow(i);

            for (int j = 0; j < totalCells; j++) {
                //create cell
                Cell cell = row.getCell(j);
                System.out.print(cell.toString() + "\t"); //print cell value to string
            }
            System.out.println();
        }

        workbook.close();
        file.close();

    }
}
