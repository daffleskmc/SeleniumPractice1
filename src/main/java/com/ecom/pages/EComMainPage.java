package com.ecom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.base.EComBasePage;

public class EComMainPage extends EComBasePage {

	@FindBy(xpath = "//a[@class='login']")
	@CacheLookup
	WebElement signInBtn;

	public EComMainPage() {
		PageFactory.initElements(driver, this);
	}

	public EComLoginPage clickSignInBtn() {
		signInBtn.click();
		return new EComLoginPage();
	}

}
