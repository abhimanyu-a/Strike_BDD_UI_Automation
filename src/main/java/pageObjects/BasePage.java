package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dataProviders.ConfigFileReader;

public class BasePage extends BaseActionPage {

	protected WebDriver driver;
	WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		//this.wait = new WebDriverWait(driver, Integer.parseInt(ConfigUtil.getProperty("WAIT_TIME")));
		this.wait = new WebDriverWait(driver, Integer.parseInt(ConfigFileReader.getProperty("WAIT_TIME")));
	}

	@Override
	public BasePage waitandclick(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		return this;
	}

	@Override
	public BasePage waitandwrite(WebElement element, String text) {
		wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(text);
		return this;
	}

	@Override
	public BasePage waitandwrite(WebElement element, Keys key) {
		element.sendKeys(key);
		return this;
	}

	@Override
	public BasePage waitfor(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		return this;
	}

}
