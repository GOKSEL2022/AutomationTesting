package comautomationtesting.tests.homepage;
import comautomationtesting.pages.Homepage;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import static comautomationtesting.utilities.ReusableMethods.clickWithJS;
import static comautomationtesting.utilities.ReusableMethods.waitAndClick;
import static org.testng.AssertJUnit.assertEquals;

public final class TC01_ThreeSlidersOnly {
    @Test
    public void ThreeSlidersOnlyTest() {

        Homepage homepage = new Homepage();
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        //3) Click on Shop Menu
        clickWithJS(homepage.shopButton);
        //4) Now click on Home menu button
        Driver.getDriver().navigate().refresh();
        waitAndClick(homepage.shopButton);
        Driver.getDriver().navigate().back();

        //5) Test whether the Home page has Three Sliders only
        assertEquals(3,homepage.threeSlidersHome.size());
        //ReusableMethods.scrollIntoViewJS(homepage.threeSliders);
        //assert homepage.threeSliders.isDisplayed();

        //6) The Home page must contains only three sliders
        assertEquals(homepage.arriwals.size(), 3);
        Reporter.log("Sayfada sadece 3 urun oldugu dogrulanir");

        //Driver.closeDriver();


    }
}
