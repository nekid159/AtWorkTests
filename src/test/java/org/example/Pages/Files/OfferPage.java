package org.example.Pages.Files;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class OfferPage {
    public WebDriver driver;

    public OfferPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "/html/body/main/div/section[7]/div[2]/div[3]/div/p/span")
    public WebElement candidateName;
    @FindBy(xpath = "/html/body/main/div/section[7]/div[2]/div[3]/div[2]/p/span[2]")
    public WebElement vacancy;
    @FindBy(xpath = "/html/body/main/div/section[7]/div[2]/div[3]/div[3]/p/span")
    public WebElement vacancyBoss;
    @FindBy(xpath = "/html/body/main/div/section[7]/div[2]/div[3]/div[4]/div/textarea")
    public WebElement vacancyDesc;
    @FindBy(xpath = "/html/body/main/div/section[7]/div[2]/div[5]/div[1]/p/span")
    public WebElement salary;
    @FindBy(xpath = "/html/body/main/div/section[7]/div[2]/div[10]/div[1]/p/span")
    public WebElement contactGuy;
    @FindBy(xpath = "/html/body/main/div/section[7]/div[2]/div[10]/div[2]/p/span")
    public WebElement post;
    @FindBy(xpath = "/html/body/main/div/section[7]/div[2]/div[10]/div[3]/p/span")
    public WebElement companyName;
    @FindBy(xpath = "/html/body/main/div/section[7]/div[2]/div[10]/div[4]/p/span")
    public WebElement contactEmail;
    @FindBy(xpath = "/html/body/main/div/section[7]/div[2]/div[10]/div[5]/p/span")
    public WebElement contactNumber;





}
