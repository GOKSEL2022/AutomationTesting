package comautomationtesting.pages;

import comautomationtesting.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    public ProductPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//h1[@class='product_title entry-title']")
    public WebElement textSeleniumRubyProduct;

    @FindBy(xpath = "//div[@class='images']")
    public WebElement imagesSeleniumRubyProduct;

    @FindBy(xpath = "//button[@class='single_add_to_cart_button button alt']")
    public WebElement addtobasketButtonProduct;

    @FindBy(xpath = "//a[@class='button wc-forward']")
    public WebElement viewbasketButtonProduct;

    @FindBy(xpath = "//*[.='Reviews (0)']")
    public WebElement reviewsButtonProduct;

    @FindBy(xpath = "//*[.='Description']")
    public WebElement descriptionButtonProduct;

    @FindBy(xpath = "//*[.='Product Description']")
    public WebElement textProductDescriptionProduct;

    @FindBy(xpath = "//*[@class='woocommerce-Price-amount amount']")
    public WebElement text500$$Product;

    @FindBy(xpath = "//*[@inputmode='numeric']")
    public WebElement sendKeysAddToBasketProduct;

    @FindBy(xpath = "//div[@class='woocommerce-message']")
    public WebElement textAddedToYourBasket;

    @FindBy(xpath = "//i[@class='wpmenucart-icon-shopping-cart-0']")
    public WebElement itemsBasketMenu;

    @FindBy(xpath = "//*[@class='price']")
    public WebElement textPriceSaleProduct;




}
