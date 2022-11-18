package by.uladzimirmakei.automation.util;

import org.testng.ITestListener;
import org.testng.ITestResult;

import static by.uladzimirmakei.automation.util.Screenshot.saveScreenshot;

public class TestListener implements ITestListener {


    public void onTestFailure(ITestResult iTestResult) {
        saveScreenshot();
    }

    public void onTestSkipped(ITestResult iTestResult) {
        saveScreenshot();
    }
}
