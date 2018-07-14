package com.wal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wal.wrappers.GenericWrappers;

public class LoginPage extends GenericWrappers{

	//Page factory or Object repository
	@FindBy(className = "header-logo")
	WebElement walmarLogo;
	
	@FindBy(xpath = "//input[@type='email']")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath= "//button[contains(text(),'Sign In')]")
	WebElement signIn;
	
	@FindBy(xpath = "//button[contains(text(),'Forgot password?')]")
	WebElement forgoPasswordt;
	
	//Initializing page factory
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateUrlTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateWalLogo()
	{
		return walmarLogo.isDisplayed();
	}
	
	public HomePage login(String usename, String pass)
	{
		username.clear();
		username.sendKeys(usename);
		password.clear();
		password.sendKeys(pass);
		signIn.click();
		return new HomePage();
	}
	
}
