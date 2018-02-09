package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/*
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.collections4.FactoryUtils;
*/

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.apache.commons.io.FileUtils;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPICIT_WAIT = 30;
	public static String TESTDATA_SHEET_PATH = "E:/Manish/OneDrive/SeleniumProjects/MavenDemoProject/src/main/java/com/crm/qa/testdata/FreeCRMTestData.xlsx";

	static Workbook book;
	static Sheet sheet;

	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");

	}

	public static Object[][] getTestdata(String sheetName) {

		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		}

		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			}
		}
		System.out.println(data);
		return data;
	}

	public static void TakeSaveScreenshot(WebDriver driver) throws IOException {
		/*
		 * DateFormat dateFormat = new SimpleDateFormat("ddMMyyyyHHmmss"); Date
		 * date = new Date(); String date1 = dateFormat.format(date);
		 */
		// Take screenshot and store as a file format
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// now copy the screenshot to desired location using copyFile
		FileUtils.copyFile(src, new File(prop.getProperty("takescreenshotUrl") + System.currentTimeMillis() + ".png"));
		// FileUtils.copyFile(src, new File("C:/screenshot/Screenshot" + date1 +
		// ".png"));

	}

}
