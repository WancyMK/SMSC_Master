#Feature: Test Dispatch
#
#		 Background:
    #Given I have logon SMSC Absa page
#
   #Verify navigation to Test Dispatch page
  #Scenario: Verify that clicking the  navigates the user to the Test Dispatch page
    #Given User clicks on 'Test Dispatch' on the sidebar
    #Then User should navigate to the Test Dispatch page
#
   #Verify UI elements on the Test Dispatch page
  #Scenario: Verify UI Elements for Test Dispatch
    #Given User clicks on 'Test Dispatch' on the sidebar
    #Then All headers, buttons, and text should be placed accurately with correct font sizes, colors, and spacing
    #And The interface should remain responsive with no overlaps, and buttons should display the correct colors in all states
#
   #Verify message dispatch functionality
  #Scenario: Verify that the user can Dispatch a Message
    #Given User clicks on 'Test Dispatch' on the sidebar
    #And User enters Recipient number and Message
    #When User clicks on Send Message button
    #Then The message should be sent successfully and displayed in Transactions and Messages
#
   #Verify email notification on failed transaction
  #Scenario: Verify that the user receives an email when the transaction fails
    #Given User clicks on 'Test Dispatch' on the sidebar
    #And User enters an invalid Recipient number and Message
    #When User clicks on Send Message button
    #Then The message should not be sent
    #And An email notification should be received
#
   #Verify dispatching a secure message
  #Scenario: Verify that the user can Dispatch a Secure Message
    #Given User clicks on 'Test Dispatch' on the sidebar
    #And User enters Recipient number and Message
    #And User enables the Secure Message checkbox
    #When User clicks on Send Message button
    #Then The message should be encrypted in the database
#
   #Verify Peeking a message in the queue
  #Scenario: Verify that the system allows peeking at a message in the queue
    #Given User clicks on 'Test Dispatch' on the sidebar
    #And User enters Recipient number and Message
    #When User clicks on Send Message button
    #And User clicks on Peek button
    #Then The message should be moved from the queue
#
   #Verify peeking behavior for an empty queue
  #Scenario: Verify the behavior of the system when peeking into an empty queue
    #Given User clicks on 'Test Dispatch' on the sidebar
    #When User clicks on Peek button
    #Then The system should return an error message or display no message data
#
   #Verify clearing messages from the Test Dispatch page
  #Scenario: Verify that the user can clear messages
    #Given User clicks on 'Test Dispatch' on the sidebar
    #When User clicks on Clear button
    #Then All message details should be cleared
#
   #Verify dispatching a message to multiple recipients
  #Scenario: Verify that the user can Dispatch a Message to multiple recipients
    #Given User clicks on 'Test Dispatch' on the sidebar
    #And User clicks on Bulk Recipients
    #And User adds multiple Recipient numbers and enters Message
    #When User clicks on Send Bulk Messages button
    #Then The message should be sent successfully to multiple recipients
#
   #Verify dispatching a message using a bulk file
  #Scenario: Verify that the user can choose a valid bulk file and dispatch a message to multiple recipients
    #Given User clicks on 'Test Dispatch' on the sidebar
    #And User clicks on Bulk Recipients
    #And User selects a valid bulk file
    #When User clicks on Send Bulk Messages button
    #Then The message should be sent successfully to Bulk Recipients
#
   #Verify invalid bulk file selection
  #Scenario: Verify that the user can choose an invalid file and cannot dispatch a message
    #Given User clicks on 'Test Dispatch' on the sidebar
    #And User clicks on Bulk Recipients
    #And User selects an invalid bulk file
    #When User clicks on Send Bulk Messages button
    #Then The system should prevent sending messages and display an error
#
   #Verify clearing bulk file selection
  #Scenario: Verify that the user can clear a selected bulk file
    #Given User clicks on 'Test Dispatch' on the sidebar
    #And User clicks on Bulk Recipients
    #And User selects a file
    #When User clicks on the Clear icon
    #Then The selected bulk file should be cleared
#
   #Verify character count functionality
  #Scenario: Verify the character count functionality under Message text box on Dispatch Message page
    #Given User clicks on 'Test Dispatch' on the sidebar
    #And User enters Recipient number and Message
    #Then The system should display the number of characters count correctly
#
  #Scenario: Verify the character count functionality under Message text box on Bulk Recipients page
    #Given User clicks on 'Test Dispatch' on the sidebar
    #And User clicks on Bulk Recipients
    #And User adds a recipient number and enters a message
    #Then The system should display the number of characters count correctly
#
  #Scenario: Verify the character count functionality under Message text box on Batch Messages page
    #Given User clicks on 'Test Dispatch' on the sidebar
    #And User clicks on Batch Messages
    #And User adds a recipient number and enters a message
    #Then The system should display the number of characters count correctly
