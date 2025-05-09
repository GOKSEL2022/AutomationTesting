package comautomationtesting.tests;
import comautomationtesting.pages.*;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static comautomationtesting.utilities.ReusableMethods.clickWithJS;
public class TC48_MyAccount05_AddressFunctionality {
    AllPages allPages=new AllPages();
    SoftAssert softAssert=new SoftAssert();
    @Test
    public void AddressFunctionality() {
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
        //8) Click on Myaccount link which leads to Dashboard
        clickWithJS(allPages.homePage().myAccountButtonHome);
        //9) Click on Address link
        clickWithJS(allPages.myAccountPage().addressButtonMyAccount);
        //10) User must view billing address and ship address
        softAssert.assertTrue(allPages.myAccountPage().textBillingAddressMyAccount.isDisplayed());
        softAssert.assertTrue(allPages.myAccountPage().textShippingAddressMyAccount.isDisplayed());
        softAssert.assertAll();
    }
}
