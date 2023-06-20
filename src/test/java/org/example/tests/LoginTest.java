package org.example.tests;
import org.example.ConfProperties;
import org.example.Pages.Company.CompanyPage;
import org.example.Pages.LoginPage;
import org.example.Pages.ProfilePage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
public class LoginTest {
    public static LoginPage loginPage;
    public static CompanyPage companyPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;


    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage")); }

    @Test
    public void loginTest() {
        loginPage.mailEnter();
        profilePage.moveToMenu();
        String user = profilePage.getUserID();
        Assert.assertEquals("ID: 976261", user);
        }

   @AfterClass
    public static void tearDown() {
        profilePage.userLogout();
       driver.quit(); } }
