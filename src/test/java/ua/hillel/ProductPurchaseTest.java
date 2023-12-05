package ua.hillel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProductPurchaseTest {
    @Test
    public void productPurchase() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1440, 1100));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.get("https://www.saucedemo.com/");
        Wait<WebDriver> driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        By idElementLocator = (By.id("login-button"));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(idElementLocator)).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
        WebElement openCart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        openCart.click();
        WebElement checkout = driver.findElement(By.id("checkout"));
        checkout.click();
        driver.findElement(By.id("first-name")).sendKeys("Olena");
        driver.findElement(By.id("last-name")).sendKeys("Antipova");
        driver.findElement(By.id("postal-code")).sendKeys("02068");
        WebElement proceedCheckout = driver.findElement(By.id("continue"));
        proceedCheckout.click();
        WebElement productName = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
        Assert.assertTrue(productName.isDisplayed(), "Sauce Labs Fleece Jacket");
        WebElement productPrice = driver.findElement(By.cssSelector(".inventory_item_price"));
        Assert.assertEquals(productPrice.getText(), "$49.99");
        WebElement totalPriceWithTax = driver.findElement(By.xpath("//div[@class='summary_info_label summary_total_label']"));
        Assert.assertEquals(totalPriceWithTax.getText(), "Total: $53.99");
        WebElement finishCheckout = driver.findElement(By.id("finish"));
        finishCheckout.click();
        driver.quit();
    }
}