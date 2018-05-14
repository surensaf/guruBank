
import helper.BrowserFactory;
import helper.Util;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.PageFactory;
import pages.Login;

import java.io.File;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class LoginTest {
    @Test
    public void verifyValidLogin() throws InterruptedException {


        WebDriver driver = BrowserFactory.
                startBrowser(Util.BROWSER_NAME, Util.BASE_URL+"V4/");
        Login loginPage = PageFactory.initElements(driver, Login.class);

        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage.loginClient(Util.USER_NAME, Util.PASSWD);

        String actualTitle = driver.getTitle();
        if (actualTitle.contains(Util.EXPECT_TITLE)) {
            System.out.println("Test case: Passed");
        }
        else {
            System.out.println("Test case : Failed");
        }

        driver.close();
    }
}