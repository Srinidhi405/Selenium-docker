package com.demoaut.newtours.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage extends BasePageObject{

    private By message= By.xpath("//b[contains(text(),'sri14')]");
    private By flightsLinkPage=By.linkText("Flights");

    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public String getResultMessage(){
        return getText(message);
    }

    public FlightFinderPage clickFlightsLink(){
        System.out.println("Clicking Flight booking page link");
        click(flightsLinkPage);
        return new FlightFinderPage(driver);
    }


}
