package com.test.incubyte.pages;

import com.test.incubyte.utils.WebDriverManagerUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
    private final WebDriver driver;

    // Locators
    private final By emailField = By.id("email");
    private final By passwordField = By.id("pass");
    private final By signInButton = By.id("send2");
    private final By welcomeMessage = By.cssSelector(".welcome-msg");
    private final By errorMessage = By.cssSelector(".message-error");
    private final By emailFieldErrorMessage = By.id("email-error");
    private final By passwordFieldErrorMessage = By.id("pass-error");
    private final By myAccountHeader = By.xpath("//h1//span[text()=\"My Account\"]");

    public SignInPage() {
        this.driver= WebDriverManagerUtility.getDriver();
    }

    // Methods
    public void enterEmail(String email) {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    public String getWelcomeMessage() {
        return driver.findElement(welcomeMessage).getText();
    }

    public boolean isMyAccountPage(){
        return driver.findElement(myAccountHeader).isDisplayed();
    }

    public boolean isSigninPage(){
        return driver.getCurrentUrl().contains("/account/login");
    }


    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public String getEmailFieldErrorMessage() {
        return driver.findElement(emailFieldErrorMessage).getText();
    }

    public String getPasswordFieldErrorMessage() {
        return driver.findElement(passwordFieldErrorMessage).getText();
    }
}
