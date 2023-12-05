package ua.hillel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MainPage {
    public final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openMenu() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
    }

    public void logout() {
        By logoutElementLocator = By.id("logout_sidebar_link");
        driver.findElement(logoutElementLocator).click();
    }

    public void purchaseTheMostExpensive() {
        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
    }

    public void openCart() {
        WebElement openCart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        openCart.click();
    }
}
