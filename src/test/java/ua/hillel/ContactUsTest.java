package ua.hillel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.hillel.pages.ContactUsPage;
import ua.hillel.pages.MainPage;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ContactUsTest extends BaseTest {
    @Test
    public void checkContactUsForm()  {

        Properties userData = new Properties();
        try {
            userData.load(new FileReader("src/test/resources/userdata.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        MainPage mainPage = new MainPage(driver);
        mainPage.openContactUsLink();

        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.fillForm(userData.getProperty("name"), userData.getProperty("email"));
        contactUsPage.uploadFile("text.txt");
        contactUsPage.submitForm();
        contactUsPage.skipAlert();

        WebElement successMessage = driver.findElement(By.cssSelector(".status.alert.alert-success"));
        Assert.assertTrue(successMessage.isDisplayed(), "Success! Your details have been submitted successfully.");

    }
}
