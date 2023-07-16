package comautomationtesting.tests.homepage;

import comautomationtesting.pages.BasketPage;
import comautomationtesting.pages.Homepage;
import comautomationtesting.pages.ProductPage;
import comautomationtesting.pages.ShopPage;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import comautomationtesting.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC40_Shop09_SaleFunctionality {
    Homepage homepage = new Homepage();
    ShopPage shopPage=new ShopPage();
    BasketPage basketPage=new BasketPage();
    ProductPage productPage=new ProductPage();
    @Test
    public void SaleFunctionality() {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        //3) Click on Shop Menu
        ReusableMethods.clickWithJS(homepage.shopButton);
        Driver.getDriver().navigate().refresh();
        ReusableMethods.clickWithJS(homepage.shopButton);
        //4) Click on Sale written product in home page
        shopPage.saleButtonShop.click();
        Driver.getDriver().navigate().refresh();
        //5) User can clearly view the actual price with old price striken for the sale written products
        Assert.assertTrue(productPage.textPriceSaleProduct.getText().contains("600.00"));
        Assert.assertTrue(productPage.textPriceSaleProduct.getText().contains("450.00"));

        Driver.closeDriver();
    }
}
