package comautomationtesting.pages;

import comautomationtesting.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    public MyAccountPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[@id='reg_email']")
    public WebElement textBoxEmailRegisterMyAccount;

    @FindBy(xpath = "//*[@id='reg_password']")
    public WebElement textBoxPasswordRegisterMyAccount;

    @FindBy(xpath = "//*[@name='register']")
    public WebElement registerButtonMyAccount;

    @FindBy(xpath = "//*[@id='username']")
    public WebElement textBoxUsernameLoginMyAccount;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement textBoxPasswordLoginMyAccount;

    @FindBy(xpath = "//*[@name='login']")
    public WebElement loginButtonLoginMyAccount;

    @FindBy(xpath = "//*[@id='rememberme']")
    public WebElement rememberMeLoginMyAccount;

    @FindBy(xpath = "(//a[@href='https://practice.automationtesting.in/my-account/customer-logout/'])[2]")
    public WebElement signOutButtonMyAccount;

    @FindBy(xpath = "//*[@class='woocommerce-error']")
    public WebElement textErrorMessageMyAccount;

    @FindBy(xpath = "//*[@class='woocommerce-error']")
    public WebElement textErrorEmptyMessageMyAccount;

    @FindBy(xpath = "//*[.='Dashboard']")
    public WebElement dashboardButtonMyAccount;


}
