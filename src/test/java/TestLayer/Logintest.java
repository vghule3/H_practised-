package TestLayer;

import java.io.IOException;

import BaseLayer.BaseClass;
import Pagelayer.LoginPage;
import UtilsLayer.readExcelSheet;

public class Logintest extends BaseClass {
	
	public static void main(String[] args) throws IOException {
		
	  BaseClass.initialization();
	   
	   LoginPage lp =new LoginPage();
	   lp.loginFunctionality();
	   System.out.println(readExcelSheet.getPass());
	}
	

}
