package smsc_stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import smsc_accelerators.SMSC_Actions;
import smsc_pageobjects.smsc_LoginObjects;
import smsc_utility.SMSC_Utils;

public class smsc_Login {
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


    @Then("The page title should be {string}")
    public void the_page_title_should_be(String expectedTitle) {

    }
}
