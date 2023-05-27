package org.example.tests;
import org.example.ConfProperties;
import org.example.Pages.EmployerPage;
import org.example.Pages.LoginPage;
import org.example.Pages.ProfilePage;
import org.example.Pages.ResumePage;
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
public class EmployerTest {
    public static LoginPage loginPage;
    public static EmployerPage employerPage;
    public static ProfilePage profilePage;
    public static ResumePage resumePage;
    public static WebDriver driver;
    public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    public static WebElement firstCityCard;
    public static WebElement secondCityCard;
    public static WebElement thirdCityCard;



    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        employerPage = new EmployerPage(driver);
        resumePage = new ResumePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage")); }

    @Test
    public void test1_FiltersSetCity() {
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.clickLoginBtn();
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickEnterBtn();
        profilePage.moveToMenu();
        profilePage.changeToCompany2();
        profilePage.setCityMoscowInHeader();
        profilePage.goToEmployerSearch();

        employerPage.goToAll();

        wait.until(ExpectedConditions.elementToBeClickable(employerPage.firstCard));
        firstCityCard = driver.findElement(By.xpath("/html/body/div[1]/main/div/section[4]/section[1]/section[1]/ul/li[1]/div[2]/a/p[2]"));
        secondCityCard = driver.findElement(By.xpath("/html/body/div[1]/main/div/section[4]/section[1]/section[1]/ul/li[2]/div[2]/a/p[1]"));
        thirdCityCard = driver.findElement(By.xpath("/html/body/div[1]/main/div/section[4]/section[1]/section[1]/ul/li[3]/div[2]/a/p[1]"));
        Assert.assertEquals("Москва", firstCityCard.getText());
        Assert.assertEquals("Москва", secondCityCard.getText());
        Assert.assertEquals("Москва", thirdCityCard.getText());
    }
    @Test
    public void test2_FiltersChangeCity() {
        employerPage.checkCity();
        employerPage.goToAll();
        employerPage.waitingForCardsLoaded();
        firstCityCard = driver.findElement(By.xpath("/html/body/div[1]/main/div/section[4]/section[1]/section[1]/ul/li[1]/div[2]/a/p[@class='resume-card__user-region']"));
        secondCityCard = driver.findElement(By.xpath("/html/body/div[1]/main/div/section[4]/section[1]/section[1]/ul/li[2]/div[2]/a/p[@class='resume-card__user-region']"));
        thirdCityCard = driver.findElement(By.xpath("/html/body/div[1]/main/div/section[4]/section[1]/section[1]/ul/li[3]/div[2]/a/p[@class='resume-card__user-region']"));
        Assert.assertEquals("Санкт-Петербург", firstCityCard.getText());
        Assert.assertEquals("Санкт-Петербург", secondCityCard.getText());
        Assert.assertEquals("Санкт-Петербург", thirdCityCard.getText());
    }
    @Test
    public void test3_FiltersExp() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        employerPage.goToExpNoExp();
        employerPage.changeCardToFull();
        employerPage.goToAll();
        employerPage.waitingForCardsLoaded();
        firstCityCard = driver.findElement(By.xpath("/html/body/div[1]/main/div/section[4]/section[1]/section[1]/ul/li[1]/div[2]/a/div[3]/p"));
        secondCityCard = driver.findElement(By.xpath("/html/body/div[1]/main/div/section[4]/section[1]/section[1]/ul/li[2]/div[2]/a/div[3]/p"));
        jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", firstCityCard);
        Assert.assertEquals("Нет опыта", firstCityCard.getText());
        Assert.assertEquals("Нет опыта", secondCityCard.getText());
        employerPage.goToExpThreeToSix();
        employerPage.goToAll();
        employerPage.waitingForCardsLoaded();
        firstCityCard = driver.findElement(By.xpath("/html/body/div[1]/main/div/section[4]/section[1]/section[1]/ul/li/div[2]/a/div[3]/p"));
        Assert.assertEquals("От 3 до 6 лет", firstCityCard.getText());
    }
    @Test
    public void test4_FiltersGender() {
        employerPage.goToReset();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", employerPage.gender.get(0));
        employerPage.gender.get(0).click();
        employerPage.changeCardToShort();
        employerPage.goToAll();
        employerPage.waitingForCardsLoaded();
        employerPage.goToAll();
        firstCityCard = driver.findElement(By.xpath("/html/body/div[1]/main/div/section[4]/section[1]/section[1]/ul/li[1]/div[2]/a/div[2]/p/span[1]"));
        secondCityCard = driver.findElement(By.xpath("/html/body/div[1]/main/div/section[4]/section[1]/section[1]/ul/li[2]/div[2]/a/div[2]/p/span[1]"));
        Assert.assertEquals("Мужчина", firstCityCard.getText());
        Assert.assertEquals("Мужчина", secondCityCard.getText());
        employerPage.gender.get(1).click();
        employerPage.goToAll();
        employerPage.waitingForCardsLoaded();
        firstCityCard = driver.findElement(By.xpath("/html/body/div[1]/main/div/section[4]/section[1]/section[1]/ul/li[1]/div[2]/a/div[2]/p/span[1]"));
        secondCityCard = driver.findElement(By.xpath("/html/body/div[1]/main/div/section[4]/section[1]/section[1]/ul/li[2]/div[2]/a/div[2]/p/span[1]"));
        Assert.assertEquals("Женщина", firstCityCard.getText());
        Assert.assertEquals("Женщина", secondCityCard.getText());
    }
    @Test
    public void test5_FiltersAge() {
        int minValue = 20;
        int maxValue = 40;
        employerPage.goToReset();
        employerPage.ageInput();
        employerPage.goToAll();
        employerPage.waitingForCardsLoaded();
        firstCityCard = driver.findElement(By.xpath("/html/body/div[1]/main/div/section[4]/section[1]/section[1]/ul/li[1]/div[2]/a/div[2]/p/span[2]"));
        String ageToCheck = firstCityCard.getText();
        String numbersOnly = ageToCheck.replaceAll("[^0-9]", "");
        int result = Integer.parseInt(numbersOnly);
        assert result >= minValue && result <= maxValue: "Не входит в диапазон";
        secondCityCard = driver.findElement(By.xpath("/html/body/div[1]/main/div/section[4]/section[1]/section[1]/ul/li[2]/div[2]/a/div[2]/p/span[2]"));
        ageToCheck = secondCityCard.getText();
        numbersOnly = ageToCheck.replaceAll("[^0-9]", "");
        result = Integer.parseInt(numbersOnly);
        assert result >= minValue && result <= maxValue: "Не входит в диапазон";
    }
    @Test
    public void test6_Complex() {
       // employerPage.goToReset();
     //   employerPage.goToAll();
      //  employerPage.waitingForCardsLoaded();
        employerPage.setFilters1();
        employerPage.goToAll();
        employerPage.waitingForCardsLoaded();
        employerPage.firstCardClick();


    }

    @AfterClass
    public static void tearDown() {
     // profilePage.moveToMenu();
    //  profilePage.changeToUser();
     // profilePage.userLogout();
     // driver.quit();
    }

}



