Feature: Messages functionality

  Background:
    Given I have logon SMSC Absa page

#    User validates the Message with valid (All, Recipient, Transaction and Channel) and invalid filter criteria
  Scenario: Verify All Filter functionality with valid and invalid criteria
    Given User clicks on Messages on the sidebar
    And User enters valid filter criteria in the search box on messages page
    And User validates the valid search results on messages page
    And User enters invalid filter criteria in the search box on messages page
    Then  User validates the error message as "errorMessage" on messages page

  Scenario: Verify Recipient Filter functionality with valid and invalid criteria
    Given User clicks on Messages on the sidebar
    And User selects Recipient from the filters dropdown
    And User enters invalid filter criteria in the search box on messages page
    Then  User validates the error message as "errorMessage" on messages page
    And User enters Recipient as "recipientNumber" in the search box on messages page
    Then User validates the Recipient search results

  Scenario: Verify Transaction Filter functionality with valid and invalid criteria
    Given User clicks on Messages on the sidebar
    And User selects Transaction from the filters dropdown
    And User enters invalid filter criteria in the search box on messages page
    Then  User validates the error message as "errorMessage" on messages page
    And User enters Transaction ID as "transactionID" in the search box on messages page
    Then User validates the Transaction ID search results

  Scenario: Verify Channel Filter functionality with valid and invalid criteria
    Given User clicks on Messages on the sidebar
    And User selects Channel from the filters dropdown
    And User enters invalid filter criteria in the search box on messages page
    Then  User validates the error message as "errorMessage" on messages page
    And User enters Channel as "ChannelName" in the search box on messages page
    Then User validates the Channel search results

#   View Message details and pagination handling
    And User clicks on View button
    Then User validates Message details
    And User clicks on Rows per page dropdown
    And User selects the desired number from Rows per page dropdown