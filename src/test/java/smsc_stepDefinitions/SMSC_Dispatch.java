package smsc_stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import smsc_accelerators.SMSC_Actions;
import smsc_accelerators.SMSC_Base;
import smsc_pageobjects.SMSC_Channels_PageObjects;
import smsc_pageobjects.SMSC_Dispatch_PageObjects;
import smsc_utility.Logs;
import smsc_utility.SMSC_ExceptionHandler;
import smsc_utility.SMSC_Utils;

import java.awt.*;
import java.awt.event.KeyEvent;

public class SMSC_Dispatch extends SMSC_Base {
    public static String actualIDText;
    public static int characterMessageCount;
    public static int bulkCharacterMessageCount;
    public static int batchCharacterMessageCount;
    public static boolean sentMessageElement;
    public static String sentTrue;
    public static String sentTrueValidateText;


    @Given("User clicks on {string} on the sidebar")
    public void user_clicks_on_on_the_sidebar(String string) {
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.dispatch_btn, 10);
        SMSC_Actions.jsClickOnElement(SMSC_Dispatch_PageObjects.dispatch_btn, "Dispatch");
    }

    @Given("User enters the valid Recipient number as {string} under the Dispatch Message")
    public void user_enters_the_valid_recipient_number_as_under_the_dispatch_message(String string) {
        String referenceNumber01 = SMSC_Utils.ConfigReader.getProperty("referenceNumber01");
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.addRecipient_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_Dispatch_PageObjects.addRecipient_txtb, referenceNumber01, "Reference Number");
    }

    @Given("User enters the Message as {string} under the Dispatch Message")
    public void user_enters_the_message_as_under_the_dispatch_message(String string) {
        String dispatchMessage = SMSC_Utils.ConfigReader.getProperty("dispatchMessage");
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.message_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_Dispatch_PageObjects.message_txtb, dispatchMessage, "Message");
    }

    @Given("User clicks on Send Messages button")
    public void user_clicks_on_send_messages_button() {
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.sendMessages_btn, 10);
        SMSC_Actions.jsClickOnElement(SMSC_Dispatch_PageObjects.sendMessages_btn, "Send Message button");
    }

    @Then("User verifies the sent message details and status as Completed under the Dispatch Message")
    public void user_verifies_the_sent_message_details_and_status_as_completed_under_the_dispatch_message() throws Exception {
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.peek_btn, 10);
        SMSC_Actions.jsClickOnElement(SMSC_Dispatch_PageObjects.peek_btn, "Peek button");

        // Fetching ID text
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.id_txt, 10);
        Thread.sleep(3000);
        String idText = SMSC_Actions.getElementText(SMSC_Dispatch_PageObjects.id_txt, "ID");
        actualIDText = idText.replace("ID: ", "");

        // Validating Completed message
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.completedMessageStatus_txt, 10);
        String completedStatus = "Completed";
        String completedStatusText = SMSC_Actions.getElementText(SMSC_Dispatch_PageObjects.completedMessageStatus_txt,"Completed").trim();
        if(!completedStatus.equals(completedStatusText)){
            SMSC_ExceptionHandler.HandleAssertion("Message is not dispatched");
        }else{
            Logs.info("Message is dispatched successfully and displayed status as Completed");
        }
    }

    @Then("User validates the message details on Messages page of Dispatch Message")
    public void user_validates_the_message_details_on_messages_page_of_dispatch_message() throws InterruptedException {
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.messagesSidebar_btn, 10);
        SMSC_Actions.jsClickOnElement(SMSC_Dispatch_PageObjects.messagesSidebar_btn, "Messages");
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.search_txtb, actualIDText, "Search Box");
        Thread.sleep(2000);
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.validateTransactionsText, 10);
        Thread.sleep(3000);
        String transactionsText = SMSC_Actions.getElementText(SMSC_Dispatch_PageObjects.validateTransactionsText, "Transactions ID");
        if (!actualIDText.contains(transactionsText)){
            SMSC_ExceptionHandler.HandleAssertion("Transaction is not validated on Messages page");
        }else {
            Logs.info("Transaction is validated on Messages page");
        }
    }

    @Given("User enters the invalid Recipient number as {string} under the Dispatch Message")
    public void user_enters_the_invalid_recipient_number_as_under_the_dispatch_message(String string) {
        String invalidReferenceNumber = SMSC_Utils.ConfigReader.getProperty("invalidReferenceNumber");
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.addRecipient_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_Dispatch_PageObjects.addRecipient_txtb, invalidReferenceNumber, "Recipient Number");
    }

    @Then("User verifies the sent message details and status as Error under the Dispatch Message")
    public void user_verifies_the_sent_message_details_and_status_as_error_under_the_dispatch_message() {
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.errorMessageStatus_txt, 10);
        String errorStatus = "Error";
        String errorStatusText = SMSC_Actions.getElementText(SMSC_Dispatch_PageObjects.errorMessageStatus_txt, "Error").trim();
        if(!errorStatus.equals(errorStatusText)){
            SMSC_ExceptionHandler.HandleAssertion("Message is dispatched");
        }else{
            Logs.info("Message is not dispatched and displayed status as Error");
        }
    }

    @Given("User enters the Recipient number as {string} under the Dispatch Message")
    public void user_enters_the_recipient_number_as_under_the_dispatch_message(String string) {
        String referenceNumber01 = SMSC_Utils.ConfigReader.getProperty("invalidReferenceNumber01");
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.addRecipient_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_Dispatch_PageObjects.addRecipient_txtb, referenceNumber01, "Reference Number");
    }

    @Given("User enters the Message as {string} under the Dispatch Message to character count")
    public void user_enters_the_message_as_under_the_dispatch_message_to_character_count(String string) {
        String dispatchMessage = SMSC_Utils.ConfigReader.getProperty("dispatchMessage");
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.message_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_Dispatch_PageObjects.message_txtb, dispatchMessage, "Message");
        String text = SMSC_Actions.getElementText(SMSC_Dispatch_PageObjects.message_txtb, "Messages text box");
        characterMessageCount = text.length();
    }

    @Then("User validates the characters count under the Dispatch Message")
    public void user_validates_the_characters_count_under_the_dispatch_message() {
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.characterCount_txt, 10);
        String text = SMSC_Actions.getElementText(SMSC_Dispatch_PageObjects.characterCount_txt, "Characters count").trim();
        String extractedCharacterCount = text.split("/")[0].trim();
        if (!String.valueOf(characterMessageCount).equals(extractedCharacterCount)){
            SMSC_ExceptionHandler.HandleAssertion("Characters count is not validated");
        }else
            Logs.info("Characters count is validated");
    }

    @Then("User clicks on Clear button under the Dispatch Message")
    public void user_clicks_on_clear_button_under_the_dispatch_message() throws InterruptedException {
        Thread.sleep(3000);
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.sentTrue_txt, 10);
        sentTrue = SMSC_Actions.getElementText(SMSC_Dispatch_PageObjects.sentTrue_txt, "Sent True");
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.sentMessageClear_btn, 10);
        SMSC_Actions.ClickViaMouse(SMSC_Dispatch_PageObjects.sentMessageClear_btn, "Clear button");
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.sentTrue_txt, 10);
        sentTrueValidateText = SMSC_Actions.getElementText(SMSC_Dispatch_PageObjects.sentTrue_txt, "Sent True");
    }

    @Then("User validates message details are cleared under the Dispatch Message")
    public void user_validates_message_details_are_cleared_under_the_dispatch_message() {
        if (sentTrue.equals(sentTrueValidateText)) {
            SMSC_ExceptionHandler.HandleAssertion("The message text is not cleared");
        } else {
            Logs.info("The message text is cleared successfully");
        }
    }

    @Given("User clicks on Bulk Recipients")
    public void user_clicks_on_bulk_recipients() {
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.bulkRecipients_btn, 10);
        SMSC_Actions.clickOnElement(SMSC_Dispatch_PageObjects.bulkRecipients_btn, "Bulk Recipients");
    }

    @Given("User enters the valid Recipient numbers as {string} under the Bulk Recipients")
    public void user_enters_the_valid_recipient_numbers_as_under_the_bulk_recipients(String string) throws InterruptedException {
        String referenceNumber01 = SMSC_Utils.ConfigReader.getProperty("referenceNumber01");
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.addRecipient_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_Dispatch_PageObjects.addRecipient_txtb, referenceNumber01, "Reference Number");

        WebElement addButton = driver.findElement(By.xpath("//button[contains(@class, 'css-992vvr')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", addButton);
        WebElement element = driver.findElement(SMSC_Dispatch_PageObjects.addRecipient_txtb);
        element.sendKeys(Keys.CONTROL + "a"); // Select all text
        element.sendKeys(Keys.BACK_SPACE);

        String referenceNumber02 = SMSC_Utils.ConfigReader.getProperty("referenceNumber02");
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.addRecipient_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_Dispatch_PageObjects.addRecipient_txtb, referenceNumber02, "Reference Number");
        js.executeScript("arguments[0].click();", addButton);
    }

    @Given("User enters the Message as {string} under the Bulk Recipients")
    public void user_enters_the_message_as_under_the_bulk_recipients(String string) {
        String dispatchBulkMessage = SMSC_Utils.ConfigReader.getProperty("bulkMessage");
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.message_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_Dispatch_PageObjects.message_txtb, dispatchBulkMessage, "Message");
    }

    @Given("User clicks on Send Bulk Messages button")
    public void user_clicks_on_send_bulk_messages_button() {
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.sendBulkMessages_btn, 10);
        SMSC_Actions.clickOnElement(SMSC_Dispatch_PageObjects.sendBulkMessages_btn, "Send Bulk Messages button");
    }

    @Then("User verifies the sent message details and status as Completed under the Bulk Recipients")
    public void user_verifies_the_sent_message_details_and_status_as_completed_under_the_bulk_recipients() throws InterruptedException {
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.peek_btn, 10);
        SMSC_Actions.clickOnElement(SMSC_Dispatch_PageObjects.peek_btn, "Peek button");

        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.id_txt, 10);
        Thread.sleep(3000);
        String idText = SMSC_Actions.getElementText(SMSC_Dispatch_PageObjects.id_txt, "ID");
        actualIDText = idText.replace("ID: ", "");

        // Validating Completed message
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.completedMessageStatus_txt, 10);
        String completedStatus = "Completed";
        String completedStatusText = SMSC_Actions.getElementText(SMSC_Dispatch_PageObjects.completedMessageStatus_txt,"Completed").trim();
        if(!completedStatus.equals(completedStatusText)){
            SMSC_ExceptionHandler.HandleAssertion("Bulk Messages not dispatched");
        }else{
            Logs.info("Bulk Messages dispatched successfully and displayed status as Completed");
        }
    }

    @Then("User validates the message details on Messages page of Bulk Recipients")
    public void user_validates_the_message_details_on_messages_page_of_bulk_recipients() throws InterruptedException {
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.messagesSidebar_btn, 10);
        SMSC_Actions.jsClickOnElement(SMSC_Dispatch_PageObjects.messagesSidebar_btn, "Messages");
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.search_txtb, actualIDText, "Search Box");
        Thread.sleep(3000);
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.validateTransactionsText, 10);
        String transactionsText = SMSC_Actions.getElementText(SMSC_Dispatch_PageObjects.validateTransactionsText, "Transactions ID");
        if (!actualIDText.equals(transactionsText)){
            SMSC_ExceptionHandler.HandleAssertion("Transaction is not validated on Messages page");
        }else {
            Logs.info("Transaction is validated on Messages page");
        }
    }

    @Given("User enters the invalid Recipient numbers as {string} under the Bulk Recipients")
    public void user_enters_the_invalid_recipient_numbers_as_under_the_bulk_recipients(String string) {
        String referenceNumber01 = SMSC_Utils.ConfigReader.getProperty("invalidReferenceNumber01");
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.addRecipient_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_Dispatch_PageObjects.addRecipient_txtb, referenceNumber01, "Reference Number");

        WebElement addButton = driver.findElement(By.xpath("//button[contains(@class, 'css-992vvr')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", addButton);
        WebElement element = driver.findElement(SMSC_Dispatch_PageObjects.addRecipient_txtb);
        element.sendKeys(Keys.CONTROL + "a"); // Select all text
        element.sendKeys(Keys.BACK_SPACE);

        String referenceNumber02 = SMSC_Utils.ConfigReader.getProperty("invalidReferenceNumber02");
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.addRecipient_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_Dispatch_PageObjects.addRecipient_txtb, referenceNumber02, "Reference Number");
        js.executeScript("arguments[0].click();", addButton);
    }

    @Then("User verifies the sent message details and status as NoAction under the Bulk Recipients")
    public void user_verifies_the_sent_message_details_and_status_as_noAction_under_the_bulk_recipients() {
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.noActionMessageStatus_txt, 10);
        String errorStatus = "NoAction";
        String errorStatusText = SMSC_Actions.getElementText(SMSC_Dispatch_PageObjects.noActionMessageStatus_txt, "Error").trim();
        if(!errorStatus.equals(errorStatusText)){
            SMSC_ExceptionHandler.HandleAssertion("Bulk Messages dispatched");
        }else{
            Logs.info("Bulk Messages not dispatched and displayed status as NoAction");
        }
    }

    @Given("User clicks on Choose File and selects the valid excel Bulk file")
    public void user_clicks_on_choose_file_and_selects_the_valid_excel_bulk_file() throws Exception {
        SMSC_Actions.ClickViaMouse(SMSC_Dispatch_PageObjects.file_txtb, "Choose file");
        String CSVFile = "smsc_Data/Bulk Recipients-Stable.csv";
        SMSC_Actions.FileUpload(SMSC_Dispatch_PageObjects.file_txtb, CSVFile);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
    }

    @Then("User verifies the sent bulk message details and status as Completed under the Bulk Recipients")
    public void user_verifies_the_sent_bulk_message_details_and_status_as_completed_under_the_bulk_recipients() throws InterruptedException {
        // Fetching ID text
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.id_txt, 10);
        Thread.sleep(3000);
        String idText = SMSC_Actions.getElementText(SMSC_Dispatch_PageObjects.id_txt, "ID");
        actualIDText = idText.replace("ID: ", "");

        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.peek_btn, 10);
        SMSC_Actions.ClickViaMouse(SMSC_Dispatch_PageObjects.peek_btn, "Peek button");

        // Validating Completed message
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.completedMessageStatus_txt, 10);
        String completedStatus = "Completed";
        String completedStatusText = SMSC_Actions.getElementText(SMSC_Dispatch_PageObjects.completedMessageStatus_txt,"Completed").trim();
        if(!completedStatus.equals(completedStatusText)){
            SMSC_ExceptionHandler.HandleAssertion("Bulk Messages not dispatched");
        }else{
            Logs.info("Bulk Messages dispatched successfully and displayed status as Completed");
        }
    }

    @Then("User validates the bulk message details on Messages page of Bulk Recipients")
    public void user_validates_the_bulk_message_details_on_messages_page_of_bulk_recipients() throws InterruptedException {
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.messagesSidebar_btn, 10);
        SMSC_Actions.jsClickOnElement(SMSC_Dispatch_PageObjects.messagesSidebar_btn, "Messages");
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.search_txtb, actualIDText, "Search Box");
        Thread.sleep(2000);
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.validateTransactionsText, 10);
        Thread.sleep(3000);
        String transactionsText = SMSC_Actions.getElementText(SMSC_Dispatch_PageObjects.validateTransactionsText, "Transactions ID");
        if (!actualIDText.contains(transactionsText)){
            SMSC_ExceptionHandler.HandleAssertion("Transaction is not validated on Messages page");
        }else {
            Logs.info("Transaction is validated on Messages page");
        }
    }

    @Given("User clicks on Choose File and selects the valid text Bulk file")
    public void user_clicks_on_choose_file_and_selects_the_valid_text_bulk_file() throws Exception {
        SMSC_Actions.ClickViaMouse(SMSC_Dispatch_PageObjects.file_txtb, "Choose file");
        String CSVFile = "smsc_Data/Bulk Recipients-Stable.txt";
        SMSC_Actions.FileUpload(SMSC_Dispatch_PageObjects.file_txtb, CSVFile);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
    }

    @Given("User clicks on Choose File and selects the invalid excel Bulk file")
    public void user_clicks_on_choose_file_and_selects_the_invalid_excel_bulk_file() throws Exception {
        SMSC_Actions.ClickViaMouse(SMSC_Dispatch_PageObjects.file_txtb, "Choose file");
        String CSVFile = "smsc_Data/Bulk Recipients-Unstable.csv";
        SMSC_Actions.FileUpload(SMSC_Dispatch_PageObjects.file_txtb, CSVFile);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
    }

    @Then("User verifies the sent bulk message details and status as NoAction under the Bulk Recipients")
    public void user_verifies_the_sent_bulk_message_details_and_status_as_noAction_under_the_bulk_recipients() {
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.noActionMessageStatus_txt, 10);
        String errorStatus = "NoAction";
        String errorStatusText = SMSC_Actions.getElementText(SMSC_Dispatch_PageObjects.noActionMessageStatus_txt, "Error").trim();
        if(!errorStatus.equals(errorStatusText)){
            SMSC_ExceptionHandler.HandleAssertion("Bulk Messages dispatched");
        }else{
            Logs.info("Bulk Messages not dispatched and displayed status as NoAction");
        }
    }

    @Given("User clicks on Choose File and selects the invalid text Bulk file")
    public void user_clicks_on_choose_file_and_selects_the_invalid_text_bulk_file() throws Exception {
        SMSC_Actions.ClickViaMouse(SMSC_Dispatch_PageObjects.file_txtb, "Choose file");
        String CSVFile = "smsc_Data/Bulk Recipients-Unstable.txt";
        SMSC_Actions.FileUpload(SMSC_Dispatch_PageObjects.file_txtb, CSVFile);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
    }

    @Given("User enters the Recipient number as {string} under the Bulk Recipients")
    public void user_enters_the_recipient_number_as_under_the_bulk_recipients(String string) {
        String referenceNumber01 = SMSC_Utils.ConfigReader.getProperty("invalidReferenceNumber01");
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.addRecipient_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_Dispatch_PageObjects.addRecipient_txtb, referenceNumber01, "Reference Number");

        WebElement addButton = driver.findElement(By.xpath("//button[contains(@class, 'css-992vvr')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", addButton);
        WebElement element = driver.findElement(SMSC_Dispatch_PageObjects.addRecipient_txtb);
        element.sendKeys(Keys.CONTROL + "a"); // Select all text
        element.sendKeys(Keys.BACK_SPACE);

        String referenceNumber02 = SMSC_Utils.ConfigReader.getProperty("invalidReferenceNumber02");
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.addRecipient_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_Dispatch_PageObjects.addRecipient_txtb, referenceNumber02, "Reference Number");
        js.executeScript("arguments[0].click();", addButton);
    }

    @Given("User enters the Message as {string} under the Bulk Recipients to character count")
    public void user_enters_the_message_as_under_the_bulk_recipients_to_character_count(String string) {
        String dispatchBulkMessage = SMSC_Utils.ConfigReader.getProperty("bulkMessage");
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.message_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_Dispatch_PageObjects.message_txtb, dispatchBulkMessage, "Message");
        String text = SMSC_Actions.getElementText(SMSC_Dispatch_PageObjects.message_txtb, "Messages text box");
        bulkCharacterMessageCount = text.length();
    }
    @Then("User validates the characters count under the Bulk Recipients")
    public void user_validates_the_characters_count_under_the_bulk_recipients() {
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.bulkCharacterCount, 10);
        String text = SMSC_Actions.getElementText(SMSC_Dispatch_PageObjects.bulkCharacterCount, "Characters count").trim();
        String extractedCharacterCount = text.split("/")[0].trim();
        System.out.println(extractedCharacterCount);
        if (!String.valueOf(bulkCharacterMessageCount).equals(extractedCharacterCount)){
            SMSC_ExceptionHandler.HandleAssertion("Characters count is not validated");
        }else {
            Logs.info("Characters count is validated");
        }
    }

    @Then("User clicks on Clear button under the Bulk Recipients")
    public void user_clicks_on_clear_button_under_the_bulk_recipients() throws InterruptedException {
        Thread.sleep(3000);
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.sentTrue_txt, 10);
        sentTrue = SMSC_Actions.getElementText(SMSC_Dispatch_PageObjects.sentTrue_txt, "Sent True");
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.sentMessageClear_btn, 10);
        SMSC_Actions.ClickViaMouse(SMSC_Dispatch_PageObjects.sentMessageClear_btn, "Clear button");
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.sentTrue_txt, 10);
        sentTrueValidateText = SMSC_Actions.getElementText(SMSC_Dispatch_PageObjects.sentTrue_txt, "Sent True");
    }

    @Then("User validates message details are cleared under the Bulk Recipients")
    public void user_validates_message_details_are_cleared_under_the_bulk_recipients() {
        if (sentTrue.equals(sentTrueValidateText)) {
            SMSC_ExceptionHandler.HandleAssertion("The message text is not cleared");
        } else {
            Logs.info("The message text is cleared successfully");
        }
    }

    @Then("User validates Clear button and Clear icon functionality before dispatch message under the Bulk Recipients")
    public void user_validates_clear_button_and_clear_icon_functionality_before_dispatch_message_under_the_Bulk_Recipients() throws Exception {
        String referenceNumber01 = SMSC_Utils.ConfigReader.getProperty("invalidReferenceNumber01");
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.addRecipient_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_Dispatch_PageObjects.addRecipient_txtb, referenceNumber01, "Reference Number");

        WebElement addButton = driver.findElement(By.xpath("//button[contains(@class, 'css-992vvr')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", addButton);

        String dispatchBulkMessage = SMSC_Utils.ConfigReader.getProperty("bulkMessage");
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.message_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_Dispatch_PageObjects.message_txtb, dispatchBulkMessage, "Message");

        String addRecipientText = SMSC_Actions.getElementTextInput(SMSC_Dispatch_PageObjects.addRecipient_txtb, "Add Recipients").trim();
        System.out.println(addRecipientText);
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.clear_btn, 10);
        SMSC_Actions.ClickViaMouse(SMSC_Dispatch_PageObjects.clear_btn, "Clear button");

        String validateAddRecipientText = SMSC_Actions.getElementTextInput(SMSC_Dispatch_PageObjects.addRecipient_txtb, "Add Recipients").trim();
        System.out.println("After clear"+validateAddRecipientText);
        if(addRecipientText.equals(validateAddRecipientText)){
            SMSC_ExceptionHandler.HandleAssertion("The Add Recipient text box is not cleared");
        } else {
            Logs.info("The Add Recipient text box is cleared successfully");
        }

        SMSC_Actions.ClickViaMouse(SMSC_Dispatch_PageObjects.file_txtb, "Choose file");
        String CSVFile = "smsc_Data/Bulk Recipients-Unstable.txt";
        SMSC_Actions.FileUpload(SMSC_Dispatch_PageObjects.file_txtb, CSVFile);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.fileUploadText, 10);
        String fileUploadText = SMSC_Actions.getElementTextInput(SMSC_Dispatch_PageObjects.fileUploadText, "File upload textbox");
        System.out.println(fileUploadText);

        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.bulkRecipientsClearIcon_btn, 10);
        SMSC_Actions.ClickViaMouse(SMSC_Dispatch_PageObjects.bulkRecipientsClearIcon_btn, "Clear Icon");

        String validateFileUploadText = SMSC_Actions.getElementTextInput(SMSC_Dispatch_PageObjects.fileUploadText, "File upload textbox");
        System.out.println("After clear"+validateFileUploadText);
        if(fileUploadText.equals(validateFileUploadText)){
            SMSC_ExceptionHandler.HandleAssertion("The File Upload text box is not cleared");
        } else {
            Logs.info("The File Upload text box is cleared successfully");
        }
    }

    @Given("User clicks on Batch Messages")
    public void user_clicks_on_batch_messages() {
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.batchMessages_btn, 10);
        SMSC_Actions.ClickViaMouse(SMSC_Dispatch_PageObjects.batchMessages_btn, "Batch Messages");
    }

    @Given("User enters the valid Recipient numbers as {string} and Message as {string} under the Batch Messages")
    public void user_enters_the_valid_recipient_numbers_as_and_message_as_under_the_batch_messages(String string, String string2) {
        String referenceNumber01 = SMSC_Utils.ConfigReader.getProperty("referenceNumber01");
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.addRecipient_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_Dispatch_PageObjects.addRecipient_txtb, referenceNumber01, "Reference Number");

        String dispatchBulkMessage = SMSC_Utils.ConfigReader.getProperty("batchMessage01");
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.message_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_Dispatch_PageObjects.message_txtb, dispatchBulkMessage, "Message");

        WebElement addButton = driver.findElement(By.xpath("//button[contains(@class, 'css-992vvr')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", addButton);
        WebElement element = driver.findElement(SMSC_Dispatch_PageObjects.addRecipient_txtb);
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.BACK_SPACE);

        String referenceNumber02 = SMSC_Utils.ConfigReader.getProperty("referenceNumber02");
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.addRecipient_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_Dispatch_PageObjects.addRecipient_txtb, referenceNumber02, "Reference Number");

        WebElement element01 = driver.findElement(SMSC_Dispatch_PageObjects.message_txtb);
        element01.sendKeys(Keys.CONTROL + "a");
        element01.sendKeys(Keys.BACK_SPACE);

        String dispatchBulkMessage01 = SMSC_Utils.ConfigReader.getProperty("batchMessage02");
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.message_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_Dispatch_PageObjects.message_txtb, dispatchBulkMessage01, "Message");

        js.executeScript("arguments[0].click();", addButton);
    }

    @Given("User clicks on Send Batch Messages button")
    public void user_clicks_on_send_batch_messages_button() {
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.sendBatchMessages_btn, 10);
        SMSC_Actions.ClickViaMouse(SMSC_Dispatch_PageObjects.sendBatchMessages_btn, "Send Batch Messages");
    }

    @Then("User verifies the sent message details and status as Completed under the Batch Messages")
    public void user_verifies_the_sent_message_details_and_status_as_completed_under_the_batch_messages() throws InterruptedException {
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.id_txt, 10);
        Thread.sleep(3000);
        String idText = SMSC_Actions.getElementText(SMSC_Dispatch_PageObjects.id_txt, "ID");
        actualIDText = idText.replace("ID: ", "");

        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.peek_btn, 10);
        SMSC_Actions.ClickViaMouse(SMSC_Dispatch_PageObjects.peek_btn, "Peek button");
        // Validating Completed message
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.completedMessageStatus_txt, 10);
        String completedStatus = "Completed";
        String completedStatusText = SMSC_Actions.getElementText(SMSC_Dispatch_PageObjects.completedMessageStatus_txt,"Completed").trim();
        if(!completedStatus.equals(completedStatusText)){
            SMSC_ExceptionHandler.HandleAssertion("Batch Messages not dispatched");
        }else{
            Logs.info("Batch Messages dispatched successfully and displayed status as Completed");
        }
    }

    @Then("User validates the message details on Messages page of Batch Messages")
    public void user_validates_the_message_details_on_messages_page_of_batch_messages() throws InterruptedException {
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.messagesSidebar_btn, 10);
        SMSC_Actions.ClickViaMouse(SMSC_Dispatch_PageObjects.messagesSidebar_btn, "Messages");
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.search_txtb, actualIDText, "Search Box");
        Thread.sleep(3000);
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.validateTransactionsText, 10);
        String transactionsText = SMSC_Actions.getElementText(SMSC_Dispatch_PageObjects.validateTransactionsText, "Transactions ID");
        if (!actualIDText.equals(transactionsText)){
            SMSC_ExceptionHandler.HandleAssertion("Transaction is not validated on Messages page");
        }else {
            Logs.info("Transaction is validated on Messages page");
        }
    }

    @Given("User enters the invalid Recipient numbers as {string} and Message as {string} under the Batch Messages")
    public void user_enters_the_invalid_recipient_numbers_as_and_message_as_under_the_batch_messages(String string, String string2) {
        String referenceNumber01 = SMSC_Utils.ConfigReader.getProperty("invalidReferenceNumber01");
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.addRecipient_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_Dispatch_PageObjects.addRecipient_txtb, referenceNumber01, "Reference Number");

        String dispatchBulkMessage = SMSC_Utils.ConfigReader.getProperty("batchMessage01");
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.message_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_Dispatch_PageObjects.message_txtb, dispatchBulkMessage, "Message");

        WebElement addButton = driver.findElement(By.xpath("//button[contains(@class, 'css-992vvr')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", addButton);
        WebElement element = driver.findElement(SMSC_Dispatch_PageObjects.addRecipient_txtb);
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.BACK_SPACE);

        String referenceNumber02 = SMSC_Utils.ConfigReader.getProperty("invalidReferenceNumber02");
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.addRecipient_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_Dispatch_PageObjects.addRecipient_txtb, referenceNumber02, "Reference Number");

        WebElement element01 = driver.findElement(SMSC_Dispatch_PageObjects.message_txtb);
        element01.sendKeys(Keys.CONTROL + "a");
        element01.sendKeys(Keys.BACK_SPACE);

        String dispatchBulkMessage01 = SMSC_Utils.ConfigReader.getProperty("batchMessage02");
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.message_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_Dispatch_PageObjects.message_txtb, dispatchBulkMessage01, "Message");

        js.executeScript("arguments[0].click();", addButton);
    }

    @Then("User verifies the sent message details and status as NoAction under the Batch Messages")
    public void user_verifies_the_sent_message_details_and_status_as_noAction_under_the_batch_messages() {
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.noActionMessageStatus_txt, 10);
        String errorStatus = "NoAction";
        String errorStatusText = SMSC_Actions.getElementText(SMSC_Dispatch_PageObjects.noActionMessageStatus_txt, "Error").trim();
        if(!errorStatus.equals(errorStatusText)){
            SMSC_ExceptionHandler.HandleAssertion("Bulk Messages dispatched");
        }else{
            Logs.info("Bulk Messages not dispatched and displayed status as NoAction");
        }
    }

    @Given("User clicks on Choose File and selects the valid excel Batch file")
    public void user_clicks_on_choose_file_and_selects_the_valid_excel_batch_file() throws Exception {
        SMSC_Actions.ClickViaMouse(SMSC_Dispatch_PageObjects.file_txtb, "Choose file");
        String CSVFile = "smsc_Data/Batch Recipients-Stable.csv";
        SMSC_Actions.FileUpload(SMSC_Dispatch_PageObjects.file_txtb, CSVFile);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
    }

    @Then("User verifies the sent batch message details and status as Completed under the Batch Messages")
    public void user_verifies_the_sent_batch_message_details_and_status_as_completed_under_the_batch_messages() throws InterruptedException {
        // Fetching ID text
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.id_txt, 10);
        Thread.sleep(3000);
        String idText = SMSC_Actions.getElementText(SMSC_Dispatch_PageObjects.id_txt, "ID");
        actualIDText = idText.replace("ID: ", "");

        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.peek_btn, 10);
        SMSC_Actions.ClickViaMouse(SMSC_Dispatch_PageObjects.peek_btn, "Peek button");

        // Validating Completed message
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.completedMessageStatus_txt, 10);
        String completedStatus = "Completed";
        String completedStatusText = SMSC_Actions.getElementText(SMSC_Dispatch_PageObjects.completedMessageStatus_txt,"Completed").trim();
        if(!completedStatus.equals(completedStatusText)){
            SMSC_ExceptionHandler.HandleAssertion("Batch Messages not dispatched");
        }else{
            Logs.info("Batch Messages dispatched successfully and displayed status as Completed");
        }
    }

    @Then("User validates the batch message details on Messages page of Batch Messages")
    public void user_validates_the_batch_message_details_on_messages_page_of_batch_messages() throws InterruptedException {
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.messagesSidebar_btn, 10);
        SMSC_Actions.jsClickOnElement(SMSC_Dispatch_PageObjects.messagesSidebar_btn, "Messages");
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.search_txtb, actualIDText, "Search Box");
        Thread.sleep(2000);
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.validateTransactionsText, 10);
        Thread.sleep(3000);
        String transactionsText = SMSC_Actions.getElementText(SMSC_Dispatch_PageObjects.validateTransactionsText, "Transactions ID");
        if (!actualIDText.contains(transactionsText)){
            SMSC_ExceptionHandler.HandleAssertion("Transaction is not validated on Messages page");
        }else {
            Logs.info("Transaction is validated on Messages page");
        }
    }

    @Given("User clicks on Choose File and selects the valid text Batch file")
    public void user_clicks_on_choose_file_and_selects_the_valid_text_batch_file() throws Exception {
        SMSC_Actions.ClickViaMouse(SMSC_Dispatch_PageObjects.file_txtb, "Choose file");
        String CSVFile = "smsc_Data/Batch Recipients-Stable.txt";
        SMSC_Actions.FileUpload(SMSC_Dispatch_PageObjects.file_txtb, CSVFile);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
    }

    @Given("User clicks on Choose File and selects the invalid excel Batch file")
    public void user_clicks_on_choose_file_and_selects_the_invalid_excel_batch_file() throws Exception {
        SMSC_Actions.ClickViaMouse(SMSC_Dispatch_PageObjects.file_txtb, "Choose file");
        String CSVFile = "smsc_Data/Batch Recipients-Unstable.csv";
        SMSC_Actions.FileUpload(SMSC_Dispatch_PageObjects.file_txtb, CSVFile);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
    }

    @Then("User verifies the sent batch message details and status as NoAction under the Batch Messages")
    public void user_verifies_the_sent_batch_message_details_and_status_as_noAction_under_the_batch_messages() {
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.noActionMessageStatus_txt, 10);
        String errorStatus = "NoAction";
        String errorStatusText = SMSC_Actions.getElementText(SMSC_Dispatch_PageObjects.noActionMessageStatus_txt, "Error").trim();
        if(!errorStatus.equals(errorStatusText)){
            SMSC_ExceptionHandler.HandleAssertion("Batch Messages dispatched");
        }else{
            Logs.info("Batch Messages not dispatched and displayed status as NoAction");
        }
    }

    @Given("User clicks on Choose File and selects the invalid text Batch file")
    public void user_clicks_on_choose_file_and_selects_the_invalid_text_batch_file() throws Exception {
        SMSC_Actions.ClickViaMouse(SMSC_Dispatch_PageObjects.file_txtb, "Choose file");
        String CSVFile = "smsc_Data/Batch Recipients-Unstable.txt";
        SMSC_Actions.FileUpload(SMSC_Dispatch_PageObjects.file_txtb, CSVFile);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
    }

    @Given("User enters the Recipient number as {string} and Message as {string} under the Batch Messages")
    public void user_enters_the_recipient_number_as_and_message_as_under_the_batch_messages(String string, String string2) {
        String referenceNumber01 = SMSC_Utils.ConfigReader.getProperty("invalidReferenceNumber01");
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.addRecipient_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_Dispatch_PageObjects.addRecipient_txtb, referenceNumber01, "Reference Number");

        String dispatchBulkMessage = SMSC_Utils.ConfigReader.getProperty("batchMessage01");
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.message_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_Dispatch_PageObjects.message_txtb, dispatchBulkMessage, "Message");

        WebElement addButton = driver.findElement(By.xpath("//button[contains(@class, 'css-992vvr')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", addButton);
        WebElement element = driver.findElement(SMSC_Dispatch_PageObjects.addRecipient_txtb);
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.BACK_SPACE);

        String referenceNumber02 = SMSC_Utils.ConfigReader.getProperty("invalidReferenceNumber02");
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.addRecipient_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_Dispatch_PageObjects.addRecipient_txtb, referenceNumber02, "Reference Number");

        WebElement element01 = driver.findElement(SMSC_Dispatch_PageObjects.message_txtb);
        element01.sendKeys(Keys.CONTROL + "a");
        element01.sendKeys(Keys.BACK_SPACE);

        String dispatchBulkMessage01 = SMSC_Utils.ConfigReader.getProperty("batchMessage02");
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.message_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_Dispatch_PageObjects.message_txtb, dispatchBulkMessage01, "Message");

        js.executeScript("arguments[0].click();", addButton);
    }

    @Given("User enters the Recipient number as {string} and Message as {string} under the Batch Messages to character count")
    public void user_enters_the_recipient_number_as_and_message_as_under_the_batch_messages_to_character_count(String string, String string2) {
        String referenceNumber01 = SMSC_Utils.ConfigReader.getProperty("invalidReferenceNumber01");
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.addRecipient_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_Dispatch_PageObjects.addRecipient_txtb, referenceNumber01, "Reference Number");

        String dispatchBulkMessage = SMSC_Utils.ConfigReader.getProperty("batchMessage01");
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.message_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_Dispatch_PageObjects.message_txtb, dispatchBulkMessage, "Message");

        String text = SMSC_Actions.getElementText(SMSC_Dispatch_PageObjects.message_txtb, "Messages text box");
        batchCharacterMessageCount = text.length();

        WebElement addButton = driver.findElement(By.xpath("//button[contains(@class, 'css-992vvr')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", addButton);

    }

    @Then("User validates the characters count under the Batch Messages")
    public void user_validates_the_characters_count_under_the_batch_messages() {
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.batchCharacterCount, 10);
        String text = SMSC_Actions.getElementText(SMSC_Dispatch_PageObjects.batchCharacterCount, "Characters count").trim();
        String extractedCharacterCount = text.split("/")[0].trim();
        if (!String.valueOf(batchCharacterMessageCount).equals(extractedCharacterCount)){
            SMSC_ExceptionHandler.HandleAssertion("Characters count is not validated");
        }else {
            Logs.info("Characters count is validated");
        }
    }

    @Then("User clicks on Clear button under the Batch Messages")
    public void user_clicks_on_clear_button_under_the_batch_messages() throws InterruptedException {
        Thread.sleep(3000);
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.sentTrue_txt, 10);
        sentTrue = SMSC_Actions.getElementText(SMSC_Dispatch_PageObjects.sentTrue_txt, "Sent True");
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.sentMessageClear_btn, 10);
        SMSC_Actions.ClickViaMouse(SMSC_Dispatch_PageObjects.sentMessageClear_btn, "Clear button");
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.sentTrue_txt, 10);
        sentTrueValidateText = SMSC_Actions.getElementText(SMSC_Dispatch_PageObjects.sentTrue_txt, "Sent True");
    }

    @Then("User validates message details are cleared under the Batch Messages")
    public void user_validates_message_details_are_cleared_under_the_batch_messages() {
        if (sentTrue.equals(sentTrueValidateText)) {
            SMSC_ExceptionHandler.HandleAssertion("The message text is not cleared");
        } else {
            Logs.info("The message text is cleared successfully");
        }
    }

    @Then("User validates Clear button and Clear icon functionality before dispatch message under the Batch Messages")
    public void user_validates_clear_button_and_clear_icon_functionality_before_dispatch_message_under_the_batch_messages() throws Exception {
        String referenceNumber01 = SMSC_Utils.ConfigReader.getProperty("invalidReferenceNumber01");
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.addRecipient_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_Dispatch_PageObjects.addRecipient_txtb, referenceNumber01, "Reference Number");

        String dispatchBulkMessage = SMSC_Utils.ConfigReader.getProperty("bulkMessage");
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.message_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_Dispatch_PageObjects.message_txtb, dispatchBulkMessage, "Message");

        WebElement addButton = driver.findElement(By.xpath("//button[contains(@class, 'css-992vvr')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", addButton);

        String addRecipientText = SMSC_Actions.getElementTextInput(SMSC_Dispatch_PageObjects.addRecipient_txtb, "Add Recipients").trim();
        System.out.println(addRecipientText);
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.clear_btn, 10);
        SMSC_Actions.ClickViaMouse(SMSC_Dispatch_PageObjects.clear_btn, "Clear button");

        String validateAddRecipientText = SMSC_Actions.getElementTextInput(SMSC_Dispatch_PageObjects.addRecipient_txtb, "Add Recipients").trim();
        System.out.println("After clear"+validateAddRecipientText);
        if(addRecipientText.equals(validateAddRecipientText)){
            SMSC_ExceptionHandler.HandleAssertion("The Add Recipient text box is not cleared");
        } else {
            Logs.info("The Add Recipient text box is cleared successfully");
        }

        SMSC_Actions.ClickViaMouse(SMSC_Dispatch_PageObjects.file_txtb, "Choose file");
        String CSVFile = "smsc_Data/Batch Recipients-Unstable.txt";
        SMSC_Actions.FileUpload(SMSC_Dispatch_PageObjects.file_txtb, CSVFile);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.fileUploadText, 10);
        String fileUploadText = SMSC_Actions.getElementTextInput(SMSC_Dispatch_PageObjects.fileUploadText, "File upload textbox");
        System.out.println(fileUploadText);

        SMSC_Actions.waitForElement(SMSC_Dispatch_PageObjects.bulkRecipientsClearIcon_btn, 10);
        SMSC_Actions.ClickViaMouse(SMSC_Dispatch_PageObjects.bulkRecipientsClearIcon_btn, "Clear Icon");

        String validateFileUploadText = SMSC_Actions.getElementTextInput(SMSC_Dispatch_PageObjects.fileUploadText, "File upload textbox");
        System.out.println("After clear"+validateFileUploadText);
        if(fileUploadText.equals(validateFileUploadText)){
            SMSC_ExceptionHandler.HandleAssertion("The File Upload text box is not cleared");
        } else {
            Logs.info("The File Upload text box is cleared successfully");
        }
    }
}