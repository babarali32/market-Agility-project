package Steps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.CommonMethods;
import utils.ConfigReader;
public class LoginSteps extends CommonMethods {
    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        driver.get(ConfigReader.getProperty("URL"));
    }
    @When("the user enters {string} and {string}")
    public void theUserEntersAnd(String userName, String password) {
        loginPage.userNameF.sendKeys(userName);
        loginPage.passwordF.sendKeys(password);
    }

    @And("the user clicks the login button")
    public void theUserClicksTheLoginButton() {
        loginPage.loginBtn.click();
    }

    @Then("the user should be redirected to the dashboard")
    public void theUserShouldBeRedirectedToTheDashboard() {
        System.out.println("logo is diplayed write assertion, logo.isDisplayed");
    }

//    @Then("the user should see an error message \"\"User not found.{string}")
//    public void the_user_should_see_an_error_message_user_not_found(String string) {
//       String loginErrorMessag=loginPage.errorMessage.getText();
//        System.out.println(loginErrorMessag);
//    }


    @Then("the user should see an error message {string}")
    public void theUserShouldSeeAnErrorMessage(String errorMessage) {
        String loginErrorMessag=loginPage.errorMessage.getText();
        System.out.println(loginErrorMessag);
       //Assert.assertEquals(loginErrorMessag,errorMessage);
    }

    @Then("the user should see an error message {string} and {string}")
    public void theUserShouldSeeAnErrorMessageAnd(String arg0, String arg1) {

    }


}
