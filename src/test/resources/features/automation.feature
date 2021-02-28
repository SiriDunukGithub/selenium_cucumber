@webAutomation
Feature: Web Automation Task
  I want to automate some scenarios in feature file

  @OrderTshirt
  Scenario: Order T-Shirt and verify in History
    Given I have Opened Webpage for AutomationPractice
    And Logged into Account using valid loging Credentials
    When we select T-shirt tab
    And Add First Item to Cart
    And Proceed to Checkout
    And Summary Proceed to Checkout
    And Address Proceed to Checkout
    And Agree to Terms and Conditions and Proceed to Payment
    And Select Payment by Wire
    And Made a Payment
    Then Verify that Order is Confirmed
    And Verify Order in OrderHistory

  @UpdatePersonalInfo
  Scenario: Update Person Information in My Account
    Given I have Opened Webpage for AutomationPractice
    And Logged into Account using valid loging Credentials
    When Clicked My Account and Clicked On Personal Information
    And  Changed FirstName to "XYZ" and save
    Then First Name is Updated Correctly
