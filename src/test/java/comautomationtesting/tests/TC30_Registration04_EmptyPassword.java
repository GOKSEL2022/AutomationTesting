package comautomationtesting.tests;
import comautomationtesting.pages.AllPages;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import static comautomationtesting.utilities.ReusableMethods.clickWithJS;
public class TC30_Registration04_EmptyPassword {
    AllPages allPages=new AllPages();
    @Test
    public void EmptyPassword() {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        //3) Click on My Account Menu
        clickWithJS(allPages.homePage().myAccountButtonHome);
        Driver.getDriver().navigate().refresh();
        allPages.homePage().myAccountButtonHome.click();
        //4) Enter valid Email Address in Email-Address textbox
        allPages.myAccountPage().textBoxEmailRegisterMyAccount.sendKeys(ConfigurationReader.getProperty("email"));
        //5) Enter empty password in password textbox
        allPages.myAccountPage().textBoxPasswordRegisterMyAccount.sendKeys(Keys.SPACE,Keys.SPACE,Keys.SPACE);
        //6) Click on Register button
        allPages.myAccountPage().registerButtonMyAccount.click();
        //7) Registration must fail with a warning message(ie please enter an account password)
        assert allPages.myAccountPage().registerButtonMyAccount.isDisplayed();
        Driver.closeDriver();
    }
}
