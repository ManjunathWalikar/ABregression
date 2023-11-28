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
		po.sg_fund_finder_page.VerifyDefaultCurrenciesSelected();
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
	@Then("^I verify AS OF DATE for SG$")
	public void verify_as_of_date_sg()
	{
		po.sg_fund_finder_page.validateAsOfDateSG();
	}
	@When("^I search '(.*)' in FF page$")
	public void fundsearch_textbox(String fundName)
	{
		po.sg_fund_finder_page.searchFund(fundName);
	}
	@When("^Validate all Funds$")
	public void validate_funds()
	{
		po.sg_fund_finder_page.ValidateFunds();
	}
	@When("^I get Performance Value of '(.*)'$")
	public void annual_Performance_Value(String fundname)
	{
		po.sg_fund_finder_page.validateIndividualFunds(fundname);
	}
	@Then("^Validate Annual Performance Values$")
	public void verify_Annual_Performance_data()
	{
		po.sg_fund_details_page.validateAnnualPerformanceData();
	}
	@When("^I wait in sec '(.*)'$")
	public void wait_in_sec(String waittime)
	{
		int time = Integer.parseInt(waittime);
		time = time*1000;
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@When("^I click on Calender Year Performance$")
	public void click_on_Calender_year()
	{
		po.sg_fund_details_page.clickOnCalenderYearPerformance();
	}
	@Then("^Validate Calender Year Performance Values$")
	public void verify_Calender_Year_Performance_data()
	{
		po.sg_fund_details_page.validateCalenderYearPerformanceData();
	}
	@When("^I Click on Fund facts$")
	public void Click_on_Fund_facts()
	{
		po.sg_fund_details_page.clickOnFundFactVehicle();
	}
	@Then("^I validate Fund Inception date in FD Page$")
	public void validate_Fund_Inception_date_in_FD_Page()
	{
		po.sg_fund_details_page.ValidateFundInceptionDate();
	}
	@Then("^I Validate Distribution Table in FD page$")
	public void validate_Distribution_Table_in_FD_Page()
	{
		po.sg_fund_details_page.ValidateDistributionTable();
	}
	@When("^I Click On Portfolio Composition$")
	public void Click_on_Portfolio_Composition()
	{
		po.sg_fund_details_page.clickOnPortfolioComposition();
	}
	@When("^I Click On Risks$")
	public void Click_on_Risks()
	{
		po.sg_fund_details_page.clickOnRiskVehicle();
	}
	
}
