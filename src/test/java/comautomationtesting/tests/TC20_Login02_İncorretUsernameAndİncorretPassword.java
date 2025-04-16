package comautomationtesting.tests;
import com.github.javafaker.Faker;
import comautomationtesting.pages.AllPages;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import org.testng.annotations.Test;
import static comautomationtesting.utilities.ReusableMethods.clickWithJS;
public class TC20_Login02_İncorretUsernameAndİncorretPassword {
    AllPages allPages=new AllPages();
    Faker faker = new Faker();
    @Test
    public void İncorretUsernameAndİncorretPassword() {
        String email = Faker.instance().internet().emailAddress();
        String password=Faker.instance().name().firstName()+Faker.instance().number().numberBetween(1,100);
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        //3) Click on My Account Menu
        clickWithJS(allPages.homePage().myAccountButtonHome);
        Driver.getDriver().navigate().refresh();
        allPages.homePage().myAccountButtonHome.click();
        //4) Enter incorrect username in username textbox
        //5) Enter incorrect password in password textbox.
        allPages.myAccountPage().textBoxUsernameLoginMyAccount.sendKeys(email);
        allPages.myAccountPage().textBoxPasswordLoginMyAccount.sendKeys(password);
        //6) Click on login button
        allPages.myAccountPage().loginButtonLoginMyAccount.click();
        //7) Proper error must be displayed(ie Invalid username) and prompt to enter login again
        assert allPages.myAccountPage().textErrorMessageMyAccount.getText().contains("A user could not be found with this email address.");
        Driver.closeDriver();
    }
}
