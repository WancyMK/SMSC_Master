Feature: Login Functionality

  Scenario: Verify Login with Valid Credentials
  Scenario: Verify Successful Login with Valid Credentials
    Given I open the browser
    And the user has valid login credentials
    When the user opens the application
    And the user enters a valid username in the "Username" field and a valid password in the "Password" field
    And the user clicks on the "LOGIN" button
    Then the user should be successfully logged in and redirected to the dashboard

  Scenario: Ensure that all visual elements of the login page are correctly displayed according to the design specifications
    Given I open the browser
    And the login page is accessible
    And access to the design specifications
    When the user opens the application
    Then all visual elements of the login page should be accurately displayed according to the design specifications, with correct branding, labels, text, colors, sizes, and alignment

  Scenario: Verify Login with Invalid Credentials
    Given I open the browser
    And the user has invalid login credentials
    When the user opens the application
    And the user enters an invalid username in the "Username" field and an invalid password in the "Password" field
    And the user clicks on the "LOGIN" button
    Then the user should receive an error message like "Invalid Username or Password."

  Scenario: Verify Login with Empty Username and Password Fields
    Given I open the browser
    And the user opens the application
    When the user leaves both the "Username" and "Password" fields blank
    And the user clicks on the "LOGIN" button
    Then the user should receive an error message like "Invalid Username or Password."
