package demoqa.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

import static demoqa.utils.ConfigReader.getValue;

public class ChromeWebDriver {

        public static WebDriver loadChromeDriver() {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--disable-extensions");
                options.addArguments("--window-size=1920,1080");
                options.addArguments("--no-sandbox");
                if (Boolean.parseBoolean(getValue("headless"))) {
                        options.addArguments("--headless");
                }
                // Используйте локальный ChromeDriver
                WebDriver driver = new org.openqa.selenium.chrome.ChromeDriver(options);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
                driver.manage().window().maximize();
                return driver;
        }

}
