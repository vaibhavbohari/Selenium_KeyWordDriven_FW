package com.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.utility.Utility;

public class BaseClass {
	
	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver(String browserName) {
		if (browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\VAIBHAV\\QAAutomation\\chromedriver.exe");
			if (prop.getProperty("headless").equals("yes")) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				driver = new ChromeDriver(options);
			} else {
				driver = new ChromeDriver();
			}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Utility.PAGE_LOAD_TIME, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Utility.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
			return driver;
		}
		return driver;
	}

	public Properties initializeProperties() {
		prop = new Properties();
		try {
			FileInputStream inputStream = new FileInputStream(
					"C:\\Users\\VAIBHAV\\eclipse-workspace\\Facebook_KeyWordDriven_Framework\\src\\main\\java\\com\\config\\config.properties");
			prop.load(inputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
		
	}

}
