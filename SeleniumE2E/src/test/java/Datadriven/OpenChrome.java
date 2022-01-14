package Datadriven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OpenChrome {

	public static WebDriver driver;

	@Parameters("browser")
	@Test
	public static void lauchTest(String browser) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sagar\\chromedriver.exe");
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			driver.get("https://www.google.com/");

		} else {

			return;
		}

	}

}
