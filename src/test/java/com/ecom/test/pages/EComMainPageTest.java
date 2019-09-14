package com.ecom.test.pages;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ecom.base.EComBasePage;
import com.ecom.pages.EComLoginPage;
import com.ecom.pages.EComMainPage;

public class EComMainPageTest extends EComBasePage {

	EComMainPage ecomMain;

	EComLoginPage ecomLogin;

	public EComMainPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initilization();
		ecomMain = new EComMainPage();
	}

	@Test
	public void clickSignInBtn() {
		ecomLogin = ecomMain.clickSignInBtn();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
