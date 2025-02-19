package smsc_stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import smsc_accelerators.SMSC_Actions;
import smsc_accelerators.SMSC_Base;
import smsc_pageobjects.SMSC_Channels_PageObjects;
import smsc_pageobjects.SMSC_References_PageObjects;
import smsc_utility.Logs;
import smsc_utility.SMSC_ExceptionHandler;
import smsc_utility.SMSC_Utils;

public class SMSC_Reference extends SMSC_Base {
    public static String referenceName;
    @Given("User clicks on References on the side bar")
    public void user_clicks_on_references_on_the_side_bar() {
        SMSC_Actions.waitForElementToBeVisible(SMSC_References_PageObjects.referencesSideBar_btn, 10);
        SMSC_Actions.clickOnElement(SMSC_References_PageObjects.referencesSideBar_btn, "References on the sidebar");
    }

    @Given("User clicks on Create New Reference button")
    public void user_clicks_on_create_new_reference_button() {
        SMSC_Actions.waitForElementToBeVisible(SMSC_References_PageObjects.createNewReference_btn, 10);
        SMSC_Actions.clickOnElement(SMSC_References_PageObjects.createNewReference_btn, "Create New Reference Button");
    }

    @Given("User enters Reference Name as {string} on New Reference page")
    public void user_enters_reference_name_as_on_new_reference_page(String string) {
        referenceName = SMSC_Utils.ConfigReader.getProperty("referenceName");
        SMSC_Actions.waitForElementToBeVisible(SMSC_References_PageObjects.referenceName_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_References_PageObjects.referenceName_txtb, referenceName, "Reference Name");
    }

    @Given("User enters  Reference as {string} on New Reference page")
    public void user_enters_reference_as_on_new_reference_page(String string) {
        String reference = SMSC_Utils.ConfigReader.getProperty("reference");
        SMSC_Actions.waitForElementToBeVisible(SMSC_References_PageObjects.reference_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_References_PageObjects.reference_txtb, reference, "Reference");
    }

    @Given("User selects Party Type as {string} on New Reference page")
    public void user_selects_party_type_as_on_new_reference_page(String string) throws Exception {
        String partyType = SMSC_Utils.ConfigReader.getProperty("partyType");
        SMSC_Actions.waitForElementToBeVisible(SMSC_References_PageObjects.partyType_dropdown, 10);
        SMSC_Actions.ClickViaMouse(SMSC_References_PageObjects.partyType_dropdown, "Party Type");
        SMSC_Actions.waitForElementToBeVisible(SMSC_References_PageObjects.partyTypeOption_dropdown, 10);
        SMSC_Actions.ClickViaMouse(SMSC_References_PageObjects.partyTypeOption_dropdown, partyType);
    }

    @Given("User enters Email Address as {string} on New Reference page")
    public void user_enters_email_address_as_on_new_reference_page(String string) {
        String emailAddress = SMSC_Utils.ConfigReader.getProperty("emailAddress");
        SMSC_Actions.waitForElementToBeVisible(SMSC_References_PageObjects.emailAddress_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_References_PageObjects.emailAddress_txtb, emailAddress, "Email Address");
    }

    @Given("User enters Contact Number as {string} on New Reference page")
    public void user_enters_contact_number_as_on_new_reference_page(String string) {
        String contactNumber = SMSC_Utils.ConfigReader.getProperty("contactNumber");
        SMSC_Actions.waitForElementToBeVisible(SMSC_References_PageObjects.contactNumber_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_References_PageObjects.contactNumber_txtb, contactNumber, "Contact Number");
    }

    @Given("User enters Description as {string} on New Reference page")
    public void user_enters_description_as_on_new_reference_page(String string) {
        String description = SMSC_Utils.ConfigReader.getProperty("description");
        SMSC_Actions.waitForElementToBeVisible(SMSC_References_PageObjects.description_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_References_PageObjects.description_txtb, description, "Description");
    }

    @Then("User verifies the created Reference to validate reference is created")
    public void user_verifies_the_created_reference_to_validate_reference_is_created() throws Exception {
        referenceName = SMSC_Utils.ConfigReader.getProperty("referenceName");
        SMSC_Actions.waitForElementToBeVisible(SMSC_Channels_PageObjects.search_txtb, 10);
        SMSC_Actions.ClickViaMouse(SMSC_Channels_PageObjects.search_txtb, "Search box");
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.search_txtb, referenceName, "Search Box");
        String validateReferenceCreated = SMSC_Actions.getElementText(SMSC_References_PageObjects.validateReferenceCreated_txt, "search get text");
        System.out.println(validateReferenceCreated);
        if(!validateReferenceCreated.contains(referenceName)){
            SMSC_ExceptionHandler.HandleAssertion("New Reference is not created");
        }else{
            Logs.info("New Reference is created");
        }
    }

    @Given("User enters Reference Name as {string} on New Reference page for Cancel button")
    public void user_enters_reference_name_as_on_new_reference_page_for_Cancel_button(String string) {
       String referenceNameCancel = SMSC_Utils.ConfigReader.getProperty("referenceNameCancel");
        SMSC_Actions.waitForElementToBeVisible(SMSC_References_PageObjects.referenceName_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_References_PageObjects.referenceName_txtb, referenceNameCancel, "Reference Name");
    }

    @Then("User should be redirected to the References page and no changes should be saved")
    public void user_should_be_redirected_to_the_references_page_and_no_changes_should_be_saved() {
        SMSC_Actions.waitForElementToBeVisible(SMSC_References_PageObjects.createNewReference_btn, 10);
        if(!SMSC_Actions.isElementVisible(SMSC_References_PageObjects.createNewReference_btn, "Create New Reference button")){
            SMSC_ExceptionHandler.HandleAssertion("New Reference is created");
        }else {
            Logs.info("New Reference is not created");
        }
    }

    @Given("User clicks on Create button to validate mandatory fields of New Reference")
    public void user_clicks_on_create_button_to_validate_mandatory_fields_of_new_reference() {
        SMSC_Actions.waitForElementToBeVisible(SMSC_Channels_PageObjects.create_btn, 10);
        SMSC_Actions.clickOnElement(SMSC_Channels_PageObjects.create_btn, "Create Button");
    }

    @Then("user should see error messages for all the reference mandatory fields")
    public void user_should_see_error_messages_for_all_the_reference_mandatory_fields() {
        SMSC_Actions.waitForElementToBeVisible(SMSC_References_PageObjects.errorReferenceName_txt, 10);
        if(!SMSC_Actions.isElementVisible(SMSC_References_PageObjects.errorReferenceName_txt, "Name is required")){
            SMSC_ExceptionHandler.HandleAssertion("Name is required element is not visible");
        }else{
            Logs.info("Name is required element is visible");
        }
        SMSC_Actions.waitForElementToBeVisible(SMSC_References_PageObjects.errorReference_txt, 10);
        if(!SMSC_Actions.isElementVisible(SMSC_References_PageObjects.errorReference_txt, "Reference is required")){
            SMSC_ExceptionHandler.HandleAssertion("Reference is required element is not visible");
        }else{
            Logs.info("Reference is required element is visible");
        }
        SMSC_Actions.waitForElementToBeVisible(SMSC_References_PageObjects.errorPartyType_txt, 10);
        if(!SMSC_Actions.isElementVisible(SMSC_References_PageObjects.errorPartyType_txt, "Party Type is required")){
            SMSC_ExceptionHandler.HandleAssertion("Party Type is required element is not visible");
        }else{
            Logs.info("Party Type is required element is visible");
        }
        SMSC_Actions.waitForElementToBeVisible(SMSC_References_PageObjects.errorEmailAddress_txt, 10);
        if(!SMSC_Actions.isElementVisible(SMSC_References_PageObjects.errorEmailAddress_txt, "Email is required")){
            SMSC_ExceptionHandler.HandleAssertion("Email is required element is not visible");
        }else{
            Logs.info("Email is required element is visible");
        }
        SMSC_Actions.waitForElementToBeVisible(SMSC_References_PageObjects.errorContactNumber_txt, 10);
        if(!SMSC_Actions.isElementVisible(SMSC_References_PageObjects.errorContactNumber_txt, "Contact is required")){
            SMSC_ExceptionHandler.HandleAssertion("Contact is required element is not visible");
        }else{
            Logs.info("Contact is required element is visible");
        }
        SMSC_Actions.waitForElementToBeVisible(SMSC_References_PageObjects.errorDescription_txt, 10);
        if(!SMSC_Actions.isElementVisible(SMSC_References_PageObjects.errorDescription_txt, "Description is required")){
            SMSC_ExceptionHandler.HandleAssertion("Description is required element is not visible");
        }else{
            Logs.info("Description is required element is visible");
        }
    }

    @Given("User clicks on Edit button on References page")
    public void user_clicks_on_edit_button_on_references_page() {
        SMSC_Actions.waitForElementToBeVisible(SMSC_Channels_PageObjects.search_txtb, 10);
        String text = SMSC_Utils.ConfigReader.getProperty("referenceName");
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.search_txtb, text, "Search Box");
        SMSC_Actions.clickOnElement(SMSC_Channels_PageObjects.edit_btn, "Edit button");
    }

    @Given("User updates the Description field as {string}")
    public void user_updates_the_description_field_as(String string) {
        String updateDescription = SMSC_Utils.ConfigReader.getProperty("updateReference");
        SMSC_Actions.waitForElementToBeVisible(SMSC_References_PageObjects.description_txtb, 10);
        SMSC_Actions.jsClickOnElement(SMSC_References_PageObjects.description_txtb, "Description");
        SMSC_Actions.clearTextbox(SMSC_References_PageObjects.description_txtb, "Description");
        WebElement element = driver.findElement(SMSC_References_PageObjects.description_txtb);
        element.sendKeys(Keys.CONTROL + "a"); // Select all text
        element.sendKeys(Keys.BACK_SPACE);
        SMSC_Actions.typeInTextBox(SMSC_References_PageObjects.description_txtb, updateDescription, "Description");
    }

    @Then("User validates the updates of the updated reference")
    public void user_validates_the_updates_of_the_updated_reference() {
        SMSC_Actions.waitForElementToBeVisible(SMSC_Channels_PageObjects.search_txtb, 10);
        String text = SMSC_Utils.ConfigReader.getProperty("referenceName");
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.search_txtb, text, "Search Box");
        SMSC_Actions.clickOnElement(SMSC_Channels_PageObjects.edit_btn, "Edit button");
        String fetchedDescriptionText = SMSC_Actions.getElementText(SMSC_References_PageObjects.description_txtb, "Updated Provider");
        System.out.println(fetchedDescriptionText);
        String updateDescriptionText = SMSC_Utils.ConfigReader.getProperty("updateReference");
        System.out.println(updateDescriptionText);
        if (!fetchedDescriptionText.contains(updateDescriptionText)){
            SMSC_ExceptionHandler.HandleAssertion("Description is not updated");
        }else {
            Logs.info("Description is updated");
        }
    }

    @Given("User enters valid filter criteria in the search box on references page")
    public void user_enters_valid_filter_criteria_in_the_search_box_on_references_page() {
        String searchContent = SMSC_Utils.ConfigReader.getProperty("referenceName");
        SMSC_Actions.waitForElementToBeVisible(SMSC_Channels_PageObjects.search_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.search_txtb, searchContent, "Search Box");
    }

    @Then("User validates the valid search results on references page")
    public void user_validates_the_valid_search_results_on_references_page() {
        String searchContent = SMSC_Utils.ConfigReader.getProperty("referenceName");
        SMSC_Actions.waitForElementToBeVisible(SMSC_References_PageObjects.validateReferenceCreated_txt, 10);
        String searchResults = SMSC_Actions.getElementText(SMSC_References_PageObjects.validateReferenceCreated_txt, "Search validate");
        if (!searchResults.contains(searchContent)){
            SMSC_ExceptionHandler.HandleAssertion("Search results not validated");
        }else{
            Logs.info("Search results validated");
        }
    }

    @Then("User enters invalid filter criteria in the search box on references page")
    public void user_enters_invalid_filter_criteria_in_the_search_box_on_references_page() {
        String invalidSearch = SMSC_Utils.ConfigReader.getProperty("invalidSearch");
        SMSC_Actions.waitForElementToBeVisible(SMSC_Channels_PageObjects.search_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.search_txtb, invalidSearch, "Search Box");
    }

    @Then("User validates the error message as {string} on references page")
    public void user_validates_the_error_message_as_on_references_page(String string) {
        SMSC_Actions.waitForElementToBeVisible(SMSC_References_PageObjects.searchErrorMessage, 10);
        if(!SMSC_Actions.isElementVisible(SMSC_References_PageObjects.searchErrorMessage, "Invalid search")){
            SMSC_ExceptionHandler.HandleAssertion("No References found error message is not displayed");
        }else{
            Logs.info("No References found error message is displayed");
        }
        SMSC_Actions.waitForElementToBeVisible(SMSC_Channels_PageObjects.search_txtb, 10);
        SMSC_Actions.clearTextbox(SMSC_Channels_PageObjects.search_txtb, "Search box");
        WebElement element = driver.findElement(SMSC_Channels_PageObjects.search_txtb);
        element.sendKeys(Keys.CONTROL + "a"); // Select all text
        element.sendKeys(Keys.BACK_SPACE);
    }
}