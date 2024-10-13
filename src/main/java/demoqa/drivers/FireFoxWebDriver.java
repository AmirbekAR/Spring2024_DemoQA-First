package demoqa.drivers;

import demoqa.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class FireFoxWebDriver {

    public static WebDriver loadFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver");

        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--window-size=1920,1080");

        // Параметры для headless режима
        if (Boolean.parseBoolean(ConfigReader.getValue("headless"))) {
            options.addArguments("--headless");
        }

        WebDriver driver = new FirefoxDriver(options); // Полный путь
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }
}
