package com.sprint.qa.helper;

import com.sprint.qa.Pages.SubscriptionDetailsPage;
import com.sprint.qa.base.TestBase;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.*;
import java.util.function.Function;

public class Helper extends TestBase{
    Logger log = LoggerHelper.getLogger(LoggerHelper.class);

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

    public static List<WebElement> select_unordered_list(WebElement ele,String tag){
        return ele.findElements(By.tagName(tag));
    }

    public static List<WebElement> select_unordered_list(String xpath,String tag){
        return driver.findElement(By.xpath(xpath)).findElements(By.tagName(tag));
    }

    public void select_unordered_list(String xpath,String tag,String value){
        options_list = select_unordered_list(xpath,tag);
        for (WebElement ele:options_list) {
            if (ele.getText().equalsIgnoreCase(value))
                move_and_click(ele);
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
//    public void enter_subscription_num(String subnum) throws InterruptedException {
//        driver.switchTo().window(parentwindow);
//        String subscriptions_sidemenu = "//ul[@id='side-menu']/li[3]/ul/li[1]/a";
//        wait_element_tobe_clickable(subscriptions_sidemenu);
//        move_and_click(subscriptions_sidemenu);
//        Thread.sleep(5000);
//        wait_element_tobe_clickable(subscriptions_dropdown_filter_1);
//        select_drop_down(subscriptions_dropdown_filter_1,"Subs #");
//        enterTextBox("Enter Subscription",subnum);
//        Thread.sleep(2000);
//        move_and_click(subscriptions_search_btn);
//        Thread.sleep(2000);
//        wait_element_tobe_displayed("//a[contains(text(),'"+subnum+"')]");
//        click_element("//a[contains(text(),'"+subnum+"')]");
//        switch_to_child_window();
//    }

    public void switch_to_child_window(){
        allwindows =driver.getWindowHandles();
        for (String childwindow: allwindows
        ) {
            driver.switchTo().window(childwindow);
        }
    }

//    public void open_subscription(String sub_num) throws InterruptedException {
//        pm.click_subscriptions();
//        Thread.sleep(6000);
//        select_single_filter("Subs #", sub_num);
//        move_and_click("//div/button[contains(text(),'Search')]");
//        Thread.sleep(4000);
//        try {
//            move_and_click("//tbody/tr[1]/td[2]/a");
//        }catch (NoSuchElementException e){
//            e.printStackTrace();
//        }
//        switch_to_child_window();
//    }

    public void send_text_element(String xpath,String text){
        element = get_element(xpath);
        element.clear();
        element.sendKeys(text);
    }
    public void send_text_element(WebElement element,String text){
        element.clear();
        element.sendKeys(text);
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

    public void wait_text_to_be_present_in_element(String xpath, String text){
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(xpath), text));
    }

    public void wait_element_located_element_visibility(String xpath){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public void fluent_wait_for_element(String xpath){
        flu_wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                element = driver.findElement(By.xpath(xpath));
                return element;
            }
        });
    }

    public void fluent_wait_for_received(String xpath){
        flu_wait.until(new Function<WebDriver, Object>() {
            @Override
            public Object apply(WebDriver webDriver) {
                int i =1;
                while(true){
                    if(i>15){
                        break;
                    }
                    try {
                        Thread.sleep(3000);
                        if(get_element_text(xpath).equalsIgnoreCase("Received")){break;}
                        log.info("checking refresh");
                        driver.navigate().refresh();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }i++;
                }return get_element(xpath);
            }
        });
    }

    public void fluent_wait_click_not_interactable(String xpath){
        flu_wait.until(new Function<WebDriver, WebElement>() {
                @Override
                public WebElement apply(WebDriver driver) {
                    element = driver.findElement(By.xpath(xpath));
                    return element;
                }
            });move_and_click(element);
        }

    public void fluent_wait_click_not_interactable_js_click(String xpath){
        flu_wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                element = driver.findElement(By.xpath(xpath));
                js_click(element);
                return element;
            }
        });
    }
    public void fluent_wait_click_not_interactable(WebElement ele){
        flu_wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                move_and_click(ele);
                return ele;
            }
        });
    }

    public void fluent_wait_sendkeys_not_interactable(String xpath,String text){
        flu_wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                element = driver.findElement(By.xpath(xpath));
                element.sendKeys(Keys.CONTROL+"a");
                element.sendKeys(Keys.DELETE);
                element.sendKeys(text);
                return element;
            }
        });
    }
    public void fluent_wait_sendkeys_not_interactable(WebElement ele,String text){
        flu_wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                ele.sendKeys(Keys.CONTROL+"a");
                ele.sendKeys(Keys.DELETE);
                ele.sendKeys(text);
                return ele;
            }
        });
    }

    public String fluent_wait_get_text(String xpath){
        flu_wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                element = driver.findElement(By.xpath(xpath));
                return element;
            }
        });
        return get_element_text(xpath);
    }

    public void fluent_wait_sendkeys_not_interactable(WebElement ele,Keys keys){
        flu_wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                ele.sendKeys(keys);
                return ele;
            }
        });
    }

    public void fluent_wait_no_such_element(String xpath){
        flu_wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                element = driver.findElement(By.xpath(xpath));
                return element;
            }
        });
    }

    public void wait_for_received_status(String xpath){
        Wait<WebDriver> wait1 = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(180))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        wait1.until(new Function<WebDriver, Object>() {
            @Override
            public Object apply(WebDriver driver) {
                wait_text_to_be_present_in_element(xpath,"Received");
                return get_element(xpath);
            }
        });
    }
    
    public void move_and_click(String xpath) {
        element = driver.findElement(By.xpath(xpath));
        action.moveToElement(element).click().build().perform();
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
    public String get_element_text(WebElement element1){
        return element1.getText();
    }

    public void set_date_days(String xpath,int days,String plus_minus){
        element = get_element(xpath);
        Calendar cal = Calendar.getInstance();
        switch (plus_minus){
            case "plus":
                cal.add(Calendar.DATE,days);
                fluent_wait_sendkeys_not_interactable(element, simdate.format(cal.getTime()));
                //element.sendKeys(simdate.format(cal.getTime()));
                break;
            case "minus":
                cal.add(Calendar.DATE,-days);
                fluent_wait_sendkeys_not_interactable(element, simdate.format(cal.getTime()));
                //element.sendKeys(simdate.format(cal.getTime()));
                break;
            default:
                fluent_wait_sendkeys_not_interactable(element, simdate.format(cal.getTime()));
                //element.sendKeys(simdate.format(cal.getTime()));
                break;
        }
    }

    public void set_date_days(WebElement ele,int days,String plus_minus){
        element = ele;
        Calendar cal = Calendar.getInstance();
        switch (plus_minus){
            case "plus":
                cal.add(Calendar.DATE,days);
                fluent_wait_sendkeys_not_interactable(element, simdate.format(cal.getTime()));
                //element.sendKeys(simdate.format(cal.getTime()));
                break;
            case "minus":
                cal.add(Calendar.DATE,-days);
                fluent_wait_sendkeys_not_interactable(element, simdate.format(cal.getTime()));
                //element.sendKeys(simdate.format(cal.getTime()));
                break;
            default:
                fluent_wait_sendkeys_not_interactable(element, simdate.format(cal.getTime()));
                //element.sendKeys(simdate.format(cal.getTime()));
                break;
        }
    }

    public void set_date_years(String xpath,int years,String plus_minus){
        element = get_element(xpath);
        Calendar cal = Calendar.getInstance();
        switch (plus_minus){
            case "plus":
                cal.add(Calendar.YEAR,years);
                element.sendKeys(simdate.format(cal.getTime()));
                break;
            case "minus":
                cal.add(Calendar.YEAR,-years);
                element.sendKeys(simdate.format(cal.getTime()));
                break;
            default:
                element.sendKeys(simdate.format(cal.getTime()));
                break;
        }
    }
    public void set_date_mnts(String xpath,int mnts,String plus_minus){
        element = get_element(xpath);
        Calendar cal = Calendar.getInstance();
        switch (plus_minus){
            case "plus":
                cal.add(Calendar.YEAR,mnts);
                element.sendKeys(simdate.format(cal.getTime()));
                break;
            case "minus":
                cal.add(Calendar.YEAR,-mnts);
                element.sendKeys(simdate.format(cal.getTime()));
                break;
            default:
                element.sendKeys(simdate.format(cal.getTime()));
                break;
        }
    }
    public void set_date_mnts(WebElement ele,int mnts,String plus_minus){
        element = ele;
        Calendar cal = Calendar.getInstance();
        switch (plus_minus){
            case "plus":
                cal.add(Calendar.YEAR,mnts);
                element.sendKeys(simdate.format(cal.getTime()));
                break;
            case "minus":
                cal.add(Calendar.YEAR,-mnts);
                element.sendKeys(simdate.format(cal.getTime()));
                break;
            default:
                element.sendKeys(simdate.format(cal.getTime()));
                break;
        }
    }
    public WebElement get_element(String xpath){
        return driver.findElement(By.xpath(xpath));
    }
    public List<WebElement> get_elements(String xpath){
        return driver.findElements(By.xpath(xpath));
    }
    public Boolean is_editable_by_attribute(WebElement ele){
        String flag= ele.getAttribute("readonly");
        if(flag.equalsIgnoreCase("true"))
            return Boolean.TRUE;
        return Boolean.FALSE;
    }
//    public Boolean is_editable(String xpath){
//        element = get_element(xpath);
//        previous_text = element.getText();
//        try{
//            element.sendKeys(randomString());
//            if(previous_text.equalsIgnoreCase(element.getText())){
//                return Boolean.FALSE;
//            }else { return Boolean.TRUE; }
//        }catch (NoSuchElementException e){
//            return Boolean.FALSE;
//        }
//    }
//    public Boolean is_editable(WebElement ele){
//        ele.clear();
//        try{
//            previous_text = randomString();
//            ele.sendKeys(previous_text);
//            click_element(save_btn_1);
//            Thread.sleep(3000);
//            if(previous_text.equalsIgnoreCase(ele.getText())){
//                return Boolean.TRUE;
//            }else { return Boolean.FALSE; }
//        }catch (NoSuchElementException | InterruptedException e){
//            return Boolean.FALSE;
//        }
//    }

    public boolean odd_or_even(int a){
        if (a % 2 == 0) {
            // if 'a' is even
            return Boolean.TRUE;
        }
        else {
            return Boolean.FALSE;
        }
    }

    public WebElement select_dropdown_first_selected(String xpath){
        Select select = new Select(get_element(xpath));
        return select.getFirstSelectedOption();
    }
    public WebElement select_dropdown_first_selected(WebElement ele){
        Select select = new Select(ele);
        return select.getFirstSelectedOption();
    }

    public List<WebElement> select_dropdown_get_options(String xpath){
        Select select = new Select(get_element(xpath));
        return select.getOptions();
    }

    public void js_click(WebElement ele){
        js.executeScript("arguments[0].click();",ele);
    }
    public void js_click(String xpath){
        element = get_element(xpath);
        js.executeScript("arguments[0].click();",element);
    }
    public String randomString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return "Auto_qa_"+saltStr;
    }
    // subscriptions invoice search page filters check
    public List<WebElement> get_present_filters(){
        return get_elements("//div[@class='row']/div/div[@class='row align-items-self-start']/div[1]/select");
    }

    public String get_filter_mapping(String filter){
        TreeMap<String,String> filter_map= new TreeMap<>();
        filter_map.put("Customer","input");
        filter_map.put("Customer Portal View","select");
        filter_map.put("Status","ul//li");
        filter_map.put("Payment Status","select");
        filter_map.put("Invoice Date","input");
        filter_map.put("Document #","input");
        filter_map.put("Document Type","select");
        filter_map.put("Subs #","input");
        filter_map.put("Customer PO #","input");
        filter_map.put("Created Date","input");
        filter_map.put("Created By","input");
        Set<Map.Entry<String, String>> me = filter_map.entrySet();
        for(Map.Entry<String, String> m:me){
            if(m.getKey().equalsIgnoreCase(filter)){
                return m.getValue();
            }
        }
        return "";
    }

    public void select_single_filter(String filter,String value) throws InterruptedException {
        int count=1;
        options_list = get_present_filters();

        // checks if filter in existing or saved filters
        // if filter is present in existing filters on page
        // continues to use and edit filter value
        fullout:
        if(!(options_list.size()==0)){
            for (WebElement row:options_list) {
                if(select_dropdown_first_selected(row).getText().equalsIgnoreCase(filter)){
                    if (filter.equalsIgnoreCase("Status")) {
                        move_and_click("//div[@class='multiselect__tags']");
                        Thread.sleep(1000);
                        select_unordered_list("//div[@class='row']/div/div[@class='row align-items-self-start']/div[1]/select/../../div["+(2*count)+"]//ul","li",value);
                        move_and_click("//div[@class='row']//div[@tabindex='0']/div[1]");
                        break fullout;
                    }
                    select_drop_down("//div[@class='row']/div["+count+"]/div[@class='row align-items-self-start']/div[1]/select",filter);
                    element =get_element("//div[@class='row']/div["+count+"]/div[@class='row align-items-self-start']/div[1]/select");
                    String tag = get_filter_mapping(select_dropdown_first_selected(element).getText());
                    switch (tag){
                        case "input":
                            element=get_element("//div[@class='row']/div["+count+"]/div[@class='row align-items-self-start']/div[1]/select/../..//"+tag);
                            element.clear();
                            Thread.sleep(2000);
                            element.sendKeys(value);
                            break fullout;
                        case "select":
                            move_and_click("//div[@class='row']/div[1]/div[@class='row align-items-self-start']/div[1]/select/../../div[2]//"+tag);
                            Thread.sleep(1000);
                            select_drop_down("//div[@class='row']/div[1]/div[@class='row align-items-self-start']/div[1]/select/../../div[2]//"+tag,value);
                            action.sendKeys(Keys.ESCAPE);
                            break fullout;
                    }

                }count++;
            }
            count =1;
            select_drop_down("//div[@class='row']/div[1]/div[@class='row align-items-self-start']/div[1]/select",filter);
            element =get_element("//div[@class='row']/div[1]/div[@class='row align-items-self-start']/div[1]/select");
            String tag = get_filter_mapping(select_dropdown_first_selected(element).getText());
            if (filter.equalsIgnoreCase("Status")) {
                move_and_click("//div[@class='multiselect__tags']");
                Thread.sleep(1000);
                select_unordered_list("//div[@id='layout-wrapper']//div//div//div//div//div//div//div//div//div//div//div//div//div//div//div//ul","li",value);
                break fullout;
            }
            switch (tag){
                case "input":
                    element=get_element("//div[@class='row']/div["+count+"]/div[@class='row align-items-self-start']/div[1]/select/../..//"+tag);
                    element.clear();
                    element.sendKeys(value);
                    break fullout;
                case "select":
                    move_and_click("//div[@class='row']/div[1]/div[@class='row align-items-self-start']/div[1]/select/../../div[2]//"+tag);
                    Thread.sleep(1000);
                    select_drop_down("//div[@class='row']/div[1]/div[@class='row align-items-self-start']/div[1]/select/../../div[2]//"+tag,value);
            }
        }
    }

// Multiple filters to any search page
//    public void select_multiple_filters(List<Pair<String,String>> filters) throws InterruptedException {
//        int no_of_filters = filters.size(), row = 1;
//        move_and_click("//button[contains(text(),'Clear')]");
//        Thread.sleep(4000);
//        options_list = get_present_filters();
//        // adding more filters
//        if(no_of_filters > 2){
//            for(Pair<String,String> p: filters){
//
//            }
//            for(int i = 1; i <= (no_of_filters - 2); i++ ){
//
//            }
//        }
//    }


    public void add_filter(String filter,String value) throws InterruptedException {
        int count=1;
        options_list = get_present_filters();
        // checks if filter in existing or saved filters
        // if filter is present in existing filters on page
        // continues to use and edit filter value
        fullout:
        if(!(options_list.size()==0)) {
            for (WebElement row : options_list) {
                if (select_dropdown_first_selected(row).getText().equalsIgnoreCase(filter)) {
                    if (filter.equalsIgnoreCase("Status")) {
                        move_and_click("//div[@class='multiselect__tags']");
                        Thread.sleep(1000);
                        select_unordered_list("//div[@id='layout-wrapper']//div//div//div//div//div//div//div//div//div//div//div//div//div//div//div//ul", "li", value);
                        action.sendKeys(Keys.ESCAPE);
                        break fullout;
                    }
                    select_drop_down("//div[@class='row']/div[1]/div[@class='row align-items-self-start']/div[1]/select", filter);
                    element = get_element("//div[@class='row']/div[1]/div[@class='row align-items-self-start']/div[1]/select");
                    String tag = get_filter_mapping(select_dropdown_first_selected(element).getText());
                    switch (tag) {
                        case "input":
                            element = get_element("//div[@class='row']/div[" + count + "]/div[@class='row align-items-self-start']/div[1]/select/../..//" + get_filter_mapping(select_dropdown_first_selected(element).getText()));
                            element.clear();
                            element.sendKeys(value);
                            break fullout;
                        case "select":
                            move_and_click("//div[@class='row']/div[" + count + "]/div[@class='row align-items-self-start']/div[1]/select/../..//" + get_filter_mapping(select_dropdown_first_selected(element).getText()));
                            Thread.sleep(1000);
                            select_drop_down("//div[@class='row']/div[" + count + "]/div[@class='row align-items-self-start']/div[1]/select/../..//" + get_filter_mapping(select_dropdown_first_selected(element).getText()), value);
                            action.sendKeys(Keys.ESCAPE);
                            break fullout;
                    }
                }
                count++;
            }
        }
        js_click(get_element("//i[@title='Add']"));
        Thread.sleep(1000);
        select_drop_down("//div[@class='row']/div[1]/div[@class='row align-items-self-start']/div[1]/select",filter);
        element =get_element("//div[@class='row']/div[1]/div[@class='row align-items-self-start']/div[1]/select");
        String tag = get_filter_mapping(select_dropdown_first_selected(element).getText());
        if (filter.equalsIgnoreCase("Status")) {
            move_and_click("//div[@class='multiselect__tags']");
            Thread.sleep(1000);
            select_unordered_list("//div[@id='layout-wrapper']//div//div//div//div//div//div//div//div//div//div//div//div//div//div//div//ul","li",value);
        }
        switch (tag){
            case "input":
                element=get_element("//div[@class='row']/div["+count+"]/div[@class='row align-items-self-start']/div[1]/select/../..//"+get_filter_mapping(select_dropdown_first_selected(element).getText()));
                element.clear();
                element.sendKeys(value);
                break;
            case "select":
                move_and_click("//div[@class='row']/div["+count+"]/div[@class='row align-items-self-start']/div[1]/select/../..//"+get_filter_mapping(select_dropdown_first_selected(element).getText()));
                Thread.sleep(1000);
                select_drop_down("//div[@class='row']/div["+count+"]/div[@class='row align-items-self-start']/div[1]/select/../..//"+get_filter_mapping(select_dropdown_first_selected(element).getText()),value);
        }

    }

    public void select_multiple_status(String[] status) throws InterruptedException {
        move_and_click("//div[@class='multiselect__tags']");
        Thread.sleep(1000);
        for(String s:status){
            select_unordered_list("//div[@id='layout-wrapper']//div//div//div//div//div//div//div//div//div//div//div//div//div//div//div//ul","li",s);
        }
        action.sendKeys(Keys.ESCAPE);
    }
    public String[] webelemts_text_list(List<WebElement> list){
        String[] text_list = new String[list.size()];
        int count =0;
        for(WebElement ele:list){
            text_list[count] = ele.getText();
            count++;
        }
        return text_list;
    }

// browser operations

    public void open_empty_new_tab(){
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.CONTROL);
        actions.sendKeys(Keys.getKeyFromUnicode('t'));
        actions.perform();
    }


// presidio operations
    List<WebElement> more_actions_options = new ArrayList<>();
    public String[] require_field = {"//div[contains(text(),'Customer PO #:')]/..//input","//div[@id='PurchaseOrderInformationDiv']//div//div//div//div[contains(text(),'Bill To:')]/..//select","//div[contains(text(),'Provisioning Email:')]/..//input"};

    public void create_change_replace(String[] discriptions) throws InterruptedException {
        // navigate to dashboard
        move_and_click("//div[contains(text(),'Vendor Subscription #:')]/../../div[1]/div[2]/a/a");
        switch_to_child_window();

        // click on more actions and select change replace
        log.info("clicking More Action button Initiate Change request Request option is displayed");
        move_and_click("//body/div[@id='layout-wrapper']/descendant::div[44]/button");
        Thread.sleep(2000);
        options_list = select_unordered_list("//div[@class='dropdown-menu dropdown-menu-right show']","a");
        for (WebElement ele:options_list) {
            if(ele.getText().equalsIgnoreCase("Initiate Change Request")){
                move_and_click(ele);
                break;
            }
        }
        Thread.sleep(4000);
        move_and_click("//input[@id='ChangeReplace']");
        move_and_click("//button[contains(text(),'Ok')]");
        switch_to_child_window();

        // enter title
        Thread.sleep(4000);
        element = get_element("//div[@id='titleDiv']/input");
        fluent_wait_sendkeys_not_interactable(element,randomString());
        Thread.sleep(3000);
        move_and_click("//div[@id='Subscription']/div/div[1]/div[1]//button[contains(text(),'Save')]");

        // send in more actions
        Thread.sleep(6000);
        more_actions("Send");

        // opportunity
        Thread.sleep(4000);
        js_click(get_element("//i[@class='fa fa-link']"));
        move_and_click("//div[@class='modal-mask']//tr[1]//td[1]//input[1]");
        move_and_click("//button[contains(text(),'Link')]");

        // fill fields
        Thread.sleep(4000);
        move_and_click("//a[contains(text(),'Change Order Details')]");
        Thread.sleep(2000);
        send_text_element("//div[contains(text(),'Customer PO #:')]/..//input",randomString());
        Thread.sleep(2000);
        select_drop_down("//div[@id='PurchaseOrderInformationDiv']//div//div//div//div[contains(text(),'Bill To:')]/..//select",1);
        Thread.sleep(2000);
        element = get_element("//div[contains(text(),'Provisioning Email:')]/..//input");
        element.clear();
        element.sendKeys("automationtest@gmail.com");
        Thread.sleep(2000);
        move_and_click("(//a[contains(text(),'Change Request Details')])[2]");
        Thread.sleep(2000);
        move_and_click("//div[@id='Subscription']/div/div[1]/div[1]//button[contains(text(),'Save')]");
        Thread.sleep(5000);

        // disable pre-order validation
        Thread.sleep(4000);
        wait_element_located_element_visibility("//button[contains(text(),'Disable Pre Order Validation')]");
        fluent_wait_click_not_interactable("//button[contains(text(),'Disable Pre Order Validation')]");

        // change quantity
        Thread.sleep(8000);
        int row = 1;
        options_list = get_elements("//div[@id='LineItem']/div/div/div[3]/div[1]/div/table/tbody/tr");
        for(String s: discriptions){
            for(WebElement ele:options_list){
                if(!(odd_or_even(row))){
                    if(get_element_text("//div[@id='LineItem']/div/div/div[3]/div[1]/div/table/tbody/tr["+row+"]/td[6]").equalsIgnoreCase(s)){
                        log.info("row to change quantity: "+row);
                        int qty = Integer.parseInt(get_element("//div[@id='LineItem']/div/div/div[3]/div[1]/div/table/tbody/tr["+row+"]/td[8]//input").getAttribute("value"));
                        log.info("value is: "+qty);
                        get_element("//div[@id='LineItem']/div/div/div[3]/div[1]/div/table/tbody/tr["+row+"]/td[8]//input").clear();
                        Thread.sleep(3000);
                        get_element("//div[@id='LineItem']/div/div/div[3]/div[1]/div/table/tbody/tr["+row+"]/td[8]//input").sendKeys(Keys.DELETE);
                        Thread.sleep(1000);
                        send_text_element("//div[@id='LineItem']/div/div/div[3]/div[1]/div/table/tbody/tr["+row+"]/td[8]//input",String.valueOf(qty+5));
                        break;
                    }
                }row++;
            }
        }
        move_and_click("//div[@id='Subscription']/div/div[1]/div[1]//button[contains(text(),'Save')]");

        // send for verification
        Thread.sleep(6000);
        more_actions("Submit for Approval");

        // edit qc
        Thread.sleep(4000);
        more_actions("Edit QC");
        wait_text_to_be_present_in_element("//div[@id='Subscription']//h5","Edit QC & Rev Rec Information");
        Thread.sleep(3000);
        select_drop_down("//div[@class='modal-body']//select","Bernadette Paszel");
        move_and_click("//button[contains(text(),'Release Verification')]");

        // release credit hold
        Thread.sleep(4000);
        more_actions("Release Credit Hold");

        // mark submitted to vendor
        Thread.sleep(4000);
        more_actions("Mark Submitted to Vendor");

        // mark complete
        Thread.sleep(4000);
        more_actions("Mark Complete");
        Thread.sleep(2000);
        get_element("//h5/../..//label[contains(text(),'Remaining Term:')]/../..//input").clear();
        Thread.sleep(1000);
        send_text_element("//h5/../..//label[contains(text(),'Remaining Term:')]/../..//input","12");
        Thread.sleep(1000);
        set_date_days("//h5/../..//label[contains(text(),'Start Date:')]/../..//input",5,"minus");
        Thread.sleep(1000);
        set_date_years("//h5/../..//label[contains(text(),'End Date:')]/../..//input",1,"plus");
        Thread.sleep(1000);
        move_and_click("//button[contains(text(),'Mark Complete')]");
    }

    public void create_vendor_invoice(String[] discriptions,String sub_num) throws InterruptedException {
        // click on vendor invoice in menu
        Thread.sleep(5000);
        move_and_click("//div//ul//li//a[text()='Vendor Invoices']");

        // click on create invoice
        Thread.sleep(5000);
        move_and_click("//div[@id='datatable_wrapper']//div/button[contains(text(),'Create Invoice')]");
        switch_to_child_window();

        // enter title
        Thread.sleep(6000);
        send_text_element("//div[contains(text(),'Invoice #:')]/..//input",randomString());

        // enter required values
        Thread.sleep(5000);
        send_text_element("//div[2]/div[2]/div/div[1]/input",prop.getProperty("vendor_name"));
        Thread.sleep(3000);
        js_click("//i[@class='fas fa-search']");
        try {
            List<WebElement> options = driver.findElements(By.xpath("//ul/li[@class='autocomplete-result']"));
            for (WebElement option : options) {
                if (option.getText().trim().contains("Cisco Systems, Inc. [CISC01]")) {
                    option.click();
                }

            }
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            List<WebElement> options = driver.findElements(By.xpath("//ul/li[@class='autocomplete-result']"));
            for (WebElement option : options) {
                if (option.getText().trim().contains("Cisco Systems, Inc. [CISC01]")) {
                    option.click();
                }

            }
        }

        Thread.sleep(3000);
        log.info("Vendor name updated Successfully");

        //select on payment terms
        WebElement pay_terms_drpdwn = driver.findElement(By.xpath("//div/div[2]/div[1]/div[2]/div/select"));
        pay_terms_drpdwn.click();
        Thread.sleep(3000);
        select_drop_down("//div/div[2]/div[1]/div[2]/div/select",14);
        log.info("Payment terms selected Successfully");
        Thread.sleep(3000);

        //user selects date for invoice date and date received
        set_date_days("//div/div[3]/div[1]/div[2]/div/div[1]/div/input",10,"minus");
        Thread.sleep(3000);
        set_date_days("//div[3]/div[2]/div[2]/div/div[1]/div/input",5,"plus");
        Thread.sleep(3000);
        set_date_days("//div[contains(text(),'Posting Date:')]/..//input",5,"plus");
        Thread.sleep(3000);

        //click on title contract vehicle
        WebElement title_head = driver.findElement(By.xpath("//div[2]/div/div/div[1]/h4/span"));
        title_head.click();
        Thread.sleep(3000);
        move_and_click("//div/button[contains(text(),'Save')]");
        Thread.sleep(3000);
        log.info("Clicked on Save button Successfully");

        //CSVI user clicks on three dots to add line items
        WebElement three_dots1 = driver.findElement(By.xpath("//div[@id='VendorInvoice']//a[@id='dropdownMenuButton']/i"));
        action.moveToElement(three_dots1).click().perform();
        Thread.sleep(3000);

        try {
            List<WebElement> options = driver.findElements(By.xpath("//a[@href='javascript:void(0)'][@class='dropdown-item']"));
            for (WebElement option : options) {
                if (option.getText().trim().contains("Add Item")) {
                    action.moveToElement(option).perform();
                    option.click();
                }
            }
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            List<WebElement> options = driver.findElements(By.xpath("//a[@href='javascript:void(0)'][@class='dropdown-item']"));
            for (WebElement option : options) {
                if (option.getText().trim().contains("Add Item")) {
                    action.moveToElement(option).perform();
                    option.click();
                }
            }
        }
        log.info("Clicked on Add Item Successfully");
        driver.switchTo().activeElement();

//        VendorInvoiceDetailsPage vip = new VendorInvoiceDetailsPage();
        Thread.sleep(3000);
//        vip.select_hambuger_option_ven_inv("Add Item");
        Thread.sleep(2000);
        //enter subscription number
        send_text_element("//div[2]/div/div[1]/div/div/div[2]/div[1]/input", prop.getProperty(sub_num));

        log.info("Entered the subscription number Successfully");
        Thread.sleep(3000);
        js_click("//button/i[@class='fa fa-search']");
        Thread.sleep(4000);
        // select from purchase order dropdown
        move_and_click("//label[contains(text(),'Purchase Order:')]/../..//select");
        Thread.sleep(2000);
        options_list = select_dropdown_get_options("//label[contains(text(),'Purchase Order:')]/../..//select");
        Thread.sleep(1000);
        options_list.stream()
                .filter(x->{
                    if (x.getText().equalsIgnoreCase("Not Selected")) {
                        return false;
                    }
                    return true;
                }).reduce((x,y)->y).get().click();
        int row=1;
        options_list=get_elements("//label[contains(text(),'Subscription # / Vendor Subscription #:')]/../../../../..//tbody/tr/td[5]");
        for(String s:discriptions){
            for (WebElement ele:options_list){
                if(ele.getText().equalsIgnoreCase(s)){
                    move_and_click("//label[contains(text(),'Subscription # / Vendor Subscription #:')]/../../../../..//tbody/tr["+row+"]/td[1]/input");
                    break;
                }
                row++;
            }
        }
        Thread.sleep(3000);
        move_and_click("//button[contains(text(),'Add & Close')]");
        Thread.sleep(3000);
        options_list = get_elements("//div[@id='VendorInvoice']/div/div/div[3]//tbody/tr");
        row =1;
        for(WebElement ele:options_list){
            if(!(odd_or_even(row))){
                get_element("//div[@id='VendorInvoice']/div/div/div[3]//tbody/tr[1]/td[10]//input").sendKeys(Keys.CONTROL+"a");
                Thread.sleep(1000);
                get_element("//div[@id='VendorInvoice']/div/div/div[3]//tbody/tr[1]/td[10]//input").sendKeys(Keys.DELETE);
                Thread.sleep(1000);
                send_text_element("//div[@id='VendorInvoice']/div/div/div[3]//tbody/tr[1]/td[10]//input","0.5");
                set_date_days("//div[@id='VendorInvoice']/div/div/div[3]//tbody/tr["+row+"]/td[13]//input",1,"minus");
                set_date_days("//div[@id='VendorInvoice']/div/div/div[3]//tbody/tr["+row+"]/td[14]//input",1,"plus");
            }row++;
        }
        Thread.sleep(2000);
        move_and_click("//div/button[contains(text(),'Save')]");
    }


    public void more_actions(String option) throws InterruptedException {
        Thread.sleep(2000);
        move_and_click(get_element("//body//div[@id='Subscription']//div//div[1]//div[1]//div[2]//div[1]//div[1]//button[1]"));
        Thread.sleep(2000);
        get_more_actions_options();
        for (WebElement ele: more_actions_options){
            if(ele.getText().equalsIgnoreCase(option)){
                move_and_click(ele);
            }
        }
    }

    public void get_more_actions_options(){
        fluent_wait_no_such_element("//div[@id='Subscription']/div/div[1]/div[1]//button[@id='btnGroupVerticalDrop1']/..//div[@id='divToButtonGroup']");
        more_actions_options = select_unordered_list("//div[@id='Subscription']/div/div[1]/div[1]//button[@id='btnGroupVerticalDrop1']/..//div[@id='divToButtonGroup']","a");
    }

    public void fill_mandatory_field(){
        int count = 1;
        for(String s: require_field){
            switch (count){
                case 1:
                    element = get_element(s);
                    fluent_wait_sendkeys_not_interactable(element,"Auto Test Cust PO1");
                    //element.sendKeys("Auto Test Cust PO1");
                    count++;
                    break;
                case 2:
                    select_drop_down(s,1);
                    count++;
                    break;
                case 3:
                    element = get_element(s);
                    element.clear();
                    element.sendKeys("automationtest@gmail.com");
                    break;
            }
        }
    }

    public String numberUptoFourDecimal(double lower , double upper ,int decimal_places)
    {
        double result = (double) (Math.random() * (upper - lower)) + lower;
        return( String.format("%."+ decimal_places +"f",result));
    }

    public String removeTrailingZeros(String value){
        StringBuilder sb = new StringBuilder(value);
        while (sb.length()>0){
            if(sb.charAt(sb.length()-1)=='0'){
                sb.deleteCharAt(sb.length()-1);
            }else {
                break;
            }
        }
        return sb.toString();
    }
    /*
     * Switch windows based on Title
     */
    public void switchWindowFDpage(String tabName)
    {
    	Set<String> windows = driver.getWindowHandles();
    	for (String wId : windows) {
			driver.switchTo().window(wId);
			String title = driver.getTitle();
			System.out.println(title);
			
			if(title.contains(tabName))
			{
				Assert.assertTrue(title.contains(tabName));
				break;
			}
		}
    }
    
    public void switchWindow(String wondowId)
    {
    	driver.switchTo().window(wondowId);
    }
}
