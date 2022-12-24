package ru.levelp.at.lesson13.bdd.steps;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import ru.levelp.at.lesson13.bdd.context.TestContext;
import ru.levelp.at.lesson13.bdd.ui.DnsComparePage;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertionStep {

    private WebDriver driver;

    public AssertionStep() {
        driver = (WebDriver) TestContext.getInstance().getObject("driver");
    }

    @Then("selected shop items should be displayed on the Compare page")
    public void selectedItemsShouldBeDisplayedOnTheComparePage() {
        List<String> addedToCompareProductsTitles =
            (List<String>) TestContext.getInstance().getObject("selectProductsToCompare");

        List<String> productTitles = new DnsComparePage(driver).getProductTitles();

        assertThat(productTitles).containsExactlyInAnyOrderElementsOf(addedToCompareProductsTitles);
    }
}
