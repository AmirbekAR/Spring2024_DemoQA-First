package demoqa.drivers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

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
                options.addArguments("--headless"); // Если не нужен графический интерфейс
                options.addArguments("--disable-gpu"); // Если используется headless режим

                String hubUrl = "http://167.71.27.204:4444/wd/hub";

                WebDriver driver = null;
                try {
                        driver = new RemoteWebDriver(new URL(hubUrl), options);
                } catch (MalformedURLException e) {
                        throw new RuntimeException("Invalid URL for RemoteWebDriver: " + e.getMessage(), e);
                } catch (Exception e) {
                        throw new RuntimeException("Error initializing WebDriver: " + e.getMessage(), e);
                }

                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
                driver.manage().window().maximize();
                return driver;
        }

        // Метод для клика по элементу с явным ожиданием
        public static void clickElement(WebDriver driver, By by) {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                try {
                        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
                        element.click();
                } catch (Exception e) {
                        throw new RuntimeException("Error clicking on element: " + e.getMessage(), e);
                }
        }
}
