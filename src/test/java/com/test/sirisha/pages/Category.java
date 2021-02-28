/**
 * 
 */
package com.test.sirisha.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.test.sirisha.utils.Utility;

/**
 * @author Sirisha Dunukunala
 *
 */
public final class Category extends Header {
	@FindBy(xpath = "//*[@id=\"center_column\"]/ul")
	WebElement listOfProducts;

	@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img")
	WebElement firstProduct;
	
	@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]/span")
	WebElement addFirstProductToCart;
	
	@FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")
	WebElement proceedToCheckout;
	
	
	public Category(WebDriver webDriver) {
		super(webDriver);;
	}
	
	public void selectFirstItemInProductList() {
		// TODO We need to Check what if there are no Products
		firstProduct.click();
	}

	public void hooverFirstItemInProductList() {
		// TODO We need to Check what if there are no Products
		Actions action = new Actions(_driver);
		action.moveToElement(firstProduct);
		action.perform();
	}
	
	public void addFirstProduct() {
		hooverFirstItemInProductList();
		Utility.waitforElement(_driver, addFirstProductToCart).click();
	}

	public void proceedToCheckout() {
		Utility.waitforElement(_driver, proceedToCheckout).click();
	}
	
}
