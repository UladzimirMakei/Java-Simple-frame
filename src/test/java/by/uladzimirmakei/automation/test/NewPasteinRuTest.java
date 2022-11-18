package by.uladzimirmakei.automation.test;

import by.uladzimirmakei.automation.pageobject.HomePagePF;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class NewPasteinRuTest extends BaseTest {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Text type test to verify input text is saved correctly")
    public void testTextInput() {
        String inputText = "Hello selenium";
        String resultBoxText = new HomePagePF(driver)
                .openPage()
                .navigateToNewTextPage()
                .enterTextInTextArea(inputText)
                .clickDeleteAfterOneViewCheckBox()
                .chooseTextStyle()
                .pressSendButtonWithEnteredData()
                .getResultPageText();
        Assertions.assertThat(resultBoxText).as("input text is not equal to result")
                .isEqualTo(inputText);
    }
}
