package org.example.Pages;
import org.example.ConfProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage {

    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
    @FindBy(xpath = "//button[contains(@data-test, 'email-choose')]")
    private WebElement mailChoose;
    @FindBy(xpath = "//button[contains(@data-test, 'phone-choose')]")
    private WebElement phoneChoose;
    @FindBy(xpath = "//input[@id=\"email\"]")
    private WebElement loginField;
    @FindBy(xpath = "//input[@id=\"phone\"]")
    private WebElement phoneField;
    @FindBy(xpath = "//input[@id=\"password\"]")
    private WebElement passwdField;
    @FindBy(xpath = "//button[contains(@data-test, 'enter')]")
    private WebElement enterBtn;



    public void inputLogin(String login) {
        loginField.sendKeys("test@at-work.pro"); }
    public void inputPhone(String phone) {
        phoneField.sendKeys("9817569728"); }

    public void inputPasswd(String passwd) {
        passwdField.sendKeys("AtW0rk##"); }

    public void clickEnterBtn() {
        enterBtn.click(); }
    public void mailEnter() {
        inputLogin(ConfProperties.getProperty("login"));
        inputPasswd(ConfProperties.getProperty("password"));
        clickEnterBtn();
    }
    public void phoneEnter() {
        phoneChoose.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        phoneField.click();
        inputPhone(ConfProperties.getProperty("phone"));
        inputPasswd(ConfProperties.getProperty("password"));
        clickEnterBtn();
    }
}



