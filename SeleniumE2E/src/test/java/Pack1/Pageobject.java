package Pack1;

import java.io.File;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Pageobject {

	public static WebDriver driver;

	public Pageobject(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='email']")
	private WebElement username;

	public WebElement getUsername() {

		return username;
	}

	@FindBy(xpath = "//a[@class = 'login']")
	private WebElement signbutton;

	public WebElement getSigbbutton() {

		return signbutton;
	}

	@FindBy(xpath = "//*[@id='passwd']")
	private WebElement password;

	public WebElement getPassword() {

		return password;
	}

	public WebElement getSerachbox() {

		WebElement searchbox = driver.findElement(By.id("search_query_top"));

		return searchbox;

	}

	public WebElement clickbutton() {

		WebElement clickbutton = driver.findElement(By.id("SubmitLogin"));

		return clickbutton;

	}

}
