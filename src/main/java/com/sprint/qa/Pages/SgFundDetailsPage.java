package com.sprint.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SgFundDetailsPage {
	
	public SgFundDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, true);
	}

}
