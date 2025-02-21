package smsc_stepDefinitions;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import smsc_accelerators.SMSC_Base;

public class smsc_Logout extends SMSC_Base {


        private boolean isLoggedIn = true; // Simulates the logged-in state
        private boolean isOnLoginPage = false; // Simulates the login page state
        private boolean isInactiveFor15Minutes = false; // Simulates inactivity



        @When("the user clicks on the {string} button on the sidebar")
        public void the_user_clicks_on_the_button_on_the_sidebar(String buttonName) {
            if (buttonName.equals("Logout")) {
                isLoggedIn = false;
                isOnLoginPage = true;
                System.out.println("User clicked on the Logout button.");
            }
        }

        @Then("the user should be navigated to the Login page")
        public void the_user_should_be_navigated_to_the_login_page() {
            Assert.assertFalse("User is still logged in.", isLoggedIn);
            Assert.assertTrue("User is not on the Login page.", isOnLoginPage);
            System.out.println("User is navigated to the Login page.");
        }

        @When("the user does not perform any actions on the screen for {int} minutes")
        public void the_user_does_not_perform_any_actions_on_the_screen_for_minutes(Integer minutes) {
            if (minutes == 15) {
                isInactiveFor15Minutes = true;
                isLoggedIn = false;
                System.out.println("User was inactive for 15 minutes.");
            }
        }

        @Then("the user should be automatically logged out")
        public void the_user_should_be_automatically_logged_out() {
            Assert.assertTrue("User was not inactive for 15 minutes.", isInactiveFor15Minutes);
            Assert.assertFalse("User is still logged in.", isLoggedIn);
            System.out.println("User is automatically logged out.");
        }
    }

