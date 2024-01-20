package Pagelayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseLayer.BaseClass;

public class loginDemo extends BaseClass {
	
	@FindBy(id="email")
	WebElement email; 

	@FindBy(id="pass")
	WebElement pass;
	
	public loginDemo() {
		PageFactory.initElements(driver, this);
	}
	
	public void sendUsername(String user)
	{
		email.sendKeys(user);
	}
	public void sendPassword(String user)
	{
		pass.sendKeys(user);
	}

}
