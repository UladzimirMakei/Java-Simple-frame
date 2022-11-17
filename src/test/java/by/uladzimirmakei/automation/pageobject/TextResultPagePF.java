package by.uladzimirmakei.automation.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TextResultPagePF extends BasePage {
    @FindBy(xpath = "//div[@class = 'code-toolbar']/descendant::code")
    private WebElement resultText;

    @FindBy(xpath = "//div[@class = 'toolbar']/descendant::span")
    private WebElement resultTextCheckStyle;

    public TextResultPagePF(WebDriver driver) {
        super(driver);
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOf(resultText));
    }

    public String getResultPageText() {
        return resultText.getText();
    }
}
