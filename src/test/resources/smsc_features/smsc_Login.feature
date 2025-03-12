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


  #Scenario: Verify Login with Valid Credentials
    #When the user enters a valid username and password
    #And clicks on the "LOGIN" button
    #Then the user should be redirected to the dashboard
#
  #Scenario: Ensure that all visual elements of the login page are correctly displayed
    #Then all visual elements should be displayed as per the design specifications
#
  Scenario: Verify Login with Invalid Credentials
    When the user enters an invalid username and password
    And click on the "LOGIN" button
    Then the user should see an error message "Invalid Username or Password."

  Scenario: Verify Login with Empty Username and Password Fields
    When the user leaves both the "Username" and "Password" fields blank
    And click on "LOGIN" button
    Then the user should see an error messages "Invalid Username or Password."

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
   

