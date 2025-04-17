package comautomationtesting.tests;
import comautomationtesting.pages.AllPages;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import static comautomationtesting.utilities.ReusableMethods.clickWithJS;
public class TC21_Login03_CorretUsernameAndEmptyPassword {
    AllPages allPages=new AllPages();
    @Test
    public void CorretUsernameAndEmptyPassword() {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        //3) Click on My Account Menu
        clickWithJS(allPages.homePage().myAccountButtonHome);
        Driver.getDriver().navigate().refresh();
        allPages.homePage().myAccountButtonHome.click();
        //4) Enter valid username in username textbox
        allPages.myAccountPage().textBoxUsernameLoginMyAccount.sendKeys("goksel5255@gmail.com");
        //5) Now enter empty password in the password textbox
        allPages.myAccountPage().textBoxPasswordLoginMyAccount.sendKeys(Keys.SPACE,Keys.SPACE,Keys.SPACE);
        //6) Click on login button.
        allPages.myAccountPage().loginButtonLoginMyAccount.click();
        //7) Proper error must be displayed(ie Invalid password) and prompt to enter login again
        assert allPages.myAccountPage().textErrorEmptyMessageMyAccount.getText().contains("empty");
        Driver.closeDriver();
    }
}
