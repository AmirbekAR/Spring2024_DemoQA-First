package demoqa.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static demoqa.utils.ConfigReader.getValue;

public class ChromeWebDriver {

        public static WebDriver loadChromeDriver() {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--disable-extensions");
                options.addArguments("--window-size=1920,1080");
                options.addArguments("--no-sandbox");
                if (Boolean.parseBoolean(getValue("headless"))) {
                        options.addArguments("--headless");
                }

                WebDriver driver = null;
                try {
                        // Убедитесь, что URL правильный
                        String hubUrl = "http://<your_server_ip>:4444/wd/hub"; // Замените на ваш IP
                        driver = new RemoteWebDriver(new URL(hubUrl), options);
                } catch (MalformedURLException e) {
                        throw new RuntimeException("Invalid URL for RemoteWebDriver: " + e.getMessage(), e);
                }

                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
                driver.manage().window().maximize();
                return driver;
        }
}
