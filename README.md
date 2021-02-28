# selenium_cucumber

## Execution-Command:
mvn clean test

## Execution Report
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running TestRunner.TestRunner

@webAutomation

Feature: Web Automation Task

  I want to automate some scenarios in feature file
  
Starting ChromeDriver 88.0.4324.96 (68dba2d8a0b149a1d3afac56fa74648032bcf46b-refs/branch-heads/4324@{#1784}) on port 38806

Only local connections are allowed.

Please see https://chromedriver.chromium.org/security-considerations for suggestions on keeping ChromeDriver safe.

ChromeDriver was started successfully.

Feb 28, 2021 9:51:33 PM org.openqa.selenium.remote.ProtocolHandshake createSession

INFO: Detected dialect: W3C

Starting ChromeDriver 88.0.4324.96 (68dba2d8a0b149a1d3afac56fa74648032bcf46b-refs/branch-heads/4324@{#1784}) on port 46462

Only local connections are allowed.

Please see https://chromedriver.chromium.org/security-considerations for suggestions on keeping ChromeDriver safe.

ChromeDriver was started successfully.

Feb 28, 2021 9:52:08 PM org.openqa.selenium.remote.ProtocolHandshake createSession

INFO: Detected dialect: W3C

  @OrderTshirt

Scenario: Order T-Shirt and verify in History              # automation.feature:6

  Given I have Opened Webpage for AutomationPractice       # StepsImpl.inBrowserEnterUrl()

    And Logged into Account using valid loging Credentials   # StepsImpl.login()
    
    When we select T-shirt tab                               # StepsImpl.selectTshirtTab()
    
    And Add First Item to Cart                               # StepsImpl.selectFirstItemFromList()
    
    And Proceed to Checkout                                  # StepsImpl.proceedToCheckoutPopup()
    
    And Summary Proceed to Checkout                          # StepsImpl.summaryDetails()
    
    And Address Proceed to Checkout                          # StepsImpl.addressCheckout()
    
    And Agree to Terms and Conditions and Proceed to Payment # StepsImpl.agreeTAndCAndShipmentCheckout()
    
    And Select Payment by Wire                               # StepsImpl.selectPaymentByWire()
    
    And Made a Payment                                       # StepsImpl.makePayment()
    
    Then Verify that Order is Confirmed                      # StepsImpl.verifyOrder()
    
    And Verify Order in OrderHistory                         # StepsImpl.checkOrderNumberPresentInHistory()

  @UpdatePersonalInfo

  Scenario: Update Person Information in My Account             # automation.feature:21
  
    Given I have Opened Webpage for AutomationPractice          # StepsImpl.inBrowserEnterUrl()
    
    And Logged into Account using valid loging Credentials      # StepsImpl.login()
    
    When Clicked My Account and Clicked On Personal Information # StepsImpl.click()
    
    And Changed FirstName to "XYZ" and save                     # StepsImpl.changeFirstNameWith(String)
    
    Then First Name is Updated Correctly                        # StepsImpl.FirstNameIsUpdatedCorrectly()


2 Scenarios (2 passed)

17 Steps (17 passed)

0m59.698s

Tests run: 19, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 60.182 sec

Results :

Tests run: 19, Failures: 0, Errors: 0, Skipped: 0


[INFO] ------------------------------------------------------------------------

[INFO] BUILD SUCCESS

[INFO] ------------------------------------------------------------------------

[INFO] Total time:  01:03 min

[INFO] Finished at: 2021-02-28T21:52:31Z

[INFO] ------------------------------------------------------------------------
