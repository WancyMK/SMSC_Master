package smsc_stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import smsc_accelerators.SMSC_Actions;
import smsc_accelerators.SMSC_Base;
import smsc_pageobjects.smsc_DashBoard_Objects;
import smsc_pageobjects.smsc_LoginObjects;
import smsc_utility.SMSC_ExceptionHandler;
import smsc_utility.SMSC_Utils;

public class smsc_Login extends SMSC_Base {
    WebDriver driver;

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
    }
    @When("the user enters a valid username and password")
    public void the_user_enters_a_valid_username_and_password() {
        SMSC_Actions.waitForElementToBeVisible(smsc_LoginObjects.Username_txtb, 10);
        SMSC_Actions.typeInTextBox(smsc_LoginObjects.Username_txtb,
                SMSC_Utils.ConfigReader.getProperty("valid_email"), "Username");
        SMSC_Actions.waitForElementToBeVisible(smsc_LoginObjects.Password_txtb, 10);
        SMSC_Actions.typeInTextBox(smsc_LoginObjects.Password_txtb,
                SMSC_Utils.ConfigReader.getProperty("valid_Password"), "Password");
    }

    @When("the user enters an invalid username and password")
    public void the_user_enters_an_invalid_username_and_password() {
        SMSC_Actions.waitForElementToBeVisible(smsc_LoginObjects.Username_txtb, 10);
        SMSC_Actions.typeInTextBox(smsc_LoginObjects.Username_txtb, "invalidUser", "Username");
        SMSC_Actions.waitForElementToBeVisible(smsc_LoginObjects.Password_txtb, 10);
        SMSC_Actions.typeInTextBox(smsc_LoginObjects.Password_txtb, "invalidPassword", "Password");
    }

    @When("the user leaves both the {string} and {string} fields blank")
    public void the_user_leaves_both_fields_blank(String usernameField, String passwordField) {
        SMSC_Actions.waitForElementToBeVisible(smsc_LoginObjects.Username_txtb, 10);
        SMSC_Actions.clearTextBox(smsc_LoginObjects.Username_txtb, "Clearing username");
        SMSC_Actions.waitForElementToBeVisible(smsc_LoginObjects.Password_txtb, 10);
        SMSC_Actions.clearTextBox(smsc_LoginObjects.Password_txtb, "Clearing password");
    }

    @And("clicks on the {string} button")
    public void clicks_on_the_button(String buttonName) {
        SMSC_Actions.waitForElementToBeVisible(smsc_LoginObjects.SubmitLogin_btn, 10);
        SMSC_Actions.clickOnElement(smsc_LoginObjects.SubmitLogin_btn, "Clicking " + buttonName);
    }

    @And("click on {string} button")
    public void click_on_button(String buttonName) {
        SMSC_Actions.waitForElementToBeVisible(smsc_LoginObjects.SubmitLogin_btn, 10);
        SMSC_Actions.clickOnElement(smsc_LoginObjects.SubmitLogin_btn, "Clicking " + buttonName);
    }

    @Then("the user should be redirected to the dashboard")
    public void the_user_should_be_redirected_to_the_dashboard() {
        SMSC_Actions.waitForElementToBeVisible(smsc_DashBoard_Objects.DashBoard_Head, 10);
        Assert.assertTrue("Dashboard is not visible",
                SMSC_Actions.isElementVisible(smsc_DashBoard_Objects.DashBoard_Head, "Dashboard heading"));
    }

    @Then("all visual elements should be displayed as per the design specifications")
    public void all_visual_elements_should_be_displayed() {
        Assert.assertTrue("Username field not visible",
                SMSC_Actions.isElementVisible(smsc_LoginObjects.Username_txtb, "Username field"));
        Assert.assertTrue("Password field not visible",
                SMSC_Actions.isElementVisible(smsc_LoginObjects.Password_txtb, "Password field"));
        Assert.assertTrue("Login button not visible",
                SMSC_Actions.isElementVisible(smsc_LoginObjects.SubmitLogin_btn, "Login button"));
    }

    @Then("the user should see an error message {string}")
    public void the_user_should_see_an_error_message(String expectedErrorMessage) {
        SMSC_Actions.waitForElementToBeVisible(smsc_LoginObjects.ErrorMessage_lbl, 10);
        String actualErrorMessage = smsc_LoginObjects.ErrorMessage_lbl.getText();
        Assert.assertEquals("Error message is incorrect", expectedErrorMessage, actualErrorMessage);
    }
}
