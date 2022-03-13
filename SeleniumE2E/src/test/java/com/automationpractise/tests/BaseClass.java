package com.automationpractise.tests;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.automationpractise.utilities.ReadConfig;

public abstract class BaseClass {

	protected static WebDriver driver;
	protected static Logger logger;
	protected static ReadConfig read;

	@Parameters("browsername")
	@BeforeClass
	public static void setUp(String browserName) {
		logger = Logger.getLogger("AutomationPractise"); // get Logger instance
		PropertyConfigurator.configure("Log4j.properties");
		read = new ReadConfig(); // read properties in base class

		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
			logger.info("chromedriver instance is created");
			driver.manage().window().maximize();
			return;

		} else if (browserName.equals("firefox")) {
			System.out.println("path is not saet for chrome");
			return;

		}

		else if (browserName.equals("ie")) {
			System.out.println("path is not set for ie");
			return;

		}

	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();

	}

}
