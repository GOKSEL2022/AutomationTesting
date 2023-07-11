package comautomationtesting.tests.homepage;

import comautomationtesting.pages.Homepage;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import comautomationtesting.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public final class TC01_ThreeSlidersOnly {
    @Test
    public void ThreeSlidersOnlyTest() {

        Homepage homepage = new Homepage();
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        //3) Click on Shop Menu
        ReusableMethods.clickWithJS(homepage.shopButton);
        //4) Now click on Home menu button
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitAndClick(homepage.shopButton);
        Driver.getDriver().navigate().back();

        //5) Test whether the Home page has Three Sliders only
        Assert.assertEquals(3,homepage.threeSlidersHome.size());
        //ReusableMethods.scrollIntoViewJS(homepage.threeSliders);
        //assert homepage.threeSliders.isDisplayed();

        //6) The Home page must contains only three sliders
        Assert.assertEquals(homepage.arriwals.size(), 3);
        Reporter.log("Sayfada sadece 3 urun oldugu dogrulanir");

        //Driver.closeDriver();


    }
}
