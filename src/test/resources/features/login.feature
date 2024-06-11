Feature: User Login

  Scenario: Successful login with valid credentials
    Given user is on the login page
    When user submits valid credentials
    Then user should be redirected to the tool list page

  Scenario: Unsuccessful login with invalid credentials
    Given user is on the login page
    When user submits invalid credentials
    Then user failed to login
    And user still on the login page