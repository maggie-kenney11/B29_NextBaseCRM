package com.nextBaseCRM.pages;


import com.nextBaseCRM.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{


    @FindBy(xpath = "//input[@type='text']")
    public WebElement usernameBox;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement loginButton;



    public void login(String username, String password) {
        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        loginButton.click();
    }



}
