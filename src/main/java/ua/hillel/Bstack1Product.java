package ua.hillel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Bstack1Product extends BaseTest {
    @Test
    public void addToCartAndRemove() throws InterruptedException {
        driver.get("https://www.bstackdemo.com/");
        WebElement addToCartButton = driver.findElement(By.xpath("(//*[@class='shelf-item__buy-btn'])[4]"));
        addToCartButton.click();
        Thread.sleep(2000);
        WebElement cartClean =  driver.findElement(By.className("shelf-item__del"));
        cartClean.click();
        WebElement continueShopping = driver.findElement(By.className("shelf-empty"));
        continueShopping.click();
    }
}