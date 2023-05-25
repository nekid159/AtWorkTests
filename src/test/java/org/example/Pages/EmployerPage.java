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
    @FindBy(xpath = "/html/body/div[1]/main/div/section[4]/section[2]/div[1]/h2")
    private WebElement vacProfBtn;
    @FindBy(xpath = "/html/body/div[1]/section[4]/div/ul/li[7]/div/p")
    private WebElement vacProf1;
    @FindBy(xpath = "/html/body/div[1]/section[4]/div/ul/li[13]/div/p")
    private WebElement vacProf2;
    @FindBy(xpath = "/html/body/div[1]/section[4]/div/div/button[3]")
    private WebElement ProfToSpec;
    @FindBy(xpath = "/html/body/div[1]/section[5]/div/ul/li[4]/div")
    private WebElement vacSpec1;
    @FindBy(xpath = "/html/body/div[1]/section[5]/div/ul/li[2]/div")
    private WebElement vacSpec2;
    @FindBy(xpath = "/html/body/div[1]/section[5]/div/div[2]/button[2]")
    private WebElement searchSpec;
    @FindBy(xpath = "/html/body/div[1]/main/div/section[4]/section[2]/div[2]/div[3]/ul/li/p[1]")
    private WebElement specValue;
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
        JavascriptExecutor jsExecutor2 = (JavascriptExecutor) driver;
        jsExecutor2.executeScript("arguments[0].scrollIntoView({block: 'center'});", vacCardFull);

        vacCardFull.click();
    }
    public void goToExpNoExp(){
        JavascriptExecutor jsExecutor3 = (JavascriptExecutor) driver;
        jsExecutor3.executeScript("arguments[0].scrollIntoView({block: 'center'});", noExp);
        noExp.click();
    }
    public void goToExpThreeToSix(){
        JavascriptExecutor jsExecutor3 = (JavascriptExecutor) driver;
        jsExecutor3.executeScript("arguments[0].scrollIntoView({block: 'center'});", noExp);
        noExp.click();
        fromThreetoSix.click();
    }
    public void waitingForCardsLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        WebElement parentElement = driver.findElement(By.xpath("/html/body/div[1]/main/div/section[4]/section[1]/section[1]/ul"));
        wait.until(ExpectedConditions.stalenessOf(parentElement.findElement(By.xpath("/html/body/div[1]/main/div/section[4]/section[1]/section[1]/ul/li"))));
        wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(parentElement, By.xpath("/html/body/div[1]/main/div/section[4]/section[1]/section[1]/ul/li[1]")));
    }





}
