package com.nextBaseCRM.step_definitions;

import com.nextBaseCRM.pages.MessagePage;
import com.nextBaseCRM.utilities.BrowserUtils;
import com.nextBaseCRM.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.time.Duration;

public class us04_addLink_steps {

    MessagePage messagePage = new MessagePage();
    @When("user clicks the Link icon")
    public void user_clicks_the_link_icon() {
        messagePage.linkBtn.click();
    }


    @When("user enters {string} in the Link text field")
    public void user_enters_in_the_link_text_field(String str) {
        messagePage.textInput.sendKeys(str);

    }
    @When("user enters {string} in the Link URL field")
    public void user_enters_in_the_link_url_field(String url) {
        messagePage.linkInput.sendKeys(url);

    }

    @When("user clicks Save button")
    public void user_clicks_save_button() {
        messagePage.saveBtn.click();
    }

    @When("user clicks SEND button")
    public void user_clicks_send_button() {
        messagePage.sendBtn.click();
        BrowserUtils.waitForVisibilty(messagePage.googleLink, 5);
    }

    @Then("user is able to see the message with the Link text in Activity Stream")
    public void user_is_able_to_see_the_message_with_the_link_text_in_activity_stream() {
        String expected = "google";
        String actual = messagePage.googleLink.getText();
        Assert.assertEquals(actual, expected);
    }


    @When("user clicks on the attached link")
    public void user_clicks_on_the_attached_link() {
        messagePage.googleLink.click();
    }



    @Then("user navigate to the correct URL")
    public void user_navigate_to_the_correct_url() {
        BrowserUtils.switchToWindow("google");

        String expected = "https://www.google.com/";
        String actual = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actual, expected);
    }

    @Then("the correct URL is opening in a new tab")
    public void the_correct_url_is_opening_in_a_new_tab() {

        BrowserUtils.switchWindowAndVerify("google", "Google");
    }
}