package com.sprint.qa.Pages;

import com.sprint.qa.base.TestBase;
import com.sprint.qa.helper.Helper;
import com.sprint.qa.helper.LoggerHelper;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class SubscriptionDashboardPage extends TestBase {
    private final String Dashboard_link = "//span[text()='Dashboard']";
    Logger log = LoggerHelper.getLogger(LoggerHelper.class);

    public SubscriptionDashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyDashboard() throws InterruptedException {
        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(By.xpath(Dashboard_link))).click().build().perform();
        Thread.sleep(8000);
        h.wait_text_to_be_present_in_element("//h4[text()='Dashboard']","Dashboard");
        String title = driver.getTitle();
        log.info(title);
        Assert.assertEquals("Dashboard", title);
    }

    public void verifyDashboardList(String link) throws InterruptedException {

        Actions act = new Actions(driver);
        try {
            log.info("click all dashboard links and verify");
            final String locator="//div//h4[contains(text(),'"+link+"')]/..//div[@class='dashcard-view-detail']//a//a[contains(@href,'#/subscription')]";
            //ExplicitWaits(locator);
            act.moveToElement(driver.findElement(By.xpath(locator))).build().perform();
            act.moveToElement(driver.findElement(By.xpath(locator))).click().build().perform();
            act.sendKeys(locator,Keys.ENTER);
            Thread.sleep(6000);
        } catch (ElementClickInterceptedException e) {
            e.printStackTrace();
        }
        Thread.sleep(5000);
        if(link==prop.getProperty("Dashboardlink7")|link==prop.getProperty("Dashboardlink8")|link==prop.getProperty("Dashboardlink9")){
        String title = driver.getTitle();
            Assert.assertEquals("Change Requests", title);
        }
        else if(link==prop.getProperty("Dashboardlink10")|link==prop.getProperty("Dashboardlink11")){
            String title = driver.getTitle();
            Assert.assertEquals("Vendor Invoice", title);
        }
        else{
            String title = driver.getTitle();
            Assert.assertEquals("Subscriptions", title);
        }
    }
}


