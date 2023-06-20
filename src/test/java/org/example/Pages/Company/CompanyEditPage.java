package org.example.Pages.Company;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CompanyEditPage {
    public WebDriver driver;

    public CompanyEditPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
    @FindBy(xpath = "//button[contains(@class, 'company-create__button--create')]")
    private WebElement goOnBtn;
    @FindBy(xpath = "//input[@id=\"newCompanySpecialization\"]")
    private WebElement companyShortDescription;
    @FindBy(xpath = "//input[@id=\"newCompanySite\"]")
    private WebElement companySite;
    @FindBy(xpath = "//button[contains(@class, 'company-create__industry-selector')]")
    private WebElement companyIndustry;
    @FindBy(xpath = "//span[contains(@class, 'company-specialization__input-icon')]")
    private WebElement companySpecialization;
    @FindBy(xpath = "//button[contains(@class, 'company-specialization__button--confirm')]")
    private WebElement specConfirmBtn;
    @FindBy(xpath = "//button[contains(@class, 'company-create__button-choose-number')]")
    private WebElement peopleNumber;
    @FindBy(xpath = "//p[text()='от 1000 до 5000 человек']")
    private WebElement peopleNumber1000;
    @FindBy(xpath = "//p[text()='1 человек']")
    private WebElement peopleNumber1;
    @FindBy(xpath = "//textarea[@id=\"newCompanyDesc\"]")
    private WebElement textArea;
    @FindBy(xpath = "//button[contains(@class, 'company-create__button company-create__button--save')]")
    private WebElement goOnAgain;
    @FindBy(xpath = "//button[contains(@class, 'company-create__button--submit')]")
    private WebElement submitBtn;

    public void nextPageCompany(){
        goOnBtn.click();
    }
    public void descriptionEdit(){
        companyShortDescription.sendKeys("Тестовое описание");
    }
    public void shortDescriptionClear() {
        companyShortDescription.clear();
    }
    public void siteEdit(){
        companySite.sendKeys("https://at-work.pro");
    }
    public void siteClear(){
        companySite.clear();
    }
    public void specializationChoose(){
        companyIndustry.click();
        companySpecialization.click();
        specConfirmBtn.click();
    }
    public void numberChoose(){
        peopleNumber.click();
        peopleNumber1000.click();
    }
    public void numberClear(){
        peopleNumber.click();
        peopleNumber1.click();
    }
    public void textAreaEdit(){
        textArea.sendKeys("Тестовое описание");
    }
    public void textAreaClear(){
        textArea.clear();
    }
    public void nextPageAgain(){
        goOnAgain.click();
    }
    public void submitCompany(){
        submitBtn.click();
    }
    public void editCompany() {
        nextPageCompany();
        descriptionEdit();
        siteEdit();
        specializationChoose();
        numberChoose();
        textAreaEdit();
        nextPageAgain();
        submitCompany();
    }
    public void clearCompany() {
        nextPageCompany();
        shortDescriptionClear();
        siteClear();
        specializationChoose();
        numberClear();
        textAreaClear();
        nextPageAgain();
        submitCompany();
    }


}
