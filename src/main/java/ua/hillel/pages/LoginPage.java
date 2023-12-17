package ua.hillel.pages;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    public void login(String username, String password) {
        $("#user-name").setValue("standard_user");
        $("#password").setValue("secret_sauce");
        $("#login-button").click();
    }
}
