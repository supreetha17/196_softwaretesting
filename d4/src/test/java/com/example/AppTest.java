package com.example;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() throws MalformedURLException {
        // assertTrue( true );
        WebDriver driver;
        ChromeOptions co = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://localhost:8080/"), co);
        driver.get("https://www.shoppersstop.com/");
    }
}