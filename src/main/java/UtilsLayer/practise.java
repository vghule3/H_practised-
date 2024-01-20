package UtilsLayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class practise {
	
	public static void main(String[] args) throws IOException {
		
		File f=new File("C:\\Users\\vishal ghule\\Desktop\\New Microsoft Excel Worksheet (3).xlsx");
		
		FileInputStream fis=new FileInputStream(f);
		XSSFWorkbook workbook =new XSSFWorkbook(fis);
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		int lastRowNum = sheet.getLastRowNum();
		System.out.println(lastRowNum);
		
		//System.out.println(sheet.getRow(0).getCell(1).getNumericCellValue());
		double d = sheet.getRow(0).getCell(1).getNumericCellValue();
	int b=(int)d;
	System.out.println(b);
	
		
		
	

}
}