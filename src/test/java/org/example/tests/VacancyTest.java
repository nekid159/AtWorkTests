package org.example.tests;
import com.beust.ah.A;
import org.example.ConfProperties;
import org.example.Pages.*;
import org.example.Pages.Company.CompanyEditPage;
import org.example.Pages.Company.CompanyPage;
import org.example.Pages.Vacanies.ArchieveVacancyPage;
import org.example.Pages.Vacanies.MyVacanciesPage;
import org.example.Pages.Vacanies.VacancyCreatePage;
import org.example.Pages.Vacanies.VacancyPage;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

import org.junit.runners.MethodSorters;




@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VacancyTest {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static CompanyPage companyPage;
    public static CompanyEditPage companyEditPage;
    public static MyVacanciesPage myVacanciesPage;
    public static VacancyCreatePage vacancyCreatePage;
    public static VacancyPage vacancyPage;
    public static ArchievePage archievePage;
    public static ArchieveVacancyPage archieveVacancyPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        vacancyPage = new VacancyPage(driver);
        archievePage = new ArchievePage(driver);
        companyPage = new CompanyPage(driver);
        companyEditPage = new CompanyEditPage(driver);
        myVacanciesPage = new MyVacanciesPage(driver);
        vacancyCreatePage = new VacancyCreatePage(driver);
        archieveVacancyPage = new ArchieveVacancyPage(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));
    }

    @Test
    public void test1_VacancyCreate() {
        loginPage.mailEnter();
        profilePage.moveToMenu();
        profilePage.changeToCompany();
        driver.get("https://at-work.pro/user/employer/vacancies/my_vacancies/#active");
        myVacanciesPage.clickVacCreateBtn();
        vacancyCreatePage.addVacCity();
        vacancyCreatePage.GoMain();
        vacancyCreatePage.addVacName();
        vacancyCreatePage.addSpec();
        vacancyCreatePage.saveVac();
        myVacanciesPage.waitToLoadVacancies();
        Assert.assertEquals("Работничек", myVacanciesPage.vacName.getText());
        Assert.assertEquals("Москва", myVacanciesPage.vacCity.getText());
        myVacanciesPage.goTocard();
        Assert.assertEquals("Работничек", vacancyPage.vacNamePage.getText());
        Assert.assertEquals("Москва", vacancyPage.vacCityPage.getText());
        Assert.assertEquals(vacancyCreatePage.vacDescriptionText, vacancyPage.vacDescPage.getText());

    }
    @Test
    public void test2_VacancyEdit() {
        driver.get("https://at-work.pro/user/employer/vacancies/my_vacancies/#active");
        myVacanciesPage.goToVacEdit();
        vacancyCreatePage.GoMain();
        vacancyCreatePage.editVacName();
        vacancyCreatePage.addSpec();
        vacancyCreatePage.saveVac();
        myVacanciesPage.waitToLoadVacancies();
        Assert.assertEquals("Чудо работник", myVacanciesPage.vacName.getText());
        myVacanciesPage.goTocard();
        Assert.assertEquals("Чудо работник", vacancyPage.vacNamePage.getText());
        Assert.assertEquals("Москва", vacancyPage.vacCityPage.getText());//
        Assert.assertEquals(vacancyCreatePage.vacDescriptionText, vacancyPage.vacDescPage.getText());
    }
    @Test
    public void test3_VacancyGotoArchive() {
        driver.get("https://at-work.pro/user/employer/vacancies/my_vacancies/#active");
        myVacanciesPage.sendVacToArchive();
        driver.get("https://at-work.pro/user/employer/archive/");
        Assert.assertEquals("Чудо работник", archievePage.vacNameInArcieve.getText());
        Assert.assertEquals("Москва", archievePage.vacCityInArcieve.getText());
        archievePage.GoToArchieveVacancy();
        Assert.assertEquals("В архиве",archieveVacancyPage.inArchieve.getText());
        Assert.assertEquals("Чудо работник", archieveVacancyPage.vacNameInArcieve.getText());
        Assert.assertEquals("Москва",archieveVacancyPage.vacCityInArcieve.getText());
        Assert.assertEquals(vacancyCreatePage.vacDescriptionText, archieveVacancyPage.vacDescriptionInArcieve.getText());
        Assert.assertEquals("Разместить повторно", archieveVacancyPage.publishAgainBtn.getText());
        Assert.assertEquals("История изменения вакансии",archieveVacancyPage.changeStory.getText());
        archieveVacancyPage.getVacBack();
    }
    @Test
    public void test4_VacancyGetBackFromArchieve() {
        vacancyCreatePage.GoMain();
        vacancyCreatePage.editVacNameAgain();
        vacancyCreatePage.addSpec();
        vacancyCreatePage.saveVac();
        myVacanciesPage.waitToLoadVacancies();
        Assert.assertEquals("Тестировщик", myVacanciesPage.vacName.getText());
        myVacanciesPage.goTocard();
        Assert.assertEquals("Тестировщик", vacancyPage.vacNamePage.getText());
        Assert.assertEquals("Москва", vacancyPage.vacCityPage.getText());
        Assert.assertEquals(vacancyCreatePage.vacDescriptionText, vacancyPage.vacDescPage.getText());
        driver.get("https://at-work.pro/user/employer/vacancies/my_vacancies/#active");
        myVacanciesPage.sendVacToArchive();

    }
    @AfterClass
    public static void tearDown() {
        profilePage.moveToMenu();
        profilePage.changeToUser();
        profilePage.userLogout();
        driver.quit();

    }



}

