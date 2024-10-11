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

//        FirefoxOptions options = new FirefoxOptions();
//        options.addArguments("--remote-allow-origin=*"); //
//        options.addArguments("--disable-extensions"); // отключи какие-то плагины если есть
//        options.addArguments("window-size=1920,1080");
//        options.addArguments("no-sandbox");
//        options.setPageLoadStrategy(PageLoadStrategy.NORMAL); // тут Используется по умолчанию, ожидает загрузки всех ресурсов.
//        options.setPageLoadStrategy(PageLoadStrategy.EAGER); // Доступ к DOM готов, но другие ресурсы, например изображения, все еще могут загружаться.
//        options.setPageLoadStrategy(PageLoadStrategy.NONE); // Совсем не блокирует WebDriver

//        if (Boolean.parseBoolean(ConfigReader.getValue("headless"))) {
//            options.addArguments("--headless");
//        }


        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }
}
