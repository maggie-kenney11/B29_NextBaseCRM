package com.nextBaseCRM.step_definitions;

import com.nextBaseCRM.pages.DrivePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class us06_drivePage_steps {

    DrivePage drivePage = new DrivePage();

    @When("user clicks the Drive button")
    public void user_clicks_the_drive_button() {
        drivePage.driveBtn.click();
    }

    @Then("user can see the following modules on the Drive page")
    public void user_can_see_the_following_modules_on_the_drive_page(List<String> modules) {

        List<String> actualModules = new ArrayList<>();

        for (WebElement eachMod: drivePage.allModules){
            actualModules.add(eachMod.getText());
        }
        Assert.assertEquals(modules, actualModules);
    }
}
