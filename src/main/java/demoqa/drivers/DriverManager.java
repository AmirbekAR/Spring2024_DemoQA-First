package demoqa.drivers;

import demoqa.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DriverManager {
    private static WebDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(DriverManager.class);

    public static WebDriver getDriver() {
        if (driver == null) {
            try {
                switch (ConfigReader.getValue("browser").toLowerCase()) {
                    case "chrome":
                        logger.info("Initializing Chrome Driver");
                        driver = ChromeDriver.loadChromeDriver();
                        break;
                    case "firefox":
                        logger.info("Initializing Firefox Driver");
                        driver = FireFoxWebDriver.loadFirefoxDriver();
                        break;
                    default:
                        throw new IllegalArgumentException("Unsupported browser: " + ConfigReader.getValue("browser"));
                }
            } catch (Exception e) {
                logger.error("Error initializing WebDriver: ", e);
            }
        }
        return driver;
    }

    public static void closeDriver() {
        try {
            if (driver != null) {
                driver.quit();
                driver = null;
                logger.info("WebDriver closed successfully.");
            }
        } catch (Exception e) {
            logger.error("Error closing WebDriver: ", e);
        }
    }
}