package demoqa_tests;

import demoqa.drivers.DriverManager;
import demoqa.helper.WebElementActions;
import demoqa.modul_import.ImportHelpers;
import demoqa.pages.SelectMenuPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

    public abstract class BaseTest {

        public WebDriver driver;
        public WebElementActions webElementActions;
        public ImportHelpers helper;
        public demoqa.module_import.DemoqaPages demoqaPages;
        public SelectMenuPage selectMenuPage;


        @BeforeClass(alwaysRun = true)
        public void setUp() {
            driver = DriverManager.getDriver();
            webElementActions = new WebElementActions();
            helper = new ImportHelpers(driver);
            demoqaPages = new demoqa.module_import.DemoqaPages();
            webElementActions = new WebElementActions();
            selectMenuPage = new SelectMenuPage();
        }

        @AfterClass(alwaysRun = true)
        public void tearDown() {
            driver.close();

    }
}
