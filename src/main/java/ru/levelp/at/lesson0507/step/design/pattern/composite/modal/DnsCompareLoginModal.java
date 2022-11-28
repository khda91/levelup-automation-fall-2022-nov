package ru.levelp.at.lesson0507.step.design.pattern.composite.modal;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.levelp.at.lesson0507.step.design.pattern.composite.DnsBaseComposite;

public class DnsCompareLoginModal extends DnsBaseComposite {

    @FindBy(css = "#compare-login-modal > div.base-modal__container")
    private WebElement rootWindow;

    public DnsCompareLoginModal(WebDriver driver) {
        super(driver);
    }

    public void closeIfVisible() {
        Boolean dialogInvisible = wait.withTimeout(Duration.ofMillis(5000))
                                      .until(ExpectedConditions.invisibilityOfElementLocated(By
                                          .cssSelector("#compare-login-modal "
                                              + "> div.base-modal__container > .base-modal__header")));
        if (Boolean.FALSE.equals(dialogInvisible)) {
            WebElement closeButton = wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(By
                    .cssSelector("#compare-login-modal > div.base-modal__container"),
                By.cssSelector("[data-base-modal-action='close']")));
            wait.until(ExpectedConditions.elementToBeClickable(closeButton)).click();
        }
    }
}
