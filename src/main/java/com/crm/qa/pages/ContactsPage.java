package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	//Initializing the Page Objects:
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//td[contains(text(),'Status')]")
	WebElement contactLabel;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@value='Load From Company']//following-sibling::input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	public boolean verifyContactLabel() {
		return contactLabel.isDisplayed();
		
	}	
	
	public void selectContacts(String name) {
	//driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']"
	//		+ "//input[@name='contact_id']")).click();	
	
		//OR
		
	driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td//preceding-sibling::td"
			+ "//input[@name='contact_id']")).click();	
	
	driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td//following-sibling::td//..//following-sibling::td"
			+ "//i[@class='fa fa-edit']")).click();	
	//a[text()='Alexender Alexender']//parent::td//following-sibling::td//..//following-sibling::td//i[@class='fa fa-edit']
	
	//following-sibling
	//following-sibling::td//following-sibling::td//following-sibling::td//following-sibling::td//following-sibling::td//i[@class='fa fa-edit']
	}
	
	public void newContact(String title,String ft,String lt,String comp) {
		Select sel=new Select(driver.findElement(By.name("title")));
		sel.selectByVisibleText(title);
		
		firstName.sendKeys(ft);
		lastName.sendKeys(lt);
		company.sendKeys(comp);		
		saveBtn.click();
	}
}
