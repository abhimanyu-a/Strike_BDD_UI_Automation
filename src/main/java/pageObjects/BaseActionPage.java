package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public abstract class BaseActionPage{

	protected abstract BasePage waitandclick(WebElement element);

	protected abstract BasePage waitandwrite(WebElement element, String text);
	
	protected abstract BasePage waitandwrite(WebElement element, Keys text);
	
	protected abstract BasePage waitfor(WebElement element);

}
