package mainframepackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenClass {

	public static void main(String[] args) throws IOException {
		//FileInputStream//
				String path="D:\\Eclipseworkspace 1\\HrmsDemoProgram\\src\\test\\resources\\TestData.xlsx";
				FileInputStream filename=new FileInputStream(path);
				XSSFWorkbook workbook=new XSSFWorkbook(filename); 
				XSSFSheet sheet=workbook.getSheetAt(0);
					
				for(int i=1; i<=5; i++) 
				{
				for(int j=0; j<=4; j++) 
				{
				System.out.println(sheet.getRow(i).getCell(j));	
				
				}
				}
}}
