package Functional;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Singlton.Singeltonclass;

public class SingltnTest {

	public WebDriver driver;

	@Test
	public void test() {
		driver = Singeltonclass.getDriver("chrome");

		driver.get("https://www.google.com/");

	}

}
