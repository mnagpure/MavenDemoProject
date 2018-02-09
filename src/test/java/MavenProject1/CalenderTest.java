package MavenProject1;

//import java.util.NoSuchElementException;
import org.openqa.selenium.*;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
//import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class CalenderTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactPage;

	public CalenderTest() {
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
		// System.out.println("00000000000");
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		// System.out.println("aaaaaaaaaaaa");
		// contactPage = homePage.clickOnContactsLink();
	}

	@Test(priority = 1)
	public void verifyCalenderTest() {
		// System.out.println("bbbbbbbbbbbbb");
		String date = "17-March-2018";
		String dateArr[] = date.split("-");
		String day = dateArr[0];
		String month = dateArr[1];
		String year = dateArr[2];

		Select selectMonth = new Select(driver.findElement(By.name("slctMonth")));
		selectMonth.selectByVisibleText(month);

		Select selectYear = new Select(driver.findElement(By.name("slctYear")));
		selectYear.selectByVisibleText(year);

		// *[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[4]/td[7]

		String beforePath = "//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[";
		String afterPath = "]/td[";

		final int totalWeekDays = 7;

		boolean flag = false;
		String dayVal = null;

		for (int rowNum = 2; rowNum <= 7; rowNum++) {

			for (int colNum = 1; colNum <= totalWeekDays; colNum++) {
				try {
					// System.out.println("1");
					dayVal = driver.findElement(By.xpath(beforePath + rowNum + afterPath + colNum + "]")).getText();
					System.out.println(dayVal);
				} catch (NoSuchElementException e) {
					System.out.println("Please enter correct date");
					flag = false;
					break;
				}
				if (dayVal.equals(day)) {
					driver.findElement(By.xpath(beforePath + rowNum + afterPath + colNum + "]")).click();
					flag = true;
					break;
				}
			}
			if (flag) {
				break;
			}
		}

	}

	@AfterMethod
	public void tearDown() {
		// driver.quit();
		// driver.findElement(By.xpath("//input[contains(text(),'Home
		// Garden')]")).sendKeys("Bajaj");
	}

}
