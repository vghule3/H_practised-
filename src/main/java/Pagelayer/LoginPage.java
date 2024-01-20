package Pagelayer;

import java.io.IOException;

import org.openqa.selenium.By;


import BaseLayer.BaseClass;
import UtilsLayer.readExcelSheet;

public class LoginPage extends BaseClass {

	

	public void loginFunctionality() throws IOException
	{
		
		driver.findElement(By.id("txtUsername")).sendKeys(readExcelSheet.userName());;
		driver.findElement(By.id("divPassword")).sendKeys(readExcelSheet.getPass());
		driver.findElement(By.id("btnLogin")).click();
	}
		
	
}
