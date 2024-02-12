package com.nextBaseCRM.pages;

import com.nextBaseCRM.utilities.Driver;
import io.cucumber.java.zh_cn.假如;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MessagePage extends  BasePage{


        @FindBy(xpath = "//span[@id='feed-add-post-form-tab-message']")
        public WebElement messageBtn;

        @FindBy(xpath ="//span[@id='bx-b-uploadfile-blogPostForm']")
        public WebElement uploadFileBtn;

        @FindBy(xpath = "//input[@name='bxu_files[]']")
        public WebElement UploadFileAndImageBtn;

        @FindBy(xpath = "//span[@class='insert-btn']")
        public WebElement insertInTextBtn;

        @FindBy(xpath = "//td[@class='files-info']")
        public WebElement inTextMessage;

        @FindBy(xpath = "//span[@class='del-but']")
        public WebElement deleteUploadBtn;


        @FindBy(xpath = "//span[@title='Link']")
        public WebElement linkBtn;

        @FindBy(xpath = "//input[@placeholder='Link text']")
        public WebElement textInput;

        @FindBy(xpath = "//input[@placeholder='Link URL']")
        public WebElement linkInput;

        @FindBy(xpath = "//input[@value='Save']")
        public WebElement saveBtn;

        @FindBy(xpath = "//div[@class='feed-com-files'][1]")
        public WebElement uploadedImages;

        @FindBy(xpath = "//div[@class='feed-com-files'][2]")
        public WebElement uploadedFiles;

        @FindBy(xpath = "//button[@class='ui-btn ui-btn-lg ui-btn-primary'][1]")
        public WebElement sendBtn;

        @FindBy (xpath ="//button[@id='blog-submit-button-save']")
        public WebElement sendBtn2;

        @FindBy(xpath = "//a[@href='https://www.google.com'][1]")
        public WebElement googleLink;


        @FindBy(xpath = "//div[@class='bx-finder-box-item-t7-name'][1]")
        public WebElement recipient;

        @FindBy (xpath = "//body[@contenteditable='true']")
        public WebElement messageBoxInIframe;

        @FindBy (xpath = "//iframe[@class='bx-editor-iframe']")
        public WebElement messageBoxIframe;

        @FindBy(xpath = "//a[@id='bx-destination-tag']")
        public WebElement addMoreBtn;

        @FindBy(xpath = "//span[@class=\"feed-add-post-destination-text\"]")
        public WebElement defaultRecipient;

        @FindBy(xpath = "//span[@class='feed-add-post-del-but']")
        public WebElement recipientDeleteBtn;

        @FindBy(xpath = "//div[@id='blg-post-img-2212'][1]")
        public WebElement postedMessage;

        @FindBy(xpath = "//button[@id=\"blog-submit-button-cancel\"]")
        public WebElement cancelMessageBtn;

        @FindBy(xpath = "//span[@class='feed-add-info-text']")
        public WebElement errorMessage;


}
