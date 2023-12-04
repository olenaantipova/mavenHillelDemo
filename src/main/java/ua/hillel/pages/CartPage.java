package ua.hillel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    public final WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkout() {
        WebElement checkout = driver.findElement(By.id("checkout"));
        checkout.click();
    }

    public void enterUserData(String firstName, String lastName, String postalCode) {
        driver.findElement(By.id("first-name")).sendKeys(firstName);
        driver.findElement(By.id("last-name")).sendKeys(lastName);
        driver.findElement(By.id("postal-code")).sendKeys(postalCode);
    }

    public void proceedToCheckout() {
        WebElement proceedCheckout = driver.findElement(By.id("continue"));
        proceedCheckout.click();
    }

    public void finishCheckout() {
        WebElement finishCheckout = driver.findElement(By.id("finish"));
        finishCheckout.click();
    }
}
