/**
 * 
 */
package com.test.sirisha.steps;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import com.test.sirisha.utils.ConfigurationParser;
import com.test.sirisha.pages.Authentication;
import com.test.sirisha.pages.Category;
import com.test.sirisha.pages.Header;
import com.test.sirisha.pages.MyAccount;
import com.test.sirisha.pages.Order;
import com.test.sirisha.pages.OrderConfirmation;
import com.test.sirisha.pages.Payment;
/**
 * @author Sirisha Dunukunala
 *
 */

public class StepsImpl {
	static 	WebDriver driver;
	String orderNumber;
	String expectedFirstName;
	String firstNameBeforeChange;

	@Before
	public void before() {
		ConfigurationParser.getInstance();
		driver = ConfigurationParser.getChromeDriver();
		orderNumber = "";
		expectedFirstName = "";
		firstNameBeforeChange = "";
	}

	@After
	public void after() {
		driver.close();
	}

	@Given("^I have Opened Webpage for AutomationPractice$")
	public void inBrowserEnterUrl() throws Throwable {
	    driver.get(ConfigurationParser.getUrl());
	}

	@Given("^Logged into Account using valid loging Credentials$")
	public void login() throws Throwable {
		Header header = PageFactory.initElements(driver, Header.class);	    
	    header.clickSignIn();
	    Authentication auth = PageFactory.initElements(driver, Authentication.class);
	    auth.LogIn();
	}

	@When("^we select T-shirt tab$")
	public void selectTshirtTab() throws Throwable {
		Header header = PageFactory.initElements(driver, Header.class);
		header.clickTShirtTab();
	}

	@When("^Add First Item to Cart$")
	public void selectFirstItemFromList() throws Throwable {
		Category category = PageFactory.initElements(driver, Category.class);
		category.addFirstProduct();
	}

	@When("^Proceed to Checkout$")
	public void proceedToCheckoutPopup() throws Throwable {
		Category category = PageFactory.initElements(driver, Category.class);
		category.proceedToCheckout();
	}

	@When("^Summary Proceed to Checkout$")
	public void summaryDetails() throws Throwable {
		Order order = PageFactory.initElements(driver, Order.class);
		order.summaryProceedToCheckout();
	}

	@When("^Address Proceed to Checkout$")
	public void addressCheckout() throws Throwable {
		Order order = PageFactory.initElements(driver, Order.class);
		order.addressProceedToCheckout();
	}

	@When("^Agree to Terms and Conditions and Proceed to Payment$")
	public void agreeTAndCAndShipmentCheckout() throws Throwable {
		Order order = PageFactory.initElements(driver, Order.class);
		order.agreeTAndCAndShipmentCheckout();
	}

	@When("^Select Payment by Wire$")
	public void selectPaymentByWire() throws Throwable {
		Order order = PageFactory.initElements(driver, Order.class);
		order.selectPaymentByBankWire();
	}

	
	@When("^Made a Payment$")
	public void makePayment() throws Throwable {
		Payment payment = PageFactory.initElements(driver, Payment.class);
		payment.clickConfirmOrderBtn();
	}

	@Then("^Verify that Order is Confirmed$")
	public void verifyOrder() throws Throwable {
		OrderConfirmation orderDetails = PageFactory.initElements(driver, OrderConfirmation.class);
		orderNumber = orderDetails.getOrderNumber();
	}

	@Then("^Verify Order in OrderHistory$")
	public void checkOrderNumberPresentInHistory() throws Throwable {
		Header header = PageFactory.initElements(driver, Header.class);
		header.clickMyAccount();
		MyAccount myAccount = PageFactory.initElements(driver, MyAccount.class);
		myAccount.clickOrderHistory();
		assertTrue(myAccount.isOrderPresent(orderNumber));
	}
	
	@When("^Clicked My Account and Clicked On Personal Information$")
	public void click() throws Throwable {
		Header header = PageFactory.initElements(driver, Header.class);
		header.clickMyAccount();
		MyAccount myAccount = PageFactory.initElements(driver, MyAccount.class);
		myAccount.clickPersonalInformationBtn();
		firstNameBeforeChange = myAccount.getFirstName();
	}

	@When("^Changed FirstName to \\\"([^\\\"]*)\\\" and save$")
	public void changeFirstNameWith(String firstName) throws Throwable {
		Header header = PageFactory.initElements(driver, Header.class);
		header.clickMyAccount();
		MyAccount myAccount = PageFactory.initElements(driver, MyAccount.class);
		myAccount.clickPersonalInformationBtn();
		myAccount.setFirstName(firstName);
		myAccount.clickSaveInPersonalInfo();
		expectedFirstName = firstName;
	}

	@Then("^First Name is Updated Correctly$")
	public void FirstNameIsUpdatedCorrectly() throws Throwable {
		Header header = PageFactory.initElements(driver, Header.class);
		header.clickMyAccount();
		MyAccount myAccount = PageFactory.initElements(driver, MyAccount.class);
		myAccount.clickPersonalInformationBtn();
		String actualFirstName = myAccount.getFirstName();
		assertEquals("FirstName has not changed", ConfigurationParser.capitalize(expectedFirstName), actualFirstName);
		changeFirstNameWith(firstNameBeforeChange);
	}
}
