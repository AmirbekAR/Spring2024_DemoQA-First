package demoqa_tests;

import org.testng.annotations.Test;

public class ButtonsTest extends BaseTest {

    @Test
    void testButtons() throws InterruptedException {
        helper.browserManager.openURL("https://demoqa.com/buttons");
        webElementActions.doubleClick(demoqaPages.getButtonsPage().doubleClickButton);
        webElementActions.rightClick(demoqaPages.getButtonsPage().rightClickButton);
    }
}
