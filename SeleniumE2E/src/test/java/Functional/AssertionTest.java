package Functional;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Singlton.Singeltonclass;

public class AssertionTest {

	public WebDriver driver;

	@Test(priority = 1)
	public void getTitle() {

		driver = new Singeltonclass().getChrome();

		driver.manage().window().maximize();

		driver.get("http://automationpractice.com/index.php");

		String title = driver.getTitle();

		// SoftAssert as = new SoftAssert();

		// as.assertEquals(title, "hello");

		Assert.assertEquals(title, "hello");

		System.out.println("executed after soft assert fail in test");

		// as.assertAll();

	}

	@Test(priority = 2)
	public void click() {

		System.out.println("in test click method");

	}

}
