package managers;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

	protected WebDriver driver;

	protected abstract WebDriver createDriver();

	public void quitDriver() {
		if (null != driver) {
			driver.quit();
			driver = null;
		}
	}

	public WebDriver getDriver() {
		if (null == driver) {
			driver = createDriver();
		}
		return driver;
	}
}
