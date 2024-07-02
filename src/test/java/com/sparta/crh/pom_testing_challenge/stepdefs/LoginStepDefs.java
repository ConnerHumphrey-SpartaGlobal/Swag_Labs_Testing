package com.sparta.crh.pom_testing_challenge.stepdefs;

import com.sparta.crh.pom_testing_challenge.Config;
import com.sparta.crh.pom_testing_challenge.pages.LoginPage;
import com.sparta.crh.pom_testing_challenge.pages.ProductsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.DataTable;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Map;

public class LoginStepDefs extends StepDefsSuper{

    @Given("I am on the login page")
    public void i_am_on_the_login_page(){
        webDriver.get(Config.getLoginURL());
        loginPage = new LoginPage(webDriver);

    }


    @And("I press the enter button")
    public void i_press_the_enter_button() {
        webDriver = loginPage.clickLogin();
        if(webDriver.getCurrentUrl().equals(Config.getProductsURL())){
            productsPage = new ProductsPage(webDriver);
        }

    }

    @Then("I will be navigated to the products page")
    public void i_will_be_navigated_to_the_products_page() {
        Assertions.assertEquals(Config.getProductsURL(), webDriver.getCurrentUrl());
    }


    @When("I enter my valid {string} and {string} into the fields")
    public void iEnterMyValidAndIntoTheFields(String username, String password) {
        loginPage.enterDetails(username,password);
    }

    @When("I enter the details of a locked account {string} {string}")
    public void iEnterTheDetailsOfALockedAccount(String username, String password) {
        loginPage.enterDetails(username,password);
    }

    @Then("I will be told my account is locked out with an {string}")
    public void iWillBeToldMyAccountIsLockedOutWithAn(String errorMessage) {
        Assertions.assertEquals(errorMessage, loginPage.getErrorMessage());
    }

    @When("I enter an invalid {string} and {string} into the fields")
    public void iEnterAnInvalidAndIntoTheFields(String username, String password) {
        loginPage.enterDetails(username,password);
    }

    @Then("I will not be logged in with and {string}")
    public void iWillNotBeLoggedInWithAnd(String errorMessage) {
        Assertions.assertEquals(errorMessage, loginPage.getErrorMessage());
    }

}
