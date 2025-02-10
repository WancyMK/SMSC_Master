package smsc_pageobjects;

import org.openqa.selenium.By;

public class smsc_LoginObjects {

    public static final By Login_heading = By.xpath("//img[@alt='Absa Logo']");
    public static final By Username_txtb = By.xpath("//input[@id=':r0:']");
    public static final By Password_txtb = By.xpath("//input[@id=':r1:']");
    public static final By SubmitLogin_btn = By.xpath("//button[@type='submit']");
    public static final By Loggedin_heading = By.xpath("//img[@alt='logo']");

}
