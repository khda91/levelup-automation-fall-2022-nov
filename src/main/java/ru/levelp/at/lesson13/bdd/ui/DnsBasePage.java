package ru.levelp.at.lesson13.bdd.ui;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.levelp.at.lesson13.bdd.ui.composite.modal.DnsCompareLoginModal;

public abstract class DnsBasePage {

    private static final String URL = "https://www.dns-shop.ru";

    protected final WebDriver driver;
    protected final WebDriverWait wait;

    @FindBy(css = ".compare-link-counter")
    private WebElement compareButton;

    protected DnsBasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        PageFactory.initElements(driver, this);
    }

    public abstract void open();

    protected void open(String relativeUrl) {
        driver.navigate().to(URL + relativeUrl);
    }

    public void clickToCompareButton() {
        wait.until(ExpectedConditions.elementToBeClickable(compareButton)).click();
    }

    public DnsCompareLoginModal getCompareLoginModal() {
        return new DnsCompareLoginModal(driver);
    }

}
