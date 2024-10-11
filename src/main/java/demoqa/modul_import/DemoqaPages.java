package demoqa.module_import;

import demoqa.entities.WebTables;
import demoqa.pages.*;

public class DemoqaPages {

    public TextBoxPage textBoxPage;
    public ButtonPage buttonsPage;
    public BrowserWindowPage browserWindowsPage;
    public AlertPage alertPage;
    public SelectMenuPage selectMenuPage;
    public FramesPage framesPage;
    public MenuPages menuPages;
    public AccordianPage accordianPage;
    public AutoCompletePage autoCompletePage;
    public PracticeFormPage2 practiceFormPage2;
    public WebTablesPage webTablesPage;
    public AmazonPage amazonPage;


    public DemoqaPages() {
        textBoxPage = new TextBoxPage();
        buttonsPage = new ButtonPage();
        browserWindowsPage = new BrowserWindowPage();
        alertPage = new AlertPage();
        selectMenuPage = new SelectMenuPage();
        framesPage = new FramesPage();
        menuPages = new MenuPages();
        accordianPage = new AccordianPage();
        autoCompletePage = new AutoCompletePage();
        practiceFormPage2 = new PracticeFormPage2();
        webTablesPage = new WebTablesPage();
        amazonPage = new AmazonPage();
    }

    public WebTablesPage getWebTablesPage() {
        return webTablesPage;
    }

    public AmazonPage getAmazonPage() {
        return amazonPage;
    }

    public PracticeFormPage2 getPracticeFormPage2() {
        return practiceFormPage2;
    }

    public AutoCompletePage getAutoCompletePage() {
        return autoCompletePage;
    }

    public AccordianPage getAccordianPage() {
        return accordianPage;
    }

    public MenuPages getMenuPages() {
        return menuPages;
    }

    public TextBoxPage getTextBoxPage() {
        return textBoxPage;
    }

    public ButtonPage getButtonsPage() {
        return buttonsPage;
    }

    public BrowserWindowPage getBrowserWindowsPage() {
        return browserWindowsPage;
    }

    public AlertPage getAlertPage() {
        return alertPage;
    }

    public SelectMenuPage getSelectMenuPage() {
        return selectMenuPage;
    }

    public FramesPage getFramesPage() {
        return framesPage;
    }
}

