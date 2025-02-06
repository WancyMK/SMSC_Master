Feature: Dashboard Functionality Testing

  Scenario: Verify that the Bar and Pie charts are displayed correctly on the dashboard
    Given I open the browser
    And the user is logged in the 'ABSA Management Application'
    When the user navigates to the dashboard
    Then the Bar and Pie charts should be visible with proper formatting
    And the charts should display time intervals on the X-axis
    And the Pie chart should show statuses for sent, delivered, failed, errors, queued, started, and completed

  Scenario: Verify visual elements of the Dashboard
    Given I open the browser
    And the user is logged in the 'ABSA Management Application'
    And the design specifications are available
    When the user navigates to the dashboard
    Then all visual elements should be correctly displayed including labels, text, colors, sizes, and alignment

  Scenario: Verify that the Bar and Pie charts represent the correct data for each status
    Given I open the browser
    And the user is logged in the 'ABSA Management Application'
    And data is available for the selected channel
    When the user navigates to the dashboard
    Then the Bar and Pie charts should represent accurate data for sent, queued, failed, completed, and errors

  Scenario: Verify that the time intervals on the chart are correctly represented
    Given I open the browser
    And the user is logged in the 'ABSA Management Application'
    And the Bar chart is displayed with data
    When the user navigates to the dashboard
    Then the time intervals on the X-axis should be correctly spaced and labeled
    And the status bars should align correctly with the time intervals

  Scenario: Verify that the charts adjust correctly on different screen sizes
    Given I open the browser
    And the user is logged in the 'ABSA Management Application'
    And the charts are displayed with data
    When the user resizes the screen
    Then the charts should adjust without data loss or distortion

  Scenario: Verify that the charts handle scenarios where there is no data to display
    Given I open the browser
    And the user is logged in the 'ABSA Management Application'
    And the selected channel has no data
    When the user navigates to the dashboard
    Then an empty Bar and Pie chart should be displayed

  Scenario: Verify tooltips display accurate information when hovering over the status bars
    Given I open the browser
    And the user is logged in the 'ABSA Management Application'
    And the Bar chart is displayed with data
    When the user hovers over each status bar
    Then the tooltip should display accurate information matching the data represented by the chart

  Scenario: Verify that clicking the Hamburger menu collapses the sidebar
    Given I open the browser
    And the user is logged in the 'ABSA Management Application'
    And the Hamburger menu is available
    When the user clicks on the Hamburger menu
    Then the sidebar should collapse, hiding text labels but keeping icons visible

  Scenario: Verify that the user can select a channel from the "Select Channel" dropdown
    Given I open the browser
    And the user is logged in the 'ABSA Management Application'
    And test data is available
    When the user selects a channel from the "Select Channel" dropdown
    Then the Transactions and Messages count should update accordingly

  Scenario: Validate the correct number of Total Messages is displayed
    Given I open the browser
    And the user is logged in the 'ABSA Management Application'
    And Total Messages exist for the selected channel
    When the user checks the "Total Messages" count
    Then the count should match the sum of messages in all statuses shown on the Pie chart

  Scenario: Verify that the user can hover over the Pie chart segments
    Given I open the browser
    And the user is logged in the 'ABSA Management Application'
    And messages exist in different statuses
    When the user hovers over a segment of the Pie chart
    Then the tooltip should display the status and corresponding message count

  Scenario: Verify that changing channels updates the displayed data correctly
    Given I open the browser
    And the user is logged in the 'ABSA Management Application'
    And multiple channels with data exist
    When the user selects a different channel
    Then the Bar and Pie charts, Total Transactions, and Total Messages count should update accordingly

  Scenario: Verify that status segments in the Pie chart are not clickable
    Given I open the browser
    And the user is logged in the 'ABSA Management Application'
    And messages exist in different statuses
    When the user clicks on a status segment in the Pie chart
    Then the status segment should not be clickable
