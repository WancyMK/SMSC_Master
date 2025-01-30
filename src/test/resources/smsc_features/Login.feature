Feature: Open Google

  Scenario: Open Google Home Page
    Given I open the browser
    When I navigate to "https://www.google.com"
    Then The page title should be "Google"