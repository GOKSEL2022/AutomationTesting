package comautomationtesting.tests;

import comautomationtesting.pages.HomePage;
import comautomationtesting.pages.MyAccountPage;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import comautomationtesting.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC30_Registration04_EmptyPassword {
    HomePage homepage=new HomePage();
    MyAccountPage myAccountPage=new MyAccountPage();
    @Test
    public void EmptyPassword() {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        //3) Click on My Account Menu
        ReusableMethods.clickWithJS(homepage.myAccountButtonHome);
        Driver.getDriver().navigate().refresh();
        homepage.myAccountButtonHome.click();
        //4) Enter valid Email Address in Email-Address textbox
        myAccountPage.textBoxEmailRegisterMyAccount.sendKeys(ConfigurationReader.getProperty("email"));
        //5) Enter empty password in password textbox
        myAccountPage.textBoxPasswordRegisterMyAccount.sendKeys(Keys.SPACE,Keys.SPACE,Keys.SPACE);
        //6) Click on Register button
        myAccountPage.registerButtonMyAccount.click();
        //7) Registration must fail with a warning message(ie please enter an account password)
        Assert.assertTrue(myAccountPage.registerButtonMyAccount.isDisplayed());
        Driver.closeDriver();


    }
}
