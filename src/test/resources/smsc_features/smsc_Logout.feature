Feature: Logout Functionality

  Scenario: TC005 - Verify that clicking the 'Logout' navigates the user to the Login page
    Given I open the browser
    And the user is logged in to the ABSA Management Application
    When the user clicks on the "Logout" button on the sidebar
    Then the user should be navigated to the Login page

  Scenario: TC006 - Verify that the User is automatically logged out of the application when the screen is inactive for 15 minutes
    Given I open the browser
    And the user is logged in to the ABSA Management Application
    When the screen is inactive for 15 minutes
    Then the user should be automatically logged out
    And the user should be navigated to the Login page
