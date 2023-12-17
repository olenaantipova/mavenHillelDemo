package ua.hillel.pages;

import static com.codeborne.selenide.Selenide.$;

public class CartPage {
    public void checkout() {
        $("#checkout").click();
    }

    public void enterUserData(String firstName, String lastName, String postalCode) {
        $("#first-name").setValue(firstName);
        $("#last-name").setValue(lastName);
        $("#postal-code").setValue(postalCode);
        $("#continue").click();
    }
}
