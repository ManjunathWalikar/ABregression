//package StepDefinitions;
//
//import java.awt.*;
//import java.awt.event.KeyEvent;
//import java.io.File;
//import java.io.IOException;
//import java.util.List;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//import com.sprint.qa.Pages.SubscriptionSearchEnginePage;
//import com.sprint.qa.helper.Helper;
//import io.cucumber.java.en.When;
//import org.apache.log4j.Logger;
//import org.junit.Assert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.Select;
//
//import com.sprint.qa.base.TestBase;
//import com.sprint.qa.helper.LoggerHelper;
//import com.sprint.qa.util.TestUtil;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//
//
//public class Reg01_SubscriptionSearchEngine_StepDefinition extends TestBase {
//
//    SubscriptionSearchEnginePage searchEngine = new SubscriptionSearchEnginePage(driver);
//    TestUtil testUtil;
//    Logger log = LoggerHelper.getLogger(LoggerHelper.class);
//    Helper help =new Helper();
//
//    public Reg01_SubscriptionSearchEngine_StepDefinition()
//    {
//        super(); // super class constructor to initialize properties
//    }
//
////	public void setUp() throws Exception
////	{
////		initialization();
////	}
//
//    @Given("^SEngine user is already on subscriptions page$")
//    public void SEngine_user_is_already_on_subscriptions_page() throws Exception
//    {
////         TestBase.initialization();
//
//        driver.navigate().to(prop.getProperty("qa_url"));
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//span[text()='Dashboard']")).click();
//        Thread.sleep(3000);
//        Actions action = new Actions(driver);
//        action.moveToElement(driver.findElement(By.xpath("//ul//li[3]//a[text()='Subscriptions']"))).doubleClick().build().perform();
//        Thread.sleep(3000);
//    }
//
//    @Given("^SEngine title of the login page is Subscriptions$")
//    public void SEngine_title_of_login_page_is_Subscriptions()
//    {
//        String title = driver.getTitle();
//        log.info(title);
//        Assert.assertEquals("Subscriptions", title);
//
//        log.info("User able to validate title successfully");
//    }
//
//    @And("^SEngine user clicks on view details link$")
//    public void SEngine_user_clicks_on_view_details_link() throws InterruptedException
//    { //already covered in above step
//       Thread.sleep(500);
//    }
//
//    @And("^SEngine user is on Subscription page$")
//    public void SEngine_user_is_on_Subscription_page() throws InterruptedException
//    {
//
//        String title = driver.getTitle();
//        log.info(title);
//        Assert.assertEquals("Subscriptions", title);
//        Thread.sleep(8000);
//
//    }
//
//    @And("^SEngine user clicks on first time add button$")
//    public void SEngine_user_clicks_on_first_time_add_button() throws InterruptedException
//    {
//        Actions action = new Actions(driver);
//        WebElement Add_button = driver.findElement(By.xpath("//div/i[@title='Add']"));
//        action.moveToElement(Add_button).click().perform();
//        Thread.sleep(3000);
//
//    }
//
//    @And("^SEngine user clicks on first subscription dropdown selects dropdown value$")
//    public void SEngine_user_clicks_on_subscription_dropdown_selects_dropdown_value() throws InterruptedException
//    {
//
//        Actions action = new Actions(driver);
//
//        WebElement Drpdwn = driver.findElement(By.xpath("(//select[@class='form-control h-100'])[1]"));
//        action.moveToElement(Drpdwn).click().perform();
//
//        Select DrpdwnAnyOption = new Select(driver.findElement(By.xpath("//div[1]/div[1]/div[1]/select")));
//        DrpdwnAnyOption.selectByVisibleText("True Forward");
//    }
//
//    @And("^SEngine user clicks on first dropdown and selects option$")
//    public void SEngine_user_clicks_on_first_dropdown_and_selects_option() {
//
//        Actions action = new Actions(driver);
//
//        action.moveToElement(driver.findElement(By.xpath("//div[3]/div[1]/div/div/div[1]/div[1]/div[1]/div[2]/div/div[1]/select"))).perform();
//        WebElement Drpdwn = driver.findElement(By.xpath("//div[3]/div[1]/div/div/div[1]/div[1]/div[1]/div[2]/div/div[1]/select"));
//        Drpdwn.click();
//
//        Select DrpdwnAnyOption = new Select(driver.findElement(By.xpath("//div[3]/div[1]/div/div/div[1]/div[1]/div[1]/div[2]/div/div[1]/select")));
//        DrpdwnAnyOption.selectByVisibleText("Yes");
//    }
//
//    @And("^SEngine user clicks on second time add button$")
//    public void SEngine_user_clicks_on_second_time_add_button() throws InterruptedException
//    {
//        WebElement Add_button = driver.findElement(By.xpath("//div/i[@title='Add']"));
//        Add_button.click();
//        Thread.sleep(3000);
//
//    }
//
//    @And("^SEngine user clicks on second subscription dropdown selects dropdown value$")
//    public void SEngine_user_clicks_on_second_subscription_dropdown_selects_dropdown_value() throws InterruptedException
//    {
//
//        Actions action = new Actions(driver);
//
//        action.moveToElement(driver.findElement(By.xpath("//div[3]/div[1]/div/div/div[1]/div[2]/div[1]/div[1]/select"))).perform();
//        WebElement Drpdwn = driver.findElement(By.xpath("//div[3]/div[1]/div/div/div[1]/div[2]/div[1]/div[1]/select"));
//        Drpdwn.click();
//
//        Select DrpdwnAnyOption = new Select(driver.findElement(By.xpath("//div[3]/div[1]/div/div/div[1]/div[2]/div[1]/div[1]/select")));
//        DrpdwnAnyOption.selectByVisibleText("Pending Cancellation");
//        Thread.sleep(3000);
//    }
//
//    @And("^SEngine user clicks on second dropdown and selects option$")
//    public void SEngine_user_clicks_on_second_dropdown_and_selects_option() throws InterruptedException {
//
//        Actions action = new Actions(driver);
//
//        action.moveToElement(driver.findElement(By.xpath("//div[2]/div[1]/div[2]/div/div[1]/select"))).perform();
//        WebElement Drpdwn = driver.findElement(By.xpath("//div[2]/div[1]/div[2]/div/div[1]/select"));
//        Drpdwn.click();
//
//        Select DrpdwnAnyOption = new Select(driver.findElement(By.xpath("//div[2]/div[1]/div[2]/div/div[1]/select")));
//        DrpdwnAnyOption.selectByVisibleText("No");
//        Thread.sleep(3000);
//    }
//
//    @And("^SEngine user clicks on search button$")
//    public void SEngine_user_clicks_on_search_button() throws InterruptedException {
//
//        WebElement search_button = driver.findElement(By.xpath("//button/i[@class='fas fa-search']"));
//        search_button.click();
//        Thread.sleep(3000);
//    }
//
//    @And ("^SEngine user clicks on save search button$")
//    public void SEngine_user_clicks_on_save_search_button() throws InterruptedException {
//        Actions act = new Actions(driver);
//        WebElement save_button = driver.findElement(By.xpath("//div/button[contains(text(),'Save')]"));
//        act.moveToElement(save_button).click().perform();
//        Thread.sleep(3000);
//
//    }
//
//    @And ("^SEngine user verifies message User Search Setting Saved$")
//    public void SEngine_user_verifies_message_User_Search_Setting_Saved() throws InterruptedException {
//
//        WebElement title = driver.findElement(By.xpath("//span[contains(text(),'User Search Setting Saved')]"));
//        String title1 = title.getText();
//        log.info(title1);
//        Assert.assertEquals("User Search Setting Saved", title1);
//        Thread.sleep(3000);
//    }
//
//    @And("^SEngine user unable to click on send renewal notice button$")
//    public void SEngine_user_unable_to_click_on_send_renewal_notice_button()throws InterruptedException{
//        Actions act = new Actions(driver);
//        WebElement srn_button = driver.findElement(By.xpath("//*[@id=\"datatable_wrapper\"]/div[1]/div[3]/div/button[1]"));
//        act.moveToElement(srn_button).click().perform();
//        Thread.sleep(3000);
//    }
//
//
//    @And("^SEngine user clicks on third time subscription dropdown selects dropdown value$")
//    public void SEngine_user_clicks_on_third_time_subscription_dropdown_selects_dropdown_value() throws InterruptedException
//    {
//
//        Actions action = new Actions(driver);
//        WebElement Drpdwn = driver.findElement(By.xpath("(//select[@class='form-control h-100'])[1]"));
//        action.moveToElement(Drpdwn).click().perform();
//        Drpdwn.click();
//
//        Select DrpdwnAnyOption = new Select(driver.findElement(By.xpath("//div[4]/div[1]/div/div/div[1]/div/div[1]/div[1]/select")));
//        DrpdwnAnyOption.selectByVisibleText("Status");
//        Thread.sleep(6000);
//    }
//
//    @And("^SEngine user clicks on third time dropdown and selects option$")
//    public void SEngine_user_clicks_on_third_time_dropdown_and_selects_option() throws InterruptedException {
//        Actions action = new Actions(driver);
//
//        WebElement Drpdwn = driver.findElement(By.xpath("//div[@class='multiselect__select']"));
//        action.moveToElement(Drpdwn).click().perform();
//
//        try {
//            List<WebElement> options = driver.findElements(By.xpath("//div/ul/li/span[@class='multiselect__option']"));
//            for(WebElement option : options) {
//                if(option.getText().trim().contains("Active")) {
//                    option.click();
//                }
//            }
//        }
//        catch(org.openqa.selenium.StaleElementReferenceException ex)
//        {
//            List<WebElement> options = driver.findElements(By.xpath("//div/ul/li/span[@class='multiselect__option']"));
//            for(WebElement option : options) {
//                if(option.getText().trim().contains("Active")) {
//                    option.click();
//                }
//            }
//        }
//
//        Thread.sleep(8000);
//
//        WebElement Drpdwn1 = driver.findElement(By.xpath("//div[@class='multiselect__select']"));
//        Drpdwn1.click();
//
//        try {
//            WebElement selected_option = driver.findElement(By.xpath("//div/ul/li[1]/span/span[contains(text(),'New')]"));
//            selected_option.click();
//        }
//
//        catch(org.openqa.selenium.StaleElementReferenceException ex)
//        {
//            WebElement selected_option = driver.findElement(By.xpath("//div/ul/li[1]/span/span[contains(text(),'New')]"));
//            selected_option.click();
//        }
//        Thread.sleep(3000);
//    }
//
//    @And("^SEngine user clicks on search button second time$")
//    public void SEngine_user_clicks_on_search_button_second_time() throws InterruptedException {
//        Actions action = new Actions(driver);
//
//        WebElement search_button2 = driver.findElement(By.xpath("//button/i[@class='fas fa-search']"));
//        action.moveToElement(search_button2);
//        search_button2.click();
//        Thread.sleep(3000);
//    }
//
//    @And("^SEngine user clicks on checkbox$")
//    public void SEngine_user_clicks_on_checkbox()throws InterruptedException{
//        Actions action = new Actions(driver);
//        WebElement Drpdwn = driver.findElement(By.xpath("//select[@class='form-control h-100']"));
//        action.moveToElement(Drpdwn).click().perform();
//
//        Select DrpdwnAnyOption = new Select(Drpdwn);
//        DrpdwnAnyOption.selectByVisibleText("Subs #");
//
//        Thread.sleep(5000);
//
//        WebElement sub_num = driver.findElement(By.xpath("//div[4]/div[1]/div/div/div[1]/div/div[1]/div[2]/div/div[1]/input"));
//        sub_num.clear();
//        sub_num.sendKeys(prop.getProperty("reg01_subNum"));
//
//        WebElement search_button2 = driver.findElement(By.xpath("//button/i[@class='fas fa-search']"));
//        action.moveToElement(search_button2);
//        search_button2.click();
//        Thread.sleep(3000);
//
//        Thread.sleep(3000);
//        // WebElement check_box = driver.findElement(By.xpath("//tbody/tr[1]/td/input[@type='checkbox']"));
//        WebElement check_box = driver.findElement(By.xpath("//input[@id='checkAllBulk']"));
//        check_box.click();
//        Thread.sleep(3000);
//    }
//
//    @And("^SEngine user able to click on send renewal notice button$")
//    public void SEngine_user_able_to_click_on_send_renewal_notice_button()throws InterruptedException{
//        WebElement srn_button = driver.findElement(By.xpath("//*[@id=\"datatable_wrapper\"]/div[1]/div[3]/div/button[1]"));
//        srn_button.click();
//        Thread.sleep(3000);
//    }
//
//    @And("^SEngine user able to click on x to close the popup message$")
//    public void SEngine_user_able_to_click_on_x_to_close_the_popup_message()throws InterruptedException{
//
//        Thread.sleep(3000);
//    }
//
//    @Then("^SEngine user able to click on export button and file gets downloaded$")
//    public void SEngine_user_able_to_click_on_export_button_and_file_gets_downloaded() throws InterruptedException{
//
//        Actions action = new Actions(driver);
//        try {
//            WebElement export_button = driver.findElement(By.xpath("//button[contains(text(),'Export')]"));
//            action.doubleClick(export_button).perform();
//            Thread.sleep(5000);
//            try {
//                File file2 =new File(download_path+File.separator+"SubscriptionList.xls");
//                Thread.sleep(6000);
//                org.testng.Assert.assertTrue(file2.exists());
//                file2.delete();
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//
//        catch(org.openqa.selenium.StaleElementReferenceException ex)
//        {
//            WebElement export_button = driver.findElement(By.xpath("//button[contains(text(),'Export')]"));
//            action.doubleClick(export_button).perform();
//        }
//
//        Thread.sleep(10000);
//    }
//
//
//    @And("^SEngine user able to click on column options first time$")
//    public void SEngine_user_able_to_click_on_column_options_first_time() throws InterruptedException {
//        WebElement co_button = driver.findElement(By.xpath("//div//button[contains(text(),'Column Options')]"));
//        co_button.click();
//        Thread.sleep(3000);
//
//    }
//    @And("^SEngine user selects available options and clicks add$")
//    public void SEngine_user_selects_available_options_and_clicks_add() throws InterruptedException {
//        driver.switchTo().activeElement();
//        WebElement co_button = driver.findElement(By.xpath("//div[1]/select[1]/option[1]"));
//        co_button.click();
//        Thread.sleep(3000);
//    }
//
//    @And("^SEngine user clicks on apply button first time$")
//    public void SEngine_user_clicks_on_apply_button_first_time() throws InterruptedException{
//
//        WebElement apply_button = driver.findElement(By.xpath("//div/button[contains(text(),\"Apply\")]"));
//        apply_button.click();
//        Thread.sleep(3000);
//
//    }
//    @And("^SEngine user able to click on column options second time$")
//    public void SEngine_user_able_to_click_on_column_options_second_time() throws InterruptedException {
//        WebElement co_button = driver.findElement(By.xpath("//div//button[contains(text(),'Column Options')]"));
//        co_button.click();
//        Thread.sleep(3000);
//
//
//    }
//    @And("^SEngine user selects already selection options and clicks on remove button$")
//    public void SEngine_user_selects_already_selection_options_and_clicks_on_remove_button() throws InterruptedException{
//        driver.switchTo().activeElement();
//        WebElement co_button = driver.findElement(By.xpath("//div[1]/select[1]/option[1]"));
//        co_button.click();
//        co_button.click();
//        Thread.sleep(3000);
//    }
//
//    @And("^SEngine user clicks on apply button second time$")
//    public void SEngine_user_clicks_on_apply_button_second_time() throws InterruptedException {
//        WebElement apply_button = driver.findElement(By.xpath("//div/button[contains(text(),'Apply')]"));
//        apply_button.click();
//        Thread.sleep(3000);
//    }
//
//    @And("^SEngine user able to click on column options third time$")
//    public void SEngine_user_able_to_click_on_column_options_third_time() throws InterruptedException {
//        WebElement co_button = driver.findElement(By.xpath("//div//button[contains(text(),'Column Options')]"));
//        co_button.click();
//        Thread.sleep(3000);
//    }
//
//    @Then("^SEngine user clicks on cancel button$")
//    public void SEngine_user_clicks_on_cancel_button() throws InterruptedException {
//        WebElement cancel_button = driver.findElement(By.xpath("//div/button[contains(text(),'Cancel')]"));
//        cancel_button.click();
//        Thread.sleep(3000);
//    }
//
//    @And("^SEngine user clicks on reset button on the search menu$")
//    public void SEngine_user_clicks_on_reset_button_on_the_search_menu() throws InterruptedException {
//        WebElement reset_button = driver.findElement(By.xpath("//div/a[@href='javascript:void(0)'][@class='link-color']"));
//        reset_button.click();
//        Thread.sleep(3000);
//    }
//
//    @And("^SEngine user unable to click the checkbox for cancelled status$")
//    public void SEngine_user_unable_to_click_the_checkbox_for_cancelled_status() throws InterruptedException {
//        Actions action = new Actions(driver);
//
//        //Search for cancelled subscriptions
//
//        WebElement Drpdwn = driver.findElement(By.xpath("(//select[@class='form-control h-100'])[1]"));
//        action.moveToElement(Drpdwn).click().perform();
//
//
//        Select DrpdwnAnyOption = new Select(driver.findElement(By.xpath("//div[4]/div[1]/div/div/div[1]/div[1]/div[1]/div[1]/select")));
//        DrpdwnAnyOption.selectByVisibleText("Status");
//
//
//        WebElement Drpdwn1 = driver.findElement(By.xpath("//div[@class='multiselect__select']"));
//        action.moveToElement(Drpdwn1).click().perform();
//
//        try {
//            List<WebElement> options = driver.findElements(By.xpath("//div/ul/li/span[@class='multiselect__option']"));
//            for(WebElement option : options) {
//                if(option.getText().trim().contains("Canceled")) {
//                    option.click();
//                }
//            }
//        }
//
//        catch(org.openqa.selenium.StaleElementReferenceException ex)
//        {
//            List<WebElement> options = driver.findElements(By.xpath("//div/ul/li/span[@class='multiselect__option']"));
//            for(WebElement option : options) {
//                if(option.getText().trim().contains("Canceled")) {
//                    option.click();
//                }
//            }
//        }
//
//        Thread.sleep(8000);
//
//        //click
//        WebElement title_subs = driver.findElement(By.xpath("//div[2]/div/div/div[3]/div/div/h4"));
//        title_subs.click();
//        Thread.sleep(3000);
//
//        WebElement search_button = driver.findElement(By.xpath("//button/i[@class='fas fa-search']"));
//        search_button.click();
//        Thread.sleep(3000);
//
//        WebElement checkbox_clk = driver.findElement(By.xpath("//div[2]/div[1]/table/tbody/tr[1]/td[1]"));
//        checkbox_clk.click();
//        Thread.sleep(3000);
//
//        log.info("unable to click the checkbox");
//    }
//
//    @And("^SEngine user able to filter entries display on page$")
//    public void SEngine_user_able_to_filter_entries_display_on_page() throws InterruptedException {
//
//        WebElement reset_button = driver.findElement(By.xpath("//div/a[@href='javascript:void(0)'][@class='link-color']"));
//        reset_button.click();
//        Thread.sleep(3000);
//
//        Actions action = new Actions(driver);
//
//        action.moveToElement(driver.findElement(By.xpath("//div/label/select[@name='datatable_length']"))).perform();
//        WebElement Drpdwn7 = driver.findElement(By.xpath("//div/label/select[@name='datatable_length']"));
//        action.moveToElement(Drpdwn7).click().perform();
//
//        Select Drp_entries = new Select(driver.findElement(By.xpath("//div/label/select[@name='datatable_length']")));
//        Drp_entries.selectByVisibleText("50");
//
//        Thread.sleep(3000);
//        JavascriptExecutor js1 = (JavascriptExecutor) driver;
//        js1.executeScript("window.scrollTo(0,document.body.scrollHeight)","");
//
//        Thread.sleep(3000);
//
//    }
//
//    @And("^SEngine user able to navigate to next page to check records$")
//    public void SEngine_user_able_to_navigate_to_next_page_to_check_records() throws InterruptedException {
//
//        try {
//            WebElement next_page1 = driver.findElement(By.xpath("//li/a[contains(text(),'Next')]"));
//            help.move_and_click(next_page1);
//        }
//        catch(org.openqa.selenium.StaleElementReferenceException ex)
//        {
//            WebElement next_page1 = driver.findElement(By.xpath("//ul/li/a[contains(text(),'Next')]"));
//            next_page1.click();
//        }
//
//        Thread.sleep(3000);
//    }
//
//
////	@And("^SEngine user clicks on user account dropdown$")
////	public void SEngine_user_clicks_on_user_account_dropdown() throws InterruptedException {
////
//////		Actions action = new Actions(driver);
//////		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"page-header-user-dropdown\"]"))).click().perform();
//////		Thread.sleep(3000);
////	}
//
////	@And("^SEngine user clicks on logout$")
////	public void SEngine_user_clicks_on_logout() {
////		Actions action = new Actions(driver);
////
////		WebElement logout = driver.findElement(By.xpath("//span[contains(text(),'Logout')]"));
////		action.moveToElement(logout).click().perform();
////	}
//
//    //	@And("^SEngine close the browser$")
////	public void SEngine_close_the_browser() {
////
////		// driver.quit();
////	}
//    @And("^SEngine user can see search filters$")
//    public void SEngine_user_can_see_search_filters() throws IOException, InterruptedException {
//        searchEngine.searchFilters();
//        searchEngine.verifySavedFilters();
//    }
//
//    @And("^SEngine user Clicks on Reset to System Defaults option$")
//    public void SEngine_user_Clicks_on_Reset_to_System_Defaults_option() throws InterruptedException {
//        searchEngine.resetToSystemDefault();
//    }
//
//    @And("^SEngine user can see search default filters as Created Date and Subs#$")
//    public void SEngine_user_can_see_search_default_filters_as_Created_Date_and_Subs() throws InterruptedException {
//        searchEngine.defaultFilters();
//    }
//
//    @And("^SEngine user clicks on second dropdown Order# and selects option$")
//    public void SEngine_user_clicks_on_second_dropdown_Order_and_selects_option() throws IOException, InterruptedException {
//        searchEngine.selectsOrder();
//    }
//
//    @And("^SEngine user inputs order#$")
//    public void SEngine_user_inputs_order() throws IOException, InterruptedException {
//        searchEngine.enterOrderDetails();
//    }
//    @And("^SEngine user inputs order# with space$")
//    public void SEngine_user_inputs_order_with_space() throws InterruptedException {
//        searchEngine.verifyErrorMessage();
//    }
//
//    @And("^SEngine verify Search button gets disabled when there is error on search filter$")
//    public void SEngine_verify_Search_button_gets_disabled_when_there_is_error_on_search_filter(){
//        searchEngine.verificationSearchButton();
//    }
//
//    @And("^SEngine user clicks on Clear button$")
//    public void SEngine_user_clicks_on_Clear_button() throws InterruptedException {
//        searchEngine.clickOnClearButton();
//    }
//
//    @And("^SEngine user adds few more filters like Status, Order#, Billing Frequency$")
//    public void SEngine_user_adds_few_more_filters() throws IOException, InterruptedException {
//        searchEngine.addingFilters();
//    }
//
//    @And("^SEngine user verifies saved filters$")
//    public void SEngine_user_verifies_saved_filters() throws InterruptedException {
//        searchEngine.verifyFilters();
//    }
//
//    @And("^SEngine user selects billing frequency as Monthly$")
//    public void SEngine_user_selects_billing_frequency_as_Monthly() throws IOException, InterruptedException {
//        searchEngine.billingFrequencyMonthly();
//    }
//
//    @And("^SEngine user expands Status and verifies values$")
//    public void SEngine_user_expands_Status_and_verifies_values() throws IOException, InterruptedException {
//        searchEngine.selectStatus();
//    }
//
//    @And("^SEngine user selects Status filter as New, Active and Expired$")
//    public void SEngine_user_selects_Status_filter_New_Active_Expired() throws IOException, InterruptedException {
//        searchEngine.statusSelection();
//    }
//
//    @And("^SEngine user selects Clicks on Collapse search button$")
//    public void SEngine_user_selects_Clicks_on_Collapse_search_button() throws InterruptedException {
//        searchEngine.clickOnCollapseSearch();
//    }
//
//    @And("^SEngine user verifies all selected search options are getting displayed in capsule$")
//    public void SEngine_user_verifies_all_selected_search_options_getting_displayed_capsule() throws InterruptedException {
//        searchEngine.filtersInCapsule();
//    }
//
//    @And("^SEngine user click modify search button to expand all search filter$")
//    public void SEngine_user_click_modify_search_button_to_expand_all_search_filter() throws InterruptedException {
//        searchEngine.modifyFilters();
//    }
//
//    @And("^SEngine user removes Expired option from Status filter$")
//    public void SEngine_user_removes_Expired_option_from_Status_filter() throws InterruptedException {
//        searchEngine.removeExpiredStatus();
//    }
//
//    @And("^SEngine user clicks on Collapse search button$")
//    public void SEngine_user_clicks_on_Collapse_search_button() throws InterruptedException {
//        searchEngine.verifyExpiredStatus();
//        searchEngine.modifyFilters();
//    }
//
//    @And("^SEngine user Filters Active status subscriptions$")
//    public void SEngine_user_Filters_Active_status_subscriptions() throws IOException, InterruptedException {
//        searchEngine.activeStatusSub();
//    }
//
//    @And("^SEngine user clicks on checkbox Active Status$")
//    public void SEngine_user_clicks_checkbox_Active_Status() throws InterruptedException {
//        searchEngine.selectCheckbox();
//    }
//
//    @And("^SEngine user verifies send renewal notice button is enabled$")
//    public void SEngine_user_verifies_send_renewal_notice_button_is_enabled() throws InterruptedException {
//        searchEngine.verifySendRenewalBtn();
//    }
//
//    @And("^SEngine user clicks on send renewal notice button$")
//    public void SEngine_user_clicks_on_send_renewal_notice_button() throws InterruptedException {
//        searchEngine.sendRenewalNotice();
//    }
//
//    @And("^SEngine user selects multiple subscriptions select top 5 using Checkbox$")
//    public void SEngine_user_selects_multiple_subscriptions_using_Checkbox() throws InterruptedException {
//        searchEngine.selectionOfMultipleCheckbox();
//        searchEngine.verifySendRenewalBtn();
//        searchEngine.sendRenewalNotice();
//    }
//
//    @And("^SEngine user Filters Overdue status subscriptions$")
//    public void SEngine_user_Filters_Overdue_status_subscriptions() throws IOException, InterruptedException {
//        searchEngine.overDueStatus();
//        searchEngine.verifySendRenewalBtn();
//        searchEngine.selectCheckbox();
//        searchEngine.sendRenewalNotice();
//    }
//
//    @And("^SEngine user Filters Expired status subscriptions$")
//    public void SEngine_user_Filters_Expired_status_subscriptions() throws IOException, InterruptedException {
//        searchEngine.expiredStatus();
//        searchEngine.verifySendRenewalBtn();
//        searchEngine.clickOnActionColumn();
//    }
//
//    @And("^SEngine user verifies in Action column send renewal notice option is displayed$")
//    public void SEngine_user_verifies_Action_column_send_renewal_notice_option_displayed() throws IOException, InterruptedException {
//        searchEngine.activeStatusSub();
//        searchEngine.activeStatusActionColumn();
//    }
//
//    @When("open new tab in browser window")
//    public void openNewTabWithQaDashboard() throws AWTException, InterruptedException {
//        Thread.sleep(2000);
////        help.move_and_click("//span[contains(text(),'Dashboard')]");
////        Thread.sleep(4000);
////        robot = new Robot();
////        robot.setAutoDelay(500);
////        robot.keyPress(KeyEvent.VK_CONTROL);
////        robot.keyPress(KeyEvent.VK_T);
////        robot.keyRelease(KeyEvent.VK_T);
////        robot.keyRelease(KeyEvent.VK_CONTROL);
////        Thread.sleep(2000);
////        allwindows=driver.getWindowHandles();
////        driver.switchTo().window(allwindows.stream()
////                .filter(x->{
////                    return driver.switchTo().window(x).getTitle().equalsIgnoreCase("New Tab");
////                }).collect(Collectors.toList()).get(0));
//        driver.navigate().to(prop.getProperty("qa_url"));
//    }
//
//}
