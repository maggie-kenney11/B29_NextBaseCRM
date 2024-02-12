package com.nextBaseCRM.pages;

import com.nextBaseCRM.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DrivePage extends BasePage{


    @FindBy(xpath = "//a[@title='Drive']")
    public WebElement driveBtn;

    @FindBy(xpath = "//div[@data-top-menu-id='top_menu_id_docs']")
    public List<WebElement> allModules;



}
