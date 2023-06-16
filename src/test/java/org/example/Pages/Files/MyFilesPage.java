package org.example.Pages.Files;

import org.example.Pages.LkEmployer;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class MyFilesPage {
    public WebDriver driver;
    public static LkEmployer lkEmployer;
    public static MyFilesPage myFilesPage;

    public MyFilesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//button[contains(@data-id, 'job-offer-page')]")
    public WebElement jobOfferPage;
    @FindBy(xpath = "//button[contains(@data-id, 'recommendation-letters-page')]")
    public WebElement recommendationLetterPage;
    @FindBy(xpath = "//button[contains(@data-id, 'test-tasks-page')]")
    public WebElement testTaskPage;
    @FindBy(xpath = "//button[contains(@class, 'create_a_new_letter')]")
    private WebElement createFile;
    @FindBy(xpath = "/html/body/main/div/section[5]/div/div[1]/div[1]/ul/a[1]")
    private WebElement createOffer;
    @FindBy(xpath = "/html/body/main/div/section[5]/div/div[1]/div[1]/ul/a[2]")
    private WebElement createRecommend;
    @FindBy(xpath = "/html/body/main/div/section[5]/div/div[1]/div[1]/ul/a[3]")
    private WebElement createTestTask;
    @FindBy(xpath = "/html/body/main/div/section[5]/div/div[3]/div[2]/div[2]/div/div[2]/div")
    public WebElement firstOffer;
    @FindBy(xpath = "//button[contains(@class, 'open-preview')]")
    public List<WebElement> filePreview;
    @FindBy(xpath = "/html/body/main/div/section[5]/div/div[3]/div[2]/div[2]/div/div[2]/div/p")
    public WebElement offerName;
    @FindBy(xpath = "/html/body/main/div/section[5]/div/div[3]/div[3]/div[2]/div/div[2]/div/p")
    public WebElement recommendName;
    @FindBy(xpath = "/html/body/main/div/section[5]/div/div[3]/div[4]/div[2]/div/div[2]/div/p")
    public WebElement testTaskName;

    @FindBy(xpath = "//button[contains(@class, 'letter__item-delete')]")
    public List<WebElement> fileDelete;
    @FindBy(xpath = "//button[contains(@class, 'delete')]")
    public List<WebElement> confirmDelete;
    @FindBy(xpath = "/html/body/main/div/section[5]/div/div[3]/div[2]/div[1]/h6")
    public WebElement offerPass;
    @FindBy(xpath = "/html/body/main/div/section[5]/div/div[3]/div[4]/div[1]/h6")
    public WebElement testTaskPass;
    public void goToCreateOffer() {
        createFile.click();
        createOffer.click();
    }
    public void goToCreateRecommend() {
        createFile.click();
        createRecommend.click();
    }
    public void goToCreateTest() {
        createFile.click();
        createTestTask.click();
    }
    public void waitForOffersLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.elementToBeClickable(firstOffer));
    }
    public void deletingFiles() {
        testTaskPage.click();
        fileDelete.get(2).click();
        confirmDelete.get(3).click();
        recommendationLetterPage.click();
        fileDelete.get(1).click();
        confirmDelete.get(2).click();
        jobOfferPage.click();
        fileDelete.get(0).click();
        confirmDelete.get(1).click();
    }
    public void checkFilesAfterDelete() {
        lkEmployer = new LkEmployer(driver);
        myFilesPage = new MyFilesPage(driver);
        lkEmployer.goToFiles();
        myFilesPage.jobOfferPage.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals("Тестировщик", myFilesPage.offerName.getText());
        myFilesPage.recommendationLetterPage.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals("Петров Пётр Петрович", myFilesPage.recommendName.getText());
        myFilesPage.testTaskPage.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals("Тестировщик", myFilesPage.testTaskName.getText());
    }
    public void checkFilesAfterDeleteWithVacancy() {
        myFilesPage.jobOfferPage.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals("Пока нет созданных", myFilesPage.offerPass.getText());
        myFilesPage.recommendationLetterPage.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals("Петров Пётр Петрович", myFilesPage.recommendName.getText());
        myFilesPage.testTaskPage.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals("Пока нет созданных", myFilesPage.testTaskPass.getText());
    }


}
