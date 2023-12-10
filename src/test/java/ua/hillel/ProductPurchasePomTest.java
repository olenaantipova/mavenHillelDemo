package ua.hillel;

import org.testng.annotations.Test;
import ua.hillel.pages.CartPage;
import ua.hillel.pages.LoginPage;
import ua.hillel.pages.MainPage;

public class ProductPurchasePomTest extends BaseTest {
    @Test
    public void productPurchase() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser("standard_user", "secret_sauce");

        MainPage mainPage = new MainPage(driver);
        mainPage.purchaseTheMostExpensive();
        mainPage.openCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.checkout();
        cartPage.enterUserData("Olena", "Antipova", "02068");
        cartPage.proceedToCheckout();
        cartPage.getProductPrice();
        cartPage.getTotalPriceWithTax();
        cartPage.finishCheckout();
    }
}
