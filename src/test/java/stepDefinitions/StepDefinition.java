package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import dataProviders.ConfigFileReader;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.DriverManager;
import managers.DriverManagerFactory;
import pageObjects.FirstPage;
import utilities.LogUtils;
import utilities.ScreenshotUtil;

public class StepDefinition {

	DriverManager driverManager;
	WebDriver driver;
	FirstPage firstPage;
	ScreenshotUtil ssUtil;
	String searchKey = "";
	private static final LogUtils LOG = new LogUtils(StepDefinition.class);

	@Given("User Navigates to {string} website")
	public void user_Navigates_to_website(String string) {
		String url = ConfigFileReader.getProperty("URL");
		driverManager = DriverManagerFactory.getDriverManager();
		driver = driverManager.getDriver();
		ssUtil = new ScreenshotUtil(driver);
		LOG.info("Driver created");
		driver.navigate().to(url);
		LOG.info("Launching application - " + url);
	}

	@When("User searches for {string}")
	public void user_searches_for(String searchKey) {
		firstPage = new FirstPage(driver);
		firstPage.waitandwrite(firstPage.searchBox, searchKey);
		firstPage.waitandwrite(firstPage.searchBox, Keys.ENTER);
		LOG.info("Search for word " + searchKey + " complete");
	}

	@Then("User should be shown the relevant results")
	public void user_should_be_shown_the_relevant_results() throws InterruptedException {
		firstPage.waitfor(firstPage.resultsText);
		Assert.assertTrue(driver.getTitle().contains(searchKey), "Validation Page Title after Google search");
		LOG.info("Page title matches");
		try {
			ssUtil.takeScreenshot();
			LOG.info("Screenshot captured");
		} catch (IOException e) {
			LOG.fail("Unable to capture screenshot " + e.toString());
		}
	}

	@After
	public void tearDown() {
		driverManager.quitDriver();
		LOG.info("Driver closed");
	}
}
