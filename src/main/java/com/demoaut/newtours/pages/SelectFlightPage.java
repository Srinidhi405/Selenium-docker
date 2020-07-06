package com.demoaut.newtours.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectFlightPage extends BasePageObject{

    private By continueButton= By.xpath("//input[@name='reserveFlights']");
    public SelectFlightPage(WebDriver driver) {
        super(driver);
    }

    public ItineraryPage clickContinueButton(){
        System.out.println("Clicking Continue Button");
        click(continueButton);
        return new ItineraryPage(driver);
    }
}
