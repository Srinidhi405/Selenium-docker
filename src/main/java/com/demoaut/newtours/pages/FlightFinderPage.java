package com.demoaut.newtours.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightFinderPage extends BasePageObject{

    private By type1= By.xpath("//input[@value='roundtrip']");
    private By type2=By.xpath("//input[@value='oneway']");
    private By pass=By.name("passCount");
    private By fport=By.name("fromPort");
    private By fmonth=By.name("fromMonth");
    private By fdate=By.name("fromDay");
    private By tport=By.name("toPort");
    private By rmonth=By.name("toMonth");
    private By rday=By.name("toDay");
    private By economy=By.xpath("//input[@value='Coach']");
    private By business=By.xpath("//input[@value='Business']");
    private By first=By.xpath("//input[@value='First']");
    private By airways=By.name("airline");
    private By contButton=By.name("findFlights");


    public FlightFinderPage(WebDriver driver) {
        super(driver);
    }
    public void enterFlightDetails(String triptype,String passcount,String fromPort,Integer dmonth,Integer ddate,String toPort,Integer amonth,Integer adate){
        System.out.println("Enter Travel details");
        switch(triptype){
            case "Round Trip":
                click(type1);
                break;
            default:
                click(type2);
                break;
        }
        selectByVisibleText(pass,passcount);
        selectByVisibleText(fport,fromPort);
        selectByVisibleText(tport,toPort);
        selectByIndex(fmonth,dmonth);
        selectByIndex(fdate,ddate);
        selectByIndex(rmonth,amonth);
        selectByIndex(rday,adate);
    }

    public SelectFlightPage enterFlightpreference(String service,String airline){
        System.out.println("Entering Flight preferences");
        switch (service){
            case "Economy":
                click(economy);
                break;
            case "Business":
                click(business);
                break;
            default:
                click(first);
                break;
        }
        selectByVisibleText(airways,airline);

        click(contButton);

        return new SelectFlightPage(driver);
    }


}
