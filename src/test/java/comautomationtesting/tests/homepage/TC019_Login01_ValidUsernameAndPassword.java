package comautomationtesting.tests.homepage;

import com.github.javafaker.Faker;
import comautomationtesting.pages.Homepage;
import comautomationtesting.pages.MyAccountPage;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import comautomationtesting.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC019_Login01_ValidUsernameAndPassword {
    Homepage homepage = new Homepage();
    MyAccountPage myAccountPage = new MyAccountPage();
    Faker faker = new Faker();

    @Test(priority = 1)
    public void ValidUsernameAndPassword() throws InterruptedException {
        String email = Faker.instance().internet().emailAddress();
        String password=Faker.instance().name().firstName()+Faker.instance().number().numberBetween(1,100);
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        //3) Click on My Account Menu
        homepage.myAccountButtonHome.click();
        Driver.getDriver().navigate().refresh();
        homepage.myAccountButtonHome.click();
        //4) Enter registered username in username textbox
        myAccountPage.textBoxEmailRegisterMyAccount.sendKeys(email);
        //5) Enter password in password textbox
        myAccountPage.textBoxPasswordRegisterMyAccount.sendKeys(password);
        myAccountPage.registerButtonMyAccount.click();
        //7) User must successfully login to the web page
        Assert.assertTrue(myAccountPage.signOutButtonMyAccount.isDisplayed());
        //ReusableMethods.clickWithJS(myAccountPage.signOutButtonMyAccount);
        Driver.closeDriver();
        }

    @Test(priority = 2)
    public void Login() {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        //3) Click on My Account Menu
        ReusableMethods.clickWithJS(homepage.myAccountButtonHome);
        Driver.getDriver().navigate().refresh();
        homepage.myAccountButtonHome.click();
        //4) Enter registered username in username textbox
        //5) Enter password in password textbox
        myAccountPage.textBoxUsernameLoginMyAccount.sendKeys("goksel5255@gmail.com");
        myAccountPage.textBoxPasswordLoginMyAccount.sendKeys("goksel123++");
        //6) Click on login button
        myAccountPage.loginButtonLoginMyAccount.click();
        //7) User must successfully login to the web page
        Assert.assertTrue(myAccountPage.signOutButtonMyAccount.isDisplayed());
        ReusableMethods.clickWithJS(myAccountPage.signOutButtonMyAccount);
        Driver.closeDriver();

    }

}





/*
    try {
            if (homepage.myAccountButtonHome.isDisplayed()) {
                homepage.myAccountButtonHome.click();
            }else if (!homepage.myAccountButtonHome.isDisplayed())
            Driver.getDriver().navigate().refresh();
            homepage.myAccountButtonHome.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
 */

