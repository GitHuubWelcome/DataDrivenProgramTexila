package exceldataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelDataProvider {


	@DataProvider(name = "excelData")
	public Object[][] readExcelData() throws IOException, EncryptedDocumentException, Throwable {
	    // Read data from Excel and provide a single column of String values

        FileInputStream file = new FileInputStream("D:\\Eclipseworkspace 1\\HrmsDemoProgram\\src\\test\\resources\\TestData.xlsx");
        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheet("Sheet 1");

        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount + 1][colCount];
        for (int i = 0; i <= rowCount; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < colCount; j++) {
                Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                CellType cellType = cell.getCellTypeEnum();
                if (cellType == CellType.NUMERIC) {
                    data[i][j] = cell.getNumericCellValue();
                } else {
                    data[i][j] = cell.toString();
                    workbook.close();
                    file.close();
                    return data;
                }
            }
        }
		return data;
		}}
		

    

