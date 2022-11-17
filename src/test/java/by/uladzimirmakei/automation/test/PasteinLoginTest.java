package by.uladzimirmakei.automation.test;

import by.uladzimirmakei.automation.model.User;
import by.uladzimirmakei.automation.pageobject.HomePagePF;
import by.uladzimirmakei.automation.service.UserCreator;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class PasteinLoginTest extends BaseTest {

    @Test
    public void loginPasteinTest() {
        User newUser = UserCreator.withCredentialFromProperty();
        boolean isChangePasswordFieldDisplayed = new HomePagePF(driver)
                .openPage()
                .navigateToLoginPage()
                .login(newUser)
                .isChangePasswordFieldDisplayed();
        Assertions.assertThat(isChangePasswordFieldDisplayed).isFalse();
    }
}
