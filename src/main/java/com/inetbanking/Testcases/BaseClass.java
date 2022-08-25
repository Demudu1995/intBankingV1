package com.inetbanking.Testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
//import org.apache.log4j.LogManager;

import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.inetbankin.utilities.ReadConfig;



public class BaseClass {
	ReadConfig read = new ReadConfig();
	public String baseURL = read.getAppl();
	public String username = read.getUser();
	public String password = read.getpass();
	public String chromepath = read.getChromeUrl();
	public String firefoxpath = read.getFirefoxUrl();
	public static WebDriver driver;

public static Logger logger;

	@Parameters("browser")
	@BeforeMethod
	public void setup(String br) throws InterruptedException {
logger = Logger.getLogger("initBankingV1");
		PropertyConfigurator.configure("Log4j.properties");
		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", chromepath);
			// WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", firefoxpath);
			// WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseURL);

	}

	@AfterMethod
	public void teardown() {
	driver.quit();
	}
	

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(
				"C:\\Users\\DemuduDonka\\eclipse-workspace\\intBankingV1\\Screenshots\\" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	}

