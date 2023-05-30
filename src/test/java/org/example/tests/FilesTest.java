package org.example.tests;
import org.example.ConfProperties;
import org.example.Pages.*;
import org.example.Pages.Files.MyFilesPage;
import org.example.Pages.Files.OfferCreatePage;
import org.example.Pages.Resume.ResumePage;
import org.example.Pages.Vacanies.ArchieveVacancyPage;
import org.example.Pages.Vacanies.MyVacanciesPage;
import org.example.Pages.Vacanies.VacancyCreatePage;
import org.example.Pages.Vacanies.VacancyPage;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Set;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FilesTest {
    public static LoginPage loginPage;
    public static EmployerPage employerPage;
    public static ProfilePage profilePage;
    public static MyVacanciesPage myVacanciesPage;
    public static VacancyCreatePage vacancyCreatePage;
    public static ArchievePage archievePage;
    public static ArchieveVacancyPage archieveVacancyPage;
    public static LkEmployer lkEmployer;
    public static OfferCreatePage offerCreatePage;

    public static MyFilesPage myFilesPage;
    public static WebDriver driver;
    public static String vacancyToFileCheck;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        myVacanciesPage = new MyVacanciesPage(driver);
        vacancyCreatePage = new VacancyCreatePage(driver);
        archievePage = new ArchievePage(driver);
        archieveVacancyPage = new ArchieveVacancyPage(driver);
        myFilesPage = new MyFilesPage(driver);
        lkEmployer = new LkEmployer(driver);
        offerCreatePage = new OfferCreatePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));
    }
    @Test
    public void Test1_CreateOffer() {
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.clickLoginBtn();
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickEnterBtn();
        profilePage.moveToMenu();
        profilePage.changeToCompany();
        driver.get("https://at-work.pro/user/employer/archive/");
        archievePage.GoToArchieveVacancy();
        archieveVacancyPage.getVacBack();

        vacancyCreatePage.GoMain();
        vacancyCreatePage.editVacNameAgain();
        vacancyCreatePage.addSpec();
        vacancyCreatePage.saveVac();
        myVacanciesPage.waitToLoadVacancies();
        WebElement vacancyToCheckName = driver.findElement(By.xpath("/html/body/main/div/section[5]/section[3]/ul/li/div[1]/a/h2/span"));
        vacancyToFileCheck = vacancyToCheckName.getText();
        lkEmployer.goToFiles();
        myFilesPage.goToCreateOffer();
        offerCreatePage.createOffer();





    }

}
