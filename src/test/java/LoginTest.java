
import helper.BrowserFactory;
import helper.ReadExcel;
import helper.Util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Login;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static test.methods.SampleMethod1.verify;

public class LoginTest {
    static WebDriver driver; // Selenium control driver

    @DataProvider(name = "GuruTest")
    public Object[][] testData() throws Exception {
        return ReadExcel.getDataFromExcel(Util.DATA_FILE_PATH, Util.SHEET_NAME,
                Util.TABLE_NAME);
    }
    @Test(dataProvider = "GuruTest")
    public void TestLogin(String username, String password) throws Exception {

        String actualTitle;
        String actualBoxMsg;
        Login loginPage = PageFactory.initElements(driver, Login.class);
        loginPage.loginClient(username, password);
        try{

            Alert alt = driver.switchTo().alert();
            actualBoxMsg = alt.getText(); // get content of the Alter Message
            alt.accept();
            // Compare Error Text with Expected Error Value
            assertEquals(actualBoxMsg,Util.EXPECT_ERROR);
        }
        catch (NoAlertPresentException Ex){
            actualTitle = driver.getTitle();
            // On Successful login compare Actual Page Title with Expected Title
            assertEquals(actualTitle,Util.EXPECT_TITLE);
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            // Code to save screenshot at desired location
            FileUtils.copyFile(scrFile, new File(Util.SCREENSHOT_PATH +"screenshot.png"));
        }
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