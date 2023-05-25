package org.example.tests;
import org.example.ConfProperties;
import org.example.Pages.Company.CompanyEditPage;
import org.example.Pages.Company.CompanyPage;
import org.example.Pages.LoginPage;
import org.example.Pages.ProfilePage;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CompanyEditTest {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static CompanyPage companyPage;
    public static CompanyEditPage companyEditPage;
    public static WebDriver driver;
    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage")); }
    @Test
    public void test1_companyEdit() {
        companyPage = new CompanyPage(driver);
        companyEditPage = new CompanyEditPage(driver);

        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.clickLoginBtn();
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickEnterBtn();

        profilePage.moveToMenu();
        profilePage.changeToCompany();
        driver.get("https://at-work.pro/user");

        companyPage.clickCompContrib();
        companyPage.goToCompMenu();
        companyPage.goToCompEdit();

        companyEditPage.nextPageCompany();
        companyEditPage.descriptionEdit();
        companyEditPage.siteEdit();
        companyEditPage.specializationChoose();
        companyEditPage.numberChoose();
        companyEditPage.textAreaEdit();
        companyEditPage.nextPageAgain();
        companyEditPage.submitCompany();

        companyPage.waitingForLoad();
        companyPage.gettingNumber();


        Assert.assertEquals("Автомобильный бизнес", companyPage.compSpec.getText());
        Assert.assertEquals("https://at-work.pro", companyPage.compSite.getText());
        Assert.assertEquals("от 1000 до 5000 человек", companyPage.compNumber.getText());
        Assert.assertEquals("Тестовое описание", companyPage.compDescription.getText());
    }
    @Test
    public void test2_companyClear() {
        companyPage.clickCompContrib();
        companyPage.goToCompMenu();
        companyPage.goToCompEdit();
        companyEditPage.nextPageCompany();

        companyEditPage.shortDescriptionClear();
        companyEditPage.siteClear();
        companyEditPage.specializationChoose();
        companyEditPage.numberClear();
        companyEditPage.textAreaClear();
        companyEditPage.nextPageAgain();
        companyEditPage.submitCompany();



    }
    @AfterClass
    public static void tearDown() {
        companyPage.waitingForLoad();
        profilePage.changeToUser();
        profilePage.moveToMenu();
        profilePage.userLogout();
        driver.quit(); } }

