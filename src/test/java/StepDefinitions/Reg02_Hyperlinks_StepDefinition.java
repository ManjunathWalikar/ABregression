package StepDefinitions;
import java.util.Set;

import com.sprint.qa.helper.Helper;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.sprint.qa.base.PageObjects;
import com.sprint.qa.base.TestBase;
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@After
	public void closeBrowser()
	{
		driver.quit();
	}
	
	@Given("Navigate to US Fund Finder Page")
	public void navigate_to_us_fund_finder_page() {
		
	}
	
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
	
	@And("^I click on Investment$")
	public void click_on_investment()
	{
		po.home_page.clickOnInvestment();
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

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Given("^hYPERLINKS user is already on Dashboard page$")
	public void hYPERLINKS_user_is_already_on_Dashboard_page() throws Exception
	{
//		TestBase.initialization();
		driver.navigate().to(prop.getProperty("qa_url"));
		Thread.sleep(8000);
		driver.findElement(By.xpath("//span[text()='Dashboard']")).click();
	}

	@When("^hYPERLINKS title of the Dashboard page is Dashboard$")
	public void hYPERLINKS_title_of_Dashboard_page_is_Dashboard() throws InterruptedException
	{
		String title = driver.getTitle();
		log.info(title);
		System.out.println(title);
		Thread.sleep(6000);
	}

	@And("^hYPERLINKS user clicks on view details link$")
	public void hYPERLINKS_user_clicks_on_view_details_link()
	{
		help.fluent_wait_click_not_interactable("//a[@class='order-link']/a[@href='#/subscriptions?status=1']");
		//driver.findElement(By.xpath("//a[@class='order-link']/a[@href='#/subscriptions?status=1']")).click();
	}

	@And("^hYPERLINKS user is on Subscription page$")
	public void hYPERLINKS_user_is_on_Subscription_page() throws InterruptedException
	{

		String title = driver.getTitle();
		log.info(title);
		//Assert.assertEquals("Subscriptions", title);
		Thread.sleep(8000);

	}

	@And("^hYPERLINKS user clicks on subscription dropdown selects dropdown value$")
	public void hYPERLINKS_user_clicks_on_subscription_dropdown_selects_dropdown_value() throws InterruptedException
	{

		Thread.sleep(3000);
	}

	@And("^hYPERLINKS user clicks on second dropdown and selects option$")
	public void hYPERLINKS_user_clicks_on_second_dropdown_and_selects_option() throws InterruptedException {
		Actions action = new Actions(driver);

		WebElement Drpdwn = driver.findElement(By.xpath("//div[3]/div[1]/div/div/div[1]/div/div[1]/div[1]/select"));
		action.moveToElement(Drpdwn).click().perform();
		Drpdwn.click();

		Select DrpdwnAnyOption = new Select(driver.findElement(By.xpath("//div[3]/div[1]/div/div/div[1]/div/div[1]/div[1]/select")));
		DrpdwnAnyOption.selectByVisibleText("Subs #");
		Thread.sleep(5000);

		WebElement sub_num = driver.findElement(By.xpath("//div[3]/div[1]/div/div/div[1]/div/div[1]/div[2]/div/div[1]/input"));
		sub_num.clear();
		sub_num.sendKeys(prop.getProperty("reg02_subNum"));

		Thread.sleep(3000);
	}

	@And("^hYPERLINKS user clicks on search button$")
	public void hYPERLINKS_user_clicks_on_search_button() throws InterruptedException {
		Actions action = new Actions(driver);

		WebElement search_button2 = driver.findElement(By.xpath("//button/i[@class='fas fa-search']"));
		action.moveToElement(search_button2);
		search_button2.click();
		Thread.sleep(5000);
	}

	@And("^hYPERLINKS user clicks on column options button$")
	public void hYPERLINKS_user_clicks_on_column_options_button() throws InterruptedException {

		WebElement co_button = driver.findElement(By.xpath("//div[4]/div/div[1]/div[3]/div/button[3]"));
		co_button.click();

		log.info("User clicks on column options button");
		Thread.sleep(3000);
	}

	@And("^hYPERLINKS user adds order number column and click apply$")
	public void hYPERLINKS_user_adds_order_number_column_and_click_apply() throws InterruptedException {

		Actions action = new Actions(driver);

		driver.switchTo().activeElement();


		action.moveToElement(driver.findElement(By.xpath("//div[4]/div/div/div/div/div[2]/div/div/div[1]/div/div/select/option[1]"))).perform();
		WebElement right_list_ele = driver.findElement(By.xpath("//div[4]/div/div/div/div/div[2]/div/div/div[1]/div/div/select/option[1]"));
		right_list_ele.click();

		Thread.sleep(3000);

		action.moveToElement(driver.findElement(By.xpath("//div[4]/div/div/div/div/div[2]/div/div/div[1]/div/div/div/a[1]"))).perform();
		WebElement arrow_right = driver.findElement(By.xpath("//div[4]/div/div/div/div/div[2]/div/div/div[1]/div/div/div/a[1]"));
		arrow_right.click();

		Thread.sleep(3000);

		action.moveToElement(driver.findElement(By.xpath("//div[4]/div/div/div/div/div[2]/div/div/div[2]/div/div/select/option[10]"))).perform();
		WebElement highlight_ele = driver.findElement(By.xpath("//div[4]/div/div/div/div/div[2]/div/div/div[2]/div/div/select/option[10]"));
		highlight_ele.click();
		Thread.sleep(3000);

		action.moveToElement(driver.findElement(By.xpath("//div[4]/div/div/div/div/div[2]/div/div/div[2]/div/div/div/a[1]"))).perform();
		WebElement arrow_up = driver.findElement(By.xpath("//div[4]/div/div/div/div/div[2]/div/div/div[2]/div/div/div/a[1]"));

		arrow_up.click();
		Thread.sleep(1000);

		arrow_up.click();
		Thread.sleep(1000);

		arrow_up.click();
		Thread.sleep(1000);

		arrow_up.click();
		Thread.sleep(1000);

		arrow_up.click();
		Thread.sleep(1000);

		arrow_up.click();

		driver.switchTo().activeElement();

		action.moveToElement(driver.findElement(By.xpath("//div[4]/div/div/div/div/div[3]/button[1]"))).perform();
		WebElement apply_button= driver.findElement(By.xpath("//div[4]/div/div/div/div/div[3]/button[1]"));
		apply_button.click();

		Thread.sleep(3000);
	}

	@And("^hYPERLINKS user clicks on hyperlink of subscription number column$")
	public void hYPERLINKS_user_clicks_on_hyperlink_of_subscription_number_column() throws InterruptedException {

		Actions action = new Actions(driver);

		action.moveToElement(driver.findElement(By.xpath("//a[text()='"+prop.getProperty("reg02_subNum")+"']"))).click().perform();
		Thread.sleep(5000);
	}

	@And("^hYPERLINKS user observes first window pop up and clicks on view details link$")
	public void hYPERLINKS_user_observes_first_window_pop_up_and_clicks_on_view_details_link() throws InterruptedException {

		log.info("User observes first window pop up and clicks on view details link");
		Thread.sleep(5000);
	}

	@And("^hYPERLINKS user closes the first browser for view details page$")
	public void hYPERLINKS_user_close_the_first_browser_for_view_details_page() throws InterruptedException {
		driver.switchTo().defaultContent();

		String parentWindow = driver.getWindowHandle();

		Set<String> allHandles = driver.getWindowHandles();

		for(String curWindow : allHandles)
		{
			driver.switchTo().window(curWindow);
		}

		driver.close();

		driver.switchTo().window(parentWindow);
		Thread.sleep(5000);
	}

	@And("^hYPERLINKS user clicks on hyperlink for order number column$")
	public void hYPERLINKS_user_clicks_on_hyperlink_for_order_number_column() throws InterruptedException {
		Actions action = new Actions(driver);

		action.moveToElement(driver.findElement(By.xpath("//div[2]/div[1]/table/tbody/tr[1]/td[5]/a"))).click().perform();
		Thread.sleep(3000);
	}

	@And("^hYPERLINKS user observes second window pop up and clicks on view details link$")
	public void hYPERLINKS_user_observes_second_window_pop_up_and_clicks_on_view_details_link() throws InterruptedException {
		driver.switchTo().activeElement();

		Actions action = new Actions(driver);

		action.moveToElement(driver.findElement(By.xpath("//div[5]/div/div/div/div/div[3]/button"))).click().perform();
		log.info("User observes second window pop up and clicks on view details link");

		Thread.sleep(3000);
	}
	@And("^hYPERLINKS user closes the second browser for view details page$")
	public void hYPERLINKS_user_close_the_second_browser_for_view_details_page() throws InterruptedException {
		driver.switchTo().defaultContent();
		String parentWindow = driver.getWindowHandle();
		Set<String> allHandles = driver.getWindowHandles();

		for(String curWindow : allHandles)
		{
			driver.switchTo().window(curWindow);
		}
//		driver.close();
		driver.switchTo().window(parentWindow);

		Thread.sleep(3000);

	}
	@And("^hYPERLINKS user clicks on hyperlink for customer column$")
	public void hYPERLINKS_user_clicks_on_hyperlink_for_customer_column() throws InterruptedException {

		Actions action = new Actions(driver);

		action.moveToElement(driver.findElement(By.xpath("//div[2]/div[1]/table/tbody/tr[1]/td[6]/a"))).click().perform();

		log.info("User clicks on hyperlink for customer column");
		Thread.sleep(3000);

	}
	@And("^hYPERLINKS user observes third window pop up and clicks on view details link$")
	public void hYPERLINKS_user_observes_third_window_pop_up_and_clicks_on_view_details() throws InterruptedException {

		driver.switchTo().activeElement();
		Actions action = new Actions(driver);

		action.moveToElement(driver.findElement(By.xpath("//div[5]/div/div/div/div/div[3]/button"))).click().perform();

		log.info("User observes third window pop up and clicks on view details link");
		Thread.sleep(3000);

	}

	@And("^hYPERLINKS user closes the third browser for view details page$")
	public void hYPERLINKS_user_closes_the_third_browser_for_view_details_page() throws InterruptedException {

		driver.switchTo().defaultContent();
		String parentWindow = driver.getWindowHandle();
		Set<String> allHandles = driver.getWindowHandles();

		for(String curWindow : allHandles)
		{
			driver.switchTo().window(curWindow);
		}

		driver.close();
		driver.switchTo().window(parentWindow);

		Thread.sleep(3000);

	}
//
//	@And("^hYPERLINKS user clicks on user account dropdown$")
//	public void hYPERLINKS_user_clicks_on_user_account_dropdown() throws InterruptedException {
//
//		Actions action = new Actions(driver);
//		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"page-header-user-dropdown\"]"))).click().perform();
//		Thread.sleep(3000);
//	}
//
//	@And("^hYPERLINKS user clicks on logout$")
//	public void hYPERLINKS_user_clicks_on_logout() {
//		Actions action = new Actions(driver);
//		WebElement logout = driver.findElement(By.xpath("//span[contains(text(),'Logout')]"));
//		action.moveToElement(logout).click().perform();
//		log.info("logged out successfully");
//	}
//
//	@And("^hYPERLINKS close the browser$")
//	public void hYPERLINKS_close_the_browser() {
//		driver.quit();
//		log.info("close the final browser successfully");
//	}

}