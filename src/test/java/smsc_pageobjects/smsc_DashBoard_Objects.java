package smsc_pageobjects;

import org.openqa.selenium.By;

public class smsc_DashBoard_Objects {

    public static final By Dashboard_Bar = By.xpath("//div[@class='bar-charts DashboardCharts']");

    public static final By Select_channel = By.xpath("//select[@id='channels']");
    public static final By channelDropdown = By.xpath("//select=[@id='channels']");
    public static final By newChannel = By.xpath("//option[text()='simulator-mtn']");
    public static final By number_Display = By.xpath("//div[@class='piechart']//div[contains(@class, 'transaction-count')]");
    public static final By TotalMessages_Count = By.xpath("//div[text()='Total Messages:']");
    public static final By DashBoard_Head   = By.xpath("//p[text()='Dashboard']");
}
