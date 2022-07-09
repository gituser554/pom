package com.flipcart.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipcart.qa.testBase.BaseClass;


public class LoginPage extends BaseClass {
	//Object repository
	@FindBy(xpath="//*[@class='_2IX_2- VJZDxU']")
	WebElement username;
	
	
	@FindBy(xpath="//*[@type='submit']")
	WebElement loginbtn;
	@FindBy(xpath="//*[@type=\"password\"]")
	WebElement password;
	
	
	//initialize page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions
	public String validatePage() {
		return driver.getTitle();
	}
	public void logintoApp(String Username, String passwrd) {
		username.sendKeys(Username);
		password.sendKeys(passwrd);
		loginbtn.click();
		
		//return driver.getTitle();
	}
	
}