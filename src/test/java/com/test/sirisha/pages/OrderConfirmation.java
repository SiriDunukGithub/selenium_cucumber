package com.test.sirisha.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.test.sirisha.utils.WebpageHelper;
/**
 * @author Sirisha Dunukunala
 *
 */

public final class OrderConfirmation extends Header {
	@FindBy(xpath = "//*[@id=\"center_column\"]/div")
	WebElement getOrderNumberText;

	public OrderConfirmation(WebDriver webDriver) {
		super(webDriver);
	}

	public String getOrderNumber() {
		WebpageHelper.waitforElement(_driver, getOrderNumberText);
		String textWithOrderNumber = getOrderNumberText.getText();
		String searchString = "Do not forget to insert your order reference";
		int index1 = textWithOrderNumber.indexOf(searchString);
		int index2 = textWithOrderNumber.indexOf(" in the subject of your");
		String orderNumber = textWithOrderNumber.substring(index1+searchString.length()+1, index2);	
		return orderNumber;
	}
}
