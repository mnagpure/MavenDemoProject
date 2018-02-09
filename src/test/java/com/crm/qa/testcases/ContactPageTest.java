package com.crm.qa.testcases;

//import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactPage;

	String sheetName = "Contacts";

	public ContactPageTest() {
		super();
	}

	// test cases should be independent from each other
	// before each test case launch browser and login
	// @test-- execute test case
	// After each test case quit the browser
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		contactPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactPage = homePage.clickOnContactsLink();
	}

	@Test(priority = 1, enabled = false)
	public void verifyContactPageLabelTest() {
		// testUtil.switchToFrame(); //write common code in setUp() Method
		// contactPage=homePage.clickOnContactsLink();
		Assert.assertTrue(contactPage.verifyContactLabel(), "Contacts label is missing");
		// System.out.println("ABC");
		// driver.findElement(By.xpath("//input[@name='cs_name']")).sendKeys("Man");
		// System.out.println("xyz");
	}

	@Test(priority = 2, enabled = true)
	public void SelectContactTest() {
		// testUtil.switchToFrame(); //write common code in setUp() Method
		// contactPage=homePage.clickOnContactsLink();
		contactPage.selectContacts("Alexender Alexender");
	}

	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestdata(sheetName);
		return data;
		
	}

	@Test(priority = 3, dataProvider = "getCRMTestData",enabled=false)
	public void validateNewContactTest(String title, String firstname, String lastname, String company) {
		homePage.clickOnNewContact();
		contactPage.newContact(title, firstname, lastname, company);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		// driver.findElement(By.xpath("//input[contains(text(),'Home
		// Garden')]")).sendKeys("Bajaj");
	}

}
