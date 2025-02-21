package smsc_stepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import smsc_accelerators.SMSC_Actions;
import smsc_pageobjects.smsc_LoginObjects;
import smsc_utility.SMSC_Utils;

public class smsc_Login {
    WebDriver driver;

    @Given("the user is on the login page")
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
        driver.findElement(By.id("username")).sendKeys("validUser");
        driver.findElement(By.id("password")).sendKeys("validPassword");
    }

    @When("the user enters an invalid username and password")
    public void the_user_enters_an_invalid_username_and_password() {
        driver.findElement(By.id("username")).sendKeys("invalidUser");
        driver.findElement(By.id("password")).sendKeys("invalidPassword");
    }

    @When("the user leaves both the \"Username\" and \"Password\" fields blank")
    public void the_user_leaves_both_fields_blank() {

    }

    @When("clicks on the \"LOGIN\" button")
    public void clicks_on_the_login_button() {
        driver.findElement(By.id("loginButton")).click();
    }

    @Then("the user should be redirected to the dashboard")
    public void the_user_should_be_redirected_to_the_dashboard() {
        String expectedUrl = "http://ec2-3-250-127-29.eu-west-1.compute.amazonaws.com:8145/#/login";  // Update if needed
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
        driver.quit();
    }

    @Then("the user should see an error message \"Invalid Username or Password.\"")
    public void the_user_should_see_an_error_message() {
        WebElement errorMsg = driver.findElement(By.id("errorMessage"));
        Assert.assertTrue(errorMsg.isDisplayed());
        Assert.assertEquals("Invalid Username or Password.", errorMsg.getText());
        driver.quit();
    }

    @Then("all visual elements should be displayed as per the design specifications")
    public void all_visual_elements_should_be_displayed() {
        Assert.assertTrue(driver.findElement(By.id("logo")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("username")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("password")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("loginButton")).isDisplayed());
        driver.quit();
    }
}
