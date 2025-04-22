package comautomationtesting.tests;
import comautomationtesting.pages.AllPages;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import static comautomationtesting.utilities.ReusableMethods.clickWithJS;
public class TC31_Registration05_EmptyEmailIdPassword {
    AllPages allPages=new AllPages();
    @Test
    public void EmptyEmailIdPassword() {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        //3) Click on My Account Menu
        clickWithJS(allPages.homePage().myAccountButtonHome);
        Driver.getDriver().navigate().refresh();
        allPages.homePage().myAccountButtonHome.click();
        //4) Enter empty Email Address in Email-Address textbox
        allPages.myAccountPage().textBoxEmailRegisterMyAccount.sendKeys(Keys.SPACE,Keys.SPACE,Keys.SPACE);
        allPages.myAccountPage().textBoxPasswordRegisterMyAccount.sendKeys(Keys.SPACE,Keys.SPACE,Keys.SPACE);
        //6) Click on Register button
        allPages.myAccountPage().registerButtonMyAccount.click();
        //7) Registration must fail with a warning message(ie please provide valid email address)
        assert allPages.myAccountPage().registerButtonMyAccount.isDisplayed();
        Driver.closeDriver();
    }
}
