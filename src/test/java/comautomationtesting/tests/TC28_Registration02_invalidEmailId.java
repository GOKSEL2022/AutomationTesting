package comautomationtesting.tests;
import com.github.javafaker.Faker;
import comautomationtesting.pages.AllPages;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import org.testng.annotations.Test;
import static comautomationtesting.utilities.ReusableMethods.clickWithJS;
public class TC28_Registration02_invalidEmailId {
    AllPages allPages=new AllPages();
    Faker faker=new Faker();
    @Test
    public void Registration02_invalidEmailId () {
        String email=Faker.instance().name().firstName();
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        //3) Click on My Account Menu
        clickWithJS(allPages.homePage().myAccountButtonHome);
        Driver.getDriver().navigate().refresh();
        allPages.homePage().myAccountButtonHome.click();
        //4) Enter invalid Email Address in Email-Address textbox
        allPages.myAccountPage().textBoxEmailRegisterMyAccount.sendKeys(email);
        //5) Enter your own password in password textbox
        allPages.myAccountPage().textBoxPasswordRegisterMyAccount.sendKeys(ConfigurationReader.getProperty("password"));
        //6) Click on Register button
        allPages.myAccountPage().registerButtonMyAccount.click();
        //7) Registration must fail with a warning message(ie You must enter a valid email address)
        assert allPages.myAccountPage().registerButtonMyAccount.isDisplayed();
        Driver.closeDriver();
    }
}
