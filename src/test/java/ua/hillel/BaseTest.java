package ua.hillel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    public static WebDriver driver;
    public final String DOWNLOAD_FOLDER_PATH = "target/downloads";

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", new File(DOWNLOAD_FOLDER_PATH).getAbsolutePath());
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        driver.manage().window().setSize(new Dimension(1440, 1100));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://the-internet.herokuapp.com/download");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
