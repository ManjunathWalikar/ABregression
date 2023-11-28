package com.sprint.qa.Pages;

import static org.junit.Assert.assertTrue;

import java.awt.event.KeyEvent;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.sprint.qa.base.PageObjects;
import com.sprint.qa.base.TestBase;
import com.sprint.qa.helper.Helper;
import com.sprint.qa.helper.LoggerHelper;

public class UsFundFinderPage extends TestBase{
	Logger log = LoggerHelper.getLogger(LoggerHelper.class);
	Helper help =new Helper();
	final static String EQUITY_CORE_and_GLOBAL = "11";
	final static String TOTAL_MUTUAL_FUNDS_COUNT = "56";
	
	public static String MutualFundVehicle = "//ul[contains(@class,'VehicleTabs')]//span[contains(text(),'Mutual Funds')]";
	public static String Daily_Pricing_and_Yields = "//span[@title='Daily Pricing and Yields']";
	public static String allFunds = "//*[contains(@class,'Table_table-rows-container')]//a";
	public static String AF_OF_DATE = "//p[contains(@class,'asOf')]";
	public static String ETFFundVehicle = "//ul[contains(@class,'VehicleTabs')]//span[contains(text(),'ETFs')]";
	public static String ASSETCLASSDD = "//div[contains(text(),'Asset Class')]";
	public static String EQUITIES = "//span[contains(text(),'Equities')]";
	public static String FIXED_INCOME = "//span[contains(text(),'Fixed Income')]";
	public static String MULTI_ASSET = "//span[contains(text(),'Multi-Asset')]";
	public static String ALTERNATIVES = "//span[contains(text(),'Alternatives')]";
	public static String RESET_FILTERS_BTN = "//button[contains(text(),'Reset Filters')]";
	public static String TICKER_VERIFICATION = "//span[contains(@class,'FundNameCell_eyebrow-text')]";
	public static String FundLoad = "//div[contains(@class,'Performance_performance')]";
	public static String SHOW_RESULTS = "//span[contains(@class,'ShowResults_desktop')]//strong";
	public static String STYLES_DD = "//div[contains(text(),'Styles')]";
	public static String Equity_Core_DD = "//span[contains(text(),'Equity: Core')]";
	public static String REGION_DD = "//div[contains(text(),'Region')]";
	public static String Global = "//span[contains(text(),'Global')]";
	public static String SHARECLASS_DD = "//div[contains(text(),'Advisor')]|//div[contains(text(),'Share Class')]";
	public static String Advisor = "//span[contains(text(),'Advisor')]";
	public static String LITERATURE = "//span[contains(text(),'Literature')]";
	public static String PERFORMANCE = "//span[contains(text(),'Performance')]";
	public static String QUARTER_END_AS_OF = "//span[contains(text(),'Quarter End as of')]";
	public static String MONTH_END_AS_OF = "//span[contains(text(),'Month End as of')]";
	public static String BENCHMARK_DATA = "//div[contains(@data-testid,'benchmark-data-0')]";
	public static String SHOW_BENCHMARK = "//span[contains(text(),'Show Benchmarks')]";
	public static String HIDE_BENCHMARK ="//span[contains(text(),'Hide Benchmarks')]";
	public static String QUICK_VIEW = "//button[contains(@class,'ExpandableTableRow_expand-row')]";
	public static String Fees_and_Expenses = "//h4[contains(text(),'Fees & Expenses')]";
	public static String FUND_SEARCH = "//input[@id='fund-search']";
	public static String SMAS_VEHICLE = "//ul[contains(@class,'VehicleTabs')]//span[contains(text(),'SMAs')]";
	public static String MODEL_PORTFOLIOS_VEHICLE = "//ul[contains(@class,'VehicleTabs')]//span[contains(text(),'Model Portfolios')]";
	public static String CLOSED_END_FUND_VEHICLE = "//ul[contains(@class,'VehicleTabs')]//span[contains(text(),'Closed-End Funds')]";
	public static String VERIABLE_PRODUCT_SERIES = "//ul[contains(@class,'VehicleTabs')]//span[contains(text(),'Variable Product Series')]";
	
	@FindBy(xpath = "//ul[contains(@class,'VehicleTabs')]//span[contains(text(),'Mutual Funds')]")
	private WebElement MutualFund;
	
	@FindBy(xpath = "//ul[contains(@class,'VehicleTabs')]//span[contains(text(),'SMAs')]")
	private WebElement SMAS;
	
	public WebElement getAssetClassDD()
	{
		return help.get_element(ASSETCLASSDD);
	}
	public WebElement getEquities() {
		return help.get_element(EQUITIES);
	}
	public WebElement getFixedIncome()
	{
		return help.get_element(FIXED_INCOME);
	}
	public WebElement getMultiAsset()
	{
		return help.get_element(MULTI_ASSET);
	}
	public WebElement getAlternatives()
	{
		return help.get_element(ALTERNATIVES);
	}
	public WebElement getResetFilter()
	{
		return help.get_element(RESET_FILTERS_BTN);
	}
	public List<WebElement> getTickerVerification()
	{
		return help.get_elements(TICKER_VERIFICATION);
	}
	public WebElement getFundLoad()
	{
		return help.get_element(FundLoad);
	}
	public WebElement showResults()
	{
		return help.get_element(SHOW_RESULTS);
	}
	public WebElement getStylesDD()
	{
		return help.get_element(STYLES_DD);
	}
	public WebElement getEquityCoreDD() {
		return help.get_element(Equity_Core_DD);
	}
	public WebElement getRegionDD() {
		return help.get_element(REGION_DD);
	}
	public WebElement getGlobalFromRegionDD() {
		return help.get_element(Global);
	}
	public WebElement getShareClassDD() {
		return help.get_element(SHARECLASS_DD);
	}
	public WebElement getAdvisorFromShareClassDD() {
		return help.get_element(Advisor);
	}
	public WebElement getDailyPricingAndYields()
	{
		return help.get_element(Daily_Pricing_and_Yields);
	}
	public WebElement getFunds()
	{
		return help.get_element(allFunds);
	}
	public WebElement getLiterature() {
		return help.get_element(LITERATURE);
	}
	public WebElement getPerformance() {
		return help.get_element(PERFORMANCE);
	}
	public WebElement getQuarterEndAsOf() {
		return help.get_element(QUARTER_END_AS_OF);
	}
	public WebElement getMonthEndAsOf() {
		return help.get_element(MONTH_END_AS_OF);
	}
	public WebElement getShowBenchMark() {
		return help.get_element(SHOW_BENCHMARK);
	}
	public WebElement getHideBenchMark() {
		return help.get_element(HIDE_BENCHMARK);
	}
	public WebElement getBenchMarkData() {
		return help.get_element(BENCHMARK_DATA);
	}
	public WebElement getQuickViewIcon() {
		return help.get_element(QUICK_VIEW);
	}
	public WebElement getFeesAndExpenses() {
		return help.get_element(Fees_and_Expenses);
	}
	public WebElement getFundSearch() {
		return help.get_element(FUND_SEARCH);
	}
	public WebElement getSMAvehicle() {
		return help.get_element(SMAS_VEHICLE);
	}
	public WebElement getModelPortfolio() {
		return help.get_element(MODEL_PORTFOLIOS_VEHICLE);
	}
	public WebElement getClosedEndFund() {
		return help.get_element(CLOSED_END_FUND_VEHICLE);
	}
	public WebElement getVeriableProductSeriesFund() {
		return help.get_element(VERIABLE_PRODUCT_SERIES);
	}
	
	/*
	 * Initialization
	 */
	public UsFundFinderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, true);
	}
	
	/**
	 * Utilization
	 */
	public void clickOnVeriableProductSeriesFund() {
		getVeriableProductSeriesFund().click();
	}
	
	public void clickOnClosedEndFund() {
		getClosedEndFund().click();
	}
	public void clickOnModelPortFolio() {
		getModelPortfolio().click();
	}
	public void clickOnSMAS() {
		getSMAvehicle().click();
	}
	public void searchFund(String fund)
	{
		getFundSearch().sendKeys(fund);
		help.get_element("//span[contains(text(),'"+fund+"')]").click();
	}
	public void validateFDpage(String fund) {
		try {
			Thread.sleep(10000);
			String title = driver.getTitle();
			System.out.println(title);
			Assert.assertTrue(title.contains(fund));
			driver.navigate().back();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void validateFFAsOfDate() {
		int currentDate = date.getDate();
		int day = date.getDay();
		int asofdate = 0;
		if(day==1)
		{
			asofdate = currentDate-3;
		}
		else if (day==6) {
			asofdate = currentDate-1;
		}
		else if (day==7) {
			asofdate = currentDate-2;
		}
		else
		{
			asofdate = currentDate-1;
		}
		String updatedDate = ""+asofdate+"";
		Assert.assertTrue(getAsOfDate().contains(updatedDate));
	}
	public void verifyQuickViewOfFunds() {
		getQuickViewIcon().click();
			Assert.assertTrue(getFeesAndExpenses().isDisplayed());
			getQuickViewIcon().click();
	}
	public void clickOnShowBenchmark() {
		wait_element_tobe_clickable(getShowBenchMark());
		getShowBenchMark().click();
	}
	public void clickOnHideBenchmark() {
		wait_element_tobe_clickable(getHideBenchMark());
		getHideBenchMark().click();
	}
	public void verifyBenchMarkData() {
		wait_element_tobe_displayed(getBenchMarkData());
		Assert.assertTrue(getBenchMarkData().isDisplayed());
	}
	
	public void clickOnMonthEndAsOf() {
		wait_element_tobe_clickable(getMonthEndAsOf());
		getMonthEndAsOf().click();
	}
	public void clickOnQuarterEndAsOf() {
		wait_element_tobe_clickable(getQuarterEndAsOf());
		getQuarterEndAsOf().click();
	}
	public void verifyFunds()
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		wait_element_tobe_displayed(getFunds());
		Assert.assertTrue(getFunds().isDisplayed());
	}
	public void clickOnPerformance()
	{
		wait_element_tobe_clickable(getPerformance());
		getPerformance().click();
	}
	public void clickOnLiterature()
	{
		wait_element_tobe_clickable(getLiterature());
		getLiterature().click();
	}
	public void clickOnDailyPricingAndYields()
	{
		wait_element_tobe_clickable(getDailyPricingAndYields());
		getDailyPricingAndYields().click();
	}
	public void verifyMutualFundCount() {
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		wait_element_tobe_clickable(allFunds);
		String mutualFundCount = showResults().getText();
		System.out.println(mutualFundCount);
		Assert.assertTrue(mutualFundCount.equals(TOTAL_MUTUAL_FUNDS_COUNT));
	}
	public void verifyEquityCoreandGlobal()
	{
		String equityCore = showResults().getText();
		Assert.assertTrue(equityCore.equals(EQUITY_CORE_and_GLOBAL));
	}
	public void clickOnAssetClassDD()
	{
		help.wait_element_tobe_clickable(getAssetClassDD());
		getAssetClassDD().click();
	}
	public void clickOnStylesDD()
	{
		help.wait_element_tobe_clickable(getStylesDD());
		getStylesDD().click();
	}
	public void clickOnRegionDD()
	{
		help.wait_element_tobe_clickable(getRegionDD());
		getRegionDD().click();
	}
	public void clickOnShareClassDD()
	{
		help.wait_element_tobe_clickable(getShareClassDD());
		getShareClassDD().click();
	}
	public void selectAdvisorFromShareClassDD()
	{
		help.wait_element_tobe_clickable(getAdvisorFromShareClassDD());
		getAdvisorFromShareClassDD().click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void selectGlobalFromRegionDD()
	{
		help.wait_element_tobe_clickable(getGlobalFromRegionDD());
		getGlobalFromRegionDD().click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void selectEquityCoreFromDD()
	{
		help.wait_element_tobe_clickable(getEquityCoreDD());
		getEquityCoreDD().click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void selectEquitiesFromDD()
	{
		help.wait_element_tobe_clickable(getEquities());
		getEquities().click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void selectFixedIncomeFromDD()
	{
		help.wait_element_tobe_clickable(getFixedIncome());
		getFixedIncome().click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void selectMultiAssetFromDD()
	{
		help.wait_element_tobe_clickable(getMultiAsset());
		getMultiAsset().click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void selectAlternativesFromDD()
	{
		help.wait_element_tobe_clickable(getAlternatives());
		getAlternatives().click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickOnResetFilters() {
		getResetFilter().click();
	}
	
	public void verifyEquities()
	{
		wait_element_tobe_displayed(getFundLoad());
		List<WebElement> header = getTickerVerification();
		for (WebElement head : header) {
			String assetClass = head.getText();
			Assert.assertTrue(assetClass.contains("EQUITIES"));
		}
	}
	public void verifyFIXED_INCOME()
	{
		wait_element_tobe_displayed(getFundLoad());
		List<WebElement> header = getTickerVerification();
		for (WebElement head : header) {
			String assetClass = head.getText();	
			Assert.assertTrue(assetClass.contains("FIXED INCOME"));
		}
	}
	public void verifyMULTI_ASSET()
	{
		wait_element_tobe_displayed(getFundLoad());
		List<WebElement> header = getTickerVerification();
		for (WebElement head : header) {
			String assetClass = head.getText();
			Assert.assertTrue(assetClass.contains("MULTI-ASSET"));
		}
	}
	public void verifyALTERNATIVES()
	{
		wait_element_tobe_displayed(getFundLoad());
		List<WebElement> header = getTickerVerification();
		for (WebElement head : header) {
			String assetClass = head.getText();
			Assert.assertTrue(assetClass.contains("ALTERNATIVES"));
		}
	}
	
	public void clickOnMutualFund() {
		WebElement mfv = help.get_element(MutualFundVehicle);
		scrollintoview(mfv);
		WebElement dpy =help.get_element(Daily_Pricing_and_Yields);
		scrollintoview(dpy);
		dpy.click();
	}
	
	public void clickOnETFFund() {
		WebElement etf = help.get_element(ETFFundVehicle);
		scrollandclick(etf);
		WebElement dpy =help.get_element(Daily_Pricing_and_Yields);
		scrollintoview(dpy);
		dpy.click();
	}
	
	
	public void clickOnSMAs() {
		SMAS.click();
	}
	public String getAsOfDate()
	{
		String asOfDate = help.get_element(AF_OF_DATE).getText();
		return asOfDate;
	}
	
	public String getNAVdata(String fundName)
	{
		return help.get_element("//tbody[contains(@class,'Table_table-rows-container')]//a[contains(text(),'"+fundName+"')]/../following-sibling::p[2]").getText();
	}
	
	public String getETFNAVdata(String fundName)
	{
		return help.get_element("//tbody[contains(@class,'Table_table-rows-container')]//a[contains(text(),'"+fundName+"')]/../following-sibling::p[3]").getText();
	}
	public void clickOnGivenFund(String fundName)
	{
		 help.get_element("//tbody[contains(@class,'Table_table-rows-container')]//a[contains(text(),'"+fundName+"')]").click();
	}
	
	/**
	 * Common methods 
	 */
	public void validateNAV(String nav) {
		int navValue = Integer.parseInt(nav);
		if(navValue<0) {
			Assert.fail();
		}
	}
	public void validateFunds()
	{
		String as_Of_date = getAsOfDate();
		String parent = driver.getWindowHandle();
		List<WebElement> funds = help.get_elements(allFunds);
		for (WebElement fund : funds) {
//			help.switchWindow(parent);
			scrollintoview(fund);
			String fundName = fund.getText();
			String NAV_value = getNAVdata(fundName);
			validateNAV(NAV_value);
			fund.click();
			help.switchWindowFDpage(fundName);
			page.us_fund_details_page.validateAsOfDate(as_Of_date);
			page.us_fund_details_page.validateNAV(NAV_value);
			page.us_fund_details_page.clickOnOverview();
			page.us_fund_details_page.clickOnPerformance();
			driver.close();
			help.switchWindow(parent);
		}
	}
	public void validateSMASFunds()
	{
		String parent = driver.getWindowHandle();
		List<WebElement> funds = help.get_elements(allFunds);
		for (WebElement fund : funds) {
//			help.switchWindow(parent);
			scrollintoview(fund);
			String fundName = fund.getText();
			fund.click();
			help.switchWindowFDpage(fundName);
			page.us_fund_details_page.clickOnOverview();
			// Literature Tab
			page.us_fund_details_page.clickOnLiterature();
			driver.close();
			help.switchWindow(parent);
		}
	}
	public void validateClosedEndFunds()
	{
		String parent = driver.getWindowHandle();
		List<WebElement> funds = help.get_elements(allFunds);
		for (WebElement fund : funds) {
//			help.switchWindow(parent);
			String fundName = fund.getText();
			fund.click();
			help.switchWindowFDpage(fundName);
			page.us_fund_details_page.clickOnOverview();
			page.us_fund_details_page.verifyKeyFacts();
			
			// Performance Tab
			page.us_fund_details_page.clickOnPerformance();
			page.us_fund_details_page.verifyHypotheticalGrowth();
			page.us_fund_details_page.verifyNavHistoryChart();
			
			// Yields and Distribution Tab
			page.us_fund_details_page.clickOnYields();
			
			// Holdings Tab
			page.us_fund_details_page.clickOnHoldings();
			
			// Literature Tab
			page.us_fund_details_page.clickOnLiterature();
			driver.close();
			help.switchWindow(parent);
		}
	}
	public void validateVeriableProductSeriesFunds()
	{
		String parent = driver.getWindowHandle();
		List<WebElement> funds = help.get_elements(allFunds);
		for (WebElement fund : funds) {
//			help.switchWindow(parent);
			String fundName = fund.getText();
			fund.click();
			help.switchWindowFDpage(fundName);
			try {
				page.us_fund_details_page.clickOnOverview();
				page.us_fund_details_page.verifyKeyFacts();
				
				// Performance Tab
				page.us_fund_details_page.clickOnPerformance();
				page.us_fund_details_page.verifyHypotheticalGrowth();
				page.us_fund_details_page.verifyNavHistoryChart();
				
				// Holdings Tab
				page.us_fund_details_page.clickOnHoldings();
							
				// Literature Tab
				page.us_fund_details_page.clickOnLiterature();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			driver.close();
			help.switchWindow(parent);
		}
	}
	
	public void validateIndividualFunds(String FundName)
	{
		String as_Of_date = getAsOfDate();
		String parent = driver.getWindowHandle();
		WebElement fund = help.get_element("//tbody[contains(@class,'Table_table-rows-container')]//a[contains(text(),'"+FundName+"')]");
//			help.switchWindow(parent);
			scrollintoview(fund);
			String NAV_value = getNAVdata(FundName);
			fund.click();
			help.switchWindowFDpage(FundName);
			page.us_fund_details_page.validateAsOfDate(as_Of_date);
			page.us_fund_details_page.validateNAV(NAV_value);
			// Over View Tab
			page.us_fund_details_page.clickOnOverview();
			page.us_fund_details_page.verifyKeyFacts();
			
			// Performance Tab
			page.us_fund_details_page.clickOnPerformance();
			page.us_fund_details_page.verifyDailyAsOfNavValue(NAV_value);
			page.us_fund_details_page.verifyHypotheticalGrowth();
			page.us_fund_details_page.verifyNavHistoryChart();
			
			// Yields and Distribution Tab
			page.us_fund_details_page.clickOnYields();
			page.us_fund_details_page.validateDistributionTable();
			
			// Holdings Tab
			page.us_fund_details_page.clickOnHoldings();
			
			// Literature Tab
			page.us_fund_details_page.clickOnLiterature();
			driver.close();
			help.switchWindow(parent);
	}
	
	public void validateETFFunds()
	{
		String as_Of_date = getAsOfDate();
		validateFFAsOfDate();
		String parent = driver.getWindowHandle();
		List<WebElement> funds = help.get_elements(allFunds);
		for (WebElement fund : funds) {
//			help.switchWindow(parent);
			scrollintoview(fund);
			String fundName = fund.getText();
			String NAV_value = getETFNAVdata(fundName);
			fund.click();
			help.switchWindowFDpage(fundName);
			page.us_fund_details_page.validateAsOfDate(as_Of_date);
			page.us_fund_details_page.validateETFNAV(NAV_value);


			page.us_fund_details_page.clickOnOverview();
			page.us_fund_details_page.verifyKeyFacts();
			
			// Performance Tab
			page.us_fund_details_page.clickOnPerformance();
			page.us_fund_details_page.verifyDailyAsOfNavValue(NAV_value);
			try {
				page.us_fund_details_page.verifyETFPreviousYearChart();
			} catch (Exception e) {
				System.out.println(fundName+" doesn't have Previous Year chart");
			}
			
			page.us_fund_details_page.verifyETFNavHistoryChart();
			
			// Yields and Distribution Tab
			try {
				page.us_fund_details_page.clickOnYields();
			} catch (Exception e) {
				System.out.println(fundName+" doesn't have Yield and Distribution");
			}
						
			// Holdings Tab
			page.us_fund_details_page.clickOnHoldings();
			
			// Literature Tab
			page.us_fund_details_page.clickOnLiterature();
			driver.close();
			help.switchWindow(parent);
		}
	}
	

}
