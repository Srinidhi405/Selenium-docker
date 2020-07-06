package com.demoaut.newtours.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItineraryPage extends BasePageObject{

    private By fname= By.name("passFirst0");
    private By lname= By.name("passLast0");
    private By amexno=By.name("creditnumber");
    private By purchaseButton=By.name("buyFlights");
    public ItineraryPage(WebDriver driver) {
        super(driver);
    }

    public FlightConfirmationPage enterCardDetails(String f_name,String l_name,String cardno){
        System.out.println("Entering card details");
        sendKeys(fname,f_name);
        sendKeys(lname,l_name);
        sendKeys(amexno,cardno);
        click(purchaseButton);

        return new FlightConfirmationPage(driver);
    }
}
