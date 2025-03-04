package smsc_pageobjects;

import org.openqa.selenium.By;

public class smsc_DashBoard_Objects {

    public static final By Select_channel = By.xpath("//select[@id='channels']");
    public static final By channelDropdown = By.xpath("//select=[@id='channels']");
    public static final By Axis_Interval = By.xpath("//div[text()= 'Total Messages:']");
    public static final By newChannel = By.xpath("//option[text()='simulator-mtn']");
    public static final By Piechart_errors = By.xpath("//*[name()='path' and contains(@name,'Queued')]");
    public static final By Total_Transactions = By.xpath("//div[@class='bar-charts DashboardCharts']/h4[contains(text(), 'Monitor Transactions for Last 24hr')]");
    public static final By barcart_container = By.xpath("//div[@class='barChart']//div[@class='transaction-container']");
    public static final By Monitor_Message = By.xpath("//h4[normalize-space()='Monitor Messages']");
    public static final By number_Display = By.xpath("//div[@class='piechart']//div[contains(@class, 'transaction-count')]");
    public static final By TotalMessages_Count = By.xpath("//div[normalize-space()='61']");
    public static final By DashBoard_Head   = By.xpath("//p[text()='Dashboard']");
    public static final By Chart_Element = By.xpath("//div[@class='piechart']//div[@class='recharts-wrapper']//*[name()='svg'][1]/*[name()='g'][1]");
}


