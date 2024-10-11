package demoqa.pages;

import demoqa.entities.PracticeForm;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PracticeFormPage2 extends BasePage {

    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "lastName")
    public WebElement lastName;

    @FindBy(id = "userEmail")
    public WebElement userEmail;

    @FindBy(css = "label[for='gender-radio-1']")
    public WebElement Male;

    @FindBy(id = "gender-radio-2")
    public WebElement Female;

    @FindBy(id = "userNumber")
    public WebElement mobileNumber;

    @FindBy(id = "dateOfBirthInput")
    public WebElement dateOfBirth;

    @FindBy(id = "subjectsInput")
    public WebElement subjectsInput;

    @FindBy(css = "label[for='hobbies-checkbox-1']")
    public WebElement Sports;

    @FindBy(css = "label[for='hobbies-checkbox-2']")
    public WebElement Reading;

    @FindBy(css = "label[for='hobbies-checkbox-3']")
    public WebElement Music;

    @FindBy(id = "currentAddress")
    public WebElement currentAddress;

    @FindBy(id = "submit")
    public WebElement submit;

    @Step("Input firstName {0}")
    public PracticeFormPage2 inputFirstName(String firstName) {
        webElementActions.input(this.firstName, firstName);
        return this;
    }

    @Step("Input lastName {0}")
    public PracticeFormPage2 inputLastName(String lastName) {
        webElementActions.input(this.lastName, lastName);
        return this;
    }

    @Step("Input email {0}")
    public PracticeFormPage2 inputEmail(String userEmail) {
        webElementActions.input(this.userEmail, userEmail);
        return this;
    }

    @Step("Input male {0}")
    public PracticeFormPage2 chooseMale() {
        webElementActions.click(this.Male);
        return this;
    }

    @Step("Input female {0}")
    public PracticeFormPage2 chooseFemale() {
        webElementActions.click(this.Female);
        return this;
    }

    @Step("Input mobileNumber {0}")
    public PracticeFormPage2 mobileNumber(String mobileNumber) {
        webElementActions.input(this.mobileNumber, mobileNumber);
        return this;
    }


    @Step("Input subjectsInput {0}")
    public PracticeFormPage2 inputSubjects(String subject) {
        webElementActions.input(this.subjectsInput, subject);
        return this;
    }

    @Step("Input HobbiesSports {0}")
    public PracticeFormPage2 chooseHobbiesSports() {
        webElementActions.click(this.Sports);
        return this;
    }

    @Step("Input HobbiesReading {0}")
    public PracticeFormPage2 chooseHobbiesReading() {
        webElementActions.click(this.Reading);
        return this;
    }

    @Step("Input HobbiesMusic {0}")
    public PracticeFormPage2 chooseHobbiesMusic() {
        webElementActions.click(this.Music);
        return this;
    }

    @Step("Input currentAddress {0}")
    public PracticeFormPage2 inputCurrentAddress(String currentAddress) {
        webElementActions.input(this.currentAddress, currentAddress);
        return this;
    }

    @Step("Click Submit button")
    public TextBoxPage submit() {
        webElementActions.scrollToElement(this.submit).click(this.submit);
        return new TextBoxPage(); // Возвращаем новый экземпляр TextBoxPage
    }

    @Step
    public PracticeFormPage2 inputDateOfBirth(String dateOfBirthInput) {
        this.dateOfBirth.sendKeys(Keys.CONTROL + "a");
        webElementActions.scrollAndClearElements(this.dateOfBirth);
        webElementActions.input(this.dateOfBirth, dateOfBirthInput);
        this.dateOfBirth.sendKeys(Keys.ENTER);
        return this;
    }

    public PracticeFormPage2 fillTextFormPractice(PracticeForm practiceForm) {
        inputFirstName(practiceForm.getFirstName())
                .inputLastName(practiceForm.getLastName())
                .inputEmail(practiceForm.getEmail())
                .mobileNumber(String.valueOf(practiceForm.getMobileNumber()))
                .inputCurrentAddress(practiceForm.getCurrentAddress());
        return this;
    }
}