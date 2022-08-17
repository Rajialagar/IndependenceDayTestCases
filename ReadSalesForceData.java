package independencyDayMarathonScenarios;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadSalesForceData {
	
	public static String[][] readSalesData(String excelName) throws IOException{
		
		XSSFWorkbook wbook = new XSSFWorkbook("data/"+excelName+".xlsx");
		XSSFSheet sheet = wbook.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
		int columnCount = sheet.getRow(0).getLastCellNum();
		
		String [][] data = new String [rowCount][columnCount];
		
		for (int i = 1; i <= rowCount; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < columnCount; j++) {
				XSSFCell column = row.getCell(j);
				System.out.println(column.getStringCellValue());
				data[i-1][j] = column.getStringCellValue();
							
				
			}
			
		}
		wbook.close();
		return data;
				
	}
	
	public static String[][] readSalesSaluationData(String excelName) throws IOException{

		XSSFWorkbook wbook1 = new XSSFWorkbook("data/"+excelName+".xlsx");
		XSSFSheet sheet1 = wbook1.getSheetAt(0);
		int rowCount1 = sheet1.getLastRowNum();
		int columnCount1 = sheet1.getRow(0).getLastCellNum();
		
		String [][] data = new String [rowCount1][columnCount1];
		
		for (int i = 1; i <= rowCount1; i++) {
			XSSFRow row = sheet1.getRow(i);
			for (int j = 0; j < columnCount1; j++) {
				XSSFCell column1 = row.getCell(j);
				System.out.println(column1.getStringCellValue());
				data[i-1][j] = column1.getStringCellValue();
							
				
			}
			
		}
		wbook1.close();
		return data;
		
		
	}

}
