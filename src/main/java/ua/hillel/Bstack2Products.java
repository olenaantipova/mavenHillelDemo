package ua.hillel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Bstack2Products extends BaseTest {

    @Test
    public void addToCart() throws InterruptedException {
        driver.get("https://www.bstackdemo.com/");
        WebElement addToCartProduct1 = driver.findElement(By.xpath("(//*[@class='shelf-item__buy-btn'])[1]"));
        WebElement addToCartProduct2 = driver.findElement(By.xpath("(//*[@class='shelf-item__buy-btn'])[10]"));
        addToCartProduct1.click();
        addToCartProduct2.click();
        WebElement product1 = driver.findElement(By.xpath("//div[@class='shelf-item__details']/p[text()='iPhone 12']"));
        WebElement product2 = driver.findElement(By.xpath("//div[@class='shelf-item__details']/p[text()='Galaxy S20']"));
        Assert.assertTrue(product1.isDisplayed(), "Product 1 is not displayed");
        Assert.assertTrue(product2.isDisplayed(), "Product 2 is not displayed");
        WebElement cartQuantity = driver.findElement(By.xpath("//*[@class='bag__quantity']"));
        Assert.assertTrue(cartQuantity.isDisplayed(), "2");
        WebElement totalPrice = driver.findElement(By.xpath("//*[@class='sub-price__val']"));
        Assert.assertEquals("$ 1798.00", "$ 1798.00");
        WebElement checkoutButton = driver.findElement(By.xpath("//*[@class='buy-btn']"));
        checkoutButton.click();
        Thread.sleep(2000);
    }
}