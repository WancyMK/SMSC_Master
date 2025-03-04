package smsc_pageobjects;

import org.openqa.selenium.By;

public class SMSC_TestDispatch_PageObjects {

	public static final By Dispatch = By.xpath("//p[text()='Dispatch']");
	public static final By Dispatch_btn	= By.xpath("//button[text()='Dispatch Message']");
	public static final By PageContainer = By.xpath("//div[@id='simple-tabpanel-0']");
	public static final By Headers = By.xpath("//div[@role='tablist']");
	public static final By Buttons = By.xpath("//button[@id='simple-tab-0']");
	public static final By TextElements = By.xpath("//button[normalize-space()='Send Messages']");
	public static final By RecipientNumberField = By.xpath("//input[@id='recipient']");
	public static final By MessageField = By.xpath("//textarea[@id='message']");
	public static final By SendMessageButton = By.xpath("//button[normalize-space()='Send Messages']");
	public static final By TransactionsTable = By.xpath("//div[@class='MuiTableContainer-root css-1evjoiv']");
	public static final By PeekButton = By.xpath("//button[normalize-space()='Peek']");
	public static final By ClearButton = By.xpath("//button[normalize-space()='Clear']");
	public static final By BulkRecipientsButton = By.xpath("//button[@id='simple-tab-1']");
	public static final By SendBulkMessagesButton = By.xpath("//button[normalize-space()='Send Bulk Messages']");
	public static final By FileUploadInput = By.xpath("//input[@id='bulkRecipientFileUploadControl']");
	public static final By BatchMessagesButton = By.xpath("//button[@id='simple-tab-2']");
	public static final By SecureMessageCheckbox = By.xpath("input[value='secureMessage']");




	

	
	
	
}
