package com.test.incubyte.pages;

import com.test.incubyte.utils.WebDriverManagerUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateAccountPage {

    private final WebDriver driver;

    private final By firstNameField = By.id("firstname");
    private final By lastNameField = By.id("lastname");
    private final By emailField = By.id("email_address");
    private final By passwordField = By.id("password");
    private final By passwordConfirmationField = By.id("password-confirmation");
    private final By createAccountButton = By.cssSelector("button[title='Create an Account']");
    private final By confirmationMessage = By.cssSelector(".message-success");

    public CreateAccountPage() {
        this.driver = WebDriverManagerUtility.getDriver();
    }

    // Methods for interacting with elements
    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void confirmPassword(String password) {
        driver.findElement(passwordConfirmationField).sendKeys(password);
    }

    public void clickCreateAccount() {
        driver.findElement(createAccountButton).click();
    }

    public String getConfirmationMessage() {
        WebElement messageElement = driver.findElement(confirmationMessage);
        return messageElement.getText();
    }

}
