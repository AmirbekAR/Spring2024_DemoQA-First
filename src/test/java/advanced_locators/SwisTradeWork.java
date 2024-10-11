package advanced_locators;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class SwisTradeWork {

    @Test
    public void swisTradeTest1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://swis.trade.kg/");

        // Ввод имени пользователя
        WebElement userNameInput = driver.findElement(By.name("userName"));
        userNameInput.sendKeys("ex_amarynbaev");

        // Ввод пароля
        WebElement userPasswordInput = driver.findElement(By.name("password"));
        userPasswordInput.sendKeys("330033");

        // Клик на кнопку входа
        WebElement enter = driver.findElement(By.xpath("//input[@class='logging_button']"));
        enter.click();

        // Ввод ИНН для поиска
        WebElement clickFindInn = driver.findElement(By.xpath("//input[@value='Поиск УВЭД']"));
        clickFindInn.sendKeys("02911201010119");
        clickFindInn.sendKeys(Keys.ENTER);

        // Ожидание элемента для клика
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement clickSearchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='traderSearchInput']")));
        clickSearchButton.click();

        // Ожидание элемента в таблице
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//td[@class='requestForPermitQueueCell' and contains(text(), 'Общество с ограниченной ответственностью')]")
        ));
        element.click();

        WebElement elementEnter = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='menu-subitem' and contains(text(), 'Подать заявление')]")));
        elementEnter.click();

        WebElement fifthCheckbox = driver.findElement(By.xpath("(//ins[@class='iCheck-helper'])[9]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fifthCheckbox);
        fifthCheckbox.click();


        WebElement fillOutTheForm = driver.findElement(By.xpath("//input[@type='submit' and @value='Заполнить форму']"));
        fillOutTheForm.click();

        WebElement inputWord = driver.findElement(By.xpath("//input[@type='text' and @name='RU.Document.AccompanyingDocuments']"));
        inputWord.sendKeys("Инвойс № OW20240615А от 14.06.2024г. ГТД № 41715004/160924/0012062 от 18.09.2024г.");
        // Закрытие браузера
//            driver.close();
    }
}
