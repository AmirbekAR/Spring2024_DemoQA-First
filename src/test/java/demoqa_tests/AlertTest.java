package demoqa_tests;

import org.testng.annotations.Test;

public class AlertTest extends BaseTest {

    @Test(groups = {"UI", "TC-5"})
    void alertTest() throws InterruptedException {
        helper.getBrowserManager().openURL("https://demoqa.com/alerts");
        webElementActions.click(demoqaPages.getAlertPage().alertButton);
        Thread.sleep(5000);
    }

}
