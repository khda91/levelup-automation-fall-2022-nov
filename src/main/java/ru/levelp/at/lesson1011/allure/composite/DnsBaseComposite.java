package ru.levelp.at.lesson1011.allure.composite;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class DnsBaseComposite {

    protected final WebDriver driver;
    protected final WebDriverWait wait;

    protected DnsBaseComposite(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        PageFactory.initElements(driver, this);
    }
}
