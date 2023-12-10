package ua.hillel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MainPage {
    public final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public void openLinkedinPage() {
        By linkElementLocator = By.xpath("//a[@href='https://www.linkedin.com/company/sauce-labs/']");
        WebElement linkedinLink = driver.findElement(linkElementLocator);
        linkedinLink.click();
    }

    public void openMenu() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
    }

    public void logout() {
        driver.findElement(By.id("logout_sidebar_link")).click();
    }

    public void purchaseTheMostExpensive() {
        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
    }

    public void openCart() {
        WebElement openCart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        openCart.click();
    }
}
