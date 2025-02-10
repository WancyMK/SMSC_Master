package smsc_stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import smsc_accelerators.SMSC_Actions;
import smsc_accelerators.SMSC_Base;
import smsc_pageobjects.SMSC_Channels_PageObjects;
import smsc_utility.Logs;
import smsc_utility.SMSC_ExceptionHandler;
import smsc_utility.SMSC_Utils;

public class SMSC_Channels extends SMSC_Base{
    public static  String channelName;
    public static String updateProvider;
    public static String searchContent;

    @Given("User clicks on Channels on the side bar")
    public void user_clicks_on_channels_on_the_side_bar() {
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.channelSideBar_btn, 10);
        SMSC_Actions.clickOnElement(SMSC_Channels_PageObjects.channelSideBar_btn, "Channels on the sidebar");
    }
    @Given("User clicks on Create New Channel button")
    public void user_clicks_on_create_new_channel_button() {
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.createNewChannel_btn, 10);
        SMSC_Actions.clickOnElement(SMSC_Channels_PageObjects.createNewChannel_btn, "Create New Channel Button");
    }

    @Given("User enters Channel Name as {string} on New Channel page")
    public void user_enters_channel_name_as_on_new_channel_page(String string) {
        Logs.info("Enter Channel Name");
        channelName = SMSC_Utils.ConfigReader.getProperty("channelName");
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.channelName_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.channelName_txtb, channelName, "Channel Name");
        Logs.info("Entered Channel Name");
    }

    @Given("User enters Host as {string} on New Channel page")
    public void user_enters_host_as_on_new_channel_page(String string) {
        String host = SMSC_Utils.ConfigReader.getProperty("host");
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.host_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.host_txtb, host, "Host");
    }

    @Given("User enters Port as {string} on New Channel page")
    public void user_enters_port_as_on_new_channel_page(String string) {
        String port = SMSC_Utils.ConfigReader.getProperty("port");
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.port_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.port_txtb, port, "Port");
    }

    @Given("User enters System ID as {string} on New Channel page")
    public void user_enters_system_id_as_on_new_channel_page(String string) {
        String systemID = SMSC_Utils.ConfigReader.getProperty("systemID");
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.systemID_txtb, 20);
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.systemID_txtb, systemID, "System ID");
    }

    @Given("User enters Password as {string} on New Channel page")
    public void user_enters_password_as_on_new_channel_page(String string) {
        String password = SMSC_Utils.ConfigReader.getProperty("password");
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.password_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.password_txtb, password, "Password");
    }

    @Given("User enters Service Type as {string} on New Channel page")
    public void user_enters_service_type_as_on_new_channel_page(String string) {
        String serviceType = SMSC_Utils.ConfigReader.getProperty("serviceType");
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.serviceType_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.serviceType_txtb, serviceType, "Service Type");
    }

    @Given("User enters Priority as {string} on New Channel page")
    public void user_enters_priority_as_on_new_channel_page(String string) {
        String priority = SMSC_Utils.ConfigReader.getProperty("priority");
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.priority_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.priority_txtb, priority, "Priority");
    }

    @Given("User enters Source Address as {string} on New Channel page")
    public void user_enters_source_address_as_on_new_channel_page(String string) {
        String sourceAddress = SMSC_Utils.ConfigReader.getProperty("sourceAddress");
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.sourceAddress_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.sourceAddress_txtb, sourceAddress, "Source Address");
    }

    @Given("User selects Status as {string} on New Channel page")
    public void user_selects_status_as_on_new_channel_page(String string) {
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.status_dropdown, 10);
        SMSC_Actions.clickOnElement(SMSC_Channels_PageObjects.status_dropdown, "Status dropdown");
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.statusActiveOption_dropdown, 10);
        SMSC_Actions.clickOnElement(SMSC_Channels_PageObjects.statusActiveOption_dropdown, "Active");
    }

    @Given("User enters Provider as {string} on New Channel page")
    public void user_enters_provider_as_on_new_channel_page(String string) {
        String provider = SMSC_Utils.ConfigReader.getProperty("provider");
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.provider_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.provider_txtb, provider, "Provider");
    }

    @Given("User selects Multi For Bulk as {string} on New Channel page")
    public void user_selects_multi_for_bulk_as_on_new_channel_page(String string) throws Exception {
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.multiForBulk_dropdown, 10);
        SMSC_Actions.ClickViaMouse(SMSC_Channels_PageObjects.multiForBulk_dropdown, "Multi For Bulk dropdown");
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.multiForBulkOption_dropdown, 10);
        SMSC_Actions.ClickViaMouse(SMSC_Channels_PageObjects.multiForBulkOption_dropdown, "no");
    }

    @Given("User enters Filters as {string} on New Channel page")
    public void user_enters_filters_as_on_new_channel_page(String string) {
        String filter = SMSC_Utils.ConfigReader.getProperty("filters");
        String filter01 = SMSC_Utils.ConfigReader.getProperty("filters01");
        String filter02 = SMSC_Utils.ConfigReader.getProperty("filters02");
        String filter03 = SMSC_Utils.ConfigReader.getProperty("filters03");
        String filter04 = SMSC_Utils.ConfigReader.getProperty("filters04");
        String filterComma = SMSC_Utils.ConfigReader.getProperty("filtersComma");
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.filters_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.filters_txtb, filter, "Filters");
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.filters_txtb, filterComma, "Filter");
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.filters_txtb, filter01, "Filters");
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.filters_txtb, filterComma, "Filter");
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.filters_txtb, filter02, "Filters");
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.filters_txtb, filterComma, "Filter");
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.filters_txtb, filter03, "Filters");
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.filters_txtb, filterComma, "Filter");
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.filters_txtb, filter04, "Filters");
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.filters_txtb, filterComma, "Filter");
    }

    @Given("User clicks on Create button")
    public void user_clicks_on_create_button() {
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.create_btn, 10);
        SMSC_Actions.jsClickOnElement(SMSC_Channels_PageObjects.create_btn, "Create Button");
    }

    @Then("User verifies the created Channel to validate channel is created")
    public void user_verifies_the_created_channel_to_validate_channel_is_created() throws Exception {
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.search_txtb, 10);
        String text = SMSC_Utils.ConfigReader.getProperty("channelName");
        SMSC_Actions.ClickViaMouse(SMSC_Channels_PageObjects.search_txtb, "Search box");
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.search_txtb, text, "Search Box");
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.validateChannelCreated_txt, 10);
        String createdChannelText = SMSC_Actions.getElementText(SMSC_Channels_PageObjects.validateChannelCreated_txt, "Created Channel text");
        if (!createdChannelText.contains(channelName)){
            SMSC_ExceptionHandler.HandleAssertion("Channel is not created");
        }else{
            Logs.info("Channel is created successfully");
        }
    }

    @Given("User enters Channel Name as {string} on New Channel page for Cancel button")
    public void user_enters_channel_name_as_on_new_channel_page_for_cancel_button(String string) {
        String channelNameCancel = SMSC_Utils.ConfigReader.getProperty("channelNameCancel");
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.channelName_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.channelName_txtb, channelNameCancel, "Channel Name");
    }

    @Given("User clicks on Cancel button")
    public void user_clicks_on_cancel_button() {
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.cancel_btn, 10);
        SMSC_Actions.jsClickOnElement(SMSC_Channels_PageObjects.cancel_btn, "Cancel Button");
    }

    @Then("User should be redirected to the Channels page and no changes should be saved")
    public void user_should_be_redirected_to_the_Channels_page_and_no_changes_should_be_saved() {
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.createNewChannel_btn, 10);
        if (!SMSC_Actions.isElementVisible(SMSC_Channels_PageObjects.createNewChannel_btn, "Create New Channel button")){
            SMSC_ExceptionHandler.HandleAssertion("New Channel is created");
        }else{
            Logs.info("New Channel is not created");
        }
    }

    @Given("User clicks on Create button to validate mandatory fields of New Channel")
    public void user_clicks_on_create_button_to_validate_mandatory_fields_of_new_channel() {
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.create_btn, 20);
        SMSC_Actions.jsClickOnElement(SMSC_Channels_PageObjects.create_btn, "Create Button");
    }

    @Then("User should see an error message for all the channel mandatory fields")
    public void User_should_see_an_error_message_for_all_the_channel_mandatory_fields() {
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.errorChannelName_txt, 10);
        if(!SMSC_Actions.isElementVisible(SMSC_Channels_PageObjects.errorChannelName_txt, "Name is required")){
            SMSC_ExceptionHandler.HandleAssertion("Name is required element is not visible");
        }else{
            Logs.info("Name is required element is visible");
        }
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.errorHost_txt, 10);
        if(!SMSC_Actions.isElementVisible(SMSC_Channels_PageObjects.errorHost_txt, "Host is required")){
            SMSC_ExceptionHandler.HandleAssertion("Host is required element is not visible");
        }else{
            Logs.info(" is required element is visible");
        }
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.errorPort_txt, 10);
        if(!SMSC_Actions.isElementVisible(SMSC_Channels_PageObjects.errorPort_txt, "Port is required")){
            SMSC_ExceptionHandler.HandleAssertion("Port is required element is not visible");
        }else{
            Logs.info("Port is required element is visible");
        }
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.errorSystemID_txt, 10);
        if(!SMSC_Actions.isElementVisible(SMSC_Channels_PageObjects.errorSystemID_txt, "System ID is required")){
            SMSC_ExceptionHandler.HandleAssertion("System ID is required element is not visible");
        }else{
            Logs.info("System ID is required element is visible");
        }
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.errorPassword_txt, 10);
        if(!SMSC_Actions.isElementVisible(SMSC_Channels_PageObjects.errorPassword_txt, "Password is required")){
            SMSC_ExceptionHandler.HandleAssertion("Password is required element is not visible");
        }else{
            Logs.info(" is required element is visible");
        }
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.errorServiceType_txt, 10);
        if(!SMSC_Actions.isElementVisible(SMSC_Channels_PageObjects.errorServiceType_txt, "Service Type is required")){
            SMSC_ExceptionHandler.HandleAssertion("Service Type is required element is not visible");
        }else{
            Logs.info("Service Type is required element is visible");
        }
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.errorPriority_txt, 10);
        if(!SMSC_Actions.isElementVisible(SMSC_Channels_PageObjects.errorPriority_txt, "Priority is required")){
            SMSC_ExceptionHandler.HandleAssertion("Priority is required element is not visible");
        }else{
            Logs.info("Priority is required element is visible");
        }
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.errorSourceAddress_txt, 10);
        if(!SMSC_Actions.isElementVisible(SMSC_Channels_PageObjects.errorSourceAddress_txt, "Source Address is required")){
            SMSC_ExceptionHandler.HandleAssertion("Source Address is required element is not visible");
        }else{
            Logs.info("Source Address is required element is visible");
        }
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.errorProvider_txt, 10);
        if(!SMSC_Actions.isElementVisible(SMSC_Channels_PageObjects.errorProvider_txt, "Provider is required")){
            SMSC_ExceptionHandler.HandleAssertion("Provider is required element is not visible");
        }else{
            Logs.info("Provider is required element is visible");
        }
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.errorFilters_txt, 10);
        if(!SMSC_Actions.isElementVisible(SMSC_Channels_PageObjects.errorFilters_txt, "Filters is required")){
            SMSC_ExceptionHandler.HandleAssertion("Filters is required element is not visible");
        }else{
            Logs.info("Filters is required element is visible");
        }
    }

    @Given("User clicks on Edit button on Channels page")
    public void user_clicks_on_edit_button_on_Channels_page() {
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.search_txtb, 10);
        String text = SMSC_Utils.ConfigReader.getProperty("channelName");
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.search_txtb, text, "Search Box");
        SMSC_Actions.clickOnElement(SMSC_Channels_PageObjects.edit_btn, "Edit button");
    }

    @Given("User updates the Provider field as {string}")
    public void user_updates_the_provider_field_as(String string) {
        updateProvider = SMSC_Utils.ConfigReader.getProperty("updateProvider");
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.provider_txtb, 10);
        SMSC_Actions.jsClickOnElement(SMSC_Channels_PageObjects.provider_txtb, "Provider");
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.provider_txtb, 20);
        SMSC_Actions.clearTextbox(SMSC_Channels_PageObjects.provider_txtb, "Provider");
        WebElement element = driver.findElement(SMSC_Channels_PageObjects.provider_txtb);
        element.sendKeys(Keys.CONTROL + "a"); // Select all text
        element.sendKeys(Keys.BACK_SPACE);
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.provider_txtb, updateProvider, "Provider");
    }

    @Given("User clicks on Update button")
    public void user_clicks_on_update_button() {
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.update_btn, 10);
        SMSC_Actions.jsClickOnElement(SMSC_Channels_PageObjects.update_btn, "Update button");
    }

    @Then("User validates the updates of the updated channel")
    public void user_validates_the_updates_of_the_updated_channel() {
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.search_txtb, 10);
        String text = SMSC_Utils.ConfigReader.getProperty("channelName");
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.search_txtb, text, "Search Box");
        SMSC_Actions.clickOnElement(SMSC_Channels_PageObjects.edit_btn, "Edit button");
       // String fetchedProviderText = SMSC_Actions.getElementText(SMSC_Channels_PageObjects.provider_txtb, "Updated Provider");
        String fetchedProviderText = SMSC_Actions.getText(SMSC_Channels_PageObjects.provider_txtb, "Updated Provider");
        String updateProviderText = SMSC_Utils.ConfigReader.getProperty("updateProvider");
        if (!fetchedProviderText.contains(updateProviderText)){
            SMSC_ExceptionHandler.HandleAssertion("Provider is not updated");
        }else{
            Logs.info("Provider is updated");
        }
    }

    @Then("User selects the status as {string}")
    public void user_selects_the_status_as(String string) {
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.status_dropdown, 10);
        SMSC_Actions.clickOnElement(SMSC_Channels_PageObjects.status_dropdown, "Status dropdown");
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.statusInactiveOption_dropdown, 10);
        SMSC_Actions.clickOnElement(SMSC_Channels_PageObjects.statusInactiveOption_dropdown, "Inactive");
    }

    @Then("User clicks on Update button and validates whether the channel is updated as Inactive")
    public void user_clicks_on_update_button_and_validates_whether_the_channel_is_updated_as_inactive() {
        String text = SMSC_Utils.ConfigReader.getProperty("channelName");
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.update_btn, 10);
        SMSC_Actions.jsClickOnElement(SMSC_Channels_PageObjects.update_btn, "Update button");
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.search_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.search_txtb, text, "Search Box");
        String statusfetchedText = SMSC_Actions.getText(SMSC_Channels_PageObjects.status_txt, "Status updated text");
        if(!statusfetchedText.contains("inactive")){
            SMSC_ExceptionHandler.HandleAssertion("Channel status is not changed");
        }else {
            Logs.info("Channel status is changed");
        }
    }

    @Given("User enters valid filter criteria in the search box on channels page")
    public void user_enters_valid_filter_criteria_in_the_search_box_on_channels_page() {
        String searchContent = SMSC_Utils.ConfigReader.getProperty("channelName");
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.search_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.search_txtb, searchContent, "Search Box");
    }

    @Then("User validates the valid search results on channels page")
    public void user_validates_the_valid_search_results_on_channels_page() {
        String searchContent = SMSC_Utils.ConfigReader.getProperty("channelName");
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.validateChannelCreated_txt, 10);
        String searchResults = SMSC_Actions.getText(SMSC_Channels_PageObjects.validateChannelCreated_txt, "Search validate");
        if (!searchResults.contains(searchContent)){
            SMSC_ExceptionHandler.HandleAssertion("Search results not validated");
        }else{
            Logs.info("Search results validated");
        }
    }

    @Then("User enters invalid filter criteria in the search box on channels page")
    public void user_enters_invalid_filter_criteria_in_the_search_box_on_channels_page() {
        String invalidSearch = SMSC_Utils.ConfigReader.getProperty("invalidSearch");
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.search_txtb, 10);
        SMSC_Actions.typeInTextBox(SMSC_Channels_PageObjects.search_txtb, invalidSearch, "Search Box");
    }

    @Then("User validates the error message as {string} on Channels page")
    public void user_validates_the_error_message_as_on_channels_page(String string) {
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.searchErrorMessage, 10);
        if(!SMSC_Actions.isElementVisible(SMSC_Channels_PageObjects.searchErrorMessage, "Invalid search")){
            SMSC_ExceptionHandler.HandleAssertion("No Channels found error message is not displayed");
        }else{
            Logs.info("No Channels found error message is displayed");
        }
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.search_txtb, 10);
        SMSC_Actions.clearTextbox(SMSC_Channels_PageObjects.search_txtb, "Search box");
        WebElement element = driver.findElement(SMSC_Channels_PageObjects.search_txtb);
        element.sendKeys(Keys.CONTROL + "a"); // Select all text
        element.sendKeys(Keys.BACK_SPACE);
    }

    @Then("User clicks on Rows per page dropdown")
    public void user_clicks_on_rows_per_page_dropdown() throws Throwable {
        SMSC_Actions.ScrollDownBottom();
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.rows_dropdown, 10);
        SMSC_Actions.ClickViaMouse(SMSC_Channels_PageObjects.rows_dropdown, "Rows per page dropdown");
    }

    @Then("User selects the desired number from Rows per page dropdown")
    public void user_selects_the_desired_number_from_rows_per_page_dropdown() throws Exception {
        SMSC_Actions.waitForElement(SMSC_Channels_PageObjects.rowsOption_dropdown, 10);
        SMSC_Actions.ClickViaMouse(SMSC_Channels_PageObjects.rowsOption_dropdown, "10");
    }
}