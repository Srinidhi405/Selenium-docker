package com.demoaut.newtours.basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserDriverFactory {
    protected String browser;

    public BrowserDriverFactory(String browser) {
        this.browser = browser.toLowerCase();
    }

    public DesiredCapabilities CreateDriver() {

        DesiredCapabilities dc;

        switch (browser) {
            case "chrome":
                dc=DesiredCapabilities.chrome();
                break;

            case "firefox":
                dc=DesiredCapabilities.firefox();
                break;

            default:
                dc=DesiredCapabilities.chrome();
                break;
        }

        return dc;

    }
}
