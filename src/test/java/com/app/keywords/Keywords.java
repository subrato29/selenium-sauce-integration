package com.app.keywords;

import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;

import com.demo.actions.ActionEngine;
import com.demo.actions.TestEngine;
import com.demo.base.DriverScript;

import pageobject.Home;

public class Keywords extends DriverScript{

	public static void findYourCity() {
		try {
			ActionEngine.sendKeys(Home.findYourCity, xls.getCellData("TestData","Address",rowNum));
			ActionEngine.click("//div[@role = 'listbox']//li[1]//span");
			if (TestEngine.isElementPresent("//h1[contains(text(),'got your easy ride')]")) {
				System.out.println("Validated");
			} else {
				System.out.println("NOT Validated");
			}
			Assert.assertEquals(TestEngine.isElementPresent("//h1[contains(text(),'got your easy ride')]"),true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void closeUnwantedPopup() {
		try {
			String parent = driver.getWindowHandle();
			Set<String> winIds = driver.getWindowHandles();
			System.out.println("Total windows -> "+ winIds.size());
			Iterator<String> itr = winIds.iterator();
			while (itr.hasNext()) {
				String child = itr.next();
				if (!parent.equals(child)) {
					driver.switchTo().window(child);
					driver.close();
				}
			}
			winIds = driver.getWindowHandles();
			System.out.println("Total windows -> "+ winIds.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
