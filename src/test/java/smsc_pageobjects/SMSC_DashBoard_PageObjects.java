package smsc_pageobjects;

import org.openqa.selenium.By;

public class SMSC_DashBoard_PageObjects {
	
	public static final By Select_channel = By.xpath("//select[@id='channels']");
    public static final By dashBoardSideBar_btn = By.xpath("//p[text()='Dashboard']");
    public static final By yAxis_Interval = By.xpath("//*[@class='recharts-layer recharts-cartesian-axis recharts-yAxis yAxis']");
    public static final By grindGraph = By.xpath("//option[text()='simulator-mtn']");
    public static final By Piechart_errors = By.xpath("//*[name()='path' and contains(@name,'Queued')]");
    public static final By monitorTransactions_lbl = By.xpath("//h4[contains(text(), 'Monitor Transactions for Last 24hr')]");
    public static final By totalTransactions_lbl = By.xpath("//div[contains(text(), 'Total Transactions:')]");
    public static final By barcartcontainer_chart = By.xpath("//div[@class='barChart']//div[@class='transaction-container']");
    public static final By monitorMessage_lbl = By.xpath("//h4[normalize-space()='Monitor Messages']");
    public static final By errorPieCount_Display = By.xpath("//*[@name='Error']");
    public static final By TotalMessages_Count = By.xpath("//div[@class='transaction-title' and text()='Total Messages:']/following-sibling::div[@class='transaction-count']");
    public static final By TotalMessages_lbl = By.xpath("//div[@class='transaction-title' and text()='Total Messages:']/following-sibling::div[@class='transaction-count']");
    public static final By DashBoard_Head   = By.xpath("//p[text()='Dashboard']");
    public static final By queuedMessageCount_lbl = By.xpath("//span[contains(@class, 'recharts-tooltip-item-value')]");

    public static final By grindGraphStatus_queued = By.xpath("(//span[contains(@class, 'recharts-legend-item-text') and text()='Queued'])[1]");
    public static final By grindGraphStatus_failed= By.xpath("//span[contains(@class, 'recharts-legend-item-text') and text()='Failed']");
    public static final By grindGraphStatus_errors = By.xpath("//span[contains(@class, 'recharts-legend-item-text') and text()='Errors']");
    public static final By grindGraphStatus_completed = By.xpath("(//span[contains(@class, 'recharts-legend-item-text') and text()='Completed'])[1]");
    public static final By grindGraphStatus_sent= By.xpath("(//span[contains(@class, 'recharts-legend-item-text') and text()='Completed'])[1]");
}
	


