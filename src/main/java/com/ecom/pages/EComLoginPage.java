package com.ecom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.base.EComBasePage;

public class EComLoginPage extends EComBasePage {

	@FindBy(xpath = "//input[@id='email']")
	@CacheLookup
	WebElement emailAddress;

	@FindBy(xpath = "//input[@id='passwd']")
	@CacheLookup
	WebElement password;

	@FindBy(xpath = "//button[@id='SubmitLogin']")
	@CacheLookup
	WebElement signInBtn;

	@FindBy(xpath = "//li[text()='Authentication failed.']")
	@CacheLookup
	WebElement authError;

	@FindBy(xpath = "//input[@id='email_create']")
	@CacheLookup
	WebElement emailAddressNew;

	@FindBy(xpath = "//button[@id='SubmitCreate']")
	@CacheLookup
	WebElement createAcctBtn;

	@FindBy(xpath = "//li[text()='Invalid email address.']")
	@CacheLookup
	WebElement invalidEmail;

	public EComLoginPage() {
		PageFactory.initElements(driver, this);
	}

	public EComAccountPage login(String email, String pwd) {
		emailAddress.sendKeys(email);
		password.sendKeys(pwd);
		signInBtn.click();

		return new EComAccountPage();
	}

	public String getAuthError() {
		return authError.getText();
	}

	public EComAcctCreationPage createAccount(String emailAddr) {
		emailAddressNew.sendKeys(emailAddr);
		createAcctBtn.click();
		return new EComAcctCreationPage();
	}

	public String getInvalidEmailError() {
		return invalidEmail.getText();
	}
}
