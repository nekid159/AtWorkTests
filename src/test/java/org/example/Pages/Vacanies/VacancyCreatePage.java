package org.example.Pages.Vacanies;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.Keys;

public class VacancyCreatePage {
    public WebDriver driver;
    public static WebElement enterVacName;
    public String vacDescriptionText;
    public VacancyCreatePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
    @FindBy(xpath = "//input[@id=\"js-cityField\"]")
    private WebElement vacCityInput;
    @FindBy(xpath = "//p[contains(@data-city, 'Москва')]")
    private WebElement vacCityMoscow;
    @FindBy(xpath = "//button[contains(@class, 'text-s14-h20-w500')]")
    private WebElement regNextBtn;
    @FindBy(xpath = "/html/body/main/div/div[2]/section[1]/div[2]/div[1]/input")
    private WebElement nameVacInput;
    @FindBy(xpath = "//p[contains(@class, 'specialisation__change-btn')]")
    private WebElement vacSpecBtn;
    @FindBy(xpath = "//button[contains(@class, 'next')]")
    private List<WebElement> nextBtns;
    @FindBy(xpath = "//p[contains(@data-value, '8358')]")
    private WebElement vacSpecChoose;
    @FindBy(xpath = "//button[contains(@class, 'save')]")
    private List<WebElement> vacProfSaveBtns;
    @FindBy(xpath = "/html/body/main/div/div[2]/section[1]/div[2]/div[4]/div[3]/div[1]")
    private WebElement vacDescription;
    @FindBy(xpath = "//button[@id=\"step-2\"]")
    private WebElement stepTwoBtn;
    @FindBy(xpath = "//button[@id=\"publish-free\"]")
    private WebElement publishVacFreeBtn;
    @FindBy(xpath = "//label[contains(@class, 'agreement')]")
    private WebElement agreeCheckbox;

    public void addVacCity() {
        vacCityInput.sendKeys("Москва");
        vacCityMoscow.click();}
    public void GoMain() {
        regNextBtn.click();
    }
    public void addVacName() {
        nameVacInput.click();
        nameVacInput.sendKeys("Работничек");
    }
    public void editVacName() {
        nameVacInput.click();
        nameVacInput.clear();
        nameVacInput.sendKeys("Чудо работник");
    }
    public void editVacNameAgain() {
        nameVacInput.click();
        nameVacInput.clear();
        nameVacInput.sendKeys("Тестировщик");
    }


    public void addSpec() {
        StringBuilder sb = new StringBuilder(151);
        Random random = new Random();

        for (int i = 0; i < 151; i++) {
            char c = (char)(random.nextInt(26) + 'a');
            sb.append(c);
        }
        vacDescriptionText = sb.toString();
        vacSpecBtn.click();
        WebElement prof = driver.findElement(By.xpath("//li[@title='Автомобильный бизнес']"));
        prof.click();
        nextBtns.get(7).click();
        vacSpecChoose.click();
        vacProfSaveBtns.get(1).click();

        vacDescription.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        vacDescription.sendKeys(Keys.DELETE);
        vacDescription.sendKeys(sb);
    }
    public void saveVac() {
        stepTwoBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.attributeToBe(By.cssSelector(".main__wrapper"), "class", "main__wrapper"));
        nextBtns.get(2).click();
        wait.until(ExpectedConditions.attributeToBe(By.cssSelector(".main__wrapper"), "class", "main__wrapper"));
        nextBtns.get(3).click();
        wait.until(ExpectedConditions.attributeToBe(By.cssSelector(".main__wrapper"), "class", "main__wrapper"));
        nextBtns.get(4).click();
        wait.until(ExpectedConditions.attributeToBe(By.cssSelector(".main__wrapper"), "class", "main__wrapper"));
        nextBtns.get(5).click();
        wait.until(ExpectedConditions.attributeToBe(By.cssSelector(".main__wrapper"), "class", "main__wrapper"));
        nextBtns.get(6).click();
        wait.until(ExpectedConditions.attributeToBe(By.cssSelector(".main__wrapper"), "class", "main__wrapper"));
        agreeCheckbox.click();
        publishVacFreeBtn.click();
    }

}

