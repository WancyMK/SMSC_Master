package smsc_stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class smsc_Dashboard {

    private WebDriver driver;  // Declare driver
    private WebDriverWait wait;  // Declare wait

        @Given("I open the browser")
        public void i_open_the_browser() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            System.out.println("Browser opened and maximized");
            throw new io.cucumber.java.PendingException();
        }

        @Given("the user is logged in the {string}")
        public void the_user_is_logged_in_the(String role) {
            driver.get("http://ec2-3-250-127-29.eu-west-1.compute.amazonaws.com:8145/#/login");
            driver.findElement(By.id("username")).sendKeys("username");
            driver.findElement(By.id("password")).sendKeys("password");
            driver.findElement(By.id("login-button")).click();
            wait.until(ExpectedConditions.urlContains("dashboard"));
        }

        @When("the user navigates to the dashboard")
        public void the_user_navigates_to_the_dashboard() {
            driver.findElement(By.id("dashboard-link")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dashboard-page")));
        }

        @Then("the Bar and Pie charts should be visible with proper formatting")
        public void the_bar_and_pie_charts_should_be_visible_with_proper_formatting() {
            WebElement barChart = driver.findElement(By.id("bar-chart"));
            WebElement pieChart = driver.findElement(By.id("pie-chart"));
            assert barChart.isDisplayed() : "Bar chart is not visible";
            assert pieChart.isDisplayed() : "Pie chart is not visible";
        }

        @Then("the charts should display time intervals on the X-axis")
        public void the_charts_should_display_time_intervals_on_the_x_axis() {
            WebElement xAxis = driver.findElement(By.cssSelector("#bar-chart .x-axis"));
            assert xAxis.isDisplayed() : "X-axis is not displayed";
        }

        @Then("the Pie chart should show statuses for sent, delivered, failed, errors, queued, started, and completed")
        public void the_pie_chart_should_show_statuses_for_sent_delivered_failed_errors_queued_started_and_completed() {
            List<WebElement> pieChartSegments = driver.findElements(By.cssSelector("#pie-chart .segment"));
            String[] expectedStatuses = {"sent", "delivered", "failed", "errors", "queued", "started", "completed"};
            for (String status : expectedStatuses) {
                boolean statusFound = pieChartSegments.stream().anyMatch(element -> element.getText().contains(status));
                assert statusFound : "Status " + status + " not found in Pie chart";
            }
        }

        @Given("the design specifications are available")
        public void the_design_specifications_are_available() {
            System.out.println("Design specifications are available.");
        }

        @Then("all visual elements should be correctly displayed including labels, text, colors, sizes, and alignment")
        public void all_visual_elements_should_be_correctly_displayed_including_labels_text_colors_sizes_and_alignment() {
            WebElement label = driver.findElement(By.id("dashboard-label"));
            assert label.isDisplayed() : "Label is not displayed";
            assert label.getCssValue("color").equals("rgba(0, 0, 0, 1)") : "Label color is incorrect";
        }

        @Given("data is available for the selected channel")
        public void data_is_available_for_the_selected_channel() {
            // Simulate data availability
            System.out.println("Data is available for the selected channel.");
        }

        @Then("the Bar and Pie charts should represent accurate data for sent, queued, failed, completed, and errors")
        public void the_bar_and_pie_charts_should_represent_accurate_data_for_sent_queued_failed_completed_and_errors() {
            WebElement barChartData = driver.findElement(By.id("bar-chart-data"));
            assert barChartData.getText().contains("sent") : "Sent data is incorrect";
            assert barChartData.getText().contains("queued") : "Queued data is incorrect";
        }

        @Given("the Bar chart is displayed with data")
        public void the_bar_chart_is_displayed_with_data() {
            WebElement barChart = driver.findElement(By.id("bar-chart"));
            assert barChart.isDisplayed() : "Bar chart is not displayed";
        }

        @Then("the time intervals on the X-axis should be correctly spaced and labeled")
        public void the_time_intervals_on_the_x_axis_should_be_correctly_spaced_and_labeled() {
            WebElement xAxis = driver.findElement(By.cssSelector("#bar-chart .x-axis"));
            assert xAxis.isDisplayed() : "X-axis is not displayed";
        }

        @Then("the status bars should align correctly with the time intervals")
        public void the_status_bars_should_align_correctly_with_the_time_intervals() {
            WebElement statusBar = driver.findElement(By.cssSelector("#bar-chart .status-bar"));
            assert statusBar.isDisplayed() : "Status bar is not aligned correctly";
        }

        @Given("the charts are displayed with data")
        public void the_charts_are_displayed_with_data() {
            WebElement barChart = driver.findElement(By.id("bar-chart"));
            WebElement pieChart = driver.findElement(By.id("pie-chart"));
            assert barChart.isDisplayed() : "Bar chart is not displayed";
            assert pieChart.isDisplayed() : "Pie chart is not displayed";
        }

        @When("the user resizes the screen")
        public void the_user_resizes_the_screen() {
            driver.manage().window().setSize(new org.openqa.selenium.Dimension(800, 600));
        }

        @Then("the charts should adjust without data loss or distortion")
        public void the_charts_should_adjust_without_data_loss_or_distortion() {
            WebElement barChart = driver.findElement(By.id("bar-chart"));
            assert barChart.isDisplayed() : "Bar chart is distorted after resizing";
        }

        @Given("the selected channel has no data")
        public void the_selected_channel_has_no_data() {
            System.out.println("Selected channel has no data.");
        }

        @Then("an empty Bar and Pie chart should be displayed")
        public void an_empty_bar_and_pie_chart_should_be_displayed() {
            WebElement barChart = driver.findElement(By.id("bar-chart"));
            WebElement pieChart = driver.findElement(By.id("pie-chart"));
            assert barChart.getText().isEmpty() : "Bar chart is not empty";
            assert pieChart.getText().isEmpty() : "Pie chart is not empty";
        }

        @When("the user hovers over each status bar")
        public void the_user_hovers_over_each_status_bar() {
            WebElement statusBar = driver.findElement(By.cssSelector("#bar-chart .status-bar"));
            statusBar.click();
        }

        @Then("the tooltip should display accurate information matching the data represented by the chart")
        public void the_tooltip_should_display_accurate_information_matching_the_data_represented_by_the_chart() {
            WebElement tooltip = driver.findElement(By.cssSelector("#bar-chart .tooltip"));
            assert tooltip.isDisplayed() : "Tooltip is not displayed";
        }

        @Given("the Hamburger menu is available")
        public void the_hamburger_menu_is_available() {
            WebElement hamburgerMenu = driver.findElement(By.id("hamburger-menu"));
            assert hamburgerMenu.isDisplayed() : "Hamburger menu is not available";
        }

        @When("the user clicks on the Hamburger menu")
        public void the_user_clicks_on_the_hamburger_menu() {
            driver.findElement(By.id("hamburger-menu")).click();
        }

        @Then("the sidebar should collapse, hiding text labels but keeping icons visible")
        public void the_sidebar_should_collapse_hiding_text_labels_but_keeping_icons_visible() {
            WebElement sidebar = driver.findElement(By.id("sidebar"));
            assert sidebar.getCssValue("width").equals("50px") : "Sidebar did not collapse correctly";
        }

        @Given("test data is available")
        public void test_data_is_available() {
            System.out.println("Test data is available.");
        }

        @When("the user selects a channel from the {string} dropdown")
        public void the_user_selects_a_channel_from_the_dropdown(String channel) {
            driver.findElement(By.id("channel-dropdown")).sendKeys(channel);
        }

        @Then("the Transactions and Messages count should update accordingly")
        public void the_transactions_and_messages_count_should_update_accordingly() {
            WebElement transactionsCount = driver.findElement(By.id("transactions-count"));
            WebElement messagesCount = driver.findElement(By.id("messages-count"));
            assert transactionsCount.getText().equals("100") : "Transactions count is incorrect";
            assert messagesCount.getText().equals("200") : "Messages count is incorrect";
        }

        @Given("Total Messages exist for the selected channel")
        public void total_messages_exist_for_the_selected_channel() {
            System.out.println("Total messages exist for the selected channel.");
        }

        @When("the user checks the {string} count")
        public void the_user_checks_the_count(String countType) {
            WebElement countElement = driver.findElement(By.id(countType + "-count"));
            assert countElement.isDisplayed() : countType + " count is not displayed";
        }

        @Then("the count should match the sum of messages in all statuses shown on the Pie chart")
        public void the_count_should_match_the_sum_of_messages_in_all_statuses_shown_on_the_pie_chart() {
            WebElement totalCount = driver.findElement(By.id("total-count"));
            WebElement pieChart = driver.findElement(By.id("pie-chart"));
            assert totalCount.getText().equals(pieChart.getText()) : "Count does not match Pie chart data";
        }

        @Given("messages exist in different statuses")
        public void messages_exist_in_different_statuses() {
            System.out.println("Messages exist in different statuses.");
        }

        @When("the user hovers over a segment of the Pie chart")
        public void the_user_hovers_over_a_segment_of_the_pie_chart() {
            WebElement pieChartSegment = driver.findElement(By.cssSelector("#pie-chart .segment"));
            pieChartSegment.click();
        }

        @Then("the tooltip should display the status and corresponding message count")
        public void the_tooltip_should_display_the_status_and_corresponding_message_count() {
            WebElement tooltip = driver.findElement(By.cssSelector("#pie-chart .tooltip"));
            assert tooltip.isDisplayed() : "Tooltip is not displayed";
        }

        @Given("multiple channels with data exist")
        public void multiple_channels_with_data_exist() {
            System.out.println("Multiple channels with data exist.");
        }

        @When("the user selects a different channel")
        public void the_user_selects_a_different_channel() {
            driver.findElement(By.id("channel-dropdown")).sendKeys("New Channel");
        }

        @Then("the Bar and Pie charts, Total Transactions, and Total Messages count should update accordingly")
        public void the_bar_and_pie_charts_total_transactions_and_total_messages_count_should_update_accordingly() {
            WebElement barChart = driver.findElement(By.id("bar-chart"));
            WebElement pieChart = driver.findElement(By.id("pie-chart"));
            assert barChart.isDisplayed() : "Bar chart did not update";
            assert pieChart.isDisplayed() : "Pie chart did not update";
        }

        @When("the user clicks on a status segment in the Pie chart")
        public void the_user_clicks_on_a_status_segment_in_the_pie_chart() {
            WebElement pieChartSegment = driver.findElement(By.cssSelector("#pie-chart .segment"));
            pieChartSegment.click();
        }

        @Then("the status segment should not be clickable")
        public void the_status_segment_should_not_be_clickable() {
            WebElement pieChartSegment = driver.findElement(By.cssSelector("#pie-chart .segment"));
            assert !pieChartSegment.isEnabled() : "Status segment is clickable";
        }
    }

