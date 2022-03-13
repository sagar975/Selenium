package com.automationpractise.tests;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObj.AutomatonPractise;

public class TC_LoginTest_001 extends BaseClass {
//setting up inheritance

	public static AutomatonPractise loginPage;

	@BeforeClass
	public static void initializeLoginPage() {

		loginPage = new AutomatonPractise(driver);

	}

	@Test
	public void loginToApplication() {
		System.out.println("Login to Application is invoked first");

		driver.get(read.getURL());
		loginPage.getSignButton().click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		loginPage.getEmail().sendKeys(read.getUserName());
		logger.info("username is entered");
		loginPage.getPassword().sendKeys(read.getPassWord());
		logger.info("password is entered");
		System.out.println("Logged in Successfully");

	}

}
