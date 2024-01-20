package UtilsLayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import BaseLayer.BaseClass;

public class readExcelSheet extends BaseClass {
	public static FileInputStream fis;
	public static XSSFSheet sheet;
	
	
	public static String userName() throws IOException
	{
		File f=new File("C:\\Users\\vishal ghule\\Desktop\\New Microsoft Excel Worksheet (3).xlsx");
	     fis=new FileInputStream(f);
	     System.out.println(f.exists());
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0);
		
		 String str=sheet.getRow(0).getCell(1).getStringCellValue();
		 return str;
		 
	}
	public static String getPass()
	{
		try{
			return sheet.getRow(0).getCell(2).getStringCellValue();
		}
		catch(Exception e)
		{
			double d= sheet.getRow(0).getCell(2).getNumericCellValue();
			int a=(int )d;
		  return  Integer.toString(a);
		}
	}
	public static String getfirstName() {
		try
		{
			return sheet.getRow(0).getCell(3).getStringCellValue();
		}
		catch(Exception e){
			double d= sheet.getRow(0).getCell(3).getNumericCellValue();
			int a=(int )d;
		  return  Integer.toString(a);
		}
		
	}
	public static String getMiddleName() {
		
		try{
			return sheet.getRow(4).getCell(3).getStringCellValue();
		}
		catch(Exception e)
		{
			double d= sheet.getRow(4).getCell(3).getNumericCellValue();
			int a=(int )d;
			  return  Integer.toString(a);
		}
		
	}
	public static String getLastName() {
		
		try{
			return sheet.getRow(5).getCell(3).getStringCellValue();
		}
		catch(Exception e)
		{
			double d= sheet.getRow(5).getCell(3).getNumericCellValue();
			int a=(int )d;
			  return  Integer.toString(a);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		System.out.println(userName());
		System.out.println(getfirstName());
		System.out.println(getMiddleName());
           System.out.println(getLastName());
		System.out.println(getPass());

	}
	
	
}
