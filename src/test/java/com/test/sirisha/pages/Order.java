/**
 * 
 */
package com.test.sirisha.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Sirisha Dunukunala
 *
 */
public class Order extends Header {

	@FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]")
	WebElement summaryProceedToCheckout;

	@FindBy(xpath = "//*[@id=\"center_column\"]/form/p/button")
	WebElement addressProceedToCheckout;

	@FindBy(xpath = "//*[@id=\"form\"]/p/button")
	WebElement shippingProceedToCheckout;
	
	@FindBy(xpath = "//*[@id=\"cgv\"]")
	WebElement agreeTermsAndConditions;

	@FindBy(xpath = "//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")
	WebElement payByBankWire;
	
	public Order(WebDriver webDriver) {
		super(webDriver);;
	}

	public void summaryProceedToCheckout() {
		summaryProceedToCheckout.click();
	}
	
	public void addressProceedToCheckout() {
		addressProceedToCheckout.click();
	}

	public void agreeTAndCAndShipmentCheckout() {
		agreeTermsAndConditions.click();
		shippingProceedToCheckout.click();
	}
	
	public void selectPaymentByBankWire() {
		payByBankWire.click();
	}
}
