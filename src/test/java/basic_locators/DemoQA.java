package basic_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class DemoQA {

    @Test
    public void demo1() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebElement userNameInput = driver.findElement(By.name("username"));
        userNameInput.sendKeys("Admin");
        Thread.sleep(4000);
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("admin123");
        Thread.sleep(4000);
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

    }
    @Test
    public void demo2(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://swis.trade.kg/");

        WebElement userNameInput = driver.findElement(By.name("userName"));
        userNameInput.sendKeys("ex_amarynbaev");
        WebElement userPasswordInput = driver.findElement(By.name("password"));
        userPasswordInput.sendKeys("330033");
        WebElement enter = driver.findElement(By.xpath("//input[@class='logging_button']"));
        enter.click();
        WebElement enterFindInn = driver.findElement(By.xpath("//input[@value='Поиск УВЭД']"));
        enterFindInn.sendKeys("01007200310037");
        enterFindInn.sendKeys(Keys.RETURN);

    }
}
