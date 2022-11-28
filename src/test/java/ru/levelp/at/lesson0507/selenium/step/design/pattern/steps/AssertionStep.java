package ru.levelp.at.lesson0507.selenium.step.design.pattern.steps;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.openqa.selenium.WebDriver;

public class AssertionStep extends BaseStep {

    public AssertionStep(WebDriver driver) {
        super(driver);
    }

    public void selectedProductsShouldBeDisplayedOnComparePage(List<String> addedToCompareProductsTitles) {
        List<String> productTitles = comparePage.getProductTitles();

        assertThat(productTitles).containsExactlyInAnyOrderElementsOf(addedToCompareProductsTitles);
    }
}
