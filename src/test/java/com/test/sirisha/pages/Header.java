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
public class Header {
	WebDriver _driver;
	
	@FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
	WebElement signInBtn;
	
	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[3]/a")
	WebElement tShirtTab;
	
	@FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
	WebElement myAccount;
	
	public Header() {}

	public Header(WebDriver webDriver) {
		this._driver = webDriver;
	}

	public void setDriver(WebDriver webDriver) {
		this._driver = webDriver;
	}

	public void clickSignIn() {
		signInBtn.click();
	}

	public void clickTShirtTab() {
		tShirtTab.click();		
	}

	public void clickMyAccount() {
		myAccount.click();
	}
}
