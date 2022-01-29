package Smoke;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import PageObj.AutomatonPractise;

import Singlton.Singeltonclass;

public class FunctionalTests {

	private static WebDriver driver;
	private static ExtentHtmlReporter reporter;

	private static AutomatonPractise object;

	private static ExtentReports extent;

	public static Properties prop;

	public static FileInputStream fis;
	public static AutomatonPractise homepage;
	private static Logger logger;

	@BeforeClass
	public static void setConfig() {

		// 1 .make the configuration for loading properties
		// 2 .get the chromedriver instance
		// 3. get the instance of ExtentHtmlReporter
		// 4. get the instance of ExtentReport

		logger = Logger.getLogger(FunctionalTests.class);
		System.out.println("before class is working here");

		File file = new File(
				"C:\\Users\\sagar\\eclipse-workspace\\SeleniumE2E\\src\\test\\java\\Properties\\Variables.properties");

		try {
			fis = new FileInputStream(file);
		}

		catch (FileNotFoundException e) {

			System.out.println("File not found");

		}

		driver = Singeltonclass.getDriver("chrome");
		// reporter = new ExtentHtmlReporter("E://sagar//ExtentReport//result.html");
		// extent = new ExtentReports();
		prop = new Properties();
		homepage = new AutomatonPractise(driver);

		try {
			prop.load(fis);
		}

		catch (Exception e) {

			System.out.println("failed to find properties file");

		}

	}

	@Test(description = "launch app in browser", priority = 1)
	public void launchApp() {

		driver = Singeltonclass.getDriver("chrome");
		// driver.get("http://automationpractice.com/index.php");
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String actualTitle = driver.getTitle();
		try {

			Assert.assertEquals(actualTitle, prop.getProperty("homepage"));

			logger.info("Application Successfully opened in browser");
		}

		catch (Exception e) {

			System.out.println();

		}

	}

	@Test(description = "click on sign in button", priority = 2)
	public void clickOnSignButton() throws Exception {

		try {

			homepage.getSignButton().click();
			logger.info("Successfully clicked in sign button");

		}

		catch (Exception e) {

			System.out.println("click operation failed");
		}

	}

	@Test(description = "login to app", priority = 3)
	public void loginToApp() {
		homepage.getEmail().sendKeys("sagar");
		logger.info("Entered username");
		homepage.getPassword().sendKeys("sonawane");
		logger.info("Entered password");

	}

	@AfterTest(description = "close the browser", enabled = false)
	public void tearDown() {

		driver.quit();

	}

}
