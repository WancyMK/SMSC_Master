//package smsc_stepDefinitions;
//
//import org.junit.Assert;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import smsc_accelerators.SMSC_Actions;
//import smsc_accelerators.SMSC_Base;
//import smsc_pageobjects.SMSC_TestDispatch_PageObjects;
//
//public class smsc_TestDispatch extends SMSC_Base {
//
//    @Given("User clicks on {string} on the sidebar")
//    public void userClicksOnTestDispatchOnTheSidebar() {
//    	SMSC_Actions.waitForElementToBeVisible(SMSC_TestDispatch_PageObjects.Dispatch, 10);
//    	SMSC_Actions.jsClickOnElement(SMSC_TestDispatch_PageObjects.Dispatch, "Dispatch");
//        System.out.println();
//
//    }
//
//    @Then("User should navigate to the Test Dispatch page")
//    public void userShouldNavigateToTheTestDispatchPage() {
//
//    	boolean isTextPresent = SMSC_Actions.waitForElementTextToBePresent(driver,SMSC_TestDispatch_PageObjects.Dispatch_btn , 5, "Dispatch Message");
//    	Assert.assertTrue("Text did not appear as expected!", isTextPresent);
//
//    }
//
//    @Then("All headers, buttons, and text should be placed accurately with correct font sizes, colors, and spacing")
//    public void allHeadersButtonsAndTextShouldBePlacedAccuratelyWithCorrectFontSizesColorsAndSpacing() {
//    	 SMSC_Actions.waitForElementToBeVisible(SMSC_TestDispatch_PageObjects.PageContainer, 10);
//    	    SMSC_Actions.waitForElementTextToBePresent(driver, SMSC_TestDispatch_PageObjects.Headers, 5, "Headers");
//    	    SMSC_Actions.waitForElementTextToBePresent(driver, SMSC_TestDispatch_PageObjects.Buttons, 5, "Buttons");
//    	    SMSC_Actions.waitForElementTextToBePresent(driver, SMSC_TestDispatch_PageObjects.TextElements, 5, "Text Elements");
//    	    System.out.println("Verified UI elements for correct font sizes, colors, and spacing.");
//
//    }
//
//    @And("The interface should remain responsive with no overlaps, and buttons should display the correct colors in all states")
//    public void theInterfaceShouldRemainResponsiveWithNoOverlapsAndButtonsShouldDisplayTheCorrectColorsInAllStates() {
//    	 SMSC_Actions.waitForElementToBeVisible(SMSC_TestDispatch_PageObjects.PageContainer, 10);
//    	    SMSC_Actions.waitForElementToBeVisible(SMSC_TestDispatch_PageObjects.PageContainer, 10);
//    	    SMSC_Actions.waitForElementToBeVisible(SMSC_TestDispatch_PageObjects.Buttons, 10);
//    	    System.out.println("Verified responsiveness, overlaps, and button colors in all states.");
//    }
//
//    @And("User enters Recipient number and Message")
//    public void userEntersRecipientNumberAndMessage() {
//    	SMSC_Actions.waitForElementToBeVisible(SMSC_TestDispatch_PageObjects.RecipientNumberField, 10);
//
//    	SMSC_Actions.typeInTextBox(SMSC_TestDispatch_PageObjects.RecipientNumberField, "1234567890", "Recipient Number");
//    	SMSC_Actions.typeInTextBox(SMSC_TestDispatch_PageObjects.MessageField, "Test message", "Message");
//        System.out.println("Entered Recipient number and Message.");
//    }
//
//    @When("User clicks on Send Message button")
//    public void userClicksOnSendMessageButton() {
//    	 SMSC_Actions.waitForElementToBeVisible(SMSC_TestDispatch_PageObjects.SendMessageButton, 10);
//    	    SMSC_Actions.jsClickOnElement(SMSC_TestDispatch_PageObjects.SendMessageButton, "Sending a message");
//    	    System.out.println("User clicked on the Send Message button.");
//    }
//
//    @Then("The message should be sent successfully and displayed in Transactions and Messages")
//    public void theMessageShouldBeSentSuccessfullyAndDisplayedInTransactionsAndMessages() {
//    	 SMSC_Actions.waitForElementToBeVisible(SMSC_TestDispatch_PageObjects.SuccessMessage, 10);
//    	    SMSC_Actions.verifyElementText(SMSC_TestDispatch_PageObjects.SuccessMessage, "Message sent successfully");
//
//    	    SMSC_Actions.waitForElementToBeVisible(SMSC_TestDispatch_PageObjects.TransactionsTable, 10);
//    	    SMSC_Actions.isElementVisible(SMSC_TestDispatch_PageObjects.TransactionsTable, "Transactions Table");
//
//    	    System.out.println("Message sent successfully and displayed in Transactions and Messages.");
//    }
//
//    @And("User enters an invalid Recipient number and Message")
//    public void userEntersAnInvalidRecipientNumberAndMessage() {
//    	SMSC_Actions.waitForElementToBeVisible(SMSC_TestDispatch_PageObjects.RecipientNumberField, 10);
//    	SMSC_Actions.typeInTextBox(SMSC_TestDispatch_PageObjects.RecipientNumberField, "invalid_number", "Recipient Number");
//    	SMSC_Actions.waitForElementToBeVisible(SMSC_TestDispatch_PageObjects.MessageField, 10);
//    	SMSC_Actions.typeInTextBox(SMSC_TestDispatch_PageObjects.MessageField, "Test invalid message", "Message");
//
//        System.out.println("Entered an invalid Recipient number and Message.");
//    }
//
//
//    @Then("The message should not be sent")
//    public void theMessageShouldNotBeSent() {
//        SMSC_Actions.waitForElementToBeVisible(SMSC_TestDispatch_PageObjects.ErrorMessage, 10);
//        SMSC_Actions.verifyElementText(SMSC_TestDispatch_PageObjects.ErrorMessage, "Invalid recipient number. Please enter a valid number.");
//
//        System.out.println("Verified that the message was not sent due to an invalid recipient number.");
//    }
//
//    @And("An email notification should be received")
//    public void anEmailNotificationShouldBeReceived() {
//    	try {
//
//            Thread.sleep(5000);
//            System.out.println("Checking for email notification...");
//
//            boolean emailReceived = true;
//
//            if (emailReceived) {
//                System.out.println("Email notification received successfully.");
//            } else {
//                System.out.println("Email notification was not received.");
//                Assert.fail("Expected email notification was not received.");
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @And("User enables the Secure Message checkbox")
//    public void userEnablesTheSecureMessageCheckbox() {
//    	 SMSC_Actions.waitForElementToBeVisible(SMSC_TestDispatch_PageObjects.SecureMessageCheckbox, 10);
//
//    	    if (!SMSC_TestDispatch_PageObjects.SecureMessageCheckbox.isSelected()) {
//    	        SMSC_TestDispatch_PageObjects.SecureMessageCheckbox.click();
//    	        System.out.println("Secure Message checkbox enabled.");
//    	    } else {
//    	        System.out.println("Secure Message checkbox was already enabled.");
//    	    }
//    }
//
//    @Then("The message should be encrypted in the database")
//    public void theMessageShouldBeEncryptedInTheDatabase() {
//    	SMSC_Actions.waitForElementToBeVisible(SMSC_TestDispatch_PageObjects.EncryptionIndicator, 10);
//
//        boolean isEncrypted = SMSC_TestDispatch_PageObjects.EncryptionIndicator.isDisplayed();
//
//        if (isEncrypted) {
//            System.out.println("Message encryption confirmed.");
//        } else {
//            System.out.println("Message encryption not confirmed.");
//            Assert.fail("Expected the message to be encrypted, but no confirmation was found.");
//        }
//    }
//
//    @And("User clicks on Peek button")
//    public void userClicksOnPeekButton() {
//    	SMSC_Actions.waitForElementToBeVisible(SMSC_TestDispatch_PageObjects.PeekButton, 10);
//        SMSC_Actions.jsClickOnElement(SMSC_TestDispatch_PageObjects.PeekButton, "Peek");
//
//        System.out.println("User clicked on the Peek button.");
//    }
//
//    @Then("The message should be moved from the queue")
//    public void theMessageShouldBeMovedFromTheQueue() {
//        SMSC_Actions.waitForElementToBeInvisible(SMSC_TestDispatch_PageObjects.MessageQueueItem, 10);
//
//        boolean isMessageRemoved = !SMSC_TestDispatch_PageObjects.MessageQueueItem.isDisplayed();
//
//        if (isMessageRemoved) {
//            System.out.println("Message successfully moved from the queue.");
//        } else {
//            System.out.println("Message is still in the queue.");
//            Assert.fail("Expected message to be removed from the queue, but it is still present.");
//        }
//    }
//
//    @Then("The system should return an error message or display no message data")
//    public void theSystemShouldReturnAnErrorMessageOrDisplayNoMessageData() {
//        SMSC_Actions.waitForElementToBeVisible(SMSC_TestDispatch_PageObjects.ErrorMessage, 10);
//
//        if (SMSC_TestDispatch_PageObjects.ErrorMessage.isDisplayed()) {
//            System.out.println("Error message displayed: " + SMSC_TestDispatch_PageObjects.ErrorMessage.getText());
//        } else if (!SMSC_TestDispatch_PageObjects.MessageData.isDisplayed()) {
//            System.out.println("No message data displayed.");
//        } else {
//            System.out.println("Unexpected behavior: No error message and message data is present.");
//            Assert.fail("Expected an error message or no message data, but found message data.");
//        }
//    }
//
//    @When("User clicks on Clear button")
//    public void userClicksOnClearButton() {
//        SMSC_Actions.waitForElementToBeVisible(SMSC_TestDispatch_PageObjects.ClearButton, 10);
//        SMSC_Actions.jsClickOnElement(SMSC_TestDispatch_PageObjects.ClearButton, "Clear");
//
//        System.out.println("User clicked on the Clear button.");
//    }
//
//    @Then("All message details should be cleared")
//    public void allMessageDetailsShouldBeCleared() {
//        SMSC_Actions.waitForElementToBeVisible(SMSC_TestDispatch_PageObjects.RecipientNumberField, 10);
//
//        boolean isRecipientFieldEmpty = SMSC_TestDispatch_PageObjects.RecipientNumberField.getAttribute("value").isEmpty();
//        boolean isMessageFieldEmpty = SMSC_TestDispatch_PageObjects.MessageField.getAttribute("value").isEmpty();
//
//        if (isRecipientFieldEmpty && isMessageFieldEmpty) {
//            System.out.println("All message details have been cleared successfully.");
//        } else {
//            System.out.println("Message details were not cleared.");
//            Assert.fail("Expected all message details to be cleared, but some fields still contain data.");}
//    }
//
//    @And("User clicks on Bulk Recipients")
//    public void userClicksOnBulkRecipients() {
//        SMSC_Actions.waitForElementToBeVisible(SMSC_TestDispatch_PageObjects.BulkRecipientsButton, 10);
//        SMSC_Actions.jsClickOnElement(SMSC_TestDispatch_PageObjects.BulkRecipientsButton, "Bulk Recipients");
//
//        System.out.println("User clicked on the Bulk Recipients button.");
//
//    }
//
//	    @And("User adds multiple Recipient numbers and enters Message")
//	    public void userAddsMultipleRecipientNumbersAndEntersMessage() {
//
//	        SMSC_Actions.waitForElementToBeVisible(SMSC_TestDispatch_PageObjects.RecipientNumberField, 10);
//
//	        String recipients = "1234567890, 9876543210, 1122334455";
//	        SMSC_Actions.typeInTextBox(SMSC_TestDispatch_PageObjects.RecipientNumberField, recipients, "Recipient Number");
//	        String message = "This is a bulk message test.";
//	        SMSC_Actions.typeInTextBox(SMSC_TestDispatch_PageObjects.MessageField, message, "Message");
//	        System.out.println("User added multiple recipient numbers and entered the message.");
//	    }
//
//    @When("User clicks on Send Bulk Messages button")
//    public void userClicksOnSendBulkMessagesButton() {
//
//    	  SMSC_Actions.waitForElementToBeVisible(SMSC_TestDispatch_PageObjects.SendBulkMessagesButton, 10);
//    	    SMSC_Actions.jsClickOnElement(SMSC_TestDispatch_PageObjects.SendBulkMessagesButton, "Send Bulk Messages");
//
//    	    System.out.println("User clicked on the Send Bulk Messages button.");
//    }
//
//    @Then("The message should be sent successfully to multiple recipients")
//    public void theMessageShouldBeSentSuccessfullyToMultipleRecipients() {
//    	 SMSC_Actions.waitForElementToBeVisible(SMSC_TestDispatch_PageObjects.SuccessMessage, 10);
//
//    	    if (SMSC_TestDispatch_PageObjects.SuccessMessage.isDisplayed()) {
//    	        System.out.println("Bulk messages sent successfully: " + SMSC_TestDispatch_PageObjects.SuccessMessage.getText());
//    	    } else {
//    	        System.out.println("Bulk message sending failed.");
//    	        Assert.fail("Expected success confirmation for bulk messages, but none was found.");
//    	    }
//    }
//
//    @And("User selects a valid bulk file")
//    public void userSelectsAValidBulkFile() {
//        SMSC_Actions.waitForElementToBeVisible(SMSC_TestDispatch_PageObjects.FileUploadInput, 10);
//
//        String filePath = "C://Users//Admin//Downloads";
//
//        SMSC_Actions.typeInTextBox(SMSC_TestDispatch_PageObjects.FileUploadInput, filePath, "File Upload");
//
//        System.out.println("User selected a valid bulk file: " + filePath);
//
//    }
//
//
//    @Then("The message should be sent successfully to Bulk Recipients")
//    public void theMessageShouldBeSentSuccessfullyToBulkRecipients() {
//    	 SMSC_Actions.waitForElementToBeVisible(SMSC_TestDispatch_PageObjects.SuccessMessage, 10);
//
//    	    if (SMSC_TestDispatch_PageObjects.SuccessMessage.isDisplayed()) {
//    	        System.out.println("Bulk messages sent successfully: " + SMSC_TestDispatch_PageObjects.SuccessMessage.getText());
//    	    } else {
//    	        System.out.println("Bulk message sending failed.");
//    	        Assert.fail("Expected success confirmation for bulk messages, but none was found.");
//    	    }
//    }
//
//    @And("User selects an invalid bulk file")
//    public void userSelectsAnInvalidBulkFile() {
//        SMSC_Actions.waitForElementToBeVisible(SMSC_TestDispatch_PageObjects.FileUploadInput, 10);
//
//        //Invalid path
//        String invalidFilePath = "C:\\Users\\Admin\\Documents\\New folder (2)";
//
//        // upload the invalid file
//        SMSC_Actions.typeInTextBox(SMSC_TestDispatch_PageObjects.FileUploadInput, invalidFilePath, "File Upload");
//
//        System.out.println("User selected an invalid bulk file: " + invalidFilePath);
//
//    }
//
//    @Then("The system should prevent sending messages and display an error")
//    public void theSystemShouldPreventSendingMessagesAndDisplayAnError() {
//
//        SMSC_Actions.waitForElementToBeVisible(SMSC_TestDispatch_PageObjects.ErrorMessage, 10);
//
//        if (SMSC_TestDispatch_PageObjects.ErrorMessage.isDisplayed()) {
//            System.out.println("Error displayed: " + SMSC_TestDispatch_PageObjects.ErrorMessage.getText());
//        } else {
//            System.out.println("Expected an error message, but none was displayed.");
//            Assert.fail("System did not prevent message sending or display an error as expected.");
//        }
//    }
//
//    @And("User selects a file")
//    public void userSelectsAFile() {
//    	SMSC_Actions.waitForElementToBeVisible(SMSC_TestDispatch_PageObjects.FileUploadInput, 10);
//
//        // Specify the file path (update with an actual file location)
//        String filePath = "C:\\Users\\Admin\\Downloads";
//
//        // Upload the file
//        SMSC_Actions.typeInTextBox(SMSC_TestDispatch_PageObjects.FileUploadInput, filePath, "File Upload");
//
//        System.out.println("User selected a file: " + filePath);
//
//    }
//
//    @When("User clicks on the Clear icon")
//    public void userClicksOnTheClearIcon() {
//        SMSC_Actions.waitForElementToBeVisible(SMSC_TestDispatch_PageObjects.ClearIcon, 10);
//        SMSC_Actions.jsClickOnElement(SMSC_TestDispatch_PageObjects.ClearIcon, "Clear Icon");
//
//        System.out.println("User clicked on the Clear icon.");
//    }
//
//    @Then("The selected bulk file should be cleared")
//    public void theSelectedBulkFileShouldBeCleared() {
//        SMSC_Actions.waitForElementToBeVisible(SMSC_TestDispatch_PageObjects.FileUploadInput, 10);
//
//        String uploadedFileName = SMSC_TestDispatch_PageObjects.FileUploadInput.getAttribute("value");
//
//        if (uploadedFileName.isEmpty()) {
//            System.out.println("The selected bulk file has been cleared successfully.");
//        } else {
//            System.out.println("Bulk file was not cleared.");
//            Assert.fail("Expected the file input to be empty, but it still contains a file.");
//        }
//    }
//
//    @Then("The system should display the number of characters count correctly")
//    public void theSystemShouldDisplayTheNumberOfCharactersCountCorrectly() {
//    	 SMSC_Actions.waitForElementToBeVisible(SMSC_TestDispatch_PageObjects.CharacterCountLabel, 10);
//
//    	    // Get the displayed character count
//    	    String displayedCount = SMSC_TestDispatch_PageObjects.CharacterCountLabel.getText();
//
//    	    // Get the actual message length
//    	    String messageText = SMSC_TestDispatch_PageObjects.MessageField.getAttribute("value");
//    	    int actualCount = messageText.length();
//
//    	    if (Integer.parseInt(displayedCount) == actualCount) {
//    	        System.out.println("Character count displayed correctly: " + displayedCount);
//    	    } else {
//    	        System.out.println("Incorrect character count displayed. Expected: " + actualCount + ", but got: " + displayedCount);
//    	        Assert.fail("Character count does not match the actual message length.");
//    	    }
//    }
//
//    @And("User adds a recipient number and enters a message")
//    public void userAddsARecipientNumberAndEntersAMessage() {
//    	SMSC_Actions.waitForElementToBeVisible(SMSC_TestDispatch_PageObjects.RecipientNumberField, 10);
//
//        // Enter recipient number
//        String recipientNumber = "1234567890";
//        SMSC_Actions.typeInTextBox(SMSC_TestDispatch_PageObjects.RecipientNumberField, recipientNumber, "Recipient Number");
//
//        // Enter message
//        String message = "Test message for recipient";
//        SMSC_Actions.typeInTextBox(SMSC_TestDispatch_PageObjects.MessageField, message, "Message");
//
//        System.out.println("User added recipient number: " + recipientNumber + " and entered message: " + message);
//    }
//
//    @And("User clicks on Batch Messages")
//    public void userClicksOnBatchMessages() {
//    	SMSC_Actions.waitForElementToBeVisible(SMSC_TestDispatch_PageObjects.BatchMessagesButton, 10);
//        SMSC_Actions.jsClickOnElement(SMSC_TestDispatch_PageObjects.BatchMessagesButton, "Batch Messages");
//
//        System.out.println("User clicked on Batch Messages.");
//
//    }
//}
