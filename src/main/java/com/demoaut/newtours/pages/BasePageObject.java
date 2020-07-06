package com.demoaut.newtours.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject {

    WebDriver driver;

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
    }

    protected void openurl(String url){
        driver.get(url);
    }

    protected WebElement find(By locator){
        return driver.findElement(locator);
    }

    protected void sendKeys(By locator,String text){
        WebDriverWait wait=new WebDriverWait(driver,5);
        wait.until (ExpectedConditions.visibilityOf(find(locator)));
        find(locator).sendKeys(text);
    }

    protected String getText(By locator){
        return find(locator).getText();
    }

    protected void click(By locator){
        WebDriverWait wait=new WebDriverWait(driver,5);
        wait.until (ExpectedConditions.visibilityOf(find(locator)));
        find(locator).click();
    }

    public void selectByIndex(By locator,Integer i){
        Select select=new Select(find(locator));
        select.selectByIndex(i-1);
    }

    public void selectByVisibleText(By locator,String i) {
        Select select = new Select(find(locator));
        select.selectByVisibleText(i);
    }

    public List<WebElement> findAll(By locator){
        return driver.findElements(locator);
    }
}
