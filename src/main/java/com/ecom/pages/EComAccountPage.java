package com.ecom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.base.EComBasePage;

public class EComAccountPage extends EComBasePage {

	@FindBy(xpath = "//span[text()='My account']")
	@CacheLookup
	WebElement myAcctLbl;

	@FindBy(xpath = "//a[text()='Women']")
	@CacheLookup
	WebElement womenLink;

	@FindBy(xpath = "//a[@title='Women']//following::ul//li//li//a[text()='T-shirts']")
	@CacheLookup
	WebElement tshirtsLink;

	@FindBy(xpath = "//span[@class='category-name']")
	@CacheLookup
	WebElement tshirtsCatLbl;

	public EComAccountPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean isMyAcctLblDisplayed() {
		return myAcctLbl.isDisplayed();
	}

	public void shopTshirts() {
		Actions hoverWomenLink = new Actions(driver);
		hoverWomenLink.moveToElement(womenLink).build().perform();

		tshirtsLink.click();
	}

	public boolean isTshirtsCategoryDisplayed() {
		return tshirtsCatLbl.isDisplayed();
	}
}
