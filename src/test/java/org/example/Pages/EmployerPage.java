package org.example.Pages;
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

public class EmployerPage {
    public WebDriver driver;
    public EmployerPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "/html/body/div[1]/main/div/section[4]/section[1]/div/div[1]/button[2]")
    private WebElement newVac;
    @FindBy(xpath = "/html/body/div[1]/main/div/section[4]/section[1]/div/div[1]/button[3]")
    private WebElement allVac;
    @FindBy(xpath = "/html/body/div[1]/main/div/section[4]/section[1]/div/div[1]/button[1]")
    private WebElement hotVac;
    @FindBy(xpath = "/html/body/div[1]/main/div/section[4]/section[2]/div[3]/div[1]/input")
    private WebElement nameInput;
    @FindBy(xpath = "/html/body/div[1]/main/div/section[4]/section[2]/div[3]/div[3]/div[2]/ul/li[1]/p")
    private WebElement readyToGo;
    @FindBy(xpath = "/html/body/div[1]/main/div/section[4]/section[2]/div[3]/div[3]/div[2]/ul/li[2]/p")
    private WebElement notReadyTogo;
    @FindBy(xpath = "/html/body/div[1]/main/div/section[4]/section[2]/div[3]/div[3]/div[2]/ul/li[3]/p")
    private WebElement dontCare;
    @FindBy(xpath = "/html/body/div[1]/main/div/section[4]/section[2]/div[3]/div[4]/div[1]/div[1]/div[1]/input")
    private WebElement salaryFrom;
    @FindBy(xpath = "/html/body/div[1]/main/div/section[4]/section[2]/div[3]/div[4]/div[1]/div[1]/div[2]/input")
    private WebElement salaryTo;
    @FindBy(xpath = "/html/body/div[1]/main/div/section[4]/section[2]/div[3]/div[5]/div[2]/ul/li[1]/div")
    private WebElement noExp;
    @FindBy(xpath = "/html/body/div[1]/main/div/section[4]/section[2]/div[3]/div[5]/div[2]/ul/li[2]/div")
    private WebElement fromOnetoThree;
    @FindBy(xpath = "/html/body/div[1]/main/div/section[4]/section[2]/div[3]/div[5]/div[2]/ul/li[3]/div")
    private WebElement fromThreetoSix;
    @FindBy(xpath = "/html/body/div[1]/main/div/section[4]/section[2]/div[3]/div[5]/div[2]/ul/li[4]/div")
    private WebElement moreThenSix;
    @FindBy(xpath = "/html/body/div[1]/main/div/section[4]/section[2]/div[3]/button")
    private WebElement applyBtn;
    @FindBy(xpath = "/html/body/div[1]/main/div/section[4]/section[2]/div[3]/div[2]/div[2]/div/ul/li[1]/div")
    private WebElement mscSearch;
    @FindBy(xpath = "/html/body/div[1]/main/div/section[4]/section[2]/div[3]/div[2]/div[2]/div/ul/li[2]/div")
    private WebElement spbSearch;
    @FindBy(xpath = "/html/body/div[1]/main/div/section[4]/section[1]/section[1]/ul/li[1]")
    public WebElement firstCard;
    @FindBy(xpath = "/html/body/div[1]/main/div/section[4]/section[1]/section[1]/ul/li[2]")
    public WebElement secondCard;
    @FindBy(xpath = "/html/body/div[1]/main/div/section[4]/section[1]/section[1]/ul/li[3]")
    public WebElement thirdCard;
    @FindBy(xpath = "/html/body/div[1]/main/div/section[3]/div/div[2]/div/div/div/div[1]")
    private WebElement test;
    @FindBy(xpath = "//*[@id=\"row\"]")
    private WebElement vacCardFull;
    @FindBy(xpath = "//*[@id=\"cell\"]")
    private WebElement vacCardShort;
    @FindBy(xpath = "/html/body/div[1]/main/div/section[4]/section[2]/div[3]/div[18]/button[1]")
    private WebElement resetBtn;
    @FindBy(xpath = "//p[contains(@class, 'filters__checkbox-item-text--type--gender')]")
    public List<WebElement> gender;
    @FindBy(xpath = "/html/body/div[1]/main/div/section[4]/section[2]/div[3]/div[7]/div[2]/div/div/div[1]/input")
    private WebElement ageFrom;
    @FindBy(xpath = "/html/body/div[1]/main/div/section[4]/section[2]/div[3]/div[7]/div[2]/div/div/div[2]/input")
    private WebElement ageTo;




    public void goAndClickApply() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", applyBtn);
        //applyBtn.click();
    }
    public void checkCity() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        int elementHeight = ((Number) jsExecutor.executeScript("return arguments[0].offsetHeight;", spbSearch)).intValue();
        int windowHeight = ((Number) jsExecutor.executeScript("return window.innerHeight;")).intValue();
        int scrollPosition = ((Number) jsExecutor.executeScript("return window.scrollY;")).intValue();
        int middle = scrollPosition + (windowHeight / 2) - (elementHeight / 2);
        jsExecutor.executeScript("window.scrollTo(0, arguments[0]);", middle);
        mscSearch.click();
        spbSearch.click();
    }
    public void goToAll() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", test);
        allVac.click();
    }
    public void changeCardToFull() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", vacCardFull);
        vacCardFull.click();
    }
    public void changeCardToShort() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", vacCardShort);
        vacCardShort.click();
    }
    public void goToExpNoExp(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", noExp);
        noExp.click();
    }
    public void goToExpThreeToSix(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", noExp);
        noExp.click();
        fromThreetoSix.click();
    }
    public void waitingForCardsLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        WebElement parentElement = driver.findElement(By.xpath("/html/body/div[1]/main/div/section[4]/section[1]/section[1]/ul"));
        wait.until(ExpectedConditions.stalenessOf(parentElement.findElement(By.xpath("/html/body/div[1]/main/div/section[4]/section[1]/section[1]/ul/li"))));
        wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(parentElement, By.xpath("/html/body/div[1]/main/div/section[4]/section[1]/section[1]/ul/li[1]")));
    }
    public void goToReset() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", resetBtn);
        resetBtn.click();
    }
    public void ageInput() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", ageFrom);
        ageFrom.sendKeys("20");
        ageTo.sendKeys("40");
    }






}
