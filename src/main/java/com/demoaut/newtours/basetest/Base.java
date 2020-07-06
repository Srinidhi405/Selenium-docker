package com.demoaut.newtours.basetest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

public class Base {

    protected DesiredCapabilities dc;
    protected WebDriver driver;

    @BeforeMethod(alwaysRun=true)
    public void setUp(ITestContext ctx) throws MalformedURLException {
        //get BROWSER value
        //get the HUB_HOST

        //set default host as localhost
        String host="localhost";
        //set default browser as chrome

        //get test name
        String testName=ctx.getCurrentXmlTest().getName();

        BrowserDriverFactory browserdriverfactory = new BrowserDriverFactory("chrome");;
        if((System.getProperty("BROWSER") != null) && (System.getProperty("BROWSER").equalsIgnoreCase("firefox"))){
            browserdriverfactory= new BrowserDriverFactory("firefox");
        }

        if(System.getProperty("HUB_HOST") != null){
            host=System.getProperty("HUB_HOST");
        }

        System.out.println("Creating driver");

        dc=browserdriverfactory.CreateDriver();

        String completeUrl="http://"+host+":4444/wd/hub";
        dc.setCapability("name",testName);
        driver= new RemoteWebDriver(new URL(completeUrl),dc);

    }

    @AfterMethod(alwaysRun=true)
    public void tearDown(){
        System.out.println("Closing driver");
        driver.quit();

    }
}
