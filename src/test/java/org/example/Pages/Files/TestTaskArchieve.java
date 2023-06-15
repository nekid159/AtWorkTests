package org.example.Pages.Files;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TestTaskArchieve {
    public WebDriver driver;
    public static TestTaskCreatePage testTaskCreatePage;

    public TestTaskArchieve(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//h5[@id=\"preview-vacancy\"]")
    private WebElement positionName;
    @FindBy(xpath = "//textarea[@id=\"view-description\"]")
    private WebElement description;
    @FindBy(xpath = "//p[@id=\"view-link\"]")
    private WebElement link;
    @FindBy(xpath = "//p[@id=\"view-format\"]")
    private WebElement format;
    @FindBy(xpath = "//p[@id=\"view-date\"]")
    public WebElement date;
    public void CheckTestTask() {
        testTaskCreatePage = new TestTaskCreatePage(driver);
        Assert.assertTrue(positionName.getText().contains("Тестировщик"));
        Assert.assertTrue(description.getAttribute("value").contains("Придётся много тестировать"));
        Assert.assertEquals("https://www.google.ru", link.getText());
        Assert.assertEquals("pdf", format.getText());
    }
}
