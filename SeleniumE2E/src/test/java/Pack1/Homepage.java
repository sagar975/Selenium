package Pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Homepage {
	public static WebDriver driver;

	public static JavascriptExecutor js;

	public Homepage(WebDriver driver) {

		this.driver = driver;

	}

	@Test
	public void sendusername() {


		js = ((JavascriptExecutor) driver);

		driver.findElement(By.id("email")).sendKeys("sagarsonawane");

		String script = "document.getElementById('email').setAttribute('value','sagarsonawane1991@gmail.com')";
		
		js.executeScript(script);

	}

	@Test
	public void sendpassword() {

		js = ((JavascriptExecutor) driver);

		String script = "document.getElementById('passwd').setAttribute('value', 'Kms60$' )";

		js.executeScript(script);

	}

	@Test
	public void Clickbutton() {

		js = ((JavascriptExecutor) driver);

		String script = "arguments[0].click()";
		WebElement button = driver.findElement(By.xpath("//*[@id='SubmitLogin']/span"));

		js.executeScript(script, button);

	}
	
	@Test(groups ={"smoke"})
	public void smoke1() {
		
		System.out.println("testing grouups");
		
	}

	
}
