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
	public static String INSTITUTIONAL_INVESTOR = "//button[contains(text(),'Institutional Investor')]";
	public static String INVESTMENTS = "//span[contains(text(),'Investments ')]";
	public static String PRODUCTS = "//div[contains(@class,'header')]//a[contains(text(),'Products')]";
	public static String AcceptCookies = "//button[@id='onetrust-accept-btn-handler']";
	public static String YES_CONTINUE_BTN = "//button[contains(text(),'Yes Continue')]";
	public static String FUNDS_LINK = "//a[contains(text(),'Funds')]";
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, true);
	}
	
	public WebElement getChooseYourSite()
	{
		WebElement ele = help.get_element(CHOOSE_YOUR_SITE);
		return ele;
	}
	
	public WebElement getFundsLink() {
		return help.get_element(FUNDS_LINK);
	}
	
	public WebElement getInstitutionalInvestor() {
		return help.get_element(INSTITUTIONAL_INVESTOR);
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
	public WebElement getAcceptCookies()
	{
		return help.get_element(AcceptCookies);
	}
	public WebElement getYesContinueBtn() {
		return help.get_element(YES_CONTINUE_BTN);
	}
	/**
	 * Utilization
	 */
	
	public void clickOnYesContinueBtn() {
		try {
			wait_element_tobe_displayed(getAcceptCookies());
			getAcceptCookies().click();
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			wait_element_tobe_displayed(getYesContinueBtn());
			getYesContinueBtn().click();
		} catch (Exception e) {
			scrollandclick(getYesContinueBtn());
		}
	}
	public void navigateToGivenSite(String country)
	{
		getChooseYourSite().click();
		wait_element_tobe_displayed(getAcceptCookies());
		getAcceptCookies().click();
		WebElement countrySpecific = help.get_element("//span[contains(text(),'"+country+"')]");
		try {
			wait_element_tobe_clickable(countrySpecific);
			countrySpecific.click();
		} catch (Exception e) {
			scrollandclick(countrySpecific);
		}
	}
	
	public void clickOnIndividualInvestor()
	{
		try {
			Thread.sleep(10000);
			wait_element_tobe_displayed(getIndividualInvestor());
			getIndividualInvestor().click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickOnInstitutionalInvestor()
	{
		try {
			Thread.sleep(5000);
			wait_element_tobe_displayed(getInstitutionalInvestor());
			getInstitutionalInvestor().click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickOnFundsLink()
	{
		try {
			Thread.sleep(5000);
			wait_element_tobe_displayed(getFundsLink());
			getFundsLink().click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickOnInvestment()
	{
		try {
			Thread.sleep(6000);
			wait_element_tobe_clickable(getInvestment());
			getInvestment().click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void clickOnProducts()
	{
		try {
			wait_element_tobe_clickable(getProducts());
			getProducts().click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
