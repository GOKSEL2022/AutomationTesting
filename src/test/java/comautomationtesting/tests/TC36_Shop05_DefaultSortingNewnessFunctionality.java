package comautomationtesting.tests;
import comautomationtesting.pages.AllPages;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import static comautomationtesting.utilities.ReusableMethods.clickWithJS;
public class TC36_Shop05_DefaultSortingNewnessFunctionality {
    AllPages allPages=new AllPages();
    @Test
    public void DefaultSortingNewnessFunctionality() {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        //3) Click on Shop Menu
        clickWithJS(allPages.homePage().shopButton);
        Driver.getDriver().navigate().refresh();
        clickWithJS(allPages.homePage().shopButton);
        //4) Click on Sort by Newness ratings in Default sorting dropdown
        allPages.shopPage().defaultSortingDropDownShop.click();
        //5) Now user can view the popular products only
        new Select(allPages.shopPage().defaultSortingDropDownShop).selectByVisibleText("Sort by newness");
        assert Driver.getDriver().getCurrentUrl().contains("orderby=date");
        Driver.closeDriver();
    }
}
