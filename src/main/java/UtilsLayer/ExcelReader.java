package UtilsLayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public static XSSFWorkbook workbook;

	public ExcelReader(String path) throws IOException
	{
	  File f=new File(path);
	  FileInputStream fis=new FileInputStream(f);
	   workbook=new XSSFWorkbook(fis);
	 }

	public String getDetaFromSheet(int sheetIndex,int row,int cell)
	{
	  try
	 {
	   return workbook.getSheetAt(sheetIndex).getRow(row).getCell(cell).getStringCellValue();
	  }
	  catch(Exception e)
	  {
	    double d=workbook.getSheetAt(sheetIndex).getRow(row).getCell(cell).getNumericCellValue();
	      int b=(int)d;
	     return Integer.toString(b);
	   }
	}

	 public int countRow(int sheetIndex)
	  { 
	    return workbook.getSheetAt(sheetIndex).getLastRowNum();
	  }
	 public int count (int sheetIndex)
	  {
	   return workbook.getSheetAt(sheetIndex).getRow(0).getLastCellNum();
	   }
	 
	 public static void main(String[] args) throws Throwable {
		 ExcelReader r=new ExcelReader("C:\\Users\\vishal ghule\\eclipse-workspace\\DetaDriven\\src\\main\\java\\TestDataLayer\\New Microsoft Excel Worksheet (3).xlsx");
	int b=r.count(0);
	System.out.println(b);
	 }
	/* public void fetchAlldeta(int sheetIndex)
	  { 
	    int row= workbook.getSheetAt(sheetIndex).getLastRowNum();
	     int cell=workbook.getSheetAt(sheetIndex).getRow(0).getLastCellNum();
	    Object[][]data=new Object[row][cell];
	      int i=0;
	      int j=0;
	       for( i=0;i<row;i++)
	        {
	            for( j=0;j<cell;j++)
	            {
	               data[i][j]= workbook.getSheetAt(sheetIndex).getRow(row).getCell(cell).getStringCellValue();   
	             }
	          }
	      System.out.println(data[i][j]);
	    } */
	 

}


