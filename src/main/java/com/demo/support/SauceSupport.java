package com.demo.support;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.demo.base.DriverScript;
import com.demo.util.Util;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SauceSupport extends DriverScript {
    public static String SAUCE_USERNAME = null;
    public static String SAUCE_ACCESS_KEY = null;
    public static String SAUCE_REMOTE_URL = null;

    public static void setUp(String browser, String methodName) {
        try {
            SAUCE_USERNAME = Util.getProperty("SAUCE_USERNAME");
            SAUCE_ACCESS_KEY = Util.getProperty("SAUCE_ACCESS_KEY");
            SAUCE_REMOTE_URL = "https://ondemand.us-west-1.saucelabs.com:443/wd/hub";
        } catch (IOException e) {
            e.printStackTrace();
        }
        methodName = methodName + "_" + Util.getDateTime();

        MutableCapabilities sauceOpts = new MutableCapabilities();
        sauceOpts.setCapability("username", SAUCE_USERNAME);
        sauceOpts.setCapability("accessKey", SAUCE_ACCESS_KEY);
        sauceOpts.setCapability("seleniumVersion", "3.141.59");
        sauceOpts.setCapability("build", "Java-W3C-Example");
        sauceOpts.setCapability("name", methodName);

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("sauce:options", sauceOpts);
        cap.setCapability("browserVersion", "latest");
        cap.setCapability("platformName", "macOS 10.15");

        if (browser.toUpperCase().equals("CHROME")) {
            WebDriverManager.chromedriver().setup();
            cap.setCapability("browserName", "chrome");
        } else if (browser.toUpperCase().equals("FIREFOX")) {
            WebDriverManager.firefoxdriver().setup();
            cap.setCapability("browserName", "firefox");
        }
        try {
            driver = new RemoteWebDriver(new URL(SAUCE_REMOTE_URL), cap);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.get(baseUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}