package TestLayer;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseLayer.BaseClass;
import Pagelayer.loginDemo;
import UtilsLayer.excelDemo;
import io.github.bonigarcia.wdm.WebDriverManager;

public class dtatproviderDemo extends BaseClass {
	
	@Test(dataProvider = "getData")
	public void setup(String user,String pass) 
	{
	BaseClass.initialization();
	loginDemo lp=new loginDemo();
	lp.sendUsername(user);
	lp.sendPassword(pass);	
	driver.quit();
	}
	
	@DataProvider
   public Object[][] getData() throws Throwable
   {
	 excelDemo reader=new excelDemo("C:\\Users\\vishal ghule\\eclipse-workspace\\DetaDriven\\src\\main\\java\\TestDataLayer\\New Microsoft Excel Worksheet (3).xlsx");
	  
	   int row=reader.countRow(3);
	   int cell=reader.cellCount(3);
	   
	   Object[][] obj=new Object[row][cell];
	   
	   for(int i=0;i<row;i++)
	   {
		  obj[i][0]    = reader.getdataFromExcel(3, i, 0);
		    obj[i][1]     =reader.getdataFromExcel(3, i, 1);
	   }
	  
	   return obj;
   }
	
}
