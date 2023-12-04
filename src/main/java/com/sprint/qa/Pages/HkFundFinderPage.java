package com.sprint.qa.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.sprint.qa.base.PageObjects;
import com.sprint.qa.base.TestBase;
import com.sprint.qa.helper.Helper;
import com.sprint.qa.helper.LoggerHelper;

public class HkFundFinderPage extends TestBase {
	Logger log = LoggerHelper.getLogger(LoggerHelper.class);
	Helper help =new Helper();
	
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
	public static String OneMonthValue;
	public static String LANGUAGE_DD = "//a[contains(text(),'English')]";
	public static String CHINESE_LANGUAGE = "//a[contains(text(),'中文')]";
	
	
	
	public WebElement getLanguageDD() {
		return help.get_element(LANGUAGE_DD);
	}
	public WebElement getChineseLanguage() {
		return help.get_element(CHINESE_LANGUAGE);
	}
	public HkFundFinderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, true);
	}
	
	public void clickOnChineseLanguage() {
		getChineseLanguage().click();
	}
	public void clickOnLanguageDD() {
		getLanguageDD().click();
	}
	
	public void validateIndividualFunds(String fundName) {
		YTDvalue = help.get_element_text("//a[contains(text(),'"+fundName+"')]/ancestor::td/following-sibling::td[5]");
		OneMonthValue = help.get_element_text("//a[contains(text(),'"+fundName+"')]/ancestor::td/following-sibling::td[4]");
		OneYearValue = help.get_element_text("//a[contains(text(),'"+fundName+"')]/ancestor::td/following-sibling::td[6]");
		ThreeYearValue = help.get_element_text("//a[contains(text(),'"+fundName+"')]/ancestor::td/following-sibling::td[7]");
		FiveYearValue = help.get_element_text("//a[contains(text(),'"+fundName+"')]/ancestor::td/following-sibling::td[8]");
		TenYearValue = help.get_element_text("//a[contains(text(),'"+fundName+"')]/ancestor::td/following-sibling::td[9]");
		SinceInceptionValue = help.get_element_text("//a[contains(text(),'"+fundName+"')]/ancestor::td/following-sibling::td[10]");
		INCEPTION_DATE = help.get_element_text("//a[contains(text(),'"+fundName+"')]/ancestor::td/following-sibling::td[11]");
		
		System.out.println(OneMonthValue);
		System.out.println(YTDvalue);
		System.out.println(OneYearValue);
		System.out.println(ThreeYearValue);
		System.out.println(FiveYearValue);
		System.out.println(TenYearValue);
		System.out.println(SinceInceptionValue);
		System.out.println(INCEPTION_DATE);
		
		page.sg_fund_finder_page.clickOnCalenderData();
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
