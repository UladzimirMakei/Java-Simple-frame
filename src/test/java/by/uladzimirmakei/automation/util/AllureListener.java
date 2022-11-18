package by.uladzimirmakei.automation.util;

import by.uladzimirmakei.automation.driver.DriverSingleton;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureListener implements ITestListener {

    @Override
    public void onTestSkipped(ITestResult result) {
        WebDriver driver = DriverSingleton.getDriver();
        saveScreenshotPNG(driver);
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        WebDriver driver = DriverSingleton.getDriver();
        saveScreenshotPNG(driver);
    }

    private byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}

