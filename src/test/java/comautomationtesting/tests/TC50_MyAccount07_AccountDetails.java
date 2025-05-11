package comautomationtesting.tests;
import comautomationtesting.pages.AllPages;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import org.testng.annotations.Test;
import static comautomationtesting.utilities.ReusableMethods.clickWithJS;
public class TC50_MyAccount07_AccountDetails {
    AllPages allPages=new AllPages();
    @Test
    public void AccountDetails() {
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
        Driver.getDriver().navigate().refresh();
        clickWithJS(allPages.homePage().myAccountButtonHome);
        //9) Click on Account details
        clickWithJS(allPages.myAccountPage().accountDetailsButtonMyAccount);
        //10) User can view account details where he can change his pasword also.
        assert allPages.myAccountPage().textPasswordChangeMyAccount.isDisplayed();
    }
}
