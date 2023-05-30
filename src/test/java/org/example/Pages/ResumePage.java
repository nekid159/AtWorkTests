package org.example.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ResumePage {
    public WebDriver driver;
    public ResumePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
}
