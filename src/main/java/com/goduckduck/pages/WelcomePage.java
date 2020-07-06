package com.goduckduck.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePageobject {

    private String url="http://duckduckgo.com/";
    private By searchBar= By.id("search_form_input_homepage");
    private By searchButton=By.id("search_button_homepage");

    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    public void OpenMainPage(){
        System.out.println("Opening main page");
        open(url);
        System.out.println("Main Page Opened");
    }

    public SearchResultsPage SearchData(String text){
        System.out.println("Entering the search text");
        sendText(searchBar,text);
        click(searchButton);
        return new SearchResultsPage(driver);
    }

}
