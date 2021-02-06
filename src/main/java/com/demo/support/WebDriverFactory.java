package com.demo.support;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.demo.actions.TestEngine;
import com.demo.base.DriverScript;
import com.demo.util.Util;

public class WebDriverFactory extends DriverScript{
	
	public static WebDriver initialize () throws NumberFormatException, IOException {
		int implicitWait = Integer.parseInt (Util.getProperty("ImplicitWait"));
		if (BROWSER.toUpperCase().equals("CHROME")) {
			System.setProperty ("webdriver.chrome.silentOutput", "true");
			System.setProperty ("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "Drivers" + File.separator + "chromedriver");
			driver = new ChromeDriver();
			TestEngine.deleteCookies();
			driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
			driver.get (baseUrl);
			TestEngine.maximize();
		} else if (BROWSER.toUpperCase().equals("IE")) {
			//code
		} else if (BROWSER.toUpperCase().equals("FIREFOX")) {
			//code
		}
		return driver;
	}
	
}
