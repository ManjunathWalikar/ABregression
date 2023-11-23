package com.sprint.qa.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
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
	
	
	
	public String getNavValue() {
		return help.get_element_text(SG_NAV_VALUE);
	}
	public String getAsOFDate() {
		return help.get_element_text(SG_AS_OF_DATE);
	}
	
	public SgFundDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, true);
	}
	
	public void validateNavValue(String navValue) {
		Assert.assertTrue(getNavValue().contains(navValue));
	}
	public void validateAsOfDate(String date) {
		Assert.assertTrue(getAsOFDate().contains(date));
	}

}
