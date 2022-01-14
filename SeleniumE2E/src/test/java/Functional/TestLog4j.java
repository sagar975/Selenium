package Functional;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import EnvironmentVar.Constant;
import PageObj.AutomatonPractise;
import Singlton.Singeltonclass;

public class TestLog4j extends Singeltonclass {

	public static WebDriver driver;

	@Test(description = "login to app")
	public void doLogin() {

		Logger log = LogManager.getLogger(TestLog4j.class);

		log.info("getting chromderdiver instance");

		driver = Singeltonclass.getDriver(Constant.browsername);
		AutomatonPractise obj = new AutomatonPractise(driver);
		driver.get(Constant.url);

		log.info("url is launched");

		obj.getSignButton().click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('email').setAttribute('value','sagarsonawane1991@gmail.com')");
		obj.getPassword().sendKeys(Constant.password);

		log.info("username and password is submitted");

		obj.getSubmit().click();

	}
	
}
