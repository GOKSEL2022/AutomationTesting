package comautomationtesting.tests.homepage;

import comautomationtesting.pages.Homepage;
import comautomationtesting.pages.ShopPage;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import comautomationtesting.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class TC32_Shop01_FilterByPriceFunctionality {
    Homepage homepage = new Homepage();
    ShopPage shopPage=new ShopPage();
    Actions actions=new Actions(Driver.getDriver());
    @Test
    public void FilterByPriceFunctionality() {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        //3) Click on Shop Menu
        ReusableMethods.clickWithJS(homepage.shopButton);
        Driver.getDriver().navigate().refresh();
        ReusableMethods.clickWithJS(homepage.shopButton);
        //4) Adjust the filter by price between 150 to 450 rps
        actions.dragAndDropBy(shopPage.price500FilterShop,-28,0).perform();
        //5) Now click on Filter button
        shopPage.filterButtonShop.click();
        //6) User can view books only between 150 to 450 rps price
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("?min_price=150&max_price=451"));
        Driver.closeDriver();


    }
}
