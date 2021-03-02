/**
 * 
 */
package com.test.sirisha.pages;

import java.util.List;

import com.test.sirisha.utils.ConfigurationParser;
import com.test.sirisha.utils.WebpageHelper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Sirisha Dunukunala
 *
 */
public final class MyAccount extends Header {

	@FindBy(xpath = "//*[@id=\"center_column\"]/div/div[1]/ul/li[1]/a")
	WebElement orderHistoryBtn;

	@FindBy(id = "order-list")
	WebElement orderHistoryTable;

	@FindBy(xpath = "//*[@id=\"order-list\"]/tbody/tr[1]")
	WebElement firstItemInOrderHistoryTable;
	
	@FindBy(xpath = "//*[@id=\"center_column\"]/div/div[1]/ul/li[4]/a")
	WebElement personalInformationBtn;
	
	@FindBy(id = "firstname")
	WebElement firstNameTextBox;
	
	@FindBy(xpath = "//*[@id=\"center_column\"]/div/form/fieldset/div[11]/button")
	WebElement personamInformationSave;
	
	@FindBy(id = "old_passwd")
	WebElement currentPassword;
	
	@FindBy(id = "passwd")
	WebElement newPassword;	

	@FindBy(id = "confirmation")
	WebElement confirmationPassword;	

	public MyAccount(WebDriver webDriver) {
		super(webDriver);
	}
	
	public void clickOrderHistory() {
		orderHistoryBtn.click();
	}
	
	public void clickPersonalInformationBtn() {
		personalInformationBtn.click();
	}

	public boolean isOrderPresent(String orderNumber) {
		WebpageHelper.waitforElement(_driver, firstItemInOrderHistoryTable);
		List<WebElement> rows = orderHistoryTable .findElements(By.tagName("tr"));
		for(int i=0; i<rows.size(); i++) {
			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
		    for(int j=0; j<cols.size(); j++) {
				if (cols.get(0).getText().equals(orderNumber)) {
					return true;
				}
		    }
		}
		return false;
	}

	public String getFirstName() {
		return firstNameTextBox.getAttribute("value");
	}

	public void setFirstName(String firstName) {
		firstNameTextBox.clear();
		firstNameTextBox.sendKeys(firstName);
	}
	
	public void clickSaveInPersonalInfo() {
		currentPassword.sendKeys(ConfigurationParser.getPassword());
		newPassword.sendKeys(ConfigurationParser.getPassword());
		confirmationPassword.sendKeys(ConfigurationParser.getPassword());
		personamInformationSave.click();
	}
}
