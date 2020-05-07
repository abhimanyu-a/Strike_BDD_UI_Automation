package managers;

import dataProviders.ConfigFileReader;

public class DriverManagerFactory {

	public static DriverManager getDriverManager() {
		DriverManager driverManager = null;
		String browser;
		browser = ConfigFileReader.getProperty("BROWSER");
	
	switch (browser) {
		case "chrome":
			driverManager = new ChromeDriverManager();
			break;
		case "firefox":
			driverManager = new FirefoxDriverManager();
			break;
		default:
		}
		return driverManager;
	}

}
