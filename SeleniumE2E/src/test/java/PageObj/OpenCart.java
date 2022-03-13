package PageObj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenCart {

	private static WebDriver driver;

	@FindBy(css = "a.btn.btn-link.navbar-btn")
	private WebElement loginLink;

	@FindBy(id = "input-email")
	private WebElement userName;

	@FindBy(id = "input-password")
	private WebElement passWord;

	public OpenCart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public WebElement getLoginLink() {

		return this.loginLink;

	}

	public WebElement getUserName() {

		return this.userName;
	}

	public WebElement getPassword() {

		return this.passWord;

	}

	// https://www.opencart.com/index.php?route=common/home

}
