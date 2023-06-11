package org.example.Pages.Files;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestTaskCreatePage {
    public WebDriver driver;
    public TestTaskCreatePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//input[contains(@id, 'vacancy')]")
    private WebElement vacancy;
    @FindBy(xpath = "/html/body/main/div/section[5]/div[2]/div[2]/form/div[1]/div[1]/div/div[2]/div/ul/li[1]")
    private WebElement currentVacancy;
    @FindBy(xpath = "//input[contains(@id, 'description')]")
    private WebElement description;
    @FindBy(xpath = "//input[contains(@id, 'link')]")
    private WebElement link;
    @FindBy(xpath = "//input[contains(@id, 'format')]")
    private WebElement format;
    @FindBy(xpath = "//input[contains(@id, 'date')]")
    private WebElement date;

    public void CreatingTestTask() {
        vacancy.click();
        currentVacancy.click();
        description.sendKeys("Придётся много тестировать");
        link.sendKeys("https://www.google.ru");
        format.sendKeys("pdf");
        date.click();
        date.sendKeys("20.10.2024");
    }
}
