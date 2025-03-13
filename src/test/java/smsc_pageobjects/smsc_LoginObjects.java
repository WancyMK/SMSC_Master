package smsc_pageobjects;

import org.openqa.selenium.By;

public class smsc_LoginObjects {
    public static final By Login_heading = By.xpath("//img[@alt='Absa Logo']");
    public static final By Username_txtb = By.xpath("//input[@id=':r0:']");
    public static final By Usernamelbl	= By.xpath("//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 css-qjy5yv'][1]");
    public static final By Passwordlbl = By.xpath("//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 css-qjy5yv'][2]");
    public static final By Password_txtb = By.xpath("//input[@id=':r1:']");
    public static final By SubmitLogin_btn = By.xpath("//button[@type='submit']");
    public static final By Loggedin_heading = By.xpath("//img[@alt='logo']");
    public static final By Error_Message = By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-1ouprxw']");
    public static final By Dashboard_element   = By.xpath("//p[text()='Dashboard']");
    public static final By logoutButton	 = By.xpath("//p[normalize-space()='Logout']");


}
