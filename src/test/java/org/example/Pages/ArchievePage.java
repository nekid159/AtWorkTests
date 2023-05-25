package org.example.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public void GoToArchieveVacancy() {
        vacCardArhieve.click();
    }




}
