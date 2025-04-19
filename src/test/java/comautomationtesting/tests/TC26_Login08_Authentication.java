package comautomationtesting.tests;
import comautomationtesting.pages.AllPages;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import org.testng.annotations.Test;
import static comautomationtesting.utilities.ReusableMethods.clickWithJS;
public class TC26_Login08_Authentication {
    AllPages allPages=new AllPages();
    @Test
    public void Authentication() {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        //3) Click on My Account Menu
        clickWithJS(allPages.homePage().myAccountButtonHome);
        Driver.getDriver().navigate().refresh();
        allPages.homePage().myAccountButtonHome.click();
        //4) Enter the case changed username in username textbox
        allPages.myAccountPage().textBoxUsernameLoginMyAccount.sendKeys(ConfigurationReader.getProperty("email"));
        //5) Enter the case chenged password in the password tetxbox
        allPages.myAccountPage().textBoxPasswordLoginMyAccount.sendKeys(ConfigurationReader.getProperty("password"));
        //6) Now click on login button
        allPages.myAccountPage().loginButtonLoginMyAccount.click();
        //7) Once your are logged in, sign out of the site
        allPages.myAccountPage().signOutButtonMyAccount.click();
        //8) Now press back button
        Driver.getDriver().navigate().back();
        //9) User shouldn’t be signed in to his account rather a general webpage must be visible
        assert allPages.myAccountPage().textBoxUsernameLoginMyAccount.isDisplayed();
        Driver.closeDriver();
    }
}
