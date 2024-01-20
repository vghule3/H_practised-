package UtilsLayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import BaseLayer.BaseClass;

public class excelDemo  extends BaseClass{
	public static XSSFWorkbook workbook;
	public excelDemo(String path) throws Throwable
	{
		File f=new File(path);
		FileInputStream fis=new FileInputStream(f);
		 workbook =new XSSFWorkbook(fis);
	}
	public static String getdataFromExcel(int sheetindex,int rowIndex,int cellindex)
	{
		try
		{
		 return workbook.getSheetAt(sheetindex).getRow(rowIndex).getCell(cellindex).getStringCellValue();
		}
		catch(Exception e)
		{
			double d=workbook.getSheetAt(sheetindex).getRow(rowIndex).getCell(cellindex).getNumericCellValue();
			
			return Double.toString(d);
		}
	}
	
	public static int countRow(int sheetIndex)
	{
		return workbook.getSheetAt(sheetIndex).getLastRowNum();
	}
	public static int cellCount(int sheetIndex)
	{
		return workbook.getSheetAt(sheetIndex).getRow(0).getLastCellNum();
	}
	

}
