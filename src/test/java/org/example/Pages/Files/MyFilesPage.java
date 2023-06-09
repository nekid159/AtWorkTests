package org.example.Pages.Files;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class MyFilesPage {
    public WebDriver driver;

    public MyFilesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//button[contains(@data-id, 'job-offer-page')]")
    private WebElement jobOfferPage;
    @FindBy(xpath = "//button[contains(@data-id, 'recommendation-letters-page')]")
    private WebElement recommendationLetterPage;
    @FindBy(xpath = "//button[contains(@data-id, 'test-tasks-page')]")
    private WebElement testTaskPage;
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
    public WebElement offerPreview;
    @FindBy(xpath = "/html/body/main/div/section[5]/div/div[3]/div[2]/div[2]/div/div[2]/div/p")
    public WebElement offerName;
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
    public void openOfferPreview() {
        offerPreview.click();
    }

}
