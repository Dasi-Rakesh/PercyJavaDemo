package org.percy;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.percy.selenium.Percy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

public class TestWebsite {
    private static WebDriver driver;
    private static Percy percy;
    private static String URL;

    @BeforeTest
    public void setup() throws IOException {
        Properties properties = new Properties();
        properties.load(TestWebsite.class.getClassLoader().getResourceAsStream("config.properties"));
        URL = properties.getProperty("url");
    }

    @Test
    public void verifyHomePage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        percy = new Percy(driver);
        driver.get(URL);
        String title = driver.getTitle();
        Assert.assertEquals(title, "Most Reliable App & Cross Browser Testing Platform | BrowserStack", "Title doesn't match");
        percy.snapshot("BrowserStack Home Page");
    }

    @Test
    public void verifyPricingPage() {
        driver.get(URL + "pricing");
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("BrowserStack Pricing"));
        percy.snapshot("BrowserStack Pricing Page");
    }

    @Test
    public void verifyIntegrationPage() {
        driver.get(URL + "integrations/automate");
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Integrations with Automate for Testing | BrowserStack"));
        percy.snapshot("BrowserStack Integration Page");
    }

    @Test
    public void verifyDocsPage() {
        driver.get(URL + "docs");
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Developer Documentation Home | BrowserStack Docs"));
        percy.snapshot("BrowserStack Docs Page");
        // Change Resolution:
        percy.snapshot("Resolution 1", Arrays.asList(375, 480, 720));
        // Change Resolution 2:
        percy.snapshot("Resolution 1", Arrays.asList(1280, 1440, 1920));
    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}