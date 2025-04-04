package comautomationtesting.tests;

import com.github.javafaker.Faker;
import comautomationtesting.pages.*;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import comautomationtesting.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC42_Shop11_AddToBasketThroughItemLink {
    HomePage homepage = new HomePage();
    ShopPage shopPage=new ShopPage();
    BasketPage basketPage=new BasketPage();
    CheckoutPage checkoutPage=new CheckoutPage();
    @Test
    public void AddToBasketThroughItemLink() throws InterruptedException {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        //3) Click on Shop Menu
        ReusableMethods.clickWithJS(homepage.shopButton);
        Driver.getDriver().navigate().refresh();
        ReusableMethods.clickWithJS(homepage.shopButton);
        //4) Click on the Add To Basket button which adds that book to your basket
        shopPage.addToBasketButtonAndroidQickStartShop.click();
        //5) User can view that Book in the Menu item with price .
        assert shopPage.textPriceShop.isDisplayed();
        //6) Now click on Item link which navigates to proceed to check out page.
        Driver.getDriver().navigate().refresh();
        Thread.sleep(1000);
        ReusableMethods.clickWithJS(shopPage.itemButtonShop);
        //7) Now user can find total and subtotal values just above the Proceed to Checkout button.
        assert basketPage.subtotalPriceBasket.isDisplayed();
        assert basketPage.totalPriceBasket.isDisplayed();
        //8) The total always < subtotal because taxes are added in the subtotal
        String subTotal=basketPage.subtotalPriceBasket.getText();
        subTotal=subTotal.replaceAll("\\D","");
        String total=basketPage.totalPriceBasket.getText();
        total=total.replaceAll("\\D","");
        int totalInt=Integer.parseInt(total);
        int subtotalInt=Integer.parseInt(subTotal);
        Assert.assertTrue(totalInt>subtotalInt);
        //9) Now click on Proceed to Check out button which navigates to payment gateway page.
        basketPage.proceedToCheckoutButtonBasket.click();
        //10) User can view Billing Details,Order Details,Additional details and Payment gateway details.
        Assert.assertTrue(checkoutPage.textBillingDetailsCheckout.isDisplayed());
        Assert.assertTrue(checkoutPage.textAdditionalInformationCheckout.isDisplayed());
        Assert.assertTrue(checkoutPage.textYourOrderCheckout.isDisplayed());
        Assert.assertTrue(checkoutPage.textTotalCheckout.isDisplayed());
        //11) Now user can fill his details in billing details form and can opt any payment in the payment gateway like Direct bank transfer,cheque,cash or paypal.
        //12) Now click on Place Order button to complete process
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
        checkoutPage.textBoxAdditionalCheckout.sendKeys(Faker.instance().lorem().paragraph(),Keys.TAB,Keys.TAB,Keys.ENTER);
        //13) On clicking place order button user completes his process where the page navigates to Order confirmation page with order details,bank details,customer details and billing details.
        Assert.assertTrue(checkoutPage.textOrderDetailsCheckout.isDisplayed());
        Assert.assertTrue(checkoutPage.textOurBankDetailsCheckout.isDisplayed());
        Driver.closeDriver();
    }
}
