package comautomationtesting.tests.homepage;

import comautomationtesting.pages.HomePage;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import comautomationtesting.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC02_ThreeArriwalsOnly {
    @Test
    public void ThreeArriwalsOnly() {
        HomePage homepage=new HomePage();

        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        Reporter.log("Sayfaya gidilir");
        //3) Click on Shop Menu
        ReusableMethods.clickWithJS(homepage.shopButton);
        Reporter.log("Shop butona tiklanir" );

        //4) Now click on Home menu button
        Driver.getDriver().navigate().refresh();
        ReusableMethods.clickWithJS(homepage.shopButton);
        ReusableMethods.clickWithJS(homepage.homeButton);
        Reporter.log("Home butona tiklanir");
        //5) Test whether the Home page has Three Arrivals only
        //6) The Home page must contains only three Arrivals
        Assert.assertEquals(homepage.arriwals.size(), 3);
        Reporter.log("Sayfada sadece 3 urun oldugu dogrulanir");
        Driver.closeDriver();

    }
}
