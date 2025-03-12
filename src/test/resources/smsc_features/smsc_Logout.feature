Feature: Logout Functionality
  As a user of the ABSA Management Application
  I want to be able to log out
  So that my session is securely ended

   Background:
    Given I have logon SMSC Absa page


  @TC005
  Scenario: Verify that clicking the 'Logout' navigates the user to the Login page
    When the user clicks on the 'Logout' button on the sidebar
    Then the user should be navigated to the Login page

  @TC006
  Scenario: Verify that the User is automatically logged out after 15 minutes of inactivity
    When the user does not perform any actions on the screen for 15 minutes
    Then the user should be automatically logged out