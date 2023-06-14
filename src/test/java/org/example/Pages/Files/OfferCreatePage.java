package org.example.Pages.Files;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;
import java.util.List;

public class OfferCreatePage {
    public WebDriver driver;
    public OfferCreatePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "/html/body/main/div/section[5]/div/div[2]/form/div[1]/div[1]/input")
    private WebElement nameCandidateOffer;
    @FindBy(xpath = "/html/body/main/div/section[5]/div/div[2]/form/div[1]/div[2]/div/p")
    private WebElement vacToOffer;
    @FindBy(xpath = "/html/body/main/div/section[5]/div/div[2]/form/div[1]/div[2]/div/div/label[2]/p")
    private WebElement chooseVacToOffer;
    @FindBy(xpath = "/html/body/main/div/section[5]/div/div[2]/form/div[1]/div[3]/input")
    private WebElement offerName;
    @FindBy(xpath = "/html/body/main/div/section[5]/div/div[2]/form/div[1]/div[4]/input")
    private WebElement offerBoss;
    @FindBy(xpath = "/html/body/main/div/section[5]/div/div[2]/form/div[1]/div[5]/textarea")
    private WebElement offerDesc;
    @FindBy(xpath = "//button[contains(@class, 'next')]")
    private List<WebElement> nextBtn;
    @FindBy(xpath = "//input[contains(@name, 'salary')]")
    private WebElement salaryInput;
    @FindBy(xpath = "//input[contains(@name, 'contact-name')]")
    private WebElement contactInput;
    @FindBy(xpath = "//input[contains(@name, 'contact-post')]")
    private WebElement postInput;
    @FindBy(xpath = "//input[contains(@name, 'contact-tel')]")
    private WebElement numberInput;
    @FindBy(xpath = "//input[contains(@name, 'contact-mail')]")
    private WebElement emailInput;
    @FindBy(xpath = "//input[contains(@name, 'response-calendar')]")
    private WebElement calendarInput;
    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div[2]/div/span[32]")
    private WebElement nextDate;
    @FindBy(xpath = "//button[contains(@class, 'save')]")
    private List<WebElement> saveBtn;



    public void createOffer() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        nameCandidateOffer.sendKeys("Сергей Сергеевич");
        vacToOffer.click();
        chooseVacToOffer.click();
        offerName.sendKeys("Грузчика");
        offerBoss.sendKeys("Главного грузчика");
        offerDesc.sendKeys("Грузить, грузить и ещё раз грузить");
        nextBtn.get(0).click();
        nextBtn.get(1).click();
        salaryInput.sendKeys("12345");
        jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", nextBtn.get(2));
        nextBtn.get(2).click();
        nextBtn.get(3).click();
        nextBtn.get(4).click();
        jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", saveBtn.get(1));
        contactInput.sendKeys("Игорь Игорьевич");
        postInput.sendKeys("Главнейший грузчик");
        numberInput.click();
        numberInput.sendKeys("9991231212");
        emailInput.sendKeys("gruzchik@mail.gruz");
        calendarInput.click();
        nextDate.click();
        saveBtn.get(1).click();
    }

}

