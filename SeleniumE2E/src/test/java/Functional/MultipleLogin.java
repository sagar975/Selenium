package Functional;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObj.AutomatonPractise;
import Singlton.Singeltonclass;

public class MultipleLogin {

	// Login to application with multiple credentials.

	public static WebDriver driver;

	public static WebDriverWait wait;

	@Test(dataProvider = "logindata")
	public void login(String username, String pass) {

		driver = new Singeltonclass().getChrome();

		driver.manage().window().maximize();

		driver.get("http://automationpractice.com/index.php");

		//wait = new WebDriverWait(driver, 25);

		AutomatonPractise ob = new AutomatonPractise(driver);

		ob.getEmail().sendKeys(username);
		ob.getEmail().sendKeys(pass);

		System.out.println("completed with thread " + Thread.currentThread().getId());

	}

	@DataProvider(name = "logindata")
	public static Object[][] getData() {

		Object[][] arr = new Object[3][2];

		arr[0][0] = "sagar19@gmail.com";
		arr[0][1] = "12345";
		arr[1][0] = "kms@yahoo.com";
		arr[1][1] = "457";
		arr[2][0] = "vks@yahoo.com";
		arr[2][1] = "12897";

		return arr;

	}

}
