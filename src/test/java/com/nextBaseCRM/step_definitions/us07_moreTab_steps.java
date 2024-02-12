package com.nextBaseCRM.step_definitions;

import com.nextBaseCRM.pages.ActivityStreamPage;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class us07_moreTab_steps {
    ActivityStreamPage activityStreamPage = new ActivityStreamPage();

    @Then("user can view the following options on Activity stream page")
    public void user_can_view_the_following_options_on_activity_stream_page(List<String> expectedButtons) {
        List<String> actualButtons = new ArrayList<>();
        for(WebElement eachButton: activityStreamPage.topOptions){
            actualButtons.add(eachButton.getText());
        }
        Assert.assertEquals(actualButtons, expectedButtons);

    }

    @When("user clicks the MORE tab")
    public void user_clicks_the_more_tab() {
        activityStreamPage.moreBtn.click();
    }
    @Then("user can view the following options under the MORE tab:")
    public void user_can_view_the_following_options_under_the_more_tab(List<String> expectedOptions) {
        List<String> actualOptions = new ArrayList<>();
        for(WebElement eachOption: activityStreamPage.moreOptions){
            actualOptions.add(eachOption.getText());
        }
        Assert.assertEquals(expectedOptions, actualOptions);
    }
}
