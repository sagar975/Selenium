package com.automationpractise.tests;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automationpractise.utilities.ReadConfig;

public abstract class BaseClass {

	protected static WebDriver driver;
	protected static Logger logger;
	protected static ReadConfig read;

	@BeforeSuite
	public void getRequiredInstance() {
		logger = Logger.getLogger("AutomationPractise"); // get Logger instance
		PropertyConfigurator.configure("Log4j.properties");
		read = new ReadConfig();
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
	}

	@Test
	public void foooo() {

		System.out.println("public void fooo");

	}

	@Parameters("browsername")
	@Test
	public static void setUp(@Optional("chrome") String browserName) {
		// logger = Logger.getLogger("AutomationPractise"); // get Logger instance
		// PropertyConfigurator.configure("Log4j.properties");
		// read = new ReadConfig(); // read properties in base class

		if (browserName.equalsIgnoreCase("chrome")) {
			// System.setProperty("webdriver.chrome.driver",
			// "C:\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
			logger.info("chromedriver instance is created");
			driver.manage().window().maximize();
			driver.get("https://www.google.com/");
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

	@AfterTest(enabled = false)
	public void closeBrowser() {
		driver.quit();
		logger.info("browser is closed");

	}

}
