package ua.hillel.uiTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DynamicPageTest extends BaseTest {
    @Test
    public void AddABox() {
        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
        WebElement addButton = driver.findElement(By.id("adder"));
        if (addButton.isDisplayed() && addButton.isEnabled()) {
            addButton.click();
            System.out.println("Red square is displayed");
        } else {
            System.out.println("Test is failed, button is unavailable to click");
        }
    }

    @Test
    public void RevealANewInput() {
        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
        WebElement addButton = driver.findElement(By.id("reveal"));
        if (addButton.isDisplayed() && addButton.isEnabled()) {
            addButton.click();
            System.out.println("Field for input data is available, enter your data");
        } else {
            System.out.println("Test is failed, button is unavailable to click");
        }

    }

}

