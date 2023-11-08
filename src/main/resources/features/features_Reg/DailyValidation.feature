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

      
      
  @ETF
  Scenario Outline: Prod Validation for US
    Given Navigate to '<Country>' site
    When I Click on Individual Investor
    And I click on Investment
    And I click on Products
    When I click on ETF Funds
    Then Verify Each ETF Funds

    Examples: 
      | Country  |
      |United States|
      
      
  @FF
  Scenario Outline: US Fund Finder Page Validation
    Given Navigate to '<Country>' site
    When I Click on Individual Investor
    And I click on Investment
    And I click on Products
    And I select AssetClass DD
    And I select Equities in AssetClass DD
    Then Verify the Funds are Equities
    And I click on Reset Filters
    And I select AssetClass DD
    And I select Fixed Income in AssetClass DD
    Then Verify the Funds are Fixed Income
    And I click on Reset Filters
    And I select AssetClass DD
    And I select Multi Asset in AssetClass DD
    Then Verify the Funds are Multi Asset
    And I click on Reset Filters
    And I select AssetClass DD
    And I select Alternatives in AssetClass DD
    Then Verify the Funds are Alternatives
    And I click on Reset Filters
    And I select Styles DD
    And I select Equity Core in Styles DD
    Then Verify Equity Core Funds
    And I click on Reset Filters
    And I select Region DD
    And I select Global in Region DD
    Then Verify Global Funds Count
    And I click on Reset Filters

    Examples: 
      | Country  |
      |United States|
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      