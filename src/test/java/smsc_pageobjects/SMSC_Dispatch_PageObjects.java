package smsc_pageobjects;

import org.openqa.selenium.By;

public class SMSC_Dispatch_PageObjects {
	public static final By dispatch_btn = By.xpath("//p[text()='Dispatch']");
	public static final By bulkRecipients_btn = By.xpath("//button[text()='Bulk Recipients']");
	public static final By batchMessages_btn = By.xpath("//button[text()='Batch Messages']");
	public static final By addRecipient_txtb = By.xpath("//input[@id='recipient']");
	public static final By message_txtb = By.xpath("//textarea[@id='message']");
	public static final By sendMessages_btn = By.xpath("//button[text()='Send Messages']");
	public static final By sendBulkMessages_btn = By.xpath("//button[text()='Send Bulk Messages']");
	public static final By sendBatchMessages_btn = By.xpath("//button[text()='Send Batch Messages']");
	public static final By peek_btn = By.xpath("//button[text()='Peek']");
	public static final By sentMessageClear_btn = By.xpath("//div[contains(@class, 'css-1drgbpp')]/div/following-sibling::div");
	public static final By bulkRecipientsClearIcon_btn = By.xpath("//*[@data-testid='ClearIcon']");
	public static final By file_txtb = By.xpath("//input[@type='file']");
	public static final By sentTrue_txt = By.xpath("//div[contains(@class,'css-9ppe9d')]");
	public static final By id_txt = By.xpath("//div[contains(@class,'css-1udr1mz')]");
	public static final By completedMessageStatus_txt = By.xpath("//td[text()='Completed']");
	public static final By errorMessageStatus_txt = By.xpath("//td[text()='Error']");
	public static final By noActionMessageStatus_txt = By.xpath("//td[text()='NoAction']");
	public static final By messagesSidebar_btn = By.xpath("//p[text()='Messages']");
	public static final By validateTransactionsText = By.xpath("//div[@class='main-content-home']/div/div/following-sibling::div/table/tbody/tr/td");
	public static final By characterCount_txt = By.xpath("//p[contains(@class, 'css-11cyslt')]");
	public static final By sentMessageTime = By.xpath("//td[contains(@class, 'css-9tf1gv')]");
	public static final By bulkCharacterCount = By.xpath("//p[contains(@class, 'css-1dii8n')]");
	public static final By batchCharacterCount = By.xpath("//p[contains(@class, 'css-11cyslt')]");
	public static final By clear_btn = By.xpath("//button[text()='Clear']");
	public static final By fileUploadText = By.xpath("//input[@id='bulkRecipientFileUploadControl']");

}