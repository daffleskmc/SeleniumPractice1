package com.ecom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ecom.base.EComBasePage;

public class EComAcctCreationPage extends EComBasePage {

	@FindBy(xpath = "//label[@for='id_gender1']")
	@CacheLookup
	WebElement titleMr;

	@FindBy(xpath = "//label[@for='id_gender2']")
	@CacheLookup
	WebElement titleMrs;

	@FindBy(xpath = "//input[@id='customer_firstname']")
	@CacheLookup
	WebElement firstName;

	@FindBy(xpath = "//input[@id='customer_lastname']")
	@CacheLookup
	WebElement lastName;

	// @FindBy(xpath = "")
	// WebElement email;

	@FindBy(xpath = "//input[@id='passwd']")
	@CacheLookup
	WebElement password;

	@FindBy(xpath = "//select[@id='days']")
	@CacheLookup
	WebElement dobDay;

	@FindBy(xpath = "//select[@id='months']")
	@CacheLookup
	WebElement dobMonth;

	@FindBy(xpath = "//select[@id='years']")
	@CacheLookup
	WebElement dobYear;

	@FindBy(xpath = "//input[@id='newsletter']")
	@CacheLookup
	WebElement signUpNewsletterChkBx;

	@FindBy(xpath = "//input[@id='firstname']")
	@CacheLookup
	WebElement firstName2;

	@FindBy(xpath = "//input[@id='lastname']")
	@CacheLookup
	WebElement lastName2;

	@FindBy(xpath = "//input[@id='address1']")
	@CacheLookup
	WebElement address;

	@FindBy(xpath = "//input[@id='city']")
	@CacheLookup
	WebElement city;

	@FindBy(xpath = "//select[@id='id_state']")
	@CacheLookup
	WebElement state;

	@FindBy(xpath = "//input[@id='postcode']")
	@CacheLookup
	WebElement zip;

	@FindBy(xpath = "//select[@id='id_country']")
	@CacheLookup
	WebElement country;

	@FindBy(xpath = "//input[@id='phone_mobile']")
	@CacheLookup
	WebElement mobile;

	@FindBy(xpath = "//input[@id='alias']")
	@CacheLookup
	WebElement addressAlias;

	@FindBy(xpath = "//button[@id='submitAccount']")
	@CacheLookup
	WebElement registerBtn;

	public EComAcctCreationPage() {
		PageFactory.initElements(driver, this);
	}

	public void inputPersonalInfo(String ttl, String fName, String lName, String pwd, String dDay, String dMonth,
			String dYear, String newsLttr) {

		if (ttl.equals("Mr")) {
			titleMr.click();
		} else if (ttl.equals("Mrs")) {
			titleMrs.click();
		}

		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		password.sendKeys(pwd);

		Select dobDaySel = new Select(dobDay);
		dobDaySel.selectByValue(dDay);

		Select dobMonthSel = new Select(dobMonth);
		dobMonthSel.selectByValue(dMonth);

		Select dobYearSel = new Select(dobYear);
		dobYearSel.selectByValue(dYear);

		if (newsLttr.equals("1")) {
			signUpNewsletterChkBx.click();
		}

	}

	public EComAccountPage inputAddressDetails(String fName, String lName, String addrss, String cty, String stt,
			String zp, String cntry, String mbl, String addrssAls) {
		firstName2.sendKeys(fName);
		lastName2.sendKeys(lName);
		address.sendKeys(addrss);
		city.sendKeys(cty);

		Select stateSel = new Select(state);
		stateSel.selectByVisibleText(stt);

		zip.sendKeys(zp);

		Select countrySel = new Select(country);
		countrySel.selectByVisibleText(cntry);

		mobile.sendKeys(mbl);
		addressAlias.sendKeys(addrssAls);

		registerBtn.click();

		return new EComAccountPage();
	}
}
