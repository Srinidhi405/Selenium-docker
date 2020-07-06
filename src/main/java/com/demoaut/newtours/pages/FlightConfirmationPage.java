package com.demoaut.newtours.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FlightConfirmationPage extends BasePageObject {

    private By confirmedmessage= By.xpath("//font[contains(text(),'Confirmation #')]");
    private By totalCost=By.xpath("//font[contains(text(),'USD')]");
    public FlightConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public String getConfirmationID(){
        return find(confirmedmessage).getText();
    }
    public boolean ticketConfirmation(){
         return find(confirmedmessage).isDisplayed();
    }

    public String ticketCost(){

        List<WebElement> list = findAll(totalCost);
        return list.get(1).getText();
    }
}
