package comautomationtesting.tests.homepage;

import com.github.javafaker.Faker;
import comautomationtesting.pages.HomePage;
import comautomationtesting.pages.MyAccountPage;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import comautomationtesting.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC27_Registration01_Signin {
    HomePage homepage=new HomePage();
    MyAccountPage myAccountPage=new MyAccountPage();
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
        ReusableMethods.clickWithJS(homepage.myAccountButtonHome);
        Driver.getDriver().navigate().refresh();
        homepage.myAccountButtonHome.click();
        //4) Enter registered Email Address in Email-Address textbox
        myAccountPage.textBoxEmailRegisterMyAccount.sendKeys(Faker.instance().internet().emailAddress());
        //5) Enter your own password in password textbox
        myAccountPage.textBoxPasswordRegisterMyAccount.sendKeys(password);
        //6) Click on Register button
        myAccountPage.registerButtonMyAccount.click();
        //7) User will be registered successfully and will be navigated to the Home page
        Assert.assertTrue(myAccountPage.signOutButtonMyAccount.isDisplayed());
        Driver.getDriver().navigate().to(ConfigurationReader.getProperty("au_url"));
        ReusableMethods.scrollIntoViewJS(homepage.firstArrivals);
        Assert.assertTrue(homepage.firstArrivals.isDisplayed());
        Driver.closeDriver();
    }
}
