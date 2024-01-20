package UtilsLayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class democode {
	public static XSSFWorkbook workbook;
	public static  XSSFSheet sheet;
	public static ArrayList data;
	public static ArrayList getData(String sheetname,String columnname,String testcasename) throws Throwable
	{
		
		 data=new ArrayList();
		File f=new File("C:\\Users\\vishal ghule\\eclipse-workspace\\DetaDriven\\src\\main\\java\\TestDataLayer\\readDeta.xlsx");
		FileInputStream fis=new FileInputStream(f);
		 workbook=new XSSFWorkbook(fis);
		int sheets = workbook.getNumberOfSheets();
		
		for(int i=0;i<sheets;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase(sheetname))
			{
				 sheet = workbook.getSheetAt(i);
				 Iterator<Row> rows = sheet.iterator();
				 Iterator<Cell> cells = rows.next().iterator();
				 int k=0;
				 int columnIndex=0;
				 while(cells.hasNext())
				 {
					 Cell r = cells.next();
					 if(r.getStringCellValue().equalsIgnoreCase(columnname))
					 {
						columnIndex=k; 
					 }
					 k++;
				 }
				while(rows.hasNext())
				{
					if(rows.next().getCell(columnIndex).getStringCellValue().equalsIgnoreCase(testcasename))
					{
						Row p = rows.next();
						Iterator<Cell> testcasedata = p.iterator();
						
						while(testcasedata.hasNext())
						{
							Cell o = testcasedata.next();
							
							data.add(o.getStringCellValue());
						}
					}
				}
				 
			}
			
		}
		return data;		
	}
	public static void main(String[] args) throws Throwable {
		ArrayList<String> list = democode.getData("guru99test", "testCases", "user1");
		System.out.println(list.get(4));
	}
  }

