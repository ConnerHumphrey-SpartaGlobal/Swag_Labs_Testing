package com.sparta.crh.pom_testing_challenge.pages;

import org.openqa.selenium.WebDriver;

public class CheckoutStepTwoPage extends BasePage{

    public CheckoutStepTwoPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected boolean isCorrectPage() {
        return false;
    }
}
