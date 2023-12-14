package ua.hillel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class CsvTest extends BaseTest {
    private final String filePath = "target/downloads/csv file.csv";

    @Test
    public void downloadFileAndCheckContent() throws IOException {
        driver.get("https://the-internet.herokuapp.com/download");
        String fileName = "csv file.csv";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement chromeDriverFile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(fileName)));
        chromeDriverFile.click();

        Assert.assertTrue(waitFileDownloaded(DOWNLOAD_FOLDER_PATH, fileName, 10));

        Assert.assertTrue(hasCorrectExtension(DOWNLOAD_FOLDER_PATH + "/" + fileName, ".csv"));

        List<String> rows = Files.readAllLines(Paths.get(filePath));
        List<String> headers = Arrays.asList(rows.get(0).split(","));
        List<String> expectedHeaders = Arrays.asList("Manufacturer Id","Period","Glass - Mixed","Aluminium","PET - Clear","PET - Colour","HDPE","Liquid Paper Board","Steel","Other Materials");
        Assert.assertEquals(headers, expectedHeaders, "CSV headers are wrong");

        String expectedRow1 = "QM20000003,M2022-11,10,20,30,40,5,6,7,8";

        Assert.assertTrue(rows.contains(expectedRow1));
    }

    public boolean hasCorrectExtension(String filePath, String extension) {
        File file = new File(filePath);
        String fileName = file.getName();
        return fileName.endsWith(extension);
    }
    public boolean waitFileDownloaded(String directory, String fileName, int timeoutInSec) {
        for (int i = 0; i < timeoutInSec; i++) {
            File file = new File(directory + "/" + fileName);
            if (file.exists() & file.length() > 0) return true;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

}
