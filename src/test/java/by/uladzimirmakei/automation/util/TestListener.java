package by.uladzimirmakei.automation.util;

import by.uladzimirmakei.automation.driver.DriverSingleton;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {
    private static Logger logger = LogManager.getLogger();

    public void onTestFailure(ITestResult iTestResult) {
        saveScreenshot();
        WebDriver driver = DriverSingleton.getDriver();
        saveScreenshotPNG(driver);
        saveTextLog(iTestResult + " failed and screenshot is taken");
    }

    public void onTestSkipped(ITestResult iTestResult) {
        saveScreenshot();
        WebDriver driver = DriverSingleton.getDriver();
        saveScreenshotPNG(driver);
        saveTextLog(iTestResult + " failed and screenshot is taken");
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public String saveTextLog(String message) {
        return message;
    }


    public void saveScreenshot() {
        File screenCapture = ((TakesScreenshot) DriverSingleton
                .getDriver())
                .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture, new File(
                    ".//target/screenshots/"
                            + getCurrentTimeAsString() +
                            ".png"));
        } catch (IOException e) {
            logger.error("Failed to save screenshot: "
                    + e.getLocalizedMessage());
        }
    }

    private String getCurrentTimeAsString() {
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("uuuu-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }
}
