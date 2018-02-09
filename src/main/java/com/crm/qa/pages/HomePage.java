package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//td[contains(text(),'User: Naveen K')]")
	WebElement userNamelabel;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;

	public String verifyHompageTitle() {
		return driver.getTitle();
	}

	public boolean verifyUserName() {
		return userNamelabel.isDisplayed();
	}

	public ContactsPage clickOnContactsLink() {
		contactLink.click();
		return new ContactsPage();
	}

	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}

	public TaskPage clickOnTasksLink() {
		tasksLink.click();
		return new TaskPage();
	}

	public void clickOnNewContact() {
		Actions act=new Actions(driver);
		act.moveToElement(contactLink).build().perform();
		newContactLink.click();
		
	}

}
