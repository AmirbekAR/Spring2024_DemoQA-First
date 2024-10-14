package demoqa_tests;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class AutoCompleteTest extends BaseTest {

    @Test(groups = {"UI", "TC-6"})
    public void colorNamesTest() throws InterruptedException {

        helper.browserManager.openURL("https://demoqa.com/auto-complete");
        helper.webElementActions.click(demoqaPages.autoCompletePage.colorClick);
        demoqaPages.autoCompletePage.colorClick.sendKeys("White" +  Keys.ENTER);
        Thread.sleep(2000);
        demoqaPages.autoCompletePage.singleColor.click();
        demoqaPages.autoCompletePage.singleColor.sendKeys("Green"  + Keys.ENTER);

    }
}
