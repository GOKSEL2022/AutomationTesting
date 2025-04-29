package comautomationtesting.tests;
import comautomationtesting.pages.AllPages;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import org.testng.annotations.Test;
import static comautomationtesting.utilities.ReusableMethods.clickWithJS;
public class TC39_Shop08_ReadMoreFunctionality {
    AllPages allPages=new AllPages();
    @Test
    public void ReadMoreFunctionality() {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        //3) Click on Shop Menu
        clickWithJS(allPages.homePage().shopButton);
        Driver.getDriver().navigate().refresh();
        clickWithJS(allPages.homePage().shopButton);
        //4) Click on read more button in home page
        allPages.shopPage().addToBasketButtonAndroidQickStartShop.click();
        //5) Read More option indicates the Out Of Stock.
        allPages.shopPage().vievBasketButtonAndroidQickStartShop.click();
        //6) User cannot add the product which has read more option as it was out of stock.
        assert allPages.shopPage().androidQickStartQideShop.isDisplayed();
        allPages.basketPage().removeProductButtonBasket.click();
        assert allPages.basketPage().textEmptyBasket.isDisplayed();
        Driver.closeDriver();
    }
}
