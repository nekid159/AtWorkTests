package org.example.Pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ArchievePage {
    public WebDriver driver;
    public ArchievePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
    @FindBy(xpath = "/html/body/main/div/section[5]/section[1]/ul[2]/li[1]/a/div/div/p")
    public WebElement vacNameInArcieve;
    @FindBy(xpath = "/html/body/main/div/section[5]/section[1]/ul[2]/li[1]/a/p[1]")
    public WebElement vacCityInArcieve;
    @FindBy(xpath = "/html/body/main/div/section[5]/section[1]/ul[2]/li[1]")
    public WebElement vacCardArhieve;
    @FindBy(xpath = "//li[@id=\"files-block\"]")
    private WebElement goToArchieveFiles;
    @FindBy(xpath = "//li[contains(@class, 'files-menu__item')]")
    private List<WebElement> archieveFiles;
    @FindBy(xpath = "/html/body/main/div/section[5]/section[2]/section[2]/ul/li[1]/div[1]/h2")
    public WebElement lastOfferName;
    @FindBy(xpath = "/html/body/main/div/section[5]/section[2]/section[3]/ul/li[1]/a/h2")
    public WebElement lastRecommendName;
    @FindBy(xpath = "/html/body/main/div/section[5]/section[2]/section[4]/ul/li[1]/a/h2")
    public WebElement lastTestTaskName;
    @FindBy(xpath = "/html/body/main/div/section[5]/section[2]/section[2]/ul/li[1]/div[1]/p[1]")
    public WebElement lastOffer;
    @FindBy(xpath = "/html/body/main/div/section[5]/section[2]/section[2]/ul/li[1]/div[2]/div[1]")
    public WebElement lastOfferMenu;
    @FindBy(xpath = "/html/body/main/div/section[5]/section[2]/section[3]/ul/li[1]/div/div[1]")
    public WebElement lastRecommendMenu;
    @FindBy(xpath = "/html/body/main/div/section[5]/section[2]/section[4]/ul/li[1]/div/div[1]")
    public WebElement lastTestTaskMenu;
    @FindBy(xpath = "/html/body/main/div/section[5]/section[2]/section[4]/ul/li[1]/div/div[2]/div/ul/li/p")
    public WebElement lastTestTaskDuplicate;
    @FindBy(xpath = "/html/body/main/div/section[8]/div/div[3]/button[2]")
    public WebElement testTaskConfirmDuplicate;
    @FindBy(xpath = "/html/body/main/div/section[8]/div/div[2]/div[1]/ul/li/div")
    public WebElement testTaskDuplicateVacancy;
    @FindBy(xpath = "/html/body/main/div/section[5]/section[2]/section[3]/ul/li[1]/div/div[2]/div/ul/li/p")
    public WebElement lastRecommendDuplicate;
    @FindBy(xpath = "/html/body/main/div/section[5]/section[2]/section[2]/ul/li[1]/div[2]/div[2]/div/ul/li/p")
    public WebElement lastOfferDuplicate;
    @FindBy(xpath = "/html/body/main/div/section[8]/div/div[2]/div[1]/ul/li/div/div")
    public WebElement offerDuplicateVacancy;
    @FindBy(xpath = "/html/body/main/div/section[8]/div/div[3]/button[2]")
    public WebElement offerConfirmDuplicate;
    @FindBy(xpath = "/html/body/main/div/section[5]/section[2]/section[3]/ul/li[1]/a")
    public WebElement lastRecommend;
    @FindBy(xpath = "/html/body/main/div/section[5]/section[2]/section[4]/ul/li[1]")
    public WebElement lastTestTask;
    @FindBy(xpath = "/html/body/main/div/div[1]/div[1]/span")
    public WebElement goBackToFilesArchieve;
    @FindBy(xpath = "/html/body/main/div/section[6]/div[1]/button")
    public WebElement goBackToFilesArchieve2;


    public void GoToArchieveVacancy() {
        vacCardArhieve.click();
    }
    public void GotoArchieveFiles() {
        goToArchieveFiles.click();
    }
    public void GoToArcieveOffers() {
        archieveFiles.get(0).click();
    }
    public void GoToArcieveRecommends() {
        archieveFiles.get(1).click();
    }
    public void GoToArcieveTestTasks() {
        archieveFiles.get(2).click();
    }
    public void WaitToFilesLoad() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void goBackArchieve() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", goBackToFilesArchieve);
        goBackToFilesArchieve.click();
    }
    public void goBackArchieve2() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", goBackToFilesArchieve2);
        goBackToFilesArchieve2.click();
    }
    public void DuplicateFiles() {
        GoToArcieveOffers();
        lastOfferMenu.click();
        lastOfferDuplicate.click();
        offerDuplicateVacancy.click();
        offerConfirmDuplicate.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        GoToArcieveRecommends();
        lastRecommendMenu.click();
        lastRecommendDuplicate.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        GoToArcieveTestTasks();
        lastTestTaskMenu.click();
        System.out.println(lastTestTaskDuplicate.getText());
        System.out.println(testTaskDuplicateVacancy.getText());
        System.out.println(testTaskConfirmDuplicate.getText());
        lastTestTaskDuplicate.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        testTaskDuplicateVacancy.click();
        testTaskConfirmDuplicate.click();

    }






}
