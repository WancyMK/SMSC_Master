package smsc_accelerators;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class SMSC_Base {
    public static WebDriver driver;

    public static void setUp() throws InterruptedException {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            Map<String, Object> prefs = new HashMap<String, Object>();
            options.setExperimentalOption("prefs", prefs);
            prefs.put("profile.default_content_settings.popups", 0);
            prefs.put("profile.default_content_setting_values.automatic_downloads", 1);
//            options.addArguments("--incognito");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();

  ;      }
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
