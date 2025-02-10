package smsc_stepDefinitions;

import io.cucumber.java.en.*;
import smsc_accelerators.SMSC_Actions;
import smsc_pageobjects.SMSC_Channels_PageObjects;
import smsc_pageobjects.SMSC_References_PageObjects;
import smsc_utility.Logs;
import smsc_utility.SMSC_ExceptionHandler;
import smsc_utility.SMSC_Utils;

public class SMSC_Reference {
    public static String referenceName;
    @Given("User clicks on References on the side bar")
    public void user_clicks_on_references_on_the_side_bar() {
        SMSC_Actions.waitForElement(SMSC_References_PageObjects.referencesSideBar, 10);
        SMSC_Actions.clickOnElement(SMSC_References_PageObjects.referencesSideBar, "References on the sidebar");
    }

    @Given("User clicks on Create New Reference button")
    public void user_clicks_on_create_new_reference_button() {
        SMSC_Actions.waitForElement(SMSC_References_PageObjects.createNewReferenceButton, 10);
        SMSC_Actions.clickOnElement(SMSC_References_PageObjects.createNewReferenceButton, "Create New Reference Button");
    }

    @Given("User enters Reference Name as {string} on New Reference page")
    public void user_enters_reference_name_as_on_new_reference_page(String string) {
        referenceName = SMSC_Utils.ConfigReader.getProperty("referenceName");
        SMSC_Actions.waitForElement(SMSC_References_PageObjects.referenceName, 10);
        SMSC_Actions.typeInTextBox(SMSC_References_PageObjects.referenceName, referenceName, "Reference Name");
    }

    @Given("User enters  Reference as {string} on New Reference page")
    public void user_enters_reference_as_on_new_reference_page(String string) {
        String reference = SMSC_Utils.ConfigReader.getProperty("reference");
        SMSC_Actions.waitForElement(SMSC_References_PageObjects.reference, 10);
        SMSC_Actions.typeInTextBox(SMSC_References_PageObjects.reference, reference, "Reference");
    }

    @Given("User selects Party Type as {string} on New Reference page")
    public void user_selects_party_type_as_on_new_reference_page(String string) throws Exception {
        String partyType = SMSC_Utils.ConfigReader.getProperty("partyType");
        SMSC_Actions.waitForElement(SMSC_References_PageObjects.partyType, 10);
        SMSC_Actions.ClickViaMouse(SMSC_References_PageObjects.partyType, "Party Type");
        SMSC_Actions.waitForElement(SMSC_References_PageObjects.partyTypeOption, 10);
        SMSC_Actions.ClickViaMouse(SMSC_References_PageObjects.partyTypeOption, partyType);
    }

    @Given("User enters Email Address as {string} on New Reference page")
    public void user_enters_email_address_as_on_new_reference_page(String string) {
        String emailAddress = SMSC_Utils.ConfigReader.getProperty("emailAddress");
        SMSC_Actions.waitForElement(SMSC_References_PageObjects.emailAddress, 10);
        SMSC_Actions.typeInTextBox(SMSC_References_PageObjects.emailAddress, emailAddress, "Email Address");
    }

    @Given("User enters Contact Number as {string} on New Reference page")
    public void user_enters_contact_number_as_on_new_reference_page(String string) {
        String contactNumber = SMSC_Utils.ConfigReader.getProperty("contactNumber");
        SMSC_Actions.waitForElement(SMSC_References_PageObjects.contactNumber, 10);
        SMSC_Actions.typeInTextBox(SMSC_References_PageObjects.contactNumber, contactNumber, "Contact Number");
    }

    @Given("User enters Description as {string} on New Reference page")
    public void user_enters_description_as_on_new_reference_page(String string) {
        String description = SMSC_Utils.ConfigReader.getProperty("description");
        SMSC_Actions.waitForElement(SMSC_References_PageObjects.description, 10);
        SMSC_Actions.typeInTextBox(SMSC_References_PageObjects.description, description, "Description");
    }

    @Then("User verifies the created Reference to validate reference is created")
    public void user_verifies_the_created_reference_to_validate_reference_is_created() {
        referenceName = SMSC_Utils.ConfigReader.getProperty("referenceName");
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.search_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.search_txtb, referenceName, "Search Box");
        String validateReferenceCreated = SMSC_Actions.getText(SMSC_References_PageObjects.validateReferenceCreated, "search get text");
        System.out.println(validateReferenceCreated);
        if(!validateReferenceCreated.contains(referenceName)){
            SMSC_ExceptionHandler.HandleAssertion("New Reference is not created");
        }else{
            Logs.info("New Reference is created");
        }
    }

    @Given("User enters Reference Name as {string} on New Reference page for Cancel button")
    public void user_enters_reference_name_as_on_new_reference_page_for_Cancel_button(String string) {
        referenceName = SMSC_Utils.ConfigReader.getProperty("referenceName");
        SMSC_Actions.waitForElement(SMSC_References_PageObjects.referenceName, 10);
        SMSC_Actions.typeInTextBox(SMSC_References_PageObjects.referenceName, referenceName, "Reference Name");
    }

    @Then("User should be redirected to the References page and no changes should be saved")
    public void user_should_be_redirected_to_the_references_page_and_no_changes_should_be_saved() {

    }

    @Given("User clicks on Create button to validate mandatory fields of New Reference")
    public void user_clicks_on_create_button_to_validate_mandatory_fields_of_new_reference() {
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.create_btn, 10);
        SMSC_Actions.clickOnElement(SMSC_Channels_PageObjects.create_btn, "Create Button");
    }

    @Then("user should see error messages for all the reference mandatory fields")
    public void user_should_see_error_messages_for_all_the_reference_mandatory_fields() {

    }

    @Given("User clicks on Edit button on References page")
    public void user_clicks_on_edit_button_on_references_page() {

    }

    @Given("User updates the Description field as {string}")
    public void user_updates_the_description_field_as(String string) {

    }

    @Then("User validates the updates of the updated reference")
    public void user_validates_the_updates_of_the_updated_reference() {

    }

    @Given("User enters valid filter criteria in the search box on references page")
    public void user_enters_valid_filter_criteria_in_the_search_box_on_references_page() {

    }

    @Then("User validates the valid search results on references page")
    public void user_validates_the_valid_search_results_on_references_page() {

    }

    @Then("User enters invalid filter criteria in the search box on references page")
    public void user_enters_invalid_filter_criteria_in_the_search_box_on_references_page() {

    }

    @Then("User validates the error message as {string} on references page")
    public void user_validates_the_error_message_as_on_references_page(String string) {

    }
}