package ru.levelp.at.lesson1011.allure.ui.steps;

import static org.assertj.core.api.Assertions.assertThat;

import io.qameta.allure.Step;
import java.util.List;
import org.openqa.selenium.WebDriver;

public class AssertionStep extends BaseStep {

    public AssertionStep(WebDriver driver) {
        super(driver);
    }

    @Step("Проверить что выбранные товары добылены в список")
    public void selectedProductsShouldBeDisplayedOnComparePage(List<String> addedToCompareProductsTitles) {
        List<String> productTitles = comparePage.getProductTitles();

        assertThat(productTitles).containsExactlyInAnyOrderElementsOf(addedToCompareProductsTitles);
    }
}
