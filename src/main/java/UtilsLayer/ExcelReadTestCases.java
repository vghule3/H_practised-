package UtilsLayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadTestCases {
	
	public static ArrayList getData(String sheetname,String testcasesColumnName,String testcasename ) throws Throwable
	{
		ArrayList ls=new ArrayList();
		
		File f=new File("C:\\Users\\vishal ghule\\eclipse-workspace\\DetaDriven\\src\\main\\java\\TestDataLayer\\readDeta.xlsx");
		
		FileInputStream fis=new FileInputStream(f);
		
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		
		int sheets=workbook.getNumberOfSheets();
		
		for(int i=0;i<sheets;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase(sheetname))
			{
				XSSFSheet sheet = workbook.getSheetAt(i);
				
				Iterator<Row> rows = sheet.iterator();
			     Row r = rows.next();
			     Iterator<Cell> cells = r.cellIterator();
				int k=0;
				int columnIndex=0;
			    while(cells.hasNext())
			    {
			    	Cell title = cells.next();
			    	if(title.getStringCellValue().equalsIgnoreCase(testcasesColumnName))
			    	{
			    		columnIndex=k;
			    	}
			    	k++;
			    }
			    while(rows.hasNext())
			    {
			    	Row names = rows.next();
			    	if(names.getCell(columnIndex).getStringCellValue().equalsIgnoreCase(testcasename))
			    	{
			    		Iterator<Cell> testcasedata = names.cellIterator();
			    		while(testcasedata.hasNext())
			    		{
			    			Cell alldataTestcase = testcasedata.next();
			    			ls.add(alldataTestcase.getStringCellValue());
			    			
			    		}
			    	}
			    	
			    }
			}
		}
		return ls;
	}

}
