package comautomationtesting.tests.homepage;

import comautomationtesting.pages.HomePage;
import comautomationtesting.pages.MyAccountPage;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import comautomationtesting.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC29_Registration03_EmptyEmailId {
    HomePage homepage=new HomePage();
    MyAccountPage myAccountPage=new MyAccountPage();
    @Test
    public void EmptyEmailId() {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        //3) Click on My Account Menu
        ReusableMethods.clickWithJS(homepage.myAccountButtonHome);
        Driver.getDriver().navigate().refresh();
        homepage.myAccountButtonHome.click();
        //4) Enter empty Email Address in Email-Address textbox
        myAccountPage.textBoxEmailRegisterMyAccount.sendKeys(Keys.SPACE,Keys.SPACE,Keys.SPACE);
        //5) Enter your own password in password textbox
        myAccountPage.textBoxPasswordRegisterMyAccount.sendKeys(ConfigurationReader.getProperty("password"));
        //6) Click on Register button
        myAccountPage.registerButtonMyAccount.click();
        //7) Registration must fail with a warning message(ie please provide valid email address)
        Assert.assertTrue(myAccountPage.textErrorMessageMyAccount.getText().contains(" Please provide a valid email address."));
        Driver.closeDriver();
    }
}
