package com.inetbanking.Testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbankin.utilities.XLUtils;
import com.inetbanking.pageObjects.LoginPage;

public class Tc_Login_002 extends BaseClass {
	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException {
		LoginPage lo = new LoginPage(driver);
	lo.setusername(user);
		logger.info("username provided");
		lo.setpassword(pwd);
		logger.info("password provided");
		lo.clickSubmit();
		Thread.sleep(5000);
		if (isAlertPresent() == true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("login failed");
			Thread.sleep(5000);
		} else {
			Assert.assertTrue(true);
			logger.info("login passed");
			lo.logoutMethod();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Thread.sleep(5000);
		}
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException

	{
		String path = "C:\\Users\\DemuduDonka\\eclipse-workspace\\intBankingV1\\src\\main\\java\\com\\inetbanking\\Testdata\\loginData1.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		String logindata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j <colcount; j++) {
				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);// 1 0
			}
		}
		return logindata;

	}

}
