package com.automationpractise.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automationpractise.pageobjects.HomePage;

public class TC_SearchProduct_002 extends TC_LoginTest_001 {

	protected HomePage page; // global level variables
	protected TC_LoginTest_001 loginTest;

	@BeforeClass
	public void initializeHomePage() {

		page = new HomePage(driver);
		loginTest = new TC_LoginTest_001();

	}

	@Test(priority = 1)
	public void searchProduct() {

		page.getSearchBar().sendKeys(read.getProduct());

	}

}
