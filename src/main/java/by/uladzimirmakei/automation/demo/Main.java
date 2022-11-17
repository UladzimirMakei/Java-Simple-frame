package by.uladzimirmakei.automation.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        String css = "a[class = 'nav-link'][href='/downloads']";
        WebDriver driver = new ChromeDriver();
        driver.get("http:/seleniumhq.org");
        WebElement element = waitForElementLocatedBy(driver, css);
        element.click();
        driver.quit();
    }

    private static WebElement waitForElementLocatedBy(WebDriver driver, String css) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(css)));
    }
}