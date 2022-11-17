package by.uladzimirmakei.automation.pageobject;

import by.uladzimirmakei.automation.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPagePF extends BasePage {

    @FindBy(xpath = "//input[@id='loginform-email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='loginform-password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonEnter;
    private By changePasswordField = By
            .xpath("//div[@class='form-group field-loginform-password required has-error']" +
                    "/child::*[@class='help-block help-block-error']");

    public LoginPagePF(WebDriver driver) {
        super(driver);
    }

    public LoginPagePF login(User user) {
        emailField.sendKeys(user.getName());
        passwordField.sendKeys(user.getPassword());
        buttonEnter.click();
        return new LoginPagePF(driver);
    }

    public boolean isChangePasswordFieldDisplayed() {
        WebElement wrongPasswordText = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(driver.findElement(changePasswordField)));
        return wrongPasswordText.isDisplayed();
    }
}
