package org.example.Pages.Files;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TestTaskArchieve {
    public WebDriver driver;

    public TestTaskArchieve(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
