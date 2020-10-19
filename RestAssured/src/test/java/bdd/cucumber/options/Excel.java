package bdd.cucumber.options;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("C:\\Users\\ragir\\OneDrive\\Desktop\\Rest API Automation\\DataBook.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook();
        int sheets = workbook.getNumberOfSheets();
        for (int i = 0; i < sheets; i++) {
            if (workbook.getSheetName(i).equalsIgnoreCase("FamilyData")) {
                XSSFSheet sheet = workbook.getSheetAt(i);
                Iterator<Row> rows = sheet.iterator();
                Row firstrow = rows.next();
                Iterator<Cell> ce = firstrow.cellIterator();
                int k = 0;
                int column = 0;
                while (ce.hasNext()) {
                    Cell value = ce.next();
                    if (value.getStringCellValue().equalsIgnoreCase("TestCases")) {
                        column = k;
                    }
                    k++;
                }
                while (rows.hasNext()) {
                    Row r = rows.next();
                    if (r.getCell(column).getStringCellValue().equalsIgnoreCase("Raju")) {
                        Iterator<Cell> cv = r.cellIterator();
                        while (cv.hasNext()) {
                            System.out.println(cv.next().getStringCellValue());
                        }
                    }
                }
            }
        }

    }
}