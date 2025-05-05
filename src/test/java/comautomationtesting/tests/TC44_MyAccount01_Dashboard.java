package comautomationtesting.tests;
import comautomationtesting.pages.AllPages;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import org.testng.annotations.Test;
import static comautomationtesting.utilities.ReusableMethods.clickWithJS;
public class TC44_MyAccount01_Dashboard {
    AllPages allPages=new AllPages();
    @Test
    public void Dashboard() {
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
        //8) Click on Myaccount link which leads to Dashboard
        clickWithJS(allPages.homePage().myAccountButtonHome);
        clickWithJS(allPages.myAccountPage().dashboardButtonMyAccount);
        //9) User must view Dashboard of the site
        assert allPages.myAccountPage().dashboardButtonMyAccount.isDisplayed();
        Driver.closeDriver();
    }
}
