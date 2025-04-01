package comautomationtesting.tests.homepage;

import comautomationtesting.pages.HomePage;
import comautomationtesting.pages.ShopPage;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import comautomationtesting.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC33_Shop02_ProductCategoriesFunctionality {
    HomePage homepage = new HomePage();
    ShopPage shopPage=new ShopPage();
    @Test
    public void ProductCategoriesFunctionality() throws InterruptedException {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        //3) Click on Shop Menu
        ReusableMethods.clickWithJS(homepage.shopButton);
        Driver.getDriver().navigate().refresh();
        ReusableMethods.clickWithJS(homepage.shopButton);
        //4) Click any of the product links available in the product category
        ReusableMethods.clickWithJS(shopPage.linkAndroidShop);
        //5) Now user can view only that particular product
        Assert.assertTrue(shopPage.androidProductImageShop.isDisplayed());
        Thread.sleep(1000);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("android"));
        Driver.closeDriver();
    }
}
