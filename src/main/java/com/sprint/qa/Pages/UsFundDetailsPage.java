package com.sprint.qa.Pages;

import java.util.Set;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sprint.qa.base.TestBase;
import com.sprint.qa.helper.Helper;
import com.sprint.qa.helper.LoggerHelper;

public class UsFundDetailsPage extends TestBase {
	Logger log = LoggerHelper.getLogger(LoggerHelper.class);
	Helper help =new Helper();
	
	public static String OVERVIEW_LINK ="//a[@id='jnOverview']";
	public static String PERFORMANCE_LINK ="//a[@id='jnPerformance']";
	public static String FD_AsOfDate = "(//div[@id='fund-detail-facts']//span[@class='abde-t-regular'])[1]";
	public static String FD_NAV_VALUE = "(//div[@id='fund-detail-facts']//p[@class='abde-t-bold'])[1]";
	public static String YIELD_and_DISTRIBUTION = "//a[@id='jnYield']";
	public static String HOLDINGS_LINK = "//a[@id='jnHoldings']";
	public static String LITERATURE_LINK = "//a[@id='jnLiterature']";
	public static String DAILY_AS_OF = "//span[contains(@title,'Daily As of')]";
	public static String MONTH_END_AS_OF = "//span[contains(@title,'Month End As of')]";
	public static String QUARTER_END_AS_OF = "//span[contains(@title,'Quarter End As of')]]";
	public static String KEY_FACTS = "//h3[contains(.,'Key Facts')]";
	public static String DAILY_AS_OF_NAV = "(//td[@data-testid='tableRow-0-data-0-'])[1]";
	public static String HYPOTHETICALGROWTH_1Month = "//div[contains(@class,'HypotheticalGrowth')]//span[@title='1 Month']";
	public static String HYPOTHETICALGROWTH_6Months = "//div[contains(@class,'HypotheticalGrowth')]//span[@title='6 Months']";
	public static String HYPOTHETICALGROWTH_1YEAR = "//div[contains(@class,'HypotheticalGrowth')]//span[@title='1 Year']";
	public static String HYPOTHETICALGROWTH_3YEARS = "//div[contains(@class,'HypotheticalGrowth')]//span[@title='3 Years']";
	public static String HYPOTHETICALGROWTH_5YEARS = "//div[contains(@class,'HypotheticalGrowth')]//span[@title='5 Years']";
	public static String HYPOTHETICALGROWTH_10YEARS = "//div[contains(@class,'HypotheticalGrowth')]//span[@title='10 Years']";
	public static String HYPOTHETICALGROWTH_MAX_RANGE = "//div[contains(@class,'HypotheticalGrowth')]//span[@title='Max Range']";
	public static String HypotheticalChart = "//div[contains(@class,'HypotheticalGrowth')]//div[contains(@id,'highchart')]";
	public static String ETF_PREMIUM_CHART = "//div[contains(@class,'PremiumDiscount_chart-container')]//div[contains(@id,'highcharts')]";
	public static String PREVIOUS_QUARTER_CHART = "//span[contains(text(),'Previous Quarter')]";
	public static String PREVIOUS_YEAR_CHART = "//span[text()='Previous Year']";
	public static String PREVIOUS_YEAR_TO_DATE_CHART = "//span[text()='Previous Year To Date']";
	public static String ETF_NAV_HISTORY_CHART = "//div[contains(@class,'NavHistory_chart-container')]//div[contains(@id,'highcharts')]";
	public static String NAVHISTORY_1MONTH = "//div[contains(@class,'NavHistory')]//span[@title='1 Month']";
	public static String NAVHISTORY_6MONTHS = "//div[contains(@class,'NavHistory')]//span[@title='6 Months']";
	public static String NAVHISTORY_1YEAR = "//div[contains(@class,'NavHistory')]//span[@title='1 Year']";
	public static String NAVHISTORY_3YEARS = "//div[contains(@class,'NavHistory')]//span[@title='3 Years']";
	public static String NAVHISTORY_5YEARS = "//div[contains(@class,'NavHistory')]//span[@title='5 Years']";
	public static String NAVHISTORY_10YEARS = "//div[contains(@class,'NavHistory')]//span[@title='10 Years']";
	public static String NAVHISTORY_MAXRANGE = "//div[contains(@class,'NavHistory')]//span[@title='Max Range']";
	public static String DISTRIBUTION_TABLE = "//th[contains(text(),'Distributions')]/ancestor::table";
	public static String HOLDINGS_TABLE = "//div[contains(@class,'HoldingsAndCharacteristics_chart-container')]";
	public static String SELECT_ALL_CHECKBOX_LITERATURE = "//label[contains(text(),'Select All')]";
	public static String DOCUMENTS_SELECTED_POPUP = " //p[contains(@class,'abde-t-regular')]";
	
	
	
	@FindBy(xpath = "//a[@id='jnOverview']")
	private WebElement OverviewLink;
	
	@FindBy(xpath = "//a[@id='jnPerformance']")
	private WebElement PerfornamceLink;
	
	public UsFundDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, true);
	}
	
	public WebElement getOverviewLink()
	{
		return OverviewLink;
	}
	
	public WebElement getPerformanceLink()
	{
		return PerfornamceLink;
	}
	public WebElement getAsOf()
	{
		return help.get_element(FD_AsOfDate);
	}
	public WebElement get_NAV_value()
	{
		return help.get_element(FD_NAV_VALUE);
	}
	
	public WebElement getHoldingsLink()
	{
		return help.get_element(HOLDINGS_LINK);
	}
	
	public WebElement getYieldsLink()
	{
		return help.get_element(YIELD_and_DISTRIBUTION);
	}
	
	public WebElement getLiteratureLink()
	{
		return help.get_element(LITERATURE_LINK);
	}
	
	public WebElement getDaiylAsOF()
	{
		return help.get_element(DAILY_AS_OF);
	}
	
	public WebElement getMonthEndAsOf()
	{
		return help.get_element(MONTH_END_AS_OF);
	}
	
	public WebElement getQuarterEndAsOf()
	{
		return help.get_element(QUARTER_END_AS_OF);
	}
	
	public WebElement getKeyFacts()
	{
		return help.get_element(KEY_FACTS);
	}
	
	public String getDailyAsOfNavValue()
	{
		return help.get_element_text(DAILY_AS_OF_NAV);
	}
	public WebElement getHypotheticalChart()
	{
		return help.get_element(HypotheticalChart);
	}
	
	public WebElement getEtfPremiumChart()
	{
		return help.get_element(ETF_PREMIUM_CHART);
	}
	
	public WebElement getEtfNavHistoryChart()
	{
		return help.get_element(ETF_NAV_HISTORY_CHART);
	}
	public WebElement getDistributionTable() {
		return help.get_element(DISTRIBUTION_TABLE);
	}
	public WebElement getHoldingsTable() {
		return help.get_element(HOLDINGS_TABLE);
	}
	public WebElement getSelectAllLiteratureCheckbox() {
		return help.get_element(SELECT_ALL_CHECKBOX_LITERATURE);
	}
	public WebElement getDocumentSelected() {
		return help.get_element(DOCUMENTS_SELECTED_POPUP);
	}
	/**
	 * Common methods 
	 */
	public void validateNAV(String FF_NAV)
	{
		help.wait_element_tobe_displayed(get_NAV_value());
		String FD_NAV = get_NAV_value().getText();
		System.out.println(FD_NAV);
		Assert.assertTrue(FD_NAV.contains(FF_NAV));
	}
	public void clickOnSelectAllLiteratureCheckbox() {
		try {
			getSelectAllLiteratureCheckbox().click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void validateDistributionTable() {
		try {
			wait_element_tobe_displayed(getDistributionTable());
			Assert.assertTrue(getDistributionTable().isDisplayed());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void validateDistributionTablePopup() {
		try {
			wait_element_tobe_displayed(getDocumentSelected());
			Assert.assertTrue(getDocumentSelected().isDisplayed());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void validateHoldingsTable() {
		try {
			Assert.assertTrue(getHoldingsTable().isDisplayed());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void validateETFNAV(String FF_NAV)
	{
		help.wait_element_tobe_displayed(get_NAV_value());
		String FD_NAV = get_NAV_value().getText();
		System.out.println(FF_NAV);
		System.out.println(FD_NAV);
		Assert.assertTrue(FD_NAV.contains(FF_NAV));
	}
	
	public void validateAsOfDate(String FFdate)
	{
		help.wait_element_tobe_displayed(getAsOf());
		String FDdate = getAsOf().getText();
		System.out.println(FDdate);
		Assert.assertTrue(FDdate.equalsIgnoreCase(FFdate));
	}
	public void clickOnOverview()
	{
		
		try {
//			scrollandclick(getOverviewLink());
//			Thread.sleep(2000);
			WebElement overview = help.get_element(OVERVIEW_LINK);
			scrollintoview(overview);
			help.wait_element_tobe_clickable(overview);
			overview.click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickOnPerformance()
	{
		
		try {
//			scrollandclick(getPerformanceLink());
//			Thread.sleep(3000);
			WebElement performance = help.get_element(PERFORMANCE_LINK);
			scrollintoview(performance);
			help.wait_element_tobe_clickable(performance);
			performance.click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void verifyKeyFacts()
	{
		Assert.assertTrue(getKeyFacts().isDisplayed());
	}
	
	public void verifyDailyAsOfNavValue(String Value)
	{
		System.out.println("Daily As Of Nav Value = "+getDailyAsOfNavValue());
		Assert.assertTrue(Value.contains(getDailyAsOfNavValue()));
	}
	
	public void verifyHypotheticalGrowth()
	{
			try {
				help.get_element(HYPOTHETICALGROWTH_1Month).click();
				Assert.assertTrue(getHypotheticalChart().isDisplayed());
			} catch (Exception e) {
				System.out.println("Hypothetical Graph of 1Month is not Displayed");
				e.printStackTrace();
			}
			try {
				help.get_element(HYPOTHETICALGROWTH_6Months).click();
				Assert.assertTrue(getHypotheticalChart().isDisplayed());
			} catch (Exception e) {
				System.out.println("Hypothetical Graph of 6Month is not Displayed");
				e.printStackTrace();
			}
			try {
				help.get_element(HYPOTHETICALGROWTH_1YEAR).click();
				Assert.assertTrue(getHypotheticalChart().isDisplayed());
			} catch (Exception e) {
				System.out.println("Hypothetical Graph of 1Year is not Displayed");
				e.printStackTrace();
			}
			try {
				help.get_element(HYPOTHETICALGROWTH_3YEARS).click();
				Assert.assertTrue(getHypotheticalChart().isDisplayed());
			} catch (Exception e) {
				System.out.println("Hypothetical Graph of 3Year is not Displayed");
				e.printStackTrace();
			}
			try {
				help.get_element(HYPOTHETICALGROWTH_5YEARS).click();
				Assert.assertTrue(getHypotheticalChart().isDisplayed());
			} catch (Exception e) {
				System.out.println("Hypothetical Graph of 5Year is not Displayed");
				e.printStackTrace();
			}
			try {
				help.get_element(HYPOTHETICALGROWTH_10YEARS).click();
				Assert.assertTrue(getHypotheticalChart().isDisplayed());
			} catch (Exception e) {
				System.out.println("Hypothetical Graph of 10Year is not Displayed");
				e.printStackTrace();
			}
			try {
				help.get_element(HYPOTHETICALGROWTH_MAX_RANGE).click();
				Assert.assertTrue(getHypotheticalChart().isDisplayed());
			} catch (Exception e) {
				System.out.println("Hypothetical Graph of MAX Range is not Displayed");
				e.printStackTrace();
			}
			
	}
	
	public void verifyETFPreviousYearChart()
	{
			try {
				help.get_element(PREVIOUS_QUARTER_CHART).click();
				Thread.sleep(1000);
				Assert.assertTrue(getEtfPremiumChart().isDisplayed());
			} catch (Exception e) {
				System.out.println("PREVIOUS_QUARTER_CHART is not Displayed");
				e.printStackTrace();
			}
			try {
				help.get_element(PREVIOUS_YEAR_TO_DATE_CHART).click();
				Thread.sleep(1000);
				Assert.assertTrue(getEtfPremiumChart().isDisplayed());
			} catch (Exception e) {
				System.out.println("PREVIOUS_YEAR_TO_DATE_CHART is not Displayed");
				e.printStackTrace();
			}
			try {
				help.wait_element_tobe_clickable(PREVIOUS_YEAR_CHART);
				help.get_element(PREVIOUS_YEAR_CHART).click();
				Thread.sleep(1000);
				Assert.assertTrue(getEtfPremiumChart().isDisplayed());
			} catch (Exception e) {
				System.out.println("PREVIOUS_YEAR_CHART is not Displayed");
				e.printStackTrace();
			}
	}
	
	public void verifyETFNavHistoryChart()
	{
			try {
				help.get_element(NAVHISTORY_1MONTH).click();
				Thread.sleep(1000);
				Assert.assertTrue(getEtfNavHistoryChart().isDisplayed());
			} catch (Exception e) {
				System.out.println("NAVHISTORY_1MONTH is not available");
				e.printStackTrace();
			}
			try {
				help.get_element(NAVHISTORY_6MONTHS).click();
				Thread.sleep(1000);
				Assert.assertTrue(getEtfNavHistoryChart().isDisplayed());
			} catch (Exception e) {
				System.out.println("NAVHISTORY_6MONTHS is not available");
				e.printStackTrace();
			}
			try {
				help.get_element(NAVHISTORY_1YEAR).click();
				Thread.sleep(1000);
				Assert.assertTrue(getEtfNavHistoryChart().isDisplayed());
			} catch (Exception e) {
				System.out.println("NAVHISTORY_1YEAR is not available");
				e.printStackTrace();
			}
			try {
				help.get_element(NAVHISTORY_MAXRANGE).click();
				Thread.sleep(1000);
				Assert.assertTrue(getEtfNavHistoryChart().isDisplayed());
			} catch (Exception e) {
				System.out.println("NAVHISTORY_MAXRANGE is not available");
				e.printStackTrace();
			}
	}
	
	public void verifyNavHistoryChart()
	{
			try {
				help.get_element(NAVHISTORY_1MONTH).click();
				Thread.sleep(1000);
				Assert.assertTrue(getEtfNavHistoryChart().isDisplayed());
			} catch (Exception e) {
				System.out.println("NAVHISTORY_1MONTH is not available");
				e.printStackTrace();
			}
			try {
				help.get_element(NAVHISTORY_6MONTHS).click();
				Thread.sleep(1000);
				Assert.assertTrue(getEtfNavHistoryChart().isDisplayed());
			} catch (Exception e) {
				System.out.println("NAVHISTORY_6MONTHS is not available");
				e.printStackTrace();
			}
			try {
				help.get_element(NAVHISTORY_1YEAR).click();
				Thread.sleep(1000);
				Assert.assertTrue(getEtfNavHistoryChart().isDisplayed());
			} catch (Exception e) {
				System.out.println("NAVHISTORY_1YEAR is not available");
				e.printStackTrace();
			}
			try {
				help.get_element(NAVHISTORY_3YEARS).click();
				Thread.sleep(1000);
				Assert.assertTrue(getEtfNavHistoryChart().isDisplayed());
			} catch (Exception e) {
				System.out.println("NAVHISTORY_3YEAR is not available");
				e.printStackTrace();
			}
			try {
				help.get_element(NAVHISTORY_5YEARS).click();
				Thread.sleep(1000);
				Assert.assertTrue(getEtfNavHistoryChart().isDisplayed());
			} catch (Exception e) {
				System.out.println("NAVHISTORY_5YEAR is not available");
				e.printStackTrace();
			}
			try {
				help.get_element(NAVHISTORY_10YEARS).click();
				Thread.sleep(1000);
				Assert.assertTrue(getEtfNavHistoryChart().isDisplayed());
			} catch (Exception e) {
				System.out.println("NAVHISTORY_10YEAR is not available");
				e.printStackTrace();
			}
			try {
				help.get_element(NAVHISTORY_MAXRANGE).click();
				Thread.sleep(1000);
				Assert.assertTrue(getEtfNavHistoryChart().isDisplayed());
			} catch (Exception e) {
				System.out.println("NAVHISTORY_MAXRANGE is not available");
				e.printStackTrace();
			}
	}
	
	public void clickOnYields()
	{
		try {
			getYieldsLink().click();
			Thread.sleep(2000);
		} catch (Exception e) {
			scrollandclick(getYieldsLink());
		}
	}
	
	public void clickOnHoldings()
	{
		try {
			getHoldingsLink().click();
			Thread.sleep(2000);
		} catch (Exception e) {
			scrollandclick(getHoldingsLink());
		}
	}
	
	public void clickOnLiterature()
	{
		try {
			getLiteratureLink().click();
			Thread.sleep(2000);
		} catch (Exception e) {
			help.wait_element_tobe_clickable(getLiteratureLink());
			scrollandclick(getLiteratureLink());
		}
	}
	
	public void clickOnDailyAsOf()
	{
		try {
			getDaiylAsOF().click();
			Thread.sleep(2000);
		} catch (Exception e) {
			help.wait_element_tobe_displayed(getDaiylAsOF());
			scrollandclick(getDaiylAsOF());
		}
	}
	
	public void clickOnMonthEndAsOf()
	{
		try {
			getMonthEndAsOf().click();
			Thread.sleep(2000);
		} catch (Exception e) {
			help.wait_element_tobe_clickable(getMonthEndAsOf());
			scrollandclick(getMonthEndAsOf());
		}
	}
	
	public void clickOnQuarterEndAsOf()
	{
		try {
			getQuarterEndAsOf().click();
			Thread.sleep(2000);
		} catch (Exception e) {
			help.wait_element_tobe_displayed(getQuarterEndAsOf());
			scrollandclick(getQuarterEndAsOf());
		}
	}
	
	
	

}
