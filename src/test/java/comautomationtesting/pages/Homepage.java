package comautomationtesting.pages;

import comautomationtesting.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Homepage {

    public Homepage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (linkText = "Shop")
    public WebElement shopButton;

    //@FindBy (xpath = "//*[@id=\"themify_builder_content-22\"]/div[2]/div/div/div/div/div[2]")
   // public WebElement threeSliders;

    @FindBy(xpath = "//img[@class='n2-ss-slide-background-image n2-ss-slide-fill n2-ow']")
    public List<WebElement> threeSlidersHome;

    @FindBy(xpath = "//*[text()='Home']")
    public WebElement homeButton;

    //@FindBy(xpath = "//a[@class='woocommerce-LoopProduct-link']")
    //public List<WebElement> arriwals;

    @FindBy(xpath = "//ul[@class='products']")
    public List<WebElement> arriwals;

    @FindBy(xpath = "(//*[@class='woocommerce-LoopProduct-link'])[1]")
    public WebElement firstArrivals;

    //MyAccount-LoginPage
    //************************************************************************
    @FindBy(xpath = "//*[.='My Account']")
    public WebElement myAccountButtonHome;




}