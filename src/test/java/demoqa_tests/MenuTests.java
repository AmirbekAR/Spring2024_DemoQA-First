package demoqa_tests;

import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.Test;

public class MenuTests extends BaseTest {

    @Test
    public void menuTest() throws InterruptedException {
        helper.getBrowserManager().openURL("https://demoqa.com/menu");

        Actions actions = new Actions(helper.getiFrameHelper().getDriver());

            helper.webElementActions.isElementVisible(demoqaPages.menuPages.mainItem2); // курсор на "Main Item 2"
            helper.webElementActions.scrollToElement(demoqaPages.menuPages.mainItem2);
            actions.moveToElement(demoqaPages.menuPages.mainItem2).perform();
            Thread.sleep(3000);

            helper.webElementActions.isElementVisible(demoqaPages.menuPages.SubItem2);
            actions.moveToElement(demoqaPages.menuPages.SubItem2).perform();

            helper.webElementActions.isElementVisible(demoqaPages.menuPages.subSubList);
            actions.moveToElement(demoqaPages.menuPages.subSubList).perform();
            Thread.sleep(3000);

               helper.webElementActions.isElementVisible(demoqaPages.menuPages.subSubItem1);
                    actions.moveToElement(demoqaPages.menuPages.subSubItem2).perform();
                    Thread.sleep(3000);

    }
}


