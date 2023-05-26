package org.example.Pages;
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

    public void inputLogin(String login) {
        loginField.sendKeys("nekid159@yandex.ru"); }

    public void inputPasswd(String passwd) {
        passwdField.sendKeys("Dd17549dd!"); }
    public void clickLoginBtn() {
        loginBtn.click(); }
    public void clickEnterBtn() {
        enterBtn.click(); }
    public void logIn() {
        loginField.sendKeys("nekid159@yandex.ru");
        passwdField.sendKeys("Dd17549dd!");
        loginBtn.click();
        enterBtn.click();
    }
}



