package smsc_pageobjects;

import org.openqa.selenium.By;

public class SMSC_References_PageObjects {
    public static final By referencesSideBar = By.xpath("//p[text()='References']");
    public static final By createNewReferenceButton = By.xpath("//button[text()='Create New Reference']");
    public static final By referenceName = By.xpath("//input[@name='name']");
    public static final By reference = By.xpath("//input[@name='reference']");
    public static final By partyType = By.xpath("//div[@id='mui-component-select-partyType']");
    public static final By partyTypeOption = By.xpath("//li[text()='Individual']");
    public static final By emailAddress = By.xpath("//input[@name='email']");
    public static final By contactNumber = By.xpath("//input[@name='contact']");
    public static final By description = By.xpath("//textarea[@name='description']");

// Mandatory fields error messages
    public static final By errorReferenceName = By.xpath("//p[text()='Name is required']");
    public static final By errorReference = By.xpath("//p[text()='Reference is required']");
    public static final By errorPartyType = By.xpath("//p[text()='Party Type is required']");
    public static final By errorEmailAddress = By.xpath("//p[text()='Email is required']");
    public static final By errorContactNumber = By.xpath("//p[text()='Contact is required']");
    public static final By errorDescription = By.xpath("//p[text()='Description is required']");

    public static final By validateReferenceCreated = By.xpath("//div[@class='main-content-home']/div/div/following-sibling::div/div/table/tbody/tr/td/following-sibling::td/following-sibling::td");
//    public static final By  = By.xpath("");
//    public static final By  = By.xpath("");
//    public static final By  = By.xpath("");
//    public static final By  = By.xpath("");
//    public static final By  = By.xpath("");
//    public static final By  = By.xpath("");
//    public static final By  = By.xpath("");
}