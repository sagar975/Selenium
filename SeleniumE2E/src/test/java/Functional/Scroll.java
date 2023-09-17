package Functional;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scroll extends Base2 {

	public static JavascriptExecutor js;

	public static WebDriverWait wait;

	public static void scrollDown(WebElement element) {

		js = (JavascriptExecutor) driver;
		// wait = new WebDriverWait(driver, 20);
		// wait.until(ExpectedConditions.visibilityOf(element));
		js.executeScript("arguments[0].scrollIntoView();", element);

	}

}
