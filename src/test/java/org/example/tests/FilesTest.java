package org.example.tests;
import org.example.ConfProperties;
import org.example.Pages.*;
import org.example.Pages.Files.*;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FilesTest {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static MyVacanciesPage myVacanciesPage;
    public static VacancyCreatePage vacancyCreatePage;
    public static ArchievePage archievePage;
    public static ArchieveVacancyPage archieveVacancyPage;
    public static LkEmployer lkEmployer;
    public static OfferCreatePage offerCreatePage;
    public static RecommendCreatePage recommendCreatePage;
    public static TestTaskCreatePage testTaskCreatePage;
    public static MyFilesPage myFilesPage;
    public static OfferPage offerPage;
    public static RecommendPage recommendPage;
    public static TestTaskPage testTaskPage;
    public static OfferArchieve offerArchieve;
    public static RecommendArchieve recommendArchieve;
    public static TestTaskArchieve testTaskArchieve;
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
        testTaskCreatePage = new TestTaskCreatePage(driver);
        recommendPage = new RecommendPage(driver);
        testTaskPage = new TestTaskPage(driver);
        offerArchieve = new OfferArchieve(driver);
        recommendArchieve = new RecommendArchieve(driver);
        testTaskArchieve = new TestTaskArchieve(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));
    }

    @Test
    public void Test1_CreateOffer() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        loginPage.mailEnter();
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
        myFilesPage.filePreview.get(0).click();
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
        myFilesPage.recommendationLetterPage.click();
        myFilesPage.filePreview.get(1).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals("Петров Пётр Петрович", recommendPage.recommendedName.get(1).getText());
        Assert.assertEquals("Менеджер", recommendPage.recommendedPost.getText());
        Assert.assertEquals("Главный менеджер", recommendPage.postWhoRecommends.getText());
        Assert.assertEquals("Олегов Олег Олегович", recommendPage.nameWhoRecommends.getText());
    }

    @Test
    public void Test3_CreateTestTask() {
        lkEmployer.goToFiles();
        myFilesPage.goToCreateTest();
        testTaskCreatePage.CreatingTestTask();
        myFilesPage.testTaskPage.click();
        myFilesPage.filePreview.get(2).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals("Придётся много тестировать", testTaskPage.description.getAttribute("value"));
        Assert.assertEquals("https://www.google.ru", testTaskPage.link.getText());
        Assert.assertEquals("pdf", testTaskPage.format.getText());
        String outputDate = testTaskCreatePage.getOutputDate();
        Assert.assertEquals(outputDate, testTaskPage.date.getText());
    }

    @Test
    public void Test4_DeleteFiles() {
        lkEmployer.goToFiles();
        myFilesPage.deletingFiles();
        driver.get("https://at-work.pro/user/employer/archive/");
        archievePage.GotoArchieveFiles();
        Assert.assertEquals("Тестировщик", archievePage.lastOfferName.getText());
        archievePage.GoToArcieveRecommends();
        Assert.assertEquals("Петров Пётр Петрович", archievePage.lastRecommendName.getText());
        archievePage.GoToArcieveTestTasks();
        Assert.assertEquals("Тестировщик", archievePage.lastTestTaskName.getText());
    }

    @Test
    public void Test5_ArchieveFilesCheck() {
        archievePage.GoToArcieveOffers();
        archievePage.lastOffer.click();
        archievePage.WaitToFilesLoad();
        offerArchieve.CheckOfferArchieve();
        archievePage.goBackArchieve();
        archievePage.GoToArcieveRecommends();
        archievePage.lastRecommend.click();
        archievePage.WaitToFilesLoad();
        recommendArchieve.CheckRecommendArchieve();
        archievePage.goBackArchieve2();
        archievePage.GoToArcieveTestTasks();
        archievePage.lastTestTask.click();
        archievePage.WaitToFilesLoad();
        testTaskArchieve.CheckTestTask();
        String checkDate = testTaskCreatePage.getOutputDate();
        System.out.println(checkDate);
        Assert.assertEquals(checkDate, testTaskArchieve.date.getText());
    }

    @Test
    public void Test6_GetFilesBack() {
        driver.get("https://at-work.pro/user/employer/archive/");
        archievePage.GotoArchieveFiles();
        archievePage.DuplicateFiles();
        myFilesPage.checkFilesAfterDelete();
    }

    @Test
    public void Test7_DeleteFilesWithVacancy() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        lkEmployer.goToVacancies();
        myVacanciesPage.sendVacToArchive();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/div/section[5]/section[1]/div/a[1]")));
        lkEmployer.goToFiles();
        myFilesPage.checkFilesAfterDeleteWithVacancy();
        myFilesPage.recommendationLetterPage.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        myFilesPage.fileDelete.get(0).click();
        myFilesPage.confirmDelete.get(1).click();

    }

    @AfterClass
    public static void tearDown() {
        profilePage.moveToMenu();
        profilePage.changeToUser();
        profilePage.userLogout();
        driver.quit();
    }
}
