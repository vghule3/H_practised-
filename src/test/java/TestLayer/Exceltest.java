package TestLayer;

import java.io.IOException;

import UtilsLayer.ExcelReader;

public class Exceltest {
	public static void main(String[] args) throws IOException {
		
		ExcelReader read=new ExcelReader("C:\\Users\\vishal ghule\\Desktop\\New Microsoft Excel Worksheet (3).xlsx");
	
	System.out.println(read.getDetaFromSheet(3, 6, 1));
	System.out.println(read.countRow(3));
	System.out.println(read.count(3));
	//read.fetchAlldeta(3);
	
	}
	

}
