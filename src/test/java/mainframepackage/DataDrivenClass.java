package mainframepackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenClass {
/*
	public static void main(String[] args) throws IOException {
		        //FileInputStream//
				String path="D:\\Eclipseworkspace 1\\HrmsDemoProgram\\src\\test\\resources\\TestData.xlsx";
				FileInputStream filename=new FileInputStream(path);
				XSSFWorkbook workbook=new XSSFWorkbook(filename); 
				XSSFSheet sheet=workbook.getSheetAt(0);   
					
				for(int i=1; i<=5; i++) 
				{
				for(int j=0; j<=1; j++) 
				{
				System.out.println(sheet.getRow(i).getCell(j));	
				}
				}}}		
	*/
	
@DataProvider(name="getData")
public String[][] getData() throws IOException {
    String filePath = "D:\\Eclipseworkspace 1\\HrmsDemoProgram\\src\\test\\resources\\TestData.xlsx";
    String sheetName = "Sheet1";

    FileInputStream inputStream = new FileInputStream(filePath);
    XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
    XSSFSheet sheet = workbook.getSheet(sheetName);
    
    int noOfRows=sheet.getPhysicalNumberOfRows();
    int noOfColums=sheet .getRow(0).getLastCellNum();
    
    String[][] data= new String[noOfRows-1][noOfColums];
    
    for(int i=0; i<noOfRows-1;i++) {
    for(int j=0; j< noOfColums; j++) {
    DataFormatter df= new DataFormatter();
    
    data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));		
    }
    System.out.println();
    }
    workbook.close();
    inputStream.close();
    
    return data;
   /* for(String[] dataArr:data)
    {
    System.out.println(Arrays.toString(dataArr));
}*/
  
 }}

	
