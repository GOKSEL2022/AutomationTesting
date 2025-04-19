package comautomationtesting.tests;
import com.github.javafaker.Faker;
import comautomationtesting.pages.AllPages;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import comautomationtesting.utilities.ReusableMethods;
import org.testng.annotations.Test;
public class TC25_Login07_HandlesCaseSensitive {
    AllPages allPages=new AllPages();
    @Test
    public void HandlesCaseSensitive() {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        //3) Click on My Account Menu
        ReusableMethods.clickWithJS(allPages.homePage().myAccountButtonHome);
        Driver.getDriver().navigate().refresh();
        allPages.homePage().myAccountButtonHome.click();
        //4) Enter the case changed username in username textbox
        allPages.myAccountPage().textBoxUsernameLoginMyAccount.sendKeys(Faker.instance().internet().emailAddress());
        //5) Enter the case chenged password in the password tetxbox
        allPages.myAccountPage().textBoxPasswordLoginMyAccount.sendKeys(Faker.instance().internet().emailAddress());
        //6) Now click on login button
        allPages.myAccountPage().loginButtonLoginMyAccount.click();
        //7) Login must fail saying incorrect username/password.
        assert allPages.myAccountPage().textErrorMessageMyAccount.getText().contains(" A user could not be found with this email address.");
        Driver.closeDriver();
    }
}
