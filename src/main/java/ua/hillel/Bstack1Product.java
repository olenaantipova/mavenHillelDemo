package ua.hillel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Bstack1Product extends BaseTest {
    @Test
    public void addToCartAndRemove() throws InterruptedException {
        driver.get("https://www.bstackdemo.com/");
        WebElement addToCartButton = (WebElement) driver.findElement(By.xpath("(//*[@class='shelf-item__buy-btn'])[4]"));
        addToCartButton.click();
        Thread.sleep(2000);
        WebElement cartClean = (WebElement) driver.findElement(By.xpath("//div[@class='shelf-item__del']"));
        cartClean.click();
        WebElement continueShopping = (WebElement) driver.findElement(By.xpath("//p[@class='shelf-empty']"));
        continueShopping.click();
    }
}