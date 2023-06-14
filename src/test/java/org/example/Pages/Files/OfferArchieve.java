package org.example.Pages.Files;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class OfferArchieve {
    public WebDriver driver;

    public OfferArchieve(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//p[contains(@class, 'completed-name')]")
    public WebElement name;
    @FindBy(xpath = "//p[contains(@class, 'completed-position')]")
    public WebElement post;
    @FindBy(xpath = "//p[contains(@class, 'completed-subordinate')]")
    public WebElement bossPost;
    @FindBy(xpath = "//textarea[contains(@class, 'completed-charge')]")
    public WebElement whatToDo;
    @FindBy(xpath = "//li[contains(@class, 'completed-salary')]")
    public WebElement salary;
    @FindBy(xpath = "//p[contains(@class, 'completed-contacts-name')]")
    public WebElement contactName;
    @FindBy(xpath = "//p[contains(@class, 'completed-contacts-position')]")
    public WebElement contactPost;
    @FindBy(xpath = "//p[contains(@class, 'completed-contacts-company')]")
    public WebElement contactCompany;
    @FindBy(xpath = "//p[contains(@class, 'completed-mail')]")
    public WebElement contactMail;
    @FindBy(xpath = "//p[contains(@class, 'completed-tel')]")
    public WebElement contactPhone;

    public void CheckOfferArchieve() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        Assert.assertTrue(name.getText().contains("Сергей Сергеевич"));
        Assert.assertTrue(post.getText().contains("Грузчика"));
        Assert.assertTrue(bossPost.getText().contains("Главного грузчика"));
        Assert.assertTrue(whatToDo.getAttribute("value").contains("Грузить, грузить и ещё раз грузить"));
        Assert.assertTrue(salary.getText().contains("12345"));
        jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", contactName);
        Assert.assertTrue(contactName.getText().contains("Игорь Игорьевич"));
        Assert.assertTrue(contactPost.getText().contains("Главнейший грузчик"));
        Assert.assertTrue(contactCompany.getText().contains("СПЕЦМОНТАЖ 234"));
        Assert.assertTrue(contactMail.getText().contains("gruzchik@mail.gruz"));
        Assert.assertTrue(contactPhone.getText().contains("+7(999)123-12-12"));
    }
}
