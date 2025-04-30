package comautomationtesting.tests;
import comautomationtesting.pages.*;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import org.testng.annotations.Test;
import static comautomationtesting.utilities.ReusableMethods.clickWithJS;
public class TC40_Shop09_SaleFunctionality {
    AllPages allPages=new AllPages();
    @Test
    public void SaleFunctionality() {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        //3) Click on Shop Menu
        clickWithJS(allPages.homePage().shopButton);
        Driver.getDriver().navigate().refresh();
        clickWithJS(allPages.homePage().shopButton);
        //4) Click on Sale written product in home page
        allPages.shopPage().saleButtonShop.click();
        Driver.getDriver().navigate().refresh();
        //5) User can clearly view the actual price with old price striken for the sale written products
        assert allPages.productPage().textPriceSaleProduct.getText().contains("600.00");
        assert allPages.productPage().textPriceSaleProduct.getText().contains("450.00");
        Driver.closeDriver();
    }
}
