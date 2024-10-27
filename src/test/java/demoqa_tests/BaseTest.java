package demoqa_tests;

import demoqa.drivers.DriverManager;
import demoqa.helper.WebElementActions;
import demoqa.modul_import.ImportHelpers;
import demoqa.pages.SelectMenuPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public abstract class BaseTest {

    public WebDriver driver;
    public WebElementActions webElementActions;
    public ImportHelpers helper;
    public demoqa.module_import.DemoqaPages demoqaPages;
    public SelectMenuPage selectMenuPage;

    WebDriverWait wait;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        driver = DriverManager.getDriver();
        if (driver == null) {
            throw new IllegalArgumentException("Driver must be set");
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        webElementActions = new WebElementActions();
        helper = new ImportHelpers(driver);
        demoqaPages = new demoqa.module_import.DemoqaPages();
        selectMenuPage = new SelectMenuPage();
    }

    @AfterClass
    public void tearDown() {
        DriverManager.closeDriver(); // Используем DriverManager для закрытия драйвера
    }
}
