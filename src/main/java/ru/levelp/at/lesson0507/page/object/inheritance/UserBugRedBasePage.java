package ru.levelp.at.lesson0507.page.object.inheritance;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class UserBugRedBasePage {

    private static final String USER_BUG_RED_URL = "http://users.bugred.ru/user";

    protected final WebDriver driver;

    protected final WebDriverWait wait;

    protected UserBugRedBasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        PageFactory.initElements(driver, this);
    }

    protected void open(String relativeUrl) {
        driver.navigate().to(USER_BUG_RED_URL + relativeUrl);
    }

    public abstract void open();

    protected void sendKeysToElement(final WebElement element, final String text) {
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }
}
