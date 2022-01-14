package Functional;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ShadowEle {

	public static WebDriver driver;

	@Test(enabled = false)
	public void handleShadowEle() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sagar\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("https://books-pwakit.appspot.com/");

		driver.manage().window().maximize();

		WebElement host = driver.findElement(By.tagName("book-app"));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement bookapp = (WebElement) js.executeScript("return arguments[0].shadowRoot", host);

		WebElement appheader = bookapp.findElement(By.tagName("app-header"));

		WebElement apptoolbar = appheader.findElement(By.tagName("app-toolbar"));

		WebElement link = apptoolbar.findElement(By.tagName("a"));

	}

	@Test
	public void multipleShadow() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sagar\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("https://shop.polymer-project.org/");

		driver.manage().window().maximize();

		WebElement host = driver.findElement(By.tagName("shop-app"));

		WebElement firstshadow = getShadow(driver, host);
		WebElement appheader = firstshadow.findElement(By.tagName("app-header"));
		WebElement container = appheader.findElement(By.id("tabContainer"));
		WebElement shop = container.findElement(By.cssSelector("shop-tabs > shop-tab:nth-child(1)>a"));
		shop.click();

	}

	public static WebElement getShadow(WebDriver driver, WebElement ele) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement shadowele = (WebElement) js.executeScript("return arguments[0].shadowRoot", ele);

		return shadowele;

	}

}
