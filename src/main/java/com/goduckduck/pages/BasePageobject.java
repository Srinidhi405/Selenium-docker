package com.goduckduck.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePageobject {
    WebDriver driver;

    public BasePageobject(WebDriver driver) {
        this.driver = driver;
    }

    protected void open(String url){
        driver.get(url);
    }

    protected WebElement find(By locator){
        return driver.findElement(locator);
    }

    protected List<WebElement> findAll(By locator){
        return driver.findElements(locator);
    }

    protected void sendText(By locator, String text){
        WebDriverWait wait=new WebDriverWait(driver,5);
        wait.until (ExpectedConditions.visibilityOf(find(locator)));
        find(locator).sendKeys(text);
    }

    protected void click(By locator){
        WebDriverWait wait=new WebDriverWait(driver,5);
        wait.until (ExpectedConditions.visibilityOf(find(locator)));
        find(locator).click();
    }
}
