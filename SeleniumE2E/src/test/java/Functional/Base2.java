package Functional;

import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Base2 {

	public static Actions action;

	public static WebDriver driver;

	public static void openBrowser(String browser) {

		ChromeOptions option = new ChromeOptions();

		// option.addArguments("--incognito");

		option.addArguments("-disable-notifications");

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\sagar\\Seleniumdriver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();

			driver.get("https://www.goibibo.com/");
			// driver.get("https://books-pwakit.appspot.com/");

			// driver.get("https://learn-automation.com/");

			
		}

		else if (browser.equalsIgnoreCase("ie")) {

			System.setProperty("webdriver.ie.driver", "C:\\Users\\sagar\\Iedriver\\IEDriverServer.exe");

			driver = new InternetExplorerDriver();
			driver.get("http://automationpractice.com/index.php");
			driver.manage().window().maximize();

			System.out.println("i dont want to run internet explorer");

		}

		else {

			System.out.println("please pass parameter browser name from testng.xml file");
		}

	}

	/*
	 * @Test(enabled = false) public static void clickOnImage() {
	 * 
	 * WebElement image =
	 * driver.findElement(By.xpath("//*[@id='homeslider']/li[4]/a/img"));
	 * 
	 * WebElement forward_button = driver.findElement(By.className("bx-next"));
	 * 
	 * int counter = 0;
	 * 
	 * while (!image.isDisplayed()) {
	 * 
	 * counter++;
	 * 
	 * forward_button.click(); }
	 * 
	 * if (image.isDisplayed() && image.isEnabled()) {
	 * 
	 * System.out.println("image is displayed");
	 * 
	 * JavascriptExecutor js = (JavascriptExecutor) driver;
	 * 
	 * js.executeScript("arguments[0].click()", image);
	 * 
	 * }
	 * 
	 * }
	 * 
	 * 
	 */

	public static void tearDown() {

		driver.quit();

	}

}
