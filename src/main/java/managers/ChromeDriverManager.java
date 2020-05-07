	package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import dataProviders.ConfigFileReader;

public class ChromeDriverManager extends DriverManager {

	@Override
	protected WebDriver createDriver() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + ConfigFileReader.getProperty("CHROME_PATH"));
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		options = setChromeOptions(options);
		options.merge(capabilities);
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		return driver;
	}

	private ChromeOptions setChromeOptions(ChromeOptions options) {
		if (ConfigFileReader.getProperty("BROWSER_MODE").equalsIgnoreCase("incognito")) {
			options.addArguments("incognito");
			return options;
			}
				else if (ConfigFileReader.getProperty("BROWSER_MODE").equalsIgnoreCase("headless")) {
					options.addArguments("headless");
					return options;
					} 
					else {
					return options;
					}
	}

}
