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

public class TestTaskPage {
    public WebDriver driver;
    public TestTaskPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//textarea[@id=\"view-description\"]")
    public WebElement description;
    @FindBy(xpath = "//p[@id=\"view-link\"]")
    public WebElement link;
    @FindBy(xpath = "//p[@id=\"view-format\"]")
    public WebElement format;
    @FindBy(xpath = "//p[@id=\"view-date\"]")
    public WebElement date;
}
