package ua.hillel;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProductPurchaseTest {
    @Test
    public void productPurchase() {
        open("https://www.saucedemo.com/");

        $("#user-name").setValue("standard_user");
        $("#password").setValue("secret_sauce");
        $("#login-button").click();

        $("#add-to-cart-sauce-labs-fleece-jacket").click();
        $(".shopping_cart_link").click();

        $("#checkout").click();
        $("#first-name").setValue("Olena");
        $("#last-name").setValue("Antipova");
        $("#postal-code").setValue("02068");
        $("#continue").click();

        $(".inventory_item_name").shouldBe(Condition.visible).shouldHave(Condition.text("Sauce Labs Fleece Jacket"));
        $(".inventory_item_price").shouldHave(Condition.text("$49.99"));
        $(".summary_info_label.summary_total_label").shouldHave(Condition.text("Total: $53.99"));

        $("#finish").click();
        Selenide.closeWebDriver();
    }

}
