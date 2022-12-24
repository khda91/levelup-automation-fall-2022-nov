package ru.levelp.at.lesson13.bdd.steps;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.When;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import ru.levelp.at.lesson13.bdd.context.TestContext;
import ru.levelp.at.lesson13.bdd.ui.DnsProductsCatalogPage;
import ru.levelp.at.lesson13.bdd.ui.composite.DnsProductCardComposite;
import ru.levelp.at.utils.SleepUtils;

public class ActionStep {

    private WebDriver driver;

    public ActionStep() {
        driver = (WebDriver) TestContext.getInstance().getObject("driver");
    }

    @ParameterType(".*")
    public List<Integer> shopItemsIndex(String indexes) {
        return Arrays.stream(indexes.split(","))
                     .map(Integer::parseInt)
                     .collect(Collectors.toList());
    }

    @When("I add '{shopItemsIndex}' shop items to Compare list on the Products page")
    public void addShopItemsToCompareList(List<Integer> shopItemsIndex) {
        var productsPage = new DnsProductsCatalogPage(driver);

        List<DnsProductCardComposite> products = productsPage.getProducts();
        List<String> addedToCompareProductsTitles = new ArrayList<>();

        for (int productIndex : shopItemsIndex) {
            SleepUtils.sleep(2500);
            int index = productIndex - 1;
            products.get(index).clickAddToCompare();
            addedToCompareProductsTitles.add(products.get(index).getTitle());

            productsPage.getCompareLoginModal().closeIfVisible();
        }

        TestContext.getInstance().putObject("selectProductsToCompare", addedToCompareProductsTitles);
    }

    @When("I click on the 'Сравнить' button in the page Header")
    public void clickCompareButtonInTheHeader() {
        new DnsProductsCatalogPage(driver).clickToCompareButton();
    }
}
