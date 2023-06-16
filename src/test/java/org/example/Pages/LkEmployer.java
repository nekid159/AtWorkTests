package org.example.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;

public class LkEmployer {
    public WebDriver driver;
    public LkEmployer(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "/html/body/main/div/section[1]/div[2]/ul[1]/a[3]")
    private WebElement files;
    @FindBy(xpath = "/html/body/main/div/section[1]/div[2]/ul[1]/a[1]/span[1]")
    private WebElement vacancies;
    public void goToFiles() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", files);
        files.click();
    }
    public void goToVacancies() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", vacancies);
        vacancies.click();
    }
}
