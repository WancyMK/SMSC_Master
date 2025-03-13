Feature: Dispatch functionality

  Background:
    Given I am on the SMSC Absa login page
    When the user enters a valid username in the "Username" field
    And the user enters a valid password in the "Password" field
    And the user clicks the "LOGIN" button
    Then the user should be successfully logged in

# Dispatch Message
#  To verify user able to Dispatch Message with valid data (Mobile number)
  Scenario: Verify that the user can Dispatch a Message with valid Mobile Number
    Given User clicks on "Dispatch" on the sidebar
    And User enters the valid Recipient number as "recipientNumber" under the Dispatch Message
    And User enters the Message as "message" under the Dispatch Message
    And User clicks on Send Messages button
    Then User verifies the sent message details and status as Completed under the Dispatch Message
    And User validates the message details on Messages page of Dispatch Message

#  To verify user able to Dispatch Message with invalid data (Mobile number)
  Scenario: Verify that the user can Dispatch a Message with invalid Mobile Number
    Given User clicks on "Dispatch" on the sidebar
    And User enters the invalid Recipient number as "recipientNumber" under the Dispatch Message
    And User enters the Message as "message" under the Dispatch Message
    And User clicks on Send Messages button
    Then User verifies the sent message details and status as Error under the Dispatch Message

# To ensure the Dispatch Message characters count functionality and Clear button functionality
  Scenario: Verify that the user can validate Dispatch Message character count and Clear button functionality
    Given User clicks on "Dispatch" on the sidebar
    And User enters the Recipient number as "recipientNumber" under the Dispatch Message
    And User enters the Message as "message" under the Dispatch Message to character count
    Then User validates the characters count under the Dispatch Message
    And User clicks on Send Messages button
    Then User clicks on Clear button under the Dispatch Message
    And User validates message details are cleared under the Dispatch Message

#    Bulk Recipients
# To verify that the user can dispatch a message to multiple recipients with valid data (Mobile numbers)
  Scenario: Verify that the user can dispatch a message to multiple recipients with valid Mobile numbers
    Given User clicks on "Dispatch" on the sidebar
    And User clicks on Bulk Recipients
    And User enters the valid Recipient numbers as "recipientNumber" under the Bulk Recipients
    And User enters the Message as "message" under the Bulk Recipients
    And User clicks on Send Bulk Messages button
    Then User verifies the sent message details and status as Completed under the Bulk Recipients
    And User validates the message details on Messages page of Bulk Recipients

# To verify that the user can dispatch a message to multiple recipients with invalid data (Mobile numbers)
  Scenario: Verify that the user can dispatch a message to multiple recipients with invalid Mobile numbers
    Given User clicks on "Dispatch" on the sidebar
    And User clicks on Bulk Recipients
    And User enters the invalid Recipient numbers as "recipientNumber" under the Bulk Recipients
    And User enters the Message as "message" under the Bulk Recipients
    And User clicks on Send Bulk Messages button
    Then User verifies the sent message details and status as NoAction under the Bulk Recipients

# To ensure that the user can choose a valid bulk excel file and dispatch a message to the multiple recipients
  Scenario: Verify that the user can choose a valid bulk excel file and dispatch a message to the multiple recipients
    Given User clicks on "Dispatch" on the sidebar
    And User clicks on Bulk Recipients
    And User clicks on Choose File and selects the valid excel Bulk file
    And User enters the Message as "message" under the Bulk Recipients
    And User clicks on Send Bulk Messages button
    Then User verifies the sent bulk message details and status as Completed under the Bulk Recipients
    And User validates the bulk message details on Messages page of Bulk Recipients

# To ensure that the user can choose a valid bulk text file and dispatch a message to the multiple recipients
  Scenario: Verify that the user can choose a valid bulk text file and dispatch a message to the multiple recipients
    Given User clicks on "Dispatch" on the sidebar
    And User clicks on Bulk Recipients
    And User clicks on Choose File and selects the valid text Bulk file
    And User enters the Message as "message" under the Bulk Recipients
    And User clicks on Send Bulk Messages button
    Then User verifies the sent bulk message details and status as Completed under the Bulk Recipients
    And User validates the bulk message details on Messages page of Bulk Recipients

# To ensure that the user can choose a invalid bulk excel file and dispatch a message to the multiple recipients
  Scenario: Verify that the user can choose a invalid bulk excel file and dispatch a message to the multiple recipients
    Given User clicks on "Dispatch" on the sidebar
    And User clicks on Bulk Recipients
    And User clicks on Choose File and selects the invalid excel Bulk file
    And User enters the Message as "message" under the Bulk Recipients
    And User clicks on Send Bulk Messages button
    Then User verifies the sent bulk message details and status as NoAction under the Bulk Recipients

# To ensure that the user can choose a invalid bulk text file and dispatch a message to the multiple recipients
  Scenario: Verify that the user can choose a invalid bulk text file and dispatch a message to the multiple recipients
    Given User clicks on "Dispatch" on the sidebar
    And User clicks on Bulk Recipients
    And User clicks on Choose File and selects the invalid text Bulk file
    And User enters the Message as "message" under the Bulk Recipients
    And User clicks on Send Bulk Messages button
    Then User verifies the sent bulk message details and status as NoAction under the Bulk Recipients

# To ensure the Bulk Recipients characters count functionality and Clear button functionality
  Scenario: Verify that the user can validate Bulk Recipients character count and Clear button functionality
    Given User clicks on "Dispatch" on the sidebar
    And User clicks on Bulk Recipients
    And User enters the Recipient number as "recipientNumber" under the Bulk Recipients
    And User enters the Message as "message" under the Bulk Recipients to character count
    Then User validates the characters count under the Bulk Recipients
    And User clicks on Send Bulk Messages button
    Then User clicks on Clear button under the Bulk Recipients
    And User validates message details are cleared under the Bulk Recipients
    And User validates Clear button and Clear icon functionality before dispatch message under the Bulk Recipients

#    Batch Messages
# To verify that the user can dispatch batch messages to multiple recipients with valid data (Mobile numbers)
  Scenario: Verify that the user can dispatch batch messages to multiple recipients with valid Mobile numbers
    Given User clicks on "Dispatch" on the sidebar
    And User clicks on Batch Messages
    And User enters the valid Recipient numbers as "recipientNumber" and Message as "message" under the Batch Messages
    And User clicks on Send Batch Messages button
    Then User verifies the sent message details and status as Completed under the Batch Messages
    And User validates the message details on Messages page of Batch Messages

# To verify that the user can dispatch batch messages to multiple recipients with invalid data (Mobile numbers)
  Scenario: Verify that the user can dispatch batch messages to multiple recipients with invalid Mobile numbers
    Given User clicks on "Dispatch" on the sidebar
    And User clicks on Batch Messages
    And User enters the invalid Recipient numbers as "recipientNumber" and Message as "message" under the Batch Messages
    And User clicks on Send Batch Messages button
    Then User verifies the sent message details and status as NoAction under the Batch Messages

# To ensure that the user can choose a valid batch excel file and dispatch batch messages to the multiple recipients
  Scenario: Verify that the user can choose a valid batch excel file and dispatch batch messages to the multiple recipients
    Given User clicks on "Dispatch" on the sidebar
    And User clicks on Batch Messages
    And User clicks on Choose File and selects the valid excel Batch file
    And User clicks on Send Batch Messages button
    Then User verifies the sent batch message details and status as Completed under the Batch Messages
    And User validates the batch message details on Messages page of Batch Messages

# To ensure that the user can choose a valid batch text file and dispatch batch message to the multiple recipients
  Scenario: Verify that the user can choose a valid batch text file and dispatch batch message to the multiple recipients
    Given User clicks on "Dispatch" on the sidebar
    And User clicks on Batch Messages
    And User clicks on Choose File and selects the valid text Batch file
    And User clicks on Send Batch Messages button
    Then User verifies the sent batch message details and status as Completed under the Batch Messages
    And User validates the batch message details on Messages page of Batch Messages

# To ensure that the user can choose a invalid batch excel file and dispatch batch messages to the multiple recipients
  Scenario: Verify that the user can choose a invalid batch excel file and dispatch batch messages to the multiple recipients
    Given User clicks on "Dispatch" on the sidebar
    And User clicks on Batch Messages
    And User clicks on Choose File and selects the invalid excel Batch file
    And User clicks on Send Batch Messages button
    Then User verifies the sent batch message details and status as NoAction under the Batch Messages

# To ensure that the user can choose a invalid batch text file and dispatch batch messages to the multiple recipients
  Scenario: Verify that the user can choose a invalid batch text file and dispatch batch message to the multiple recipients
    Given User clicks on "Dispatch" on the sidebar
    And User clicks on Batch Messages
    And User clicks on Choose File and selects the invalid text Batch file
    And User clicks on Send Batch Messages button
    Then User verifies the sent batch message details and status as NoAction under the Batch Messages

# To ensure the Batch Messages characters count functionality and Clear button functionality
  Scenario: Verify that the user can validate Batch Messages character count and Clear button functionality
    Given User clicks on "Dispatch" on the sidebar
    And User clicks on Batch Messages
    And User enters the Recipient number as "recipientNumber" and Message as "message" under the Batch Messages to character count
    Then User validates the characters count under the Batch Messages
    And User clicks on Send Batch Messages button
    Then User clicks on Clear button under the Batch Messages
    And User validates message details are cleared under the Batch Messages
    And User validates Clear button and Clear icon functionality before dispatch message under the Batch Messages