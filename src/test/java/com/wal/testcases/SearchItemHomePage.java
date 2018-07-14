package com.wal.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wal.pages.HomePage;
import com.wal.pages.LoginPage;
import com.wal.util.TestUtil;
import com.wal.wrappers.GenericWrappers;

public class SearchItemHomePage extends GenericWrappers{
	
	LoginPage log;
	HomePage hom;
	
	SearchItemHomePage(){
		super();
	}
	
	@BeforeClass()
	public void setData()
	{
		datasheet = "TestData";
	}

	@BeforeMethod()
	public void setup()
	{
		invokeApp(sBrowser, sMode);
		log = new LoginPage();
	}
	
	@Test(dataProvider = "fetch")
	public void LoginWalmart(String sName) throws InterruptedException
	{
		hom = log.login(sUsername, sPassword);
		Thread.sleep(TestUtil.THREAD_SLEEP_MIN);
		hom.searchItemHomePage(sName);
	}
	
	
	@AfterMethod()
	public void endSetup()
	{
		closeBrowser();
	}
	

}
