package UtilsLayer;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testsample {

	
	public static void main(String[] args) throws Throwable {
		
		//ArrayList<String> list = ExcelReadTestCases.getData("guru99test", "testCases", "user1");
		
		//System.out.println(list.get(2));
		//ArrayList<String> data = democode.getData("guru99test", "testCases", "user1");
	//System.out.println(data.get(2));
		 ArrayList<String> p = DemoExcelCode.getdata("guru99test", "testCases", "user1");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys( p.get(0));
		
		
	}
}
