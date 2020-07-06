package com.goduckduck.searchtest;


import com.demoaut.newtours.basetest.TestUtilities;
import com.goduckduck.pages.SearchResultsPage;
import com.goduckduck.pages.WelcomePage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchTest extends TestUtilities {

    @Parameters({"SearchTest"})
    @Test
    public void searchingTest(String text){
        System.out.println("Starting Search data test");
        WelcomePage welcome=new WelcomePage(driver);

        welcome.OpenMainPage();
        SearchResultsPage searchresult = welcome.SearchData(text);

        searchresult.clickVideoResultLink();
        sleep(2000);
        int resultno=searchresult.noOfVideos();

        System.out.println("The number of video results for the search of "+text+" is "+resultno);

    }
}
