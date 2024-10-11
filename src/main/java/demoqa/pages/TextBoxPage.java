package demoqa.pages;

import demoqa.entities.TextBox;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TextBoxPage extends BasePage {


    @FindBy(id = "userName")
    public WebElement userName;

    @FindBy(id = "userEmail")
    public WebElement userEmail;

    @FindBy(id = "currentAddress")
    public WebElement currentAddress;

    @FindBy(id = "permanentAddress")
    public WebElement permanentAddress;

    @FindBy(id = "submit")
    public WebElement submit;


    @Step("Input fullName {0}")
    public TextBoxPage inputUserName(String userName) {
        webElementActions.input(this.userName, userName);
        return this;
    }
    @Step("Input user email {0}")
    public TextBoxPage inputUserEmail(String userEmail) {
        webElementActions.input(this.userEmail, userEmail);
        return this;
    }

    @Step("Input current address {0}")
    public TextBoxPage inputCurrentAddress(String currentAddress) {
        webElementActions.input(this.currentAddress, currentAddress);
        return this;
    }

    @Step("Input permanent address {0}")
    public TextBoxPage inputPermanentAddress(String permanentAddress) {
        webElementActions.input(this.permanentAddress, permanentAddress);
        return this;
    }

    @Step("Click Submit button")
    public TextBoxPage submit() {
        webElementActions.scrollToElement(this.submit).click(this.submit);
        return this;
    }

    public TextBoxPage fillTextBoxForm(TextBox textBox) { // готовый метод для ввода данных
        inputUserName(textBox.getFullName())
                .inputUserEmail(textBox.getEmail())
                .inputCurrentAddress(textBox.getCurrentAddress())
                .inputPermanentAddress(textBox.getPermanentAddress())
                .submit();
        return this;
    }
}
