package comautomationtesting.tests;
import comautomationtesting.pages.AllPages;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import static comautomationtesting.utilities.ReusableMethods.clickWithJS;
public class TC22_Login04_EmptyUsernameAndValidPassword {
    AllPages allPages=new AllPages();
    @Test
    public void EmptyUsernameAndValidPassword() {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        //3) Click on My Account Menu
        clickWithJS(allPages.homePage().myAccountButtonHome);
        Driver.getDriver().navigate().refresh();
        allPages.homePage().myAccountButtonHome.click();
        //4) Enter empty username in username textbox
        allPages.myAccountPage().textBoxUsernameLoginMyAccount.sendKeys(Keys.SPACE,Keys.SPACE,Keys.SPACE);
        //5) Now enter valid password in the password textbox
        allPages.myAccountPage().textBoxPasswordLoginMyAccount.sendKeys("goksel123++");
        //6) Click on login button.
        allPages.myAccountPage().loginButtonLoginMyAccount.click();
        //7) Proper error must be displayed(ie Invalid username) and prompt to enter login again
        assert allPages.myAccountPage().textErrorMessageMyAccount.getText().contains(" Username is required.");
        Driver.closeDriver();
    }
}
