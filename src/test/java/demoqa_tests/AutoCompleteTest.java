package demoqa_tests;


import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class AutoCompleteTest extends BaseTest {

    @Test
    public void colorNamesTest() {

        helper.browserManager.openURL("https://demoqa.com/auto-complete");
        helper.webElementActions.click(demoqaPages.autoCompletePage.colorClick);
        demoqaPages.autoCompletePage.colorClick.click();

        demoqaPages.autoCompletePage.colorClick.click();

    }
}
