package StepDefination;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import EnvironmentVar.Constant;
import PageObj.AutomatonPractise;
import Singlton.Singeltonclass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTest {

	public static WebDriver driver;

	public static WebDriverWait wait;

	@Given("^navigate to application url$")
	public void launhBrowser() {

		driver = Singeltonclass.getChromeDriver("chrome");
		driver.get(Constant.url);

	}

	@When("^ $")
	public void openUrl(String uname, String pass) {

		// List<List<String>> testdata = data.cells();

		wait = new WebDriverWait(driver, 10);

		driver.manage().window().maximize(); // this is kind of fluent patten in design

		AutomatonPractise ap = new AutomatonPractise(driver);
		ap.getSignButton().click();
		ap.getEmail().sendKeys(uname);
		ap.getPassword().sendKeys(pass);

	}

	@Then("^user should be on homepage of application$")
	public void login() {

		System.out.println(driver.getTitle());

	}

}
