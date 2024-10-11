package advanced_locators;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class XpathDemo {

    @Test
    public void absoluteXPathTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://demoqa.com/webtables");

        WebElement addNewRecordButton = driver.findElement(By.className("/html/body/div[2]/div//div/div/div[2]/div[2]/form/div[5]/div/button")); // 1 вариант

    }

    @Test
    public void relativeXPathTest() throws InterruptedException { // подходы поиска элементов в Web сайта
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://demoqa.com/webtables");

        WebElement addNewRecordButton = driver.findElement(By.className("//button[@id='submit']"));                             // 2 вариант
        WebElement addNewRecordButton2 = driver.findElement(By.className("//button[@type='button' and text()='Submit']"));      // 3 вариант
        WebElement addNewRecordButton3 = driver.findElement(By.className("//input[@placeholder='Full name]"));                  // 3 вариант
        WebElement addNewRecordButton4 = driver.findElement(By.className("//input[@placeholder='Full name and @type='text' or @id='User Name']?")); // 4
        WebElement addNewRecordButtonAllOfWeb = driver.findElement(By.className("//*[@placeholder='Full Name']?"));                                 // 5
        WebElement addNewRecordButtonAllOfWeb2 = driver.findElement(By.className("//div[@id='output']/div/p[@id='currentAddress']"));               // 6
        WebElement addNewRecord3 = driver.findElement(By.className("//h1[text()='Text Box']"));               // 6
        WebElement addNewRecord4 = driver.findElement(By.className("//h3/normalize-space()='Фаиза / Faiza']")); // удаляет начальны и кон. пробелы
        WebElement addNewRecord5 = driver.findElement(By.className("//div[@id='brandsRefinements']/ul[1]/span/span[position()=7]")); // поиск по позициям
        WebElement addNewRecord6 = driver.findElement(By.className("//div[@id='brandsRefinements']/ul/span/span/li/span/a/span")); // поиск по позициям

    }

    @Test
    public void amazonXPathTest() throws InterruptedException {
        // Установка драйвера Chrome
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Открываем сайт с календарём
        driver.get("https://demoqa.com/date-picker");

        // Открываем календарь, нажав на поле
        WebElement dateInput = driver.findElement(By.id("datePickerMonthYearInput"));
        dateInput.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        for (int i = 1; i <= 31; i++) { // Перебираем числа от 1 до 31
            try {
                // Открываем календарь заново для каждой итерации
                dateInput.click();
                Thread.sleep(500); // Небольшая пауза для стабильности
                // Ищем все дни в календаре
                List<WebElement> days = driver.findElements(By.xpath("//div[contains(@aria-label, 'October') and contains(@aria-label, '2024')]"));

                boolean dayFound = false; // Флаг для отслеживания, был ли найден день
                for (WebElement day : days) {
                    if (day.getText().equals(String.valueOf(i))) {
                        // Кликаем на нужный день
                        day.click();
                        System.out.println("Selected date: " + day.getAttribute("aria-label"));  // Выводим дату
                        dayFound = true; // Устанавливаем флаг, что день найден
                        break; // Выходим из внутреннего цикла
                    }
                }
                // Если день не был найден, выводим сообщение
                if (!dayFound) {
                    System.out.println("Day " + i + " not found in the calendar.");
                }
                Thread.sleep(1000);  // Небольшая пауза между кликами
            } catch (StaleElementReferenceException e) {
                System.out.println("Element became stale, retrying... {}");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("No more days available.");
                break;
            }
        }
        // Закрытие браузера
        driver.quit();
    }
}


//*[@placeholder='Full Name']
        //div[@id='output']/div/p[@id='currentAddress']
        //p[@id='currentAddress']/..
        //h1[text()= 'Text Box']
        //h1[contains (text(), 'Text')]
        //h3[contains(text(), 'Фаиза / Faiza')]
        //h3 [normalize-space ()='Фаиза / Faiza']
        //span[starts-with(text() , 'Перед')]
        //input[starts-with(@id, 'userE')]
        //div[@id='brandsRefinements']/ul[1]/span/span[position ()=3]
        //div[@id='brandsRefinements']/ul[1]/span/span[position ()=4]
        //div[@id='brandsRefinements']/ul[1]/span/span[last0)]  1/999.99
        //span[round (text)) = 999] ---> 1000]
        //span［floor（text（）='999］ ---> 999
        //input[starts-with(@id, 'user') and not(@type='text!) ]|


