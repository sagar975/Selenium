package Functional;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Singlton.Singeltonclass;
import Singlton.ThreadLocalDriver;

public class MultiThreadPacrise {

	public static WebDriver driver = null;

	@Test(priority = 1)
	public void automationPractisePage() {

		// driver = Singeltonclass.getDriver("chrome");
		// driver = Singeltonclass.getChromeDriver("chrome");

		driver.get("http://automationpractice.com/index.php");
		System.out.println("thread id is " + Thread.currentThread().getId());
		System.out.println("success");

	}

	@Test(priority = 2)
	public void googlePage() {

		// driver = Singeltonclass.getDriver("chrome");
		// driver = Singeltonclass.getChromeDriver("chrome");
		driver.get("https://www.goibibo.com/");
		System.out.println("thread id is " + Thread.currentThread().getId());
		System.out.println("success");

	}

	@Test(priority = 3)
	public void learnAutoPage() {
		// driver = Singeltonclass.getDriver("chrome");
		// driver = Singeltonclass.getChromeDriver("chrome");

		driver.get("https://learn-automation.com/");

		System.out.println("thread id is " + Thread.currentThread().getId());
		System.out.println("success");

	}

	@BeforeClass
	public void callDriver() {
		// ThreadLocalDriver.setDriver(driver);
		// driver = ThreadLocalDriver.getLocalDriver();

		driver = new Singeltonclass().getChrome();

	}

	public void tearDown() {
		driver.quit();

	}

}
