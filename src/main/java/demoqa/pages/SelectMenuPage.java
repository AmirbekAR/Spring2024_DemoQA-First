package demoqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SelectMenuPage extends BasePage {

    @FindBy(id = "oldSelectMenu")
    public WebElement oldStyleSelectMenu;



    @FindBy(id = "withOptGroup")
    public WebElement selectValueMenu;

    @FindBy(id = "react-select-2-option-0-0")
    public WebElement getGroup1option1;

    @FindBy(id = "react-select-2-option-0-1")
    public WebElement getGroup1option2;

    @FindBy(id = "react-select-2-option-1-0")
    public WebElement getGroup2option1;

    @FindBy(id = "react-select-2-option-1-1")
    public WebElement getGroup2option2;

//    @FindBy(xpath = "//div[contains(@class, 'css-1uccc91-singleValue') and text()='Group 2, option 2']")
//    public WebElement getGroup2option2;

    @FindBy(id = "react-select-2-option-2")
    public WebElement getARootOption;

    @FindBy(id = "react-select-2-option-3")
    public WebElement getAnotherRootOption;

    public List<WebElement> selectValue () {
        List<WebElement> elementList = new ArrayList<>();
        elementList.add(getGroup1option1);
        elementList.add(getGroup1option2);
        elementList.add(getGroup2option1);
        elementList.add(getGroup2option2);
        elementList.add(getARootOption);
        elementList.add(getAnotherRootOption);
        return elementList;
    }



    // For 'Select One' dropdown options
    @FindBy(id = "selectOne")
    public WebElement selectOne;

    @FindBy(id = "react-select-3-option-0-0")
    public WebElement Dr;

    @FindBy(id = "react-select-3-option-0-1")
    public WebElement Mr;

    @FindBy(id = "react-select-3-option-0-2")
    public WebElement Mrs;

    @FindBy(id = "react-select-3-option-0-3")
    public WebElement Ms;

    @FindBy(id = "react-select-3-option-0-4")
    public WebElement Prof;

    @FindBy(id = "react-select-3-option-0-5")
    public WebElement Other;


    public List<WebElement> getSelectOneOptions() {
        List<WebElement> options = new ArrayList<>();
        options.add(Dr);
        options.add(Mr);
        options.add(Mrs);
        options.add(Ms);
        options.add(Prof);
        options.add(Other);

        return options;
    }


    //Multiselect drop down

    @FindBy(xpath = "(//div[contains(@class,'css-2b097c-container')])[3]")
    public WebElement clickMulti;

    @FindBy(id="react-select-4-option-0")
    public WebElement Green;

    @FindBy(id ="react-select-4-option-1")
    public WebElement Blue;

    @FindBy(id="react-select-4-option-2")
    public WebElement Black;

    @FindBy(id="react-select-4-option-3")
    public WebElement Red;

    public List<WebElement> multiDropDown() {
        List<WebElement> options = new ArrayList<>();
        options.add(Green);
        options.add(Blue);
        options.add(Black);
        options.add(Red);
        return options;
    }

    // Standard multi select

    @FindBy(xpath = "//select[@id='cars']")
    public WebElement cars;

    @FindBy(xpath = "//option[@value='volvo']")
    public WebElement Volvo;

    @FindBy(xpath = "//option[@value='saab']")
    public WebElement Saab;

    @FindBy(xpath = "//option[@value='opel']")
    public WebElement Opel;

    @FindBy(xpath = "//option[@value='audi']")
    public WebElement Audi;

    public List<WebElement> standardMultiSelect(){
        List<WebElement> listCars = new ArrayList<>();
        listCars.add(Volvo);
        listCars.add(Saab);
        listCars.add(Opel);
        listCars.add(Audi);
        return listCars;
    }
  }
