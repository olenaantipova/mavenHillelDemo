package ua.hillel.pages;

import static com.codeborne.selenide.Selenide.$;

public class ItemsPage {
    public void addToCart(String product) {
        $("#add-to-cart-sauce-labs-fleece-jacket").click();
    }

    public void proceedWithShoppingCart() {
        $(".shopping_cart_link").click();
    }
}
