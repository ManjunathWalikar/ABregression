package test.RegressionTest;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {
				"src/main/resources/features/features_Reg/DailyValidation.feature"
		},
		glue={"StepDefinitions"},//the path of the step definition files
		plugin = {"pretty",
				"html:target/cucumber-reports/cucumber-pretty.html",
				"rerun:target/cucumber-reports/rerun.txt",
				"json:target/cucumber-reports/CucumberTestReport.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				},
		//to generate different type of reporting
		monochrome = false, //display the console o/p in proper readable format
		dryRun = false,//to check the mapping is proper between feature file and step def file
		stepNotifications = true,
		tags="@LUXFD"
		//tags = "@Regression1,~@ignore"

)
public class DailyTestRunner {												
	
}
