import helper.BrowserFactory;
import helper.Util;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NewCustomerTest {
    static WebDriver driver; // Selenium control driver

    @Test
    public void NewCustomer() {

    }
    @BeforeMethod
    public static void setUp() {
        driver = BrowserFactory.
                startBrowser(Util.BROWSER_NAME);
        driver.manage().timeouts()
                .implicitlyWait(Util.WAIT_TIME, TimeUnit.SECONDS);
        driver.get(Util.BASE_URL + "V4/");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
}
