package demoqa.drivers;

import demoqa.utils.ConfigReader;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class FireFoxWebDriver {

    public static WebDriver loadFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver");

        FirefoxOptions options = new FirefoxOptions();
        // Добавьте ваши опции
        if (Boolean.parseBoolean(ConfigReader.getValue("headless"))) {
            options.addArguments("--headless");
        }

        WebDriver driver = null;
        try {
            driver = new FirefoxDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        } catch (Exception e) {
            e.printStackTrace();
            // Обработка ошибки
        }
        return driver;
    }
}