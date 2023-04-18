package org.percy;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.percy.selenium.Percy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestWebsite {
    private static WebDriver driver;
    private static Percy percy;

    @Test
    public void exampleTest() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        percy = new Percy(driver);

        driver.get("https://www.browserstack.com/");
        String title = driver.getTitle();
        Assert.assertEquals(title, "Most Reliable App & Cross Browser Testing Platform | BrowserStack", "Title doesn't match");
        percy.snapshot("BrowserStack Home Page");
    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}