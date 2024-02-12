package com.nextBaseCRM.utilities;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.bouncycastle.oer.its.ieee1609dot2.basetypes.Duration.seconds;

public class BrowserUtils {



    //WINDOW AND TITLE MANIPULATION/VERIFICATION UTILS
    public static void switchToWindowAndBack(String targetTitle){
        String origin = Driver.getDriver().getWindowHandle();

        for (String handle: Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(handle);
            if(Driver.getDriver().getTitle().equals(targetTitle)){
                return;
            }
        }
        Driver.getDriver().switchTo().window(origin);

    }
    public static void switchToWindow(String targetTitle){

        for (String handle: Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(handle);
            if(Driver.getDriver().getTitle().equals(targetTitle)){
                break;
            }
        }

    }

    public static void switchWindowAndVerify(String expectedInURL, String expectedInTitle) {
        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();

        for (String each : allWindowHandles) {
            Driver.getDriver().switchTo().window(each);
            System.out.println("Current URL: " + Driver.getDriver().getCurrentUrl());

            if (Driver.getDriver().getCurrentUrl().contains(expectedInURL)) {
                break;
            }
        }

        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));

    }
    //returns to original window if title is not found

    public static void verifyTitle(String expectedTitle){
        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);
    }

    public static void verifyTitleContains(String expectedInTitle){
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedInTitle));
    }

    public static void verifyURLContains(String expectedInURL){
        String actualURL = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualURL.contains(expectedInURL));

    }





    //CUSTOMIZED WAIT UTILS
    public static void waitForInvisibilityOfGivenElement(WebElement target, int timeWaiting){

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeWaiting);
        wait.until(ExpectedConditions.invisibilityOf(target));
    }

    public static void waitForVisibilty(WebElement element, int timeWaiting){

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeWaiting);
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public static void waitForVisibility(By locator, int timeWaiting){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeWaiting);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitForTitleContains(String title, int timeWaiting){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeWaiting);
        wait.until(ExpectedConditions.titleContains(title));
    }


    public static void waitFor(int i){

        try{
            Thread.sleep(seconds * 1000);
        }catch (InterruptedException e){
            e.printStackTrace();

        }
    }
    //performs momentary pause

    public static WebElement waitForClickability(WebElement element, int timeWaiting){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeWaiting);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForClickablility(By locator, int timeWaiting) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeWaiting);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void sleep(int second){
        second *= 1000;
        try{
            Thread.sleep(second);
        }catch (InterruptedException e){

        }
    }







    //MISC. ACTIONS AND TEXT RETRIEVAL UTILS
    public static List<String> dropdown_options_as_String(WebElement dropdownElement){

        Select select = new Select(dropdownElement);

        List<WebElement> actualSelect_as_WebElement = select.getOptions();

        List<String> actualSelect_as_String = new ArrayList<>();

        for (WebElement each: actualSelect_as_WebElement) {
            actualSelect_as_String.add(each.getText());
        }
        return actualSelect_as_String;

    }
    //accepts dropdown element and returns list of values of the drop down

    public static void clickRadioButton(List<WebElement> radioButtons, String attributeValue){

        for (WebElement each: radioButtons) {
            if(each.getAttribute("value").equalsIgnoreCase(attributeValue));
            each.click();
        }
    }


    public static void hover(WebElement element){
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }


    public static List<String> getElementsText(List<WebElement> list){
        List<String> elementTexts = new ArrayList<>();
        for (WebElement element: list) {
            elementTexts.add(element.getText());
        }
        return elementTexts;
    }


    public static List<String> getElementsText(By locator){
        List<WebElement> elements = Driver.getDriver().findElements(locator);
        List<String> elementTexts = new ArrayList<>();

        for (WebElement each:elements) {
            elementTexts.add(each.getText());

        }
        return elementTexts;
    }



}
