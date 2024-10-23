package LoginDemoFramework;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class usingPOILibrary {

    public void readExcel() throws IOException {

        FileInputStream inputfile = new FileInputStream("/Users/kalai/Downloads/testdata.xlsx");
        Workbook workbook = new HSSFWorkbook(inputfile);
        Sheet sheet = workbook.getSheet("Sheet1");

        Iterator<Row> rowIterator = sheet.iterator();
        while(rowIterator.hasNext())
        {
            Row rowvalue = rowIterator.next();

            Iterator<Cell> columnIterator = rowvalue.iterator();
            while(columnIterator.hasNext())
            {
                Cell columnvalue = columnIterator.next();
                System.out.println(columnvalue);
            }
        }

    }
    public static void main (String[] args) throws IOException {
        usingPOILibrary usingPOILibrary = new usingPOILibrary();
        usingPOILibrary.readExcel();

    }
}
