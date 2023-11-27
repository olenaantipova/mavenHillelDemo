package ua.hillel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SauceDemo extends BaseTest {
    @Test
    public void login() throws InterruptedException {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(5000);
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(5000);
        WebElement linkedinLink = driver.findElement(By.xpath("//a[@href='https://www.linkedin.com/company/sauce-labs/']"));
        linkedinLink.click();
        Thread.sleep(5000);
        Set<String> windowHandles = driver.getWindowHandles();
        String linkedinWindowHandle = (String) windowHandles.toArray()[1];
        driver.switchTo().window(linkedinWindowHandle);
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("LinkedIn"), "Page title doesn't contain LinkedIn");
        driver.close();
        String mainWindowHandle = (String) windowHandles.toArray()[0];
        driver.switchTo().window(mainWindowHandle);
        driver.findElement(By.id("react-burger-menu-btn")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("logout_sidebar_link")).click();

    }
}
