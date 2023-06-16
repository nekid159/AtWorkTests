package org.example.Pages.Vacanies;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class MyVacanciesPage {
    public WebDriver driver;
    public MyVacanciesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
    @FindBy(xpath = "//a[contains(@class, 'plug-desktop__btn--type--new')]")
    private WebElement vacCreateBtn;
    @FindBy(xpath = "//span[contains(@class, 'card-active__title-name')]")
    public WebElement vacName;
    @FindBy(xpath = "//p[contains(@class, 'card-active__place')]")
    public WebElement vacCity;
    @FindBy(xpath = "/html/body/main/div/section[5]/section[3]/ul/li/div[2]/div/div/div[1]")
    public WebElement vacMenu;
    @FindBy(xpath = "/html/body/main/div/section[5]/section[3]/ul/li/div[2]/div/div/div[2]/div/ul/li[2]/a")
    public WebElement vacEdit;
    @FindBy(xpath = "/html/body/main/div/section[5]/section[3]/ul/li/div[2]/div/div/div[2]/div/ul/li[3]")
    public WebElement vacArch;

    @FindBy(xpath = "/html/body/main/div/section[5]/section[3]/ul/li/div[1]/a")
    public WebElement vacCard;
    @FindBy(xpath = "/html/body/main/div/section[11]/div[2]/div[1]/ul/li[2]/p")
    public WebElement anotherResource;
    @FindBy(xpath = "/html/body/main/div/section[11]/div[2]/div[1]/ul/li[3]/p")
    public WebElement anotherReason;
    @FindBy(xpath = "/html/body/main/div/section[11]/div[2]/div[1]/ul/li[1]/p")
    public WebElement foundHere;
    @FindBy(xpath = "/html/body/main/div/section[11]/div[2]/div[2]/button[2]")
    public WebElement sendVac;



    public void clickVacCreateBtn() {
        vacCreateBtn.click(); }

    public void waitToLoadVacancies() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement newResume = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class, 'new-resume__link')]")));
    }
    public void goToVacEdit() {
        vacMenu.click();
        vacEdit.click();
    }
    public void sendVacToArchive() {
        vacMenu.click();
        vacArch.click();
        anotherResource.click();
        anotherReason.click();
        foundHere.click();
        sendVac.click();
    }
    public void goTocard() {
        vacCard.click();
    }

}