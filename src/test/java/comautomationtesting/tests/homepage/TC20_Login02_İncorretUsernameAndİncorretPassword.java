package comautomationtesting.tests.homepage;

import com.github.javafaker.Faker;
import comautomationtesting.pages.Homepage;
import comautomationtesting.pages.MyAccountPage;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import comautomationtesting.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC20_Login02_İncorretUsernameAndİncorretPassword {
    Homepage homepage = new Homepage();
    MyAccountPage myAccountPage = new MyAccountPage();
    Faker faker = new Faker();
    @Test
    public void İncorretUsernameAndİncorretPassword() {
        String email = Faker.instance().internet().emailAddress();
        String password=Faker.instance().name().firstName()+Faker.instance().number().numberBetween(1,100);
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        //3) Click on My Account Menu
        ReusableMethods.clickWithJS(homepage.myAccountButtonHome);
        Driver.getDriver().navigate().refresh();
        homepage.myAccountButtonHome.click();
        //4) Enter incorrect username in username textbox
        //5) Enter incorrect password in password textbox.
        myAccountPage.textBoxUsernameLoginMyAccount.sendKeys(email);
        myAccountPage.textBoxPasswordLoginMyAccount.sendKeys(password);
        //6) Click on login button
        myAccountPage.loginButtonLoginMyAccount.click();
        //7) Proper error must be displayed(ie Invalid username) and prompt to enter login again
        Assert.assertTrue(myAccountPage.textErrorMessageMyAccount.getText().contains("A user could not be found with this email address."));

    }
}
