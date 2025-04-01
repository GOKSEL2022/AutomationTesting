package comautomationtesting.tests.homepage;

import comautomationtesting.pages.HomePage;
import comautomationtesting.pages.MyAccountPage;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import comautomationtesting.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC21_Login03_CorretUsernameAndEmptyPassword {
    HomePage homepage = new HomePage();
    MyAccountPage myAccountPage = new MyAccountPage();
    @Test
    public void CorretUsernameAndEmptyPassword() {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        //3) Click on My Account Menu
        ReusableMethods.clickWithJS(homepage.myAccountButtonHome);
        Driver.getDriver().navigate().refresh();
        homepage.myAccountButtonHome.click();
        //4) Enter valid username in username textbox
        myAccountPage.textBoxUsernameLoginMyAccount.sendKeys("goksel5255@gmail.com");
        //5) Now enter empty password in the password textbox
        myAccountPage.textBoxPasswordLoginMyAccount.sendKeys(Keys.SPACE,Keys.SPACE,Keys.SPACE);
        //6) Click on login button.
        myAccountPage.loginButtonLoginMyAccount.click();
        //7) Proper error must be displayed(ie Invalid password) and prompt to enter login again
        Assert.assertTrue(myAccountPage.textErrorEmptyMessageMyAccount.getText().contains("empty"));
        Driver.closeDriver();

    }
}
