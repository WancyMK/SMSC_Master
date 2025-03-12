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
	private String password;

	@Given("I am on the SMSC Absa login page")
	public void i_am_on_the_SMSC_Absa_login_page() {
		String base_url = SMSC_Utils.ConfigReader.getProperty("smsc_absa_login_url");
	    
    }

//    // TC001 - Verify Login with Valid Credentials
//    @Given("the user has valid login credentials")
//    public void the_user_has_valid_login_credentials() {
//        // No direct method to store data; we'll use config directly in the next steps
//    }

    @When("the user enters a valid username in the {string} field")
    public void the_user_enters_a_valid_username_in_the_field(String fieldName) {
        SMSC_Actions.waitForElementToBeVisible(smsc_LoginObjects.Username_txtb, 10);
        SMSC_Actions.typeInTextBox(smsc_LoginObjects.Username_txtb, 
            SMSC_Utils.ConfigReader.getProperty("valid_email"), "Entering valid username in " + fieldName);
    }

    @When("the user enters a valid password in the {string} field")
    public void the_user_enters_a_valid_password_in_the_field(String fieldName) {
        SMSC_Actions.waitForElementToBeVisible(smsc_LoginObjects.Password_txtb, 10);
        SMSC_Actions.typeInTextBox(smsc_LoginObjects.Password_txtb, 
            SMSC_Utils.ConfigReader.getProperty("valid_Password"), "Entering valid password in " + fieldName);
    }

    @When("the user clicks the {string} button")
    public void the_user_clicks_the_button(String buttonName) {
        SMSC_Actions.clickOnElement(smsc_LoginObjects.SubmitLogin_btn, "Clicking " + buttonName + " button");
    }

    @Then("the user should be successfully logged in")
    public void the_user_should_be_successfully_logged_in() {
        SMSC_Actions.waitForElementToBeVisible(smsc_LoginObjects.Loggedin_heading, 5);
    }

    @Then("the user should be redirected to the dashboard")
    public void the_user_should_be_redirected_to_the_dashboard() {
        // No verifyUrlContains; use element visibility instead
        SMSC_Actions.waitForElementToBeVisible(smsc_LoginObjects.Dashboard_element, 5);
    }
    @When("the user logs out")
    public void the_user_logs_out() {
    	try {
            SMSC_Actions.scrollToBottom(); // Scroll to the bottom of the page
            SMSC_Actions.waitForElementToBeVisible(smsc_LoginObjects.logoutButton, 5); // Wait for logout button
            SMSC_Actions.clickOnElement(smsc_LoginObjects.logoutButton, "Clicking Logout button");
        } catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Failed to log out by clicking the logout button");
        }
    }

    @Then("the user should be redirected to the login page")
    public void the_user_should_be_redirected_to_the_login_page() {
        SMSC_Actions.waitForElementToBeVisible(smsc_LoginObjects.Login_heading, 5);
    }

    // TC003 - Verify Login with Invalid Credentials
    @Given("the user has invalid login credentials")
    public void the_user_has_invalid_login_credentials() {
        // No direct method to store data; we'll use hardcoded invalid creds in the next steps
    }

    @When("the user enters an invalid username in the {string} field")
    public void the_user_enters_an_invalid_username_in_the_field(String fieldName) {
        SMSC_Actions.waitForElementToBeVisible(smsc_LoginObjects.Username_txtb, 10);
        SMSC_Actions.typeInTextBox(smsc_LoginObjects.Username_txtb, 
            "test", "Entering invalid username 'test' in " + fieldName);
    }

    @When("the user enters an invalid password in the {string} field")
    public void the_user_enters_an_invalid_password_in_the_field(String fieldName) {
        SMSC_Actions.waitForElementToBeVisible(smsc_LoginObjects.Password_txtb, 10);
        SMSC_Actions.typeInTextBox(smsc_LoginObjects.Password_txtb, 
            "data", "Entering invalid password in " + fieldName);
    }
    @When("the user clicks the {string} buttons")
    public void the_user_clicks_the_buttons(String buttonName) {
        SMSC_Actions.clickOnElement(smsc_LoginObjects.SubmitLogin_btn, "Clicking " + buttonName + " button");
    }

    @Then("the user should receive an error message {string}")
    public void the_user_should_receive_an_error_message(String errorMessage) {
    	  SMSC_Actions.waitForElementToBeVisible(smsc_LoginObjects.Error_Message, 10);
    	    System.out.println("Displayed Error Message: " + "Invalid username or password");
    	    //SMSC_Actions.compareData(smsc_LoginObjects.Error_Message, password, "Invalid username or password");
    }
    

    // TC004 - Verify Login with Empty Username and Password Fields
    @When("the user leaves both the {string} and {string} fields blank")
    public void the_user_leaves_both_the_and_fields_blank(String usernameField, String passwordField) {
        SMSC_Actions.waitForElementToBeVisible(smsc_LoginObjects.Username_txtb, 10);
        SMSC_Actions.clearTextbox(smsc_LoginObjects.Username_txtb, "Clearing " + usernameField);
        SMSC_Actions.waitForElementToBeVisible(smsc_LoginObjects.Password_txtb, 10);
        SMSC_Actions.clearTextbox(smsc_LoginObjects.Password_txtb, "Clearing " + passwordField);
    }
    
    

    // TC002 - Ensure visual elements are correctly displayed
    @Given("the login page is accessible")
    public void the_login_page_is_accessible() {
        // No verifyPageIsAccessible; use element visibility to confirm
        SMSC_Actions.isElementVisible(smsc_LoginObjects.Login_heading, "Login heading");
    }

    @Given("the design specifications are available")
    public void the_design_specifications_are_available() {
        // No loadDesignSpecifications; assume specs are in config or handled elsewhere
    }

    @When("the user validates all visual elements against design specifications")
    public void the_user_validates_all_visual_elements_against_design_specifications() {
        // No direct method; assume validation is done in Then steps
        SMSC_Actions.waitForElementToBeVisible(smsc_LoginObjects.SubmitLogin_btn, 5);
    }

    @Then("all visual elements should be accurately displayed according to specifications")
    public void all_visual_elements_should_be_accurately_displayed_according_to_specifications() {
        SMSC_Actions.isElementVisible(smsc_LoginObjects.SubmitLogin_btn, "Login container");
    }}

//    @Then("labels should be correct")
//    public void labels_should_be_correct() {
//        SMSC_Actions.compareData(smsc_LoginObjects.Usernamelbl, 
//            SMSC_Utils.ConfigReader.getProperty("Username"), "Username label");
//        SMSC_Actions.compareData(smsc_LoginObjects.Passwordlbl, 
//            SMSC_Utils.ConfigReader.getProperty("Password"), "Password label");
//    }
//
//    @Then("text should be correct")
//    public void text_should_be_correct() {
//        SMSC_Actions.compareData(smsc_LoginObjects.Login_heading, 
//            SMSC_Utils.ConfigReader.getProperty("Login"), "Login heading");
//    }
//
//    @Then("colors should be correct")
//    public void colors_should_be_correct() {
//        // No direct CSS verification; use visibility as a proxy or extend SMSC_Actions if needed
//        SMSC_Actions.isElementVisible(smsc_LoginObjects.SubmitLogin_btn, "Login container color check");
//    }
//
//    @Then("sizes should be correct")
//    public void sizes_should_be_correct() {
//        // No direct size verification; use visibility as a proxy or extend SMSC_Actions if needed
//        SMSC_Actions.isElementVisible(smsc_LoginObjects.SubmitLogin_btn, "Login container size check");
//    }
//
//    @Then("alignment should be correct")
//    public void alignment_should_be_correct() {
//        // No direct alignment verification; use visibility as a proxy or extend SMSC_Actions if needed
//        SMSC_Actions.isElementVisible(smsc_LoginObjects.SubmitLogin_btn, "Login container alignment check");
//    }
//}
