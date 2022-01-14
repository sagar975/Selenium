package Functional;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Singlton.Singeltonclass;

public class Geolocation {

	public static WebDriver driver;
	public static ChromeDriver driver2;

	@Test
	public static void testLocation() throws InterruptedException {

		// test geographical location based on latitude and longitude

		driver2 = Singeltonclass.getChromeInstance();

		driver2.manage().window().maximize();

		DevTools obj = driver2.getDevTools();

		obj.createSession();

		Map<String, Object> coordinates = new HashMap<String, Object>();

		coordinates.put("latitude", 35);
		coordinates.put("longitude", 104);
		coordinates.put("accuracy", 1);

		driver2.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);

		// driver2.get("https://www.google.co.in/");
		// Thread.sleep(4000);
		// driver2.findElement(By.name("q")).sendKeys("netflix", Keys.ENTER);

		driver2.get("https://www.trivago.in/");

	}

	@Test(description = "total links on the page")
	public void getTitleOfWindow() {

		// get total number of links on page

		int total_links = driver2.findElements(By.tagName("a")).size();

		Assert.assertEquals(100, total_links);

	}

	@Test(description = "title of page")
	public void totalFramOnpage() {

		String title = driver2.getTitle();

		Assert.assertEquals(title, "hello me");

	}

	@AfterTest
	public void tearDown() {

		driver2.close();

	}

}
