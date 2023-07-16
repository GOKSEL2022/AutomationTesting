package comautomationtesting.tests.homepage;

import comautomationtesting.pages.*;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import comautomationtesting.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC47_MyAccount04_Orders_3 {
    Homepage homepage=new Homepage();
    MyAccountPage myAccountPage=new MyAccountPage();
    @Test
    public void Orders_3() {
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
        //Assert.assertTrue(myAccountPage.signOutButtonMyAccount.isDisplayed());
        //8) Click on Myaccount link
        homepage.myAccountButtonHome.click();
        //9) Click on Orders link
        ReusableMethods.clickWithJS(myAccountPage.ordersButtonMyAccount);
        //10) Click view button
        ReusableMethods.clickWithJS(myAccountPage.viewButtonMyAccount);
        //11) User must view Order Number Ordered date and Status of the order on clicking view button
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(myAccountPage.orderNumberTextMyAccount.isDisplayed());
        softAssert.assertTrue(myAccountPage.orderDateTextMyAccount.isDisplayed());
        softAssert.assertTrue(myAccountPage.orderStatusTextMyAccount.isDisplayed());
        softAssert.assertAll();
    }
}

