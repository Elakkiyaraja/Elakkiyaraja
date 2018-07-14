package com.wal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wal.wrappers.GenericWrappers;

public class LogoutPage extends GenericWrappers{
	@FindBy(xpath= "//button[contains(text(),'Sign In')]")
	WebElement signIn;
	
	LogoutPage(){
		
			PageFactory.initElements(driver, this);
		}
	
	public boolean validateLogOutSuccess() {
		return signIn.isDisplayed();
		
	}
}
