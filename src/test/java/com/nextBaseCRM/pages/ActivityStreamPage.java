package com.nextBaseCRM.pages;

import com.nextBaseCRM.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ActivityStreamPage extends BasePage{


    @FindBy (xpath = "//div[@class='feed-add-post-form-variants']/span")
    public List<WebElement> topOptions;

    @FindBy(xpath = "//span[@id='feed-add-post-form-link-text']")
    public WebElement moreBtn;

    @FindBy (xpath = "//span[@class='menu-popup-item-text']")
    public List<WebElement> moreOptions;

}
