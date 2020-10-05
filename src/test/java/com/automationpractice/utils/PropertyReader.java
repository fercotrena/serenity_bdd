package com.automationpractice.utils;


import java.util.ResourceBundle;

public class PropertyReader {
	
	private ResourceBundle configFile;

	public PropertyReader() {

		try {
			configFile = ResourceBundle.getBundle("base");
		} catch (Exception ex) {

			ex.printStackTrace();
		}
	}

	public String getProperty(String key) {
		return this.configFile.getString(key);
	}
}
