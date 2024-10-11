package demoqa.drivers;

import demoqa.utils.ConfigReader;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class ChromeDriver {

    public static WebDriver loadChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");

//        ChromeOptions options = new ChromeOptions();
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

//        Cookie cookie = new Cookie("JSESSIONID", ConfigReader.getValue("cookies"));

        WebDriver driver = new org.openqa.selenium.chrome.ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }
}
