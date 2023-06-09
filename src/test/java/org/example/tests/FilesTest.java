package org.example.tests;
import org.example.ConfProperties;
import org.example.Pages.*;
import org.example.Pages.Files.MyFilesPage;
import org.example.Pages.Files.OfferCreatePage;
import org.example.Pages.Files.OfferPage;
import org.example.Pages.Files.RecommendCreatePage;
import org.example.Pages.Vacanies.ArchieveVacancyPage;
import org.example.Pages.Vacanies.MyVacanciesPage;
import org.example.Pages.Vacanies.VacancyCreatePage;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Dimension;

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
    public static RecommendCreatePage recommendCreatePage;
    public static MyFilesPage myFilesPage;
    public static OfferPage offerPage;
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
        offerPage = new OfferPage(driver);
        recommendCreatePage = new RecommendCreatePage(driver);
        Dimension size = new Dimension(2500, 1800);
        driver.manage().window().setSize(size);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));
    }
    @Test
    public void Test1_CreateOffer() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
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
        myFilesPage.waitForOffersLoaded();
        Assert.assertEquals(vacancyToFileCheck, myFilesPage.offerName.getText());
        myFilesPage.firstOffer.click();
        myFilesPage.openOfferPreview();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals("Сергей Сергеевич", offerPage.candidateName.getText());
        Assert.assertEquals("Грузчика", offerPage.vacancy.getText());
        Assert.assertEquals("Главного грузчика", offerPage.vacancyBoss.getText());
        //Assert.assertEquals("Грузить, грузить и ещё раз грузить", offerPage.vacancyDesc.getText());
        Assert.assertEquals("12345", offerPage.salary.getText());
        jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", offerPage.companyName);
        Assert.assertEquals("Игорь Игорьевич", offerPage.contactGuy.getText());
        Assert.assertEquals("Главнейший грузчик", offerPage.post.getText());
        Assert.assertEquals("СПЕЦМОНТАЖ 234", offerPage.companyName.getText());
        Assert.assertEquals("gruzchik@mail.gruz", offerPage.contactEmail.getText());
        Assert.assertEquals("+7(999)123-12-12", offerPage.contactNumber.getText());
    }
    @Test
    public void Test2_CreateRecommend() {
        lkEmployer.goToFiles();
        myFilesPage.goToCreateRecommend();
        recommendCreatePage.CreatingRecommendationLetter();

    }

}