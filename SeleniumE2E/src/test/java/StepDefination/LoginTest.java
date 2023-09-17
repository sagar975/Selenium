package StepDefination;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import EnvironmentVar.Constant;
import PageObj.AutomatonPractise;
import PageObj.OpenCart;
import Singlton.Singeltonclass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTest {

	public static WebDriver driver;

	public static WebDriverWait wait;

	@Given("^navigate to applicatiom freeCrm$")
	public void launhBrowser() {

		driver = Singeltonclass.getChromeDriver("chrome");
		driver.get(Constant.openCartUrl);
		driver.manage().window().maximize();

	}

	@When("^enter valid credentials(.*) and password(.*)$")
	public void login(String uname, String pass) {
		// List<List<String>> testdata = data.cells();

		// this is kind of fluent patten in design
		// FreeCrm crm = new FreeCrm(driver);

		OpenCart page = new OpenCart(driver);
		page.getLoginLink().click();
		page.getUserName().sendKeys(uname);
		page.getPassword().sendKeys(pass);

		System.out.println(uname);
		System.out.println(pass);
		/*
		 * if (crm.getUserName().isDisplayed()) { crm.getUserName().sendKeys(uname);
		 * 
		 * }
		 * 
		 * if (crm.getUserPassword().isDisplayed()) {
		 * 
		 * crm.getUserPassword().sendKeys(pass);
		 * 
		 * }
		 * 
		 * 
		 */

	}

	@Then("^user should be on homepage of application$")
	public void VerifyTitle() {

		System.out.println(driver.getTitle());
		driver.quit();

	}

}
