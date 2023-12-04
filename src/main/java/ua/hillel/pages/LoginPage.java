package ua.hillel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    public final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUserName(String userName) {
        driver.findElement(By.id("user-name")).sendKeys(userName);
    }

    public void setPassword(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    public void login() {
        driver.findElement(By.id("login-button")).click();
    }

    public void loginUser(String userName, String password) {
        setUserName(userName);
        setPassword(password);
        login();
    }
}
