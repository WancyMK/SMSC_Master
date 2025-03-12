package smsc_pageobjects;

import org.openqa.selenium.By;

public class SMSC_TestDispatch_PageObjects {

	public static final By dispatch_btn = By.xpath("//p[text()='Dispatch']");
	public static final By bulkRecipients_btn = By.xpath("//button[text()='Bulk Recipients']");
	public static final By batchMessages_btn = By.xpath("//button[text()='Batch Messages']");
	public static final By addRecipient_txtb = By.xpath("//input[@id='recipient']");
	public static final By message_txtb = By.xpath("//textarea[@id='message']");
	public static final By sendMessages_btn = By.xpath("//button[text()='Send Messages']");
	public static final By sendBulkMessages_btn = By.xpath("//button[text()='Send Bulk Messages']");
	public static final By sendBatchMessages_btn = By.xpath("//button[text()='Send Batch Messages']");
	public static final By peek_btn = By.xpath("//button[text()='Peek']");
	public static final By messageClear_btn = By.xpath("//button[text()='Clear']");
	public static final By successMessageClear_btn = By.xpath("//div[contains(@class,'css-1drgbpp')]/div/following-sibling::div");
	public static final By bulkRecipientsAdd_btn = By.xpath("//button[contains(@class, 'MuiFab-sizeSmall')]");
	public static final By bulkRecipientsClearIcon_btn = By.xpath("//*[@data-testid='ClearIcon']");
	public static final By file_txtb = By.xpath("//input[@type='file']");
	public static final By id_txt = By.xpath("//div[contains(@class, 'css-1udr1mz')]");
	public static final By transactions_btn = By.xpath("//p[text()='Transactions']");
	public static final By validateTransactionsText = By.xpath("//div[@class='main-content-home']/div/following-sibling::div/div/table/tbody/tr/td");
//	public static final By
//	public static final By
//	public static final By
//	public static final By
}