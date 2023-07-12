package org.example.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class ProfilePage {

    public WebDriver driver;
    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "//div[contains(@data-test, 'profile-menu')]")
    private WebElement upperMenu;
    @FindBy(xpath = "//p[contains(@data-test, 'user-id')]")
    public WebElement profID;
    @FindBy(xpath = "//p[contains(@data-test, 'logout')]")
    private WebElement logoutBtn ;

    @FindBy(css = "[data-id='2200699']")
    private WebElement compSpec ;
    @FindBy(xpath = "//div[contains(@class, 'upper-case__profile-return')]")
    private WebElement userProf;
    @FindBy(xpath = "/html/body/section[2]/div/div[2]/div[2]/a[1]")
    private WebElement employer;
    @FindBy(xpath = "//*[@id=\"main-header\"]/div[3]/div/section[1]/div[1]/div/p/span")
    private WebElement cityHeader;
    @FindBy(xpath = "//*[@id=\"new-location-toggle\"]")
    private WebElement changeCityHeader;
    @FindBy(xpath = "//*[@id=\"main-header\"]/div[4]/div[2]/input")
    private WebElement cityInputInHeader;
    @FindBy(xpath = "//*[@id=\"main-header\"]/div[4]/div[3]/p[1]")
    private WebElement addMoscow;

    public void setCityMoscowInHeader() {
        cityHeader.click();
        changeCityHeader.click();
        cityInputInHeader.sendKeys("Москва");
        addMoscow.click();
    }




    public void moveToMenu() {
        Actions actions = new Actions(driver);
        actions.moveToElement(upperMenu).perform();
    }


    public String getUserID() {
        String userID = profID.getText();
        return userID; }

    public void changeToCompany () {
        moveToMenu();
        compSpec.click();
        upperMenu.click();
    }
    public void changeToCompany2 () {
        moveToMenu();
        compSpec.click();
        }
    public void changeToUser () {
        moveToMenu();
        userProf.click();
    }
    public void goToEmployerSearch() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        employer.click();
    }

    public void userLogout() {
        logoutBtn.click();
        } }

