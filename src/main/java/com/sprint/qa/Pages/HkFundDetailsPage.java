package com.sprint.qa.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.sprint.qa.base.TestBase;
import com.sprint.qa.helper.Helper;
import com.sprint.qa.helper.LoggerHelper;

public class HkFundDetailsPage extends TestBase {
	Logger log = LoggerHelper.getLogger(LoggerHelper.class);
	Helper help =new Helper();
	
	
	public HkFundDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, true);
	}
	
	public void validateAnnualPerformanceData(String fundName) {
		help.get_element("//td[contains(text(),'"+fundName+"')]").click();
		String YTD = help.get_element_text("//td[contains(text(),'"+fundName+"')]/following-sibling::td[1]");
		String OneYear = help.get_element_text("//td[contains(text(),'"+fundName+"')]/following-sibling::td[2]");
		String ThreeYear = help.get_element_text("//td[contains(text(),'"+fundName+"')]/following-sibling::td[3]");
		String FiveYear = help.get_element_text("//td[contains(text(),'"+fundName+"')]/following-sibling::td[4]");
		String TenYear = help.get_element_text("//td[contains(text(),'"+fundName+"')]/following-sibling::td[5]");
		String SinceInceptionData = help.get_element_text("//td[contains(text(),'"+fundName+"')]/following-sibling::td[6]");
		
		System.out.println(YTD);
		System.out.println(OneYear);
		System.out.println(ThreeYear);
		System.out.println(FiveYear);
		System.out.println(TenYear);
		System.out.println(SinceInceptionData);
		Assert.assertTrue(YTD.contains(HkFundFinderPage.YTDvalue));
			Assert.assertTrue(YTD.contains(HkFundFinderPage.YTDvalue));
			Assert.assertTrue(OneYear.contains(HkFundFinderPage.OneYearValue));
			Assert.assertTrue(ThreeYear.contains(HkFundFinderPage.ThreeYearValue));
			Assert.assertTrue(FiveYear.contains(HkFundFinderPage.FiveYearValue));
			Assert.assertTrue(TenYear.contains(HkFundFinderPage.TenYearValue));
			Assert.assertTrue(SinceInceptionData.contains(HkFundFinderPage.SinceInceptionValue));
	}
	public void validateCalenderYearPerformanceData(String fundName) {
		help.get_element("//td[contains(text(),'"+fundName+"')]").click();
		String Calender2018 = help.get_element_text("//td[contains(text(),'"+fundName+"')]/following-sibling::td[1]");
		String Calender2019 = help.get_element_text("//td[contains(text(),'"+fundName+"')]/following-sibling::td[2]");
		String Calender2020 = help.get_element_text("//td[contains(text(),'"+fundName+"')]/following-sibling::td[3]");
		String Calender2021 = help.get_element_text("//td[contains(text(),'"+fundName+"')]/following-sibling::td[4]");
		String Calender2022 = help.get_element_text("//td[contains(text(),'"+fundName+"')]/following-sibling::td[5]");
		String CalenderYTD = help.get_element_text("//td[contains(text(),'"+fundName+"')]/following-sibling::td[6]");
		
		Assert.assertTrue(Calender2018.contains(HkFundFinderPage.DATA_2018));
		Assert.assertTrue(Calender2019.contains(HkFundFinderPage.DATA_2019));
		Assert.assertTrue(Calender2020.contains(HkFundFinderPage.DATA_2020));
		Assert.assertTrue(Calender2021.contains(HkFundFinderPage.DATA_2021));
		Assert.assertTrue(Calender2022.contains(HkFundFinderPage.DATA_2022));
		Assert.assertTrue(CalenderYTD.contains(HkFundFinderPage.DATA_YTD));
		
	}

}
