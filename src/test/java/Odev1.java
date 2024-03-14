package org.Ders20_Odev.Test;

import org.Ders20_Odev.drivers.Driver;
import org.Ders20_Odev.drivers.utils.PropertyManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class Odev1 {
    public static WebDriver driver;
    Driver webDriver = new Driver();
    PropertyManager propertyManager = new PropertyManager();


    @BeforeSuite
    public void CssOdev1() throws MalformedURLException {
        driver = webDriver.initializeDriver();
    }

    // Adrese gidiş
    @Test(priority = 1)
    public void sayfayaGit() {
        driver.get(propertyManager.getProperty("APP_URL"));
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "DEMOQA");
    }

    // Buttons Tıkla
    @Test(priority = 2)
    public void ButtonsClick() throws ClassNotFoundException {
        WebElement Buttons = driver.findElement(By.cssSelector("#item-4"));
        Buttons.click();
        WebElement textButtons = driver.findElement(By.cssSelector(".text-center"));
        String control = textButtons.getText();
        Assert.assertEquals(control, "Buttons");
    }

    //Click Me Düğmesine Tıkla --> Click Me düğmesi CSS selector ile seçilemedi.
    @Test(priority = 3)
    public void clickMeClick() {
        WebElement clickMe = driver.findElement(By.cssSelector(".col-md-6 div:nth-of-type(3) > .btn"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", clickMe);
    }
    
    @AfterSuite
    public void close() {
        webDriver.quitDriver();
    }
}