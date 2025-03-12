Feature: Dashboard Functionality

  Background:
    Given I have logon SMSC Absa page

  Scenario: Verify visual elements of the Dashboard, including labels, text accuracy, color schemes, sizes, and alignment
    Then all visual elements should be accurately displayed according to the design specifications

  Scenario: Verify that the time intervals on the chart are correctly represented
    When the user selects a different channel from the "simulator-mtn" dropdown
    Then Verify that the time intervals on the axis correctly labeled
    And the Pie chart should display statuses: sent, delivered, failed, errors, queued, started, and completed

  Scenario: Verify that the user can hover over the pie chart segments and view correct message information
    Then Status message should display as user hovers over each segment of pie chart

  Scenario: Verify that Data changes according to each Channels selected
    When the user selects a different channel from the "MTN Uganda Limited" dropdown
    And user gets the data from the page to compare with
    Then the user selects a different channel from the "simulator-mtn" dropdown
    Then Validate that the data from the previous channel does not match with the current channel