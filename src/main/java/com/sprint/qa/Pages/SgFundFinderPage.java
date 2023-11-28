package com.sprint.qa.Pages;

import java.util.List;

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
	public static String CURRENCIES_JPY = "//input[contains(@id,'ReportingCurrency/JPY') and @checked]";
	public static String CURRENCIES_USD = "//input[contains(@id,'ReportingCurrency/USD') and @checked]";
	public static String BASE_CURRENCIES = "//input[contains(@id,'CurrencyType/Base') and @checked]";
	public static String SHARECLASS_DD = "//div[contains(text(),'Share Classes')]";
	public static String SHARECLASS_ACCUMULATING = "//input[contains(@id,'DividendFrequency/Accumulating') and @checked]";
	public static String SHARECLASS_DISTRIBUTING = "//input[contains(@id,'DividendFrequency/Distributing') and @checked]";
	public static String SHARECLASS_A = "//input[contains(@id,'ShareClass/A') and @checked]";
	public static String DAILYPRICING_SG = "//*[contains(@id,'dailyPricing')]";
	public static String PERFORMANCE_SG = "//*[contains(@id,'Performance')]";
	public static String FUNDFACTS_SG = "//*[contains(@id,'fundFacts')]";
	public static String DOCUMENTS_SG = "//*[contains(@id,'documents')]";
	public static String NAV_AS_OF_DATE_SG = "//tbody//td[6]";
	public static String FUND_SEARCH_SG = "//input[contains(@placeholder,'Fund Name')]";
	public static String ANNULIZED_DATA = "//label[contains(text(),'Annualized')]";
	public static String CALENDER_DATA = "//label[contains(text(),'Calendar')]";
	public static String YTDvalue;
	public static String OneYearValue;
	public static String ThreeYearValue;
	public static String FiveYearValue;
	public static String TenYearValue;
	public static String SinceInceptionValue;
	public static String INCEPTION_DATE;
	public static String DATA_2018;
	public static String DATA_2019;
	public static String DATA_2020;
	public static String DATA_2021;
	public static String DATA_2022;
	public static String DATA_YTD;
	
	
	
	
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
	public WebElement getCurrenciesJPY() {
		return help.get_element(CURRENCIES_JPY);
	}
	public WebElement getCurrenciesUSD() {
		return help.get_element(CURRENCIES_USD);
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
	public WebElement getShareclassA() {
		return help.get_element(SHARECLASS_A);
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
	public String getAsOfDateSG() {
		return help.get_element_text(NAV_AS_OF_DATE_SG);
	}
	public WebElement getFundSearch() {
		return help.get_element(FUND_SEARCH_SG);
	}
	public WebElement getAnnulizedData() {
		return help.get_element(ANNULIZED_DATA);
	}
	public WebElement getCalenderData() {
		return help.get_element(CALENDER_DATA);
	}
	
	
	
	
	public SgFundFinderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, true);
	}
	public void clickOnAnnulizedData() {
		getAnnulizedData().click();
	}
	public void clickOnCalenderData() {
		getCalenderData().click();
	}
	public void validateAsOfDateSG() {
		int currentDate = date.getDate();
		int day = date.getDay();
		int asofdate = 0;
		if(day==1)
		{
			asofdate = currentDate-4;
		}
		else if (day==2) {
			asofdate = currentDate-4;
		}
		else if (day==6) {
			asofdate = currentDate-2;
		}
		else if (day==7) {
			asofdate = currentDate-3;
		}
		else
		{
			asofdate = currentDate-2;
		}
		String updatedDate = ""+asofdate+"";
		Assert.assertTrue(getAsOfDateSG().contains(updatedDate));
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
		validateCurrenciesJPY();
		validateCurrenciesUSD();
		validateBaseCurrencies();
	}
	public void VerifyDefaultShareclassSelected() {
		validateShareclassAccumulating();
		validateShareclassDistributing();
		validateShareclassA();
	}
	
	public void validateCurrenciesCNH() {
		Assert.assertTrue(getCurrenciesCNH().isEnabled());
	}
	public void validateCurrenciesEUR() {
		Assert.assertTrue(getCurrenciesEUR().isEnabled());
	}
	public void validateCurrenciesJPY() {
		Assert.assertTrue(getCurrenciesJPY().isEnabled());
	}
	public void validateCurrenciesUSD() {
		Assert.assertTrue(getCurrenciesUSD().isEnabled());
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
	public void validateShareclassA() {
		Assert.assertTrue(getShareclassA().isEnabled());
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
	public void searchFund(String fundName) {
		getFundSearch().sendKeys(fundName);
		help.get_element("//span[contains(text(),'"+fundName+"')]").click();
	}
	public void ValidateFunds() {
		String asOfDate = getAsOfDateSG();
		List<WebElement> allFunds = help.get_elements(SG_ALLFUNDS);
		int i = 1;
		int totalFunds = allFunds.size();
		for (WebElement eachFund : allFunds) {
			String fundname = eachFund.getText();
			System.out.println(fundname);
			String navValue = "";
			if(i<totalFunds) {
				navValue = help.get_element_text("//tbody//tr["+i+"]//td[5]");
				System.out.println(navValue);
				i++;
			}
			page.us_fund_finder_page.validateNAV(navValue);
			eachFund.click();
			Assert.assertTrue(driver.getTitle().contains(fundname));
			page.sg_fund_details_page.validateNavValue(navValue);
			page.sg_fund_details_page.validateAsOfDate(asOfDate);
			driver.navigate().back();
		}
	}
	
	public void validateIndividualFunds(String fundName) {
		YTDvalue = help.get_element_text("//a[contains(text(),'"+fundName+"')]/ancestor::td/following-sibling::td[4]");
		OneYearValue = help.get_element_text("//a[contains(text(),'"+fundName+"')]/ancestor::td/following-sibling::td[5]");
		ThreeYearValue = help.get_element_text("//a[contains(text(),'"+fundName+"')]/ancestor::td/following-sibling::td[6]");
		FiveYearValue = help.get_element_text("//a[contains(text(),'"+fundName+"')]/ancestor::td/following-sibling::td[7]");
		TenYearValue = help.get_element_text("//a[contains(text(),'"+fundName+"')]/ancestor::td/following-sibling::td[8]");
		SinceInceptionValue = help.get_element_text("//a[contains(text(),'"+fundName+"')]/ancestor::td/following-sibling::td[9]");
		INCEPTION_DATE = help.get_element_text("//a[contains(text(),'"+fundName+"')]/ancestor::td/following-sibling::td[10]");
		
		System.out.println(YTDvalue);
		System.out.println(OneYearValue);
		System.out.println(ThreeYearValue);
		System.out.println(FiveYearValue);
		System.out.println(TenYearValue);
		System.out.println(SinceInceptionValue);
		System.out.println(INCEPTION_DATE);
		
		clickOnCalenderData();
		wait_element_tobe_clickable("//a[contains(text(),'"+fundName+"')]");
		DATA_2018 = help.get_element_text("//a[contains(text(),'"+fundName+"')]/ancestor::td/following-sibling::td[4]");
		DATA_2019 = help.get_element_text("//a[contains(text(),'"+fundName+"')]/ancestor::td/following-sibling::td[5]");
		DATA_2020 = help.get_element_text("//a[contains(text(),'"+fundName+"')]/ancestor::td/following-sibling::td[6]");
		DATA_2021 = help.get_element_text("//a[contains(text(),'"+fundName+"')]/ancestor::td/following-sibling::td[7]");
		DATA_2022 = help.get_element_text("//a[contains(text(),'"+fundName+"')]/ancestor::td/following-sibling::td[8]");
		DATA_YTD = help.get_element_text("//a[contains(text(),'"+fundName+"')]/ancestor::td/following-sibling::td[9]");
		
		System.out.println(DATA_2018);
		System.out.println(DATA_2019);
		System.out.println(DATA_2020);
		System.out.println(DATA_2021);
		System.out.println(DATA_2022);
		System.out.println(DATA_YTD);
		
		help.get_element("//a[contains(text(),'"+fundName+"')]").click();
		
		
	}

}
