package demoqa.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;

public class DropdownHelper {

    private WebDriver driver;
    private Select select;
    private WebDriverWait wait;

    public DropdownHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public DropdownHelper selectByText(WebElement webElement, String txt) {
        this.select = new Select(webElement);
        this.select.selectByVisibleText(txt);
        return this;
    }

    public DropdownHelper selectByIndex(WebElement webElement, int index) {
        this.select = new Select(webElement);
        this.select.selectByIndex(index);
        return this;
    }

    public DropdownHelper selectByValue(WebElement webElement, String txt) {
        this.select = new Select(webElement);
        this.select.selectByValue(txt);
        return this;
    }

    public List<String> getAllDropdownValues(WebElement webElement) {
        this.select = new Select(webElement);
        Select select = new Select(webElement);
        List<WebElement> elementList = select.getOptions();
        List<String> list = new LinkedList<>();
        for (WebElement element : elementList) {
            list.add(element.getText());
        }
        return list;
    }
}
