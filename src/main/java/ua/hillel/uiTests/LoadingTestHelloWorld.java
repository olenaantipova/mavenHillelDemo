package ua.hillel.uiTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoadingTestHelloWorld extends BaseTest {
    @Test
    public void test5sec() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.cssSelector("#start button")).click();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement helloWorldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
    }

    @Test
    public void test10sec() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        driver.findElement(By.cssSelector("#start button")).click();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement helloWorldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
    }

}

