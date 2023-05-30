package org.example.Pages.Files;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.module.ModuleDescriptor;
import java.time.Duration;
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

    public void createOffer() {
        nameCandidateOffer.sendKeys("Сергей Сергеевич");
        vacToOffer.click();
        chooseVacToOffer.click();
        offerName.sendKeys("Грузчика");
        offerBoss.sendKeys("Главного грузчика");
        offerDesc.sendKeys("Грузить, грузить и ещё раз грузить");
    }

}

