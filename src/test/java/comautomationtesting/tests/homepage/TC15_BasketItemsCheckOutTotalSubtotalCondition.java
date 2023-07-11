package comautomationtesting.tests.homepage;

import comautomationtesting.pages.BasketPage;
import comautomationtesting.pages.Homepage;
import comautomationtesting.pages.ProductPage;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import comautomationtesting.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC15_BasketItemsCheckOutTotalSubtotalCondition {
    @Test
    public void BasketItemsCheckOutTotalSubtotalCondition() {
        Homepage homepage = new Homepage();
        ProductPage productPage = new ProductPage();
        BasketPage basketPage = new BasketPage();

        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        Reporter.log("Sayfaya gidilir");
        //3) Click on Shop Menu
        ReusableMethods.clickWithJS(homepage.shopButton);
        Reporter.log("Shop butona tiklanir");
        //4) Now click on Home menu button
        Driver.getDriver().navigate().refresh();
        ReusableMethods.clickWithJS(homepage.shopButton);
        ReusableMethods.clickWithJS(homepage.homeButton);
        Reporter.log("Home butona tiklanir");
        //5) Test whether the Home page has Three Arrivals only
        //6) The Home page must contains only three Arrivals
        Driver.getDriver().navigate().refresh();
        Assert.assertEquals(homepage.arriwals.size(), 3);
        Reporter.log("Sayfada sadece 3 urun oldugu dogrulanir");
        //7) Now click the image in the Arrivals
        ReusableMethods.clickWithJS(homepage.firstArrivals);
        Reporter.log("İlk urune tiklanir");
        //8) Test whether it is navigating to next page where the user can add that book into his basket.
        Assert.assertTrue(productPage.textSeleniumRubyProduct.isDisplayed());
        Reporter.log("Secilen kitabin sepete eklenecegi sayfanin acildigi dogrulanir");
        //9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
        ReusableMethods.clickWithJS(productPage.imagesSeleniumRubyProduct);
        Reporter.log("İlk urunun resmine tiklanir");
        Driver.getDriver().navigate().refresh();
        ReusableMethods.clickWithJS(productPage.addtobasketButtonProduct);
        Reporter.log("Kullanici urun ekleme butonuna tiklar");
        ReusableMethods.clickWithJS(productPage.viewbasketButtonProduct);
        Reporter.log("İlk urunun sepet sayfasina gidilir");
        Assert.assertTrue(basketPage.textBasketTotalsBasket.isDisplayed());
        Reporter.log("Kullanicinin sepet sayfasinda oldugu dogrulanir");
        //10) Click on the Add To Basket button which adds that book to your basket
        Driver.getDriver().navigate().back();
        ReusableMethods.clickWithJS(productPage.addtobasketButtonProduct);
        Reporter.log("Kullanici sepete ekle butonuna tiklar");
        //11) User can view that Book in the Menu item with price.
        Assert.assertTrue(productPage.text500$$Product.isDisplayed());
        Reporter.log("Kullanici urunun fiyatini sayfada görebilir");
        //12) Now click on Item link which navigates to proceed to check out page.
        ReusableMethods.clickWithJS(productPage.itemsBasketMenu);
        Reporter.log("Kullanici sayfanin sag ustundeki sepet simgesine tiklar");
        //13) Now user can find total and subtotal values just above the Proceed to Checkout button.
        Assert.assertTrue(basketPage.textSubtotalBasket.isDisplayed());
        Assert.assertTrue(basketPage.textTotalBasket.isDisplayed());
        Reporter.log("Kullanici ara toplam ve toplam tutari gorebilir");
        //14) The total always < subtotal because taxes are added in the subtotal
        String subTotal=basketPage.subtotalPriceBasket.getText();
        subTotal=subTotal.replaceAll("\\D","");
        //System.out.println(subTotal);
        String total=basketPage.totalPriceBasket.getText();
        total=total.replaceAll("\\D","");
        //System.out.println(total);
        int totalInt=Integer.parseInt(total);
        int subtotalInt=Integer.parseInt(subTotal);
        Assert.assertTrue(totalInt>subtotalInt);
        Reporter.log("Kullanici her zaman toplam miktarin ara toplamdan buyuk oldugunu gorur");
        //15) Total
        Assert.assertTrue(basketPage.totalPriceBasket.isDisplayed());
        Reporter.log("Kullanici total bilgisini goruntuler");
    }

}
