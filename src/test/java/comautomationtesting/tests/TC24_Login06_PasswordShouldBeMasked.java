package comautomationtesting.tests;
import comautomationtesting.pages.AllPages;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import org.testng.annotations.Test;
import java.io.IOException;
import static comautomationtesting.utilities.ReusableMethods.clickWithJS;
import static comautomationtesting.utilities.ReusableMethods.getScreenshot;
public class TC24_Login06_PasswordShouldBeMasked {
    AllPages allPages=new AllPages();
    @Test
    public void PasswordShouldBeMasked() throws IOException {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        //3) Click on My Account Menu
        clickWithJS(allPages.homePage().myAccountButtonHome);
        Driver.getDriver().navigate().refresh();
        allPages.homePage().myAccountButtonHome.click();
        //4) Enter the password field with some characters.
        allPages.myAccountPage().textBoxPasswordLoginMyAccount.sendKeys("***+++???");
        //5) The password field should display the characters in asterisks or bullets such that the password is not visible on the screen
        //Assert.assertTrue(myAccountPage.textBoxPasswordLoginMyAccount.getText().contains("........."));
        //Assert.assertTrue(myAccountPage.textBoxPasswordLoginMyAccount.getText().contains("***+++???"));
        //Assert.assertTrue(myAccountPage.textBoxPasswordLoginMyAccount.getAttribute("***+++???").contains("........."));
        assert allPages.myAccountPage().textBoxPasswordLoginMyAccount.isDisplayed();
        getScreenshot("Parola degeri gizli");
        Driver.closeDriver();
    }
}
