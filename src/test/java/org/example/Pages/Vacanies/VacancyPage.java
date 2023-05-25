package org.example.Pages.Vacanies;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class VacancyPage {
    public WebDriver driver;
    public VacancyPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
    @FindBy(xpath = "/html/body/main/section/section/section[1]/div/div[2]/div/h2/span")
    public WebElement vacNamePage;
    @FindBy(xpath = "/html/body/main/section/section/section[1]/div/div[2]/div/p[2]")
    public WebElement vacCityPage;
    @FindBy(xpath = "//*[@id=\"description-text\"]")
    public WebElement vacDescPage;
}
