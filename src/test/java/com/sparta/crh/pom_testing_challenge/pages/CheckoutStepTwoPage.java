package com.sparta.crh.pom_testing_challenge.pages;

import com.sparta.crh.pom_testing_challenge.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepTwoPage extends BasePage{

    private final By finishButton = By.linkText("FINISH");
    private final By cancelButton = By.linkText("CANCEL");

    public CheckoutStepTwoPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected boolean isCorrectPage() {
        return webDriver.getCurrentUrl().equals(Config.getCheckoutStepTwoURL());
    }

    public WebDriver clickFinish(){
        webDriver.findElement(finishButton).click();
        return webDriver;
    }
}
