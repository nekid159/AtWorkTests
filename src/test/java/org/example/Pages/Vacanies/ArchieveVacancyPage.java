package org.example.Pages.Vacanies;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ArchieveVacancyPage {
    public WebDriver driver;
    public ArchieveVacancyPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
    @FindBy(xpath = "/html/body/main/section/section/section[1]/div/div/div/h2/span")
    public WebElement vacNameInArcieve;
    @FindBy(xpath = "/html/body/main/section/section/section[1]/div/div/div/p[2]")
    public WebElement vacCityInArcieve;
    @FindBy(xpath = "//*[@id=\"description-text\"]")
    public WebElement vacDescriptionInArcieve;
    @FindBy(xpath = "/html/body/main/section/section/section[1]/div/div/div/p[1]")
    public WebElement inArchieve;
    @FindBy(xpath = "//*[@id=\"publish-again\"]")
    public WebElement publishAgainBtn;
    @FindBy(xpath = "/html/body/main/section/section/section[3]/div[2]/div/div[2]/h5")
    public WebElement changeStory;

    public void getVacBack() {
        publishAgainBtn.click();
    }



}
