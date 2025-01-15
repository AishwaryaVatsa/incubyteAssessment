package com.test.incubyte.steps;

import com.test.incubyte.pages.CreateAccountPage;
import com.test.incubyte.pages.HomePage;
import com.test.incubyte.pages.SignInPage;
import com.test.incubyte.utils.ConfigUtility;
import com.test.incubyte.utils.RandomEmailUtility;
import com.test.incubyte.utils.WebDriverManagerUtility;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class CreateAccountSteps {
    WebDriver driver;
    CreateAccountPage accountPage = new CreateAccountPage();
    HomePage homePage = new HomePage();
    ConfigUtility config;
    String randomEmail;
    SignInPage signInPage;


    public CreateAccountSteps() {
        config = new ConfigUtility();  // Initialize the ConfigReader
    }

    // Create an Account Scenario -- Start
    @Given("I am on the Magento homepage")
    public void iAmOnTheMagentoHomepage() {
        driver = WebDriverManagerUtility.getDriver();
        String url = config.getProperty("url");  // Get the URL from properties file
        driver.get(url);
        Assert.assertTrue("Failed: Not on Magento homepage", driver.getCurrentUrl().contains("magento.softwaretestingboard.com"));
    }

    @When("I navigate to the {string} page")
    public void iNavigateToThePage(String pageName) {
        homePage.clickCreateAccountLink();
    }

    @When("I enter the following details:")
    public void iEnterTheFollowingDetails(io.cucumber.datatable.DataTable dataTable) {
        randomEmail = RandomEmailUtility.generateRandomEmail();  // Generate a random email
        var data = dataTable.asMaps(String.class, String.class).get(0);
        accountPage.enterFirstName(data.get("First Name"));
        accountPage.enterLastName(data.get("Last Name"));
        accountPage.enterEmail(randomEmail);
        accountPage.enterPassword(config.getProperty("password"));
    }

    @When("I confirm the password")
    public void iConfirmThePassword() {
        accountPage.confirmPassword(config.getProperty("password"));
    }

    @When("I click on the create account button")
    public void iClickOnTheButton() {
        accountPage.clickCreateAccount();
    }

    @Then("I should see a confirmation message {string}")
    public void iShouldSeeAConfirmationMessage(String message) {
        String actualMessage = accountPage.getConfirmationMessage();
        if (!actualMessage.contains(message)) {
            throw new AssertionError("Expected message: " + message + ", but got: " + actualMessage);
        }
    }
    // Create an Account Scenario -- End


    // Sign-in with the created account Scenario - Start
    @Given("I am on the Magento Sign In page")
    public void iAmOnTheMagentoSignInPage() {
        driver = WebDriverManagerUtility.getDriver();
        String url = config.getProperty("url");  // Get the URL from properties file
        driver.get(url + config.getProperty("signin")); // Navigate to sign-in page
        Assert.assertTrue("Failed: Sign In page not displayed", signInPage.isSigninPage());
        signInPage = new SignInPage();
    }

    @When("I enter a valid email and password")
    public void iEnterAValidEmailAndPassword() {
        signInPage.enterEmail(randomEmail);
        signInPage.enterPassword(config.getProperty(config.getProperty("password")));
    }

    @And("I click on the \"Sign In\" button")
    public void iClickOnTheSignInButton() {
        signInPage.clickSignInButton();
    }

    @Then("I should be redirected to my account dashboard")
    public void iShouldBeRedirectedToMyAccountDashboard() {
        String expectedUrl = config.getProperty("url") + config.getProperty("dashboard"); // Dashboard URL
        Assert.assertTrue("User was not redirected to the dashboard.",
                driver.getCurrentUrl().contains(expectedUrl));
        Assert.assertTrue("User not on Account Page", signInPage.isMyAccountPage());

    }

    // Sign-in with the created account Scenario - End

    @After
    public void tearDown() {
        WebDriverManagerUtility.quitDriver();
    }
}
