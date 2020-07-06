package com.demoaut.newtours.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePageObject{

    protected String url="http://newtours.demoaut.com/";
    private By registerLinkLocator= By.linkText("REGISTER");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openUrl(){
        System.out.println("Opening the page");
        openurl(url);
        System.out.println("Page opened");
    }

    public RegistrationPage clickRegisterLink(){
        System.out.println("Clicking Registration Link");
        click(registerLinkLocator);
        System.out.println("Register Link Clicked");
        return new RegistrationPage(driver);
    }
}
