package com.sprint.qa.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

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

}
