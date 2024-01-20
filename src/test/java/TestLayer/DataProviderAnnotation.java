package TestLayer;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import UtilsLayer.ExcelReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderAnnotation {
	
	public static WebDriver driver;
	@Test(dataProvider="data")
	public void setUp(String user,String pass) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://www.facebook.com/");
		 driver.findElement(By.name("email")).sendKeys(user);
		   driver.findElement(By.name("pass")).sendKeys(pass);
		   Thread.sleep(3000);

			driver.close();
	}
	

	@DataProvider(name="data")
	public Object[][] fetchData() throws IOException 
	{
		ExcelReader read=new ExcelReader("C:\\Users\\vishal ghule\\Desktop\\New Microsoft Excel Worksheet (3).xlsx");
	    int row = read.countRow(3);
	    int cell = read.count(3);
	    Object obj[][]=new Object[row][cell];
	    
	    for(int i=0;i<row;i++)
	    {
	    	
	    		obj[i][0]=read.getDetaFromSheet(3, i, 0);
	    		obj[i][1]=read.getDetaFromSheet(3, i, 1);
	    		
	    }
	   return obj; 
	}
}
