package com.sparta.crh.pom_testing_challenge.stepdefs;

import com.sparta.crh.pom_testing_challenge.Config;
import com.sparta.crh.pom_testing_challenge.pages.IndividualProductPage;
import com.sparta.crh.pom_testing_challenge.pages.LoginPage;
import com.sparta.crh.pom_testing_challenge.pages.ProductsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import org.junit.jupiter.api.Assertions;

public class ProductsStepDefs extends StepDefsSuper{


    @Given("I have logged in and am on the products page")
    public void iHaveLoggedInAndAmOnTheProductsPage() {
        webDriver.get(Config.getLoginURL());
        loginPage = new LoginPage(webDriver);
        loginPage.enterDetails(Config.getStandardUser(), Config.getMasterPassword());
        productsPage = new ProductsPage(loginPage.clickLogin());

    }

    @When("I click the product with the {string}")
    public void iClickTheProductWithThe(String iD) {
        individualProductPage = new IndividualProductPage(productsPage.clickOnProduct(iD), iD);

    }

    @Then("I will be navigated to the individual {string} page")
    public void iWillBeNavigatedToTheIndividualPage(String productName) {
        Assertions.assertEquals(productName, individualProductPage.getProductName());
    }

    @When("I click the add to cart button for the product with id {string}")
    public void iClickTheAddToCartButtonForTheProductWithId(String productID) {
        productsPage.addProductToCart(productID);
    }

    @Then("The cart iterator will increase by one")
    public void theCartIteratorWillIncreaseByOne() {
        Assertions.assertEquals("1", productsPage.getCartNumber());
    }

    @When("I click add to cart on all the products")
    public void iClickAddToCartOnAllTheProducts() {
        productsPage.addAllProductsToCart();
    }


    @Then("The cart iterator will increase by six")
    public void theCartIteratorWillIncreaseBySix() {
        Assertions.assertEquals("6", productsPage.getCartNumber());
    }

}
