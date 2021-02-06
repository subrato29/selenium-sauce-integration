package com.demo.actions;

import org.openqa.selenium.By;

import com.demo.base.DriverScript;

public class TestEngine extends DriverScript{
	
	static int MAXTIMEOUT = 100;
	/*
	 * 
	 */
	public static boolean isElementPresent(String locator) {
		boolean isElementPresent = false;
		int nStartTime = 1;
		while (nStartTime <= MAXTIMEOUT) {
			try {
				if (driver.findElements(By.xpath(locator)).size()>0) {
					nStartTime = 500;
					isElementPresent = true;
				} else {
					nStartTime = nStartTime + 1;
				}
			} catch (Throwable t) {
				nStartTime = nStartTime + 1;
			}
		}
		return isElementPresent;
	}
	
	public static boolean isElementPresent(String locator, int nEndTime) {
		boolean isElementPresent = false;
		int nStartTime = 1;
		while (nStartTime <= nEndTime) {
			try {
				if (driver.findElements(By.xpath(locator)).size()>0) {
					nEndTime = nEndTime + 1;
					isElementPresent = true;
				} else {
					nStartTime = nStartTime + 1;
				}
			} catch (Throwable t) {
				nStartTime = nStartTime + 1;
			}
		}
		return isElementPresent;
	}
	
	public static void pause(double x) {
		try {
			Thread.sleep ((long) + (x * 500L));
		} catch (Throwable t) {
			
		}
	}
	
	public static void maximize() {
		driver.manage().window().maximize();
	}
	
	public static void deleteCookies() {
		driver.manage().deleteAllCookies();
	}
	
	public static void quit () {
		try {
			driver.quit();
		} catch (Exception e) {
			
		}
	}
	
}
