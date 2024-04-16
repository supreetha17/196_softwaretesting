package com.example;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://economictimes.indiatimes.com/et-now/results/");
        driver.findElement(By.linkText("Mutual Funds")).click();
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,700)");
        Thread.sleep(3000);
        Select dropdown1 = new Select(driver.findElement(By.name("amc")));
        dropdown1.selectByVisibleText("Canara Robeco");
        Thread.sleep(3000);
        Select dropdown2 = new Select(driver.findElement(By.name("schemenm")));
        dropdown2.selectByVisibleText("Canara Robeco Bluechip Equity Direct-G");
        Thread.sleep(3000);
        driver.findElement(By.id("anchor3")).click();
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0,700)");
        String currentWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(currentWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        driver.findElement(By.xpath("//*[@id='installment_type']/li")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='installment_type']/li/ul/li[1]/span")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='installment_amt']/li")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='installment_amt']/li/ul/li[3]/span")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='installment_period']/li")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='installment_period']/li/ul/li[4]/span")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='mfNav']/div/ul/li[2]")).click();
        Thread.sleep(3000);
        WebElement table = driver.findElement(By.xpath("//*[@id='mfReturns']/div[2]/div[2]/ul/li[1]/table"));
        Thread.sleep(3000);
        WebElement firstrow = table
                .findElement(By.xpath("//*[@id='mfReturns']/div[2]/div[2]/ul/li[1]/table/tbody/tr[1]"));
        try {
            List<WebElement> cells = firstrow.findElements(By.tagName("td"));
            for (WebElement cell : cells) {
                System.out.print(cell.getText() + " ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Thread.sleep(5000);
        driver.quit();
    }

}
