package com.wal.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wal.pages.HomePage;
import com.wal.pages.LoginPage;
import com.wal.pages.PickupPage;
import com.wal.util.TestUtil;
import com.wal.wrappers.GenericWrappers;

public class PickUpPageAdTest extends GenericWrappers{

		LoginPage log;
		HomePage hom; 
		PickupPage pic; 
		
		PickUpPageAdTest(){
			super();
		}
		
		@BeforeMethod()
		public void setup()
		{
			invokeApp(sBrowser, sMode);
			log = new LoginPage();
			hom = new HomePage();
			pic = new PickupPage();
			hom = log.login(sUsername, sPassword);	
		}
		
		@Test()
		public void pickUpAddValidaiton() throws InterruptedException
		{
			hom.clickPickupBtn();
			pic.validatePickUpPageTitle();
			Thread.sleep(TestUtil.THREAD_SLEEP_MIN);
			String AdText1 = pic.verifyTextSlideOffer0(TestUtil.PICKUPPAGE_SLIDE0_TEXT_XPATH);
			Assert.assertEquals(AdText1, "Stretch your tax refund with cool, tech toys. Pickup for free at store as soon as today.");	
			pic.signOut();
		}
		
		
		@AfterMethod()
		public void endSetup()
		{
			closeBrowser();
		}
	}
