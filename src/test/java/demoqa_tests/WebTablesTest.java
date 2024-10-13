package demoqa_tests;

import demoqa.data.MockDataRegistrationForm;
import org.testng.annotations.Test;

public class WebTablesTest extends BaseTest {

    @Test
    public void webTableTest() throws InterruptedException {
        helper.browserManager.openURL("https://demoqa.com/webtables");
        demoqaPages.webTablesPage.addButton.click();
        Thread.sleep(2000);
        demoqaPages.webTablesPage.fillWebTablesForm(MockDataRegistrationForm.randomRegistration());
        Thread.sleep(2000);

        demoqaPages.webTablesPage.editUser.click();
        demoqaPages.webTablesPage.fillWebTablesEditForm(MockDataRegistrationForm.randomRegistrationEdit());
        Thread.sleep(2000);

        demoqaPages.webTablesPage.deleteUser.click();
        Thread.sleep(2000);

        demoqaPages.webTablesPage.searchBox.click();
        helper.webElementActions.input(demoqaPages.webTablesPage.searchBox, "Cierra");
        Thread.sleep(2000);


    }
}
