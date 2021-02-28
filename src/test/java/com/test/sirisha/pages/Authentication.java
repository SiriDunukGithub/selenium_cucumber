/**
 * 
 */
package com.test.sirisha.pages;

import com.test.sirisha.utils.Utility;
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
		Utility.getInstance();
		emailIdTextBox.sendKeys(Utility.getUsername());
	}

	public void setPassword() {
		Utility.getInstance();
		passwordTextBox.sendKeys(Utility.getPassword());
	}

	public void signIn() {
		Utility.getInstance();
		signInBtn.click();
	}

	public void LogIn() {
	    setEmailId();
	    setPassword();
	    signIn();
	}
}
