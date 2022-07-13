package com.utilities;

import java.io.FileInputStream;
import java.util.Properties;


public class ReadConfig {

	Properties properties;
	String prop_path = "C:\\Users\\INDRAJIT\\eclipse-workspace\\com.db_support\\Configaration\\config.properties";

	public ReadConfig(){

		try {
			FileInputStream fis = new FileInputStream(prop_path);
			properties = new Properties();
			properties.load(fis);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getBaseUrl() {

		String base_URL= properties.getProperty("base_url");

		if(base_URL != null){

			return base_URL;
		}
		else {
			throw new RuntimeException("URL not define in propertoes file");
		}
	}

	public String getBrowser() {

		String browser  = properties.getProperty("browser");

		if(browser != null) {

			return browser;
		}
		else {

			throw new RuntimeException("Browser name not specified in properties file");
		}

	}

	public String getImplicitWait() {

		String wait  = properties.getProperty("implicitlyWaitTime");

		if(wait != null) {

			return wait;
		}
		else {

			throw new RuntimeException("Wait not specified in Properties file");
		}
	}
	
	
}
