package com.demoaut.newtours.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePageObject{


    private By f_name= By.name("firstName");
    private By u_name=By.name("email");
    private By p_word=By.name("password");
    private By cp_word=By.name("confirmPassword");
    private By submitkey=By.name("register");
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public ConfirmationPage enterRegistrationDetails(String fname,String uname,String pword,String cpword){
        System.out.println("Entering User details with Firstname "+fname+" Username "+uname+" Password "+pword);
        sendKeys(f_name,fname);
        sendKeys(u_name,uname);
        sendKeys(p_word,pword);
        sendKeys(cp_word,cpword);
        click(submitkey);
        return new ConfirmationPage(driver);

    }
}
