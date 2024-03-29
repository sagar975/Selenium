package com.automationpractise.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "a.login")
	private WebElement signbutton;

	@FindBy(id = "email")
	private WebElement email;

	@FindBy(id = "passwd")
	private WebElement password;

	@FindBy(id = "SubmitLogin")
	private WebElement submit;

	@FindBy(xpath = "//a[@title='View my shopping cart']")
	private WebElement cart;

	@FindBy(css = "a[title = 'Contact Us']")
	private WebElement ContactUs;

	@FindBy(xpath = "//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	private WebElement SignButton;

	public WebElement getEmail() {

		return signbutton;

	}

	public WebElement getPassword() {

		return password;

	}

	public WebElement getSubmit() {

		return submit;
	}

	public WebElement getCart() {

		return cart;

	}

	public WebElement contactUs() {

		return ContactUs;
	}

	public WebElement getSignButton() {

		return SignButton;

	}

}
