package com.sparta.crh.pom_testing_challenge.stepdefs;

import com.sparta.crh.pom_testing_challenge.Config;
import com.sparta.crh.pom_testing_challenge.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class CheckoutStepDefs extends StepDefsSuper{


    @And("I have added a product to my cart")
    public void iHaveAddedAProductToMyCart() {
        productsPage.addProductToCart("1");

    }

    @And("I have navigated to my cart")
    public void iHaveNavigatedToMyCart() {
        cartPage = new CartPage(productsPage.clickCartButton());
    }

    @When("I press checkout")
    public void iPressCheckout() {
        checkoutStepOnePage = new CheckoutStepOnePage(cartPage.clickCheckout());
    }

    @And("Enter my {string}, {string} and {string}")
    public void enterMyAnd(String firstName, String lastName, String zipCode) {
        checkoutStepOnePage.inputDetails(firstName,lastName,zipCode);
    }

    @And("press the continue button")
    public void pressTheContinueButton() {
        webDriver = checkoutStepOnePage.pressContinue();
        if (webDriver.getCurrentUrl().equals(Config.getCheckoutStepTwoURL())){
            checkoutStepTwoPage = new CheckoutStepTwoPage(webDriver);
        }

    }

    @And("press the finish button")
    public void pressTheFinishButton() {
        checkoutFinalStepPage = new CheckoutFinalStepPage(checkoutStepTwoPage.clickFinish());
    }

    @Then("I will be told my order has been dispatched")
    public void iWillBeToldMyOrderHasBeenDispatched() {
        Assertions.assertEquals("Your order has been dispatched, and will arrive just as fast as the pony can get there!", checkoutFinalStepPage.getDispatchNotification());
    }

    @Then("I will be told I need to enter a first name")
    public void iWillBeToldINeedToEnterAFirstName() {
        Assertions.assertEquals("Error: First Name is required", checkoutStepOnePage.getInputErrorMessage());

    }

    @Then("I will be told I need to enter a second name")
    public void iWillBeToldINeedToEnterASecondName() {
        Assertions.assertEquals("Error: Last Name is required", checkoutStepOnePage.getInputErrorMessage());
    }

    @Then("I will be told I need to enter a Zip code")
    public void iWillBeToldINeedToEnterAZipCode() {
        Assertions.assertEquals("Error: Postal Code is required", checkoutStepOnePage.getInputErrorMessage());
    }

    @And("Enter my first name {string}, last name {string} and postcode {string}")
    public void enterMyFirstNameLastNameAndPostcode(String firstName, String lastName, String zipCode) {
        checkoutStepOnePage.inputDetails(firstName,lastName,zipCode);
    }

    @Then("I will be presented with an error code stating {string}")
    public void iWillBePresentedWithAnErrorCodeStating(String errorCode) {
        Assertions.assertEquals(errorCode, checkoutStepOnePage.getInputErrorMessage());
    }
}
