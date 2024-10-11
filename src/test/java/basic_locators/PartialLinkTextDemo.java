package basic_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class PartialLinkTextDemo {

    @Test
    public void partialLinkedTextTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demoqa.com/links");

        WebElement homeLink = driver.findElement(By.partialLinkText("Request")); // поиск по названию похоже на contains если находит кликает всех
        homeLink.click();

        String badRequestText = driver.findElement(By.xpath("(//p/b)[2]")).getText();
        Assert.assertTrue(badRequestText.equals("Bad Request"));
        Thread.sleep(4000);
        driver.close();
    }
}
