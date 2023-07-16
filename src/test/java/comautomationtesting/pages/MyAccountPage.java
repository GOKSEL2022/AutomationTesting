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

    @FindBy(xpath = "(//a[@href='https://practice.automationtesting.in/my-account/orders/'])[1]")
    public WebElement ordersButtonMyAccount;

    @FindBy(xpath = "//div[@class='woocommerce-Message woocommerce-Message--info woocommerce-info']")
    public WebElement textNoOrderMyAccount;

    @FindBy(xpath = "//*[@class='woocommerce-Button button']")
    public WebElement goShopButtonMyAccount;

    @FindBy(xpath = "//*[@class='button view']")
    public WebElement viewButtonMyAccount;

    @FindBy(xpath = "//*[.='Order Details']")
    public WebElement textOrderDetailsMyAccount;

    @FindBy(xpath = "//*[.='Customer Details']")
    public WebElement textCustomerDetailsMyAccount;

    @FindBy(xpath = "//*[.='Billing Address']")
    public WebElement textBillingAddressDetailsMyAccount;

    @FindBy(xpath = "//*[@class='order-number']")
    public WebElement orderNumberTextMyAccount;

    @FindBy(xpath = "//*[@class='order-date']")
    public WebElement orderDateTextMyAccount;

    @FindBy(xpath = "//*[@class='order-status']")
    public WebElement orderStatusTextMyAccount;

    @FindBy(xpath = "//*[.='Addresses']")
    public WebElement addressButtonMyAccount;

    @FindBy(xpath = "//*[.='Billing Address']")
    public WebElement textBillingAddressMyAccount;

    @FindBy(xpath = "//*[.='Shipping Address']")
    public WebElement textShippingAddressMyAccount;

    @FindBy(xpath = "(//*[@class='edit'])[2]")
    public WebElement editButtonShippingMyAccount;

    @FindBy(xpath = "//*[@name='save_address']")
    public WebElement saveAddressButtonMyAccount;

    @FindBy(xpath = "//*[.='Account Details']")
    public WebElement accountDetailsButtonMyAccount;

    @FindBy(xpath = "//*[.='Password Change']")
    public WebElement textPasswordChangeMyAccount;

    @FindBy(xpath = "//*[.='Logout']")
    public WebElement logOutButtonMyAccount;




}
