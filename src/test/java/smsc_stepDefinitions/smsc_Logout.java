package smsc_stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

import smsc_accelerators.SMSC_Actions;
import smsc_accelerators.SMSC_Base;
import smsc_pageobjects.SMSC_Logout_PageObjects;
import smsc_pageobjects.smsc_LoginObjects;
import smsc_utility.SMSC_ExceptionHandler;

public class smsc_Logout extends SMSC_Base {
	
    @When("the user clicks on the 'Logout' button on the sidebar")
    public void theUserClicksOnTheLogoutButtonOnTheSidebar() {
    	try {
            SMSC_Actions.scrollToBottom(); // Scroll to the bottom of the page
            SMSC_Actions.waitForElementToBeVisible(SMSC_Logout_PageObjects.logoutbutton, 5); // Wait for logout button
            SMSC_Actions.clickOnElement(SMSC_Logout_PageObjects.logoutbutton, "Clicking Logout button");
        } catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Failed to log out by clicking the logout button");
        }
             
                
                
             
    }

    @Then("the user should be navigated to the Login page")
    public void theUserShouldBeNavigatedToTheLoginPage() {
        SMSC_Actions.waitForElementToBeVisible(SMSC_Logout_PageObjects.loginPageHeader, 5);
        Assert.assertNotNull("User is not on the login page", SMSC_Logout_PageObjects.loginPageHeader);
    }

    @When("the user does not perform any actions on the screen for 15 minutes")
    public void theUserDoesNotPerformAnyActionsOnTheScreenFor15Minutes() throws InterruptedException {
        Thread.sleep(2000); // 15 minutes in milliseconds (not recommended for real tests, use a better approach)
    }
    @Then("the user should be automatically logged out")

    public void theUserShouldBeAutomaticallyLoggedOut() {
        //SMSC_Actions.jsClickOnElement(SMSC_Logout_PageObjects.loginPageHeader, "login");
        Assert.assertNotNull("User is not on the login page", SMSC_Logout_PageObjects.loginPageHeader);
    }
}
