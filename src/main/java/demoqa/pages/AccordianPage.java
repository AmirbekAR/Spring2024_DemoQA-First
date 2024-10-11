package demoqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccordianPage extends BasePage {

    @FindBy(id = "section1Heading")
    public WebElement loremIpsum;

    @FindBy(id = "section2Heading")
    public WebElement comeFrom;

    @FindBy(id = "section3Heading")
    public WebElement useIt;


}
