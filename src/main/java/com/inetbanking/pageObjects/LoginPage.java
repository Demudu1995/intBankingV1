package com.inetbanking.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	public static WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	/*@FindBy(name = "//*[@class=\"new-orange-btn\"]")
	WebElement txtUsername;
	public void setusername() {
		//WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(20))
			//	.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"new-orange-btn\"]")));
			//	WebElement button = driver.findElement(By.xpath("//*[@class=\"new-orange-btn\"]"));
		txtUsername.click();
	}*/

	@FindBy(name = "uid")
	WebElement txtUsername;

	@FindBy(name = "password")
	WebElement txtPassword;

	@FindBy(name = "btnLogin")
	WebElement login;

	@FindBy(xpath = "//a[text()='Log out']")
	WebElement logout;

	public void setusername(String uname) {
		txtUsername.sendKeys(uname);
	}

	public void setpassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void clickSubmit() {
		login.click();
	}

	public void logoutMethod() {
		logout.click();

	}
}
