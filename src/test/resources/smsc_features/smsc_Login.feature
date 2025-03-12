Feature: Login Functionality

   Scenario: TC001 - Verify Login with Valid Credentials
    Given I am on the SMSC Absa login page
    #And the user has valid login credentials
    When the user enters a valid username in the "Username" field
    And the user enters a valid password in the "Password" field
    And the user clicks the "LOGIN" button
    Then the user should be successfully logged in
    And the user should be redirected to the dashboard
    When the user logs out
    Then the user should be redirected to the login page

  Scenario: TC003 - Verify Login with Invalid Credentials
    Given I am on the SMSC Absa login page
    And the user has invalid login credentials
    When the user enters an invalid username in the "Username" field
    And the user enters an invalid password in the "Password" field
    And the user clicks the "LOGIN" buttons
    Then the user should receive an error message "Invalid Username or Password"

  Scenario: TC004 - Verify Login with Empty Username and Password Fields
    Given I am on the SMSC Absa login page
    When the user leaves both the "Username" and "Password" fields blank
    And the user clicks the "LOGIN" button
    Then the user should receive an error message "Invalid Username or Password"

  Scenario: TC002 - Ensure visual elements are correctly displayed
    Given I am on the SMSC Absa login page
    And the login page is accessible
    And the design specifications are available
    When the user validates all visual elements against design specifications
    Then all visual elements should be accurately displayed according to specifications
   