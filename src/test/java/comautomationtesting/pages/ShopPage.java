package comautomationtesting.pages;

import comautomationtesting.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopPage {
    public ShopPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//*[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]")
    public WebElement price500FilterShop;

    @FindBy(xpath = "//span[@style='left: 85.7143%;']")
    public WebElement price450FilterShop;

    @FindBy(xpath = "//*[@class='button']")
    public WebElement filterButtonShop;

    @FindBy(xpath = "//*[@class='price']")
    public WebElement price_150_450_Shop;

    @FindBy(xpath = "//*[.='Android']")
    public WebElement linkAndroidShop;

    @FindBy(xpath = "//*[@id='content']")
    public WebElement androidProductImageShop;

    @FindBy(xpath = "//*[@name='orderby']")
    public WebElement defaultSortingDropDownShop;

    @FindBy(xpath = "//*[@data-product_id='169']")
    public WebElement addToBasketButtonAndroidQickStartShop;

    @FindBy(xpath = "//*[@class='added_to_cart wc-forward']")
    public WebElement vievBasketButtonAndroidQickStartShop;

    @FindBy(xpath = "//*[.='Android Quick Start Guide']")
    public WebElement androidQickStartQideShop;

    @FindBy(xpath = "(//span[@class='onsale'])[1]")
    public WebElement saleButtonShop;
}
