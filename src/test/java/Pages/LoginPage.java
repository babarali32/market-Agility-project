package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class LoginPage extends CommonMethods {
        @FindBy(xpath ="//input[@id='Username']" )
        public WebElement userNameF;
        @FindBy(xpath ="//input[@id='Password']" )
        public WebElement passwordF;
        @FindBy(xpath ="//button[@id='btnLogin']" )
        public WebElement loginBtn;
        @FindBy(xpath ="//div[@id='swal2-html-container']/div/div" )
        public WebElement errorMessage;


////div[@class='alert alert-danger mt-3']//div[contains(text(),'Username is required')]

        public LoginPage(){
                PageFactory.initElements(driver, this);
        }
}
