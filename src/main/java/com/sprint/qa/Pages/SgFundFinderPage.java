package com.sprint.qa.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.sprint.qa.base.TestBase;
import com.sprint.qa.helper.Helper;
import com.sprint.qa.helper.LoggerHelper;

public class SgFundFinderPage extends TestBase{
	Logger log = LoggerHelper.getLogger(LoggerHelper.class);
	Helper help =new Helper();
	
	public static String VIEW_ALL_FUNDS = "//a[contains(text(),' View All Funds ')]";
	public static String SG_ALLFUNDS = "//*[contains(@class,'fund-name ab-table')]//a";
	public static String CURRENCIES_DD = "//div[contains(text(),'Currencies')]";
	public static String CURRENCIES_CNH = "//input[contains(@id,'ReportingCurrency/CNH') and @checked]";
	public static String CURRENCIES_EUR = "//input[contains(@id,'ReportingCurrency/EUR') and @checked]";
	public static String BASE_CURRENCIES = "//input[contains(@id,'CurrencyType/Base') and @checked]";
	public static String SHARECLASS_DD = "//div[contains(text(),'Share Classes')]";
	public static String SHARECLASS_ACCUMULATING = "//input[contains(@id,'DividendFrequency/Accumulating') and @checked]";
	public static String SHARECLASS_DISTRIBUTING = "//input[contains(@id,'DividendFrequency/Distributing') and @checked]";
	public static String DAILYPRICING_SG = "//*[contains(@id,'dailyPricing')]";
	public static String PERFORMANCE_SG = "//*[contains(@id,'calPerformance')]";
	public static String FUNDFACTS_SG = "//*[contains(@id,'fundFacts')]";
	public static String DOCUMENTS_SG = "//*[contains(@id,'documents')]";
	
	
	public WebElement getViewAllFunds() {
		return help.get_element(VIEW_ALL_FUNDS);
	}
	public WebElement getCurrenciesDD() {
		return help.get_element(CURRENCIES_DD);
	}
	public WebElement getShareclassDD() {
		return help.get_element(SHARECLASS_DD);
	}
	public WebElement getCurrenciesCNH() {
		return help.get_element(CURRENCIES_CNH);
	}
	public WebElement getCurrenciesEUR() {
		return help.get_element(CURRENCIES_EUR);
	}
	public WebElement getBaseCurrencies() {
		return help.get_element(BASE_CURRENCIES);
	}
	public WebElement getShareclassAccumulating() {
		return help.get_element(SHARECLASS_ACCUMULATING);
	}
	public WebElement getShareclassDistributing() {
		return help.get_element(SHARECLASS_DISTRIBUTING);
	}
	public WebElement getPerformanceSG() {
		return help.get_element(PERFORMANCE_SG);
	}
	public WebElement getDailyPricingSG() {
		return help.get_element(DAILYPRICING_SG);
	}
	public WebElement getFundFactsSG() {
		return help.get_element(FUNDFACTS_SG);
	}
	public WebElement getDocumentsSG() {
		return help.get_element(DOCUMENTS_SG);
	}
	public WebElement getsgAllFunds() {
		return help.get_element(SG_ALLFUNDS);
	}
	
	public SgFundFinderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, true);
	}
	
	public void clickOnViewAllFunds() {
		try {
			getViewAllFunds().click();
		} catch (Exception e) {
			scrollandclick(getViewAllFunds());
		}
	}
	public void clickOnCurrenciesDD() {
		getCurrenciesDD().click();
	}
	public void clickOnShareclassDD() {
		getShareclassDD().click();
	}
	public void VerifyDefaultCurrenciesSelected() {
		validateCurrenciesCNH();
		validateCurrenciesEUR();
		validateBaseCurrencies();
	}
	public void VerifyDefaultShareclassSelected() {
		validateShareclassAccumulating();
		validateShareclassDistributing();
	}
	
	public void validateCurrenciesCNH() {
		Assert.assertTrue(getCurrenciesCNH().isEnabled());
	}
	public void validateCurrenciesEUR() {
		Assert.assertTrue(getCurrenciesEUR().isEnabled());
	}
	public void validateBaseCurrencies() {
		Assert.assertTrue(getBaseCurrencies().isEnabled());
	}
	public void validateShareclassAccumulating() {
		Assert.assertTrue(getShareclassAccumulating().isEnabled());
	}
	public void validateShareclassDistributing() {
		Assert.assertTrue(getShareclassDistributing().isEnabled());
	}
	public void clickOnPerformanceTab() {
		getPerformanceSG().click();
	}
	public void clickOnDailyPricingTab() {
		getDailyPricingSG().click();
	}
	public void clickOnFundFactsTab() {
		getFundFactsSG().click();
	}
	public void clickOnDocumentsTab() {
		getDocumentsSG().click();
	}
	public void validateSGallFunds() {
		wait_element_tobe_displayed(getsgAllFunds());
		Assert.assertTrue(getsgAllFunds().isDisplayed());
	}

}
