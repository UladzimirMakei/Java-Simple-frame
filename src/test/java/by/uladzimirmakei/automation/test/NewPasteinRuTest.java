package by.uladzimirmakei.automation.test;

import by.uladzimirmakei.automation.pageobject.HomePagePF;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class NewPasteinRuTest extends BaseTest {

    @Test
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
