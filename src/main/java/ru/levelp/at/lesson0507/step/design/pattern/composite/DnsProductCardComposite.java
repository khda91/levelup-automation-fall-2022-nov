package ru.levelp.at.lesson0507.step.design.pattern.composite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DnsProductCardComposite extends DnsBaseComposite {

    private static final By PRODUCT_TITLE_LOCATOR = By.cssSelector(".catalog-product__name > span");
    private static final By ADD_TO_COMPARE_BUTTON_LOCATOR = By
        .xpath(".//span[@class='compare-checkbox']");

    private final WebElement root;

    public DnsProductCardComposite(WebDriver driver, WebElement root) {
        super(driver);
        this.root = root;
    }

    public String getTitle() {
        WebElement title = wait.until(ExpectedConditions
            .presenceOfNestedElementLocatedBy(root, PRODUCT_TITLE_LOCATOR));
        int textIndex = title.getText().indexOf("[");
        return title.getText().substring(0, textIndex - 1);
    }

    public void clickAddToCompare() {
        WebElement addToCompareButton = wait.until(ExpectedConditions
            .presenceOfNestedElementLocatedBy(root, ADD_TO_COMPARE_BUTTON_LOCATOR));
        wait.until(ExpectedConditions.elementToBeClickable(addToCompareButton)).click();
    }
}
