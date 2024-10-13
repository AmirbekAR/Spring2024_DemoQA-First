package basic_locators;

import demoqa.pages.BasePage;
import demoqa_tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ByIdDemo extends BaseTest {

    @Test
    public void byIdDemoTest() throws InterruptedException {
        helper.browserManager.openURL("https://demoqa.com/text-box");

        // Ввод данных
        String fullName = "Timur Demirov";
        WebElement fullNameInput = driver.findElement(By.id("userName"));
        fullNameInput.sendKeys(fullName);

        String email = "timur.dem@gmail.com";
        WebElement emailInput = driver.findElement(By.id("userEmail"));
        emailInput.sendKeys(email);

        String currentAddressStr = "Bishkek, 12 mkr";
        WebElement currentAddressInput = driver.findElement(By.id("currentAddress"));
        currentAddressInput.sendKeys(currentAddressStr);

        String permanentAddressStr = "Gorkogo, 174";
        WebElement permanentAddressInput = driver.findElement(By.id("permanentAddress"));
        permanentAddressInput.sendKeys(permanentAddressStr);
        permanentAddressInput.sendKeys(Keys.TAB);
        permanentAddressInput.sendKeys(Keys.ENTER);

        // Проверка имени
        String actualName = driver.findElement(By.xpath("//p[@id='name']")).getText().split(":")[1].trim();

//        WebElement responseName = driver.findElement(By.xpath("//p[@id='name']")); // Найти элемент на веб-странице, содержащий имя.
//        String[] nameParts = responseName.getText().split(":"); /* responseName.getText() извлекает текстовое содержимое элемента responseName -
//        "Name: Timur Demirov", то этот метод вернет всю строку.  .split(":") разбивает полученную строку на массив строк по символу двоеточия ":".
//        Результат будет массивом, в котором первая часть (индекс 0) — это "Name" и вторая часть (индекс 1) — это "Timur Demirov"*/
//        String actualName = nameParts[1].trim();
          Assert.assertEquals(actualName, fullName);

        // Проверка email
        WebElement responseEmail = driver.findElement(By.xpath("//p[@id='email']")); // Исправлено на 'email'
        String[] emailParts = responseEmail.getText().split(":");
        String actualEmail = emailParts[1].trim();
        Assert.assertEquals(actualEmail, email);

        // Проверка текущего адреса
        WebElement currentAddress = driver.findElement(By.xpath("//p[@id='currentAddress']")); // Исправлено на 'currentAddress'
        String[] currentParts = currentAddress.getText().split(":");
        String actualCurrentAddress = currentParts[1].trim();
        Assert.assertEquals(actualCurrentAddress, currentAddressStr);

        // Проверка постоянного адреса
        WebElement permanentAddress = driver.findElement(By.xpath("//p[@id='permanentAddress']"));
        String[] permanentAddressParts = permanentAddress.getText().split(":");
        String actualPermanentAddress = permanentAddressParts[1].trim();
        Assert.assertEquals(actualPermanentAddress, permanentAddressStr);

    }
}