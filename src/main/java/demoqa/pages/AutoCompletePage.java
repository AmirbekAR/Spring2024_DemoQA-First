package demoqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class AutoCompletePage extends BasePage {

    @FindBy(id = "autoCompleteMultipleContainer")
    public WebElement colorClick;

    @FindBy(css = ".css-19bqh2r[height='20']")
    public WebElement clearColors;

    @FindBy(id = "autoCompleteSingleContainer")
    public WebElement singleColor;

}
