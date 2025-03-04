package smsc_accelerators;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import smsc_utility.SMSC_ExceptionHandler;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static smsc_accelerators.SMSC_Base.driver;

public class SMSC_Actions {
    public static String sTestCaseName;

    public static void jsClickOnElement(By object, String elementName) {
        try {
            if (!driver.findElements(object).isEmpty()) {
                WebElement webElement = driver.findElement(object);
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].click();", webElement);
            } else {
                SMSC_ExceptionHandler.HandleAssertion("Unable to click on element " + elementName);
            }
        } catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Failed to click on: " + elementName);
        }
    }

    public static void clickOnElement(By object, String elementName) {
        try {
            if (!driver.findElements(object).isEmpty()) {
                driver.findElement(object).click();
            } else {
                SMSC_ExceptionHandler.HandleAssertion("Unable to click on element " + elementName);
            }
        } catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Failed to click on: " + elementName);
        }
    }

    public static boolean isMenuSelected(By object, String elementName) {
        boolean selected = false;
        try {
            if (!driver.findElements(object).isEmpty()) {
                selected = true;
            } else {
                SMSC_ExceptionHandler.HandleAssertion("Unable to display element " + elementName);
            }
        } catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Failed to select menu: " + elementName);
        }
        return selected;
    }

    public static void compareUIContent(String data, By object, String elementName) {
        try {
            String text = getElementText(object).toLowerCase();
            if (!text.contains(data.toLowerCase())) {
                SMSC_ExceptionHandler.HandleAssertion(elementName + " is invalidated (does not match expected content)");
            }
        } catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Unable to compare UI content for " + elementName);
        }
    }

    public static void comparePDFWithUI(String actualText, By object, String elementName) {
        try {
            if (!actualText.toLowerCase().contains(getElementText(object).toLowerCase())) {
                SMSC_ExceptionHandler.HandleAssertion(elementName + " is invalid");
            }
        } catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Failed to compare PDF and UI: " + elementName);
        }
    }

    public static void comparePDFWithUserInputData(String actualText, String data, String elementName) {
        try {
            if (!actualText.toLowerCase().trim().contains(data.toLowerCase().trim())) {
                SMSC_ExceptionHandler.HandleAssertion(elementName + " is not valid (not found in the PDF)");
            }
        } catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Failed to compare PDF and data for: " + elementName);
        }
    }

    public static void clickViaMouse(By object, String elementName) {
        try {
            if (!driver.findElements(object).isEmpty()) {
                WebElement mo = driver.findElement(object);
                new Actions(driver).moveToElement(mo).click().build().perform();
            } else {
                SMSC_ExceptionHandler.HandleAssertion("Unable to click on element " + elementName);
            }
        } catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Failed to click on " + elementName);
        }
    }

    public static void compareValues(String value1, String value2, String elementName) {
        String v1 = value1.toLowerCase().trim();
        String v2 = value2.toLowerCase().trim();
        try {
            if (!v1.contains(v2)) {
                SMSC_ExceptionHandler.HandleAssertion(elementName + " is invalidated (does not match expected value)");
            }
        } catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Failed to verify " + elementName);
        }
    }

    public static void compareData(By object, String value, String elementName) {
        try {
            if (!driver.findElements(object).isEmpty()) {
                String text = driver.findElement(object).getText().trim();
                if (text.isEmpty() || !text.equals(value.trim())) {
                    SMSC_ExceptionHandler.HandleAssertion(elementName + " is invalidated (has an unexpected or empty value)");
                }
            } else {
                SMSC_ExceptionHandler.HandleAssertion("Unable to find element " + elementName);
            }
        } catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Failed to verify " + elementName);
        }
    }

    public static void switchTabs() {
        try {
            Set<String> windows = driver.getWindowHandles();
            String currentHandle = driver.getWindowHandle();
            for (String window : windows) {
                if (!currentHandle.equalsIgnoreCase(window)) {
                    driver.switchTo().window(window);
                    break; // Exit after switching to the first different tab
                }
            }
        } catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Unable to switch tabs");
        }
    }

    public static String getElementText(By object) {
        String sText = "";
        try {
            if (!driver.findElements(object).isEmpty()) {
                sText = driver.findElement(object).getText().trim();
            } else {
                SMSC_ExceptionHandler.HandleAssertion("Unable to find element");
            }
        } catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Failed to get text from element");
        }
        return sText;
    }

    public static void typeInTextBox(By object, String data, String elementName) {
        try {
            if (!driver.findElements(object).isEmpty()) {
                WebElement element = driver.findElement(object);
                element.clear();
                element.sendKeys(data);
            } else {
                SMSC_ExceptionHandler.HandleAssertion("Unable to find element " + elementName);
            }
        } catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Failed to enter data in " + elementName + " textbox");
        }
    }

    public static boolean isElementVisible(By object, String elementName) {
        try {
            return !driver.findElements(object).isEmpty() && driver.findElement(object).isDisplayed();
        } catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Unable to check if the " + elementName + " element is visible");
            return false;
        }
    }

    public static boolean isElementNotVisible(By object, String elementName) {
        try {
            return driver.findElements(object).isEmpty() || !driver.findElement(object).isDisplayed();
        } catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Unable to check if the " + elementName + " element is not visible");
            return true;
        }
    }

    public static boolean waitForElementTextToBePresent(WebDriver driver, By locator, long timeInSeconds, String expectedText) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return wait.until(d -> {
                WebElement element = d.findElement(locator);
                String actualText = element.getText().trim();
                System.out.println("DEBUG: Actual text found - '" + actualText + "'");
                return actualText.contains(expectedText);
            });
        } catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Failed to wait for text to be present in element");
            return false;
        }
    }

    public static void waitForElementToBeVisible(By locator, long timeInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Failed to wait for element to be visible");
        }
    }

    public static String getCurrentDate(String strFormat) {
        try {
            DateFormat dateFormat = new SimpleDateFormat(strFormat);
            Date dateObj = new Date();
            return dateFormat.format(dateObj);
        } catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Failed to get current date: " + strFormat);
            return null;
        }
    }

    public static void selectByVisibleText(By objLocator, String sVisibleText) {
        try {
            if (isElementVisible(objLocator, sVisibleText)) {
                Select select = new Select(driver.findElement(objLocator));
                select.selectByVisibleText(sVisibleText);
            } else {
                SMSC_ExceptionHandler.HandleAssertion("Unable to select visible text " + sVisibleText);
            }
        } catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Failed to select visible text: " + sVisibleText);
        }
    }

    public static void selectByValue(By objLocator, String sValue) {
        try {
            if (isElementVisible(objLocator, sValue)) {
                Select select = new Select(driver.findElement(objLocator));
                select.selectByValue(sValue);
            } else {
                SMSC_ExceptionHandler.HandleAssertion("Unable to find element for value " + sValue);
            }
        } catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Failed to select value " + sValue);
        }
    }

    public static boolean isElementEnabled(By objLocator) {
        try {
            return driver.findElement(objLocator).isEnabled();
        } catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Failed to check if element is enabled");
            return false;
        }
    }

    public static String getScreenShot() {
        String screenShotPath = null;
        try {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            String dateStr = sdf.format(date);
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            screenShotPath = System.getProperty("user.dir") + "\\WinDeedData\\Screenshots\\" + "Screenshot_" + dateStr + ".png";
            FileUtils.copyFile(screenshot, new File(screenShotPath));
        } catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Failed to capture screenshot");
        }
        return screenShotPath;
    }

    public static List<WebElement> getElements(By obj) {
        try {
            return driver.findElements(obj);
        } catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Failed to get elements");
            return null;
        }
    }

    public static void clearTextBox(By object, String elementName) {
        try {
            if (!driver.findElements(object).isEmpty()) {
                driver.findElement(object).clear();
            } else {
                SMSC_ExceptionHandler.HandleAssertion("Unable to find element " + elementName);
            }
        } catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Failed to clear text from " + elementName);
        }
    }

    public static void scrollToBottom() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            Thread.sleep(2000);
        } catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Failed to scroll to bottom");
        }
    }

    public static String getText(WebElement element) {
        try {
            return element.getText().trim();
        } catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Failed to get text from WebElement");
            return "";
        }
    }

}

