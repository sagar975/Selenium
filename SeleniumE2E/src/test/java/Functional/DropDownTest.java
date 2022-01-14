package Functional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DropDownTest extends Base2 {

	public static WebDriverWait wait;
	public static WebElement bottom;

	@Test(priority = 1)
	public void openApplication() {

		Base2.openBrowser("chrome");
		driver.get("https://learn-automation.com/");
		driver.manage().window().maximize();
		WebElement side_title = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/h1/a"));

		if (side_title.isDisplayed()) {

			String actual = side_title.getText();

			String expected_title = "Automation";

			Assert.assertEquals(actual, expected_title);

			System.out.println("Assertion is passed");

		}

	}

	@Test(enabled = false)
	public void handlePopup() {

		// WebElement close_button =
		// driver.findElement(By.id("sendx-close-dNnOns5gBj56SFGkOimE4p"));

		WebElement close_button2 = driver.findElement(By.className("sendx-modal-close-dNnOns5gBj56SFGkOimE4p"));

		wait = new WebDriverWait(driver, 15);

		wait.until(ExpectedConditions.visibilityOf(close_button2));

		if (close_button2.isDisplayed()) {

			close_button2.click();

			System.out.println("popup had present on page");

		}

	}

	@Test(enabled = false)
	public void scrollDown() {

		WebElement close_button2 = driver.findElement(By.className("sendx-modal-close-dNnOns5gBj56SFGkOimE4p"));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		wait = new WebDriverWait(driver, 30);

		wait.until(ExpectedConditions.visibilityOf(close_button2));

		if (close_button2.isDisplayed()) {
			js.executeScript("arguments[0].click()", close_button2);
			bottom = driver.findElement(By.id("cat"));

			js.executeScript("arguments[0].scrollIntoView();", bottom);

		}

	}

	public void closeBrowser() {

		Base2.tearDown();

	}

	@Test(enabled = false)
	public void dropDownTest() {

		Select s = new Select(bottom);

		List<String> actual = new ArrayList<String>();
		List<String> expected = new ArrayList<String>();

		List<WebElement> temp = s.getOptions();

		for (WebElement el : temp) {

			actual.add(el.getText());
			expected.add(el.getText());

		}

		// Collections.sort(expected);

		Assert.assertEquals(actual, expected);

		System.out.println("actual expected is match");

	}

}
