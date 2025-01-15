package com.test.incubyte.pages;

import com.test.incubyte.utils.WebDriverManagerUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;


    private final By createAnAccountLink = By.xpath("//header//a[text()=\"Create an Account\"]");

    public HomePage() {
        this.driver = WebDriverManagerUtility.getDriver();
    }

    public void clickCreateAccountLink() {
        driver.findElement(createAnAccountLink).click();
    }

}
