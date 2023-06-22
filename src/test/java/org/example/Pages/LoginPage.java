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
    @FindBy(xpath = "//input[@id=\"email-input\"]")
    private WebElement loginField;
    @FindBy(xpath = "//button[contains(@class, 'authorization__button--continue')]")
    private WebElement loginBtn;
    @FindBy(xpath = "//button[contains(@class, 'authorization__button--enter')]")
    private WebElement enterBtn;
    @FindBy(xpath = "//input[@id=\"auth-password\"]")
    private WebElement passwdField;
    @FindBy(xpath = "//button[@id=\"email-authorization\"]")
    private WebElement mailChoose;
    @FindBy(xpath = "//button[@id=\"phone-authorization\"]")
    private WebElement phoneChoose;
    @FindBy(xpath = "//input[@id=\"phone-input\"]")
    private WebElement phoneField;

    public void inputLogin(String login) {
        loginField.sendKeys("nekid159@yandex.ru"); }
    public void inputPhone(String phone) {
        phoneField.sendKeys("9191640883"); }

    public void inputPasswd(String passwd) {
        passwdField.sendKeys("Dd17549dd!"); }
    public void clickLoginBtn() {
        loginBtn.click(); }
    public void clickEnterBtn() {
        enterBtn.click(); }
    public void mailEnter() {
        inputLogin(ConfProperties.getProperty("login"));
        clickLoginBtn();
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
        clickLoginBtn();
        inputPasswd(ConfProperties.getProperty("password"));
        clickEnterBtn();
    }
}



