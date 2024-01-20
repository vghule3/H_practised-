package UtilsLayer;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDetaStanderedCode {
	
	public static void main(String[] args) throws Throwable {
		//readDeta.xlx  file name
	//identify testcases colum by scanning entire ist row
	//onces identify the column then scan entire testcase column to identify manager testcases	
	//after grab manager testcase then pull all deta from row and feed it  into test	
		
	ArrayList<Object> ls=new ArrayList<Object>();	
		File f=new File("C:\\Users\\vishal ghule\\eclipse-workspace\\DetaDriven\\src\\main\\java\\TestDataLayer\\readDeta.xlsx");
	
		//System.out.println(f.exists());
	
		FileInputStream fis=new FileInputStream(f);
	
	XSSFWorkbook workbook=new XSSFWorkbook(fis);
	
	int sheets=workbook.getNumberOfSheets();
	
	for(int i=0;i<sheets;i++)
	{
		if(workbook.getSheetName(i).equalsIgnoreCase("testdata"))
		{
			XSSFSheet sheet = workbook.getSheetAt(i);
			//identify testcases colum by scanning entire i row	
			Iterator<Row> rows = sheet.iterator();
			
			Row ist = rows.next();
//scan each ist row column that conatins testcase by itrates each column in first row
			
		Iterator<Cell> cells = ist.cellIterator();//get all cell in i row
		
		//sheet=collection of row
		//row is collection of cell
		int k=0;
		int columnIndex=0;  //for grab paticuler collum index conatin testCases
		while(cells.hasNext())
		{
			Cell value = cells.next();
			if(value.getStringCellValue().equalsIgnoreCase("testCases"))
			{
				columnIndex=k;
				
			}
			k++;
		}
		//System.out.println(columnIndex);
//onces identify the column then scan entire testcase column to identify manager testcases		
		while(rows.hasNext())
		{
			Row r = rows.next();
	    if(r.getCell(columnIndex).getStringCellValue().equalsIgnoreCase("purchase"))
	      {
//after grab your particular testcases row pull all deta that row and feed into test    	    
	    	Iterator<Cell> ab = r.cellIterator();
	    	     
	    	while(ab.hasNext())
	    	{
	    		//System.out.println( ab.next().getStringCellValue());
	    		//add to arraylist obj
	    		
	    		ls.add(ab.next().getStringCellValue());
	    		
	    	}
	      }
			
		 }
		
		 
		
	}
	
	
	
	}
	System.out.println(ls.get(0));

 }
}