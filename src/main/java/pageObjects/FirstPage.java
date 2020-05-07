package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FirstPage extends BasePage {

	WebDriver driver;

	@FindBy(name = "q")
	@CacheLookup
	public WebElement searchBox;
	
	@FindBy(id = "result-stats")
	@CacheLookup
	public WebElement resultsText;

	public FirstPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void performGoogleSearch(String text) {
		waitandwrite(searchBox, text).waitandwrite(searchBox, Keys.ENTER);
	}

}
