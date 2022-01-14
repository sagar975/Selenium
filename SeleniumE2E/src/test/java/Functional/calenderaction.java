package Functional;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import PageObj.PhpTravelsHome;
import PageObj.GoIbibo;

public class calenderaction extends Base2 {

	public static WebDriverWait Wait;

	public static GoIbibo go;

	public static GoIbibo getGoIbiboInstance() {

		go = new GoIbibo(Base2.driver);

		return go;

	}

	@Test(priority = 0, enabled = false)
	public void calenderOperation() {

		openBrowser("chrome");

	}

	@Test(priority = 1, enabled = false)
	public void selectTravelDate() {

		go = calenderaction.getGoIbiboInstance();
		go.getCheckIn().click();
		Base2.driver.findElement(By.id("fare_20210225")).click();

	}

	@Test(priority = 2, enabled = false)
	public void selectReturnDate() {

		go = calenderaction.getGoIbiboInstance();

		go.getCheckOut().click();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement rollbutton = Base2.driver.findElement(
				By.xpath("//*[@id='searchWidgetCommon']/div[1]/div[1]/div[1]/div/div[7]/div/div/div[1]/span"));

		String month = driver
				.findElement(
						By.xpath("//*[@id='searchWidgetCommon']/div[1]/div[1]/div[1]/div/div[7]/div/div/div[2]/div[1]"))
				.getText();

		while (!month.equalsIgnoreCase("June 2021")) {

			rollbutton.click();
			month = driver
					.findElement(By.xpath(
							
							
							"//*[@id=\"searchWidgetCommon\"]/div[1]/div[1]/div[1]/div/div[7]/div/div/div[2]/div[1]"))
					.getText();

		}

		
		driver.findElement(By.id("fare_20210601")).click();

	}

}
