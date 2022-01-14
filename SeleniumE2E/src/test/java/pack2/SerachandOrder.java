package pack2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SerachandOrder {

	public static WebDriver driver;

	public SerachandOrder(WebDriver driver) {

		this.driver = driver;

	}

	public WebElement searchitem() {

		WebElement searhbox = driver.findElement(By.id("search_query_top"));
		
		return searhbox;

	}

	public WebElement serachicon() {

		WebElement search = driver.findElement(By.name("submit_search"));

		return search;

	}

	
	@Test(groups= {"smoke"})
	public void smoke() {
		
		System.out.println("tesing somke3");
	}
}
