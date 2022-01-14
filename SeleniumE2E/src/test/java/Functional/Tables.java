package Functional;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Tables extends Base2 {

	public static JavascriptExecutor js;
	public static Actions a;

	@Test(priority = 0, invocationCount = 2)
	public void htmlTables() {

		Base2.openBrowser("chrome");

		driver.get("https://www.javatpoint.com/html-table");

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		WebElement table = driver.findElement(By.xpath("//*[@id='city']/table/tbody/tr/td/table[4]"));

		Scroll.scrollDown(table);

	}

	public void printColumnName() {
		js = (JavascriptExecutor) driver;

		WebElement column1 = driver
				.findElement(By.xpath("//*[@id='city']/table/tbody/tr/td/table[4]/tbody/tr[1]/th[1]"));

		WebElement column2 = driver
				.findElement(By.xpath("//*[@id='city']/table/tbody/tr/td/table[4]/tbody/tr[1]/th[2]"));

		WebElement column3 = driver
				.findElement(By.xpath("//*[@id='city']/table/tbody/tr/td/table[4]/tbody/tr[1]/th[3]"));

		String name1 = (String) js.executeScript("return arguments[0].innerHTML", column1);
		String name2 = (String) js.executeScript("return arguments[0].innerHTML", column2);
		String name3 = (String) js.executeScript("return arguments[0].innerHTML", column3);

		System.out.println("column name is" + name1);
		System.out.println("column name is" + name1);
		System.out.println("column name is" + name3);

	}

	@Test(invocationCount = 2)
	public void printTableData() {

		String path = "//*[@id='city']/table/tbody/tr/td/table[4]/tbody/tr[2]/td[";
		String fullpath = "]";

		for (int i = 1; i <= 3; i++) {

			WebElement name = driver.findElement(By.xpath(path + i + fullpath));

			System.out.println(name.getText());

		}

	}

	public void PrintColumnName() {

		js = (JavascriptExecutor) driver;

		a = new Actions(driver);

		WebElement columnname = driver
				.findElement(By.xpath("//*[@id='city']/table/tbody/tr/td/table[3]/tbody/tr[1]/th[1]"));

		String coulname = a.moveToElement(columnname).toString();

	}

	@AfterTest
	public void quit() {

		driver.quit();

	}

}
