package com.demo.actions;

import org.openqa.selenium.By;

import com.demo.base.DriverScript;

public class ActionEngine extends DriverScript{
	
	public static void sendKeys(String locator, String value) {
		try {
			if (TestEngine.isElementPresent(locator)) {
				driver.findElement(By.xpath(locator)).sendKeys(value);
			}
		} catch (Throwable t) {
			System.out.println("sendKeys is not working");
		}
	}
	
	public static void click(String locator) {
		try {
			if (TestEngine.isElementPresent(locator)) {
				driver.findElement(By.xpath(locator)).click();
			}
		} catch (Throwable t) {
			System.out.println("click is not working");
		}
	}
	
}
