package comautomationtesting.tests;
import comautomationtesting.pages.AllPages;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import org.testng.annotations.Test;
import static comautomationtesting.utilities.ReusableMethods.clickWithJS;
public class TC33_Shop02_ProductCategoriesFunctionality {
    AllPages allPages=new AllPages();
    @Test
    public void ProductCategoriesFunctionality() throws InterruptedException {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        //3) Click on Shop Menu
        clickWithJS(allPages.homePage().shopButton);
        Driver.getDriver().navigate().refresh();
        clickWithJS(allPages.homePage().shopButton);
        //4) Click any of the product links available in the product category
        clickWithJS(allPages.shopPage().linkAndroidShop);
        //5) Now user can view only that particular product
        assert allPages.shopPage().androidProductImageShop.isDisplayed();
        Thread.sleep(1000);
        assert Driver.getDriver().getCurrentUrl().contains("android");
        Driver.closeDriver();
    }
}
