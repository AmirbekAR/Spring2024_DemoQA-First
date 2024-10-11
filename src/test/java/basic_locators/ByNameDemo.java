package basic_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ByNameDemo {

    @Test
    public void demo1() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebElement userNameInput = driver.findElement(By.name("username"));
        Thread.sleep(4000);
        userNameInput.sendKeys("Admin");
        WebElement passwordInput = driver.findElement(By.name("password"));
        Thread.sleep(4000);
        passwordInput.sendKeys("admin123");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        Thread.sleep(4000);
        String expectedTitle = "Dashboard";
        WebElement title = driver.findElement(By.xpath("//h6"));
        String actualTitle = title.getText();
        System.out.println(actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle);
        driver.close();
    }
}
