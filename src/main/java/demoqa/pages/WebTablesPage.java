package demoqa.pages;

import demoqa.entities.WebTables;
import demoqa.module_import.DemoqaPages;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebTablesPage extends BasePage {

    @FindBy(id = "addNewRecordButton")
    public WebElement addButton;

    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "lastName")
    public WebElement lastName;

    @FindBy(id = "userEmail")
    public WebElement userEmail;

    @FindBy(id = "age")
    public WebElement age;

    @FindBy(id = "salary")
    public WebElement salary;

    @FindBy(id = "department")
    public WebElement department;

    @FindBy(id = "submit")
    public WebElement submit;

    @FindBy(xpath = "//input[@id='searchBox']")
    public WebElement searchBox;


    @FindBy(xpath = "//div[normalize-space()='asdgds'])[1]")
    public WebElement searchBoxFirstName;

    @FindBy(id = "edit-record-2")
    public WebElement editUser;


    @FindBy(id = "delete-record-2")
    public WebElement deleteUser;

    @Step("Input firstName {0}")
    public WebTablesPage inputUserName(String firsName) {
        webElementActions.input(this.firstName, firsName);
        return this;
    }
    @Step("Input lastName {0}")
    public WebTablesPage inputLastName(String lastName) {
        webElementActions.input(this.lastName, lastName);
        return this;
    }
    @Step("Input user email {0}")
    public WebTablesPage inputEmail(String email) {
        webElementActions.input(this.userEmail, email);
        return this;
    }

    @Step("Input user age {0}")
    public WebTablesPage inputAge(int age) {
        webElementActions.input(this.age, String.valueOf(age));
        return this;
}
    @Step("Input user age {0}")
    public WebTablesPage inputSalary(int salary) {
        webElementActions.input(this.salary, String.valueOf(salary));
        return this;
    }
    @Step("Input user email {0}")
    public WebTablesPage inputDepartment(String department) {
        webElementActions.input(this.department, department);
        return this;
    }
    @Step("Click Submit button")
    public WebTablesPage submit() throws InterruptedException {
        Thread.sleep(1000);
        webElementActions.scrollToElement(this.submit).click(this.submit);
        return this;
    }
    @Step("Input searchBox {0}")
    public WebTablesPage inputSearchBox(String searchBox) {
        webElementActions.input(this.searchBox, searchBox);
        return this;
    }

    public WebTablesPage fillWebTablesForm(WebTables webTables) throws InterruptedException { // готовый метод для ввода данных
        inputUserName(webTables.getFirstName())
                .inputLastName(webTables.getLastName())
                .inputEmail(webTables.getEmail())
                .inputAge(webTables.getAge())
                .inputSalary(webTables.getSalary())
                .inputDepartment(webTables.getDepartment())
                .submit();
        return this;
    }
    public WebTablesPage fillWebTablesEditForm(WebTables webTables) throws InterruptedException { // готовый метод для ввода данных
        inputUserName(webTables.getFirstName())
                .inputLastName(webTables.getLastName())
                .clearEmail()
                .inputEmail(webTables.getEmail())
                .inputAge(webTables.getAge())
                .inputSalary(webTables.getSalary())
                .inputDepartment(webTables.getDepartment())
                .submit();
        return this;
    }

    public String getFirstName(WebElement element) {
        return firstName.getText();
    }
    public WebTablesPage clearEmail() {
//        demoqa.module_import.DemoqaPages demoqaPages = new DemoqaPages();
        userEmail.clear();
        return this;
    }
}
