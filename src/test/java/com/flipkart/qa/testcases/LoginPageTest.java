package com.flipkart.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipcart.qa.pages.LoginPage;
import com.flipcart.qa.testBase.BaseClass;


public class LoginPageTest extends BaseClass {
	LoginPage loginPage;
	public LoginPageTest() {
		super();
	}

	
	@BeforeMethod
	public void setup(){
		browserInitialisation();
		 loginPage =new LoginPage();
	}
	
	@Test(priority=1)
	public void logintest() {
		String title=loginPage.validatePage();
		System.out.println(" title  "+title);
		loginPage.logintoApp(prop.getProperty("loginName"), prop.getProperty("password"));	
		
	}
	@Test(priority=2)
	public void login() {
		
		loginPage.logintoApp(prop.getProperty("loginName"), prop.getProperty("password"));	
	}
	
	@AfterMethod
	public void endTest() {
		driver.close();
		
	}
}
