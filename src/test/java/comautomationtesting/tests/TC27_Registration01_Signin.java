package comautomationtesting.tests;
import com.github.javafaker.Faker;
import comautomationtesting.pages.AllPages;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import org.testng.annotations.Test;
import static comautomationtesting.utilities.ReusableMethods.clickWithJS;
import static comautomationtesting.utilities.ReusableMethods.scrollIntoViewJS;
public class TC27_Registration01_Signin {
    AllPages allPages=new AllPages();
    Faker faker=new Faker();
    @Test
    public void Registration01_Signin() {
        String password1=Faker.instance().name().firstName();
        String password2=Faker.instance().name().lastName();
        int password3=Faker.instance().number().numberBetween(999,9999);
        String password=password1+password2+password3;
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        //3) Click on My Account Menu
        clickWithJS(allPages.homePage().myAccountButtonHome);
        Driver.getDriver().navigate().refresh();
        allPages.homePage().myAccountButtonHome.click();
        //4) Enter registered Email Address in Email-Address textbox
        allPages.myAccountPage().textBoxEmailRegisterMyAccount.sendKeys(Faker.instance().internet().emailAddress());
        //5) Enter your own password in password textbox
        allPages.myAccountPage().textBoxPasswordRegisterMyAccount.sendKeys(password);
        //6) Click on Register button
        allPages.myAccountPage().registerButtonMyAccount.click();
        //7) User will be registered successfully and will be navigated to the Home page
        assert allPages.myAccountPage().signOutButtonMyAccount.isDisplayed();
        Driver.getDriver().navigate().to(ConfigurationReader.getProperty("au_url"));
        scrollIntoViewJS(allPages.homePage().firstArrivals);
        assert allPages.homePage().firstArrivals.isDisplayed();
        Driver.closeDriver();
    }
}
