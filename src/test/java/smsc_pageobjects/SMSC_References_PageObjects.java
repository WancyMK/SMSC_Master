package smsc_pageobjects;

import org.openqa.selenium.By;

public class SMSC_References_PageObjects {
    public static final By referencesSideBar = By.xpath("//p[text()='References']");
    public static final By createNewReferenceButton = By.xpath("//button[text()='Create New Reference']");
    public static final By referenceName = By.xpath("//input[@id=':r6:']");
    public static final By reference = By.xpath("//input[@id=':r7:']");
    public static final By partyType = By.xpath("//div[@id='mui-component-select-partyType']");
    public static final By partyTypeOption = By.xpath("//li[text()='Individual']");
    public static final By emailAddress = By.xpath("//input[@id=':r9:']");
    public static final By contactNumber = By.xpath("//input[@id=':ra:']");
    public static final By description = By.xpath("//textarea[@id=':rb:']");

// Mandatory fields error messages
    public static final By errorReferenceName = By.xpath("//p[@id=':r4s:-helper-text']");
    public static final By errorReference = By.xpath("//p[@id=':r4t:-helper-text']");
    public static final By errorPartyType = By.xpath("//p[text()='Party Type is required']");
    public static final By errorEmailAddress = By.xpath("//p[@id=':r4v:-helper-text']");
    public static final By errorContactNumber = By.xpath("//p[@id=':r50:-helper-text']");
    public static final By errorDescription = By.xpath("//p[@id=':r51:-helper-text']");

    public static final By validateReferenceCreated = By.xpath("//div[@class='main-content-home']/div/div/following-sibling::div/div/table/tbody/tr/td/following-sibling::td/following-sibling::td");
//    public static final By  = By.xpath("");
//    public static final By  = By.xpath("");
//    public static final By  = By.xpath("");
//    public static final By  = By.xpath("");
//    public static final By  = By.xpath("");
//    public static final By  = By.xpath("");
//    public static final By  = By.xpath("");
}