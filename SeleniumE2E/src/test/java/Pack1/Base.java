package Pack1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pack2.Maplogin;
import pack2.SerachandOrder;

class Base {

	public static WebDriver driver;

	public static String text;

	@BeforeTest(enabled = false)
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		driver = new ChromeDriver();

		try {

			FileInputStream file = new FileInputStream("C:\\Users\\sagar\\eclipse-workspace\\SeleniumE2E\\Properties");
			Properties pro = new Properties();
			pro.load(file);
			String browsername = pro.getProperty("browser");
			if (browsername.equals("chrome")) {

				long beforeget_statement = System.currentTimeMillis();

				driver.get(" http://automationpractice.com/index.php");

				String title = driver.getTitle();

				String source = driver.getPageSource();

				System.out.println("this should not print");

				WebElement box = driver.findElement(By.id("bmwcheck"));

				driver.navigate().refresh();

				WebDriverWait wait = new WebDriverWait(driver, 10);
				driver.navigate().refresh();

				wait.until(ExpectedConditions.presenceOfElementLocated(By.id("bmwcheck")));

				box.click();

				/*
				 * 
				 * WebDriverWait wait = new WebDriverWait(driver, 10);
				 * 
				 * try { WebElement box =
				 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id")));
				 * box.click();
				 * 
				 * }
				 * 
				 * catch (Exception e) {
				 * 
				 * e.printStackTrace(); }
				 * 
				 */

				long after_getstatement = System.currentTimeMillis();

				long browsertime = after_getstatement - beforeget_statement;

				driver.manage().window().maximize();

				System.out.println("time require for opening browser is in sec" + browsertime);

				Dimension a = driver.manage().window().getSize();

				System.out.println("size of page  in length * height is " + a);

			}

			else {

				System.out.println("check browsername in properties file");
			}

		}

		catch (Throwable e) {

			e.printStackTrace();
		}

	}

	@DataProvider
	public Object[][] getdata() {

		Object[][] arr;

		arr = new String[0][0];

		arr[0][0] = "sagarsonawane1991@gmail.com";
		arr[0][0] = "Kms60$";

		return arr;

	}

	@Parameters({ "username", "password" })
	public void multiplelogin(String username, String password) throws InterruptedException {

		Pageobject obj2 = new Pageobject(driver);

		obj2.getUsername().sendKeys(username);
		obj2.getPassword().sendKeys(password);

	}

	public void search() {

		String[] items = { "Printed Chiffon Dress", " blouse", "  Printed Dress" };

		List list1 = Arrays.asList(items);
		SerachandOrder obj = new SerachandOrder(driver);
		obj.searchitem().sendKeys("teeshirt");
		WebDriverWait wait = new WebDriverWait(driver, 10);

		obj.serachicon().click();

		List<WebElement> list = driver.findElements(By.cssSelector("a.product-name"));

		for (int i = 0; i <= list.size(); i++) {

			String prodname = list.get(i).getText();

			if (list1.contains(prodname)) {

				driver.findElements(By.cssSelector("a.product-name")).get(i).click();

				driver.navigate().back();

			}

		}

	}

	public void loginwithmap() {

		WebDriverWait wait = new WebDriverWait(driver, 5);

		// wait.until(ExpectedConditions.visibilityOfElementLocated(driver.getTitle()));

		HashMap<String, String> mp = new HashMap<String, String>();

		mp.put("user1", "sagarsonawane1991@gmail.com,Kms60$");
		mp.put("user2", "abc@gmail.com,1234");

		mp.put("user3", "pqr@gmail.com,5678");

		String username = mp.get("user1");

		String arr[] = username.split(",");

		Pageobject obj = new Pageobject(driver);

		Cart obj2 = new Cart(driver);
		obj.getUsername().sendKeys(arr[0]);
		obj.getPassword().sendKeys(arr[1]);
		obj.clickbutton().click();
		WebElement cartbutton = obj2.getcart();

		cartbutton.click();

		SerachandOrder obj3 = new SerachandOrder(driver);
		obj3.searchitem().sendKeys("tshirt");
		obj3.serachicon().click();

	}

	public void gettshirt() {

		List<String> list = new ArrayList<String>();

		List<WebElement> elelist = driver.findElements(By.className("product-name"));

		for (int i = 0; i < elelist.size(); i++) {

			list.add(elelist.get(i).getText());

		}

		Collections.sort(list);

		for (String str : list) {

			System.out.println(str);

		}

	}

	@AfterTest
	public void teardown() {
		System.out.println("driver is closed");
		driver.close();

	}

	public void somke2() {

		System.out.println("smoke2");
	}

	@Test(priority = 1)
	public void doo() {
		Assert.assertTrue(false);
	}

}
