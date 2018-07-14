package com.wal.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wal.pages.HomePage;
import com.wal.pages.LoginPage;
import com.wal.util.TestUtil;
import com.wal.wrappers.GenericWrappers;

public class HomeMenuTest extends GenericWrappers {
	LoginPage log;
	HomePage hom;

	HomeMenuTest() {
		super();
	}

	@BeforeMethod()
	public void setup() throws InterruptedException {
		invokeApp(sBrowser, sMode);
		log = new LoginPage();
		hom = new HomePage();
		hom = log.login(sUsername, sPassword);
		Thread.sleep(TestUtil.THREAD_SLEEP_MIN);
	}

	@Test()
	public void HomePageMenuCheck() {
		try {
			hom.VerifyPickupBtnExists();
			String title = hom.validateHomePageTitle();
			Assert.assertEquals(title, "Account");
			hom.VerifyGrossPickupBtnExists();
			hom.signOut();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterMethod()
	public void endSetup() {
		closeBrowser();
	}
}
