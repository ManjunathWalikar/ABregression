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
      
  @ProdValidation
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
      |United States|AB All Market Real Return Portfolio|
      #|United States|AB All Market Total Return Portfolio|
      #|United States|AB Arizona Portfolio|

      
      
  @ProdValidation
  Scenario Outline: Prod Validation for US ETF Funds
    Given Navigate to '<Country>' site
    When I Click on Individual Investor
    And I click on Investment
    And I click on Products
    When I click on ETF Funds
    Then Verify Each ETF Funds

    Examples: 
      | Country  |
      |United States|
      
      
  @ProdValidation
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
    And I select Global in Region DD
    And I select ShareClass DD
    And I select Advisor in ShareClass DD
    And I select ShareClass DD
    
    Then Verify Total Mutual Funds Count
    And I click on Reset Filters
    When I click on Daily Pricing and Yields
    Then I Verify Funds are Loaded
    And I click on Literature
    Then I Verify Funds are Loaded
    And I click on Performance
    When I click on Quarter End As Of
    Then I Verify Funds are Loaded
    When I click on Month End As Of
    Then I Verify Funds are Loaded
    When I click on Show Benchmark
    Then Verify Benchmark Data
    And I Click on Hide Benchmark
    Then Verify QuickView of Funds
    When I click on Daily Pricing and Yields
    When I Validate As Of Date
    And I search '<Fundname>' in FF page FundSearch
    Then I validate FD page of '<Fundname>'

    Examples: 
      | Country  | Fundname |
      |United States| AB All China Equity Portfolio |
      
      
  @SMAS
  Scenario Outline: Prod Validation for US SMAS Funds
    Given Navigate to '<Country>' site
    When I Click on Individual Investor
    And I click on Investment
    And I click on Products
    When I click on SMAS Funds
    Then Verify Each SMAS Funds    
      
    Examples: 
      | Country  | 
      |United States|   
      
   @MPF
  Scenario Outline: Prod Validation for US Model Portfolio Funds
    Given Navigate to '<Country>' site
    When I Click on Individual Investor
    And I click on Investment
    And I click on Products
    When I click on Model Portfolio Funds
    Then Verify Each Model Portfolio Funds    
      
    Examples: 
      | Country  | 
      |United States|    
      
      
   @CEF
  Scenario Outline: Prod Validation for US Closed End Funds
    Given Navigate to '<Country>' site
    When I Click on Individual Investor
    And I click on Investment
    And I click on Products
    When I click on Closed End Funds
    Then Verify Each Closed End Funds    
      
    Examples: 
      | Country  | 
      |United States|   
      
      
      
  @VPSF
  Scenario Outline: Prod Validation for US Veriable Product Series Funds
    Given Navigate to '<Country>' site
    When I Click on Individual Investor
    And I click on Investment
    And I click on Products
    When I click on Veriable Product Series Funds
    Then Verify Each Veriable Product Series Funds    
      
    Examples: 
      | Country  | 
      |United States|    
      
      
  @ProdValidation   
  Scenario Outline: Prod Validation for US Fund Details Page   
    Given Navigate to '<Country>' site
    When I Click on Individual Investor
    And I click on Investment
    And I click on Products
    When I click on Mutual Funds
    Then Verify Each mutual Funds 
    When I click on SMAS Funds
    Then Verify Each SMAS Funds
    When I click on ETF Funds
    Then Verify Each ETF Funds
    When I click on Model Portfolio Funds
    Then Verify Each Model Portfolio Funds
    When I click on Closed End Funds
    Then Verify Each Closed End Funds
    When I click on Veriable Product Series Funds
    Then Verify Each Veriable Product Series Funds  
      
    Examples: 
      | Country  | 
      |United States|   
      
      
  @ProdValidation
  Scenario Outline: US Mutual Fund Details Page Validation
    Given Navigate to '<Country>' site
    When I Click on Individual Investor
    And I click on Investment
    And I click on Products
    When I click on Mutual Funds
    And I get as of Date From FF page
    And I get NAV value of '<Fundname>' FF page
    When I Validate As Of Date
    And I Click On given '<Fundname>'
    And I Switch Window to '<Fundname>'
    And I Validate As Of Date in FD Page
    And I Validate NAV Value    
    And I Click On Overview
    Then I Verify Key Facts
    And I click on Pricing and Performance
    Then I Validate Daily Nav As Of Value
    And I Validate Hypothetical Growth
    And I validate NAV History Chart
    And I click On Yields and Distribution
    Then I Validate Distribution Table
    And I click on Holdings and Characteristics
    Then I Verify Holdings Table
    And I click on Literature Vehicle
    And I click on select all Literature checkbox
    Then I verify Document Selected PopUp
    And I click on select all Literature checkbox
    And I close current Browser
    
    Examples: 
      | Country  | Fundname |
      |United States| AB All Market Real Return Portfolio |    
   
   @ProdValidation   
  Scenario Outline: Prod Validation for SG Fund Finder Page   
    Given Navigate to '<Country>' site
    When I Click on Individual Investor  
    And I Click on Yes Continue Btn
    And I click on view all funds
    #And I select AssetClass DD
    #And I select Equities in AssetClass DD
    When I click on Currencies DD
    Then Verify Default Currencies for SG
    When I click on Shareclass DD
    Then Verify Default Shareclass For SG
    And I click on Performance Tab
    Then I verify Funds are Displayed
    And I click on Fund Facts
    Then I verify Funds are Displayed
    And I click on Documents
    Then I verify Funds are Displayed
    And I click on DailyPricing Tab
    Then I verify Funds are Displayed
    Then I verify AS OF DATE for SG
    And I search '<Fundname>' in FF page
      
    Examples: 
      | Country  | Fundname |
      | Singapore| AB All Market Income Portfolio |   

      
  @ProdValidation   
  Scenario Outline: Prod Validation for SG Fund Details Page   
    Given Navigate to '<Country>' site
    When I Click on Individual Investor  
    And I Click on Yes Continue Btn
    And I click on view all funds   
    Then Validate all Funds 
      
    
    Examples: 
      | Country  | 
      | Singapore| 
      
      
  @ProdValidation   
  Scenario Outline: Prod Validation for SG Fund Details Page   
    Given Navigate to '<Country>' site
    When I Click on Individual Investor  
    And I Click on Yes Continue Btn
    And I click on view all funds 
    And I wait in sec '10'
    And I click on Performance Tab
    And I get Performance Value of '<Fundname>'
    And I click on Pricing and Performance
    Then Validate Annual Performance Values
    And I click on Performance Tab
    And I wait in sec '5'
    And I click on Calender Year Performance
    Then Validate Calender Year Performance Values
      
    
    Examples: 
      | Country  | Fundname |
      | Singapore| AB All Market Income Portfolio |   
      
      
      
      
      
      
        
      