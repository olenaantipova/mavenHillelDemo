package ua.hillel.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.hillel.pages.CartPage;
import ua.hillel.pages.LoginPage;
import ua.hillel.pages.MainPage;

import java.time.Duration;

public class ProductPurchasePomTest {
    @Test
    public void productPurchase() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1440, 1100));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.get("https://www.saucedemo.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser("standard_user", "secret_sauce");
        Thread.sleep(2000);

        MainPage mainPage = new MainPage(driver);
        mainPage.purchaseTheMostExpensive();
        mainPage.openCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.checkout();
        cartPage.enterUserData("Olena", "Antipova", "02068");
        cartPage.proceedToCheckout();
        WebElement productPrice = driver.findElement(By.cssSelector(".inventory_item_price"));
        Assert.assertEquals(productPrice.getText(), "$49.99");
        WebElement totalPriceWithTax = driver.findElement(By.xpath("//div[@class='summary_info_label summary_total_label']"));
        Assert.assertEquals(totalPriceWithTax.getText(), "Total: $53.99");
        cartPage.finishCheckout();
        driver.quit();
    }
}
