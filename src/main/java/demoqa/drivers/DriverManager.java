package demoqa.drivers;

import demoqa.utils.ConfigReader;
import org.openqa.selenium.WebDriver;

public class DriverManager {

        private static WebDriver driver;

        public static WebDriver getDriver() {

            if (driver == null) {
                switch (ConfigReader.getValue("browser").toLowerCase()) {
                    case "chrome": driver = ChromeDriver.loadChromeDriver();
                    break;
                    case  "firefox": driver = FireFoxWebDriver.loadFirefoxDriver();
                    break;
                    default: throw new IllegalArgumentException("Unsupported browser" + ConfigReader.getValue("browser"));
                }
            }
            return driver;
        }

    public static void closeDriver() {
            try {
                if (driver != null) {
                    driver.close();
                    driver.quit();
                    driver = null;
                }
        } catch (Exception e) {
                e.printStackTrace();
            }
    }
}
