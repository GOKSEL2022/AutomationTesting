package comautomationtesting.tests.homepage;

import com.github.javafaker.Faker;
import comautomationtesting.pages.HomePage;
import comautomationtesting.pages.MyAccountPage;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import comautomationtesting.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC28_Registration02_invalidEmailId {
    HomePage homepage=new HomePage();
    MyAccountPage myAccountPage=new MyAccountPage();
    Faker faker=new Faker();
    @Test
    public void Registration02_invalidEmailId () {
        String email=Faker.instance().name().firstName();
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        //3) Click on My Account Menu
        ReusableMethods.clickWithJS(homepage.myAccountButtonHome);
        Driver.getDriver().navigate().refresh();
        homepage.myAccountButtonHome.click();
        //4) Enter invalid Email Address in Email-Address textbox
        myAccountPage.textBoxEmailRegisterMyAccount.sendKeys(email);
        //5) Enter your own password in password textbox
        myAccountPage.textBoxPasswordRegisterMyAccount.sendKeys(ConfigurationReader.getProperty("password"));
        //6) Click on Register button
        myAccountPage.registerButtonMyAccount.click();
        //7) Registration must fail with a warning message(ie You must enter a valid email address)
        Assert.assertTrue(myAccountPage.registerButtonMyAccount.isDisplayed());
        Driver.closeDriver();

    }
}
