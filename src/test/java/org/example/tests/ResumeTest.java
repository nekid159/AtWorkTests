package org.example.tests;
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
public class ResumeTest {
    public static WebDriver driver;
    public static LoginPage loginPage;
    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));
    }
    @Test
    public void Test1_ResumeCreate() {
        loginPage = new LoginPage(driver);
    }
}
