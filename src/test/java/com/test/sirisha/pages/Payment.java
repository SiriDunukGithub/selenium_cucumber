package com.test.sirisha.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Sirisha Dunukunala
 *
 */

public final class Payment extends Header {

	@FindBy(xpath = "//*[@id=\"cart_navigation\"]/button")
	WebElement confirmMyOrderBtn;

	public Payment(WebDriver webDriver) {
		super(webDriver);
	}

	public void clickConfirmOrderBtn() {
		confirmMyOrderBtn.click();		
	}
}
