package demoqa.helper;

import demoqa.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;


public class WebElementActions {

    Actions actions = new Actions(DriverManager.getDriver());

                                                            // Тут все кастомные методы для управления браузером
    public WebElementActions click(WebElement element) {
        waitElementToBeVisible(element);
        waitElementToBeClickable(element);
        element.click();
        return this;
    }

    public WebElementActions input(WebElement element, String txt) {
        waitElementToBeVisible(element);
        element.sendKeys(txt);
        return this;
    }

    public WebElementActions navigateToElement(WebElement element, WebElement male) {
        actions.moveToElement(element).build().perform();
        return this;
    }

    public WebElementActions scrollToElement(WebElement element) {
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        return this;
    }
    public WebElementActions scrollAndClearElements(WebElement element) {
        // Прокручиваем к элементу, чтобы он был видим на экране
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        // Очищаем поле
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].value = '';", element);
        return this;
    }

    public WebElementActions waitElementToBeVisible(WebElement element) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOf(element));
        return this;
    }

    public WebElementActions waitElementToBeClickable(WebElement element) {   // время ожидания поиска элемента 15 секунд
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(15)) // после если не находит, выдает ошибку NoSuchElementException
                .until(ExpectedConditions.elementToBeClickable(element));
        return this;
    }

    public String getTextFromElement(WebElement element) {
        waitElementToBeVisible(element);
        return element.getText();
    }

    public WebElementActions doubleClick(WebElement element) {
        waitElementToBeClickable(element);
        actions.doubleClick(element).build().perform();
        return this;
    }

    public WebElementActions rightClick(WebElement element) {
        waitElementToBeClickable(element);
        actions.contextClick(element).build().perform();
        return this;
    }

    public boolean isElementVisible(WebElement element) {
        // element.isDisplayed() — этот метод проверяет, отображается ли элемент на странице. Если элемент виден, метод вернет true.
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) { // Если элемент не виден, будет выброшено исключение
            return false;
        }
    }

    public WebElementActions jsClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor)DriverManager.getDriver();
        executor.executeScript("arguments[0].click();", element);
        return this;
    }

    public WebElementActions highLights(WebElement element) {
        JavascriptExecutor executor =(JavascriptExecutor)DriverManager.getDriver();
        executor.executeScript("arguments[0].stile.border='3px solid red", element);
        return this;
    }
}
