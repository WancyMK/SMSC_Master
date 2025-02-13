package smsc_pageobjects;

import org.openqa.selenium.By;

public class SMSC_Messages_PageObjects {
    public static final By messagesSidebar_btn = By.xpath("//p[text()='Messages']");
    public static final By all_txt = By.xpath("//li[text()=' All']");
    public static final By transactionID_txt = By.xpath("//div[@class='main-content-home']/div/div/following-sibling::div/table/tbody/tr/td[count(//th[text()='Transaction ID\t']/preceding-sibling::th) + 1]");
    public static final By recipient_txt = By.xpath("//div[@class='main-content-home']/div/div/following-sibling::div/table/tbody/tr/td[count(//th[text()='Recipient']/preceding-sibling::th) + 1]");
    public static final By channel_txt = By.xpath("//div[@class='main-content-home']/div/div/following-sibling::div/table/tbody/tr/td[count(//th[text()='Channel']/preceding-sibling::th) + 1]");
    public static final By view_btn = By.xpath("//div[@class='main-content-home']/div/div/following-sibling::div/table/tbody/tr/td[count(//th[text()='Actions']/preceding-sibling::th) + 1]");
    public static final By search_dropdown = By.xpath("//div[@role='combobox']");
    public static final By recipientOption_dropdown = By.xpath("//li[text()='Recipient']");
    public static final By transactionOption_dropdown = By.xpath("//li[text()=' Transaction']");
    public static final By channelOption_dropdown = By.xpath("//li[text()=' Channel']");
    public static final By validateMessageDetails_txt = By.xpath("//h2[text()='Message Details']");
    public static final By noMessagesFound_txt = By.xpath("//td[text()='No messages found.']");
    public static final By close_btn = By.xpath("//button[text()='Close']");
//    public static final By  = By.xpath();
}