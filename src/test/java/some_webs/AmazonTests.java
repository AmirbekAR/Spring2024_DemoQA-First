package some_webs;

import demoqa_tests.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

@Slf4j
public class AmazonTests extends BaseTest {

    @Test
    public void amazonTests() throws InterruptedException {

        helper.browserManager.openURL("https://www.amazon.com");
        Thread.sleep(3000);
        driver.findElement(By.id("twotabsearchtextbox"))
                .sendKeys("iphone" + Keys.ENTER);
        Thread.sleep(3000);

        List<WebElement> brands = driver.findElements(By.xpath("//div[@id='brandsRefinements']/ul/span/span/li/span/a"));

        for (int i = 0; i < brands.size() - 1; i++) {
            try {
                brands = driver.findElements(By.xpath("//div[@id='brandsRefinements']/ul/span/span/li/span/a"));
                if (i < brands.size()) {
                    brands.get(i).click();
                    Thread.sleep(3000);
                }
            } catch (StaleElementReferenceException e) {
                if (i == brands.size() - 1) throw e;
                e.printStackTrace();
                System.out.println("В случае ошибки заново ищем элемент " + i);
            }
        }
    }
}
