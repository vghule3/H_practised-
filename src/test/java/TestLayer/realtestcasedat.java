package TestLayer;

import java.util.ArrayList;

import org.testng.annotations.Test;

import UtilsLayer.ExcelReadTestCases;

public class realtestcasedat {
	
	@Test
	public void fetchAlldeta() throws Throwable {
		
		ArrayList data = ExcelReadTestCases.getData("testdata", "testCases", "purchase");
	
	   Object object = data.get(0);
	}

}
