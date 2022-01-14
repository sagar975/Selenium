package Pack1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart {

	public static WebDriver driver;

	public Cart(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//*[@id='header']/div[3]/div/div/div[3]/div/a")
	WebElement cart;

	public WebElement getcart() {

		return cart;

	}

}
