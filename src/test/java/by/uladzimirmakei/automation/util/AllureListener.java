package by.uladzimirmakei.automation.util;

import org.testng.ITestListener;
import org.testng.ITestResult;

import static by.uladzimirmakei.automation.util.Screenshot.saveScreenshot;

public class AllureListener implements ITestListener {

    @Override
    public void onTestSkipped(ITestResult result) {
        saveScreenshot();
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        saveScreenshot();
    }
}

