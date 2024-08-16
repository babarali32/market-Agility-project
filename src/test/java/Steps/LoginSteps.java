package Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import utils.ConfigReader;

import java.util.List;

public class LoginSteps extends CommonMethods {
    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        driver.get(ConfigReader.getProperty("URL"));
    }

    @When("the user enters {string} and {string}")
    public void theUserEntersAnd(String username, String password) {
        sendText(loginPage.userNameF, username);
        sendText(loginPage.passwordF, password);
    }

    @And("the user clicks the login button")
    public void userClicksLoginButton() {
        List<WebElement> dropdownOptions = loginPage.dropDown;
        for (WebElement option : dropdownOptions) {
            if (option.getText().contains("Demo")) {
                option.click();
                break;
            }
        }

        loginPage.loginBtn.click();
    }


    @Then("the user should be redirected to the dashboard")
    public void theUserShouldBeRedirectedToTheDashboard() {

        Assert.assertTrue(loginPage.logo.isDisplayed());
    }

    @Then("the user should see an error message \"\"User not found.{string}")
    public void the_user_should_see_an_error_message_user_not_found(String expectedErrorMessage) {

        Assert.assertEquals(loginPage.actualErrorMessage, expectedErrorMessage);
    }


    @Then("the user should see an error message {string}")
    public void theUserShouldSeeAnErrorMessage(String expectedErrorMessage) {
        Assert.assertEquals(loginPage.actualErrorMessage.getText(), expectedErrorMessage);

    }

    @Then("the user should see an error message {string} and {string}")
    public void theUserShouldSeeAnErrorMessageAnd(String expectedPasswordErorMessage, String expectedUserNameErorMessage) {
        System.out.println(loginPage.actualErrorMessage.getText());
        Assert.assertEquals(loginPage.actualErrorMessage.getText(), expectedPasswordErorMessage);
        Assert.assertEquals(loginPage.actualErrorMessage2.getText(), expectedUserNameErorMessage);

    }


}
