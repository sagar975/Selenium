package PageObj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PhpTravelsHome {

	public static WebDriver driver;

	public PhpTravelsHome(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(className = "imagelogo")
	private WebElement logo;

	@FindBy(id = "checkin")
	private WebElement checkin;

	@FindBy(id = "checkout")
	private WebElement checkout;

	public WebElement getPageLogo() {

		return logo;

	}

	public WebElement getCheckInField() {

		return checkin;
	}

	public WebElement getCheckOutField() {

		return checkout;
	}
	
	
	
	
	
	
	
	
	
	
	

}
