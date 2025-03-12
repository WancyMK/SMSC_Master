package smsc_stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import smsc_accelerators.SMSC_Actions;
import smsc_accelerators.SMSC_Base;
import smsc_pageobjects.SMSC_DashBoard_PageObjects;
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
    	    SMSC_Actions.typeInTextBox(smsc_LoginObjects.Username_txtb, "validUser", "Username");
    	    SMSC_Actions.waitForElementToBeVisible(smsc_LoginObjects.Password_txtb, 10);
    	    SMSC_Actions.typeInTextBox(smsc_LoginObjects.Password_txtb, "validPassword", "Password");
    }
    @And("clicks on the {string} button")
    public void clicksOnTheButton(String button) {
        SMSC_Actions.waitForElementToBeVisible(smsc_LoginObjects.Loggedin_heading, 10);
        SMSC_Actions.jsClickOnElement(smsc_LoginObjects.Loggedin_heading, button);
    }
    

    @Then("the user should be redirected to the dashboard")
    public void the_user_should_be_redirected_to_the_dashboard () {
    	SMSC_Actions.waitForElementToBeVisible(SMSC_DashBoard_PageObjects.DashBoard_Head, 5);
        
        boolean isDashboardVisible = SMSC_Actions.isElementVisible(SMSC_DashBoard_PageObjects.DashBoard_Head, "Dashboard heading");

        if (!isDashboardVisible) {
            SMSC_ExceptionHandler.HandleAssertion("Dashboard page is not displayed");
        }
    }
    @Then("all visual elements should be displayed as per the design specifications")
    public void all_visual_elements_should_be_displayed () {
    	    SMSC_Actions.waitForElementToBeVisible(smsc_LoginObjects.Username_txtb, 5);
    	    SMSC_Actions.waitForElementToBeVisible(smsc_LoginObjects.Password_txtb, 5);
    	    SMSC_Actions.waitForElementToBeVisible(smsc_LoginObjects.SubmitLogin_btn, 5);

    	    boolean isUsernameVisible = SMSC_Actions.isElementVisible(smsc_LoginObjects.Username_txtb, "Username field");
    	    boolean isPasswordVisible = SMSC_Actions.isElementVisible(smsc_LoginObjects.Password_txtb, "Password field");
    	    boolean isLoginButtonVisible = SMSC_Actions.isElementVisible(smsc_LoginObjects.SubmitLogin_btn, "Login button");

    	    
    }

    @When("the user enters an invalid username and password")
    public void the_user_enters_an_invalid_username_and_password() {
    	SMSC_Actions.waitForElementToBeVisible(smsc_LoginObjects.Username_txtb, 10);
    	SMSC_Actions.typeInTextBox(smsc_LoginObjects.Username_txtb, "invalidUser", "Username");

    	SMSC_Actions.waitForElementToBeVisible(smsc_LoginObjects.Password_txtb, 10);
    	SMSC_Actions.typeInTextBox(smsc_LoginObjects.Password_txtb, "invalidPassword", "Password");
    }

    @And("click on the {string} button")
    public void clickOnTheButton(String button) {
        SMSC_Actions.waitForElementToBeVisible(smsc_LoginObjects.Loggedin_heading, 10);
        SMSC_Actions.jsClickOnElement(smsc_LoginObjects.Loggedin_heading, button);
    }
    
    @Then("the user should see an error message {string}")
    public void theUserShouldSeeAnErrorMessage(String errorMessage) {
        SMSC_Actions.waitForElementToBeVisible(smsc_LoginObjects.errorMessage, 45);
        Assert.assertEquals("Error message is incorrect", errorMessage, smsc_LoginObjects.errorMessage);
    }
               
    @When("the user leaves both the {string} and {string} fields blank")
    public void theUserLeavesBothFieldsBlank(String username, String password) {
        SMSC_Actions.waitForElementToBeVisible(smsc_LoginObjects.Username_txtb, 45);
        SMSC_Actions.clearTextbox(smsc_LoginObjects.Username_txtb, password);

        SMSC_Actions.waitForElementToBeVisible(smsc_LoginObjects.Password_txtb, 45);
        SMSC_Actions.clearTextbox(smsc_LoginObjects.Password_txtb, password);
    }    
    @And("click on {string} button")
    public void clickOnButton(String button) {
        SMSC_Actions.waitForElementToBeVisible(smsc_LoginObjects.Loggedin_heading, 10);
        SMSC_Actions.jsClickOnElement(smsc_LoginObjects.Loggedin_heading, button);
    }

    @Then("the user should see an error messages {string}")
    public void theUserShouldSeeAnErrorMessages(String expectedErrorMessage) {
        SMSC_Actions.waitForElementToBeVisible(smsc_LoginObjects.errorMessage, 45);
        String actualErrorMessage = SMSC_Actions.getElementText(smsc_LoginObjects.errorMessage, "Invalid username or password");
        Assert.assertEquals("Error message is incorrect", expectedErrorMessage, actualErrorMessage);
    }
        }