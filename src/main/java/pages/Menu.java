package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Menu {
    WebDriver driver;

    @FindBy(how = How.XPATH, using = "//a[@href='addcustomerpage.php']")
    @CacheLookup
    WebElement newCustomer;

    @FindBy(how = How.XPATH, using = "//a[@href='EditCustomer.php']")
    @CacheLookup
    WebElement editCustomer;

    @FindBy(how = How.XPATH, using = "//a[@href='DeleteCustomerInput.php']")
    @CacheLookup
    WebElement deleteCustomer;

    public Menu(WebDriver driver){

        this.driver = driver;
    }

    public void goToNewCustomer(){
        newCustomer.click();
    }
    public void goToEditCustomer(){
        editCustomer.click();
    }
    public void goToDeleteCustomer() {
        deleteCustomer.click();
    }
}
