package com.wal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wal.wrappers.GenericWrappers;

public class HomePage extends GenericWrappers {

	//Page factory
	@FindBy(id="header-Logo")
	WebElement WalLogo;
	
	//user
	@FindBy(className ="ellipsify-name")
	WebElement logedUser;
	
	//Sign out button
	@FindBy(xpath = "//a[contains(text(),'Not You? Sign Out')]")
	WebElement signOut;
	
	//Pickup button
	@FindBy(css = "div.arrange-fill > nav > div > a:first-child")
	WebElement pickUp;
	
	@FindBy(css = "div.arrange-fill > nav > div > a:nth-of-type(2)")
	WebElement GrosPickUp;
	
	@FindBy(className = "header-GlobalSearch-input")
	WebElement searchInHomePage;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage signOut() {
		logedUser.click();
		signOut.click();
		return new LoginPage();
	}
	
	public PickupPage clickPickupBtn() {
		pickUp.click();
		return new PickupPage();
	}
	
	public boolean VerifyPickupBtnExists() {
		return pickUp.isDisplayed();
	}
	
	public String validateHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public GroceryPickupPage clickGroceryPickupBtn() {
		GrosPickUp.click();
		return new GroceryPickupPage();
	}
	
	public boolean VerifyGrossPickupBtnExists() {
		return GrosPickUp.isDisplayed();
	}
	
	
	public void searchItemHomePage(String sName)
	{
		searchInHomePage.sendKeys(sName);
		
	}
	
}
