package demoqa_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class SelectMenuTest extends BaseTest {

    public static final Logger log = LoggerFactory.getLogger(SelectMenuTest.class);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    @Test(priority = 1)
    public void selectValueTest() throws InterruptedException {
        helper.getBrowserManager().openURL("https://demoqa.com/select-menu");

        helper.webElementActions.scrollToElement(demoqaPages.getSelectMenuPage().selectValueMenu);
        demoqaPages.getSelectMenuPage().selectValueMenu.click();

        List<WebElement> options = demoqaPages.getSelectMenuPage().selectValue();
        for (WebElement element : options) {
            System.out.println(element.getText());
            element.click();
            demoqaPages.getSelectMenuPage().selectValueMenu.click();
            Thread.sleep(2000);
        }

        String resultGroup1Option1 = driver.findElement(By.id("react-select-2-option-0-0")).getText();
        String resultGroup1Option2 = driver.findElement(By.id("react-select-2-option-0-1")).getText();
        String resultGroup2Option1 = driver.findElement(By.id("react-select-2-option-1-0")).getText();
        String resultGroup2Option2 = driver.findElement(By.id("react-select-2-option-1-1")).getText();
        String resultARootOption = driver.findElement(By.id("react-select-2-option-2")).getText();
        String resultAnotherRootOption = driver.findElement(By.id("react-select-2-option-3")).getText();

        Assert.assertEquals(resultGroup1Option1, "Group 1, option 1");
        Assert.assertEquals(resultGroup1Option2, "Group 1, option 2");
        Assert.assertEquals(resultGroup2Option1, "Group 2, option 1");
        Assert.assertEquals(resultGroup2Option2, "Group 2, option 2");
        Assert.assertEquals(resultARootOption, "A root option");
        Assert.assertEquals(resultAnotherRootOption, "Another root option");
    }


    @Test(priority = 3)
    void selectMenuTest() throws InterruptedException {
        helper.getBrowserManager().openURL("https://demoqa.com/select-menu");
//        helper.getDropdownHelper().selectByText(demoqaPages.getSelectMenuPage().oldStyleSelectMenu, GREEN.getColor());
//        Thread.sleep(5000);

        List<String> colors = helper.getDropdownHelper().getAllDropdownValues(demoqaPages.getSelectMenuPage().oldStyleSelectMenu);
        for (String color : colors) {
            System.out.println(color);
        }
        for (String color : colors) {
            helper.getDropdownHelper().selectByText(demoqaPages.getSelectMenuPage().oldStyleSelectMenu, color);
            Thread.sleep(1000);
        }
    }

    @Test(priority = 2)
    public void clickSelectOneOptions() throws InterruptedException {
        helper.getBrowserManager().openURL("https://demoqa.com/select-menu");

        helper.webElementActions.scrollToElement(demoqaPages.getSelectMenuPage().selectOne);
        demoqaPages.getSelectMenuPage().selectOne.click();
        Thread.sleep(1500);

        List<WebElement> options = demoqaPages.getSelectMenuPage().getSelectOneOptions();

        // Печатаем текст всех опций
        for (WebElement option : options) {
            System.out.println(option.getText());
            option.click();
            demoqaPages.getSelectMenuPage().selectOne.click(); // для выбора
            Thread.sleep(1500);
        }

        String resultDr = driver.findElement(By.xpath("//div[contains(text(),'Dr.')][text()='Dr.']")).getText();
        String resultMr = driver.findElement(By.xpath("//div[contains(text(),'Mr.')][text()='Mr.']")).getText();
        String resultMrs = driver.findElement(By.xpath("//div[contains(text(),'Mrs.')][text()='Mrs.']")).getText();
        String resultMs = driver.findElement(By.xpath("//div[contains(text(),'Ms.')][text()='Ms.']")).getText();
        String resultProf = driver.findElement(By.xpath("//div[contains(text(),'Prof.')][text()='Prof.']")).getText();
        String resultOther = driver.findElement(By.xpath("//div[contains(text(),'Other')][text()='Other']")).getText();

        Assert.assertEquals(resultDr, "Dr.");
        Assert.assertEquals(resultMr, "Mr.");
        Assert.assertEquals(resultMrs, "Mrs.");
        Assert.assertEquals(resultMs, "Ms.");
        Assert.assertEquals(resultProf, "Prof.");
        Assert.assertEquals(resultOther, "Other");
    }

        @Test(priority = 4)
        public void multiSelectDropDown() throws InterruptedException {
            helper.getBrowserManager().openURL("https://demoqa.com/select-menu");

            helper.webElementActions.scrollToElement(demoqaPages.getSelectMenuPage().clickMulti);
            demoqaPages.getSelectMenuPage().clickMulti.click();
            List<WebElement> list = selectMenuPage.multiDropDown();
            for (WebElement element : list) {
                element.click();
                Thread.sleep(2000);
            }
            String resultMultiSelectGreen = driver.findElement(By.xpath("(//div[@class='css-12jo7m5'])[contains(text(),'Green')]")).getText();
            String resultMultiSelectBlue = driver.findElement(By.xpath("(//div[@class='css-12jo7m5'])[contains(text(),'Blue')]")).getText();
            String resultMultiSelectBlack = driver.findElement(By.xpath("(//div[@class='css-12jo7m5'])[contains(text(),'Black')]")).getText();
            String resultMultiSelectRed = driver.findElement(By.xpath("(//div[@class='css-12jo7m5'])[contains(text(),'Red')]")).getText();

            Assert.assertEquals(resultMultiSelectGreen, "Green");
            Assert.assertEquals(resultMultiSelectBlue, "Blue");
            Assert.assertEquals(resultMultiSelectBlack, "Black");
            Assert.assertEquals(resultMultiSelectRed, "Red");
    }

        @Test(priority = 5)
        public void standardMultiSelectTest() throws InterruptedException {
            helper.getBrowserManager().openURL("https://demoqa.com/select-menu");
            helper.webElementActions.scrollToElement(demoqaPages.getSelectMenuPage().cars);

            List<WebElement> list = selectMenuPage.standardMultiSelect();
            for (WebElement element : list) {
                element.click();
                Thread.sleep(2000);
                log.info("Выбрано авто: '{}'", element.getText());
            }
        String resultVolvo = driver.findElement(By.xpath("//option[@value='volvo']")).getText();
        String resultSaab = driver.findElement(By.xpath("//option[@value='saab']")).getText();
        String resultOpel = driver.findElement(By.xpath("//option[@value='opel']")).getText();
        String resulAudi = driver.findElement(By.xpath("//option[@value='audi']")).getText();

        Assert.assertEquals(resultVolvo, "Volvo");
        Assert.assertEquals(resultSaab, "Saab");
        Assert.assertEquals(resultOpel, "Opel");
        Assert.assertEquals(resulAudi, "Audi");

    }

}
