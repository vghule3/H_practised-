package BaseLayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Demo2 {
	public static void main(String[] args) throws IOException {
		File f=new File("‪C:\\Users\\vishal ghule\\Desktop\\vis.xlsx");
		FileInputStream fis=new FileInputStream(f);
		
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		
		
		Iterator<Sheet> iterator = workbook.iterator();
		
		
	}

}
