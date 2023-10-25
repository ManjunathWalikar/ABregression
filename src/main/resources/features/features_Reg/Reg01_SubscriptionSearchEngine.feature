@smoke @uat
Feature: Subscriptions Search Engine

  @smoke @Regression1
  Scenario: Subscriptions Search Engine Validation
    Given SEngine user is already on subscriptions page
    Then SEngine title of the login page is Subscriptions
    Then SEngine user clicks on view details link
    And SEngine user is on Subscription page

  @smoke @Regression1
  Scenario: Subscriptions Search Engine Validation Validate Add Button
    And SEngine user clicks on first time add button

  @smoke @Regression1
  Scenario: Subscriptions Search Engine Validating Dropdowns
    And SEngine user clicks on first subscription dropdown selects dropdown value
    And SEngine user clicks on first dropdown and selects option

  @smoke @Regression1
  Scenario: Subscriptions Search Engine Validation Validate Second Time Add Button
    And SEngine user clicks on second time add button
    And SEngine user clicks on second subscription dropdown selects dropdown value
    And SEngine user clicks on second dropdown and selects option

  @smoke @Regression1
  Scenario: Subscriptions Search Engine Validation Validate Search Button
    And SEngine user clicks on search button
    And SEngine user clicks on save search button
    And SEngine user verifies message User Search Setting Saved

  @smoke @Regression1
  Scenario: Subscriptions Search Engine Validation Renewal Notice Button
    And SEngine user unable to click on send renewal notice button

  @Regression1
  Scenario: Subscriptions Search Engine Validation Validate Dropdown
    And SEngine user clicks on third time subscription dropdown selects dropdown value
    And SEngine user clicks on third time dropdown and selects option

  @Regression1
  Scenario: Subscriptions Search Engine Validation Validate Second Time Search Button
    And SEngine user clicks on search button second time

  @Regression1
  Scenario: Scenario: Subscriptions Search Engine Validation Validate Checkbox
    And SEngine user clicks on checkbox

  @Regression1
  Scenario: Subscriptions Search Engine Validation Validate Renewal Notice Button
    And SEngine user able to click on send renewal notice button

  @Regression1
  Scenario: Subscriptions Search Engine Validation Close the Popup Message
    And SEngine user able to click on x to close the popup message

  @Regression1
  Scenario: Subscriptions Search Engine Validation Export Button and File Download
    Then SEngine user able to click on export button and file gets downloaded

  @Regression1
  Scenario: Subscriptions Search Engine Validation Validate Column Options Button
    And SEngine user able to click on column options first time
    And SEngine user selects available options and clicks add
    And SEngine user clicks on apply button first time

  @Regression1
  Scenario: Subscriptions Search Engine Validation Verifying Column Options Button Second Time
    And SEngine user able to click on column options second time
    And SEngine user selects already selection options and clicks on remove button
    And SEngine user clicks on apply button second time
  @Regression1
  Scenario: Subscriptions Search Engine Validation Verifying Column Options Button Third Time
    And SEngine user able to click on column options third time
    Then SEngine user clicks on cancel button
    And SEngine user clicks on reset button on the search menu

  @Regression1
  Scenario: Subscriptions Search Engine Validation Cancelled Status
    And SEngine user unable to click the checkbox for cancelled status
    And SEngine user able to filter entries display on page

  @Regression1
  Scenario: Subscriptions Search Engine Validation Go to Next Page
    And SEngine user able to navigate to next page to check records


  @Regression1
  Scenario: Subscriptions Search Engine validate search filters
    And SEngine user can see search filters
  @Regression1
  Scenario: Subscriptions Search Engine validating Reset to System Defaults
    And SEngine user Clicks on Reset to System Defaults option
    And SEngine user can see search default filters as Created Date and Subs#
  @Regression1
  Scenario: Subscriptions Search Engine verifying order#
    And SEngine user clicks on second dropdown Order# and selects option
    And SEngine user inputs order#
    And SEngine user inputs order# with space
  @Regression1
  Scenario: Subscriptions Search Engine verification of search button
    And SEngine verify Search button gets disabled when there is error on search filter
  @Regression1
  Scenario: Subscriptions Search Engine verifying clear button
    And SEngine user clicks on Clear button
  @Regression1
  Scenario: Subscriptions Search Engine Adding and verifying more filters
    And SEngine user adds few more filters like Status, Order#, Billing Frequency
    And SEngine user verifies saved filters
  @Regression1
  Scenario: Subscriptions Search Engine Monthly Billing Frequency
    And SEngine user selects billing frequency as Monthly
  @Regression1
  Scenario: Subscriptions Search Engine Status and All Status Values
    And SEngine user expands Status and verifies values
  @Regression1
  Scenario: Subscriptions Search Engine Selects Status Filter as New,  Active and Expired
    And SEngine user selects Status filter as New, Active and Expired
  @Regression1
  Scenario: Subscriptions Search Engine Collapse Searched Filters
    And SEngine user selects Clicks on Collapse search button
  @Regression1
  Scenario: Subscriptions Search Engine Verifying Filters in Capsule
    And SEngine user verifies all selected search options are getting displayed in capsule
    And SEngine user click modify search button to expand all search filter
  @Regression1
  Scenario: Subscriptions Search Engine Remove and Verify Expired Status
    And SEngine user removes Expired option from Status filter
    And SEngine user clicks on Collapse search button
  @Regression1
  Scenario: Subscriptions Search Engine Filtering Active Status Subscription selection
    And SEngine user Filters Active status subscriptions
    And SEngine user clicks on checkbox Active Status
  @Regression1
  Scenario: Subscriptions Search Engine Verifying Send Renewal Notice Button
    And SEngine user verifies send renewal notice button is enabled
  @Regression1
  Scenario: Subscriptions Search Engine Click on Send Renewal Notice
    And SEngine user clicks on send renewal notice button
  @Regression1
  Scenario: Subscriptions Search Engine Selecting Top Five Subscription Checkbox, Verifying Renewal Button and Click
    And SEngine user selects multiple subscriptions select top 5 using Checkbox
#  @Regression1
#  Scenario: Subscriptions Search Engine Selecting OverDue Status, Verifying Renewal Button and Click
#    And SEngine user Filters Overdue status subscriptions
#  @Regression1
#  Scenario: Subscriptions Search Engine Expired Filter
#    And SEngine user Filters Expired status subscriptions
  @Regression1
  Scenario: Subscriptions Search Engine Active Filter
    And SEngine user verifies in Action column send renewal notice option is displayed
