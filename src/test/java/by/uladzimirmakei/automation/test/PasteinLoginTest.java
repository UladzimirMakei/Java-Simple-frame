package by.uladzimirmakei.automation.test;

import by.uladzimirmakei.automation.model.User;
import by.uladzimirmakei.automation.pageobject.HomePagePF;
import by.uladzimirmakei.automation.service.UserCreator;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class PasteinLoginTest extends BaseTest {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Login test without existing account")
    public void loginPasteinTest() {
        User newUser = UserCreator.withCredentialFromProperty();
        boolean isChangePasswordFieldDisplayed = new HomePagePF(driver)
                .openPage()
                .navigateToLoginPage()
                .login(newUser)
                .isChangePasswordFieldDisplayed();
        Assertions.assertThat(isChangePasswordFieldDisplayed)
                .as("Wrong password message is not displayed when non-existing user log in")
                .isFalse();
    }
}
