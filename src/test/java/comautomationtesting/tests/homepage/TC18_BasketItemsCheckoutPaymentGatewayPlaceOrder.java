package comautomationtesting.tests.homepage;


import com.github.javafaker.Faker;
import comautomationtesting.pages.BasketPage;
import comautomationtesting.pages.CheckoutPage;
import comautomationtesting.pages.Homepage;
import comautomationtesting.pages.ProductPage;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import comautomationtesting.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC18_BasketItemsCheckoutPaymentGatewayPlaceOrder {
    @Test
    public void BasketItemsCheckoutPaymentGatewayPlaceOrder() throws InterruptedException {
        Homepage homepage = new Homepage();
        ProductPage productPage = new ProductPage();
        BasketPage basketPage = new BasketPage();
        CheckoutPage checkoutPage=new CheckoutPage();

        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        Reporter.log("Sayfaya gidilir");
        //3) Click on Shop Menu
        ReusableMethods.clickWithJS(homepage.shopButton);
        Reporter.log("Shop butona tiklanir");
        //4) Now click on Home menu button
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
        String total=basketPage.totalPriceBasket.getText();
        total=total.replaceAll("\\D","");
        int totalInt=Integer.parseInt(total);
        int subtotalInt=Integer.parseInt(subTotal);
        Assert.assertTrue(totalInt>subtotalInt);
        Reporter.log("Kullanici her zaman toplam miktarin ara toplamdan buyuk oldugunu gorur");
        //15) Now click on Proceed to Check out button which navigates to payment gateway page.
        ReusableMethods.clickWithJS(basketPage.proceedToCheckoutButtonBasket);
        Reporter.log("Proceed To Checkout butonuna tiklanir");
        //16)User can view Billing Details,Order Details,Additional details and Payment gateway details.
        Assert.assertTrue(checkoutPage.textBillingDetailsCheckout.isDisplayed());
        Assert.assertTrue(checkoutPage.textAdditionalInformationCheckout.isDisplayed());
        Assert.assertTrue(checkoutPage.textYourOrderCheckout.isDisplayed());
        Assert.assertTrue(checkoutPage.textTotalCheckout.isDisplayed());
        Reporter.log("Billing,Your Order,Additional ve odeme detaylari goruntulenir");
        //17)Now user can fill his details in billing details form and can opt any payment in the payment gateway like Direct bank transfer,cheque,cash or paypal.
        checkoutPage.firstNameCheckout.sendKeys(Faker.instance().name().firstName());
        Thread.sleep(1000);
        checkoutPage.lastNameCheckout.sendKeys(Faker.instance().name().lastName());
        Thread.sleep(1000);
        checkoutPage.companyNameCheckout.sendKeys(Faker.instance().company().name());
        Thread.sleep(1000);
        checkoutPage.emailNameCheckout.sendKeys(Faker.instance().internet().emailAddress());
        Thread.sleep(1000);
        checkoutPage.phoneNameCheckout.sendKeys("0452-481-21-66", Keys.TAB,Keys.ARROW_UP,Keys.ARROW_DOWN,Keys.ENTER);
        Thread.sleep(1000);
        checkoutPage.address1Checkout.sendKeys(Faker.instance().address().streetAddress());
        Thread.sleep(1000);
        checkoutPage.address2Checkout.sendKeys(Faker.instance().address().fullAddress());
        Thread.sleep(1000);
        checkoutPage.townCityCheckout.sendKeys(Faker.instance().address().city(),Keys.TAB,Keys.ARROW_UP,Keys.ARROW_DOWN,Keys.ENTER);
        Thread.sleep(1000);
        checkoutPage.postcodeCheckout.sendKeys(Faker.instance().address().zipCode());
        Thread.sleep(1000);
        ReusableMethods.scrollIntoViewJS(checkoutPage.textBoxAdditionalCheckout);
        checkoutPage.textBoxAdditionalCheckout.sendKeys(Faker.instance().lorem().paragraph());
        Reporter.log("Kullanici istenen alanlari doldurur");
        //18) Now click on Place Order button to complete process
        Thread.sleep(1000);
        ReusableMethods.scrollIntoViewJS(checkoutPage.placeOrderButtonCheckout);
        Thread.sleep(1000);
        ReusableMethods.clickWithJS(checkoutPage.placeOrderButtonCheckout);
        //19) On clicking place-order button user completes the process where the page navigates to Order confirmation page
        //with order details,bank details,customer details and billing details.
        Assert.assertTrue(checkoutPage.textOrderDetailsCheckout.isDisplayed());
        Assert.assertTrue(checkoutPage.textOurBankDetailsCheckout.isDisplayed());

    }
}
