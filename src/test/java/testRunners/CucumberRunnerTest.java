package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = { "src/test/resources/functionalTests" }, 
		glue = { "stepDefinitions" },
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, 
		dryRun = false, 
		strict = true, 
		monochrome = true)


public class CucumberRunnerTest {
	
}
