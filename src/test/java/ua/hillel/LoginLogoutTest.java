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
import java.util.Set;

public class LoginLogoutTest {
    @Test
    public void loginAndLogout() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1440, 1100));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.get("https://www.saucedemo.com/");
        Wait<WebDriver> driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String initialUrl = driver.getCurrentUrl();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        By linkElementLocator = By.xpath("//a[@href='https://www.linkedin.com/company/sauce-labs/']");
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(linkElementLocator)).click();
        Set<String> windowHandles = driver.getWindowHandles();
        String linkedinWindowHandle = (String) windowHandles.toArray()[1];
        driver.switchTo().window(linkedinWindowHandle);
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("LinkedIn"), "Page title doesn't contain LinkedIn");
        driver.close();
        String mainWindowHandle = (String) windowHandles.toArray()[0];
        driver.switchTo().window(mainWindowHandle);
        driver.findElement(By.id("react-burger-menu-btn")).click();
        By logoutElementLocator = By.id("logout_sidebar_link");
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(logoutElementLocator)).click();
        Assert.assertTrue(driver.getCurrentUrl().contains(initialUrl), "Logout didn't happen");
        driver.quit();
    }
}
