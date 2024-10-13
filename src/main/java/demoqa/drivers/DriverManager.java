package demoqa.drivers;

import demoqa.utils.ConfigReader;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    // ThreadLocal для поддержки многопоточности
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Получаем экземпляр драйвера
    public static WebDriver getDriver() {
        WebDriver currentDriver = driver.get();

        if (currentDriver == null || !isDriverActive(currentDriver)) {
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

    // Проверка, активен ли драйвер
    private static boolean isDriverActive(WebDriver driver) {
        try {
            // Пробуем получить текущий URL; если драйвер не активен, это вызовет исключение
            driver.getCurrentUrl();
            return true;
        } catch (Exception e) {
            return false;
        }
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
