package comautomationtesting.tests;
import com.github.javafaker.Faker;
import comautomationtesting.pages.*;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import static comautomationtesting.utilities.ReusableMethods.clickWithJS;
import static comautomationtesting.utilities.ReusableMethods.scrollIntoViewJS;
public class TC42_Shop11_AddToBasketThroughItemLink {
    AllPages allPages=new AllPages();
    @Test
    public void AddToBasketThroughItemLink() throws InterruptedException {
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
        //9) Now click on Proceed to Check out button which navigates to payment gateway page.
        allPages.basketPage().proceedToCheckoutButtonBasket.click();
        //10) User can view Billing Details,Order Details,Additional details and Payment gateway details.
        assert allPages.checkoutPage().textBillingDetailsCheckout.isDisplayed();
        assert allPages.checkoutPage().textAdditionalInformationCheckout.isDisplayed();
        assert allPages.checkoutPage().textYourOrderCheckout.isDisplayed();
        assert allPages.checkoutPage().textTotalCheckout.isDisplayed();
        //11) Now user can fill his details in billing details form and can opt any payment in the payment gateway like Direct bank transfer,cheque,cash or paypal.
        //12) Now click on Place Order button to complete process
        allPages.checkoutPage().firstNameCheckout.sendKeys(Faker.instance().name().firstName());
        wait(1);
        allPages.checkoutPage().lastNameCheckout.sendKeys(Faker.instance().name().lastName());
        wait(1);
        allPages.checkoutPage().companyNameCheckout.sendKeys(Faker.instance().company().name());
        wait(1);
        allPages.checkoutPage().emailNameCheckout.sendKeys(Faker.instance().internet().emailAddress());
        wait(1);
        allPages.checkoutPage().phoneNameCheckout.sendKeys("0452-481-21-66", Keys.TAB,Keys.ARROW_UP,Keys.ARROW_DOWN,Keys.ENTER);
        wait(1);
        allPages.checkoutPage().address1Checkout.sendKeys(Faker.instance().address().streetAddress());
        wait(1);
        allPages.checkoutPage().address2Checkout.sendKeys(Faker.instance().address().fullAddress());
        wait(1);
        allPages.checkoutPage().townCityCheckout.sendKeys(Faker.instance().address().city(),Keys.TAB,Keys.ARROW_UP,Keys.ARROW_DOWN,Keys.ENTER);
        wait(1);
        allPages.checkoutPage().postcodeCheckout.sendKeys(Faker.instance().address().zipCode());
        wait(1);
        scrollIntoViewJS(allPages.checkoutPage().textBoxAdditionalCheckout);
        allPages.checkoutPage().textBoxAdditionalCheckout.sendKeys(Faker.instance().lorem().paragraph(),Keys.TAB,Keys.TAB,Keys.ENTER);
        //13) On clicking place order button user completes his process where the page navigates to Order confirmation page with order details,bank details,customer details and billing details.
        assert allPages.checkoutPage().textOrderDetailsCheckout.isDisplayed();
        assert allPages.checkoutPage().textOurBankDetailsCheckout.isDisplayed();
        Driver.closeDriver();
    }
}
