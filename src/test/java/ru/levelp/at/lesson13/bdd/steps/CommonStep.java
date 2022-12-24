package ru.levelp.at.lesson13.bdd.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import ru.levelp.at.lesson13.bdd.context.TestContext;
import ru.levelp.at.lesson13.bdd.ui.DnsCatalogPage;
import ru.levelp.at.lesson13.bdd.ui.DnsIndexPage;
import ru.levelp.at.lesson13.bdd.ui.DnsSubCatalogPage;

public class CommonStep {

    private WebDriver driver;

    public CommonStep() {
        driver = (WebDriver) TestContext.getInstance().getObject("driver");
    }

    @Given("I open dns-shop Main page")
    public void openDnsMainPage() {
        new DnsIndexPage(driver).open();
    }

    @When("I navigate to {string} product sub-category of {string} sub-category of {string} category from Menu")
    public void navigateToProductSubcategoryOfSubcategoryOfCategory(String productSubCategoryName,
                                                                    String subCategoryName,
                                                                    String categoryName) {
        new DnsIndexPage(driver).openMenuCategory(categoryName);
        new DnsCatalogPage(driver).getSubcategoryItems().openSubcategory(subCategoryName);
        new DnsSubCatalogPage(driver).getSubcategoryItems().openSubcategory(productSubCategoryName);
    }

}
