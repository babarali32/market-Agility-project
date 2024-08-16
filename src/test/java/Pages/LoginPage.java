package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class LoginPage extends CommonMethods {
        @FindBy(id="Username" )
        public WebElement userNameF;
        @FindBy(xpath ="//input[@id='Password']" )
        public WebElement passwordF;
        @FindBy(xpath ="//button[@id='btnLogin']" )
        public WebElement loginBtn;
        @FindBy(xpath ="//div[contains(@class, 'alert alert-danger')]//div" )
        public WebElement actualErrorMessage;
        @FindBy(xpath ="(//div[text()='Username is required'])[2]" )
        public WebElement actualErrorMessage2;
        @FindBy(xpath ="//select[@id='SiteId']/option" )
        public List<WebElement> dropDown;
        @FindBy(xpath ="//img[@src='/assets/media/logos/default-dark.svg']" )
        public WebElement logo;

        //



        public LoginPage(){
                PageFactory.initElements(driver, this);
        }
}
