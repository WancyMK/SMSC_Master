package smsc_stepDefinitions;

import io.cucumber.java.en.*;
import smsc_accelerators.SMSC_Actions;
import smsc_pageobjects.SMSC_Channels_PageObjects;
import smsc_utility.SMSC_ExceptionHandler;
import smsc_utility.SMSC_Utils;

public class SMSC_Channels {
    @Given("User clicks on Channels on the side bar")
    public void user_clicks_on_channels_on_the_side_bar() {
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.channelSideBar, 10);
        SMSC_Actions.clickOnElement(SMSC_Channels_PageObjects.channelSideBar, "Channels on the sidebar");
    }

    @Given("User clicks on Create New Channel button")
    public void user_clicks_on_create_new_channel_button() {
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.createNewChannelButton, 10);
        SMSC_Actions.clickOnElement(SMSC_Channels_PageObjects.createNewChannelButton, "Create New Channel Button");
    }
    @Given("User enters Channel Name as {string} on New Channel page")
    public void user_enters_channel_name_as_on_new_channel_page(String string) {
        String channelName = SMSC_Utils.ConfigReader.getProperty("channelName");
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.channelName, 10);
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.channelName, channelName, "Channel Name");
    }

    @Given("User enters Host as {string} on New Channel page")
    public void user_enters_host_as_on_new_channel_page(String string) {
        String host = SMSC_Utils.ConfigReader.getProperty("host");
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.host, 10);
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.host, host, "Host");
    }

    @Given("User enters Port as {string} on New Channel page")
    public void user_enters_port_as_on_new_channel_page(String string) {
        String port = SMSC_Utils.ConfigReader.getProperty("port");
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.port, 10);
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.port, port, "Port");
    }

    @Given("User enters System ID as {string} on New Channel page")
    public void user_enters_system_id_as_on_new_channel_page(String string) {
        String systemID = SMSC_Utils.ConfigReader.getProperty("systemID");
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.systemID, 20);
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.systemID, systemID, "System ID");
    }

    @Given("User enters Password as {string} on New Channel page")
    public void user_enters_password_as_on_new_channel_page(String string) {
        String password = SMSC_Utils.ConfigReader.getProperty("password");
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.password, 10);
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.password, password, "Password");
    }

    @Given("User enters Service Type as {string} on New Channel page")
    public void user_enters_service_type_as_on_new_channel_page(String string) {
        String serviceType = SMSC_Utils.ConfigReader.getProperty("serviceType");
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.serviceType, 10);
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.serviceType, serviceType, "Service Type");
    }

    @Given("User enters Priority as {string} on New Channel page")
    public void user_enters_priority_as_on_new_channel_page(String string) {
        String priority = SMSC_Utils.ConfigReader.getProperty("priority");
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.priority, 10);
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.priority, priority, "Priority");
    }

    @Given("User enters Source Address as {string} on New Channel page")
    public void user_enters_source_address_as_on_new_channel_page(String string) {
        String sourceAddress = SMSC_Utils.ConfigReader.getProperty("sourceAddress");
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.sourceAddress, 10);
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.sourceAddress, sourceAddress, "Source Address");
    }

    @Given("User selects Status as {string} on New Channel page")
    public void user_selects_status_as_on_new_channel_page(String string) {

    }

    @Given("User enters Provider as {string} on New Channel page")
    public void user_enters_provider_as_on_new_channel_page(String string) {
        String provider = SMSC_Utils.ConfigReader.getProperty("provider");
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.provider, 10);
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.provider, provider, "Provider");
    }

    @Given("User selects Multi For Bulk as {string} on New Channel page")
    public void user_selects_multi_for_bulk_as_on_new_channel_page(String string) {

    }

    @Given("User enters Filters as {string} on New Channel page")
    public void user_enters_filters_as_on_new_channel_page(String string) {
        String filter = SMSC_Utils.ConfigReader.getProperty("filters");
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.filters, 10);
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.filters, filter, "Filters");
    }

    @Given("User clicks on Create button")
    public void user_clicks_on_create_button() {
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.createButton, 10);
        SMSC_Actions.clickOnElement(SMSC_Channels_PageObjects.createButton, "Create Button");
    }

    @Then("User verifies the created Channel to validate channel is created")
    public void user_verifies_the_created_channel_to_validate_channel_is_created() {

    }

    @Given("User enters Channel Name as {string} on New Channel page for Cancel button")
    public void user_enters_channel_name_as_on_new_channel_page_for_cancel_button(String string) {
        String channelNameCancel = SMSC_Utils.ConfigReader.getProperty("channelNameCancel");
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.channelName, 10);
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.channelName, channelNameCancel, "Channel Name");
    }

    @Given("User clicks on Cancel button")
    public void user_clicks_on_cancel_button() {
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.cancelButton, 10);
        SMSC_Actions.clickOnElement(SMSC_Channels_PageObjects.cancelButton, "Cancel Button");
    }

    @Then("User should be redirected to the Channels page and no changes should be saved")
    public void user_should_be_redirected_to_the_Channels_page_and_no_changes_should_be_saved() {

    }

    @Given("User clicks on Create button to validate mandatory fields of New Channel")
    public void user_clicks_on_create_button_to_validate_mandatory_fields_of_new_channel() {
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.createButton, 10);
        SMSC_Actions.clickOnElement(SMSC_Channels_PageObjects.createButton, "Create Button");
    }

    @Then("User should see an error message for all the channel mandatory fields")
    public void User_should_see_an_error_message_for_all_the_channel_mandatory_fields() {

    }

    @Given("User clicks on Edit button on Channels page")
    public void user_clicks_on_edit_button_on_Channels_page() {

    }

    @Given("User updates the Provider field as {string}")
    public void user_updates_the_provider_field_as(String string) {

    }

    @Given("User clicks on Update button")
    public void user_clicks_on_update_button() {

    }

    @Then("User validates the updates of the updated channel")
    public void user_validates_the_updates_of_the_updated_channel() {

    }

    @Then("User selects the status as {string}")
    public void user_selects_the_status_as(String string) {

    }

    @Then("User clicks on Update button and validates whether the channel is updated as Inactive")
    public void user_clicks_on_update_button_and_validates_whether_the_channel_is_updated_as_inactive() {

    }

    @Given("User enters valid filter criteria in the search box on channels page")
    public void user_enters_valid_filter_criteria_in_the_search_box_on_channels_page() {

    }

    @Then("User validates the valid search results on channels page")
    public void user_validates_the_valid_search_results_on_channels_page() {

    }

    @Then("User enters invalid filter criteria in the search box on channels page")
    public void user_enters_invalid_filter_criteria_in_the_search_box_on_channels_page() {

    }

    @Then("User validates the error message as {string} on Channels page")
    public void user_validates_the_error_message_as_on_channels_page(String string) {

    }

    @Then("User clicks on Rows per page dropdown")
    public void user_clicks_on_rows_per_page_dropdown() {

    }

    @Then("User selects the desired number from Rows per page dropdown")
    public void user_selects_the_desired_number_from_rows_per_page_dropdown() {

    }
}
