package com.sprint.qa.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.sprint.qa.base.TestBase;
import com.sprint.qa.helper.Helper;
import com.sprint.qa.helper.LoggerHelper;

public class SgFundDetailsPage extends TestBase {
	
	Logger log = LoggerHelper.getLogger(LoggerHelper.class);
	Helper help =new Helper();
	
	public static String SG_NAV_VALUE = "(//div[contains(@class,'header-section-value')])[2]"; 	
	public static String SG_AS_OF_DATE = "(//p[contains(@class,'header-section-date')])[1]";
	public static String CALENDER_YEAR_PERFORMANCE = "//*[@id='ppCal']";
	public static String ANNUAL_PERFORMANCE = "//*[@id='ppAnnual']";
	public static String FUND_FACTS_VEHICLE = "//*[@id='jnFacts']";
	public static String FUND_INCEPTION_DATE = "//td[contains(text(),'Fund Inception Date')]/following-sibling::td[contains(@class,'ab-table-right')]";
	public static String Distribution_Table = "//div[contains(@id,'fund-detail-yield-distribution')]//div[contains(@id,'highcharts')]";
	public static String PORTFOLIO_COMPOSITION = "//*[@id='jnComposition']";
	public static String RISKS_VEHICLE = "//*[@id='jnRisks']";
	public static String CLEAR_ALL_FILTERS = "//*[contains(text(),'Clear All Filters')]";
	public static String UNHEDGED_TYPE = "//*[contains(@id,'CurrencyType/Unhedged')]";
	
	
	
	public String getNavValue() {
		return help.get_element_text(SG_NAV_VALUE);
	}
	public String getAsOFDate() {
		return help.get_element_text(SG_AS_OF_DATE);
	}
	public WebElement getCalenderYear() {
		return help.get_element(CALENDER_YEAR_PERFORMANCE);
	}
	public WebElement getFundFacts() {
		return help.get_element(FUND_FACTS_VEHICLE);
	}
	public String getFundInceptionDate() {
		return help.get_element_text(FUND_INCEPTION_DATE);
	}
	public WebElement getDistributionTable() {
		return help.get_element(Distribution_Table);
	}
	public WebElement getPortfolioComposition() {
		return help.get_element(PORTFOLIO_COMPOSITION);
	}
	public WebElement getRisksVehicle() {
		return help.get_element(RISKS_VEHICLE);
	}
	public WebElement getClearAllFilters() {
		return help.get_element(CLEAR_ALL_FILTERS);
	}
	public WebElement getUnhedged() {
		return help.get_element(UNHEDGED_TYPE);
	}
	public WebElement getAnnualPerformance() {
		return help.get_element(ANNUAL_PERFORMANCE);
	}
	
	public SgFundDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, true);
	}
	public void clickOnRiskVehicle() {
		getRisksVehicle().click();
	}
	public void clickOnUnhedged() {
		getUnhedged().click();
	}
	public void clickOnClearAllFilters() {
		getClearAllFilters().click();
	}
	public void ValidateFundInceptionDate() {
		Assert.assertTrue(getFundInceptionDate().contains(SgFundFinderPage.INCEPTION_DATE));
	}
	public void ValidateDistributionTable() {
		wait_element_tobe_displayed(getDistributionTable());
		Assert.assertTrue(getDistributionTable().isDisplayed());
	}
	public void clickOnAnnualPerformance() {
		getAnnualPerformance().click();
	}
	public void clickOnFundFactVehicle() {
		getFundFacts().click();
	}
	public void clickOnPortfolioComposition() {
		getPortfolioComposition().click();
	}
	
	public void clickOnCalenderYearPerformance() {
		getCalenderYear().click();
	}
	
	public void validateNavValue(String navValue) {
		System.out.println(getNavValue());
		Assert.assertTrue(getNavValue().contains(navValue));
	}
	public void validateAsOfDate(String date) {
		Assert.assertTrue(getAsOFDate().contains(date));
	}
	public void validateAnnualPerformanceData() {
		help.get_element("//td[contains(text(),'Charges Applied')]").click();
		String YTD = help.get_element_text("//td[contains(text(),'Charges Applied')]/following-sibling::td[1]");
		String OneYear = help.get_element_text("//td[contains(text(),'Charges Applied')]/following-sibling::td[2]");
		String ThreeYear = help.get_element_text("//td[contains(text(),'Charges Applied')]/following-sibling::td[3]");
		String FiveYear = help.get_element_text("//td[contains(text(),'Charges Applied')]/following-sibling::td[4]");
		String TenYear = help.get_element_text("//td[contains(text(),'Charges Applied')]/following-sibling::td[5]");
		String SinceInceptionData = help.get_element_text("//td[contains(text(),'Charges Applied')]/following-sibling::td[6]");
		
		System.out.println(YTD);
		System.out.println(OneYear);
		System.out.println(ThreeYear);
		System.out.println(FiveYear);
		System.out.println(TenYear);
		System.out.println(SinceInceptionData);
		
			Assert.assertTrue(YTD.contains(SgFundFinderPage.YTDvalue));
			Assert.assertTrue(OneYear.contains(SgFundFinderPage.OneYearValue));
			Assert.assertTrue(ThreeYear.contains(SgFundFinderPage.ThreeYearValue));
			Assert.assertTrue(FiveYear.contains(SgFundFinderPage.FiveYearValue));
			Assert.assertTrue(TenYear.contains(SgFundFinderPage.TenYearValue));
			Assert.assertTrue(SinceInceptionData.contains(SgFundFinderPage.SinceInceptionValue));
	}
	public void validateCalenderYearPerformanceData(String fundName) {
		help.get_element("//td[contains(text(),'AB All Market Income Portfolio')]").click();
		String Calender2018 = help.get_element_text("//td[contains(text(),'"+fundName+"')]/following-sibling::td[1]");
		String Calender2019 = help.get_element_text("//td[contains(text(),'"+fundName+"')]/following-sibling::td[2]");
		String Calender2020 = help.get_element_text("//td[contains(text(),'"+fundName+"')]/following-sibling::td[3]");
		String Calender2021 = help.get_element_text("//td[contains(text(),'"+fundName+"')]/following-sibling::td[4]");
		String Calender2022 = help.get_element_text("//td[contains(text(),'"+fundName+"')]/following-sibling::td[5]");
		String CalenderYTD = help.get_element_text("//td[contains(text(),'"+fundName+"')]/following-sibling::td[6]");
		
		Assert.assertTrue(Calender2018.contains(SgFundFinderPage.DATA_2018));
		Assert.assertTrue(Calender2019.contains(SgFundFinderPage.DATA_2019));
		Assert.assertTrue(Calender2020.contains(SgFundFinderPage.DATA_2020));
		Assert.assertTrue(Calender2021.contains(SgFundFinderPage.DATA_2021));
		Assert.assertTrue(Calender2022.contains(SgFundFinderPage.DATA_2022));
		Assert.assertTrue(CalenderYTD.contains(SgFundFinderPage.DATA_YTD));
		
	}
	public void validateAnnualPerformanceDataforUnhedged() {
		help.get_element("//td[contains(text(),'Charges Applied')]").click();
		String INCEPTIONDATE = help.get_element_text("//td[contains(text(),'Charges Applied')]/following-sibling::td[1]");
		String YTD = help.get_element_text("//td[contains(text(),'Charges Applied')]/following-sibling::td[2]");
		String OneYear = help.get_element_text("//td[contains(text(),'Charges Applied')]/following-sibling::td[3]");
		String ThreeYear = help.get_element_text("//td[contains(text(),'Charges Applied')]/following-sibling::td[4]");
		String FiveYear = help.get_element_text("//td[contains(text(),'Charges Applied')]/following-sibling::td[5]");
		String TenYear = help.get_element_text("//td[contains(text(),'Charges Applied')]/following-sibling::td[6]");
		String SinceInceptionData = help.get_element_text("//td[contains(text(),'Charges Applied')]/following-sibling::td[7]");
		
		System.out.println(YTD);
		System.out.println(OneYear);
		System.out.println(ThreeYear);
		System.out.println(FiveYear);
		System.out.println(TenYear);
		System.out.println(SinceInceptionData);
		
		Assert.assertTrue(INCEPTIONDATE.contains(SgFundFinderPage.INCEPTION_DATE));
		Assert.assertTrue(YTD.contains(SgFundFinderPage.YTDvalue));
		Assert.assertTrue(OneYear.contains(SgFundFinderPage.OneYearValue));
		Assert.assertTrue(ThreeYear.contains(SgFundFinderPage.ThreeYearValue));
		Assert.assertTrue(FiveYear.contains(SgFundFinderPage.FiveYearValue));
		Assert.assertTrue(TenYear.contains(SgFundFinderPage.TenYearValue));
		Assert.assertTrue(SinceInceptionData.contains(SgFundFinderPage.SinceInceptionValue));
	}
	public void validateCalenderYearPerformanceDataforUnhedged(String fundName) {
		help.get_element("//td[contains(text(),'AB All Market Income Portfolio')]").click();
		String Calender2018 = help.get_element_text("//td[contains(text(),'"+fundName+"')]/following-sibling::td[2]");
		String Calender2019 = help.get_element_text("//td[contains(text(),'"+fundName+"')]/following-sibling::td[3]");
		String Calender2020 = help.get_element_text("//td[contains(text(),'"+fundName+"')]/following-sibling::td[4]");
		String Calender2021 = help.get_element_text("//td[contains(text(),'"+fundName+"')]/following-sibling::td[5]");
		String Calender2022 = help.get_element_text("//td[contains(text(),'"+fundName+"')]/following-sibling::td[6]");
		String CalenderYTD = help.get_element_text("//td[contains(text(),'"+fundName+"')]/following-sibling::td[7]");
		
		Assert.assertTrue(Calender2018.contains(SgFundFinderPage.DATA_2018));
		Assert.assertTrue(Calender2019.contains(SgFundFinderPage.DATA_2019));
		Assert.assertTrue(Calender2020.contains(SgFundFinderPage.DATA_2020));
		Assert.assertTrue(Calender2021.contains(SgFundFinderPage.DATA_2021));
		Assert.assertTrue(Calender2022.contains(SgFundFinderPage.DATA_2022));
		Assert.assertTrue(CalenderYTD.contains(SgFundFinderPage.DATA_YTD));
		
	}

}
