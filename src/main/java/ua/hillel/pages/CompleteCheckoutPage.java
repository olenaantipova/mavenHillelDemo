package ua.hillel.pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class CompleteCheckoutPage {
    public void verifyPurchaseDetails() {
        $(".inventory_item_name").shouldBe(Condition.visible).shouldHave(Condition.text("Sauce Labs Fleece Jacket"));
        $(".inventory_item_price").shouldHave(Condition.text("$49.99"));
        $(".summary_info_label.summary_total_label").shouldHave(Condition.text("Total: $53.99"));
    }

    public void finishPurchase() {
        $("#finish").click();
    }
}
