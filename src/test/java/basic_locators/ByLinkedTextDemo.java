package basic_locators;

import demoqa_tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class ByLinkedTextDemo extends BaseTest {

    @Test
    public void byLinkedTextTest() throws InterruptedException {
      helper.browserManager.openURL("https://demoqa.com/links");
        WebElement homeLink = driver.findElement(By.linkText("Home")); // поиск по названию ссылки
        homeLink.click();
        Thread.sleep(4000);
    }
}
