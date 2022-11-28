package ru.levelp.at.lesson0507.selenium.step.design.pattern.steps;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import ru.levelp.at.lesson0507.step.design.pattern.composite.DnsProductCardComposite;
import ru.levelp.at.utils.SleepUtils;

public class ActionStep extends BaseStep {

    public ActionStep(WebDriver driver) {
        super(driver);
    }

    public void openMainDnsPage() {
        indexPage.open();
    }

    public void openProductCategory(String categoryName, String subCategoryName, String productSubCategoryName) {
        indexPage.openMenuCategory(categoryName);
        catalogPage.getSubcategoryItems().openSubcategory(subCategoryName);
        subCatalogPage.getSubcategoryItems().openSubcategory(productSubCategoryName);
    }

    public List<String> compareSelectedProducts(int... productIndexes) {
        List<String> addedToCompareProductsTitles = new ArrayList<>();

        List<DnsProductCardComposite> products = productsPage.getProducts();

        for (int productIndex : productIndexes) {
            int index = productIndex - 1;
            products.get(index).clickAddToCompare();
            addedToCompareProductsTitles.add(products.get(index).getTitle());

            productsPage.getCompareLoginModal().closeIfVisible();
        }

        productsPage.clickToCompareButton();

        return addedToCompareProductsTitles;
    }
}
