package com.inetbankin.utilities;

import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {
	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	public static ExtentTest log1;

	 //@BeforeTest
	public void onStart(ITestContext testContext) {

		// extent = new ExtentReports();
		// final File CONF = new File("extent-config.xml");

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName = "Test-Report-" + timeStamp + ".html";
		spark = new ExtentSparkReporter(
				"C:\\Users\\DemuduDonka\\eclipse-workspace\\intBankingV1\\test-output\\" + repName);

		try {
			spark.loadXMLConfig("C:\\Users\\DemuduDonka\\eclipse-workspace\\intBankingV1\\extent-config.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*
		 * try { spark.loadXMLConfig(CONF); } catch (IOException e) {
		 * 
		 * e.printStackTrace(); }
		 */
		extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Evironment", "QA");
		extent.setSystemInfo("user", "demudu");

		spark.config().setDocumentTitle("Banking Test Project");
		spark.config().setReportName("Functional Testing Report");

		spark.config().setTheme(Theme.DARK);
	}
//@AfterMethod
	public void onTestSuccess(ITestResult result) {

		log1 = extent.createTest(result.getName());
		log1.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "Test Case Passed", ExtentColor.GREEN));

		log1.pass(result.getThrowable());
//      // System.out.println(result.getName());
		String screenshotPath = "C:\\Users\\DemuduDonka\\eclipse-workspace\\intBankingV1\\Screenshots\\"
				+ result.getName() + ".png";
		File f = new File(screenshotPath);
		if (f.exists()) {
			log1.pass("Screenshot is below:" + log1.addScreenCaptureFromPath(screenshotPath));
		}

	}

//@AfterMethod
	public void onTestFailure(ITestResult result) {

		log1 = extent.createTest(result.getName());
		log1.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "Test Case Failed", ExtentColor.RED));
		String screenshotPath = "C:\\Users\\DemuduDonka\\eclipse-workspace\\intBankingV1\\Screenshots\\"
				+ result.getName() + ".png";
		File f = new File(screenshotPath);
		if (f.exists()) {
			log1.fail("Screenshot is below:" + log1.addScreenCaptureFromPath(screenshotPath));
		}
	}

//@AfterMethod
	public void onTestSkipped(ITestResult result) {

		log1 = extent.createTest(result.getName());
		log1.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "Test Case Skipped", ExtentColor.BROWN));
	}

//@AfterTest
	public void onFinish(ITestContext testContext) {
		extent.flush();
	}

}
