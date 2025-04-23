package comautomationtesting.tests;
import comautomationtesting.pages.AllPages;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import static comautomationtesting.utilities.ReusableMethods.clickWithJS;
public class TC32_Shop01_FilterByPriceFunctionality {
    AllPages allPages=new AllPages();
    Actions actions=new Actions(Driver.getDriver());
    @Test
    public void FilterByPriceFunctionality() {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        //3) Click on Shop Menu
        clickWithJS(allPages.homePage().shopButton);
        Driver.getDriver().navigate().refresh();
        clickWithJS(allPages.homePage().shopButton);
        //4) Adjust the filter by price between 150 to 450 rps
        actions.dragAndDropBy(allPages.shopPage().price500FilterShop,-28,0).perform();
        //5) Now click on Filter button
        allPages.shopPage().filterButtonShop.click();
        //6) User can view books only between 150 to 450 rps price
        assert Driver.getDriver().getCurrentUrl().contains("?min_price=150&max_price=451");
        Driver.closeDriver();
    }
}
