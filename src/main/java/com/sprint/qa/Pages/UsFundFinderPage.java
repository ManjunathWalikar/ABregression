package com.sprint.qa.Pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	@FindBy(xpath = "//ul[contains(@class,'VehicleTabs')]//span[contains(text(),'Mutual Funds')]")
	private WebElement MutualFund;
	
	@FindBy(xpath = "//ul[contains(@class,'VehicleTabs')]//span[contains(text(),'SMAs')]")
	private WebElement SMAS;
	
	public UsFundFinderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, true);
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
//			page.us_fund_details_page.clickOnMonthEndAsOf();
//			page.us_fund_details_page.clickOnQuarterEndAsOf();
			
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
