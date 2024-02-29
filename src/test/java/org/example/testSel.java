package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

public class testSel {
    public static WebDriver driver;

    @BeforeAll
    public static void setupDriver() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://www.amazon.com");
    }

    @AfterAll
    public static void closeDriver() {
        driver.quit();
    }

    @Test
    public void captureElement() throws IOException {
        WebElement logo = driver.findElement(By.xpath("//*[@id='nav-logo-sprites']"));
        File file = logo.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("logo.png"));
    }
}
