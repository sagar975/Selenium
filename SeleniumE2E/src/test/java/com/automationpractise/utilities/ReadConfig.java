package com.automationpractise.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public  class ReadConfig {

	protected static Properties prop;
	protected static FileInputStream file;

	public ReadConfig() {

		try {
			file = new FileInputStream(

					"C:\\SeleniumCloned\\Selenium\\SeleniumE2E\\Configuration\\EnvironmentVaraibles.properties");
			prop = new Properties();

			try {
				prop.load(file);
			} catch (IOException exception) {

				System.out.println("exception is occured" + " " + exception.getMessage());

			}

		}

		catch (FileNotFoundException exception) {

			System.out.println("exception is occured" + " " + exception.getMessage());

		}

	}

	public String getURL() {

		return prop.getProperty("url");

	}

	public String getUserName() {

		return prop.getProperty("username");

	}

	public String getPassWord() {

		return prop.getProperty("password");
	}

	public String getProduct() {

		return prop.getProperty("productSearch");
	}

}
