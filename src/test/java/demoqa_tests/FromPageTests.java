package demoqa_tests;

import demoqa.drivers.DriverManager;
import demoqa.pages.PracticeFromPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FromPageTests {
    WebDriver driver = DriverManager.getDriver();
    PracticeFromPage fromPage = new PracticeFromPage();

    @Test
    public void testFromPage() throws InterruptedException {
        driver.get("https://demoqa.com/automation-practice-form");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        fromPage.inputFirstName("Timur")
                .inputLastName("Timurov")
                .inputUserEmail("timurTT@gmail.com")
                .genderMale()
                .inputUserNumber("0777668877")
                .inputDateOfBirth("06 Sep 1983")
                .inputSubject("Maths")
                .hobbiesCheckbox1()
                .currentAddress("Some address")
                .clickState("NCR")
                .clickCity("Delhi");
        Thread.sleep(5000);

        // Использование WebDriverWait для ожидания, пока элементы станут видимыми
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Student Name']/following-sibling::td")));
        WebElement resultFirstName = driver.findElement(By.xpath("//td[text()='Student Name']/following-sibling::td"));
        WebElement resultEmail = driver.findElement(By.xpath("//td[text()='Student Email']/following-sibling::td"));
        WebElement resultGender = driver.findElement(By.xpath("//td[text()='Gender']/following-sibling::td"));
        WebElement resultMobile = driver.findElement(By.xpath("//td[text()='Mobile']/following-sibling::td"));
        WebElement resultDateOfBirth = driver.findElement(By.xpath("//td[text()='Date of Birth']/following-sibling::td"));
        WebElement resultSubjects = driver.findElement(By.xpath("//td[text()='Subjects']/following-sibling::td"));
        WebElement resultHobbies = driver.findElement(By.xpath("//td[text()='Hobbies']/following-sibling::td"));
        WebElement resultAddress = driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td"));
        WebElement resultStateCity = driver.findElement(By.xpath("//td[text()='State and City']/following-sibling::td"));

        // Проверка утверждений
        Assert.assertEquals(resultFirstName.getText(), "Timur Timurov");
        Assert.assertEquals(resultEmail.getText(), "timurTT@gmail.com");
        Assert.assertEquals(resultGender.getText(), "Male");
        Assert.assertEquals(resultMobile.getText(), "0777668877");
        Assert.assertEquals(resultDateOfBirth.getText(), "06 September,1983");
        Assert.assertEquals(resultSubjects.getText(), "Maths");
        Assert.assertEquals(resultHobbies.getText(), "Sports");
        Assert.assertEquals(resultAddress.getText(), "Some address");
        Assert.assertTrue(resultStateCity.getText().contains("NCR"));
        Assert.assertTrue(resultStateCity.getText().contains("Delhi"));

         driver.close();
    }
}
