package ru.levelp.at.lesson0507.page.object.types.fluent;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class UserBugRedBasePage<T extends UserBugRedBasePage> {

    private static final String USER_BUG_RED_URL = "http://users.bugred.ru/user";

    protected final WebDriver driver;

    protected final WebDriverWait wait;

    protected UserBugRedBasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        PageFactory.initElements(driver, this);
    }

    protected T open(String relativeUrl) {
        driver.navigate().to(USER_BUG_RED_URL + relativeUrl);
        return (T) this;
    }

    public abstract T open();

    protected void sendKeysToElement(final WebElement element, final String text) {
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }
}
