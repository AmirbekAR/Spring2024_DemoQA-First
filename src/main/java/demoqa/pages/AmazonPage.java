package demoqa.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AmazonPage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(AmazonPage.class);
    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchInput;

    @FindBy(id = "nav-search-submit-button")
    public WebElement clickButtonSearch;

    @FindBy(css = "input[class=\"a-button-input\"][data-action-params$='{\"toasterType\":\"AIS_INGRESS\"}']")
    public WebElement dismiss;

    @FindBy(xpath = "//div[@id='brandsRefinements']/ul/span/span/li/span/a")
    public WebElement brandApple;

    @FindBy(xpath = "//li[@id='p_123/110955']//i[@class='a-icon a-icon-checkbox']")
    public WebElement appleCheckboxLabel;

    public void clickAppleCheckbox() {
        // Кликаем на label, чтобы активировать чекбокс
        appleCheckboxLabel.click();
    }

    @FindBy(xpath = "//span[contains(text(),'Apple')]")
    public WebElement searchApple;

    @FindBy(xpath = "(//div[@id='filters']/ul/span/span/li)[position() <= 6]")
    public WebElement searchApple2;


    @Step("Check some name Apple")
    public AmazonPage findApple(String expectedText) {
        try {
            if (searchApple.isDisplayed() && searchApple.getText().contains(expectedText)) {
                log.info("Найден элемент: " + expectedText);
                if (expectedText.contains("Apple Iphone")) {

                    log.info("Выбрано 5 Apple");
                }
            }
        } catch (StaleElementReferenceException e) {
            log.error("Элемент не найден", e);
        }
        return this;
    }
}
