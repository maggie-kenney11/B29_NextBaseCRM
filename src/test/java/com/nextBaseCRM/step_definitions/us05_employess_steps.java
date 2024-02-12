package com.nextBaseCRM.step_definitions;

import com.nextBaseCRM.pages.EmployeesPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class us05_employess_steps {

    EmployeesPage employeesPage = new EmployeesPage();

    @When("user clicks on Employee module")
    public void user_clicks_on_employee_module() {
        employeesPage.employeesBtn.click();
    }

    @Then("user is able to see expected modules on the Employee page")
    public void user_is_able_to_see_expected_modules_on_the_employee_page(List<String> modules) {

        employeesPage.moreBtn.click();

        List<String> actualModules = new ArrayList<>();

        for(WebElement eachModule: employeesPage.modules){
            actualModules.add(eachModule.getText());
        }
        Assert.assertEquals(modules, actualModules);
    }


    @Then("user is able to see Company Structure by default")
    public void user_is_able_to_see_company_structure_by_default() {
        String expected = "Company Structure";
        String actual = employeesPage.pageTitle.getText();
        Assert.assertEquals(actual, expected);
    }



}
