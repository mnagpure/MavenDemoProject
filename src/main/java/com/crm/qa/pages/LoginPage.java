package com.crm.qa.pages;

//import java.sql.Driver;

//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
//import com.crm.qa.util.TestUtil;

public class LoginPage extends TestBase {
	

	// Page Factory- OR= Object Repository
	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	// @FindBy(css="input.btn btn-small")
	WebElement loginButton;

	@FindBy(xpath = "//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;

	// @FindBy(xpath="img[contains(@class,'img-responsive')]")
	@FindBy(css = "img.img-responsive")
	WebElement crmLogo;

	//
	// How to initialize PageFactory(PageObjects): Constructor to Intialize
	// above Web Elements,
	// 'this' is current class objects
	public LoginPage() {
		PageFactory.initElements(driver, this);

	}

	// Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateCrmImage() {
		return crmLogo.isDisplayed();
	}

	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		javascriptButtonClick(loginButton);
		//driver.findElement(By.xpath("//input[@type='submit']")).click();

		return new HomePage();
	}

	public void signUp() {
		javascriptButtonClick(signUpBtn);
	}

	

}
