package smsc_stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import smsc_accelerators.SMSC_Actions;
import smsc_accelerators.SMSC_Base;
import smsc_pageobjects.SMSC_Logout_PageObjects;

public class smsc_Logout extends SMSC_Base {
    @When("the user clicks on the 'Logout' button on the sidebar")
    public void theUserClicksOnTheLogoutButtonOnTheSidebar() {
        SMSC_Actions.waitForElementToBeVisible(SMSC_Logout_PageObjects.logoutButton, 45);
        SMSC_Actions.jsClickOnElement(SMSC_Logout_PageObjects.logoutButton, "Logout");
    }

    @Then("the user should be navigated to the Login page")
    public void theUserShouldBeNavigatedToTheLoginPage() {
        SMSC_Actions.waitForElementToBeVisible(SMSC_Logout_PageObjects.loginPageHeader, 45);
        Assert.assertTrue("User is not on the login page", SMSC_Logout_PageObjects.loginPageHeader.isDisplayed());
    }

    @When("the user does not perform any actions on the screen for 15 minutes")
    public void theUserDoesNotPerformAnyActionsOnTheScreenFor15Minutes() throws InterruptedException {
        Thread.sleep(900000); // 15 minutes in milliseconds (not recommended for real tests, use a better approach)
    }

    @Then("the user should be automatically logged out")
    public void theUserShouldBeAutomaticallyLoggedOut() {
        SMSC_Actions.waitForElementToBeVisible(SMSC_Logout_PageObjects.loginPageHeader, 45);
        Assert.assertTrue("User is not on the login page", SMSC_Logout_PageObjects.loginPageHeader.isDisplayed());
    }
}
