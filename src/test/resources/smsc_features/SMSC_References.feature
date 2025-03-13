Feature: References Functionality

  Background:
    Given I am on the SMSC Absa login page
    When the user enters a valid username in the "Username" field
    And the user enters a valid password in the "Password" field
    And the user clicks the "LOGIN" button
    Then the user should be successfully logged in

 # User creates a new reference
  Scenario: Verify the Create New Reference functionality
    Given User clicks on References on the side bar
    And User clicks on Create New Reference button
    And User enters Reference Name as "name" on New Reference page
    And User enters  Reference as "reference" on New Reference page
    And User selects Party Type as "partyType" on New Reference page
    And User enters Email Address as "emailAddress" on New Reference page
    And User enters Contact Number as "contactNumber" on New Reference page
    And User enters Description as "description" on New Reference page
    And User clicks on Create button
    Then User verifies the created Reference to validate reference is created

# To ensure that the Cancel button works as expected
  Scenario: Verify Cancel Button Functionality in Reference Creation
    Given User clicks on References on the side bar
    And User clicks on Create New Reference button
    And User enters Reference Name as "name" on New Reference page for Cancel button
    And User enters  Reference as "reference" on New Reference page
    And User selects Party Type as "partyType" on New Reference page
    And User enters Email Address as "emailAddress" on New Reference page
    And User enters Contact Number as "contactNumber" on New Reference page
    And User enters Description as "description" on New Reference page
    And User clicks on Cancel button
    Then User should be redirected to the References page and no changes should be saved

# To ensure that the mandatory fields are validated properly
  Scenario: Verify mandatory fields on New Reference page.
    Given User clicks on References on the side bar
    And User clicks on Create New Reference button
    And User clicks on Create button to validate mandatory fields of New Reference
    Then User should see an error message for all the reference mandatory fields

# To verify user able to update the details of an existing reference
  Scenario: Verify the Update Reference functionality
    Given User clicks on References on the side bar
    And User clicks on Edit button on References page
    And User updates the Description field as "updatedDescription"
    And User clicks on Update button
    Then User validates the updates of the updated reference

#   User validates the created references with valid and invalid filter criteria
  Scenario: Verify the References Filter functionality with valid and invalid criteria
    Given User clicks on References on the side bar
    And User enters valid filter criteria in the search box on references page
    Then User validates the valid search results on references page
    And User enters invalid filter criteria in the search box on references page
    Then  User validates the error message as "errorMessage" on references page
    And User clicks on Rows per page dropdown
    And User selects the desired number from Rows per page dropdown