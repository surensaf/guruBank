import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import pages.Login;

public class MyStepdefs {
    @Given("^User is on Home Page$")
    public void userIsOnHomePage() throws Throwable {
        LoginTest.setUp();// Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^User enters UserName and Password$")
    public void userEntersUserNameAndPassword() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
       new LoginTest();
        throw new PendingException();
    }
}
