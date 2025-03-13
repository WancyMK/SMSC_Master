Feature: Channels functionality

  Background:
    Given I am on the SMSC Absa login page
    When the user enters a valid username in the "Username" field
    And the user enters a valid password in the "Password" field
    And the user clicks the "LOGIN" button
    Then the user should be successfully logged in

# User creates a new channel
  Scenario: Verify the Create New Channel functionality
    Given User clicks on Channels on the side bar
    And User clicks on Create New Channel button
    And User enters Channel Name as "Name" on New Channel page
    And User enters Host as "Host" on New Channel page
    And User enters Port as "Port" on New Channel page
    And User enters System ID as "System ID" on New Channel page
    And User enters Password as "Password" on New Channel page
    And User enters Service Type as "Service Type" on New Channel page
    And User enters Priority as "Priority" on New Channel page
    And User enters Source Address as "Source Address" on New Channel page
    And User selects Status as "Status" on New Channel page
    And User enters Provider as "Provider" on New Channel page
    And User selects Multi For Bulk as "Multi For Bulk" on New Channel page
    And User enters Filters as "Filters" on New Channel page
    And User clicks on Create button
    Then User verifies the created Channel to validate channel is created

# To ensure that the Cancel button works as expected
  Scenario: Verify Cancel Button Functionality in Channel Creation
    Given User clicks on Channels on the side bar
    And User clicks on Create New Channel button
    And User enters Channel Name as "Name" on New Channel page for Cancel button
    And User enters Host as "Host" on New Channel page
    And User enters Port as "Port" on New Channel page
    And User enters System ID as "System ID" on New Channel page
    And User enters Password as "Password" on New Channel page
    And User enters Service Type as "Service Type" on New Channel page
    And User enters Priority as "Priority" on New Channel page
    And User enters Source Address as "Source Address" on New Channel page
    And User selects Status as "Status" on New Channel page
    And User enters Provider as "Provider" on New Channel page
    And User selects Multi For Bulk as "Multi For Bulk" on New Channel page
    And User enters Filters as "Filters" on New Channel page
    And User clicks on Cancel button
    Then User should be redirected to the Channels page and no changes should be saved

# To ensure that the mandatory fields are validated properly
  Scenario: Verify mandatory fields on New Channel page.
    Given User clicks on Channels on the side bar
    And User clicks on Create New Channel button
    And User clicks on Create button to validate mandatory fields of New Channel
    Then User should see an error message for all the channel mandatory fields

# To verify user able to update the details of an existing channel
  Scenario: Verify the Update Channel functionality
    Given User clicks on Channels on the side bar
    And User clicks on Edit button on Channels page
    And User updates the Provider field as "Updated Provider"
    And User clicks on Update button
    Then User validates the updates of the updated channel
    And User selects the status as "Inactive"
    Then User clicks on Update button and validates whether the channel is updated as Inactive

#   User validates the created channels with valid and invalid filter criteria
  Scenario: Verify the Channels Filter functionality with valid and invalid criteria
    Given User clicks on Channels on the side bar
    And User enters valid filter criteria in the search box on channels page
    Then User validates the valid search results on channels page
    And User enters invalid filter criteria in the search box on channels page
    Then  User validates the error message as "errorMessage" on Channels page
    And User clicks on Rows per page dropdown
    And User selects the desired number from Rows per page dropdown