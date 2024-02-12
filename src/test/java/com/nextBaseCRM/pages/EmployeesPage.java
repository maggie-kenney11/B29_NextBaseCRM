package com.nextBaseCRM.pages;

import com.nextBaseCRM.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EmployeesPage extends BasePage{


    @FindBy(xpath = "//a[@title='Employees']")
    public WebElement employeesBtn;


    @FindBy(xpath = "//div[@data-top-menu-id='top_menu_id_company']")
    public List<WebElement> modules;

    @FindBy(xpath = "//span[@id='pagetitle']")
    public WebElement pageTitle;

    @FindBy(xpath = "//span[.='More'][1]")
    public WebElement moreBtn;
}
