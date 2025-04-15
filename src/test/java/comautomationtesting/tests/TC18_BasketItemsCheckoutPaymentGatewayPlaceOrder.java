package comautomationtesting.tests;
import com.github.javafaker.Faker;
import comautomationtesting.pages.*;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import static comautomationtesting.utilities.ReusableMethods.*;
public class TC18_BasketItemsCheckoutPaymentGatewayPlaceOrder {
    @Test
    public void BasketItemsCheckoutPaymentGatewayPlaceOrder() throws InterruptedException {
            AllPages allPages=new AllPages();
            //1) Open the browser
            //2) Enter the URL “http://practice.automationtesting.in/”
            Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
            Reporter.log("Sayfaya gidilir");
            //3) Click on Shop Menu
            clickWithJS(allPages.homePage().shopButton);
            Reporter.log("Shop butona tiklanir");
            //4) Now click on Home menu button
            Driver.getDriver().navigate().refresh();
            clickWithJS(allPages.homePage().shopButton);
            clickWithJS(allPages.homePage().homeButton);
            Reporter.log("Home butona tiklanir");
            //5) Test whether the Home page has Three Arrivals only
            //6) The Home page must contains only three Arrivals
            Driver.getDriver().navigate().refresh();
            Assert.assertEquals(allPages.homePage().arriwals.size(), 3);
            Reporter.log("Sayfada sadece 3 urun oldugu dogrulanir");
            //7) Now click the image in the Arrivals
            clickWithJS(allPages.homePage().firstArrivals);
            Reporter.log("İlk urune tiklanir");
            //8) Test whether it is navigating to next page where the user can add that book into his basket.
            assert allPages.productPage().textSeleniumRubyProduct.isDisplayed();
            Reporter.log("Secilen kitabin sepete eklenecegi sayfanin acildigi dogrulanir");
            //9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
            clickWithJS(allPages.productPage().imagesSeleniumRubyProduct);
            Reporter.log("İlk urunun resmine tiklanir");
            Driver.getDriver().navigate().refresh();
            clickWithJS(allPages.productPage().addtobasketButtonProduct);
            Reporter.log("Kullanici urun ekleme butonuna tiklar");
            clickWithJS(allPages.productPage().viewbasketButtonProduct);
            Reporter.log("İlk urunun sepet sayfasina gidilir");
            assert allPages.basketPage().textBasketTotalsBasket.isDisplayed();
            Reporter.log("Kullanicinin sepet sayfasinda oldugu dogrulanir");
            //10) Click on the Add To Basket button which adds that book to your basket
            Driver.getDriver().navigate().back();
            clickWithJS(allPages.productPage().addtobasketButtonProduct);
            Reporter.log("Kullanici sepete ekle butonuna tiklar");
            //11) User can view that Book in the Menu item with price.
            assert allPages.productPage().text500$$Product.isDisplayed();
            Reporter.log("Kullanici urunun fiyatini sayfada görebilir");
            //12) Now click on Item link which navigates to proceed to check out page.
            clickWithJS(allPages.productPage().itemsBasketMenu);
            Reporter.log("Kullanici sayfanin sag ustundeki sepet simgesine tiklar");
            //13) Now user can find total and subtotal values just above the Proceed to Checkout button.
            assert allPages.basketPage().textSubtotalBasket.isDisplayed();
            assert allPages.basketPage().textTotalBasket.isDisplayed();
            Reporter.log("Kullanici ara toplam ve toplam tutari gorebilir");
            //14) The total always < subtotal because taxes are added in the subtotal
            String subTotal=allPages.basketPage().subtotalPriceBasket.getText();
            subTotal=subTotal.replaceAll("\\D","");
            String total=allPages.basketPage().totalPriceBasket.getText();
            total=total.replaceAll("\\D","");
            int totalInt=Integer.parseInt(total);
            int subtotalInt=Integer.parseInt(subTotal);
            Assert.assertTrue(totalInt>subtotalInt);
            Reporter.log("Kullanici her zaman toplam miktarin ara toplamdan buyuk oldugunu gorur");
            //15) Now click on Proceed to Check out button which navigates to payment gateway page.
            clickWithJS(allPages.basketPage().proceedToCheckoutButtonBasket);
            Reporter.log("Proceed To Checkout butonuna tiklanir");
            //16)User can view Billing Details,Order Details,Additional details and Payment gateway details.
            assert allPages.checkoutPage().textBillingDetailsCheckout.isDisplayed();
            assert allPages.checkoutPage().textAdditionalInformationCheckout.isDisplayed();
            assert allPages.checkoutPage().textYourOrderCheckout.isDisplayed();
            assert allPages.checkoutPage().textTotalCheckout.isDisplayed();
            Reporter.log("Billing,Your Order,Additional ve odeme detaylari goruntulenir");
            //17)Now user can fill his details in billing details form and can opt any payment in the payment gateway like Direct bank transfer,cheque,cash or paypal.
            allPages.checkoutPage().firstNameCheckout.sendKeys(Faker.instance().name().firstName());
            waitFor(1);
            allPages.checkoutPage().lastNameCheckout.sendKeys(Faker.instance().name().lastName());
            waitFor(1);
            allPages.checkoutPage().companyNameCheckout.sendKeys(Faker.instance().company().name());
            waitFor(1);
            allPages.checkoutPage().emailNameCheckout.sendKeys(Faker.instance().internet().emailAddress());
            waitFor(1);
            allPages.checkoutPage().phoneNameCheckout.sendKeys(Faker.instance().phoneNumber().phoneNumber(),Keys.TAB,Keys.ARROW_UP,Keys.ARROW_DOWN,Keys.ENTER);
            waitFor(1);
            allPages.checkoutPage().address1Checkout.sendKeys(Faker.instance().address().streetAddress());
            waitFor(1);
            allPages.checkoutPage().address2Checkout.sendKeys(Faker.instance().address().fullAddress());
            waitFor(1);
            allPages.checkoutPage().townCityCheckout.sendKeys(Faker.instance().address().city(),Keys.TAB,Keys.ARROW_UP,Keys.ARROW_DOWN,Keys.ENTER);
            waitFor(1);
            allPages.checkoutPage().postcodeCheckout.sendKeys(Faker.instance().address().zipCode());
            waitFor(1);
            scrollIntoViewJS(allPages.checkoutPage().textBoxAdditionalCheckout);
            allPages.checkoutPage().textBoxAdditionalCheckout.sendKeys(Faker.instance().lorem().paragraph());
            waitFor(1);
            scrollIntoViewJS(allPages.checkoutPage().placeOrderButtonCheckout);
            waitFor(1);
            clickWithJS(allPages.checkoutPage().placeOrderButtonCheckout);
            Reporter.log("Kullanici istenen alanlari doldurur");
        //18) Now click on Place Order button to complete process
        waitFor(1);
        scrollIntoViewJS(allPages.checkoutPage().placeOrderButtonCheckout);
        waitFor(1);
        clickWithJS(allPages.checkoutPage().placeOrderButtonCheckout);
        //19) On clicking place-order button user completes the process where the page navigates to Order confirmation page
        //with order details,bank details,customer details and billing details.
        assert allPages.checkoutPage().textOrderDetailsCheckout.isDisplayed();
        assert allPages.checkoutPage().textOurBankDetailsCheckout.isDisplayed();
        Driver.closeDriver();
    }
}
