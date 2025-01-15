@executeFirst
Feature: Create an account on Magento

  Scenario: Successfully create a new account
    Given I am on the Magento homepage
    When I navigate to the "Create an Account" page
    And I enter the following details:
      | First Name        | Last Name
      | Aishwarya         | Vatsa
    And I confirm the password
    And I click on the create account button
    Then I should see a confirmation message "Thank you for registering with Main Website Store."

  Scenario: Successful Sign In with valid credentials
      Given I am on the Magento Sign In page
      When I enter a valid email and password
      And I click on the "Sign In" button
      Then I should be redirected to my account dashboard
