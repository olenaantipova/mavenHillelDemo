package ua.hillel;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.hillel.pages.LinkedinPage;
import ua.hillel.pages.LoginPage;
import ua.hillel.pages.MainPage;


public class LoginLogoutPomTest extends BaseTest {
    @Test
    public void loginAndLogout() {

        String initialUrl = driver.getCurrentUrl();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser("standard_user", "secret_sauce");

        MainPage mainPage = new MainPage(driver);
        mainPage.openLinkedinPage();
        mainPage.openMenu();
        mainPage.logout();

        LinkedinPage linkedinPage = new LinkedinPage(driver);
        linkedinPage.switchToLinkedinWindow();
        linkedinPage.switchToMainPage();

        Assert.assertTrue(driver.getCurrentUrl().contains(initialUrl), "Logout didn't happen");
    }
}