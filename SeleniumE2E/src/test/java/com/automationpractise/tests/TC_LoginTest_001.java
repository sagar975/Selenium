package com.automationpractise.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObj.AutomatonPractise;

public class TC_LoginTest_001 extends BaseClass {
//setting up inheritance

	public static AutomatonPractise loginPage;
	public static WebDriverWait wait;

	@BeforeClass
	public static void initializeLoginPage() {
		wait = new WebDriverWait(driver, 10);

		loginPage = new AutomatonPractise(driver);

	}

	@Test(priority = 0)
	private void loginToApplication() {

		driver.get(read.getURL());
		loginPage.getSignButton().click();
		// wait.until(ExpectedConditions.elementToBeClickable(loginPage.getEmail()));
		loginPage.getEmail().click();

		loginPage.getEmail().sendKeys(read.getUserName());

		logger.info("username is entered");
		loginPage.getPassword().sendKeys(read.getPassWord());
		logger.error("crashed");
		loginPage.getSignButton().click();
		logger.info("submit button is clicked");
		

		System.out.println("Logged in Successfully");

	}

}
