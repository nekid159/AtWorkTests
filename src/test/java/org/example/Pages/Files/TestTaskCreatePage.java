package org.example.Pages.Files;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.util.Locale;

public class TestTaskCreatePage {
    public WebDriver driver;
    public SimpleDateFormat outputFormat;
    private String outputDate;
    public TestTaskCreatePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        outputFormat = new SimpleDateFormat("dd MMMM yyyy", new Locale("ru"));
    }
    @FindBy(xpath = "//input[contains(@id, 'vacancy')]")
    private WebElement vacancy;
    @FindBy(xpath = "/html/body/main/div/section[5]/div[2]/div[2]/form/div[1]/div[1]/div/div[2]/div/ul/li[1]")
    private WebElement currentVacancy;
    @FindBy(xpath = "//textarea[@id=\"description\"]")
    private WebElement description;
    @FindBy(xpath = "//input[contains(@id, 'link')]")
    private WebElement link;
    @FindBy(xpath = "//input[contains(@id, 'format')]")
    private WebElement format;
    @FindBy(xpath = "//input[contains(@id, 'date')]")
    private WebElement dateInput;
    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/span[26]")
    private WebElement dateChoose;
    @FindBy(xpath = "//button[contains(@class, 'save')]")
    private List<WebElement> saveBtn;

    public void CreatingTestTask() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        vacancy.click();
        currentVacancy.click();
        description.sendKeys("Придётся много тестировать");
        link.sendKeys("https://www.google.ru");
        format.sendKeys("pdf");
        dateInput.click();
        dateChoose.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String dateToCheck = dateInput.getAttribute("value");
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd.MM.yyyy", new Locale("ru"));
        // SimpleDateFormat outputFormat = new SimpleDateFormat("dd MMMM yyyy", new Locale("ru"));
        try {
            Date date = inputFormat.parse(dateToCheck);
            outputDate = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", saveBtn.get(1));
        saveBtn.get(1).click();
    }
    public String getOutputDate() {
        return outputDate;
    }

}
