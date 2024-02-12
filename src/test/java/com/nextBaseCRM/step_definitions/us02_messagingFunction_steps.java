package com.nextBaseCRM.step_definitions;

import com.nextBaseCRM.pages.MessagePage;
import com.nextBaseCRM.utilities.BrowserUtils;
import com.nextBaseCRM.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;

public class us02_messagingFunction_steps {

    MessagePage messagePage = new MessagePage();

    @When("user types message in Message field")
    public void user_types_message_in_message_field() {
        Driver.getDriver().switchTo().frame(messagePage.messageBoxIframe);
        messagePage.messageBoxInIframe.sendKeys("test");
        Driver.getDriver().switchTo().parentFrame();

    }
    @When("User selects recipient")
    public void user_selects_recipient() {
        messagePage.addMoreBtn.sendKeys("hr3");
        messagePage.recipient.click();
    }
    @Then("user sees message displayed under Activity Stream")
    public void user_sees_message_displayed_under_activity_stream() {
        Assert.assertTrue(messagePage.postedMessage.isDisplayed());
    }


    @Then("To: field is set to {string}")
    public void to_field_is_set_to(String expectedDefault) {
        String actualDefault = messagePage.defaultRecipient.getText();
        Assert.assertEquals(expectedDefault, actualDefault);
    }


    @When("user clicks Cancel")
    public void user_clicks_cancel() {
        messagePage.cancelMessageBtn.click();
    }
    @Then("user sees message has been cancelled")
    public void user_sees_message_has_been_cancelled() {
        Assert.assertFalse(messagePage.sendBtn.isDisplayed());
        Assert.assertFalse(messagePage.linkBtn.isDisplayed());
    }

    @Then("user should see error message {string}")
    public void user_should_see_error_message(String expectedError) {
        Actions actions = new Actions(Driver.getDriver());
        actions.doubleClick(messagePage.sendBtn2).perform();

        BrowserUtils.waitForClickability(messagePage.sendBtn, 10);


        String actualError = messagePage.errorMessage.getText();
        Assert.assertEquals(actualError, expectedError);
    }

    @When("user deletes default recipient")
    public void user_deletes_default_recipient() {
        messagePage.recipientDeleteBtn.click();
    }
}
