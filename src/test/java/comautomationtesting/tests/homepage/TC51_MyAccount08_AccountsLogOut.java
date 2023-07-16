package comautomationtesting.tests.homepage;

import comautomationtesting.pages.Homepage;
import comautomationtesting.pages.MyAccountPage;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import comautomationtesting.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC51_MyAccount08_AccountsLogOut {
    Homepage homepage=new Homepage();
    MyAccountPage myAccountPage=new MyAccountPage();
    @Test
    public void AccountsLogOut() {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        //3) Click on My Account Menu
        ReusableMethods.clickWithJS(homepage.myAccountButtonHome);
        Driver.getDriver().navigate().refresh();
        homepage.myAccountButtonHome.click();
        //4) Enter registered username in username textbox
        myAccountPage.textBoxUsernameLoginMyAccount.sendKeys(ConfigurationReader.getProperty("email"));
        //5) Enter password in password textbox
        myAccountPage.textBoxPasswordLoginMyAccount.sendKeys(ConfigurationReader.getProperty("password"));
        //6) Click on login button
        myAccountPage.loginButtonLoginMyAccount.click();
        //7) User must successfully login to the web page
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("my-account"));
        //8) Click on Myaccount link
        ReusableMethods.clickWithJS(homepage.myAccountButtonHome);
        Driver.getDriver().navigate().refresh();
        ReusableMethods.clickWithJS(homepage.myAccountButtonHome);
        //9) Click on Logout button
        ReusableMethods.clickWithJS(myAccountPage.logOutButtonMyAccount);
        //10) On clicking logout,User successfully comes out from the site
        Assert.assertTrue(myAccountPage.textBoxEmailRegisterMyAccount.isDisplayed());
    }
}
