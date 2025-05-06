package comautomationtesting.tests;
import comautomationtesting.pages.AllPages;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import org.testng.annotations.Test;
import static comautomationtesting.utilities.ReusableMethods.clickWithJS;
public class TC45_MyAccount02_Orders {
    AllPages allPages=new AllPages();
    @Test
    public void Orders() {
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
        assert allPages.myAccountPage().signOutButtonMyAccount.isDisplayed();
        //8) Click on Myaccount link
        allPages.homePage().myAccountButtonHome.click();
        //9) Click on Orders link
        clickWithJS(allPages.myAccountPage().ordersButtonMyAccount);
        //10) User must view their orders on clicking orders link
        clickWithJS(allPages.myAccountPage().viewButtonMyAccount);
        assert allPages.myAccountPage().textOrderDetailsMyAccount.isDisplayed();
        Driver.closeDriver();
    }
}
