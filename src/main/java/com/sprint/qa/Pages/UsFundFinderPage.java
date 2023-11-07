package com.sprint.qa.Pages;

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
	
	public static String MutualFundVehicle = "//ul[contains(@class,'VehicleTabs')]//span[contains(text(),'Mutual Funds')]";
	public static String Daily_Pricing_and_Yields = "//span[@title='Daily Pricing and Yields']";
	public static String allFunds = "//tbody[contains(@class,'Table_table-rows-container')]//a";
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
	
	public UsFundFinderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, true);
	}
	
	public void clickOnAssetClassDD()
	{
		help.wait_element_tobe_clickable(getAssetClassDD());
		getAssetClassDD().click();
	}
	public void selectEquitiesFromDD()
	{
		help.wait_element_tobe_clickable(getEquities());
		getEquities().click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void selectFixedIncomeFromDD()
	{
		help.wait_element_tobe_clickable(getFixedIncome());
		getFixedIncome().click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clickOnResetFilters() {
		getResetFilter().click();
	}
	
	public void vefifyEquities()
	{
		wait_element_tobe_displayed(getFundLoad());
		List<WebElement> header = getTickerVerification();
		for (WebElement head : header) {
			String assetClass = head.getText();
			Assert.assertTrue(assetClass.contains("EQUITIES"));
		}
	}
	public void vefifyFIXED_INCOME()
	{
		wait_element_tobe_displayed(getFundLoad());
		List<WebElement> header = getTickerVerification();
		for (WebElement head : header) {
			String assetClass = head.getText();	
			System.out.println(assetClass);
			Assert.assertTrue(assetClass.contains("FIXED INCOME"));
		}
	}
	public void vefifyMULTI_ASSET()
	{
		wait_element_tobe_displayed(getFundLoad());
		List<WebElement> header = getTickerVerification();
		for (WebElement head : header) {
			String assetClass = head.getText();
			System.out.println(assetClass);
			Assert.assertTrue(assetClass.contains("MULTI-ASSET"));
		}
	}
	public void vefifyALTERNATIVES()
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
	
	/**
	 * Common methods 
	 */
	public void validateFunds()
	{
		String as_Of_date = getAsOfDate();
		String parent = driver.getWindowHandle();
		List<WebElement> funds = help.get_elements(allFunds);
		for (WebElement fund : funds) {
			help.switchWindow(parent);
			scrollintoview(fund);
			String fundName = fund.getText();
			String NAV_value = getNAVdata(fundName);
			fund.click();
			help.switchWindowFDpage(fundName);
			page.us_fund_details_page.validateAsOfDate(as_Of_date);
			page.us_fund_details_page.validateNAV(NAV_value);
			page.us_fund_details_page.clickOnOverview();
			page.us_fund_details_page.clickOnPerformance();
			driver.close();
		}
	}
	
	public void validateIndividualFunds(String FundName)
	{
		String as_Of_date = getAsOfDate();
		String parent = driver.getWindowHandle();
		WebElement fund = help.get_element("//tbody[contains(@class,'Table_table-rows-container')]//a[contains(text(),'"+FundName+"')]");
			help.switchWindow(parent);
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
			
			// Holdings Tab
			page.us_fund_details_page.clickOnHoldings();
			
			// Literature Tab
			page.us_fund_details_page.clickOnLiterature();
			driver.close();
	}
	
	public void validateETFFunds()
	{
		String as_Of_date = getAsOfDate();
		String parent = driver.getWindowHandle();
		List<WebElement> funds = help.get_elements(allFunds);
		for (WebElement fund : funds) {
			help.switchWindow(parent);
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
		}
	}
	

}
