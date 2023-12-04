package ua.hillel.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.hillel.pages.LinkedinPage;
import ua.hillel.pages.LoginPage;
import ua.hillel.pages.MainPage;

import java.time.Duration;

public class LoginLogoutPomTest {
    @Test
    public void loginAndLogout() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1440, 1100));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.get("https://www.saucedemo.com/");

        Wait<WebDriver> driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String initialUrl = driver.getCurrentUrl();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser("standard_user", "secret_sauce");
        By linkElementLocator = By.xpath("//a[@href='https://www.linkedin.com/company/sauce-labs/']");
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(linkElementLocator));

        LinkedinPage linkedinPage = new LinkedinPage(driver);
        linkedinPage.openLinkedinPage();
        linkedinPage.switchToLinkedinWindow();
        String actualTitle = linkedinPage.getPageTitle();
        Assert.assertTrue(actualTitle.contains("LinkedIn"), "Page title doesn't contain LinkedIn");
        driver.close();

        driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);

        MainPage mainPage = new MainPage(driver);
        mainPage.openMenu();
        By logoutElementLocator = By.id("logout_sidebar_link");
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(logoutElementLocator));
        mainPage.logout();

        Assert.assertTrue(driver.getCurrentUrl().contains(initialUrl), "Logout didn't happen");
        driver.quit();
    }
}