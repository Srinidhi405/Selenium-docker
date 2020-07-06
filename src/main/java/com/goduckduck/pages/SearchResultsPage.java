package com.goduckduck.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage extends BasePageobject {

    private By videoResults= By.linkText("Videos");
    private By videos=By.className("tile--vid");
    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void clickVideoResultLink(){
        System.out.println("Clicking Videos Results section");
        click(videoResults);
    }

    public Integer noOfVideos(){
        System.out.println("Taking the video results count");
        WebDriverWait wait=new WebDriverWait(driver,5);
        wait.until (ExpectedConditions.numberOfElementsToBeMoreThan(videos,1));
        return findAll(videos).size();

    }


}
