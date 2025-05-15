package DataDriven;

import java.io.FileInputStream;
import java.io.IOException; 
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    public static Object[][] getTestData(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);
        int rows = sheet.getPhysicalNumberOfRows();
        int cols = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rows - 1][cols];

        for (int i = 1; i < rows; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < cols; j++) {
                data[i - 1][j] = row.getCell(j).getStringCellValue();
            }
        }
        workbook.close();
        return data;
    }
}
