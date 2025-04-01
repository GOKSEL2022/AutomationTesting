package comautomationtesting.tests.homepage;

import comautomationtesting.pages.HomePage;
import comautomationtesting.pages.MyAccountPage;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import comautomationtesting.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC23_Login05_EmptyUsernameAndEmptyPassword {
    HomePage homepage = new HomePage();
    MyAccountPage myAccountPage = new MyAccountPage();
    @Test
    public void EmptyUsernameAndEmptyPassword() {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        //3) Click on My Account Menu
        ReusableMethods.clickWithJS(homepage.myAccountButtonHome);
        Driver.getDriver().navigate().refresh();
        homepage.myAccountButtonHome.click();
        //4) Enter empty username in username textbox
        myAccountPage.textBoxUsernameLoginMyAccount.sendKeys(Keys.SPACE,Keys.SPACE,Keys.SPACE);
        //5) Now enter valid password in the password textbox
        myAccountPage.textBoxPasswordLoginMyAccount.sendKeys(Keys.SPACE,Keys.SPACE,Keys.SPACE);
        //6) Click on login button.
        myAccountPage.loginButtonLoginMyAccount.click();
        //7) Proper error must be displayed(ie required username) and prompt to enter login agai
        Assert.assertTrue(myAccountPage.textErrorMessageMyAccount.getText().contains(" Username is required."));
        Driver.closeDriver();

    }
}
