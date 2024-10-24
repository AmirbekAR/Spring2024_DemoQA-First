package demoqa_tests;

import demoqa.data.MockDataGenerator;
import org.testng.annotations.Test;

public class TextBoxTests extends BaseTest {

    @Test(priority = 2)
    public void textTextBox() throws InterruptedException {
        helper.browserManager.openURL("https://demoqa.com/text-box");

        demoqaPages.textBoxPage.inputUserName("Lee Child")
                .inputUserEmail("leeChild@gmail.com")
                .inputCurrentAddress("Wall street 123")
                .inputPermanentAddress("Some permanent address")
                .submit();
        Thread.sleep(5000);
        }

    @Test(priority = 1)
    void testTexBox2() throws InterruptedException {
        helper.browserManager.openURL("https://demoqa.com/text-box");
        demoqaPages.getTextBoxPage().fillTextBoxForm(MockDataGenerator.randomTextBox());
        Thread.sleep(2000);

    }
}

