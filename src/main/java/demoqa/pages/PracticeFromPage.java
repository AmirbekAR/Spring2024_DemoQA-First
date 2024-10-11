package demoqa.pages;

import demoqa.drivers.DriverManager;
import demoqa.helper.WebElementActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PracticeFromPage {
    WebElementActions webElementActions = new WebElementActions();

    public PracticeFromPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

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

    @FindBy(id = "gender-radio-3")
    public WebElement Other;

    @FindBy(id = "userNumber")
    public WebElement userNumber;

    @FindBy(id = "dateOfBirthInput")
    public WebElement dateOfBirthInput;

    @FindBy(id = "subjectsInput")
    public WebElement subjectsInput;

    @FindBy(css = "label[for='hobbies-checkbox-1']")
    public WebElement Sports;

    @FindBy(id = "uploadPicture")
    public WebElement uploadPicture;

    @FindBy(id = "hobbies-checkbox-2")
    public WebElement Reading;

    @FindBy(id = "hobbies-checkbox-3")
    public WebElement Music;

    @FindBy(id = "currentAddress")
    public WebElement currentAddress;

    @FindBy(id = "react-select-3-input")
    public WebElement ncr;

    @FindBy(id = "react-select-4-input")
    public WebElement city;

    public PracticeFromPage inputFirstName(String firstName) {
        webElementActions.input(this.firstName, firstName);
        return this;
    }

    public PracticeFromPage inputLastName(String lastName) {
        webElementActions.input(this.lastName, lastName);
        return this;
    }

    public PracticeFromPage inputUserEmail(String userEmail) {
        webElementActions.input(this.userEmail, userEmail);
        return this;
    }

    public PracticeFromPage genderMale() {
        webElementActions.scrollToElement(this.Male);
        this.Male.click();
        return this;
    }

    public PracticeFromPage genderFemale() {
        webElementActions.scrollToElement(this.Female).click(this.Female);
        return this;
    }

    public PracticeFromPage genderOther() {
        webElementActions.scrollToElement(this.Other).click(this.Other);
        return this;
    }

    public PracticeFromPage inputUserNumber(String userNumber) {
        webElementActions.input(this.userNumber, userNumber);
        return this;
    }

    public PracticeFromPage inputDateOfBirth(String dateOfBirthInput) {
        this.dateOfBirthInput.sendKeys(Keys.CONTROL + "a");
        webElementActions.scrollAndClearElements(this.dateOfBirthInput);
        webElementActions.input(this.dateOfBirthInput, dateOfBirthInput);
        this.dateOfBirthInput.sendKeys(Keys.ENTER);
        return this;
    }

    public PracticeFromPage inputSubject(String subjectsInput) {
        webElementActions.input(this.subjectsInput, subjectsInput);
        this.subjectsInput.sendKeys(Keys.ARROW_DOWN); // Перейдите к первому результату
        this.subjectsInput.sendKeys(Keys.ENTER); // Выберите первый результат
        return this;
    }

    public PracticeFromPage hobbiesCheckbox1() {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].click();", this.Sports);
        return this;
    }

    public PracticeFromPage uploadFile(WebElement element) throws InterruptedException {
        this.uploadPicture.click();
        String filePath = "/Users/amir/Desktop/Снимок экрана 2024-10-03 в 09.29.25.png";
        element.sendKeys(filePath);
        Thread.sleep(10000);
        this.uploadPicture.sendKeys(Keys.ENTER);
        //Снимок экрана 2024-10-03 в 09.29.25.png
        return this;
    }


    public PracticeFromPage currentAddress(String currentAddress) {
        webElementActions.input(this.currentAddress, currentAddress);
        this.currentAddress.sendKeys(Keys.TAB);
        return this;
    }

    public PracticeFromPage clickState(String stateName) {
        webElementActions.input(this.ncr, stateName);
        this.ncr.sendKeys(Keys.ENTER);
        this.ncr.sendKeys(Keys.TAB);
        return this;
    }

    public PracticeFromPage clickCity(String cityName) {
        webElementActions.input(this.city, cityName);
        this.city.sendKeys(Keys.TAB);
        this.city.sendKeys(Keys.ENTER);
        return this;
    }
}
