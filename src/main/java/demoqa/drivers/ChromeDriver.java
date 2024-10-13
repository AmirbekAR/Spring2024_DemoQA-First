package demoqa.drivers;

import demoqa.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class ChromeDriver {

    public static WebDriver loadChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080");

        // Пример добавления параметров для headless режима
        if (Boolean.parseBoolean(ConfigReader.getValue("headless"))) {
            options.addArguments("--headless");
        }

        WebDriver driver = new org.openqa.selenium.chrome.ChromeDriver(options); // Полный путь
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }
}