package comautomationtesting.pages;

import comautomationtesting.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    public CheckoutPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id='place_order']")
    public WebElement placeOrderButtonCheckout;

    @FindBy(xpath = "//div[@class='woocommerce-billing-fields']")
    public WebElement textBillingDetailsCheckout;

    @FindBy(xpath = "//div[@class='woocommerce-shipping-fields']")
    public WebElement textAdditionalInformationCheckout;

    @FindBy(xpath = "//h3[@id='order_review_heading']")
    public WebElement textYourOrderCheckout;

    @FindBy(xpath = "//th[@class='product-total']")
    public WebElement textTotalCheckout;

    @FindBy(xpath = "//*[@id='billing_first_name']")
    public WebElement firstNameCheckout;

    @FindBy(xpath = "//*[@id='billing_last_name']")
    public WebElement lastNameCheckout;

    @FindBy(xpath = "//*[@name='billing_company']")
    public WebElement companyNameCheckout;

    @FindBy(xpath = "//*[@name='billing_email']")
    public WebElement emailNameCheckout;

    @FindBy(xpath = "//*[@name='billing_phone']")
    public WebElement phoneNameCheckout;

    @FindBy(xpath = "(//*[@class='select2-input'])[2]")
    public WebElement countryDropdown2Checkout;

    @FindBy(xpath = "//*[@name='billing_address_1']")
    public WebElement address1Checkout;

    @FindBy(xpath = "//*[@name='billing_address_2']")
    public WebElement address2Checkout;

    @FindBy(xpath = "//*[@name='billing_city']")
    public WebElement townCityCheckout;

    @FindBy(xpath = "(//*[@class='select2-input'])[2]")
    public WebElement stateCountyCheckout;

    @FindBy(xpath = "//*[@name='billing_postcode']")
    public WebElement postcodeCheckout;

    @FindBy(xpath = "//*[@name='order_comments']")
    public WebElement textBoxAdditionalCheckout;

    @FindBy(xpath = "//*[@class='showcoupon']")
    public WebElement haveACouponLinkCheckout;

    @FindBy(xpath = "//*[@class='wc-bacs-bank-details-heading']")
    public WebElement textOurBankDetailsCheckout;

    @FindBy(xpath = "//*[.='Order Details']")
    public WebElement textOrderDetailsCheckout;

    @FindBy(xpath = "(//*[@id='select2-drop-mask")
    public WebElement countryDropDown1Checkout;

    @FindBy(xpath = "//*[@class='cart-subtotal']")
    public WebElement subtoltalPriceAndTextCheckout;

    @FindBy(xpath = "tax-rate tax-rate-in-tax-1")
    public WebElement taxPriceAndTextCheckout;
}


