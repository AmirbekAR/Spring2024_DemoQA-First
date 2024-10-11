package advanced_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class CssSelectorDemo {

    @Test
    public void cssSelectorTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demoqa.com/webtables");

        WebElement submitBtn1 = driver.findElement(By.cssSelector(".w3-example")); // . точка - в селекторе означает класс
        WebElement submitBtn2 = driver.findElement(By.cssSelector("#userName")); // # решетка - означает id




    }
}

/*  CSS Selector последний селектора в Selenium
    css selector --> input[type='text'] тут значении передается без собачки и без слэша.
    <.class value>
    table[id='customer'] tbody
    textarea[id=currentAddress]

    span[class*='_h1']
    . точка - в селекторе означает класс
    # решетка - означает id
    ^ - означает в поиске startsWith()
    $ - endsWith()
    * - contains
    table[id='customers'] > tbody > tr > th
    table[id='customers'] tr > th

 */