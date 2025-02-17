package smsc_stepDefinitions;

<<<<<<< Updated upstream
import io.cucumber.java.en.And;
import smsc_accelerators.SMSC_Actions;
import smsc_pageobjects.smsc_ViewTransactionsObjects;
=======
import io.cucumber.java.en.Given;
import smsc_accelerators.SMSC_Actions;
import smsc_pageobjects.smsc_LoginObjects;
>>>>>>> Stashed changes
import smsc_utility.SMSC_Utils;

public class smsc_ViewTransaction {

<<<<<<< Updated upstream
    @And("I Click on the View Transaction on the sidebar")
    public void I_Click_on_the_View_Transaction_on_the_sidebar() throws InterruptedException {
        SMSC_Actions.waitForElementToBeVisible(smsc_ViewTransactionsObjects.Transactions_heading, 5);
        SMSC_Actions.clickOnElement(smsc_ViewTransactionsObjects.Transactions_heading, "Enter Transactions menu button");
    }

    @And("I Click on the Next Page button and am directed to the next page")
    public void I_Click_on_the_Next_Page_button_and_am_directed_to_the_next_page() throws InterruptedException {
        SMSC_Actions.scrollToBottom();
        SMSC_Actions.waitForElementToBeVisible(smsc_ViewTransactionsObjects.NextPage_btn, 5);
        SMSC_Actions.clickOnElement(smsc_ViewTransactionsObjects.NextPage_btn, "Enter Next Page button");
        SMSC_Actions.isElementVisible(smsc_ViewTransactionsObjects.PreciousPage_btn, "Previous Page Button, 5");
    }

    @And("I Click on the Previous Page button and am directed to the previous page")
    public void I_Click_on_the_Previous_Page_button_and_am_directed_to_the_previous_page() throws InterruptedException {
        SMSC_Actions.waitForElementToBeVisible(smsc_ViewTransactionsObjects.PreciousPage_btn, 5);
        SMSC_Actions.clickOnElement(smsc_ViewTransactionsObjects.PreciousPage_btn, "Enter Next Page button");
        SMSC_Actions.isElementNotVisible(smsc_ViewTransactionsObjects.PreciousPage_btn, "Previous Page Button, 5");
    }

    @And("Verify the Clear Filter button functionality")
    public void Verify_the_Clear_Filter_button_functionality() throws InterruptedException {
        SMSC_Actions.waitForElementToBeVisible(smsc_ViewTransactionsObjects.ClearFilter_btn, 5);
        SMSC_Actions.ClickViaMouse(smsc_ViewTransactionsObjects.ClearFilter_btn, "Enter Next Page button");
//        SMSC_Actions.waitForElementToBeVisible(smsc_ViewTransactionsObjects.FirstTransaction_txt, 25);
        Thread.sleep(10000);
    }

    @And("Verify the transaction data display in the table")
    public void Verify_the_transaction_data_display_in_the_table() throws InterruptedException {
        SMSC_Actions.waitForElementToBeVisible(smsc_ViewTransactionsObjects.FirstTransaction_txt, 25);
    }

    @And("Verify the Search functionality with invalid transaction details")
    public void Verify_the_Search_functionality_with_invalid_transaction_details() throws InterruptedException {
        String invalidTransactionId = SMSC_Utils.ConfigReader.getProperty("invalid_transaction_ID");
        SMSC_Actions.waitForElementToBeVisible(smsc_ViewTransactionsObjects.Search_txb, 5);
        SMSC_Actions.ClickViaMouse(smsc_ViewTransactionsObjects.Search_txb, "Enter Next Page button");
        SMSC_Actions.waitForElementToBeVisible(smsc_ViewTransactionsObjects.Search_txb, 25);
        SMSC_Actions.typeInTextBox(smsc_ViewTransactionsObjects.Search2_txb, invalidTransactionId , "enter transaction in the Search textbox");
        SMSC_Actions.isElementVisible(smsc_ViewTransactionsObjects.ErrorMessage_txt, "Previous Page Button, 5");
    }

    @And("Verify the Search functionality with valid transaction details")
    public void Verify_the_Search_functionality_with_valid_transaction_details() throws InterruptedException {
        String TransactionId = SMSC_Utils.ConfigReader.getProperty("transaction_ID");
        SMSC_Actions.waitForElementToBeVisible(smsc_ViewTransactionsObjects.Search_txb, 5);
        SMSC_Actions.ClickViaMouse(smsc_ViewTransactionsObjects.Search_txb, "Enter Next Page button");
        SMSC_Actions.waitForElementToBeVisible(smsc_ViewTransactionsObjects.Search_txb, 25);
        SMSC_Actions.typeInTextBox(smsc_ViewTransactionsObjects.Search2_txb, TransactionId , "enter transaction in the Search textbox");
//       Thread.sleep(2000);
//        SMSC_Actions.waitForElementToBeVisible(smsc_ViewTransactionsObjects.FromDate_tbx, 50);
//        String ID = SMSC_Actions.getElementText(smsc_ViewTransactionsObjects.FirstTransaction_txt);
//        HandleAssertion(String.valueOf(TransactionId.equalsIgnoreCase(ID)));
        SMSC_Actions.isElementVisible(smsc_ViewTransactionsObjects.FirstTransaction_txt, "First Transactions Data, 5");
    }

    @And("Verify that the required labels are listed on for each column")
    public void Verify_that_the_required_labels_are_listed_on_for_each_column() throws InterruptedException {
        //        Check the labels displayed
        SMSC_Actions.isElementVisible(smsc_ViewTransactionsObjects.TransactionsID_lbl, "Transactions_heading, 5");
        SMSC_Actions.isElementVisible(smsc_ViewTransactionsObjects.Timestamp_lbl, "Transactions_heading, 5");
        SMSC_Actions.isElementVisible(smsc_ViewTransactionsObjects.Reference_lbl, "Transactions_heading, 5");
        SMSC_Actions.isElementVisible(smsc_ViewTransactionsObjects.Channel_lbl, "Transactions_heading, 5");
        SMSC_Actions.isElementVisible(smsc_ViewTransactionsObjects.Partition_lbl, "Transactions_heading, 5");
        SMSC_Actions.isElementVisible(smsc_ViewTransactionsObjects.Priority_lbl, "Transactions_heading, 5");
        SMSC_Actions.isElementVisible(smsc_ViewTransactionsObjects.Status_Timestamp_lbl, "Transactions_heading, 5");
        SMSC_Actions.isElementVisible(smsc_ViewTransactionsObjects.Type_lbl, "Transactions_heading, 5");
        SMSC_Actions.isElementVisible(smsc_ViewTransactionsObjects.Status_lbl, "Transactions_heading, 5");
    }

    @And("Enter invalid date on the From textbox")
    public void enter_invalid_date_on_the_From_textbox() throws InterruptedException{
        SMSC_Actions.waitForElementToBeVisible(smsc_ViewTransactionsObjects.FromDate_tbx, 35);
        SMSC_Actions.ClickViaMouse(smsc_ViewTransactionsObjects.FromDate_tbx, "Click on From Date textbox");
        SMSC_Actions.waitForElementToBeVisible(smsc_ViewTransactionsObjects.MonthDropdownArrow_dpd, 45);
        SMSC_Actions.clickOnElement(smsc_ViewTransactionsObjects.MonthDropdownArrow_dpd, "Click on Month Drop Down Arrow");
        SMSC_Actions.waitForElementToBeVisible(smsc_ViewTransactionsObjects.Year2017_txt, 35);
        SMSC_Actions.clickOnElement(smsc_ViewTransactionsObjects.Year2017_txt, "Click on Year 2017");
        SMSC_Actions.ClickViaMouse(smsc_ViewTransactionsObjects.MonthDate12_txt, "Click on Year 2017");
    }

    @And("Enter invalid date on the To Textbox")
    public void enter_invalid_date_on_the_To_textbox() throws InterruptedException {
        SMSC_Actions.waitForElementToBeVisible(smsc_ViewTransactionsObjects.ToDate_tbx, 10);
        SMSC_Actions.ClickViaMouse(smsc_ViewTransactionsObjects.ToDate_tbx, "Click on From Date textbox");
        SMSC_Actions.ClickViaMouse(smsc_ViewTransactionsObjects.ToDate_dpd, "Click on Month Drop Down Arrow");
        SMSC_Actions.waitForElementToBeVisible(smsc_ViewTransactionsObjects.MonthDropdownArrow_dpd, 10);
        SMSC_Actions.ClickViaMouse(smsc_ViewTransactionsObjects.MonthDropdownArrow_dpd, "Click on Month Drop Down Arrow");

        SMSC_Actions.waitForElementToBeVisible(smsc_ViewTransactionsObjects.Year2016_txt, 10);
        SMSC_Actions.ClickViaMouse(smsc_ViewTransactionsObjects.Year2016_txt, "Click on the month date");
        SMSC_Actions.waitForElementToBeVisible(smsc_ViewTransactionsObjects.MonthDate12_txt, 10);
        SMSC_Actions.ClickViaMouse(smsc_ViewTransactionsObjects.MonthDate12_txt, "Click on Year 2017");
        Thread.sleep(2000);
    }

    @And("Verify the Error message displayed on the screen that states {string}")
    public void verify_the_error_message_displayed_on_the_screen_that_states(String string) throws InterruptedException {
        SMSC_Actions.isElementVisible(smsc_ViewTransactionsObjects.DateErrorMessage_txt, "Transactions_heading, 5");
    }

    @And("Enter valid date on the From textbox")
    public void enter_valid_date_on_the_From_textbox() throws InterruptedException{
        SMSC_Actions.waitForElementToBeVisible(smsc_ViewTransactionsObjects.FromDate_tbx, 35);
        SMSC_Actions.ClickViaMouse(smsc_ViewTransactionsObjects.FromDate_tbx, "Click on From Date textbox");
        SMSC_Actions.waitForElementToBeVisible(smsc_ViewTransactionsObjects.MonthDropdownArrow_dpd, 45);
        SMSC_Actions.clickOnElement(smsc_ViewTransactionsObjects.MonthDropdownArrow_dpd, "Click on Month Drop Down Arrow");
        SMSC_Actions.waitForElementToBeVisible(smsc_ViewTransactionsObjects.Year2017_txt, 35);
        SMSC_Actions.clickOnElement(smsc_ViewTransactionsObjects.Year2017_txt, "Click on Year 2017");
        SMSC_Actions.ClickViaMouse(smsc_ViewTransactionsObjects.MonthDate12_txt, "Click on Year 2017");
    }

    @And("Enter valid date on the To Textbox")
    public void enter_valid_date_on_the_To_textbox() throws InterruptedException {
        SMSC_Actions.waitForElementToBeVisible(smsc_ViewTransactionsObjects.ToDate_tbx, 10);
        SMSC_Actions.ClickViaMouse(smsc_ViewTransactionsObjects.ToDate_tbx, "Click on From Date textbox");
        SMSC_Actions.ClickViaMouse(smsc_ViewTransactionsObjects.ToDate_dpd, "Click on Month Drop Down Arrow");
        SMSC_Actions.waitForElementToBeVisible(smsc_ViewTransactionsObjects.MonthDropdownArrow_dpd, 10);
        SMSC_Actions.ClickViaMouse(smsc_ViewTransactionsObjects.MonthDropdownArrow_dpd, "Click on Month Drop Down Arrow");

        SMSC_Actions.waitForElementToBeVisible(smsc_ViewTransactionsObjects.Year2025_txt, 10);
        SMSC_Actions.ClickViaMouse(smsc_ViewTransactionsObjects.Year2025_txt, "Click on the month date");
        SMSC_Actions.waitForElementToBeVisible(smsc_ViewTransactionsObjects.MonthDate12_txt, 10);
        SMSC_Actions.ClickViaMouse(smsc_ViewTransactionsObjects.MonthDate12_txt, "Click on Year 2017");

    }

    @And("I Click on Rows per page dropdown")
    public void i_click_on_rows_per_page_dropdown()throws InterruptedException  {
        SMSC_Actions.scrollToBottom();
        SMSC_Actions.waitForElementToBeVisible(smsc_ViewTransactionsObjects.RowPageDropDown_dpd, 25);
        SMSC_Actions.ClickViaMouse(smsc_ViewTransactionsObjects.RowPageDropDown_dpd, "Click on Row Page Drop Down Arrow");
    }
    @And("Select desired value from the dropdown")
    public void select_desired_value_from_the_dropdown() throws InterruptedException {
        SMSC_Actions.isElementVisible(smsc_ViewTransactionsObjects.RowPageDropDown10_dpd,"");
        SMSC_Actions.clickOnElement(smsc_ViewTransactionsObjects.RowPageDropDown10_dpd, "Select 10 Row Page Drop Down Arrow");
    }
    @And("Verify that the user can change the number of rows displayed per page in the transaction list")
    public void verify_that_the_user_can_change_the_number_of_rows_displayed_per_page_in_the_transaction_list() throws InterruptedException {
        SMSC_Actions.isElementVisible(smsc_ViewTransactionsObjects.RowPageDropDown10_dpd,"");
=======
    @Given("I have logon SMSC Absa page")
    public void I_have_logon_SMSC_Absa_page() {
        SMSC_Actions.waitForElementToBeVisible(smsc_LoginObjects.Login_heading, 5);
        SMSC_Actions.waitForElementToBeVisible(smsc_LoginObjects.Username_txtb, 5);
        String email = SMSC_Utils.ConfigReader.getProperty("valid_email");
        String password = SMSC_Utils.ConfigReader.getProperty("valid_Password");
        SMSC_Actions.typeInTextBox(smsc_LoginObjects.Username_txtb, email, "enter the word email");
        SMSC_Actions.typeInTextBox(smsc_LoginObjects.Password_txtb, password, "Enter the word password textbox");
        SMSC_Actions.clickOnElement(smsc_LoginObjects.SubmitLogin_btn, "Enter login button");
        SMSC_Actions.waitForElementToBeVisible(smsc_LoginObjects.Loggedin_heading, 5);
>>>>>>> Stashed changes
    }
}
