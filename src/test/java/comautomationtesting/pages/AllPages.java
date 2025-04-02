package comautomationtesting.pages;

public class AllPages {
    public AllPages() {
    }
    private BasketPage basketPage;
    private CheckoutPage checkoutPage;
    private HomePage homePage;
    private MyAccountPage myAccountPage;
    private ProductPage productPage;
    private ShopPage shopPage;
    public ShopPage shopPage() {
        if (shopPage == null) {
            shopPage = new ShopPage();
        }
        return shopPage;
    }
    public ProductPage productPage() {
        if (productPage == null) {
            productPage = new ProductPage();
        }
        return productPage;
    }

    public MyAccountPage myAccountPage() {
        if (myAccountPage == null) {
            myAccountPage = new MyAccountPage();
        }
        return myAccountPage;
    }

    public HomePage homePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }

    public CheckoutPage checkoutPage() {
        if (checkoutPage == null) {
            checkoutPage = new CheckoutPage();
        }
        return checkoutPage;
    }

    public BasketPage basketPage() {
        if (basketPage == null) {
            basketPage = new BasketPage();
        }
        return basketPage;
    }


}
