package ua.hillel;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.hillel.pages.LinkedinPage;
import ua.hillel.pages.LoginPage;
import ua.hillel.pages.MainPage;


public class LoginLogoutPomTest extends BaseTest {
    @Test
    public void loginAndLogout() throws InterruptedException {

        String initialUrl = driver.getCurrentUrl();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser("standard_user", "secret_sauce");

        LinkedinPage linkedinPage = new LinkedinPage(driver);
        linkedinPage.openLinkedinPage();
        linkedinPage.switchToLinkedinWindow();
        String actualTitle = linkedinPage.getPageTitle();
        Assert.assertTrue(actualTitle.contains("LinkedIn"), "Page title doesn't contain LinkedIn");
        driver.close();
        linkedinPage.switchToMainPage();

        MainPage mainPage = new MainPage(driver);
        mainPage.openMenu();
        mainPage.logout();

        Assert.assertTrue(driver.getCurrentUrl().contains(initialUrl), "Logout didn't happen");
    }
}