package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactPage;

	public HomePageTest() {
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
		contactPage=new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1,enabled=false)
	public void verifyHomePageTitleTest() {
		String title = homePage.verifyHompageTitle();
		Assert.assertEquals(title, "CRMPRO", "Homepage title not matched");
		// If Test case failed this message will be printed
	}

	@Test(priority = 2)
	public void verifyUserNameTest() {
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyUserName());
		
	}
	@Test(priority = 3)
	public void verifyContactsLinkTest() {
		testUtil.switchToFrame();
		contactPage=homePage.clickOnContactsLink();
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
