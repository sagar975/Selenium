package Pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Shadowpractise {

	public static WebDriver driver;

	public WebElement getRootElement(WebElement ele) {

		WebElement elem = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot",
				ele);

		return elem;

	}

	@Test
	public void getShadowElement() {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("https://www.alodokter.com/");
		driver.manage().window().maximize();
		WebElement domstart = driver.findElement(By.id("top-navbar-view"));

		System.out.println(domstart.getText());

		WebElement shadow1 = getRootElement(domstart);

		System.out.println(shadow1.getText());

		// WebElement shadow2 = shadow1.findElement(By.tagName("message-bar"));

		// WebElement shadow3 = getRootElement(shadow2);

		// WebElement shadow4 = shadow3.findElement(By.tagName("login-page-user"));

		// WebElement shadow5 =
		// shadow4.findElement(By.tagName("login-social-media-phone-number-popup"));

	}

}
