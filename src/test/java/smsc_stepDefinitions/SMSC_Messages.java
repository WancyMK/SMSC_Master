package smsc_stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import smsc_accelerators.SMSC_Actions;
import smsc_accelerators.SMSC_Base;
import smsc_pageobjects.SMSC_Channels_PageObjects;
import smsc_pageobjects.SMSC_Messages_PageObjects;
import smsc_utility.Logs;
import smsc_utility.SMSC_ExceptionHandler;
import smsc_utility.SMSC_Utils;

public class SMSC_Messages extends SMSC_Base {
    public static String transactionIDText;
    public static String recipientText;
    public static String channelText;
    @Given("User clicks on Messages on the sidebar")
    public void user_clicks_on_messages_on_the_sidebar() {
        SMSC_Actions.waitForElementToBeVisible(SMSC_Messages_PageObjects.messagesSidebar_btn, 45);
        SMSC_Actions.jsClickOnElement(SMSC_Messages_PageObjects.messagesSidebar_btn, "Messages");

        recipientText = SMSC_Actions.getElementText(SMSC_Messages_PageObjects.recipient_txt, "Recipient");
        transactionIDText = SMSC_Actions.getElementText(SMSC_Messages_PageObjects.transactionID_txt, "Transaction ID");
        channelText = SMSC_Actions.getElementText(SMSC_Messages_PageObjects.channel_txt, "Channel");
    }
    @Given("User enters valid filter criteria in the search box on messages page")
    public void user_enters_valid_filter_criteria_in_the_search_box_on_messages_page() throws InterruptedException {
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.search_txtb, transactionIDText, "Transaction ID");
        Thread.sleep(3000);
    }
    @Given("User validates the valid search results on messages page")
    public void user_validates_the_valid_search_results_on_messages_page() throws InterruptedException {
        Thread.sleep(3000);
//        SMSC_Actions.waitForTextChangeFluently(SMSC_Messages_PageObjects.transactionID_txt, "No messages found.", 50, 3);
        SMSC_Actions.waitForElementToBeVisible(SMSC_Messages_PageObjects.transactionID_txt, 50);
        String fetchedTransactionIDText = SMSC_Actions.getElementText(SMSC_Messages_PageObjects.transactionID_txt, "Transaction ID");
        System.out.println(fetchedTransactionIDText);
        if(!fetchedTransactionIDText.equals(transactionIDText)){
            SMSC_ExceptionHandler.HandleAssertion("Search results not validated");
        }else{
            Logs.info("Search results validated");
        }
    }
    @Given("User enters invalid filter criteria in the search box on messages page")
    public void user_enters_invalid_filter_criteria_in_the_search_box_on_messages_page() {
        SMSC_Actions.clearTextbox(SMSC_Channels_PageObjects.search_txtb, "Search box");
        WebElement element = driver.findElement(SMSC_Channels_PageObjects.search_txtb);
        element.sendKeys(Keys.CONTROL + "a"); // Select all text
        element.sendKeys(Keys.BACK_SPACE);
        String invalidSearch = SMSC_Utils.ConfigReader.getProperty("invalidSearch");
        SMSC_Actions.waitForElementToBeVisible(SMSC_Channels_PageObjects.search_txtb, 45);
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.search_txtb, invalidSearch, "Search Box");

    }
    @Then("User validates the error message as {string} on messages page")
    public void user_validates_the_error_message_as_on_messages_page(String string) {
        SMSC_Actions.waitForElementToBeVisible(SMSC_Messages_PageObjects.noMessagesFound_txt, 45);
        if(!SMSC_Actions.isElementVisible(SMSC_Messages_PageObjects.noMessagesFound_txt, "Invalid search")){
            SMSC_ExceptionHandler.HandleAssertion("No messages found. element is not visible");
        }else{
            Logs.info("No messages found. element is visible");
        }
    }

    @Then("User selects Recipient from the filters dropdown")
    public void user_selects_recipient_from_the_filters_dropdown() throws Exception {
        SMSC_Actions.waitForElementToBeVisible(SMSC_Messages_PageObjects.search_dropdown, 45);
        SMSC_Actions.ClickViaMouse(SMSC_Messages_PageObjects.search_dropdown,"Search dropdown");
        SMSC_Actions.waitForElementToBeVisible(SMSC_Messages_PageObjects.recipientOption_dropdown, 45);
        SMSC_Actions.waitForElementToBeVisible(SMSC_Messages_PageObjects.recipientOption_dropdown, 45);
        SMSC_Actions.ClickViaMouse(SMSC_Messages_PageObjects.recipientOption_dropdown,"Search dropdown");
    }
    @Then("User enters Recipient as {string} in the search box on messages page")
    public void user_enters_recipient_as_in_the_search_box_on_messages_page(String string) throws InterruptedException {
        WebElement element = driver.findElement(SMSC_Channels_PageObjects.search_txtb);
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.BACK_SPACE);
        SMSC_Actions.waitForElementToBeVisible(SMSC_Channels_PageObjects.search_txtb, 45);
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.search_txtb, recipientText, "Recipient");
        Thread.sleep(3000);
    }
    @Then("User validates the Recipient search results")
    public void user_validates_the_recipient_search_results() throws InterruptedException {
        Thread.sleep(3000);
        SMSC_Actions.waitForElementToBeVisible(SMSC_Messages_PageObjects.recipient_txt, 50);
        String recipientSearch = SMSC_Actions.getElementText(SMSC_Messages_PageObjects.recipient_txt, "Recipient");
        if(!recipientSearch.equals(recipientText)){
            SMSC_ExceptionHandler.HandleAssertion("Recipient search results not validated");
        }else{
            Logs.info("Recipient search results validated");
        }
    }

    @Then("User selects Transaction from the filters dropdown")
    public void user_selects_transaction_from_the_filters_dropdown() throws Exception {
        SMSC_Actions.waitForElementToBeVisible(SMSC_Messages_PageObjects.search_dropdown, 45);
        SMSC_Actions.ClickViaMouse(SMSC_Messages_PageObjects.search_dropdown,"Search dropdown");
        SMSC_Actions.waitForElementToBeVisible(SMSC_Messages_PageObjects.transactionOption_dropdown, 45);
        SMSC_Actions.jsClickOnElement(SMSC_Messages_PageObjects.transactionOption_dropdown,"Search dropdown");
    }
    @Then("User enters Transaction ID as {string} in the search box on messages page")
    public void user_enters_transaction_id_as_in_the_search_box_on_messages_page(String string) throws InterruptedException {
        WebElement element = driver.findElement(SMSC_Channels_PageObjects.search_txtb);
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.BACK_SPACE);
        SMSC_Actions.waitForElementToBeVisible(SMSC_Channels_PageObjects.search_txtb, 45);
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.search_txtb, transactionIDText, "Transaction ID");
        Thread.sleep(3000);
    }
    @Then("User validates the Transaction ID search results")
    public void user_validates_the_transaction_id_search_results() throws InterruptedException {
        Thread.sleep(3000);
//        SMSC_Actions.waitForTextChangeFluently(SMSC_Messages_PageObjects.transactionID_txt, "No messages found.", 50, 3);
        SMSC_Actions.waitForElementToBeVisible(SMSC_Messages_PageObjects.transactionID_txt, 50);
        String transactionSearch = SMSC_Actions.getElementText(SMSC_Messages_PageObjects.transactionID_txt, "Transaction ID");
        if(!transactionSearch.equals(transactionIDText)){
            SMSC_ExceptionHandler.HandleAssertion("Transaction search results not validated");
        }else{
            Logs.info("Transaction search results validated");
        }
    }

    @Then("User selects Channel from the filters dropdown")
    public void user_selects_channel_from_the_filters_dropdown() throws Exception {
        SMSC_Actions.waitForElementToBeVisible(SMSC_Messages_PageObjects.search_dropdown, 45);
        SMSC_Actions.ClickViaMouse(SMSC_Messages_PageObjects.search_dropdown,"Search dropdown");
        SMSC_Actions.waitForElementToBeVisible(SMSC_Messages_PageObjects.channelOption_dropdown, 45);
        SMSC_Actions.jsClickOnElement(SMSC_Messages_PageObjects.channelOption_dropdown,"Search dropdown");
    }
    @Then("User enters Channel as {string} in the search box on messages page")
    public void user_enters_channel_as_in_the_search_box_on_messages_page(String string) throws InterruptedException {
        WebElement element = driver.findElement(SMSC_Channels_PageObjects.search_txtb);
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.BACK_SPACE);
        SMSC_Actions.waitForElementToBeVisible(SMSC_Channels_PageObjects.search_txtb, 45);
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.search_txtb, channelText, "Channel");
        Thread.sleep(3000);
    }
    @Then("User validates the Channel search results")
    public void user_validates_the_channel_search_results() throws InterruptedException {
        Thread.sleep(3000);
        SMSC_Actions.waitForElementToBeVisible(SMSC_Messages_PageObjects.channel_txt, 50);
        String channelSearch = SMSC_Actions.getElementText(SMSC_Messages_PageObjects.channel_txt, "Channel");
        if(!channelSearch.equals(channelText)){
            SMSC_ExceptionHandler.HandleAssertion("Channel search results not validated");
        }else{
            Logs.info("Channel search results validated");
        }
    }
    @Then("User clicks on View button")
    public void user_clicks_on_view_button() throws Exception {
        SMSC_Actions.waitForElementToBeVisible(SMSC_Messages_PageObjects.view_btn, 45);
        SMSC_Actions.ClickViaMouse(SMSC_Messages_PageObjects.view_btn, "View button");
    }
    @Then("User validates Message details")
    public void user_validates_message_details() {
        SMSC_Actions.waitForElementToBeVisible(SMSC_Messages_PageObjects.validateMessageDetails_txt, 45);
        if(!SMSC_Actions.isElementVisible(SMSC_Messages_PageObjects.validateMessageDetails_txt, "Message details")){
            SMSC_ExceptionHandler.HandleAssertion("Message details are not validated");
        }else{
            Logs.info("Message details are validated");
        }
        SMSC_Actions.waitForElementToBeVisible(SMSC_Messages_PageObjects.close_btn, 45);
        SMSC_Actions.jsClickOnElement(SMSC_Messages_PageObjects.close_btn, "Close button");
    }
}