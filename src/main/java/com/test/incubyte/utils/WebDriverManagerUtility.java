package com.test.incubyte.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerUtility {
    private static WebDriver driver;

    // Initializes WebDriver
    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    // Clean up
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
