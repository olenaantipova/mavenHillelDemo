package ua.hillel.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Set;

public class LinkedinPage {
    public static WebDriver driver;

    public LinkedinPage(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToLinkedinWindow() {
        Set<String> windowHandles = driver.getWindowHandles();
        String linkedinWindowHandle = (String) windowHandles.toArray()[1];
        driver.switchTo().window(linkedinWindowHandle);
        String actualTitle = getPageTitle();
        Assert.assertTrue(actualTitle.contains("LinkedIn"), "Page title doesn't contain LinkedIn");
        driver.close();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void switchToMainPage() {
        Set<String> windowHandles = driver.getWindowHandles();
        String mainWindowHandle = (String) windowHandles.toArray()[0];
        driver.switchTo().window(mainWindowHandle);
    }
}
