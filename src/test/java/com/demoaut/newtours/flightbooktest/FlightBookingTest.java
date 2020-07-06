package com.demoaut.newtours.flightbooktest;

import com.demoaut.newtours.basetest.TestUtilities;
import com.demoaut.newtours.pages.*;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class FlightBookingTest extends TestUtilities {

    public String result;



    @Parameters({"noOfPassengers","expectedCost"})
    @Test
    public void flightbooking(String headCount,String expectedCost){


        System.out.println("Starting flight booking test");

        HomePage homepage=new HomePage(driver);
        homepage.openUrl();
        sleep(2000);
        RegistrationPage registerpage = homepage.clickRegisterLink();
        sleep(2000);
        ConfirmationPage confirmpage = registerpage.enterRegistrationDetails("srinidhi","sri14","qwerty","qwerty");
        result=confirmpage.getResultMessage();
        sleep(2000);
        Assert.assertTrue(result.equals("Note: Your user name is sri14."),"The result message does not contain the user specified user name");
        sleep(2000);
        FlightFinderPage flightfind=confirmpage.clickFlightsLink();
        sleep(2000);
        flightfind.enterFlightDetails("One way",headCount,"London",5,26,"Paris",5,30);
        sleep(2000);
        SelectFlightPage selectflight = flightfind.enterFlightpreference("Business","No Preference");
        sleep(2000);
        ItineraryPage itinerary = selectflight.clickContinueButton();
        sleep(2000);
        FlightConfirmationPage flightconfirm = itinerary.enterCardDetails("alex","martin","2456345678");
        sleep(2000);
        Boolean bool = flightconfirm.ticketConfirmation();
        String actualCost = flightconfirm.ticketCost();
        Assert.assertTrue(bool,"Flight booking is not successful");

        Assert.assertTrue(actualCost.equals(expectedCost),"The flight is not booked at expected price instead at "+actualCost);
        String flightID=flightconfirm.getConfirmationID();
        System.out.println("The Booking ID is"+flightID+". Have a Safe Journey!");

    }

}
