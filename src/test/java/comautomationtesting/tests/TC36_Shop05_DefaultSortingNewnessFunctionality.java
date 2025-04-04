package comautomationtesting.tests;

import comautomationtesting.pages.HomePage;
import comautomationtesting.pages.ShopPage;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import comautomationtesting.utilities.ReusableMethods;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC36_Shop05_DefaultSortingNewnessFunctionality {
    HomePage homepage = new HomePage();
    ShopPage shopPage=new ShopPage();
    @Test
    public void DefaultSortingNewnessFunctionality() {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        //3) Click on Shop Menu
        ReusableMethods.clickWithJS(homepage.shopButton);
        Driver.getDriver().navigate().refresh();
        ReusableMethods.clickWithJS(homepage.shopButton);
        //4) Click on Sort by Newness ratings in Default sorting dropdown
        shopPage.defaultSortingDropDownShop.click();
        //5) Now user can view the popular products only
        Select select =new Select(shopPage.defaultSortingDropDownShop);
        select.selectByVisibleText("Sort by newness");
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("orderby=date"));

        Driver.closeDriver();
    }
}
