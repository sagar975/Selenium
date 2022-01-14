package Functional;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class DesiredCaps extends Base2 {

	@Test(priority = 2)
	public static void incognitoLaunch() {

		ChromeOptions option = new ChromeOptions();

		option.addArguments("--incognito");

		Base2.openBrowser("chrome");

	}

	@Test(priority = 1)
	public void handleSSL() {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setAcceptInsecureCerts(true);
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sagar\\chromedriver.exe");
		driver = new ChromeDriver(cap);
		driver.get("https://sarathi.nic.in:8443/nrportal");

	}

	@Test(priority = 0)
	public void headLess() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sagar\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.setHeadless(true);
		driver = new ChromeDriver(option);
		driver.get("https://www.google.com/");

		String title = driver.getTitle();

		System.out.println("title of home page is " + title);

	}

}