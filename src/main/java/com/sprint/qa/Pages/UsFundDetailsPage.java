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
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	

}
