package com.sprint.qa.base;

import com.sprint.qa.Pages.HomePage;
import com.sprint.qa.Pages.SgFundDetailsPage;
import com.sprint.qa.Pages.SgFundFinderPage;
import com.sprint.qa.Pages.UsFundDetailsPage;
import com.sprint.qa.Pages.UsFundFinderPage;

public class PageObjects {

	public UsFundFinderPage us_fund_finder_page;
	public UsFundDetailsPage us_fund_details_page;
	public HomePage home_page;
	public SgFundDetailsPage sg_fund_details_page;
	public SgFundFinderPage sg_fund_finder_page;

	public PageObjects()
	{
	us_fund_finder_page = new UsFundFinderPage(TestBase.driver);
	us_fund_details_page = new UsFundDetailsPage(TestBase.driver);
	home_page = new HomePage(TestBase.driver);
	sg_fund_details_page = new SgFundDetailsPage(TestBase.driver);
	sg_fund_finder_page = new SgFundFinderPage(TestBase.driver);

	}
}
