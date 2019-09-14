package com.ecom.test.pages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ecom.base.EComBasePage;
import com.ecom.pages.EComAccountPage;
import com.ecom.pages.EComAcctCreationPage;
import com.ecom.pages.EComLoginPage;
import com.ecom.pages.EComMainPage;

public class EComLoginPageTest extends EComBasePage {

	EComLoginPage ecomLogin;

	EComMainPage ecomMain;

	EComAcctCreationPage ecomNewAcct;

	EComAccountPage account;

	public EComLoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initilization();
		ecomMain = new EComMainPage();
		ecomLogin = ecomMain.clickSignInBtn();
		ecomNewAcct = new EComAcctCreationPage();
	}

	@Test(priority = 1)
	public void invalidLogin() {
		account = ecomLogin.login(prop.getProperty("username"), prop.getProperty("password"));

		String actual = "Authentication failed.";
		String expected = ecomLogin.getAuthError();
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 2)
	public void createAcctFailed() {

		String emailAddr = "daffles3@gmail";
		ecomNewAcct = ecomLogin.createAccount(emailAddr);
		String actual = "Invalid email address.";
		String expected = ecomLogin.getInvalidEmailError();
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 3)
	public void createAccountSuccess() {
		String emailAddr = "daffles3@gmail.com";
		ecomNewAcct = ecomLogin.createAccount(emailAddr);
	}

	@AfterMethod
	public void tearDown() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}
}
