package ru.levelp.at.lesson13.bdd.ui;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DnsComparePage extends DnsBasePage {

    @FindBy(css = ".products-slider__product-name > a")
    private List<WebElement> productTitles;

    public DnsComparePage(WebDriver driver) {
        super(driver);
    }

    public List<String> getProductTitles() {
        wait.until(ExpectedConditions.visibilityOfAllElements(productTitles));
        return productTitles.stream()
                            .map(WebElement::getText)
                            .collect(Collectors.toList());
    }

    @Override
    public void open() {
        throw new UnsupportedOperationException("Not Implemented");
    }
}
