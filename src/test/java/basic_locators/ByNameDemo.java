package basic_locators;

import demoqa_tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ByNameDemo extends BaseTest {

    @Test
    public void demo1() throws InterruptedException {

       helper.browserManager.openURL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebElement userNameInput = driver.findElement(By.name("username"));
        Thread.sleep(4000);
        userNameInput.sendKeys("Admin");
        WebElement passwordInput = driver.findElement(By.name("password"));
        Thread.sleep(4000);
        passwordInput.sendKeys("admin123");
        Thread.sleep(4000);
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        Thread.sleep(4000);
        String expectedTitle = "Dashboard";
        WebElement title = driver.findElement(By.xpath("//h6"));
        Thread.sleep(4000);
        String actualTitle = title.getText();
        System.out.println(actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle);
        driver.close();
    }
}
