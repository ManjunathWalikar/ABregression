package StepDefinitions;

import org.apache.log4j.Logger;

import com.sprint.qa.base.PageObjects;
import com.sprint.qa.helper.Helper;
import com.sprint.qa.helper.LoggerHelper;
import com.sprint.qa.util.TestUtil;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SgProdStepDefinition {

	TestUtil testUtil;
	Logger log = LoggerHelper.getLogger(LoggerHelper.class);
	Helper help = new Helper();
	PageObjects po = new PageObjects();
	public static String VIEW_ALL_FUNDS= "//a[contains(text(),' View All Funds ')]";

	public SgProdStepDefinition()
	{
		super(); // super class constructor to initialize properties
	}
	
	@When("I Click on Yes Continue Btn")
	public void click_on_Yes_Btn() {
	    po.home_page.clickOnYesContinueBtn();
	}
	@When("I click on view all funds")
	public void click_on_View_all_Funds() {
	    po.sg_fund_finder_page.clickOnViewAllFunds();
	}
	@When("^I click on Currencies DD$")
	public void click_on_Currencies_DD()
	{
		po.sg_fund_finder_page.clickOnCurrenciesDD();
	}
	@Then("^Verify Default Currencies for SG$")
	public void Verify_Default_Currencies()
	{
		po.sg_fund_finder_page.validateCurrenciesCNH();
	}
	@When("^I click on Shareclass DD$")
	public void click_on_Shareclass_DD()
	{
		po.sg_fund_finder_page.clickOnShareclassDD();
	}
	@Then("^Verify Default Shareclass For SG$")
	public void Verify_Default_Shareclass()
	{
		po.sg_fund_finder_page.VerifyDefaultShareclassSelected();
	}
	@When("^I click on Performance Tab$")
	public void click_on_Performance()
	{
		po.sg_fund_finder_page.clickOnPerformanceTab();
	}
	@Then("^I verify Funds are Displayed$")
	public void Verify_Funds_are_Displayed()
	{
		po.sg_fund_finder_page.validateSGallFunds();
	}
	@When("^I click on Fund Facts$")
	public void click_on_Fund_Facts()
	{
		po.sg_fund_finder_page.clickOnFundFactsTab();
	}
	@When("^I click on Documents$")
	public void click_on_Documents()
	{
		po.sg_fund_finder_page.clickOnDocumentsTab();
	}
	@When("^I click on DailyPricing Tab$")
	public void click_on_DailyPricing()
	{
		po.sg_fund_finder_page.clickOnDailyPricingTab();
	}
	
	
}
