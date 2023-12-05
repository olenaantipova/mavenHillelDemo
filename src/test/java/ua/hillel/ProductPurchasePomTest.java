package ua.hillel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.hillel.pages.CartPage;
import ua.hillel.pages.LoginPage;
import ua.hillel.pages.MainPage;

public class ProductPurchasePomTest extends BaseTest {
    @Test
    public void productPurchase() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser("standard_user", "secret_sauce");

        MainPage mainPage = new MainPage(driver);
        mainPage.purchaseTheMostExpensive();
        mainPage.openCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.checkout();
        cartPage.enterUserData("Olena", "Antipova", "02068");
        cartPage.proceedToCheckout();
        WebElement productPrice = driver.findElement(By.cssSelector(".inventory_item_price"));
        Assert.assertEquals(productPrice.getText(), "$49.99");
        WebElement totalPriceWithTax = driver.findElement(By.xpath("//div[@class='summary_info_label summary_total_label']"));
        Assert.assertEquals(totalPriceWithTax.getText(), "Total: $53.99");
        cartPage.finishCheckout();
    }
}
