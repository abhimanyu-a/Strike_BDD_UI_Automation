package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import dataProviders.ConfigFileReader;

public class FirefoxDriverManager extends DriverManager {

	protected WebDriver driver;

	@Override
	protected WebDriver createDriver() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + ConfigFileReader.getProperty("FIREFOX_PATH"));

		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		return driver;

	}

}
