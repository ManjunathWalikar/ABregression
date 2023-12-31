package StepDefinitions;
import org.apache.log4j.Logger;

import com.sprint.qa.base.PageObjects;
import com.sprint.qa.base.TestBase;
import com.sprint.qa.helper.Helper;
import com.sprint.qa.helper.LoggerHelper;
import com.sprint.qa.util.TestUtil;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Reg02_Hyperlinks_StepDefinition extends TestBase {

	TestUtil testUtil;
	Logger log = LoggerHelper.getLogger(LoggerHelper.class);
	Helper help = new Helper();
	PageObjects po = new PageObjects();
	public static String NAV_VALUE;
	public static String AS_OF_DATE;

	public Reg02_Hyperlinks_StepDefinition()
	{
		super(); // super class constructor to initialize properties
	}

//	public void setUp() throws Exception
//	{
//		initialization();
//	}
	
	@Before
	public void launchApplication()
	{
		try {
			initialization();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@After
	public void closeBrowser()
	{
		driver.quit();
	}
	
//	@Given("Navigate to US Fund Finder Page")
//	public void navigate_to_us_fund_finder_page() {
//		
//	}
	
	@Given("^Navigate to '(.*)' site$")
	public void navigate_to_country_site(String country) {
		System.out.println(country);
		po.home_page.navigateToGivenSite(country);
	}

	@When("I click on Mutual Funds")
	public void i_click_on_mutual_funds() {
	    po.us_fund_finder_page.clickOnMutualFund();
	}

	@Then("Verify Each mutual Funds")
	public void verify_each_mutual_funds() {
	    po.us_fund_finder_page.validateFunds();
	}
	
	@When("^I Click on Individual Investor$")
	public void click_on_Individual_investor()
	{
		po.home_page.clickOnIndividualInvestor();
	}
	@When("^I Click on Institutional Investor$")
	public void click_on_Institutional_investor()
	{
		po.home_page.clickOnInstitutionalInvestor();
	}
	@And("^I click on Investment$")
	public void click_on_investment()
	{
		po.home_page.clickOnInvestment();
	}
	
	@And("^I click on Funds$")
	public void click_on_Funds()
	{
		po.home_page.clickOnFundsLink();
	}
	
	@And("^I click on Products$")
	public void click_on_products()
	{
		po.home_page.clickOnProducts();
	}
	
	@Then("^Verify '(.*)' Fund$")
	public void verify_Perticular_Fund(String fundName)
	{
		po.us_fund_finder_page.validateIndividualFunds(fundName);
	}

	@When("I click on ETF Funds")
	public void i_click_on_etf_funds() {
	    po.us_fund_finder_page.clickOnETFFund();
	}
	
	@Then("Verify Each ETF Funds")
	public void verify_each_etf_funds() {
	    po.us_fund_finder_page.validateETFFunds();
	}
	
	@And("^I select AssetClass DD$")
	public void selectAssetClassDD()
	{
		po.us_fund_finder_page.clickOnAssetClassDD();
	}
	
	@And("^I select Equities in AssetClass DD$")
	public void select_Equities_in_AssetClass_DD()
	{
		po.us_fund_finder_page.selectEquitiesFromDD();
	}
	
	@And("^I select Fixed Income in AssetClass DD$")
	public void select_Fixed_Income_in_AssetClass_DD()
	{
		po.us_fund_finder_page.selectFixedIncomeFromDD();
	}
	
	@And("^I select Multi Asset in AssetClass DD$")
	public void select_Multi_Asset_in_AssetClass_DD()
	{
		po.us_fund_finder_page.selectMultiAssetFromDD();
	}
	
	@And("^I select Alternatives in AssetClass DD$")
	public void select_Alternatives_in_AssetClass_DD()
	{
		po.us_fund_finder_page.selectAlternativesFromDD();
	}
	
	@And("^I click on Reset Filters$")
	public void click_on_Reset_Filters()
	{
		po.us_fund_finder_page.clickOnResetFilters();
	}
	
	@Then("^Verify the Funds are Equities$")
	public void Verify_the_Funds_are_Equities()
	{
		po.us_fund_finder_page.verifyEquities();
	}
	
	@Then("^Verify the Funds are Fixed Income$")
	public void Verify_the_Funds_are_Fixed_Income()
	{
		po.us_fund_finder_page.verifyFIXED_INCOME();
	}
	
	@Then("^Verify the Funds are Multi Asset$")
	public void Verify_the_Funds_are_Multi_Asset()
	{
		po.us_fund_finder_page.verifyMULTI_ASSET();
	}
	
	@Then("^Verify the Funds are Alternatives$")
	public void Verify_the_Funds_are_Alternatives()
	{
		po.us_fund_finder_page.verifyALTERNATIVES();
	}
	@And("^I select Styles DD$")
	public void I_select_Styles_DD()
	{
		po.us_fund_finder_page.clickOnStylesDD();
	}
	@And("^I select Equity Core in Styles DD$")
	public void select_Equity_Core_in_Styles_DD()
	{
		po.us_fund_finder_page.selectEquityCoreFromDD();
	}
	
	@Then("^Verify Equity Core Funds$")
	public void Verify_Equity_Core_Funds()
	{
		po.us_fund_finder_page.verifyEquityCoreandGlobal();
	}
	
	@And("^I select Region DD$")
	public void I_select_Region_DD()
	{
		po.us_fund_finder_page.clickOnRegionDD();
	}
	@And("^I select Global in Region DD$")
	public void select_Global_in_Region_DD()
	{
		po.us_fund_finder_page.selectGlobalFromRegionDD();
	}
	
	@Then("^Verify Global Funds Count$")
	public void Verify_Global_Funds_Counts()
	{
		po.us_fund_finder_page.verifyEquityCoreandGlobal();
	}
	@And("^I select ShareClass DD$")
	public void I_select_ShareClass_DD()
	{
		po.us_fund_finder_page.clickOnShareClassDD();;
	}
	@And("^I select Advisor in ShareClass DD$")
	public void select_Advisor_in_ShareClass_DD()
	{
		po.us_fund_finder_page.selectAdvisorFromShareClassDD();
	}
	
	@Then("^Verify Total Mutual Funds Count$")
	public void Verify_Total_Mutual_Funds_Counts()
	{
		po.us_fund_finder_page.verifyMutualFundCount();
	}
	
	@When("^I click on Daily Pricing and Yields$")
	public void click_on_Daily_Pricing_and_Yields()
	{
		po.us_fund_finder_page.clickOnDailyPricingAndYields();
	}
	@Then("^I Verify Funds are Loaded$")
	public void Verify_Funds_are_Loaded()
	{
		po.us_fund_finder_page.verifyFunds();
	}
	@And("^I click on Literature$")
	public void I_click_on_Literature()
	{
		po.us_fund_finder_page.clickOnLiterature();
	}
	@And("^I click on Performance$")
	public void I_click_on_Performance()
	{
		po.us_fund_finder_page.clickOnPerformance();
	}
	@When("^I click on Quarter End As Of$")
	public void click_on_Quarter_End_As_Of()
	{
		po.us_fund_finder_page.clickOnQuarterEndAsOf();
	}
	@When("^I click on Month End As Of$")
	public void click_on_Month_End_As_Of()
	{
		po.us_fund_finder_page.clickOnMonthEndAsOf();
	}
	@When("^I click on Show Benchmark$")
	public void click_on_Show_Benchmark()
	{
		po.us_fund_finder_page.clickOnShowBenchmark();
	}
	@Then("^Verify Benchmark Data$")
	public void Verify_Benchmark_Data()
	{
		po.us_fund_finder_page.verifyBenchMarkData();
	}
	@When("^I Click on Hide Benchmark$")
	public void click_on_Hide_Benchmark()
	{
		po.us_fund_finder_page.clickOnHideBenchmark();
	}
	@Then("^Verify QuickView of Funds$")
	public void Verify_QuickView_of_Funds()
	{
		po.us_fund_finder_page.verifyQuickViewOfFunds();
	}
	@When("^I Validate As Of Date$")
	public void Validate_As_Of_Date()
	{
		po.us_fund_finder_page.validateFFAsOfDate();
	}
	@When("^I search '(.*)' in FF page FundSearch$")
	public void fundsearch_textbox(String fundName)
	{
		po.us_fund_finder_page.searchFund(fundName);
	}
	@Then("^I validate FD page of '(.*)'$")
	public void validate_FD_Page(String fundName)
	{
		po.us_fund_finder_page.validateFDpage(fundName);
	}
	
	@When("^I click on SMAS Funds$")
	public void click_on_SMAS_Funds()
	{
		po.us_fund_finder_page.clickOnSMAS();
	}
	@Then("Verify Each SMAS Funds")
	public void verify_each_SMAS_funds() {
	    po.us_fund_finder_page.validateSMASFunds();
	}
	@When("^I click on Model Portfolio Funds$")
	public void click_on_Model_Portfolio_Funds()
	{
		po.us_fund_finder_page.clickOnModelPortFolio();
	}
	@Then("Verify Each Model Portfolio Funds")
	public void verify_each_Model_Portfolio_funds() {
	    po.us_fund_finder_page.validateSMASFunds();
	}
	@When("^I click on Closed End Funds$")
	public void click_on_Closed_End_Funds()
	{
		po.us_fund_finder_page.clickOnClosedEndFund();
	}
	@Then("^Verify Each Closed End Funds$")
	public void verify_each_Closed_End_funds() {
	    po.us_fund_finder_page.validateClosedEndFunds();
	}
	
	@When("^I click on Veriable Product Series Funds$")
	public void click_on_Veriable_Product_Series_Funds()
	{
		po.us_fund_finder_page.clickOnVeriableProductSeriesFund();
	}
	@Then("^Verify Each Veriable Product Series Funds$")
	public void verify_each_Veriable_Product_Series_funds() {
	    po.us_fund_finder_page.validateVeriableProductSeriesFunds();
	}
	@Then("^I Switch Window to '(.*)'$")
	public void switch_window(String fundName)
	{
		help.switchWindowFDpage(fundName);
		log.info("Switched to "+fundName);
	}
	@When("^I get NAV value of '(.*)' FF page$")
	public void get_NAV_From_FF(String fundName)
	{
		NAV_VALUE = po.us_fund_finder_page.getNAVdata(fundName);
	}
	@When("^I Click On given '(.*)'$")
	public void click_on_Fund(String fundName)
	{
		po.us_fund_finder_page.clickOnGivenFund(fundName);
	}
	@And("^I get as of Date From FF page$")
	public void get_asOfDate_From_FF()
	{
		AS_OF_DATE = po.us_fund_finder_page.getAsOfDate();
	}
	@Then("^I Validate As Of Date in FD Page$")
	public void validate_asOfDate_in_FD_Page()
	{
		po.us_fund_details_page.validateAsOfDate(AS_OF_DATE);
	}
	@Then("^I Validate NAV Value$")
	public void validate_NAV_Value_in_FD_Page()
	{
		po.us_fund_details_page.validateNAV(NAV_VALUE);
	}
	@When("^I Click On Overview$")
	public void click_on_Overview()
	{
		po.us_fund_details_page.clickOnOverview();
	}
	@Then("^I Verify Key Facts$")
	public void verify_Key_Facts()
	{
		po.us_fund_details_page.verifyKeyFacts();
	}
	@When("^I click on Pricing and Performance$")
	public void click_on_Pricing_and_Performance()
	{
		po.us_fund_details_page.clickOnPerformance();
	}
	@Then("^I Validate Daily Nav As Of Value$")
	public void validate_Daily_Nav_As_Of_Value()
	{
		po.us_fund_details_page.verifyDailyAsOfNavValue(NAV_VALUE);
	}
	@Then("^I Validate Hypothetical Growth$")
	public void validate_Hypothetical_Growth()
	{
		po.us_fund_details_page.verifyHypotheticalGrowth();
	}
	@Then("^I validate NAV History Chart$")
	public void validate_NAV_History_Chart()
	{
		po.us_fund_details_page.verifyNavHistoryChart();
	}
	@When("^I click On Yields and Distribution$")
	public void click_on_Yields_and_Distribution()
	{
		po.us_fund_details_page.clickOnYields();
	}
	@Then("^I Validate Distribution Table$")
	public void validate_Distribution_Table()
	{
		po.us_fund_details_page.validateDistributionTable();
	}
	@When("^I click on Holdings and Characteristics$")
	public void click_on_Holdings_and_Characteristics()
	{
		po.us_fund_details_page.clickOnHoldings();
	}
	@Then("^I Verify Holdings Table$")
	public void validate_Holdings_Table()
	{
		po.us_fund_details_page.validateHoldingsTable();
	}
	@When("^I click on Literature Vehicle$")
	public void click_on_Literature_Vehicle()
	{
		po.us_fund_details_page.clickOnLiterature();
	}
	@When("^I click on select all Literature checkbox$")
	public void click_on_select_all_Literature()
	{
		po.us_fund_details_page.clickOnSelectAllLiteratureCheckbox();
	}
	@Then("^I verify Document Selected PopUp$")
	public void validate_Document_Selected_PopUp()
	{
		po.us_fund_details_page.validateDistributionTablePopup();
	}
	@When("^I close current Browser$")
	public void close_current_browser()
	{
		driver.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	
//	
//	@Given("^hYPERLINKS user is already on Dashboard page$")
//	public void hYPERLINKS_user_is_already_on_Dashboard_page() throws Exception
//	{
////		TestBase.initialization();
//		driver.navigate().to(prop.getProperty("qa_url"));
//		Thread.sleep(8000);
//		driver.findElement(By.xpath("//span[text()='Dashboard']")).click();
//	}
//
//	@When("^hYPERLINKS title of the Dashboard page is Dashboard$")
//	public void hYPERLINKS_title_of_Dashboard_page_is_Dashboard() throws InterruptedException
//	{
//		String title = driver.getTitle();
//		log.info(title);
//		System.out.println(title);
//		Thread.sleep(6000);
//	}
//
//	@And("^hYPERLINKS user clicks on view details link$")
//	public void hYPERLINKS_user_clicks_on_view_details_link()
//	{
//		help.fluent_wait_click_not_interactable("//a[@class='order-link']/a[@href='#/subscriptions?status=1']");
//		//driver.findElement(By.xpath("//a[@class='order-link']/a[@href='#/subscriptions?status=1']")).click();
//	}
//
//	@And("^hYPERLINKS user is on Subscription page$")
//	public void hYPERLINKS_user_is_on_Subscription_page() throws InterruptedException
//	{
//
//		String title = driver.getTitle();
//		log.info(title);
//		//Assert.assertEquals("Subscriptions", title);
//		Thread.sleep(8000);
//
//	}
//
//	@And("^hYPERLINKS user clicks on subscription dropdown selects dropdown value$")
//	public void hYPERLINKS_user_clicks_on_subscription_dropdown_selects_dropdown_value() throws InterruptedException
//	{
//
//		Thread.sleep(3000);
//	}
//
//	@And("^hYPERLINKS user clicks on second dropdown and selects option$")
//	public void hYPERLINKS_user_clicks_on_second_dropdown_and_selects_option() throws InterruptedException {
//		Actions action = new Actions(driver);
//
//		WebElement Drpdwn = driver.findElement(By.xpath("//div[3]/div[1]/div/div/div[1]/div/div[1]/div[1]/select"));
//		action.moveToElement(Drpdwn).click().perform();
//		Drpdwn.click();
//
//		Select DrpdwnAnyOption = new Select(driver.findElement(By.xpath("//div[3]/div[1]/div/div/div[1]/div/div[1]/div[1]/select")));
//		DrpdwnAnyOption.selectByVisibleText("Subs #");
//		Thread.sleep(5000);
//
//		WebElement sub_num = driver.findElement(By.xpath("//div[3]/div[1]/div/div/div[1]/div/div[1]/div[2]/div/div[1]/input"));
//		sub_num.clear();
//		sub_num.sendKeys(prop.getProperty("reg02_subNum"));
//
//		Thread.sleep(3000);
//	}
//
//	@And("^hYPERLINKS user clicks on search button$")
//	public void hYPERLINKS_user_clicks_on_search_button() throws InterruptedException {
//		Actions action = new Actions(driver);
//
//		WebElement search_button2 = driver.findElement(By.xpath("//button/i[@class='fas fa-search']"));
//		action.moveToElement(search_button2);
//		search_button2.click();
//		Thread.sleep(5000);
//	}
//
//	@And("^hYPERLINKS user clicks on column options button$")
//	public void hYPERLINKS_user_clicks_on_column_options_button() throws InterruptedException {
//
//		WebElement co_button = driver.findElement(By.xpath("//div[4]/div/div[1]/div[3]/div/button[3]"));
//		co_button.click();
//
//		log.info("User clicks on column options button");
//		Thread.sleep(3000);
//	}
//
//	@And("^hYPERLINKS user adds order number column and click apply$")
//	public void hYPERLINKS_user_adds_order_number_column_and_click_apply() throws InterruptedException {
//
//		Actions action = new Actions(driver);
//
//		driver.switchTo().activeElement();
//
//
//		action.moveToElement(driver.findElement(By.xpath("//div[4]/div/div/div/div/div[2]/div/div/div[1]/div/div/select/option[1]"))).perform();
//		WebElement right_list_ele = driver.findElement(By.xpath("//div[4]/div/div/div/div/div[2]/div/div/div[1]/div/div/select/option[1]"));
//		right_list_ele.click();
//
//		Thread.sleep(3000);
//
//		action.moveToElement(driver.findElement(By.xpath("//div[4]/div/div/div/div/div[2]/div/div/div[1]/div/div/div/a[1]"))).perform();
//		WebElement arrow_right = driver.findElement(By.xpath("//div[4]/div/div/div/div/div[2]/div/div/div[1]/div/div/div/a[1]"));
//		arrow_right.click();
//
//		Thread.sleep(3000);
//
//		action.moveToElement(driver.findElement(By.xpath("//div[4]/div/div/div/div/div[2]/div/div/div[2]/div/div/select/option[10]"))).perform();
//		WebElement highlight_ele = driver.findElement(By.xpath("//div[4]/div/div/div/div/div[2]/div/div/div[2]/div/div/select/option[10]"));
//		highlight_ele.click();
//		Thread.sleep(3000);
//
//		action.moveToElement(driver.findElement(By.xpath("//div[4]/div/div/div/div/div[2]/div/div/div[2]/div/div/div/a[1]"))).perform();
//		WebElement arrow_up = driver.findElement(By.xpath("//div[4]/div/div/div/div/div[2]/div/div/div[2]/div/div/div/a[1]"));
//
//		arrow_up.click();
//		Thread.sleep(1000);
//
//		arrow_up.click();
//		Thread.sleep(1000);
//
//		arrow_up.click();
//		Thread.sleep(1000);
//
//		arrow_up.click();
//		Thread.sleep(1000);
//
//		arrow_up.click();
//		Thread.sleep(1000);
//
//		arrow_up.click();
//
//		driver.switchTo().activeElement();
//
//		action.moveToElement(driver.findElement(By.xpath("//div[4]/div/div/div/div/div[3]/button[1]"))).perform();
//		WebElement apply_button= driver.findElement(By.xpath("//div[4]/div/div/div/div/div[3]/button[1]"));
//		apply_button.click();
//
//		Thread.sleep(3000);
//	}
//
//	@And("^hYPERLINKS user clicks on hyperlink of subscription number column$")
//	public void hYPERLINKS_user_clicks_on_hyperlink_of_subscription_number_column() throws InterruptedException {
//
//		Actions action = new Actions(driver);
//
//		action.moveToElement(driver.findElement(By.xpath("//a[text()='"+prop.getProperty("reg02_subNum")+"']"))).click().perform();
//		Thread.sleep(5000);
//	}
//
//	@And("^hYPERLINKS user observes first window pop up and clicks on view details link$")
//	public void hYPERLINKS_user_observes_first_window_pop_up_and_clicks_on_view_details_link() throws InterruptedException {
//
//		log.info("User observes first window pop up and clicks on view details link");
//		Thread.sleep(5000);
//	}
//
//	@And("^hYPERLINKS user closes the first browser for view details page$")
//	public void hYPERLINKS_user_close_the_first_browser_for_view_details_page() throws InterruptedException {
//		driver.switchTo().defaultContent();
//
//		String parentWindow = driver.getWindowHandle();
//
//		Set<String> allHandles = driver.getWindowHandles();
//
//		for(String curWindow : allHandles)
//		{
//			driver.switchTo().window(curWindow);
//		}
//
//		driver.close();
//
//		driver.switchTo().window(parentWindow);
//		Thread.sleep(5000);
//	}
//
//	@And("^hYPERLINKS user clicks on hyperlink for order number column$")
//	public void hYPERLINKS_user_clicks_on_hyperlink_for_order_number_column() throws InterruptedException {
//		Actions action = new Actions(driver);
//
//		action.moveToElement(driver.findElement(By.xpath("//div[2]/div[1]/table/tbody/tr[1]/td[5]/a"))).click().perform();
//		Thread.sleep(3000);
//	}
//
//	@And("^hYPERLINKS user observes second window pop up and clicks on view details link$")
//	public void hYPERLINKS_user_observes_second_window_pop_up_and_clicks_on_view_details_link() throws InterruptedException {
//		driver.switchTo().activeElement();
//
//		Actions action = new Actions(driver);
//
//		action.moveToElement(driver.findElement(By.xpath("//div[5]/div/div/div/div/div[3]/button"))).click().perform();
//		log.info("User observes second window pop up and clicks on view details link");
//
//		Thread.sleep(3000);
//	}
//	@And("^hYPERLINKS user closes the second browser for view details page$")
//	public void hYPERLINKS_user_close_the_second_browser_for_view_details_page() throws InterruptedException {
//		driver.switchTo().defaultContent();
//		String parentWindow = driver.getWindowHandle();
//		Set<String> allHandles = driver.getWindowHandles();
//
//		for(String curWindow : allHandles)
//		{
//			driver.switchTo().window(curWindow);
//		}
////		driver.close();
//		driver.switchTo().window(parentWindow);
//
//		Thread.sleep(3000);
//
//	}
//	@And("^hYPERLINKS user clicks on hyperlink for customer column$")
//	public void hYPERLINKS_user_clicks_on_hyperlink_for_customer_column() throws InterruptedException {
//
//		Actions action = new Actions(driver);
//
//		action.moveToElement(driver.findElement(By.xpath("//div[2]/div[1]/table/tbody/tr[1]/td[6]/a"))).click().perform();
//
//		log.info("User clicks on hyperlink for customer column");
//		Thread.sleep(3000);
//
//	}
//	@And("^hYPERLINKS user observes third window pop up and clicks on view details link$")
//	public void hYPERLINKS_user_observes_third_window_pop_up_and_clicks_on_view_details() throws InterruptedException {
//
//		driver.switchTo().activeElement();
//		Actions action = new Actions(driver);
//
//		action.moveToElement(driver.findElement(By.xpath("//div[5]/div/div/div/div/div[3]/button"))).click().perform();
//
//		log.info("User observes third window pop up and clicks on view details link");
//		Thread.sleep(3000);
//
//	}
//
//	@And("^hYPERLINKS user closes the third browser for view details page$")
//	public void hYPERLINKS_user_closes_the_third_browser_for_view_details_page() throws InterruptedException {
//
//		driver.switchTo().defaultContent();
//		String parentWindow = driver.getWindowHandle();
//		Set<String> allHandles = driver.getWindowHandles();
//
//		for(String curWindow : allHandles)
//		{
//			driver.switchTo().window(curWindow);
//		}
//
//		driver.close();
//		driver.switchTo().window(parentWindow);
//
//		Thread.sleep(3000);
//
//	}
////
////	@And("^hYPERLINKS user clicks on user account dropdown$")
////	public void hYPERLINKS_user_clicks_on_user_account_dropdown() throws InterruptedException {
////
////		Actions action = new Actions(driver);
////		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"page-header-user-dropdown\"]"))).click().perform();
////		Thread.sleep(3000);
////	}
////
////	@And("^hYPERLINKS user clicks on logout$")
////	public void hYPERLINKS_user_clicks_on_logout() {
////		Actions action = new Actions(driver);
////		WebElement logout = driver.findElement(By.xpath("//span[contains(text(),'Logout')]"));
////		action.moveToElement(logout).click().perform();
////		log.info("logged out successfully");
////	}
////
////	@And("^hYPERLINKS close the browser$")
////	public void hYPERLINKS_close_the_browser() {
////		driver.quit();
////		log.info("close the final browser successfully");
////	}
//
}