package com.sprint.qa.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.sprint.qa.base.TestBase;
import com.sprint.qa.helper.Helper;
import com.sprint.qa.helper.LoggerHelper;

public class HomePage extends TestBase {
	Logger log = LoggerHelper.getLogger(LoggerHelper.class);
	Helper help =new Helper();
	
	public static String CHOOSE_YOUR_SITE = "//div[@id='site-selector-trigger']";
	public static String INDIVIDUAL_INVESTOR = "//button[contains(text(),'Individual Investors')]";
	public static String INVESTMENTS = "//span[contains(text(),'Investments ')]";
	public static String PRODUCTS = "//div[contains(@class,'header')]//a[contains(text(),'Products')]";
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, true);
	}
	
	public WebElement getChooseYourSite()
	{
		WebElement ele = help.get_element(CHOOSE_YOUR_SITE);
		return ele;
	}
	public WebElement getIndividualInvestor()
	{
		WebElement ele = help.get_element(INDIVIDUAL_INVESTOR);
		return ele;
	}
	public WebElement getInvestment()
	{
		WebElement ele = help.get_element(INVESTMENTS);
		return ele;
	}
	public WebElement getProducts()
	{
		WebElement ele = help.get_element(PRODUCTS);
		return ele;
	}
	
	public void navigateToGivenSite(String country)
	{
		getChooseYourSite().click();
		WebElement countrySpecific = help.get_element("//span[contains(text(),'"+country+"')]");
		try {
			countrySpecific.click();
		} catch (Exception e) {
			scrollandclick(countrySpecific);
		}
	}
	
	public void clickOnIndividualInvestor()
	{
		try {
			getIndividualInvestor().click();
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
			scrollandclick(getIndividualInvestor());
		}
	}
	public void clickOnInvestment()
	{
		try {
			Thread.sleep(3000);
			wait_element_tobe_clickable(getInvestment());
			getInvestment().click();
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
			scrollandclick(getInvestment());
		}
	}
	public void clickOnProducts()
	{
		try {
			getProducts().click();
		} catch (Exception e) {
			// TODO: handle exception
			scrollandclick(getProducts());
		}
	}

}
