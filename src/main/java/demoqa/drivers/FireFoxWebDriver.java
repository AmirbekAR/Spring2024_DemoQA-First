package demoqa.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

import static demoqa.utils.ConfigReader.getValue;

public class FireFoxWebDriver {

    public static WebDriver loadFirefoxDriver() {
        // Установка драйвера Firefox через WebDriverManager
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();

        // Устанавливаем параметры для Firefox для корректной работы в headless-режиме
        options.addArguments("--disable-extensions");  // Отключение расширений
        options.addArguments("--window-size=1920,1080");  // Установка размера окна
        options.addArguments("--no-sandbox");  // Отключение песочницы (для работы в Docker)
        options.addArguments("--disable-gpu");  // Отключение использования GPU
        options.addArguments("--disable-software-rasterizer");  // Отключение программного рендеринга
        options.addArguments("--remote-debugging-port=9222");  // Установка порта для отладки

        // Если нужно работать в headless-режиме, добавляем соответствующий флаг
        if (Boolean.parseBoolean(getValue("headless"))) {
            options.addArguments("--headless");
        }

        // Создание и настройка WebDriver
        WebDriver driver = null;
        try {
            driver = new FirefoxDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));  // Установка таймаута
            driver.manage().window().maximize();  // Максимизация окна
        } catch (Exception e) {
            System.out.println("Ошибка при инициализации WebDriver: " + e.getMessage());
        }
        return driver;
    }
}
