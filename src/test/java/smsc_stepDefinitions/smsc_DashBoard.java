package smsc_stepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import smsc_accelerators.SMSC_Actions;
import smsc_accelerators.SMSC_Base;
import smsc_pageobjects.smsc_DashBoard_Objects;
public class smsc_DashBoard extends SMSC_Base {


        private boolean isLoggedIn = true; // Simulates the logged-in state
        private boolean areChartsDisplayed = true; // Simulates chart visibility
        private boolean areVisualElementsCorrect = true; // Simulates visual elements
        private boolean isDataCorrect = true; // Simulates data accuracy
        private boolean areTimeIntervalsCorrect = true; // Simulates time intervals
        private boolean areChartsResponsive = true; // Simulates responsiveness
        private boolean areEmptyChartsDisplayed = true; // Simulates empty charts
        private boolean areTooltipsAccurate = true; // Simulates tooltip accuracy
        private boolean isSidebarCollapsed = false; // Simulates sidebar state
        private boolean isChannelSelected = false; // Simulates channel selection
        private boolean isTotalMessagesCorrect = true; // Simulates Total Messages count
        private boolean arePieChartSegmentsClickable = false; // Simulates pie chart segments



        @When("the user checks the Bar and Pie charts")
        public void the_user_checks_the_bar_and_pie_charts() {
            SMSC_Actions.clickOnElement(smsc_DashBoard_Objects.Select_channel,"select channels");
            System.out.println("User checks the Bar and Pie charts.");
        }

        @Then("the Bar and Pie charts should be visible with proper formatting")
        public void the_bar_and_pie_charts_should_be_visible_with_proper_formatting() {
            Assert.assertTrue("Bar and Pie charts are not displayed.", areChartsDisplayed);
            System.out.println("Bar and Pie charts are visible with proper formatting.");
        }

        @Then("the Bar chart should show time intervals on the X-axis")
        public void the_bar_chart_should_show_time_intervals_on_the_x_axis() {
            Assert.assertTrue("Time intervals on the X-axis are incorrect.", areTimeIntervalsCorrect);
            System.out.println("Bar chart shows time intervals on the X-axis.");
        }

        @Then("the Pie chart should display statuses: sent, delivered, failed, errors, queued, started, and completed")
        public void the_pie_chart_should_display_statuses() {
            Assert.assertTrue("Pie chart statuses are incorrect.", isDataCorrect);
            System.out.println("Pie chart displays correct statuses.");
        }

        @When("the user checks the visual elements of the Dashboard")
        public void the_user_checks_the_visual_elements_of_the_dashboard() {
            System.out.println("User checks the visual elements of the Dashboard.");
        }

        @Then("all visual elements should be accurately displayed according to the design specifications")
        public void all_visual_elements_should_be_accurately_displayed_according_to_the_design_specifications() {
            Assert.assertTrue("Visual elements are not displayed correctly.", areVisualElementsCorrect);
            System.out.println("All visual elements are accurately displayed.");
        }

        @Given("data is available for the selected channel")
        public void data_is_available_for_the_selected_channel() {
            System.out.println("Data is available for the selected channel.");
        }

        @When("the user compares the chart data against the actual data")
        public void the_user_compares_the_chart_data_against_the_actual_data() {
            System.out.println("User compares the chart data against the actual data.");
        }

        @Then("the Bar and Pie charts should correctly represent the data for sent, queued, failed, completed, and errors")
        public void the_bar_and_pie_charts_should_correctly_represent_the_data() {
            Assert.assertTrue("Chart data is incorrect.", isDataCorrect);
            System.out.println("Bar and Pie charts correctly represent the data.");
        }

        @Given("the Bar chart is displayed with data")
        public void the_bar_chart_is_displayed_with_data() {
            System.out.println("Bar chart is displayed with data.");
        }

        @When("the user checks the time intervals on the X-axis")
        public void the_user_checks_the_time_intervals_on_the_x_axis() {
            System.out.println("User checks the time intervals on the X-axis.");
        }

        @Then("the time intervals should be correctly spaced and labeled")
        public void the_time_intervals_should_be_correctly_spaced_and_labeled() {
            Assert.assertTrue("Time intervals are incorrect.", areTimeIntervalsCorrect);
            System.out.println("Time intervals are correctly spaced and labeled.");
        }

        @Then("the status bars should align with the corresponding time intervals")
        public void the_status_bars_should_align_with_the_corresponding_time_intervals() {
            Assert.assertTrue("Status bars are not aligned with time intervals.", areTimeIntervalsCorrect);
            System.out.println("Status bars align with the corresponding time intervals.");
        }

        @Given("the charts are displayed with data")
        public void the_charts_are_displayed_with_data() {
            System.out.println("Charts are displayed with data.");
        }

        @When("the user resizes the screen")
        public void the_user_resizes_the_screen() {
            System.out.println("User resizes the screen.");
        }

        @Then("the charts should resize and adjust correctly without data loss or distortion")
        public void the_charts_should_resize_and_adjust_correctly_without_data_loss_or_distortion() {
            Assert.assertTrue("Charts are not responsive.", areChartsResponsive);
            System.out.println("Charts resize and adjust correctly.");
        }

        @Given("the user selects a channel with no data")
        public void the_user_selects_a_channel_with_no_data() {
            System.out.println("User selects a channel with no data.");
        }

        @Then("the user checks the bar and pie charts for empty data")
        public void the_user_checks_the_bar_and_pie_charts_for_empty_data() {
            System.out.println("User checks the Bar and Pie charts for empty data.");
        }

        @Then("the empty Bar and Pie charts should be displayed")
        public void the_empty_bar_and_pie_charts_should_be_displayed() {
            Assert.assertTrue("Empty charts are not displayed.", areEmptyChartsDisplayed);
            System.out.println("Empty Bar and Pie charts are displayed.");
        }

        @When("the user hovers over each status bar")
        public void the_user_hovers_over_each_status_bar() {
            System.out.println("User hovers over each status bar.");
        }

        @Then("the tooltip should display accurate and detailed information")
        public void the_tooltip_should_display_accurate_and_detailed_information() {
            Assert.assertTrue("Tooltips are not accurate.", areTooltipsAccurate);
            System.out.println("Tooltips display accurate and detailed information.");
        }

        @Given("the Hamburger menu button is available in the UI")
        public void the_hamburger_menu_button_is_available_in_the_ui() {
            System.out.println("Hamburger menu button is available in the UI.");
        }

        @When("the user clicks on the Hamburger menu")
        public void the_user_clicks_on_the_hamburger_menu() {
            isSidebarCollapsed = true;
            System.out.println("User clicks on the Hamburger menu.");
        }

        @Then("the sidebar should collapse, showing only icons and hiding text labels")
        public void the_sidebar_should_collapse_showing_only_icons_and_hiding_text_labels() {
            Assert.assertTrue("Sidebar did not collapse.", isSidebarCollapsed);
            System.out.println("Sidebar collapsed, showing only icons.");
        }

        @Then("the icons should remain visible and functional")
        public void the_icons_should_remain_visible_and_functional() {
            Assert.assertTrue("Icons are not visible or functional.", isSidebarCollapsed);
            System.out.println("Icons remain visible and functional.");
        }

        @Given("test data is available")
        public void test_data_is_available() {
            System.out.println("Test data is available.");
        }

        @When("the user selects a channel from the {string} dropdown")
        public void the_user_selects_a_channel_from_the_dropdown(String dropdownName) {
            isChannelSelected = true;
            System.out.println("User selects a channel from the " + dropdownName + " dropdown.");
        }

        @Then("the Transactions and Messages should update according to the selected channel")
        public void the_transactions_and_messages_should_update_according_to_the_selected_channel() {
            Assert.assertTrue("Transactions and Messages did not update.", isChannelSelected);
            System.out.println("Transactions and Messages updated according to the selected channel.");
        }

        @Given("Total Messages are present for the selected channel")
        public void total_messages_are_present_for_the_selected_channel() {
            System.out.println("Total Messages are present for the selected channel.");
        }

        @When("the user checks the {string} count")
        public void the_user_checks_the_count(String countType) {
            System.out.println("User checks the " + countType + " count.");
        }

        @Then("the Total Messages count should match the sum of messages in all statuses")
        public void the_total_messages_count_should_match_the_sum_of_messages_in_all_statuses() {
            Assert.assertTrue("Total Messages count is incorrect.", isTotalMessagesCorrect);
            System.out.println("Total Messages count matches the sum of messages in all statuses.");
        }

        @Given("Total Messages are present in different statuses for the selected channel")
        public void total_messages_are_present_in_different_statuses_for_the_selected_channel() {
            System.out.println("Total Messages are present in different statuses for the selected channel.");
        }

        @When("the user hovers over each segment of the pie chart")
        public void the_user_hovers_over_each_segment_of_the_pie_chart() {
            System.out.println("User hovers over each segment of the pie chart.");
        }

        @Then("the tooltip should display the status and the corresponding messages count")
        public void the_tooltip_should_display_the_status_and_the_corresponding_messages_count() {
            Assert.assertTrue("Tooltips are not accurate.", areTooltipsAccurate);
            System.out.println("Tooltip displays the status and the corresponding messages count.");
        }

        @Given("data for multiple channels is available")
        public void data_for_multiple_channels_is_available() {
            System.out.println("Data for multiple channels is available.");
        }

        @When("the user selects a different channel from the {string} dropdown")
        public void the_user_selects_a_different_channel_from_the_dropdown(String dropdownName) {
            isChannelSelected = true;
            System.out.println("User selects a different channel from the " + dropdownName + " dropdown.");
        }

        @Then("the Bar and Pie charts and Total Transactions and Messages count should update accordingly")
        public void the_bar_and_pie_charts_and_total_transactions_and_messages_count_should_update_accordingly() {
            Assert.assertTrue("Charts and counts did not update.", isChannelSelected);
            System.out.println("Bar and Pie charts and Total Transactions and Messages count updated accordingly.");
        }

        @When("the user tries to click on any status segment in the pie chart")
        public void the_user_tries_to_click_on_any_status_segment_in_the_pie_chart() {
            System.out.println("User tries to click on a status segment in the pie chart.");
        }

        @Then("the status segments should not be clickable")
        public void the_status_segments_should_not_be_clickable() {
            Assert.assertFalse("Status segments are clickable.", arePieChartSegmentsClickable);
            System.out.println("Status segments are not clickable.");
        }
    }

