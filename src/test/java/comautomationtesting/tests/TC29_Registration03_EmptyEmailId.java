package comautomationtesting.tests;
import comautomationtesting.pages.AllPages;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import static comautomationtesting.utilities.ReusableMethods.clickWithJS;
public class TC29_Registration03_EmptyEmailId {
    AllPages allPages=new AllPages();
    @Test
    public void EmptyEmailId() {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        //3) Click on My Account Menu
        clickWithJS(allPages.homePage().myAccountButtonHome);
        Driver.getDriver().navigate().refresh();
        allPages.homePage().myAccountButtonHome.click();
        //4) Enter empty Email Address in Email-Address textbox
        allPages.myAccountPage().textBoxEmailRegisterMyAccount.sendKeys(Keys.SPACE,Keys.SPACE,Keys.SPACE);
        //5) Enter your own password in password textbox
        allPages.myAccountPage().textBoxPasswordRegisterMyAccount.sendKeys(ConfigurationReader.getProperty("password"));
        //6) Click on Register button
        allPages.myAccountPage().registerButtonMyAccount.click();
        //7) Registration must fail with a warning message(ie please provide valid email address)
        assert allPages.myAccountPage().textErrorMessageMyAccount.getText().contains(" Please provide a valid email address.");
        Driver.closeDriver();
    }
}
