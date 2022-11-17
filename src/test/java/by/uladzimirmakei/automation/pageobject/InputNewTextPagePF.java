package by.uladzimirmakei.automation.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InputNewTextPagePF extends BasePage {

    @FindBy(xpath = "//textarea[@class = 'form-control']")
    private WebElement textArea;

    @FindBy(xpath = "//input[@id = 'one_time']")
    private WebElement oneTimeCheckBox;

    @FindBy(xpath = "//*[@class = 'btn btn-success']")
    private WebElement sendButton;

    @FindBy(xpath = "//select[@id ='highlighting']")
    private WebElement highlightingDropdown;

    @FindBy(xpath = "//option[@value ='bash']")
    private WebElement bashHighlight;


    public InputNewTextPagePF(WebDriver driver) {
        super(driver);
    }

    public InputNewTextPagePF enterTextInTextArea(String textInput) {
        textArea.sendKeys(textInput);
        return this;
    }

    public InputNewTextPagePF clickDeleteAfterOneViewCheckBox() {
        oneTimeCheckBox.click();
        return this;
    }

    public TextResultPagePF pressSendButtonWithEnteredData() {
        sendButton.click();
        return new TextResultPagePF(driver);
    }

    public InputNewTextPagePF chooseTextStyle() {
        highlightingDropdown.click();
        bashHighlight.click();
        return this;
    }
}
