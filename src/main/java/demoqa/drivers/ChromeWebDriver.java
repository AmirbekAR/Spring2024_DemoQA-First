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
                        // Specify the URL of the remote WebDriver server
                        WebDriver driver = null;
                        try {
                                driver = new RemoteWebDriver(new URL("http://selenium-hub:4444/wd/hub"), options);
                        } catch (MalformedURLException e) {
                                throw new RuntimeException(e);
                        }
                        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
                        driver.manage().window().maximize();
                        return driver;
                }
        }