package comautomationtesting.tests;
import comautomationtesting.pages.*;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import org.testng.annotations.Test;
import static comautomationtesting.utilities.ReusableMethods.clickWithJS;
public class TC46_MyAccount03_Orders_2 {
    AllPages allPages=new AllPages();
    @Test
    public void MyAccount03_Orders_2() throws InterruptedException {
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
        //Assert.assertTrue(myAccountPage.signOutButtonMyAccount.isDisplayed());
        //8) Click on Myaccount link
        allPages.homePage().myAccountButtonHome.click();
        //9) Click on Orders link
        clickWithJS(allPages.myAccountPage().ordersButtonMyAccount);
        //10) Click view button
        clickWithJS(allPages.myAccountPage().viewButtonMyAccount);
        //11) User must view his Order details,customer details and billing details on clicking view button
        assert allPages.myAccountPage().textOrderDetailsMyAccount.isDisplayed();
        assert allPages.myAccountPage().textCustomerDetailsMyAccount.isDisplayed();
        assert allPages.myAccountPage().textBillingAddressDetailsMyAccount.isDisplayed();
        Driver.closeDriver();
    }
}
