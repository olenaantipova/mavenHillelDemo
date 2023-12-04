package ua.hillel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.Set;

public class LinkedinPage {
    public static WebDriver driver;

    public LinkedinPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openLinkedinPage() {
        By linkElementLocator = By.xpath("//a[@href='https://www.linkedin.com/company/sauce-labs/']");
        WebElement linkedinLink = driver.findElement(linkElementLocator);
        linkedinLink.click();
    }

    public void switchToLinkedinWindow() {
        Set<String> windowHandles = driver.getWindowHandles();
        String linkedinWindowHandle = (String) windowHandles.toArray()[1];
        driver.switchTo().window(linkedinWindowHandle);
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
