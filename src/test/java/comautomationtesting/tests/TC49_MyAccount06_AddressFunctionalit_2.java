package comautomationtesting.tests;
import comautomationtesting.pages.AllPages;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import org.testng.annotations.Test;
import static comautomationtesting.utilities.ReusableMethods.clickWithJS;
import static comautomationtesting.utilities.ReusableMethods.scrollIntoViewJS;
public class TC49_MyAccount06_AddressFunctionalit_2 {
    AllPages allPages=new AllPages();
    @Test
    public void AddressFunctionalit_2() {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        //3) Click on My Account Menu
        clickWithJS(allPages.homePage().myAccountButtonHome);
        Driver.getDriver().navigate().refresh();
        allPages.homePage().myAccountButtonHome.click();
        //4) Enter registered username in username textbox
        allPages.myAccountPage().textBoxUsernameLoginMyAccount.sendKeys(ConfigurationReader.getProperty("email"));
        //5) Enter password in password textbox
        allPages.myAccountPage().textBoxPasswordLoginMyAccount.sendKeys(ConfigurationReader.getProperty("password"));
        //6) Click on login button
        allPages.myAccountPage().loginButtonLoginMyAccount.click();
        //7) User must successfully login to the web page
        assert Driver.getDriver().getCurrentUrl().contains("my-account");
        //8) Click on Myaccount link
        clickWithJS(allPages.homePage().myAccountButtonHome);
        //9) Click on Address link
        clickWithJS(allPages.myAccountPage().addressButtonMyAccount);
        //10) Click Edit on Shipping Address
        clickWithJS(allPages.myAccountPage().editButtonShippingMyAccount);
        //11) User can Edit Shipping address
        scrollIntoViewJS(allPages.myAccountPage().saveAddressButtonMyAccount);
        assert allPages.myAccountPage().saveAddressButtonMyAccount.isDisplayed();
    }
}
