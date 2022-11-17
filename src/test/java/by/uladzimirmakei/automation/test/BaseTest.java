package by.uladzimirmakei.automation.test;

import by.uladzimirmakei.automation.driver.DriverSingleton;
import by.uladzimirmakei.automation.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void browserSetup() {
        driver = DriverSingleton.getDriver();
    }


    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        DriverSingleton.closeDriver();
    }
}
