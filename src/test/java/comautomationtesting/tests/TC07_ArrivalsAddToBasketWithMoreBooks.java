package comautomationtesting.tests;
import comautomationtesting.pages.AllPages;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import static comautomationtesting.utilities.ReusableMethods.clickWithJS;
public class TC07_ArrivalsAddToBasketWithMoreBooks {
    @Test
    public void ArrivalsAddToBasketWithMoreBooks() throws InterruptedException {
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
        //12) User can add a book by clicking on Add To Basket button which adds that book in to his Basket
        clickWithJS(allPages.productPage().viewbasketButtonProduct);
        Reporter.log("Kullanici sepete ekle butonuna tiklar");
        assert allPages.basketPage().textSeleniumRubyBasket.isDisplayed();
        Reporter.log("Kullanici secilen kitabin sepete eklendigini dogrular");
        Thread.sleep(2000);
        //13) Select more books than the books in stock.Ex if the stock has 20 books, try to add 21.
        Driver.getDriver().navigate().back();
        allPages.productPage().sendKeysAddToBasketProduct.clear();
        Thread.sleep(2000);
        allPages.productPage().sendKeysAddToBasketProduct.sendKeys("9999999999", Keys.ENTER);
        Reporter.log("Kullanici sayfaya istedigi kadar urun sayisi girebilir");
        //14) Click the add to basket button
        clickWithJS(allPages.productPage().addtobasketButtonProduct);
        //15) Now it throws an error prompt like you must enter a value between 1 and 20
        assert allPages.productPage().textAddedToYourBasket.isDisplayed();
        Reporter.log("Kullanici ekledigi urun sayisini gorebilir");
        Driver.closeDriver();
    }
}
