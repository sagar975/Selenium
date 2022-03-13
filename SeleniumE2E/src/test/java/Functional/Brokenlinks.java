package Functional;

import org.openqa.selenium.By;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Singlton.Singeltonclass;

import java.util.*;

public class Brokenlinks extends Base2 {
	WebElement ele;

	public static WebDriver driver;

	public static int urlcounter = 0;

	@Test(enabled = true)
	public void checkBrokenLinks() throws IOException {

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

	public static void openNaukriPage() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sagar\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.naukri.com/mnjuser/homepage");
		driver.manage().window().maximize();
		System.out.println("Naukri page running with thread id is " + Thread.currentThread().getId());
		System.out.println("name of naukri thread is " + Thread.currentThread().getName());

	}

	public static int findBrokenLinks(String url) throws IOException {

		URL ob = new URL(url);

		HttpURLConnection con = (HttpURLConnection) ob.openConnection();
		con.setConnectTimeout(3000);
		con.connect();

		return con.getResponseCode();

	}

}
