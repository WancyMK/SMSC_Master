#Feature: Dashboard Functionality
#
#
#  Background:
#    Given I have logon SMSC Absa page
#
#
#  Scenario: Verify that the Bar and Pie charts are displayed correctly on the dashboard
#
#    Given the Bar and Pie charts should be visible with proper formatting
#    And the Bar chart should show time intervals on the X-axis
#    And the Pie chart should display statuses: sent, delivered, failed, errors, queued, started, and completed
#
#  Scenario: Verify visual elements of the Dashboard, including labels, text accuracy, color schemes, sizes, and alignment
#    When the user checks the visual elements of the Dashboard
#    Then all visual elements should be accurately displayed according to the design specifications
#
#
#  Scenario: Verify that the Bar and Pie chart represent the correct data for each status
#    Given data is available for the selected channel
#    When the user compares the chart data against the actual data
#    Then the Bar and Pie charts should correctly represent the data for sent, queued, failed, completed, and errors
#
#
#  Scenario: Verify that the time intervals on the chart are correctly represented
#    Given the Bar chart is displayed with data
#    When the user checks the time intervals on the X-axis
#    Then the time intervals should be correctly spaced and labeled
#    And the status bars should align with the corresponding time intervals
#
#
#  Scenario: Verify that the charts adjust correctly on different screen sizes
#    Given the charts are displayed with data
#    When the user resizes the screen
#    Then the charts should resize and adjust correctly without data loss or distortion
#
#
#  Scenario: Verify that the charts handle scenarios where there is no data to display
#    Given the user selects a channel with no data
#    When the user checks the Bar and Pie charts
#    Then the empty Bar and Pie charts should be displayed
#
#
#  Scenario: Verify that the tooltips display accurate information when hovering over the status bars
#    Given the Bar chart is displayed with data
#    When the user hovers over each status bar
#    Then the tooltip should display accurate and detailed information
#
#
#  Scenario: Verify that the sidebar collapses when the user clicks on the Hamburger menu
#    Given the Hamburger menu button is available in the UI
#    When the user clicks on the Hamburger menu
#    Then the sidebar should collapse, showing only icons and hiding text labels
#    And the icons should remain visible and functional
#
#
#  Scenario: Verify that the user can select a channel from the "Select Channel" dropdown
#    Given test data is available
#    When the user selects a channel from the "Select Channel" dropdown
#    Then the Transactions and Messages should update according to the selected channel
#
#
#  Scenario: Validate that the correct number of Total Messages are displayed
#    Given Total Messages are present for the selected channel
#    When the user checks the "Total Messages" count
#    Then the Total Messages count should match the sum of messages in all statuses
#
#
#  Scenario: Verify that the user can hover over the pie chart segments and view correct message information
#    Given Total Messages are present in different statuses for the selected channel
#    When the user hovers over each segment of the pie chart
#    Then the tooltip should display the status and the corresponding messages count
#
#
#  Scenario: Verify that changing the channel updates the Total Transactions and Total Messages data and charts correctly
#    Given data for multiple channels is available
#    When the user selects a different channel from the "Select Channel" dropdown
#    Then the Bar and Pie charts and Total Transactions and Messages count should update accordingly
#
#
#  Scenario: Verify that the status segments in the pie chart are not clickable
#    Given Total Messages are present in different statuses for the selected channel
#    When the user tries to click on any status segment in the pie chart
#    Then the status segments should not be clickable