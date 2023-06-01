package com.example.base_repo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

class ChromeWebDriverTest {
    @BeforeEach
    public void test() {
        System.setProperty("webdriver.chrome.driver", "lib/chromedriver");
    }

    @Test
    public void run() throws InterruptedException {
        WebDriverFactory driver = new ChromeWebDriver();
        WebDriver webDriver = driver.create();
        webDriver.get("http://info.cern.ch");
        TimeUnit.SECONDS.sleep(5);
        webDriver.quit();
    }

    @Test
    public void getByCSS() throws InterruptedException {
        WebDriverFactory driver = new ChromeWebDriver();
        WebDriver webDriver = driver.create();
        webDriver.get("http://info.cern.ch");

        WebElement elementsXPath = webDriver.findElement(By.xpath("/html/body/ul/li[1]/a"));
        TimeUnit.SECONDS.sleep(2);
        elementsXPath.click();
        elementsXPath.sendKeys();
        elementsXPath.sendKeys(Keys.ENTER);
        TimeUnit.SECONDS.sleep(5);
        webDriver.quit();
    }

    @Test
    public void getClick() throws InterruptedException {
        WebDriverFactory driver = new ChromeWebDriver();
        WebDriver webDriver = driver.create();
        webDriver.get("https://www.google.com/");

        WebElement elementsXPath = webDriver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));
        TimeUnit.SECONDS.sleep(2);
        elementsXPath.sendKeys("Test");
        TimeUnit.SECONDS.sleep(2);
        elementsXPath.sendKeys(Keys.ENTER);
        TimeUnit.SECONDS.sleep(5);
        webDriver.quit();
    }

}
