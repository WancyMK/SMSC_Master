package smsc_stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import smsc_accelerators.SMSC_Actions;
import smsc_accelerators.SMSC_Base;
import smsc_pageobjects.SMSC_DashBoard_PageObjects;


public class smsc_DashBoard extends SMSC_Base {
        String TotalMessages_Count;
        String errorPieCount;


        @And("Verify that the time intervals on the axis correctly labeled")
        public void verify_that_the_time_intervals_on_the_axis_labeled() throws InterruptedException {
            Thread.sleep(5000);
            SMSC_Actions.isElementVisible(SMSC_DashBoard_PageObjects.grindGraph, "GrindGraph");
            SMSC_Actions.isElementVisible(SMSC_DashBoard_PageObjects.yAxis_Interval, "GrindGraph");

        }

        @Then("the Pie chart should display statuses: sent, delivered, failed, errors, queued, started, and completed")
        public void the_pie_chart_should_display_statuses() {
            SMSC_Actions.waitForElementToBeVisible(SMSC_DashBoard_PageObjects.grindGraphStatus_queued, 10);
        	SMSC_Actions.waitForElementToBeVisible(SMSC_DashBoard_PageObjects.grindGraphStatus_failed, 10);
            SMSC_Actions.waitForElementToBeVisible(SMSC_DashBoard_PageObjects.grindGraphStatus_errors, 10);
            SMSC_Actions.waitForElementToBeVisible(SMSC_DashBoard_PageObjects.grindGraphStatus_completed, 10);
            SMSC_Actions.waitForElementToBeVisible(SMSC_DashBoard_PageObjects.grindGraphStatus_sent, 10);

        }

        @Then("all visual elements should be accurately displayed according to the design specifications")
        public void all_visual_elements_should_be_accurately_displayed_according_to_the_design_specifications() {
        	SMSC_Actions.isElementVisible(SMSC_DashBoard_PageObjects.monitorTransactions_lbl, "Monitor Transaction Label");
            SMSC_Actions.isElementVisible(SMSC_DashBoard_PageObjects.totalTransactions_lbl, "Total Transaction Label");
            SMSC_Actions.isElementVisible(SMSC_DashBoard_PageObjects.barcartcontainer_chart, "barchart container");
            SMSC_Actions.isElementVisible(SMSC_DashBoard_PageObjects.monitorMessage_lbl, "Monitor Message");
            SMSC_Actions.isElementVisible(SMSC_DashBoard_PageObjects.TotalMessages_Count, "Total Messages");
            SMSC_Actions.isElementVisible(SMSC_DashBoard_PageObjects.TotalMessages_lbl, "Total Messages");
        }

        @When("the user selects a different channel from the {string} dropdown")
        public void the_user_selects_a_different_channel_from_the_dropdown(String dropdownName) throws Throwable {
            SMSC_Actions.selectByVisibleText(SMSC_DashBoard_PageObjects.Select_channel, dropdownName);
        }

        @When("user gets the data from the page to compare with")
        public void user_gets_the_data_from_the_page_to_compare_with() throws Throwable {
            Thread.sleep(2000);
            TotalMessages_Count = SMSC_Actions.getElementText(SMSC_DashBoard_PageObjects.TotalMessages_Count, "Total Messages Count");
        }

        @When("Validate that the data from the previous channel does not match with the current channel")
        public void verify_that_the_data_from_the_previous_channel_does_not_match_with_the_current_channel() throws Throwable {
            Thread.sleep(2000);
            String Data = SMSC_Actions.getElementText(SMSC_DashBoard_PageObjects.TotalMessages_Count, "Total Messages Count");
            Assert.assertNotEquals(TotalMessages_Count,Data);
        }

        @When("Status message should display as user hovers over each segment of pie chart")
        public void Status_message_should_display_as_user_hovers_over_each_segment_of_pie_chart() throws Throwable {
            Thread.sleep(4000);
            SMSC_Actions.mouseover(SMSC_DashBoard_PageObjects.Piechart_errors);
            Thread.sleep(5000);
            errorPieCount = SMSC_Actions.getElementText(SMSC_DashBoard_PageObjects.errorPieCount_Display,"Error Pie Chart Count");
            System.out.println(errorPieCount);
            Thread.sleep(2000);
            SMSC_Actions.isElementVisible(SMSC_DashBoard_PageObjects.queuedMessageCount_lbl, "Total Messages");
        }

    }

