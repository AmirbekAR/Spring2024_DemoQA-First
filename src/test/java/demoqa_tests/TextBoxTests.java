package demoqa_tests;

import demoqa.data.MockDataGenerator;
import demoqa.drivers.DriverManager;
import demoqa.entities.TextBox;
import demoqa.pages.TextBoxPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TextBoxTests extends BaseTest {
    TextBoxPage textBoxPage = new TextBoxPage();


    @Test
    public void textTextBox() throws InterruptedException {
        helper.browserManager.openURL("https://demoqa.com/text-box");
        textBoxPage.inputUserName("Lee Child")
                .inputUserEmail("leeChild@gmail.com")
                .inputCurrentAddress("Wall street 123")
                .inputPermanentAddress("Some permanent address")
                .submit();
        Thread.sleep(5000);

    }

    @Test
    void testTexBox2() throws InterruptedException {
        helper.browserManager.openURL("https://demoqa.com/text-box");
        demoqaPages.getTextBoxPage().fillTextBoxForm(MockDataGenerator.randomTextBox());
        Thread.sleep(2000);

    }
    @AfterClass
    public void tearDown() {
        // Закрытие WebDriver
        if (driver != null) {
            driver.quit();
        }
    }
}

