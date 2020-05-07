package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

	WebDriver driver;
	private static final String SSHOT_PATH = System.getProperty("user.dir") + "\\Screenshots\\";

	public ScreenshotUtil(WebDriver driver) {
		this.driver = driver;
	}

	public void takeScreenshot() throws IOException {
		try {
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(SSHOT_PATH + sdf.format(d) + "//" + sdf.format(d) + ".png"));
		}

		catch (IOException e) {
			e.printStackTrace();
		}

	}

}
