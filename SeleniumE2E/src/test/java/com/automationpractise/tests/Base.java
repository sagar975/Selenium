package com.automationpractise.tests;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automationpractise.pageobjects.LoginPage;
import com.automationpractise.utilities.ReadConfig;

public class Base {

	public static WebDriver driver;
	protected static LoginPage loginPage;
	protected static Logger logger;
	protected static ReadConfig reader;

	@BeforeClass
	public void initializeUtilities() {
		logger = Logger.getLogger("AutomationPractise");
		PropertyConfigurator.configure("Log4j.properties");
		reader = new ReadConfig();

	}

	@Parameters
	@Test
	public void loginToAppliacation(@Optional("chrome") String browserName) {

		if (browserName.equalsIgnoreCase(browserName)) {

			// driver = WebDriverManager.chromedriver().create();

			System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();

			driver.manage().window().maximize();

			driver.get(reader.getURL());
			logger.info("Url is opened");

			loginPage = new LoginPage(Base.driver);
			loginPage.getSignButton().click();

			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			if (loginPage.getEmail().isEnabled()) {

				loginPage.getEmail().sendKeys(reader.getUserName());

			}

			loginPage.getPassword().sendKeys(reader.getPassWord());
			loginPage.getSubmit().click();

			// return;
		}

	}

	public void fooTest() {

	}

	public void tearDown() {

	}

}
