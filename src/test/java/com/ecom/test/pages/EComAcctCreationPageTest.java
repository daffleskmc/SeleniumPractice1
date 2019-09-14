package com.ecom.test.pages;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ecom.base.EComBasePage;
import com.ecom.pages.EComAccountPage;
import com.ecom.pages.EComAcctCreationPage;
import com.ecom.pages.EComLoginPage;
import com.ecom.pages.EComMainPage;
import com.ecom.util.EComTestUtil;

public class EComAcctCreationPageTest extends EComBasePage {

	EComMainPage main;

	EComLoginPage login;

	EComAccountPage account;

	EComAcctCreationPage newAcct;

	String sheetNamePersonal = "personal";

	public EComAcctCreationPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initilization();
		main = new EComMainPage();
		login = main.clickSignInBtn();
		newAcct = login.createAccount("daffles6@gmail.com");
	}

	@DataProvider
	public Object[][] getPersonalInfoTestData() {
		Object data[][] = EComTestUtil.getTestData(sheetNamePersonal);
		return data;
	}

	// @DataProvider
	// public Object[][] getAddressDetailsTestData() {
	// Object data[][] = ECommerceTestUtil.getTestData(sheetName);
	// return data;
	// }

	@Test(priority = 1, dataProvider = "getPersonalInfoTestData")
	public void inputPersonalInfoTest(String ttl, String fName, String lName, String pwd, String dDay, String dMonth,
			String dYear, String newsLttr) {

		newAcct.inputPersonalInfo(ttl, fName, lName, pwd, dDay, dMonth, dYear, newsLttr);

	}
	//
	// public void inputAddressDetailsTest() {
	// newAcct.inputAddressDetails("Daphne", "Cruz", "Mkt", "Mkt", "Iowa", "12303",
	// "United States", "0919",
	// "Rodriguez");
	// }

	// @Test(priority = 2)
	// public void inputAddressDetailsTest() {
	//
	// }

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
