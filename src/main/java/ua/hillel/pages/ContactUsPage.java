package ua.hillel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class ContactUsPage {
    public final WebDriver driver;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillForm(String name, String email) {
        WebElement nameField = driver.findElement(By.cssSelector("input[placeholder='Name']"));
        nameField.sendKeys(name);
        WebElement emailField = driver.findElement(By.cssSelector("input[placeholder='Email']"));
        emailField.sendKeys(email);
    }

    public void uploadFile() throws InterruptedException {

        URL url = getClass().getClassLoader().getResource("text.txt");
        if (url == null) throw new IllegalArgumentException("file not found");
        File file;
        try {
            file = new File(url.toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        WebElement input = driver.findElement(By.cssSelector("input[name='upload_file']"));
        input.sendKeys(file.getAbsolutePath());
        Thread.sleep(2000);
    }

    public void submitForm() {
        WebElement submitButton = driver.findElement(By.xpath("//input[@name='submit']"));
        submitButton.click();
    }

    public void checkSuccessMessage() {
        WebElement successMessage = driver.findElement(By.cssSelector(".status.alert.alert-success"));
        Assert.assertTrue(successMessage.isDisplayed(), "Success! Your details have been submitted successfully.");
    }

}
