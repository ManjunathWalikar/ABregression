package StepDefinitions;

import org.apache.log4j.Logger;

import com.sprint.qa.base.PageObjects;
import com.sprint.qa.helper.Helper;
import com.sprint.qa.helper.LoggerHelper;
import com.sprint.qa.util.TestUtil;

public class HkProdStepDefinition {
	TestUtil testUtil;
	Logger log = LoggerHelper.getLogger(LoggerHelper.class);
	Helper help = new Helper();
	PageObjects po = new PageObjects();
	
	public HkProdStepDefinition()
	{
		super(); // super class constructor to initialize properties
	}

}
