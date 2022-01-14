package Functional;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObj.AutomatonPractise;
import Singlton.Singeltonclass;
import junit.framework.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Jsconcept {
	public static WebDriver driver;

	private static ExtentHtmlReporter reporter;

	private static AutomatonPractise object;

	private static ExtentReports extent;

	public static Properties prop;

	public static FileInputStream fis;

	@BeforeClass(description = "configuration method")
	public void invokeDriver() {

		// 1 .make the configuration for loading properties
		// 2 .get the chromedriver instance
		// 3. get the instance of ExtentHtmlReporter
		// 4. get the instance of ExtentReport

		File file = new File(
				"C:\\Users\\sagar\\eclipse-workspace\\SeleniumE2E\\src\\test\\java\\Properties\\Variables.properties");

		try {
			fis = new FileInputStream(file);
		}

		catch (FileNotFoundException e) {

			System.out.println("File not found");

		}

		driver = Singeltonclass.getDriver("chrome");
		reporter = new ExtentHtmlReporter("E://sagar//ExtentReport//result.html");
		extent = new ExtentReports();
		prop = new Properties();

		try {
			prop.load(fis);
		}

		catch (Exception e) {

			System.out.println("failed to find properties file");

		}

	}

	@Test(enabled = true)
	public static void VerifyHomePage() {
		// driver.get("http://automationpractice.com/index.php");
		// driver.manage().window().maximize();
		String pageTitle = driver.getTitle();
		System.out.println(prop.getProperty("homepage"));

	}

	@Test(description = "checkhomepage", priority = 1, enabled = false)
	public static void jsAction() throws InterruptedException {

		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();

		String title = driver.getTitle();

		Assert.assertEquals("My Store", title);

		// JavascriptExecutor js = (JavascriptExecutor) driver;

		// js.executeScript("document.getElementById('search_query_top').setAttribute('value','teabox')");
		// js.executeAsyncScript("document.getElementById('search_query_top').setAttribute('value','teabox')");
//

		ExtentTest logger = extent.createTest("Homepage Display");
		logger.log(Status.FAIL, "verifying homepage is present");
		extent.attachReporter(reporter);

	}

	@Test(description = "check contactus butto present", priority = 2, enabled = false)
	public void cart() {

		object = new AutomatonPractise(driver);
		WebElement contactfield = object.contactUs();

		ExtentTest logger = extent.createTest("check button is present");
		if (contactfield.isDisplayed()) {

			logger.log(Status.FAIL, "button is present");

		}

		extent.attachReporter(reporter);

	}

	@AfterMethod
	public void extentInstace() {

		extent.flush();

	}

}
