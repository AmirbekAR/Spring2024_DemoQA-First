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

                // Устанавливаем параметры для правильной работы в Docker или headless-режиме
                options.addArguments("--remote-allow-origins=*");  // Разрешение на доступ с различных источников
                options.addArguments("--disable-extensions");  // Отключение расширений
                options.addArguments("--window-size=1920,1080");  // Установка окна браузера
                options.addArguments("--no-sandbox");  // Отключение песочницы (для Docker)
                options.addArguments("--disable-dev-shm-usage");  // Отключение использования общей памяти в Docker
                options.addArguments("--disable-gpu");  // Отключение GPU (для headless-режима)
                options.addArguments("--disable-software-rasterizer");  // Отключение программного рендеринга (полезно для Docker)

                // Если требуется headless-режим, добавляем соответствующий флаг
                if (Boolean.parseBoolean(getValue("headless"))) {
                        options.addArguments("--headless");
                }

                // Дополнительный параметр для отладки, если нужно (не обязательно)
                options.addArguments("--remote-debugging-port=9222");

                WebDriver driver = null;
                try {
                        driver = new org.openqa.selenium.chrome.ChromeDriver(options);
                        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));  // Установка таймаута
                        driver.manage().window().maximize();  // Максимизация окна
                } catch (Exception e) {
                        System.out.println("Ошибка при инициализации Chrome WebDriver: " + e.getMessage());
                }

                return driver;
        }
}
