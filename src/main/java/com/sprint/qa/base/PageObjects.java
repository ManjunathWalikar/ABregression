package com.sprint.qa.base;

import com.sprint.qa.Pages.HomePage;
import com.sprint.qa.Pages.SubscriptionDetailsPage;
import com.sprint.qa.Pages.UsFundDetailsPage;
import com.sprint.qa.Pages.UsFundFinderPage;

public class PageObjects {

	public SubscriptionDetailsPage subscription_details_page;
	public UsFundFinderPage us_fund_finder_page;
	public UsFundDetailsPage us_fund_details_page;
	public HomePage home_page;

	public PageObjects()
	{
	subscription_details_page = new SubscriptionDetailsPage(TestBase.driver);
	us_fund_finder_page = new UsFundFinderPage(TestBase.driver);
	us_fund_details_page = new UsFundDetailsPage(TestBase.driver);
	home_page = new HomePage(TestBase.driver);

	}
}
