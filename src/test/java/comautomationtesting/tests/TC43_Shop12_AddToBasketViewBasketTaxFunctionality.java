package comautomationtesting.tests;
import comautomationtesting.pages.*;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import static comautomationtesting.utilities.ReusableMethods.clickWithJS;
import static comautomationtesting.utilities.ReusableMethods.scrollIntoViewJS;
public class TC43_Shop12_AddToBasketViewBasketTaxFunctionality {
    AllPages allPages=new AllPages();
    @Test
    public void AddToBasketViewBasketTaxFunctionality() throws InterruptedException {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        //3) Click on Shop Menu
        clickWithJS(allPages.homePage().shopButton);
        Driver.getDriver().navigate().refresh();
        clickWithJS(allPages.homePage().shopButton);
        //4) Click on the Add To Basket button which adds that book to your basket
        allPages.shopPage().addToBasketButtonAndroidQickStartShop.click();
        //5) User can view that Book in the Menu item with price .
        assert allPages.shopPage().textPriceShop.isDisplayed();
        //6) Now click on Item link which navigates to proceed to check out page.
        Driver.getDriver().navigate().refresh();
        wait(1);
        clickWithJS(allPages.shopPage().itemButtonShop);
        //7) Now user can find total and subtotal values just above the Proceed to Checkout button.
        assert allPages.basketPage().subtotalPriceBasket.isDisplayed();
        assert allPages.basketPage().totalPriceBasket.isDisplayed();
        //8) The total always < subtotal because taxes are added in the subtotal
        String subTotal=allPages.basketPage().subtotalPriceBasket.getText();
        subTotal=subTotal.replaceAll("\\D","");
        String total=allPages.basketPage().totalPriceBasket.getText();
        total=total.replaceAll("\\D","");
        int totalInt=Integer.parseInt(total);
        int subtotalInt=Integer.parseInt(subTotal);
        assert totalInt > subtotalInt;
        //9) The tax rate variers for India compared to other countries
        clickWithJS(allPages.basketPage().proceedToCheckoutButtonBasket);
        //10) Tax rate for indian should be 2% and for abroad it should be 5%
       scrollIntoViewJS(allPages.checkoutPage().phoneNameCheckout);
       allPages.checkoutPage().phoneNameCheckout.sendKeys(Keys.SPACE,
               Keys.SPACE,Keys.TAB,Keys.ARROW_UP,Keys.ARROW_UP,Keys.ARROW_DOWN,Keys.ENTER);
       String subtotal=allPages.checkoutPage().subtoltalPriceAndTextCheckout.getText();
       subtotal=subtotal.replaceAll("\\D","");
       int yeniSubtotal= Integer.parseInt(subtotal);
       String tax=allPages.checkoutPage().taxPriceAndTextCheckout.getText();
       tax=tax.replaceAll("\\D","");
       int yeniTax=Integer.parseInt(tax);
       Assert.assertTrue(2/100==yeniTax/yeniSubtotal);
       Assert.assertEquals(2/100,yeniTax/yeniSubtotal);
       Driver.closeDriver();
    }
}
