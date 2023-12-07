package ua.hillel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import ua.hillel.pages.ContactUsPage;
import ua.hillel.pages.MainPage;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class ContactUsTest {
    @Test
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1440, 1100));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://automationexercise.com/");

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
        contactUsPage.uploadFile();
        contactUsPage.submitForm();
        driver.switchTo().alert().accept();

        contactUsPage.checkSuccessMessage();
        driver.quit();
    }
}
