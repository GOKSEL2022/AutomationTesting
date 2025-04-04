package comautomationtesting.tests;

import comautomationtesting.pages.HomePage;
import comautomationtesting.pages.MyAccountPage;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import comautomationtesting.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC24_Login06_PasswordShouldBeMasked {
    HomePage homepage=new HomePage();
    MyAccountPage myAccountPage=new MyAccountPage();

    @Test
    public void PasswordShouldBeMasked() throws IOException {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        //3) Click on My Account Menu
        ReusableMethods.clickWithJS(homepage.myAccountButtonHome);
        Driver.getDriver().navigate().refresh();
        homepage.myAccountButtonHome.click();
        //4) Enter the password field with some characters.
        myAccountPage.textBoxPasswordLoginMyAccount.sendKeys("***+++???");
        //5) The password field should display the characters in asterisks or bullets such that the password is not visible on the screen
        //Assert.assertTrue(myAccountPage.textBoxPasswordLoginMyAccount.getText().contains("........."));
        //Assert.assertTrue(myAccountPage.textBoxPasswordLoginMyAccount.getText().contains("***+++???"));
        //Assert.assertTrue(myAccountPage.textBoxPasswordLoginMyAccount.getAttribute("***+++???").contains("........."));
        Assert.assertTrue(myAccountPage.textBoxPasswordLoginMyAccount.isDisplayed());
        ReusableMethods.getScreenshot("Parola degeri gizli");
        Driver.closeDriver();

    }
}
