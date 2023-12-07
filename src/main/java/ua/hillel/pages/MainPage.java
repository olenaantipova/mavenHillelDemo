package ua.hillel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    public final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openContactUsLink() {
        driver.findElement(By.cssSelector("a[href='/contact_us']")).click();
    }

}
