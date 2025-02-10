package smsc_pageobjects;

import org.openqa.selenium.By;

public class SMSC_Channels_PageObjects {
    public static final By channelSideBar_btn = By.xpath("//p[text()='Channels']");
    public static final By createNewChannel_btn = By.xpath("//button[text()='Create New Channel']");
    public static final By channelName_txtb = By.xpath("//input[@name='name']");
    public static final By host_txtb = By.xpath("//input[@name='host']");
    public static final By port_txtb = By.xpath("//input[@name='port']");
    public static final By systemID_txtb = By.xpath("//input[@name='systemId']");
    public static final By password_txtb = By.xpath("//input[@name='password']");
    public static final By serviceType_txtb = By.xpath("//input[@name='serviceType']");
    public static final By priority_txtb = By.xpath("//input[@name='priority']");
    public static final By sourceAddress_txtb = By.xpath("//input[@name='sourceAddress']");
    public static final By status_dropdown = By.xpath("//div[@role='combobox']");
    public static final By statusActiveOption_dropdown = By.xpath("//li[text()='Active']");
    public static final By statusInactiveOption_dropdown = By.xpath("//li[text()='Inactive']");
    public static final By provider_txtb = By.xpath("//input[@name='provider']");
    public static final By multiForBulk_dropdown = By.xpath("(//div[@role='combobox'])[2]");
    public static final By multiForBulkOption_dropdown = By.xpath("//li[text()='no']");
    public static final By filters_txtb = By.xpath("//input[@name='filters']");
    public static final By create_btn = By.xpath("//button[text()='Create']");
    public static final By cancel_btn = By.xpath("//button[text()='Cancel']");
    public static final By update_btn = By.xpath("//button[text()='Update']");
    public static final By search_txtb = By.xpath("//input[@type='text']");
    public static final By rows_dropdown = By.xpath("//div[text()='5']");
    public static final By rowsOption_dropdown = By.xpath("//li[text()='10']");

// Mandatory fields error messages
    public static final By errorChannelName_txt = By.xpath("//p[text()='Name is required']");
    public static final By errorHost_txt = By.xpath("//p[text()='Host is required']");
    public static final By errorPort_txt = By.xpath("//p[text()='Port is required']");
    public static final By errorSystemID_txt = By.xpath("//p[text()='System ID is required']");
    public static final By errorPassword_txt = By.xpath("//p[text()='Password is required']");
    public static final By errorServiceType_txt = By.xpath("//p[text()='Service Type is required']");
    public static final By errorPriority_txt = By.xpath("//p[text()='Priority is required']");
    public static final By errorSourceAddress_txt = By.xpath("//p[text()='Source Address is required']");
    public static final By errorProvider_txt = By.xpath("//p[text()=' Provider is  required']");
    public static final By errorFilters_txt = By.xpath("//p[text()='Filters is required']");


    public static final By validateChannelCreated_txt = By.xpath("//div[@class='main-content-home']/div/div/following-sibling::div/table/tbody/tr/td/following-sibling::td");
    public static final By edit_btn = By.xpath("//div[@class='search-container']//following-sibling::div//table//tbody//tr//td//button[contains(@class, 'MuiButtonBase-root')]");
    public static final By status_txt = By.xpath("//div[@class='search-container']/following-sibling::div//table//tbody//tr/td[count(//th[text()='Status']/preceding-sibling::th) + 1]");
    public static final By searchErrorMessage = By.xpath("//td[text()='No channels found.']");
//    public static final By  = By.xpath("");
//    public static final By  = By.xpath("");
//    public static final By  = By.xpath("");
//    public static final By  = By.xpath("");
}