package comautomationtesting.tests.homepage;

import comautomationtesting.pages.Homepage;
import comautomationtesting.pages.ShopPage;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import comautomationtesting.utilities.ReusableMethods;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC34_Shop03_DefaultSortingFunctionality {
    Homepage homepage = new Homepage();
    ShopPage shopPage=new ShopPage();
    @Test
    public void Shop03DefaultSortingFunctionality() {

        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        //3) Click on Shop Menu
        ReusableMethods.clickWithJS(homepage.shopButton);
        Driver.getDriver().navigate().refresh();
        ReusableMethods.clickWithJS(homepage.shopButton);
        //4) Click on Sort by Popularity item in Default sorting dropdown
        shopPage.defaultSortingDropDownShop.click();
        //5) Now user can view the popular products only
        Select select =new Select(shopPage.defaultSortingDropDownShop);
        select.selectByVisibleText("Sort by popularity");
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("orderby=popularity"));

        Driver.closeDriver();
    }
}
