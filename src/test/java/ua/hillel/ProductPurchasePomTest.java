package ua.hillel;

import org.testng.annotations.Test;
import ua.hillel.pages.CartPage;
import ua.hillel.pages.CompleteCheckoutPage;
import ua.hillel.pages.ItemsPage;
import ua.hillel.pages.LoginPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class ProductPurchasePomTest {
    @Test
    public void productPurchase() {
        open("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage();
        loginPage.login("standard_user", "secret_sauce");

        ItemsPage itemsPage = new ItemsPage();
        itemsPage.addToCart("add-to-cart-sauce-labs-fleece-jacket");
        itemsPage.proceedWithShoppingCart();

        CartPage cartPage = new CartPage();
        cartPage.checkout();
        cartPage.enterUserData("Olena", "Antipova", "02068");

        CompleteCheckoutPage completeCheckoutPage = new CompleteCheckoutPage();
        completeCheckoutPage.verifyPurchaseDetails();
        completeCheckoutPage.finishPurchase();

        closeWebDriver();
    }


}

