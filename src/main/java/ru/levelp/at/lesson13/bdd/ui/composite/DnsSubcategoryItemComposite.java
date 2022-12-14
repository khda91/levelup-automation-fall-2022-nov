package ru.levelp.at.lesson13.bdd.ui.composite;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DnsSubcategoryItemComposite extends DnsBaseComposite {

    // @FindBy(css = ".subcategory__item > label.subcategory__mobile-title")
    // private List<WebElement> subcategoryItems;

    public DnsSubcategoryItemComposite(WebDriver driver) {
        super(driver);
    }

    public void openSubcategory(final String subcategoryName) {
        List<WebElement> subcategoryItems = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By
            .cssSelector(".subcategory__item span.subcategory__title")));
        for (WebElement subcategoryItem : subcategoryItems) {
            String subcategoryText = subcategoryItem.getText();
            if (subcategoryName.equalsIgnoreCase(subcategoryText)) {
                wait.until(ExpectedConditions.elementToBeClickable(subcategoryItem)).click();
                break;
            }
        }
    }
}
