package org.example.Pages.Files;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecommendArchieve {
    public WebDriver driver;
    public RecommendArchieve(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "/html/body/main/div/section[6]/div[2]/div[3]/p")
    public WebElement namePostAndDate;
    @FindBy(xpath = "//span[contains(@class, 'letter-chapter__text-select')]")
    public WebElement howToRecommend;
    @FindBy(xpath = "//span[contains(@class, 'letter-chapter__text-recommending-post')]")
    public WebElement postWhoRecommends;
    @FindBy(xpath = "//span[contains(@class, 'letter-chapter__text-recommending-name')]")
    public WebElement nameWhoRecommends;
    @FindBy(xpath = "//span[contains(@class, 'letter-chapter__text-company')]")
    public WebElement company;

    public void CheckRecommendArchieve(){
        Assert.assertTrue(namePostAndDate.getText().contains("Петров Пётр Петрович"));
        Assert.assertTrue(namePostAndDate.getText().contains("Менеджер"));
        Assert.assertEquals("Я безоговорочно рекомендую", howToRecommend.getText());
        Assert.assertEquals("Главный менеджер", postWhoRecommends.getText());
        Assert.assertEquals("Олегов Олег Олегович", nameWhoRecommends.getText());
        Assert.assertEquals("СПЕЦМОНТАЖ 234", company.getText());
    }

}
