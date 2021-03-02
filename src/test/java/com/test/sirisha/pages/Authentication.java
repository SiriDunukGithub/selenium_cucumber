/**
 * 
 */
package com.test.sirisha.pages;

import com.test.sirisha.utils.ConfigurationParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * @author Sirisha Dunukunala
 *
 */

public final class Authentication extends Header {
	@FindBy(id = "email")
	WebElement emailIdTextBox;

	@FindBy(id = "passwd")
	WebElement passwordTextBox;

	@FindBy(id = "SubmitLogin")
	WebElement signInBtn;
	
	
	
	public Authentication(WebDriver webDriver) {
		super(webDriver);
	}
	
	public void setEmailId() {
		ConfigurationParser.getInstance();
		emailIdTextBox.sendKeys(ConfigurationParser.getUsername());
	}

	public void setPassword() {
		ConfigurationParser.getInstance();
		passwordTextBox.sendKeys(ConfigurationParser.getPassword());
	}

	public void signIn() {
		ConfigurationParser.getInstance();
		signInBtn.click();
	}

	public void LogIn() {
	    setEmailId();
	    setPassword();
	    signIn();
	}
}
