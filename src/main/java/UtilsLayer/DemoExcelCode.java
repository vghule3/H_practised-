package UtilsLayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DemoExcelCode {
	
	public static ArrayList getdata(String sheetname,String columnname,String testcases) throws IOException
	{
		ArrayList l=new ArrayList();
		File f=new File("C:\\Users\\vishal ghule\\eclipse-workspace\\DetaDriven\\src\\main\\java\\TestDataLayer\\readDeta.xlsx");
	FileInputStream fis=new FileInputStream(f);
	XSSFWorkbook workbook=new XSSFWorkbook(fis);
	
	int sheets = workbook.getNumberOfSheets();
	for(int i=0;i<sheets;i++)
	{
		if(workbook.getSheetName(sheets).equalsIgnoreCase(sheetname))
		{
			XSSFSheet sheet = workbook.getSheetAt(i);
			Iterator<Row> rows = sheet.iterator();
			
			Iterator<Cell> cells = rows.next().cellIterator();
			
			int k=0;
			int columnIndex=0;
			while(cells.hasNext())
			{
				if(cells.next().getStringCellValue().equalsIgnoreCase(columnname))
				{
					columnIndex=k;
				}
				k++;
			}
			while(rows.hasNext())
			{
				if(rows.next().getCell(columnIndex).getStringCellValue().equalsIgnoreCase(testcases))
				{
					Iterator<Cell> testdata = rows.next().iterator();
					
					while(testdata.hasNext())
					{
						l.add(testdata.next().getStringCellValue());
					}
				}
				
			}
		}
	}
	
	return l;
	}
	

}
