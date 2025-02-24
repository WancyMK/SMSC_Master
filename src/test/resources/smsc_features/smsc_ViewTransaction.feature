Feature: View Transactions

  Background:
    Given I have logon SMSC Absa page
    And I Click on the View Transaction on the sidebar

  Scenario: Verify that clicking the 'View Transaction' navigates the user to the View Transaction page.
    And Verify that the required labels are listed on for each column

  Scenario: Verify that the user can navigate between different pages by tapping on navigation buttons.
    And I Click on the Next Page button and am directed to the next page
    And I Click on the Previous Page button and am directed to the previous page

  Scenario: Verify the functionality of the date filters (Start Date, End Date) with an invalid date range.
    And Enter invalid date on the From textbox
    And Enter invalid date on the To Textbox
    And Verify the Error message displayed on the screen that states "To date cannot be before From date."

  Scenario: Verify the transaction data display in the table
    And Verify the transaction data display in the table

  Scenario: Verify the functionality of the date filters (Start Date, End Date)
    And Enter valid date on the From textbox
    And Enter valid date on the To Textbox
    And Verify the transaction data display in the table

  Scenario: Verify the 'Search' functionality with invalid transaction details
    And Verify the Search functionality with invalid transaction details

  Scenario: Verify the 'Search' functionality with valid transaction details
    And Verify the Search functionality with valid transaction details

  Scenario: Verify the 'Clear Filter' button functionality
    And Enter valid date on the From textbox
    And Enter valid date on the To Textbox
    And Verify the transaction data display in the table
    And Verify the Clear Filter button functionality

  Scenario: Verify that the user can change the number of rows displayed per page in the transaction list.
    And I Click on Rows per page dropdown
    And Select desired value from the dropdown
    And Verify that the user can change the number of rows displayed per page in the transaction list



