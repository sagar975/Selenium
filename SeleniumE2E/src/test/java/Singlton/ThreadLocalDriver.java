package Singlton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ThreadLocalDriver {

	private static ThreadLocal<WebDriver> local = new ThreadLocal<WebDriver>();

	public static void setDriver(WebDriver driver) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sagar\\Seleniumdriver\\chromedriver.exe");

		local.set(new ChromeDriver());
	}

	public static WebDriver getLocalDriver() {

		return local.get();

	}

}
