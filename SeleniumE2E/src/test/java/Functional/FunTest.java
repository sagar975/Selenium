package Functional;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import Singlton.Singeltonclass;

public class FunTest {

	public static WebDriver driver;

	@Test(priority = 0)
	public void testLinks() {

		// Login and checktitle

		driver = Singeltonclass.getChromeDriver("chrome");

		driver.get("https://www.goibibo.com/");

		driver.manage().window().maximize();

		System.out.println(driver.getTitle());
	}

	@Test(priority = 1)
	public void tearDown() {

		driver.close();

	}

	public static int urlcounter = 0;

	@Test(enabled = false)
	public void checkBrokenLinks() throws IOException {

		// find broken links in appilication

		int urlcounter = 0;

		driver = Singeltonclass.getDriver("chrome");

		driver.get("https://www.trivago.in/");

		int total_links = driver.findElements(By.tagName("a")).size();

		System.out.println("total number of links on page are " + " " + total_links);

		List<WebElement> elementlist = driver.findElements(By.tagName("a"));

		for (int i = 0; i <= elementlist.size(); i++) {

			String link = elementlist.get(i).getAttribute("href");

			URL ob = new URL(link);

			HttpURLConnection con = (HttpURLConnection) ob.openConnection();
			con.setConnectTimeout(3000);
			con.connect();

			int httpresponse = con.getResponseCode();

			if (httpresponse >= 400) {

				urlcounter++;

			}

			con.disconnect();

		}

		System.out.println("total failed links are " + "  " + urlcounter);

		/*
		 * ArrayList<WebElement> links = (ArrayList<WebElement>)
		 * driver.findElements(By.tagName("a"));
		 * 
		 * for (int i = 0; i < links.size(); i++) {
		 * 
		 * String urlname = links.get(i).getAttribute("href");
		 * 
		 * findBrokenLinks(urlname);
		 * 
		 * }
		 */
		// System.out.println("brokenlinks running with Thread id is : " +
		// Thread.currentThread().getId());
		// System.out.println("name of broken links thread is " +
		// Thread.currentThread().getName());

	}

}
