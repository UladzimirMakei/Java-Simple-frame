package by.uladzimirmakei.automation.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePagePF extends BasePage {
    private static final String PASTEIN_HOME_PAGE =
            "https://pastein.ru/";
    @FindBy(xpath = "//div[@class='collapse navbar-collapse']" +
            "/descendant::*[contains(text(), 'Новый текст')]")
    private WebElement textInputPageButton;

    @FindBy(xpath = "//div[@class='collapse navbar-collapse']" +
            "/descendant::*[@class='dropdown-toggle']")
    private WebElement guestButton;

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement enterButton;


    public HomePagePF(WebDriver driver) {
        super(driver);
    }

    public HomePagePF openPage() {
        driver.get(PASTEIN_HOME_PAGE);
        logger.info("Home page is opened {}", PASTEIN_HOME_PAGE);
        return this;
    }

    public InputNewTextPagePF navigateToNewTextPage() {
        textInputPageButton.click();
        return new InputNewTextPagePF(driver);
    }

    public LoginPagePF navigateToLoginPage() {
        guestButton.click();
        enterButton.click();
        return new LoginPagePF(driver);
    }
}
