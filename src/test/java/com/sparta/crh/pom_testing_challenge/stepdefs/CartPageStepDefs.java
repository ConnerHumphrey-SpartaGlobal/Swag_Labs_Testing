package com.sparta.crh.pom_testing_challenge.stepdefs;

import com.sparta.crh.pom_testing_challenge.pages.CartPage;
import com.sparta.crh.pom_testing_challenge.pages.LoginPage;
import com.sparta.crh.pom_testing_challenge.pages.ProductsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class CartPageStepDefs extends StepDefsSuper{


    @And("I click the cart button")
    public void iClickTheCartButton() {
        productsPage = new ProductsPage(webDriver);
        cartPage = new CartPage(productsPage.clickCartButton());
    }


    @Then("The item with the link id {string} and name {string} will be displayed in the cart")
    public void theItemWithTheLinkIdAndNameWillBeDisplayedInTheCart(String linkID, String name) {
        Assertions.assertEquals(name,cartPage.isItemThere(linkID));
    }
}
