package dataProviders;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	private final static String FILE_PATH = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\configs\\configuration.properties";

	public static String getProperty(String key) {

		return loadProperty(key);

	}

	private static String loadProperty(String key) {
		try {
			File file = new File(FILE_PATH);
			FileInputStream inStream = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(inStream);
			inStream.close();
			return properties.getProperty(key);
		} catch (IOException e) {
			System.out.println("Unable to read config property file: " + e.toString());
		}
		return null;
	}

}
