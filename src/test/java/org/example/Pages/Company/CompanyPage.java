package org.example.Pages.Company;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.time.Duration;

public class CompanyPage {
    public WebDriver driver;
    public WebElement compNumber;

    public CompanyPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "//a[contains(@class, 'companies')]")
    private WebElement compContrib;
    @FindBy(xpath = "//button[contains(@class, 'company-about__button')]")
    private WebElement compMenu;
    @FindBy(xpath = "//a[contains(@class, 'company-about__actions-link--edit-company')]")
    private WebElement compEdit;
    @FindBy(xpath = "//p[contains(@class, 'company-about__start-info-desc')]")
    public WebElement compSpec;
    @FindBy(xpath = "//p[contains(@class, 'company-about__start-info-link')]")
    public WebElement compSite;
    @FindBy(xpath = "//textarea[contains(@class, 'company-about__desc')]")
    public WebElement compDescription;



    public void clickCompContrib() {
        compContrib.click();
    }
    public void goToCompMenu() {
        compMenu.click();
    }
    public void goToCompEdit() {
        compEdit.click();
    }
    public void waitingForLoad(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        WebElement btnAbout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'company-about__button')]")));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("scroll(0, 0);");

    }
    public void gettingNumber() {
      List<WebElement> elements = driver.findElements(By.className("company-about__start-info-desc"));
      compNumber = elements.get(2);
    }
    public void checkCompany() {
        Assert.assertEquals("Автомобильный бизнес", compSpec.getText());
        Assert.assertEquals("https://at-work.pro", compSite.getText());
        Assert.assertEquals("от 1000 до 5000 человек", compNumber.getText());
        Assert.assertEquals("Тестовое описание", compDescription.getText());
    }

}

