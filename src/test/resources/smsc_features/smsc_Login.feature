Feature: Login Functionality

  Background:
    Given I have logon SMSC Absa page

  Scenario: Verify Login with Valid Credentials
    When the user enters a valid username and password
    And clicks on the "LOGIN" button
    Then the user should be redirected to the dashboard

  Scenario: Ensure that all visual elements of the login page are correctly displayed
    Then all visual elements should be displayed as per the design specifications

  Scenario: Verify Login with Invalid Credentials
    When the user enters an invalid username and password
    And clicks on the "LOGIN" button
    Then the user should see an error message "Invalid Username or Password."

  Scenario: Verify Login with Empty Username and Password Fields
    When the user leaves both the "Username" and "Password" fields blank
    And clicks on the "LOGIN" button
    Then the user should see an error message "Invalid Username or Password."
