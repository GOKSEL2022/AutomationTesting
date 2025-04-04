package comautomationtesting.tests;

import comautomationtesting.pages.HomePage;
import comautomationtesting.pages.MyAccountPage;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import comautomationtesting.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC45_MyAccount02_Orders {
    HomePage homepage=new HomePage();
    MyAccountPage myAccountPage=new MyAccountPage();
    @Test
    public void Orders() {
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
        Assert.assertTrue(myAccountPage.signOutButtonMyAccount.isDisplayed());
        //8) Click on Myaccount link
        homepage.myAccountButtonHome.click();
        //9) Click on Orders link
        ReusableMethods.clickWithJS(myAccountPage.ordersButtonMyAccount);
        //10) User must view their orders on clicking orders link
        ReusableMethods.clickWithJS(myAccountPage.viewButtonMyAccount);
        Assert.assertTrue(myAccountPage.textOrderDetailsMyAccount.isDisplayed());
        Driver.closeDriver();

    }
}
