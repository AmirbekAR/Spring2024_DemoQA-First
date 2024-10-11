package demoqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertPage extends BasePage{

    @FindBy(id = "alertButton")
    public WebElement alertButton;

}
