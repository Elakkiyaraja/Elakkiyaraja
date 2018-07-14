package com.wal.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wal.pages.HomePage;
import com.wal.pages.LoginPage;
import com.wal.util.TestUtil;
import com.wal.wrappers.GenericWrappers;

public class LoginAppTest extends GenericWrappers{

	LoginPage log;
	HomePage hom;  
	
	LoginAppTest(){
		super();
	}
	
	@BeforeMethod()
	public void setup()
	{
		invokeApp(sBrowser, sMode);
		log = new LoginPage();
	}
	
	@Test()
	public void LoginWalmart() throws InterruptedException
	{
		hom = log.login(sUsername, sPassword);
		Thread.sleep(TestUtil.THREAD_SLEEP_MIN);
		hom.signOut();
	}
	
	
	@AfterMethod()
	public void endSetup()
	{
		closeBrowser();
	}
}
