package com.ecom.test.pages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ecom.base.EComBasePage;
import com.ecom.pages.EComAccountPage;
import com.ecom.pages.EComLoginPage;
import com.ecom.pages.EComMainPage;

public class EComAccountPageTest extends EComBasePage {

	EComLoginPage login;

	EComAccountPage account;

	EComMainPage main;

	public EComAccountPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initilization();
		main = new EComMainPage();
		login = main.clickSignInBtn();
		account = login.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	// @Test
	// public void isMyAcctLblDisplayedTest() {
	// Assert.assertTrue(account.isMyAcctLblDisplayed());
	// }

	@Test
	public void shopTshirtsTest() {
		account.shopTshirts();
		Assert.assertTrue(account.isTshirtsCategoryDisplayed());
	}

	@AfterMethod
	public void tearDown() {
		// driver.quit();
	}
}
