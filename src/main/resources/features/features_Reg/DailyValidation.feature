@Regression
Feature: Daily Production validaton

  @Smoke
  Scenario Outline: Prod Validation for US
    Given Navigate to '<Country>' site
    When I Click on Individual Investor
    And I click on Investment
    And I click on Products
    When I click on Mutual Funds
    Then Verify Each mutual Funds

    Examples: 
      | Country  |
      |United States|
      
  @Test
  Scenario Outline: Prod Validation for US
    Given Navigate to '<Country>' site
    When I Click on Individual Investor
    And I click on Investment
    And I click on Products
    When I click on Mutual Funds
    Then Verify '<Perticular>' Fund

    Examples: 
      | Country     |Perticular |
      |United States|AB All China Equity Portfolio|
      #|United States|AB All Market Real Return Portfolio|
      #|United States|AB All Market Total Return Portfolio|
      #|United States|AB Arizona Portfolio|
