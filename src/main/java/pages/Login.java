package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Login {

    WebDriver driver;

    @FindBy(how = How.XPATH, using = "//input[@onkeyup='validateuserid();']")
    @CacheLookup
    WebElement username;

    @FindBy(how = How.XPATH, using = "//input[@onkeyup='validatepassword();']")
    @CacheLookup
    WebElement password;

    @FindBy(how = How.XPATH, using = "//input[@name='btnLogin']")
    @CacheLookup
    WebElement loginButton;

    public Login(WebDriver driver){
        this.driver = driver;
    }

    public void loginClient(String userId, String pass){
        username.sendKeys(userId);
        password.sendKeys(pass);
        loginButton.click();
    }
}
