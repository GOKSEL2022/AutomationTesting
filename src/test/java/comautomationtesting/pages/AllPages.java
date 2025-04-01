package comautomationtesting.pages;

public class AllPages {
    public AllPages() {
    }
    private BasketPage basketPage;
    private CheckoutPage checkoutPage;

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
