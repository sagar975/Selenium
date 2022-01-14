package Singlton;

import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Singeltonclass {

	private static WebDriver driver = null;
	private static ChromeDriver driver2 = null;

	public static WebDriver getDriver(String browsername) {

		// Lazy singelton patten in java

		try {

			if (driver == null && browsername.equalsIgnoreCase("chrome")) {

				System.setProperty("webdriver.chrome.driver", "C:\\Users\\sagar\\Seleniumdriver\\chromedriver.exe");

				driver = new ChromeDriver();

				driver.manage().window().maximize();

			}

			else if (driver == null && browsername.equalsIgnoreCase("ie")) {

				System.setProperty("webdriver.ie.driver", "C:\\Users\\sagar\\Iedriver\\IEDriverServer.exe");

				driver = new InternetExplorerDriver();
				driver.get("http://automationpractice.com/index.php");
				driver.manage().window().maximize();

			}
		}

		catch (SessionNotCreatedException exe) {

			System.out.println("session not created");

		}

		return driver;

	}

	public static WebDriver getChromeDriver(String browsername) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sagar\\Seleniumdriver\\chromedriver.exe");

		return new ChromeDriver();

	}

	// test with non static instance of browser

	public WebDriver getChrome() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sagar\\Seleniumdriver\\chromedriver.exe");

		return new ChromeDriver();

	}

	// get ChromeDriver class instance not Webdriver

	public static ChromeDriver getChromeInstance() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sagar\\Seleniumdriver\\chromedriver.exe");

		return new ChromeDriver();

	}

}
