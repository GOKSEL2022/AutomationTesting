package comautomationtesting.tests.homepage;

import comautomationtesting.pages.*;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import comautomationtesting.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC48_MyAccount05_AddressFunctionality {
    Homepage homepage=new Homepage();
    MyAccountPage myAccountPage=new MyAccountPage();
    @Test
    public void AddressFunctionality() {
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
        //8) Click on Myaccount link which leads to Dashboard
        ReusableMethods.clickWithJS(homepage.myAccountButtonHome);
        //9) Click on Address link
        ReusableMethods.clickWithJS(myAccountPage.addressButtonMyAccount);
        //10) User must view billing address and ship address
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(myAccountPage.textBillingAddressMyAccount.isDisplayed());
        softAssert.assertTrue(myAccountPage.textShippingAddressMyAccount.isDisplayed());
        softAssert.assertAll();
    }
}
