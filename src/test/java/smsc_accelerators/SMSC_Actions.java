package smsc_accelerators;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import smsc_utility.Logs;
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
    public static Actions builder;
    public static void jsClickOnElement(By object, String elementName) {
        try {
            if(!driver.findElements(object).isEmpty()) {
                WebElement webElement = driver.findElement(object);
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].click();", webElement);
            }
            else {
                SMSC_ExceptionHandler.HandleAssertion("Unable to Click on element " + elementName);
            }
        } catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Failed to click on:" + elementName);
        }
    }
    public static void clickOnElement(By object,String elementName) {
        try {
            if(!driver.findElements(object).isEmpty()) {
                driver.findElement(object).click();
            }
            else {
                SMSC_ExceptionHandler.HandleAssertion("Unable to Click on element " + elementName);
            }
        } catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Failed to click on:" + elementName);
        }
    }
    public static boolean isMenuSelected(By object,String elementName) {
        boolean selected=false;
        try {
            if(!driver.findElements(object).isEmpty()) {
                selected= true;
            }
            else {
                SMSC_ExceptionHandler.HandleAssertion("Unable to Display element" + elementName);
            }
        } catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Failed to select Menu:" + elementName);
        }
        return selected;
    }

    public static void CompareUIContent(String data, By object,String elementName) {
        try {
            String text = getElementText(object,elementName).toLowerCase();
            //				SMSC_ExceptionHandler.HandleAssertion(elementName +" is invalidated (is not equals)");
        }
        catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Unable to compare UI Content for " + elementName);
        }
    }
    public static void ComparePDFWithUI(String AtcualText, By object,String elementName) {
        try {
            if(!AtcualText.toLowerCase().contains(getElementText(object,elementName).toLowerCase())) {
                SMSC_ExceptionHandler.HandleAssertion(elementName +" is invalid");
            }
        }
        catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Failed to compare Pdf and UI : "+elementName);
        }
    }
    public static void ComparePDFWithUserInputData(String AtcualText, String Data,String elementName) {
        try {
            if(!AtcualText.toLowerCase().trim().contains(Data.toLowerCase().trim()))
            {
                SMSC_ExceptionHandler.HandleAssertion(elementName +" is not valid(not found on the PDF)");
            }
        }
        catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Failed to compare Pdf and Data for : "+elementName);
        }
    }
    public static void ClickViaMouse(By object,String elementName) {
        try {
            if(!driver.findElements(object).isEmpty()) {
                WebElement mo = driver.findElement(object);
                new Actions(driver).moveToElement(mo).click().build().perform();
            }
            else {
                SMSC_ExceptionHandler.HandleAssertion("Unable to click on element " + elementName);
            }
        } catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Failed to click on " + elementName );
        }
    }

    public static void CompareValues(String value1, String value2,String elementName) {
        String v1= value1.toLowerCase().trim();
        String v2 =value2.toLowerCase().trim();
        try {
            if(!v1.contains(v2)){
                SMSC_ExceptionHandler.HandleAssertion(elementName +" is invalidated (has an empty value)");
            }

        } catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Failed to verify " + elementName );
        }
    }
    public static void CompareData(By object, String value, String elementName) {
        try {
            String text = "";

            if(!driver.findElements(object).isEmpty()) {
                text = driver.findElement(object).getText();
                if(!text.isEmpty()){
                    if(value.trim().isEmpty())
                    {
                        SMSC_ExceptionHandler.HandleAssertion(elementName +" is invalidated (has an empty value)");
                    }
                }
            }
            else {
                SMSC_ExceptionHandler.HandleAssertion("Unable to find element " + elementName);
            }
        } catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Failed to verify " + elementName );
        }
    }

    public static void SwitchTabs() {
        try {
            Set<String> windows = driver.getWindowHandles();
            String sCurrentHandle = driver.getWindowHandle();
            for (String window:windows)
            {
                if(!sCurrentHandle.equalsIgnoreCase(window))
                {
                    driver.switchTo().window(window);
                }
            }
        } catch(Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Unable to Switch Tabs");
        }
    }

    //Function to get text
    public static String getElementText(By object,String elementName) {
        String sText="";
        try {
            if(!driver.findElements(object).isEmpty()) {
                sText=driver.findElement(object).getText();
            }
            else {
                SMSC_ExceptionHandler.HandleAssertion("Unable to find element " + elementName);
            }
        }
        catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Failed to get text from element: " + elementName);
        }
        return sText;
    }

    //Function to type in text box
    public static void typeInTextBox(By object,String data,String elementName) {
        try {
            if(!driver.findElements(object).isEmpty()) {
                driver.findElement(object).clear();
                driver.findElement(object).sendKeys(data);
            }
            else {
                SMSC_ExceptionHandler.HandleAssertion("Unable to find element " + elementName);
            }
        } catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Failed to enter data in " + elementName + " textbox");
        }
    }

    public static boolean isElementVisible(By object,String elementName) {
        boolean bFlag = false;
        try {
            if(!driver.findElements(object).isEmpty()) {
                bFlag= true;
            }
        } catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Unable to check if the " + elementName +" element is visible or not");
        }
        return bFlag;
    }
    public static boolean isElementVisibleDispatch(By object,String elementName) throws Exception {
        boolean bFlag = false;
        try {
            if(driver.findElements(object).size() > 0) {
                bFlag= true;
            }
        } catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Unable to check if the " + elementName +" element is visible or not");
        }
        return bFlag;
    }
    public static boolean isElementNotVisible(By object,String elementName) {
        boolean bFlag = false;
        try {
            WebElement element = driver.findElement(object);
            return !element.isDisplayed();
        } catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Unable to check if the " + elementName +" element is visible or not");
        }
        return bFlag;
    }

    public static boolean waitForElement(By Locator, long lTime) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(lTime));
            wait.until(ExpectedConditions.elementToBeClickable(Locator));
            return true;
        } catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Failed to wait for element to be visible");
            return false;
        }
    }
    public static boolean waitForElementTextToBePresent(WebDriver driver, By locator, long timeInSeconds, String text) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
            return wait.until(ExpectedConditions.textToBe(locator, text));
        } catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Failed to wait for text to be present in element");
            return false; // Return false on failure
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
    public static boolean waitForTextMatch(By locator, String expectedText, long timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            wait.until(d -> driver.findElement(locator).getText().equals(expectedText));
            return true;
        } catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Failed to wait for text match: " + expectedText);
            return false;
        }
    }
    //    public static boolean waitForElementToBeInvisible(By Locator, long lTime) {
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, lTime);
//            wait.until(ExpectedConditions.invisibilityOfElementLocated(Locator));
//            return true;
//        } catch (Exception e) {
//            SMSC_ExceptionHandler.HandleException(e, "Failed to wait for element to be invisible");
//            return true;
//        }
//    }
    //Get current date in any format
    public static String getCurrentDate(String strFormat)
    {
        try{
            DateFormat dateFormat = new SimpleDateFormat(strFormat);
            Date dateObj = new Date();
            return dateFormat.format(dateObj);
        } catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Failed to get Current Date:" + strFormat);
            return null;
        }
    }

    public static void mouseover(By objLocator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement element = wait.ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.visibilityOfElementLocated(objLocator));

            Actions actions = new Actions(driver);
            actions.moveToElement(element).perform();

        } catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Failed to hover over element: " + objLocator);
        }}

    //Select by visible text
    public static void selectByVisibleText(By objLocator, String sVisibletext) throws Throwable {
        try {
            if (isElementVisible(objLocator, sVisibletext)) {

                Select s = new Select(driver.findElement(objLocator));
                s.selectByVisibleText(sVisibletext);
            }
            else {
                SMSC_ExceptionHandler.HandleAssertion("Unable to Select visible text" + sVisibletext);
            }

        } catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Failed to select visible text: " + sVisibletext);
        }
    }

    //Select by value
    public static void selectByIndex(By objLocator, String sText) throws Throwable {
        try {

            if (isElementVisible(objLocator, sText)) {

                Select s = new Select(driver.findElement(objLocator));
                s.selectByValue(sText);
            }
            else {
                SMSC_ExceptionHandler.HandleAssertion("Unable to find" + sText);
            }
        } catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Failed to select value text " + sText);
        }
    }

    //Verify if element is enabled
    public static boolean isElementEnabled(By objLocator) throws Throwable {
        boolean bflag=false;
        try {
            if (driver.findElement(objLocator).isEnabled()) {
                bflag=true;
            }

        } catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Failed to check if element is enabled");
        }
        return bflag;
    }
    public static String GetScreenShot() throws Exception
    {
        String sScreenShotNameWithPath = null;

        try {
            Date oDate = new Date();
            SimpleDateFormat oSDF = new SimpleDateFormat("yyyyMMddHHmmss");
            String sDate = oSDF.format(oDate);

            File fScreenshot = ((TakesScreenshot)SMSC_Base.driver).getScreenshotAs(OutputType.FILE);
            sScreenShotNameWithPath = System.getProperty("user.dir")+"\\WinDeedData\\Screenshots\\"+"Screenshot_" + sDate + ".png";
            FileUtils.copyFile(fScreenshot, new File(sScreenShotNameWithPath));
        } catch (Exception e) {
            SMSC_ExceptionHandler.HandleScreenShotException(e, "Failed to get screen shot");
        }

        return sScreenShotNameWithPath;
    }

    public static List<WebElement> getElements(By Obj) throws Throwable{
        List<WebElement> webele=null;
        try {
            webele=driver.findElements(Obj);
        }  catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Failed to getElement");
        }
        return webele;
    }

    //Function to clear the textbox
    public static void clearTextbox(By object,String elementName) {
        try {
            if(!driver.findElements(object).isEmpty()) {
                driver.findElement(object).clear();
            } else SMSC_ExceptionHandler.HandleAssertion("Unable to find Element");
        }
        catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e,"Failed to clear text from " + elementName);
        }
    }
    // Method to scroll to the bottom of the page
    public static void scrollToBottom() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(2000);
    }

    public static String getAttributeValue(By object, String attributeName, String elementName) {
        String attributeValue = "";
        try {
            if (!driver.findElements(object).isEmpty()) {
                WebElement element = driver.findElement(object);
                attributeValue = element.getAttribute(attributeName);
                if (attributeValue == null) {  // Handle null attributes
                    attributeValue = "";
                }
            } else {
                SMSC_ExceptionHandler.HandleAssertion("Unable to find element " + elementName);
            }
        } catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Failed to get attribute '" + attributeName + "' from element: " + elementName);
        }
        return attributeValue;
    }

    public static void FileUpload(By object,String filepath) throws Exception {
        try {
            Thread.sleep(3000);
            String absoluteFilePath = System.getProperty("user.dir") + "/" + filepath;

            SMSC_Base.driver.findElement(object).sendKeys(absoluteFilePath);
            Logs.info("File is selected Successfully");

        } catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Unable to select file");
        }
    }

    public static boolean waitForElementToDisappear(By object, String elementName) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            return wait.until(ExpectedConditions.invisibilityOfElementLocated(object));
        } catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Failed to verify the disappearance of " + elementName);
            return false;
        }
    }

    // Function to get text from an element
    public static String getElementTextInput(By object, String elementName) {
        String sText = "";
        try {
            if (!driver.findElements(object).isEmpty()) {
                WebElement element = driver.findElement(object);
                if (element.getTagName().equalsIgnoreCase("input") || element.getTagName().equalsIgnoreCase("textarea")) {
                    sText = element.getAttribute("value"); // Use getAttribute("value") for input fields
                } else {
                    sText = element.getText(); // Use getText() for other elements
                }
            } else {
                SMSC_ExceptionHandler.HandleAssertion("Unable to find element " + elementName);
            }
        } catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Failed to get text from element: " + elementName);
        }
        return sText;
    }
}

