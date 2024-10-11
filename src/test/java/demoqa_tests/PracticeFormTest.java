package demoqa_tests;

import demoqa.data.MockDataGeneratorForPractice;
import demoqa.pages.PracticeFromPage;
import org.testng.annotations.Test;

public class PracticeFormTest extends BaseTest {
    PracticeFromPage fromPage = new PracticeFromPage();

    @Test
    public void practiceFormTest() throws InterruptedException {
        helper.browserManager.openURL("https://demoqa.com/automation-practice-form");

        demoqaPages.getPracticeFormPage2().fillTextFormPractice(MockDataGeneratorForPractice.randomTextFormPage2());
        Thread.sleep(5000);
        helper.webElementActions.scrollToElement(demoqaPages.getPracticeFormPage2().dateOfBirth);
        Thread.sleep(5000);
        fromPage.genderMale()
                .inputDateOfBirth("06 Sep 1983")
                .inputSubject("Maths")
                .hobbiesCheckbox1()
                .clickState("NCR")
                .clickCity("Delhi");
        Thread.sleep(5000);
    }
}
