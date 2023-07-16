package comautomationtesting.tests.homepage;

import com.github.javafaker.Faker;
import comautomationtesting.pages.Homepage;
import comautomationtesting.pages.MyAccountPage;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import comautomationtesting.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC26_Login08_Authentication {
    Homepage homepage=new Homepage();
    MyAccountPage myAccountPage=new MyAccountPage();
    @Test
    public void Authentication() {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        //3) Click on My Account Menu
        ReusableMethods.clickWithJS(homepage.myAccountButtonHome);
        Driver.getDriver().navigate().refresh();
        homepage.myAccountButtonHome.click();
        //4) Enter the case changed username in username textbox
        myAccountPage.textBoxUsernameLoginMyAccount.sendKeys(ConfigurationReader.getProperty("email"));
        //5) Enter the case chenged password in the password tetxbox
        myAccountPage.textBoxPasswordLoginMyAccount.sendKeys(ConfigurationReader.getProperty("password"));
        //6) Now click on login button
        myAccountPage.loginButtonLoginMyAccount.click();
        //7) Once your are logged in, sign out of the site
        myAccountPage.signOutButtonMyAccount.click();
        //8) Now press back button
        Driver.getDriver().navigate().back();
        //9) User shouldn’t be signed in to his account rather a general webpage must be visible
        Assert.assertTrue(myAccountPage.textBoxUsernameLoginMyAccount.isDisplayed());
        Driver.closeDriver();
    }
}
