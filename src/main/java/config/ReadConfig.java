package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	public static Properties property;

	private static String configPath = "./config.properties";

	public ReadConfig() {

		property = new Properties();

		try {
			FileInputStream in = new FileInputStream(configPath);
			property.load(in);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getBroserName() {

		String browserName = property.getProperty("browser");
		if(browserName!=null) {
			return browserName;
		}
		else 
			throw new RuntimeException("Browser name not specified in configuration file");
	}

	public String getBaseUrl() {

		String baseurl = property.getProperty("url");
		if(baseurl!=null) {
			return baseurl;
		}
		else 
			throw new RuntimeException("baseUrl name not specified in configuration file");
	}

	public String getUsername() {

		String uname = property.getProperty("username");
		if(uname!=null) {
			return uname;
		}
		else 
			throw new RuntimeException("username name not specified in configuration file");
	}

	public String getPassword() {

		String pwd = property.getProperty("password");
		if(pwd!=null) {
			return pwd;
		}
		else 
			throw new RuntimeException("password name not specified in configuration file");
	}

}
