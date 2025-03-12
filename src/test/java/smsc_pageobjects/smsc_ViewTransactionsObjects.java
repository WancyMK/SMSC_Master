package smsc_pageobjects;

import org.openqa.selenium.By;

public class smsc_ViewTransactionsObjects {

    public static final By Transactions_heading = By.xpath("//a[@href='#/view-transactions']");
    public static final By TransactionsID_lbl = By.xpath("//th[contains(.,'Transaction ID')]");
    public static final By Timestamp_lbl = By.xpath("//th[contains(.,'Timestamp')]");
    public static final By Reference_lbl = By.xpath("//th[contains(.,'Reference')]");
    public static final By Channel_lbl = By.xpath("//th[contains(.,'Channel')]");
    public static final By Partition_lbl = By.xpath("//th[contains(.,'Partition')]");
    public static final By Priority_lbl = By.xpath("//th[contains(.,'Priority')]");
    public static final By Status_Timestamp_lbl = By.xpath("//th[contains(.,'Status Timestamp')]");
    public static final By Type_lbl = By.xpath("//th[contains(.,'Type')]");
    public static final By Status_lbl = By.xpath("//th[contains(.,'Status')]");
    public static final By DateErrorMessage_txt = By.xpath("//div[@class='MuiSnackbarContent-message css-1w0ym84']");
    public static final By FromDate_tbx = By.xpath("(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-edgeEnd MuiIconButton-sizeMedium css-1psvnyp'])[1]");
    public static final By ToDate_dpd = By.xpath("(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-edgeEnd MuiIconButton-sizeMedium css-1psvnyp'])[2]");
    public static final By ToDate_tbx = By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd css-1uvydh2'])[2]");
    public static final By NextPage_btn = By.xpath("//button[@title='Go to next page']");
    public static final By PreciousPage_btn = By.xpath("//button[@title='Go to previous page']");
    public static final By ErrorMessage_txt = By.xpath("//td[contains(.,'No results found')]");
    public static final By Search_txb = By.xpath("//div[@class='MuiFormControl-root MuiTextField-root css-i44wyl']");
    public static final By Search2_txb = By.xpath("(//input[@type='text'])[1]");
    public static final By FirstTransaction_txt = By.xpath("(//td[contains(.,'GVHNKK-7450557016')])[1]");
    public static final By MonthDropdownArrow_dpd = By.xpath("//button[@aria-label='calendar view is open, switch to year view']");
    public static final By Year2017_txt = By.xpath("//button[contains(.,'2017')]");
    public static final By Year2016_txt = By.xpath("//button[contains(.,'2016')]");
    public static final By Year2025_txt = By.xpath("//button[contains(.,'2025')]");
    public static final By MonthDate12_txt = By.xpath("//button[contains(.,'12')]");
    public static final By ClearFilter_btn = By.xpath("//button[contains(.,'Clear Filter')]");
    public static final By RowPageDropDown_dpd = By.xpath("//div[text()='5']");
    public static final By RowPageDropDown10_dpd = By.xpath("//li[contains(.,'10')]");

}
