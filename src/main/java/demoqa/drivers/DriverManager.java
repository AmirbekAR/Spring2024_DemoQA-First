package demoqa.drivers;

import demoqa.utils.ConfigReader;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    // ThreadLocal для поддержки многопоточности
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Получаем экземпляр драйвера
    public static WebDriver getDriver() {
        if (driver.get() == null) {
            System.out.println("Initializing WebDriver");
            switch (ConfigReader.getValue("browser").toLowerCase()) {
                case "chrome":
                    driver.set(ChromeWebDriver.loadChromeDriver());
                    break;
                case "firefox":
                    driver.set(FireFoxWebDriver.loadFirefoxDriver());
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported browser: " + ConfigReader.getValue("browser"));
            }
        }
        return driver.get();
    }

    // Закрываем драйвер
    public static void closeDriver() {
        try {
            if (driver.get() != null) {
                System.out.println("Closing WebDriver");
                driver.get().quit();
                driver.remove(); // Удаляем драйвер из ThreadLocal
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
