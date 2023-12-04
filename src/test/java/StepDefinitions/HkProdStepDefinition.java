package StepDefinitions;

import org.apache.log4j.Logger;

import com.sprint.qa.base.PageObjects;
import com.sprint.qa.helper.Helper;
import com.sprint.qa.helper.LoggerHelper;
import com.sprint.qa.util.TestUtil;

import io.cucumber.java.en.When;

public class HkProdStepDefinition {
	TestUtil testUtil;
	Logger log = LoggerHelper.getLogger(LoggerHelper.class);
	Helper help = new Helper();
	PageObjects po = new PageObjects();
	
	public HkProdStepDefinition()
	{
		super(); // super class constructor to initialize properties
	}
	
	@When("^I get Performance Value of HK '(.*)'$")
	public void annual_Performance_Value(String fundname)
	{
		po.hk_FF_Page.validateIndividualFunds(fundname);
	}
	@When("^I Click On Language DD$")
	public void language_DD()
	{
		po.hk_FF_Page.clickOnLanguageDD();
	}
	@When("^I Click On Chinese Language$")
	public void chinese_language()
	{
		po.hk_FF_Page.clickOnChineseLanguage();
	}

}
