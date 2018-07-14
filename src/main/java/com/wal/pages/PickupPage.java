package com.wal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.wal.wrappers.GenericWrappers;

public class PickupPage extends GenericWrappers{
	
	//Page factory
		@FindBy(id="header-Logo")
		WebElement WalLogo;	
		
		//user
		@FindBy(className ="ellipsify-name")
		WebElement logedUser;
		
		//Sign out button
		@FindBy(xpath = "//a[contains(text(),'Not You? Sign Out')]")
		WebElement signOut;
		
		@FindBy(xpath="//button[@data-tl-id='undefined-paginatorButton-0']")
		WebElement SlideOffers0;
		
		@FindBy (xpath= "//img[@alt='Stretch your tax refund with cool, tech toys. Pickup for free at store as soon as today.']")
		WebElement textslslideOffer0;
		
		@FindBy(xpath="//button[@data-tl-id='undefined-paginatorButton-1']")
		WebElement SlideOffers1;
		
		@FindBy(xpath="//button[@data-tl-id='undefined-paginatorButton-2']")
		WebElement SlideOffers2;
		
		@FindBy(xpath="//button[@data-tl-id='undefined-paginatorButton-3']")
		WebElement SlideOffers3;
		
		public PickupPage(){
			PageFactory.initElements(driver, this);
		}
		
		public LoginPage signOut() {
			logedUser.click();
			signOut.click();
			return new LoginPage();
		}
		
		public String validatePickUpPageTitle()
		{
			return driver.getTitle();
		}
		
		public String verifyTextSlideOffer0(String dValue)
		{
			return driver.findElement(By.xpath("//img[@alt='"+dValue+"']")).getAttribute("title");
		}
	
}
