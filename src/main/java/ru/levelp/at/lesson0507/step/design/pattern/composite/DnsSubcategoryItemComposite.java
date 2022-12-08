package ru.levelp.at.lesson0507.step.design.pattern.composite;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
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

    @Step("Окрываем подкатегодрию {subcategoryName}")
    public void openSubcategory(final String subcategoryName) {
        List<WebElement> subcategoryItems = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By
            .cssSelector(".subcategory__item span.subcategory__title")));
        Allure.step("Ищем подкатегорию в списке", () -> {
            for (WebElement subcategoryItem : subcategoryItems) {
                String subcategoryText = subcategoryItem.getText();
                if (subcategoryName.equalsIgnoreCase(subcategoryText)) {
                    Allure.step("Кликаем по подкатегории", () -> {
                        wait.until(ExpectedConditions.elementToBeClickable(subcategoryItem)).click();
                    });
                    break;
                }
            }
        });
    }
}
