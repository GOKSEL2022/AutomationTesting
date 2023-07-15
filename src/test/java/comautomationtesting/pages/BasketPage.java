package comautomationtesting.pages;

import comautomationtesting.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasketPage {
    public BasketPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//h2[.='Basket Totals']")
    public WebElement textBasketTotalsBasket;

    @FindBy(xpath = "//td[@class='product-name']")
    public WebElement textSeleniumRubyBasket;

    @FindBy(xpath = "//*[@id='coupon_code']")
    public WebElement couponCodeBasket;

    @FindBy(xpath = "//*[@name='apply_coupon']")
    public WebElement applyCouponButtonBasket;

    @FindBy(xpath = "//*[@class='cart-discount coupon-krishnasakinala']")
    public WebElement couponKrishnasakinalaBasket;

    @FindBy(xpath = "//*[@CLASS='checkout-button button alt wc-forward']")
    public WebElement proceedToCheckoutButtonBasket;

    @FindBy(xpath = "(//*[@class='product-remove'])[2]")
    public WebElement removeSymbolBasket;

    @FindBy(xpath = "//*[@class='input-text qty text']")
    public WebElement textBoxQuantityBasket;

    @FindBy(xpath = "//input[@name='update_cart']")
    public WebElement updateBasketButtonBasket;

    @FindBy(xpath = "//div[@class='woocommerce-message']")
    public WebElement textBasketUpdateBasket;

    @FindBy(xpath = "//*[@class='order-total']")
    public WebElement totalPriceBasket;

    @FindBy(xpath = "//*[@step='1']")
    public WebElement upQuantityButonBasket;

    @FindBy(xpath = "//*[.='Subtotal']")
    public WebElement textSubtotalBasket;

    @FindBy(xpath = "//*[.='Total']")
    public WebElement textTotalBasket;

    @FindBy(xpath = "//*[@class='cart-subtotal']")
    public WebElement subtotalPriceBasket;

    @FindBy(xpath = "//*[@data-product_id='169']")
    public WebElement removeProductButtonBasket;
    @FindBy(xpath = "//*[@class='cart-empty']")
    public WebElement textEmptyBasket;



}
