package demoqa.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ChromeWebDriver {

        public static WebDriver loadChromeDriver() {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--disable-extensions");
                options.addArguments("--window-size=1920,1080");
                options.addArguments("--no-sandbox");

                // Замените <your_server_ip> на фактический IP-адрес вашего сервера
                String hubUrl = "http://167.71.27.204:4444/wd/hub";

                WebDriver driver = null;
                try {
                        driver = new RemoteWebDriver(new URL(hubUrl), options);
                } catch (MalformedURLException e) {
                        throw new RuntimeException("Invalid URL for RemoteWebDriver: " + e.getMessage(), e);
                }

                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
                driver.manage().window().maximize();
                return driver;
        }
}
