package UtilsLayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class exceldataproviserguru99 {
   
	public static XSSFWorkbook workbook;
	
	public exceldataproviserguru99(String path) throws Throwable
	{
		File f=new File(path);
		FileInputStream fis=new FileInputStream(f);
		 workbook=new XSSFWorkbook(fis);
		
	}
	public String getDatafromExcel(int sheetindex,int row,int cell)
	{
		
		return workbook.getSheetAt(sheetindex).getRow(row).getCell(cell).getStringCellValue();
		
	}
	public int getRow(int sheetindex)
	{
		return workbook.getSheetAt(sheetindex).getLastRowNum();
	}
	public int getCell(int sheetindex)
	{
		return workbook.getSheetAt(sheetindex).getRow(0).getLastCellNum();
	}
	public static void main(String[] args) throws Throwable {
		
		exceldataproviserguru99 reader=new exceldataproviserguru99("C:\\Users\\vishal ghule\\eclipse-workspace\\DetaDriven\\src\\main\\java\\TestDataLayer\\readDeta.xlsx");
	String s = reader.getDatafromExcel(1, 1, 4);
	//System.out.println(s);
	int cell=reader.getCell(1);
	//System.out.println(reader.getRow(1));
	
	Object[][] obj=new Object[reader.getRow(1)][cell];
	for(int i=0;i<reader.getRow(1);i++)
	{
		obj[i][0]=reader.getDatafromExcel(1, i, 0 );
		obj[i][1]=reader.getDatafromExcel(1, i, 1);
		
	}
	
	System.out.println(obj.toString());
	}
}
