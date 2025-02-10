package smsc_pageobjects;

import org.openqa.selenium.By;

public class SMSC_References_PageObjects {
    public static final By referencesSideBar_btn = By.xpath("//p[text()='References']");
    public static final By createNewReference_btn = By.xpath("//button[text()='Create New Reference']");
    public static final By referenceName_txtb = By.xpath("//input[@name='name']");
    public static final By reference_txtb = By.xpath("//input[@name='reference']");
    public static final By partyType_dropdown = By.xpath("//div[@id='mui-component-select-partyType']");
    public static final By partyTypeOption_dropdown = By.xpath("//li[text()='Individual']");
    public static final By emailAddress_txtb = By.xpath("//input[@name='email']");
    public static final By contactNumber_txtb = By.xpath("//input[@name='contact']");
    public static final By description_txtb = By.xpath("//textarea[@name='description']");

// Mandatory fields error messages
    public static final By errorReferenceName_txt = By.xpath("//p[text()='Name is required']");
    public static final By errorReference_txt = By.xpath("//p[text()='Reference is required']");
    public static final By errorPartyType_txt = By.xpath("//p[text()='Party Type is required']");
    public static final By errorEmailAddress_txt = By.xpath("//p[text()='Email is required']");
    public static final By errorContactNumber_txt = By.xpath("//p[text()='Contact is required']");
    public static final By errorDescription_txt = By.xpath("//p[text()='Description is required']");

    public static final By validateReferenceCreated_txt = By.xpath("//div[@class='main-content-home']/div/div/following-sibling::div/div/table/tbody/tr/td/following-sibling::td/following-sibling::td");
    public static final By searchErrorMessage = By.xpath("//td[text()='No Reference found.']");
//    public static final By  = By.xpath("");
//    public static final By  = By.xpath("");
//    public static final By  = By.xpath("");
//    public static final By  = By.xpath("");
//    public static final By  = By.xpath("");
//    public static final By  = By.xpath("");
}