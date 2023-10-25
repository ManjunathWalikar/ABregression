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
//		ele.click();
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
			page.us_fund_details_page.clickOnOverview();
			page.us_fund_details_page.clickOnPerformance();
			driver.close();
	}
	

}
