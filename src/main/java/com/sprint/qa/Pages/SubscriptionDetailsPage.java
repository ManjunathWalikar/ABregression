package com.sprint.qa.Pages;

import com.sprint.qa.base.TestBase;
import com.sprint.qa.helper.Helper;
import com.sprint.qa.helper.LoggerHelper;
import io.cucumber.java.bs.A;
import io.cucumber.java.ht.Le;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.text.ParseException;
import java.util.*;
import java.util.List;

public class SubscriptionDetailsPage extends TestBase {

    Logger log = LoggerHelper.getLogger(LoggerHelper.class);
    Helper help =new Helper();
    // Subscription page web elements
    public String description="";
    public static Boolean invoice_check = Boolean.TRUE;
    public String vertical_menu_btn="//button[@id='vertical-menu-btn']";
    public String subscription_number_filter="//div[@class='main-content']//div[2]//div[1]//div[1]//select[1]";
    public String created_date_filter="//body//div[@class='row']//div[@class='row']//div[1]//div[1]//div[1]//select[1]";
    public String add_filter_btn= "//i[@class='fas fa-plus-circle text-success fa-lg']";
    public String customer_PO = "//div[normalize-space()='Customer PO #:']/..//label";
    public String purchase_order = "//div[normalize-space()='Purchase Order #:']/..//label";
    public String auto_renewal = "//div[@class='row details']//div[contains(text(),'Auto Renewal:')]/..//label";
    public String auto_renewal_term = "//div[@class='row details']//div[contains(text(),'Auto Renewal Term:')]/..//label";

    public String status = "//h4[contains(text(),'Status:')]/span";
    public String requested_start_date="//div[contains(text(),'Requested Start Date:')]";
    public String start_date = "//div[contains(text(),'Start Date:')]/..//label";
    public String anniversary_date = "//div[contains(text(),'Anniversary Date:')]/..//label";
    public String days_left = "//h4[contains(text(),'Days Left:')]//span";
    public String subscriptions_dropdown_filter_1 = "//body//div[@class='row']//div[@class='row']//div[1]//div[1]//div[1]//select[1]";
    public String subscriptions_search_btn = "//button[@class='btn btn-md btn-primary waves-effect waves-light']";
    public String invoice_by_dropdown = "//div[contains(text(),'Invoice By:')]/..//select";
//    public String invoice_by_label = "//div[contains(text(),'Invoice By:')]/..//label";
    public String save_btn_1 = "//div[@id='Subscription']//div[@class='button-top']//button[@class='btn btn-md btn-primary waves-effect waves-light'][contains(text(),'Save')]";
    public String save_btn_general_info_1 = "//div[@class='tab-content-body']//div//div[@class='button-top']//button[@class='btn btn-md btn-primary waves-effect waves-light'][contains(text(),'Save')]";
    public String history_tab_subs_page = "//div[@class='subscription-tab']//li[3]//a[1]";
    public String subscription_details_tab_subs_page = "//div[@id='layout-wrapper']//div//div//div//div//div//ul//a[contains(text(),'Subscription Details')]";
    public String audit_subs_page = "//body/div[@id='layout-wrapper']/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/h4[1]";
    public String latest_audit_subs_page ="//div[@id='layout-wrapper']/div[2]/div/div/div[3]/div/div/div[3]//div[@id='third']//tbody/tr[1]/td[4]/div[1]";
    public String true_forward_toggle_btn_subs_page = "//input[@id='renewSwitch']";
    public String customer_invoice_notes_subs_page ="//div[@id='billingInfo']//div//div//div//div//textarea";
    public String hold_invoice_processing_btn = "//div[contains(text(),'Hold Invoice Processing:')]/..//input";
    public String renewal_notification_btn = "//div[contains(text(),'Renewal Notification:')]/..//input";
    public String show_on_portal_btn = "//div[contains(text(),'Show On Portal:')]/..//input";
    public String subscription_detail_header = "//h4[contains(text(),'Subscription Details')]";
    public String cust_name_subs_page = "//div[contains(text(),'Customer Name:')]";
    public String manufacturer_subs_page = "//div[contains(text(),'Manufacturer:')]";
    public String vendor_subscription = "//div[contains(text(),'Vendor Subscription #:')]";
    public String Customer_Site_Admin = "//div[contains(text(),'Customer Site Admin:')]";
    public String Start_date = "//div[contains(text(),'Start Date:')]";
    public String End_date = "//body/div//descendant::div[74]//div[contains(text(),'End Date:')]";
    public String Anniversary_Date = "//div[contains(text(),'Anniversary Date:')]";
    public String Auto_renewal = "//div[contains(text(),'Auto Renewal:')]";
    public String Initial_Term = "//div[contains(text(),'Initial Term:')]";
    public String True_forward = "//div[contains(text(),'True Forward:')]";
    public String cust_name_hyperlink = "//div[contains(text(),'Customer Name:')]/..//a";
    public String Billing_Frequency_Vendor = "//div[contains(text(),'Billing Frequency (Vendor):')]";
    public String Billing_Frequency_Customer = "//div[contains(text(),'Billing Frequency (Customer):')]";
    public String Hold_Invoice_Processing = "//div[contains(text(),'Hold Invoice Processing:')]";
    public String Party_Biller = "//div[contains(text(),'3rd Party Biller:')]";
    public String Customer_Invoice_Notes = "//div[@id='billingInfo']//div[contains(text(),'Customer Invoice Notes:')]";
    public String Invoice_by = "//div[contains(text(),'Invoice By:')]";
    public String Renewal_notification="//div[contains(text(),'Renewal Notification:')]";
    public String Show_on_portal ="//div[contains(text(),'Show On Portal:')]";
    public String Total_amount = "//div[contains(text(),'Total Amount:')]";
    public String Total_cost= "//div[contains(text(),'Total Cost:')]";
    public String Margin = "//div[contains(text(),'Margin:')]";
    public String Margin_percent = "//div[contains(text(),'Margin %:')]";
    public String Recurring_amount = "//div[contains(text(),'Recurring Amount (Prepaid):')]";
    public String more_action_btn_1 = "//body/div[@id='layout-wrapper']/descendant::div[44]/button";//div[@class='tab-pane fade show active']//div[@class='button-top']//button[@class='btn btn-primary waves-effect waves-light dropdown-toggle btn-md'][contains(text(),'More Actions')]";
    public String more_action_btn_1_list = "//div[@class='tab-pane fade show active']//div[@class='button-top']//button[@class='btn btn-primary waves-effect waves-light dropdown-toggle btn-md'][contains(text(),'More Actions')]/..//div[@class='dropdown-menu dropdown-menu-right']//a";
    public String line_items_table = "//div[@id='Active']//div//div//div[@id='table-vertical-scroll']//div//div//table";
    public String line_items_table_rows = "//div[@id='Active']//div//div//div[@id='table-vertical-scroll']//div//div//tbody";
    public List<WebElement> more_actions_options_list;
    public List<WebElement> initiate_changes_otions;
    public String initate_changes_options_ok_btn = "//button[contains(text(),'Ok')]";
    public String customerinvoicenotesprevioustext = "//div[contains(text(),'Title :')]/..//input";
    public boolean previousstate_boolean = Boolean.TRUE;
    public String subcription_credit_model_mask = "//div[@class='modal-mask']";
    public String sub_credit_model_title = "//h5[@class='modal-title']";
    public String sub_credit_model_title_close= "//button[@class='close']";
    public String line_items_active_tab = "//a[contains(text(),'Active')]";
    public String line_items_history_tab = "//div[@id='Subscription']//div//div//a[contains(text(),'History')]";
    public String general_info_tab ="//a[contains(text(),'General Information')]";
    public String[] general_info_tab_sections = {"//h4[contains(text(),'Order Information')]","//h4[contains(text(),'Vendor Information')]","//h4[contains(text(),'General Information')]","//h4[contains(text(),'Attachments')]"};
    public String[] general_info_order_info_fields = {"//div[contains(text(),'Original Sales Order #:')]", "//div[contains(text(),'Customer PO #:')]", "//div[contains(text(),'Order Type:')]", "//div[contains(text(),'Contract Vehicle:')]", "//div[contains(text(),'Sales Order Processing Notes:')]"};
    public String[] general_info_vendor_info_fields ={"//div[contains(text(),'Vendor:')]","//div[contains(text(),'Purchase Order #:')]","//div[contains(text(),'Deal ID:')]","//div[contains(text(),'Vendor Success Manager:')]","//div[contains(text(),'Organization ID:')]"};
    public String[] general_info_gen_info_fields={"//div[contains(text(),'Account Manager:')]","//div[contains(text(),'Inside Sales Rep:')]","//div[contains(text(),'Business Development Manager:')]","//div[contains(text(),'Presidio Success Manager:')]"};
    public String related_docs_tab = "//a[contains(text(),'Related Documents')]";
    public String vendor_id="//div[contains(text(),'Vendor Subscription #:')]/..//input";
    public String manufacture_parts="//div[@id='Subscription']/div/div[3]/div/descendant::div[9]//tbody/tr[1]/td[3]/div";
    public String quantity="//div[@id='Subscription']/div/div[3]/div/descendant::div[9]//tbody/tr[1]/td[5]";
    public String purchase_order_label ="//div[contains(text(),'Purchase Order #:')]/..//label";
    public String upload_file_name="",upload_file_attachment_type="";
    int total_no_of_uploaded_attachments = 0;
    public SubscriptionDetailsPage(WebDriver driver){
    	PageFactory.initElements(driver, this);
        this.driver =driver;
    }
    @FindBy(xpath = "//div[@id='Subscription']/div/div[3]/div/descendant::div[9]//tbody/tr[1]/td[5]")
    private WebElement element;
    
    public void clickOnpage()
    {
    	try {
    		element.click();
        	log.info("Click on Page");
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOf(element));
			element.click();
		}
    	
    }
    
    
    
    
    
    
    public void verify_vertical_menu_btn(){
        element = get_element((vertical_menu_btn));
        element.click();
    }

    public List<WebElement> get_initiate_changes_otions(){
        initiate_changes_otions =driver.findElements(By.xpath("//h5[contains(text(),'Initiate Change')]/../..//label"));
        return initiate_changes_otions;
    }

//    public List<WebElement> getMore_actions_options_list(){
//        return help.get_elements(more_action_btn_1_list);
//    }

    public List<WebElement> get_more_action_options(){
        more_actions_options_list = select_unordered_list("//div[@id='Subscription']/div/div[1]/div/div[1]/div//button[contains(text(),'More Actions')]/../div","a");
        return more_actions_options_list;
    }

    public void verify_audit_history_tab_displayed(){
        element = get_element("//div[@id='History']//div[2]//div[1]//div[1]//div[1]//h4[1]");
        Assert.assertTrue(element.isDisplayed());
    }
    public void verify_audit_history_tab_columns(){
        List<WebElement> columns = select_unordered_list("//div[@id='third']//div[@id='table-vertical-scroll']//div//div//thead//tr","th");
        String[] column_names = {"Date & Time","By","Type","Description"};
        int count = 0;
        for(WebElement ele: columns){
            Assert.assertEquals(column_names[count],ele.getText());
            count++;
        }
    }
    public void verify_audit_history_tab_no_pagination(){
        List<WebElement> items = driver.findElements(By.xpath("//*[@class='pagination']"));
        Assert.assertEquals(1, items.size());
    }
    public void verify_audit_subscription_history_columns(){
        List<WebElement> columns = select_unordered_list("//div[@id='HistoryInformationdiv']//thead[@class='thead-light']//tr","th");
        String[] column_names = {"Change Order #", "Type","Title","Account Manager","Created By","Start Date","End Date","Booking Amount","Effective Amount"};
        int no_of_columns = columns.size();
        for(int i=1;i<=no_of_columns;i++){
            element = get_element("//div[@id='History']//div[@class='row']//th["+i+"]//div[1]");
            Assert.assertEquals(column_names[(i-1)],element.getText());
        }
    }
    public void verify_change_order_with_3(){
        String change_order=get_element_text("//div[@class='text-truncate']//a[@class='order-link']");
        Assert.assertTrue(change_order.startsWith("3"));
    }
    public void verify_subscription_history_pagination(){
        List<WebElement> items = select_unordered_list("//ul[@class='pagination']","li");
        Assert.assertEquals("Previous",get_element_text("//div[@id='History']//li[1]//a[1]"));
        Assert.assertEquals("Next",get_element_text("//div[@id='History']//li["+items.size()+"]//a[1]"));
    }

    public void verify_audit_subscription_history_displayed() throws InterruptedException {
        Thread.sleep(3000);
        help.move_and_click(history_tab_subs_page);
        //Thread.sleep(8000);
        help.wait_text_to_be_present_in_element("//h4[contains(text(),'Subscription History')]","Subscription History");
        Assert.assertTrue(get_element("//h4[contains(text(),'Subscription History')]").isDisplayed());
    }

    public void verify_no_of_attachments() throws InterruptedException {
        Thread.sleep(3000);
        List<WebElement> type_of_attachments = driver.findElements(By.xpath("//div[@id='attachementdiv']/div//h4"));
        int count = 1;
//        for (WebElement ta: type_of_attachments){
//            List<WebElement> files = ta.findElements(By.xpath("li"));
//            total_no_of_uploaded_attachments = total_no_of_uploaded_attachments+files.size();
//        }
        total_no_of_uploaded_attachments = driver.findElements(By.xpath("//div[@id='attachementdiv']//li")).size();
        Assert.assertEquals("Attachments ("+total_no_of_uploaded_attachments+")",get_element_text("//div[@id='Information']//div//div//div//div//div//div//div//div//div//div//h4"));
//        wait_element_tobe_present("//a[contains(@class,'auto-pointer')]//span");
//        if (!(previousstate_boolean == Boolean.TRUE)) {
//            Assert.assertEquals(upload_file_name,get_element_text("//a[contains(@class,'auto-pointer')]//span"));
//        } else {
//            Assert.assertEquals(upload_file_name+" (Internal)","");
//        }
    }
    public void verify_upload_file_with_different_type() throws InterruptedException {
//        help.move_and_click("//button[contains(text(),'Upload')]");
//        help.move_and_click("//div[@class='dropbox']");
        WebElement upload_btn = driver.findElement(By.xpath("//button[contains(text(),'Upload')][@class='btn btn-md btn-primary btn-sm']"));
        action.moveToElement(upload_btn).click().perform();
        Thread.sleep(3000);
//        String filename = "src/test/resources/Order.pdf";
//        upload_file(filename);
        driver.switchTo().activeElement();

        try {

            WebElement browse = driver.findElement(By.xpath("//form/div/input"));
            File file1 = new File("src/test/resources/Order.pdf");
            browse.sendKeys(file1.getAbsolutePath());

        } catch (org.openqa.selenium.StaleElementReferenceException ex) {

            WebElement browse = driver.findElement(By.xpath("//form/div/input"));
            File file1 = new File("src/test/resources/Order.pdf");
            browse.sendKeys(file1.getAbsolutePath());

        }
        Thread.sleep(3000);
        log.info("pdf file uploaded successfully");

        String[] fields = {"//div[@class='modal-body']/.//input[@type='text']","//div[@class='modal-body']/.//input[@type='checkbox']","//div[@class='modal-body']/.//select"};
        int count = 1;
        for (String s : fields){
            switch (count){
                case 1:
                    element = get_element(s);
                    element.sendKeys(randomString());
                    count++;
                    break;
                case 2:
                    element = get_element(s);
                    move_and_click(s);
                    count++;
                    break;
                case 3:
                    select_drop_down(s,"Email Authorization");
                    count++;
                    help.move_and_click("//button[contains(text(),'Attach & Close')]");
                    break;
            }
        }
    }
    public void verify_upload_file_delete_btn() throws InterruptedException {
        List<WebElement> type_of_attachments = driver.findElements(By.xpath("//div[@id='attachementdiv']/div//h4"));
        int count = 1;
        for (WebElement ta: type_of_attachments){
            List<WebElement> files = select_unordered_list("//div[@id='attachementdiv']/div//h4/..//ul","li");
            total_no_of_uploaded_attachments = total_no_of_uploaded_attachments+files.size();
        }
        String no_of_attchments_before_delete = get_element_text("//div[@id='Information']//div//div//div//div//div//div//div//div//div//div//h4");
        element=get_element("//body//div[@class='gray-section no-space']//div//div[1]//div[1]//ul[1]//li[1]//a[2]//i[1]");
        js_click(element);
        help.move_and_click("//button[contains(text(),'OK')]");
        Thread.sleep(3000);
        String no_of_attchments_after_delete = get_element_text("//div[@id='Information']//div//div//div//div//div//div//div//div//div//div//h4");
    }

    public void verify_upload_file_btns_enabled(){
        String[] buttons = {"//div[contains(@class,'modal-footer')]//button[1]","//button[contains(@class,'btn btn-outline-primary btn-md waves-effect waves-light')]"};
        for(String s:buttons){
         Assert.assertTrue(get_element(s).isEnabled());
        }
    }
    public void verify_upload_attach_close_btn(){
        help.move_and_click("//button[contains(text(),'Attach & Close')]");
    }

    public void verify_upload_file() throws InterruptedException {
        Thread.sleep(2000);
        driver.switchTo().activeElement();
        help.move_and_click("//div[contains(@class,'dropbox')]");
        Thread.sleep(1000);
        String filename = "src\\test\\resources\\SubscriptionVendorInvoiceList.xls";
        upload_file(filename);
        Assert.assertTrue(filename.contains(upload_file_name));
    }
    public void verify_upload_file_fields(){
        String[] fields = {"//label[contains(text(),'Attachment Name:')]","//label[contains(text(),'Attachment Type:')]", "//label[@class='custom-control-label'][contains(text(),'Internal')]"};
        String[] fieldsNames = {"Attachment Name:","Attachment Type:","Internal"};

        int count = 0;
        for (String s: fields){
            element =  get_element(s);
            Assert.assertEquals(fieldsNames[count],element.getText());
            count++;
        }
    }
    public void verify_upload_file_fields_editable(){
        String[] fields = {"//div[@class='modal-body']/.//input[@type='text']","//div[@class='modal-body']/.//input[@type='checkbox']","//div[@class='modal-body']/.//select"};
        int count = 1;
        for (String s : fields){
            //label[contains(text(),'Attachment Name:')]/../..//div[@class='row align-items-baseline']/div/input
            switch (count){
                case 1:
                    element = get_element(s);
                    upload_file_name=randomString();
                    element.sendKeys(upload_file_name);
                    count++;
                    break;
                case 2:
                    element = get_element(s);
                    move_and_click(s);
                    previousstate_boolean = element.isSelected();
                    count++;
                    break;
                case 3:
                    select_drop_down(s,"Credit Card Form");
                    upload_file_attachment_type="Credit Card Form";
                    count++;
                    break;
            }
        }
    }

    public void verify_upload_btn_title(){
        wait_element_tobe_clickable("//button[@class='btn btn-md btn-primary btn-sm']");
        Assert.assertTrue(get_element("//button[@class='btn btn-md btn-primary btn-sm']").isEnabled());
        help.move_and_click("//button[@class='btn btn-md btn-primary btn-sm']");
        Assert.assertEquals("Attachments",get_element_text("//h5[@class='modal-title']"));
    }

    public void verify_general_tab_sections() throws InterruptedException {
        String[] sections = {"Order Information","Vendor Information","General Information","Attachments"};
        int count =0;
        move_and_click(general_info_tab);
        Thread.sleep(5000);
        for (String s:general_info_tab_sections) {
            customerinvoicenotesprevioustext = get_element_text(s);
            Assert.assertTrue(customerinvoicenotesprevioustext.contains(sections[count]));
            count++;
        }
    }

    public void verify_order_info_fields_general_info_tab() throws InterruptedException {
        String[] fields = {"Original Sales Order #:","Customer PO #:","Order Type:","Contract Vehicle:","Sales Order Processing Notes:"};
        int count =0;
        for (String s:general_info_order_info_fields) {
            customerinvoicenotesprevioustext = get_element_text(s);
            Assert.assertEquals(fields[count],customerinvoicenotesprevioustext);
            count++;
        }
    }
    public void verify_vendor_info_fields_general_info_tab(){
        String[] fields = {"Vendor:","Purchase Order #:","Deal ID:","Vendor Success Manager:","Organization ID:"};
        int count =0;
        for (String s:general_info_vendor_info_fields) {
            customerinvoicenotesprevioustext = get_element_text(s);
            Assert.assertEquals(fields[count],customerinvoicenotesprevioustext);
            count++;
        }
    }
    public void verify_general_info_fields_general_info_tab(){
        String[] fields= {"Account Manager:","Inside Sales Rep:","Business Development Manager:","Presidio Success Manager:"};
        int count =0;
        for (String s:general_info_gen_info_fields) {
            customerinvoicenotesprevioustext = get_element_text(s);
            Assert.assertEquals(fields[count],customerinvoicenotesprevioustext);
            count++;
        }
    }

    public void verify_general_info_tab_editable_fields1_audit_reflection() throws InterruptedException {
        String[] fields ={"//div[@id='OrderInformation']//textarea","//div[@id='VendorInformationdiv']//div[4]//div[2]//input[1]","//div[contains(text(),'Organization ID:')]/..//input"};
        int count = 1;
        for(String s:fields){
            Thread.sleep(2000);
            element = get_element(s);
            element.sendKeys(Keys.CONTROL+"a");
            element.sendKeys(Keys.DELETE);
            customerinvoicenotesprevioustext = randomString();
            element.sendKeys(customerinvoicenotesprevioustext);
            help.move_and_click(save_btn_general_info_1);
            Thread.sleep(3000);
            help.move_and_click(history_tab_subs_page);
            Thread.sleep(3000);
           // wait_element_tobe_displayed(latest_audit_subs_page);
            switch (count){
                case 1: Thread.sleep(8000);Assert.assertTrue(get_element_text(latest_audit_subs_page).contains("Sales Order Processing Notes"));help.move_and_click(general_info_tab);break;
                case 2: Thread.sleep(8000);Assert.assertTrue(get_element_text(latest_audit_subs_page).contains("Vendor Customer Success Manager"));help.move_and_click(general_info_tab);break;
                case 3: Thread.sleep(8000);Assert.assertTrue(get_element_text(latest_audit_subs_page).contains("Organization ID"));help.move_and_click(general_info_tab);break;
            }count++;
        }
    }
    public void verify_general_info_tab_editable_fields2_audit_reflection() throws InterruptedException {
        String[] fields = {"//div[contains(text(),'Account Manager:')]/..//input","//div[contains(text(),'Inside Sales Rep:')]/..//input","//div[contains(text(),'Business Development Manager:')]/..//input","//div[contains(text(),'Presidio Success Manager:')]/..//input"};
        String[] field_names = {"Account Manager:","Inside Sales Rep:","Business Development Manager:","Presidio Success Manager:"};
        String[] names = {"Kat","Har","Gab","Ran","Mar","Tar","Jac","Fre"};
        int count =0,name_index=0;

        for(String field: fields){
            String value=help.get_element(field).getAttribute("value");
            for(String name:names){
                log.info("count: "+count);
                log.info("-------");
                if(value.startsWith(name)){
                    if(help.odd_or_even(count)){
                        element = help.get_element(field);
                        help.fluent_wait_sendkeys_not_interactable(element,Keys.CONTROL+"a");
                        help.fluent_wait_sendkeys_not_interactable(element,Keys.DELETE);
                        log.info(names[(count) +  1]);
                        help.fluent_wait_sendkeys_not_interactable(element,names[(count) +  1]);
                        Thread.sleep(5000);
                        help.wait_element_located_element_visibility("//li[contains(text(),'"+names[(count) +  1]+"')]");
                        List<WebElement> items=select_unordered_list("//div[contains(text(),'"+field_names[name_index]+"')]/..//ul","li");
                        help.fluent_wait_click_not_interactable(items.get(0));
                        help.move_and_click(save_btn_general_info_1);
                        Thread.sleep(5000);
                        help.move_and_click(history_tab_subs_page);
                        help.fluent_wait_no_such_element(latest_audit_subs_page);
//                        wait_element_tobe_displayed(latest_audit_subs_page);
                        if(get_element_text(latest_audit_subs_page).contains("Account Manager Name")){
                            log.info("history record found");
                            Assert.assertTrue(get_element_text(latest_audit_subs_page).contains("Account Manager Name"));
                        }
                        help.move_and_click(general_info_tab);
                        count=0;
                        break;

                    }else {
                        if(count>names.length){
                            break;
                        }
                        element = help.get_element(field);
                        help.fluent_wait_sendkeys_not_interactable(element,Keys.CONTROL+"a");
                        help.fluent_wait_sendkeys_not_interactable(element,Keys.DELETE);
                        log.info(names[(count) -  1]);
                        help.fluent_wait_sendkeys_not_interactable(element,names[(count) -  1]);
                        Thread.sleep(5000);
                        help.wait_element_located_element_visibility("//li[contains(text(),'"+names[(count) -  1]+"')]");
                        List<WebElement> items=select_unordered_list("//div[contains(text(),'"+field_names[name_index]+"')]/..//ul","li");
                        help.fluent_wait_click_not_interactable(items.get(0));
                        help.move_and_click(save_btn_general_info_1);
                        Thread.sleep(5000);
                        help.move_and_click(history_tab_subs_page);
                        help.fluent_wait_no_such_element(latest_audit_subs_page);
//                        wait_element_tobe_displayed(latest_audit_subs_page);
                        if(get_element_text(latest_audit_subs_page).contains("Account Manager Name")){
                            Assert.assertTrue(get_element_text(latest_audit_subs_page).contains("Account Manager Name"));
                        }
                        help.move_and_click(general_info_tab);
                        count=0;
                        break;

                    }
                }else{
                    count++;
                }
            }name_index++;
        }

//        for(String s : fields){
//            Thread.sleep(2000);
//            get_element(s).clear();
//            out:
//            switch (count){
//                case 0:
//                    for(int i=0;i<=1;i++){
//                        element = get_element(s);
//                        element.clear();
//                        element.sendKeys(names[i]);
//                        //Thread.sleep(5000);
//                        help.wait_element_located_element_visibility("//li[contains(text(),'"+names[i]+"')]");
//                        wait_element_tobe_clickable("//div[contains(text(),'Account Manager:')]/..//ul");
//                        List<WebElement> items=select_unordered_list("//div[contains(text(),'Account Manager:')]/..//ul","li");
//                        move_and_click(items.get(0));
//                        help.move_and_click(save_btn_general_info_1);
//                        Thread.sleep(5000);
//                        help.move_and_click(history_tab_subs_page);
//                        Thread.sleep(5000);
//                       // wait_element_tobe_displayed(latest_audit_subs_page);
//                        if(get_element_text(latest_audit_subs_page).contains("Account Manager Name")){
//                            Thread.sleep(8000);
//                            Assert.assertTrue(get_element_text(latest_audit_subs_page).contains("Account Manager Name"));
//                            help.move_and_click(general_info_tab);
//                            break out;
//                        }help.move_and_click(general_info_tab);
//                    }
//                case 1:
//                    for(int i=2;i<=3;i++){
//                        element = get_element(s);
//                        element.clear();
//                        element.sendKeys(names[i]);
//                        //Thread.sleep(5000);
//                        help.wait_element_located_element_visibility("//li[contains(text(),'"+names[i]+"')]");
//                        wait_element_tobe_clickable("//div[contains(text(),'Inside Sales Rep:')]/..//ul");
//                        List<WebElement> items=select_unordered_list("//div[contains(text(),'Inside Sales Rep:')]/..//ul","li");
//                        move_and_click(items.get(0));
//                        help.move_and_click(save_btn_general_info_1);
//                        Thread.sleep(5000);
//                        help.move_and_click(history_tab_subs_page);
//                        Thread.sleep(5000);
//                       // wait_element_tobe_displayed(latest_audit_subs_page);
//                        if(get_element_text(latest_audit_subs_page).contains("Inside Sales Rep Name")){
//                            Thread.sleep(8000);
//                            Assert.assertTrue(get_element_text(latest_audit_subs_page).contains("Inside Sales Rep Name"));
//                            help.move_and_click(general_info_tab);
//                            break out;
//                        }help.move_and_click(general_info_tab);
//                    }
//                case 2:
//                    for(int i=4;i<=5;i++){
//                        element = get_element(s);
//                        element.clear();
//                        element.sendKeys(names[i]);
//                        //Thread.sleep(5000);
//                        help.wait_element_located_element_visibility("//li[contains(text(),'"+names[i]+"')]");
//                        wait_element_tobe_clickable("//div[contains(text(),'Business Development Manager:')]/..//ul");
//                        List<WebElement> items=select_unordered_list("//div[contains(text(),'Business Development Manager:')]/..//ul","li");
//                        move_and_click(items.get(0));
//                        help.move_and_click(save_btn_general_info_1);
//                        Thread.sleep(5000);
//                        help.move_and_click(history_tab_subs_page);
//                        Thread.sleep(5000);
//                        //wait_element_tobe_displayed(latest_audit_subs_page);
//                        if(get_element_text(latest_audit_subs_page).contains("Business Development Manager Name")){
//                            Thread.sleep(8000);
//                            Assert.assertTrue(get_element_text(latest_audit_subs_page).contains("Business Development Manager Name"));
//                            help.move_and_click(general_info_tab);
//                            break out;
//                        }help.move_and_click(general_info_tab);
//                    }
//                case 3:
//                    for(int i=6;i<=7;i++){
//                        element = get_element(s);
//                        element.clear();
//                        element.sendKeys(names[i]);
//                        //Thread.sleep(2000);
//                        help.wait_element_located_element_visibility("//li[contains(text(),'"+names[i]+"')]");
//                        wait_element_tobe_clickable("//div[contains(text(),'Presidio Success Manager:')]/..//ul");
//                        List<WebElement> items=select_unordered_list("//div[contains(text(),'Presidio Success Manager:')]/..//ul","li");
//                        move_and_click(items.get(0));
//                        help.move_and_click(save_btn_general_info_1);
//                        Thread.sleep(5000);
//                        help.move_and_click(history_tab_subs_page);
//                        Thread.sleep(5000);
//                       // wait_element_tobe_displayed(latest_audit_subs_page);
//                        if(get_element_text(latest_audit_subs_page).contains("Presidio Customer Success Manager Name")){
//                            Thread.sleep(8000);
//                            Assert.assertTrue(get_element_text(latest_audit_subs_page).contains("Presidio Customer Success Manager Name"));
//                            help.move_and_click(general_info_tab);
//                            break out;
//                        }help.move_and_click(general_info_tab);
//                    }
//            }count++;
//        }
    }

    public void verify_line_items_expand_collapse_ion() throws InterruptedException {
        element = get_element("//div[@id='Active']//div//div//div[@id='table-vertical-scroll']//div//div//table//thead//tr//th//div//i");
        String title = element.getAttribute("title");
        Assert.assertEquals("Expand All Icons",title);
        js_click(element);
        Thread.sleep(1000);
        title = element.getAttribute("title");
        Assert.assertEquals("Collapse all line items",title);
        Thread.sleep(1000);
        js_click(element);
//        List<WebElement> items= select_unordered_list("//div[@id='Active']//div//div//div[@id='table-vertical-scroll']//div//div//tbody","tr");
//        boolean flag = Boolean.TRUE;
//        int count = 1;
//        for (WebElement ele: items
//             ) {
//            if(count%2 == 0){
//                List<WebElement> info = ele.findElements(By.tagName("label"));
//                for (WebElement i:info
//                     ) {
//                    log.info("label: "+i.getText());
//                    Assert.assertTrue(i.isDisplayed());
//                }
//            }
//            count++;
//        }
        move_and_click(line_items_history_tab);
        Thread.sleep(2000);
        element = get_element("//div[@id='History']//div//div//div[@id='table-vertical-scroll']//div//div//table//thead//tr//th//div//i");
        title = element.getAttribute("title");
        Assert.assertEquals("Expand All Icons",title);
        js_click(element);
        Thread.sleep(1000);
        title = element.getAttribute("title");
        Assert.assertEquals("Collapse all line items",title);
        Thread.sleep(1000);
        js_click(element);
//        items = select_unordered_list("//div[@id='History']//div[@class='tab-content-body']//div//div[@id='table-vertical-scroll']//div[@class='clearfix']//tbody","tr");
//        count = 1;
//        for (WebElement ele: items
//        ) {
//            if(count%2 == 0){
//                List<WebElement> info = ele.findElements(By.tagName("label"));
//                for (WebElement i:info
//                ) {
//                    log.info("label: "+i.getText());
//                    Assert.assertTrue(i.isDisplayed());
//                }
//            }
//            count++;
//        }
    }

    public void verify_line_items_pluse_icon() throws InterruptedException {
        wait_element_tobe_clickable(line_items_active_tab);
        move_and_click(line_items_active_tab);
        Thread.sleep(2000);
        List<WebElement> items = select_unordered_list("//div[@id='Active']//div//div//div[@id='table-vertical-scroll']//div//div//tbody","i");
        for (WebElement ele: items
             ) {
            if(ele.getAttribute("id").contains("PlusIcon")){
                String title = ele.getAttribute("title");
                Assert.assertEquals("Expand",title);
                js_click(ele);
                Thread.sleep(500);
                title = ele.getAttribute("title");
                Assert.assertEquals("Collapse",title);
            }
        }
    }

    public void verify_line_items_history_tab_columns() throws InterruptedException {
        String[] table_column_names = {"Expand All Icons","#","Manufacturer Part #","Description","Qty","Subscription\n" +
                "Credit (Revenue)","Subscription\n" + "Credit (Cost)","Unit\n" + "Price","Unit\n" + "Cost","Recurring\n" + "Price","Recurring\n" + "Cost","Extended\n" +
                "Price","Extended\n" + "Cost","Customer\n" + "PO #","Change Order #"};
        int count = 0;

        move_and_click(line_items_history_tab);
        Thread.sleep(2000);
        List<WebElement> items= select_unordered_list("//div[@id='Subscription']//div//div//div//div[@id='History']//div//div//div[@id='table-vertical-scroll']//div//div//thead//tr","th");
        for (WebElement ele: items
             ) {
            if(count == 0){
                element = ele.findElement(By.tagName("i"));
                Assert.assertTrue(element.getAttribute("title").equalsIgnoreCase(table_column_names[count]));
                count++;
            }
//            else{
//                int node = count+1;
//                List<WebElement> temp = driver.findElements(By.xpath("//div[@id='Subscription']//div[@id='History']//th//div[1]"));
//
//                for (WebElement t:temp) {
//                    log.info("count: "+count+" index: "+t.getText());
//                }
//                Assert.assertEquals(table_column_names[count],element.getText());
//                count++;
//            }
        }
    }

    public void verify_line_items_active_tab_columns(){
        String[] table_column_names = {"Expand All Icons","#","Manufacturer Part #","Description","Qty","Subscription\n" +
                "Credit (Revenue)","Subscription\n" +
                "Credit (Cost)","Unit\n" + "Price","Unit\n" + "Cost","Recurring\n" + "Price","Recurring\n" + "Cost","Extended\n" + "Price","Extended\n" + "Cost","Customer\n" + "PO #"};
        int count = 0;
        List<WebElement> items = select_unordered_list("//div[@id='Active']//div[@class='tab-content-body']//div//thead[@class='thead-light']//tr","th");
        for (WebElement ele:items
             ) {
            if(count == 0){
                element = ele.findElement(By.tagName("i"));
                Assert.assertTrue(element.getAttribute("title").equalsIgnoreCase(table_column_names[count]));
                count++;
            }else{

                Assert.assertEquals(table_column_names[count],ele.getText());
                count++;
            }
        }
    }

    public void verify_subscription_model_title() throws InterruptedException {
        Thread.sleep(2000);
        element= get_element("//div[@id='Active']//tr[1]//td[6]//div[1]//a[1]");
        js_click(element);
        element=get_element(sub_credit_model_title);
        Assert.assertEquals("Subscription Credit For Line # 1",element.getText());
        help.move_and_click(sub_credit_model_title_close);
    }
    public void verify_line_items_tabs() throws InterruptedException {
        scrollintoview("//div[@id='Active']//div//div//div[@id='table-vertical-scroll']//div//div//th//div[contains(text(),'Description')]");
        Assert.assertTrue(get_element(line_items_active_tab).isDisplayed());
        Assert.assertTrue(get_element(line_items_history_tab).isDisplayed());
    }

    public void verify_active_tab_no_editable_fields() throws InterruptedException {
        Thread.sleep(5000);
        int odd =1;
        List<WebElement> rows = select_unordered_list(line_items_table_rows,"tr");
        for (WebElement ele:rows
             ) {
            if (!(odd%2 == 0)) {
                List<WebElement> cells = ele.findElements(By.tagName("td"));
                for (WebElement cell:cells
                     ) {
                    Assert.assertFalse(is_editable(cell));
                }
            }
            odd++;
        }
    }

    public void verify_subscription_credit_is_hyperlink() throws InterruptedException {
        int count,odd=1;
        List<WebElement> rows = select_unordered_list(line_items_table_rows,"tr");
        out:
        for (WebElement ele:rows
        ) {
            count = 1;
            if (!(odd%2 == 0)) {
                List<WebElement> cells = ele.findElements(By.tagName("td"));
                for (WebElement cell:cells
                ) {
                    if (count == 6 || count == 7) {
                        scrollintoview(cell);
                        element = driver.findElement(By.xpath("//div[@id='Active']//tr["+odd+"]//td["+count+"]//div[1]//a[1]"));
                        js_click(element);
//                        Thread.sleep(3000);
                        //driver.switchTo().activeElement();
                        try {
                            element = get_element(subcription_credit_model_mask);
                            Assert.assertEquals("modal-mask", element.getAttribute("class"));
                            move_and_click(sub_credit_model_title_close);
                            break out;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        Thread.sleep(1000);
                    }
                    count++;
                }
            }
            odd++;
        }

    }

    public void verify_profit_info_fields() throws InterruptedException {
        //help.move_and_click(subscription_details_tab_subs_page);
        Thread.sleep(2000);
        try {
            Assert.assertTrue(get_element(Total_amount).isDisplayed());
            Assert.assertTrue(get_element(Total_cost).isDisplayed());
            Assert.assertTrue(get_element(Margin).isDisplayed());
            Assert.assertTrue(get_element(Margin_percent).isDisplayed());
            Assert.assertTrue(get_element(Recurring_amount).isDisplayed());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void verify_customer_options_fields() throws InterruptedException {
        //help.move_and_click(subscription_details_tab_subs_page);
        //Thread.sleep(2000);
        Assert.assertTrue(get_element(Invoice_by).isDisplayed());
        Assert.assertTrue(get_element(Renewal_notification).isDisplayed());
        Assert.assertTrue(get_element(Show_on_portal).isDisplayed());
    }

    public void verify_billing_info_fields() throws InterruptedException {
        //help.move_and_click(subscription_details_tab_subs_page);
        //Thread.sleep(4000);
        Assert.assertTrue(get_element(Billing_Frequency_Vendor).isDisplayed());
        Assert.assertTrue(get_element(Billing_Frequency_Customer).isDisplayed());
        Assert.assertTrue(get_element(Hold_Invoice_Processing).isDisplayed());
        Assert.assertTrue(get_element(Party_Biller).isDisplayed());
        Assert.assertTrue(get_element(Customer_Invoice_Notes).isDisplayed());
    }

    public void verify_cust_name_hyperlink() throws InterruptedException {
        help.move_and_click(subscription_details_tab_subs_page);
        Thread.sleep(4000);
        wait_element_tobe_clickable(cust_name_hyperlink);
        help.move_and_click(cust_name_hyperlink);
        switch_to_child_window();

    }

    public void verify_subscription_details_header() throws InterruptedException {
        help.move_and_click(subscription_details_tab_subs_page);
        Thread.sleep(4000);
        //scrollintoview(subscription_detail_header);
        Assert.assertEquals(get_element_text(subscription_detail_header),"Subscription Details");
    }

    public void verify_subscription_details_header_fields() throws InterruptedException {
        //help.move_and_click(subscription_details_tab_subs_page);
        //Thread.sleep(4000);
        Assert.assertTrue(get_element(cust_name_subs_page).isDisplayed());
        Assert.assertTrue(get_element(manufacturer_subs_page).isDisplayed());
        Assert.assertTrue(get_element(vendor_subscription).isDisplayed());
        Assert.assertTrue(get_element(Customer_Site_Admin).isDisplayed());
        Assert.assertTrue(get_element(Start_date).isDisplayed());
        Assert.assertTrue(get_element(End_date).isDisplayed());
        Assert.assertTrue(get_element(Anniversary_Date).isDisplayed());
        Assert.assertTrue(get_element(Auto_renewal).isDisplayed());
        Assert.assertTrue(get_element(Initial_Term).isDisplayed());
        Assert.assertTrue(get_element(True_forward).isDisplayed());
    }
    public String hold_description="",renewal_description="",portal_description="";
    public void verify_hold_process_renewal_showonportal_btn() throws InterruptedException {
        help.move_and_click(subscription_details_tab_subs_page);
        Thread.sleep(4000);
        element = get_element(hold_invoice_processing_btn);
        boolean flag = element.isSelected();
        Thread.sleep(1000);
        click_toggle_btn(hold_invoice_processing_btn);
        Thread.sleep(1000);
        help.move_and_click(save_btn_1);
        Thread.sleep(5000);
        //Assert.assertNotEquals(element.isSelected(),flag);
        help.move_and_click(history_tab_subs_page);
        Thread.sleep(4000);
        if (flag == Boolean.TRUE) {
            Thread.sleep(8000);
            //help.wait_text_to_be_present_in_element(latest_audit_subs_page,"Hold Invoice Processing updated (from 'Yes' to 'No')");
            hold_description = get_element_text(latest_audit_subs_page);
            Assert.assertEquals(hold_description,"Hold Invoice Processing updated (from 'Yes' to 'No')");
        } else {
            Thread.sleep(8000);
            //help.wait_text_to_be_present_in_element(latest_audit_subs_page,"Hold Invoice Processing updated (from 'No' to 'Yes')");
            hold_description = get_element_text(latest_audit_subs_page);
            Assert.assertEquals(hold_description,"Hold Invoice Processing updated (from 'No' to 'Yes')");
        }        

        help.move_and_click(subscription_details_tab_subs_page);
        Thread.sleep(4000);
        element =get_element(renewal_notification_btn);
        flag = element.isSelected();
        click_toggle_btn(renewal_notification_btn);
        help.move_and_click(save_btn_1);
        Thread.sleep(3000);
        //Assert.assertNotEquals(element.isSelected(),flag);
        help.move_and_click(history_tab_subs_page);
        Thread.sleep(4000);

        if (flag == Boolean.TRUE) {
            Thread.sleep(8000);
            //help.wait_text_to_be_present_in_element(latest_audit_subs_page,"Enable Renewal Notifications (from 'Yes' to 'No')");
            renewal_description = get_element_text(latest_audit_subs_page);
            Assert.assertEquals("Enable Renewal Notifications (from 'Yes' to 'No')",renewal_description);
        } else {
            Thread.sleep(8000);
            //help.wait_text_to_be_present_in_element(latest_audit_subs_page,"Enable Renewal Notifications (from 'No' to 'Yes')");
            renewal_description = get_element_text(latest_audit_subs_page);
            Assert.assertEquals("Enable Renewal Notifications (from 'No' to 'Yes')",renewal_description);
        }

        help.move_and_click(subscription_details_tab_subs_page);
        Thread.sleep(4000);
        element =get_element(show_on_portal_btn);
        flag = element.isSelected();
        click_toggle_btn(show_on_portal_btn);
        help.move_and_click(save_btn_1);
        Thread.sleep(3000);
       // Assert.assertNotEquals(element.isSelected(),flag);
        help.move_and_click(history_tab_subs_page);
        Thread.sleep(4000);

        if (flag == Boolean.TRUE) {
            Thread.sleep(8000);
            //help.wait_text_to_be_present_in_element(latest_audit_subs_page,"Show on Portal updated (from 'Yes' to 'No')");
            portal_description = get_element_text(latest_audit_subs_page);
            Assert.assertEquals("Show on Portal updated (from 'Yes' to 'No')",portal_description);
        } else {
            Thread.sleep(8000);
            //help.wait_text_to_be_present_in_element(latest_audit_subs_page,"Show on Portal updated (from 'No' to 'Yes')");
            portal_description = get_element_text(latest_audit_subs_page);
            Assert.assertEquals("Show on Portal updated (from 'No' to 'Yes')",portal_description);
        }
    }

    public void verify_customer_invoices_notes_editable_audit_reflection() throws InterruptedException {
        wait_element_tobe_clickable(history_tab_subs_page);
        Thread.sleep(4000);
        help.move_and_click(history_tab_subs_page);
        Thread.sleep(4000);
        Thread.sleep(8000);
        //help.wait_text_to_be_present_in_element(latest_audit_subs_page,customerinvoicenotesprevioustext);
        String auditdescription = get_element_text(latest_audit_subs_page);

        Assert.assertTrue(auditdescription.contains(customerinvoicenotesprevioustext));

    }

    public void verify_customer_invoices_notes_editable() throws InterruptedException {
        //help.move_and_click(subscription_details_tab_subs_page);
        //wait_element_tobe_present(customer_invoice_notes_subs_page);
        help.move_and_click(subscription_details_tab_subs_page);
        element = get_element((customer_invoice_notes_subs_page));
        //customerinvoicenotesprevioustext = element.getText();
        boolean enabled = element.isEnabled();
        Assert.assertEquals(enabled,Boolean.TRUE);
        if (enabled == Boolean.TRUE) {
            element.clear();
            customerinvoicenotesprevioustext = randomString();
            element.sendKeys(customerinvoicenotesprevioustext);
            Thread.sleep(2000);
            help.move_and_click(save_btn_1);
        }
    }

    public void verify_true_forward_toggle_btn() throws InterruptedException {
        help.move_and_click(subscription_details_tab_subs_page);
        Thread.sleep(3000);
        //help.wait_element_located_element_visibility(true_forward_toggle_btn_subs_page);
        element = get_element((true_forward_toggle_btn_subs_page));
        previousstate_boolean = element.isSelected();
        help.js_click(element);
        //element.click();
        Thread.sleep(2000);
        help.move_and_click(save_btn_1);
        Thread.sleep(6000);
       // Assert.assertNotEquals(element.isSelected(),state);
    }

    public void verify_true_forward_toggle_btn_audit_reflection() throws InterruptedException {
        help.move_and_click(history_tab_subs_page);
        Thread.sleep(4000);
        log.info("previousstate_boolean: "+previousstate_boolean);
        if (previousstate_boolean == Boolean.TRUE) {
            Thread.sleep(12000);
            //help.wait_text_to_be_present_in_element(latest_audit_subs_page, "True Forward (from 'Yes' to 'No')");
            String auditdescription = get_element_text(latest_audit_subs_page);
            Assert.assertEquals("True Forward (from 'Yes' to 'No')",auditdescription);

        } else {
            Thread.sleep(12000);
            //help.wait_text_to_be_present_in_element(latest_audit_subs_page,"True Forward (from 'No' to 'Yes')");
            String auditdescription = get_element_text(latest_audit_subs_page);
            Assert.assertEquals("True Forward (from 'No' to 'Yes')",auditdescription);
        }
    }

    public void verify_audit_history_tab_invoice_by_to_customerpo() throws InterruptedException {
        if (invoice_check) {
            wait_element_tobe_clickable(history_tab_subs_page);
            Thread.sleep(3000);
            help.move_and_click(history_tab_subs_page);
//        Thread.sleep(12000);
            //wait_element_tobe_displayed(latest_audit_subs_page);
            //help.wait_text_to_be_present_in_element(latest_audit_subs_page,"Invoice By (from 'Subscription' to 'CustomerPO')");
            help.fluent_wait_no_such_element(latest_audit_subs_page);
            String invbydescription =get_element_text(latest_audit_subs_page);
            Assert.assertEquals("Invoice By (from 'Subscription' to 'CustomerPO')",invbydescription);
        }
    }

    public void verify_audit_history_tab_invoice_by_to_subscription() throws InterruptedException {
        if (invoice_check) {
            wait_element_tobe_clickable(history_tab_subs_page);
            help.move_and_click(history_tab_subs_page);
            Thread.sleep(12000);
            // wait_element_tobe_displayed(latest_audit_subs_page);
            //help.wait_text_to_be_present_in_element(latest_audit_subs_page,"Invoice By (from 'CustomerPO' to 'Subscription')");
            String invbydescription =get_element_text(latest_audit_subs_page);
            Assert.assertEquals("Invoice By (from 'CustomerPO' to 'Subscription')",invbydescription);
        }
    }

    public void verify_invoice_by_updating_to_customerPO() throws InterruptedException {
        if (invoice_check) {
            Thread.sleep(6000);
            try {
                Select se = new Select(get_element((invoice_by_dropdown)));
                if(se.getFirstSelectedOption().getText().equalsIgnoreCase("Customer PO")){
                    select_drop_down(invoice_by_dropdown,"Subscription");
                    Thread.sleep(2000);
                    help.move_and_click(save_btn_1);
                    Thread.sleep(4000);
                }
                select_drop_down(invoice_by_dropdown,"Customer PO");
                Thread.sleep(2000);
                help.move_and_click(save_btn_1);
                Thread.sleep(4000);
                Assert.assertEquals(se.getFirstSelectedOption().getText(),"Customer PO");
            } catch (Exception e) {
                log.info("This subscription is already merged with CR having fixed invoice by field");
            }
        }
    }

    public void verify_invoice_by_updating_to_subscription() throws InterruptedException {
        if (invoice_check) {
            help.move_and_click(subscription_details_tab_subs_page);
            Thread.sleep(6000);
            try {
                select_drop_down(invoice_by_dropdown,"Subscription");
                Thread.sleep(2000);
                help.move_and_click(save_btn_1);
                Thread.sleep(4000);
                Select se = new Select(get_element((invoice_by_dropdown)));
                Assert.assertEquals(se.getFirstSelectedOption().getText(),"Subscription");
            } catch (Exception e) {
                log.info("This subscription is already merged with CR having fixed invoice by field");
            }
        }
    }

    public void verify_invoice_by() throws InterruptedException {
        Thread.sleep(6000);
        String[] invoicebyfields = {"Subscription","Customer PO"};
        try {
            element = get_element((invoice_by_dropdown));
        Assert.assertEquals(element.isEnabled(),Boolean.TRUE);
        Thread.sleep(5000);
        List<WebElement> items = select_drop_down_list(invoice_by_dropdown);
        int count = 0;
        for (WebElement i:items
             ) {
            Assert.assertEquals(i.getText(),invoicebyfields[count]);
            count += 1;
        }
        } catch (Exception e) {
            invoice_check = Boolean.FALSE;
            log.info("This subscription is already merged with CR having fixed invoice by field");
        }
    }

    public void verify_days_left_based_on_status(){
        wait_element_tobe_displayed(status);
        if(get_element_text(status).equalsIgnoreCase("Active")){
            Assert.assertNotEquals(get_element_text(days_left),"--");
        }
    }

    public void verify_anniversary_date_with_starting_starting_date() throws ParseException, InterruptedException {
        wait_element_tobe_displayed(start_date);
        wait_element_tobe_displayed(anniversary_date);
        Thread.sleep(5000);
        Calendar cal = Calendar.getInstance();
        String startdate = get_element_text(start_date);
        log.info("start date before: "+startdate);
        String anniversarydate= get_element_text(anniversary_date);
        log.info("anniversy date: "+anniversarydate);
        cal.setTime(simdate.parse(startdate));
        cal.add(Calendar.YEAR,1);

        startdate =simdate.format(cal.getTime());
        log.info("start date before: "+startdate);
        Assert.assertEquals(startdate,anniversarydate);
    }

    public void verify_requested_start_date_based_on_status() throws InterruptedException {
        wait_element_tobe_displayed(status);
        element = get_element((status));
        Thread.sleep(2000);
        if(element.getText().equalsIgnoreCase("Active")){
            try {
                Assert.assertEquals(get_element((requested_start_date)).isDisplayed(),Boolean.FALSE);
            } catch (NoSuchElementException e) {
                Assert.assertTrue(Boolean.TRUE);
            }
        }
    }

    public void verify_auto_renewal_term() throws InterruptedException {
        wait_element_tobe_present(auto_renewal);
        element = get_element((auto_renewal));
        log.info("auto_renewal: "+element.getText());
        Thread.sleep(2000);
        String autorenewalterm="";
        if(element.getText().equalsIgnoreCase("No")){
            autorenewalterm  = driver.findElement(By
                    .xpath(auto_renewal_term)).getText();
            Assert.assertEquals("Do Not Renew",autorenewalterm);
        } else if (element.getText().equalsIgnoreCase("Yes")) {
            autorenewalterm = driver.findElement(By
                    .xpath(auto_renewal_term)).getText();
            Assert.assertNotEquals("Do Not Renew",autorenewalterm);
        }
    }

    // Handling select interface dropdown
    public void select_drop_down(String xpath, int index){
        Select select=new Select(get_element((xpath)));
        select.selectByIndex(index);
    }

    public void select_drop_down(String xpath, String value){
        Select select=new Select(get_element((xpath)));
        List<WebElement> items = select.getOptions();
        for (WebElement ele: items
             ) {
            if(ele.getText().equalsIgnoreCase(value)){
                ele.click();
            }
        }
    }

    public List<WebElement> select_drop_down_list(String xpath){
        Select select=new Select(get_element((xpath)));
        return select.getOptions();
    }

    // Handling Unordered List [<ul>] web element
    public static List<WebElement> select_unordered_list(WebElement ele){
        return ele.findElements(By.tagName("li"));
    }

    // enter subscription number
    public void enter_subscription_num(String subnum) throws InterruptedException {
        driver.switchTo().window(parentwindow);
        String subscriptions_sidemenu = "//li[@class='mm-active']//li[1]/a";
        wait_element_tobe_clickable(subscriptions_sidemenu);
        help.move_and_click(subscriptions_sidemenu);
        Thread.sleep(5000);
        wait_element_tobe_clickable(subscriptions_dropdown_filter_1);
        select_drop_down(subscriptions_dropdown_filter_1,"Subs #");
        enterTextBox("Enter Subscription",subnum);
        Thread.sleep(2000);
        help.move_and_click(subscriptions_search_btn);
        Thread.sleep(2000);
        wait_element_tobe_displayed("//a[contains(text(),'"+subnum+"')]");
        help.move_and_click("//a[contains(text(),'"+subnum+"')]");
        switch_to_child_window();
    }

    public void switch_to_child_window(){
        allwindows =driver.getWindowHandles();
        for (String childwindow: allwindows
             ) {
            driver.switchTo().window(childwindow);
        }
    }

    public void close_child_windows(){
        allwindows=driver.getWindowHandles();
        for (String win:allwindows
             ) {
            if(!(win.equalsIgnoreCase(parentwindow))){
                driver.close();
            }
        }
    }

    public void wait_element_tobe_displayed(String xpath){
        wait.until(ExpectedConditions.visibilityOf(get_element((xpath))));
    }

    public void wait_element_tobe_displayed(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void wait_element_tobe_present(String xpath){
        wait.until(ExpectedConditions.visibilityOf(get_element((xpath))));
    }
    public void wait_element_tobe_present(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void wait_element_tobe_clickable(String xpath){
        wait.until(ExpectedConditions.elementToBeClickable(get_element((xpath))));
    }

    public void wait_element_tobe_clickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void click_element(String xpath){
        get_element((xpath)).click();
    }

    public void click_element(WebElement element){
        element.click();
    }

    public String get_element_text(String xpath){
       return get_element((xpath)).getText();
    }

    public WebElement get_element(String xpath){
        return driver.findElement(By.xpath(xpath));
    }
    public Boolean is_editable_by_attribute(WebElement ele){
        String flag= ele.getAttribute("readonly");
        if(flag.equalsIgnoreCase("true"))
            return Boolean.TRUE;
        return Boolean.FALSE;
    }
    public Boolean is_editable(String xpath){
        element = get_element(xpath);
        customerinvoicenotesprevioustext = element.getText();
        try{
            element.sendKeys(randomString());
            if(customerinvoicenotesprevioustext.equalsIgnoreCase(element.getText())){
                return Boolean.FALSE;
            }else { return Boolean.TRUE; }
        }catch (Exception e){
            return Boolean.FALSE;
        }
    }
    public Boolean is_editable(WebElement ele){
        try{
            ele.clear();
            customerinvoicenotesprevioustext = randomString();
            ele.sendKeys(customerinvoicenotesprevioustext);
            help.move_and_click(save_btn_1);
            Thread.sleep(3000);
            if(customerinvoicenotesprevioustext.equalsIgnoreCase(ele.getText())){
                return Boolean.TRUE;
            }else { return Boolean.FALSE; }
        }catch (Exception e){
            return Boolean.FALSE;
        }
    }
    public void js_click(WebElement ele){
        js.executeScript("arguments[0].click();",ele);
    }
    public String randomString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

}
