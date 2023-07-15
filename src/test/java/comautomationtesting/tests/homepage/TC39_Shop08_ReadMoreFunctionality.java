package comautomationtesting.tests.homepage;

import comautomationtesting.pages.BasketPage;
import comautomationtesting.pages.Homepage;
import comautomationtesting.pages.ShopPage;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import comautomationtesting.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC39_Shop08_ReadMoreFunctionality {
    Homepage homepage = new Homepage();
    ShopPage shopPage=new ShopPage();
    BasketPage basketPage=new BasketPage();
    @Test
    public void ReadMoreFunctionality() {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        //3) Click on Shop Menu
        ReusableMethods.clickWithJS(homepage.shopButton);
        Driver.getDriver().navigate().refresh();
        ReusableMethods.clickWithJS(homepage.shopButton);
        //4) Click on read more button in home page
        shopPage.addToBasketButtonAndroidQickStartShop.click();
        //5) Read More option indicates the Out Of Stock.
        shopPage.vievBasketButtonAndroidQickStartShop.click();
        //6) User cannot add the product which has read more option as it was out of stock.
        Assert.assertTrue(shopPage.androidQickStartQideShop.isDisplayed());
        basketPage.removeProductButtonBasket.click();
        Assert.assertTrue(basketPage.textEmptyBasket.isDisplayed());
    }
}
