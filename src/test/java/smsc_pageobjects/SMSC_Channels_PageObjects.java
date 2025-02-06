package smsc_pageobjects;

import org.openqa.selenium.By;

public class SMSC_Channels_PageObjects {
    public static final By channelSideBar = By.xpath("//p[text()='Channels']");
    public static final By createNewChannelButton = By.xpath("//button[text()='Create New Channel']");
    public static final By channelName = By.xpath("//input[@id=':r3r:']");
    public static final By host = By.xpath("//input[@id=':r3s:']");
    public static final By port = By.xpath("//input[@id=':r3t:']");
    public static final By systemID = By.xpath("//input[@id=':r3u:']");
    public static final By password = By.xpath("//input[@id=':r3v:']");
    public static final By serviceType = By.xpath("//input[@id=':r40:']");
    public static final By priority = By.xpath("//input[@id=':r41:']");
    public static final By sourceAddress = By.xpath("//input[@id=':r42:']");
    public static final By status = By.xpath("//div[@role='combobox']");
    public static final By statusOption = By.xpath("//li[text()='Active']");
    public static final By provider = By.xpath("//input[@id=':r44:']");
    public static final By multiForBulk = By.xpath("//div[@id='mui-component-select-useMultiForBulk']");
    public static final By multiForBulkOption = By.xpath("//li[text()='no']");
    public static final By filters = By.xpath("//input[@id=':r46:']");
    public static final By createButton = By.xpath("//button[text()='Create']");
    public static final By cancelButton = By.xpath("//button[text()='Cancel']");
    public static final By updateButton = By.xpath("//button[text()='Update']");
    public static final By searchBox = By.xpath("//input[@id=':r1k:']");
    public static final By rowsDropdown = By.xpath("//div[@id=':r1l:']");
    public static final By rowsDropdownOption = By.xpath("//ul[@id=':r1n:']");

// Mandatory fields error messages
    public static final By errorChannelName = By.xpath("//p[@id=':r4a:-helper-text']");
    public static final By errorHost = By.xpath("//p[@id=':r4b:-helper-text']");
    public static final By errorPort = By.xpath("//p[@id=':r4c:-helper-text']");
    public static final By errorSystemID = By.xpath("//p[@id=':r4d:-helper-text']");
    public static final By errorPassword = By.xpath("//p[@id=':r4e:-helper-text']");
    public static final By errorServiceType = By.xpath("//p[@id=':r4f:-helper-text']");
    public static final By errorPriority = By.xpath("//p[@id=':r4g:-helper-text']");
    public static final By errorSourceAddress = By.xpath("//p[@id=':r4h:-helper-text']");
    public static final By errorMultiForBulk = By.xpath("//p[@id=':r4j:-helper-text']");
    public static final By errorFilters = By.xpath("//p[@id=':r4l:-helper-text']");


    public static final By validateChannelCreated = By.xpath("//div[@class='main-content-home']/div/div/following-sibling::div/table/tbody/tr/td/following-sibling::td");
//    public static final By  = By.xpath("");
//    public static final By  = By.xpath("");
//    public static final By  = By.xpath("");
//    public static final By  = By.xpath("");
//    public static final By  = By.xpath("");
//    public static final By  = By.xpath("");
//    public static final By  = By.xpath("");
}