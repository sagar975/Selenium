package PageObj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoIbibo {

	public static WebDriver driver;

	public GoIbibo(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "departureCalendar")
	private WebElement checkin;

	@FindBy(id = "returnCalendar")
	private WebElement checkout;

	@FindBy(xpath = "/*[@id='header']/div[1]/a/img")
	private WebElement logo;

	public WebElement getCheckIn() {

		return checkin;

	}

	public WebElement getCheckOut() {

		return checkout;

	}

	public WebElement getHomePageLogo() {

		return logo;
	}

}
