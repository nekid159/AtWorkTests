package org.example.Pages.Files;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RecommendCreatePage {
    public WebDriver driver;
    public RecommendCreatePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//input[contains(@name, 'city')]")
    private WebElement city;
    @FindBy(xpath = "//input[contains(@name, 'recommended')]")
    private WebElement nameToRecommend;
    @FindBy(xpath = "//input[contains(@name, 'position')]")
    private WebElement post;
    @FindBy(xpath = "//input[contains(@name, 'period__from')]")
    private WebElement periodFrom;
    @FindBy(xpath = "//input[contains(@name, 'period__to')]")
    private WebElement periodTo;
    @FindBy(xpath = "//input[contains(@name, 'recommending-post')]")
    private WebElement postWhoRecommends;
    @FindBy(xpath = "//input[contains(@name, 'recommending-name')]")
    private WebElement nameWhoRecommends;
    @FindBy(xpath = "//button[contains(@class, 'next')]")
    private List<WebElement> nextBtn;
    @FindBy(xpath = "//button[contains(@class, 'save')]")
    private List<WebElement> saveBtn;
    public void CreatingRecommendationLetter() {
        city.sendKeys("Москва");
        nameToRecommend.sendKeys("Петров Пётр Петрович");
        post.sendKeys("Менеджер");
        periodFrom.click();
        periodFrom.sendKeys("20.03.2017");
        periodTo.click();
        periodTo.sendKeys("15.07.2020");
        nextBtn.get(0).click();
        nextBtn.get(1).click();
        postWhoRecommends.sendKeys("Главный менеджер");
        nameWhoRecommends.sendKeys("Олегов Олег Олегович");
        saveBtn.get(1).click();

    }

}
