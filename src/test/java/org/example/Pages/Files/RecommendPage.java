package org.example.Pages.Files;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class RecommendPage {
    public WebDriver driver;
    public RecommendPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//p[contains(@class, 'recommended')]")
    public List<WebElement> recommendedName;
    @FindBy(xpath = "//p[contains(@class, 'position')]")
    public WebElement recommendedPost;
    @FindBy(xpath = "/html/body/main/div/section[6]/div[2]/div[6]/div[4]/div[1]/span")
    public WebElement postWhoRecommends;
    @FindBy(xpath = "/html/body/main/div/section[6]/div[2]/div[6]/div[4]/div[2]/span")
    public WebElement nameWhoRecommends;


}
