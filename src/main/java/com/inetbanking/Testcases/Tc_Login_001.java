package com.inetbanking.Testcases;

import java.io.IOException;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class Tc_Login_001 extends BaseClass {

	@Test
	public void LoginTest() throws InterruptedException, IOException {
		
		logger.info("base url opened");
		LoginPage lp = new LoginPage(driver);
		
		lp.setusername(username);
		logger.info("entered username");
		
		lp.setpassword(password);
		logger.info("entered password");
		Thread.sleep(5000);
		lp.clickSubmit();
		Thread.sleep(5000);
		logger.info("clicked");
		driver.getTitle();
		System.out.println(driver.getTitle());
		
		
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
		//captureScreen(driver, "LoginTest1");
			Assert.assertTrue(true);
			logger.info("login test passed");
		} 
		else {
			 captureScreen(driver ,"LoginTest1") ;
			Assert.assertTrue(false);
			logger.info("login test failed");
		}

	
	
}}
