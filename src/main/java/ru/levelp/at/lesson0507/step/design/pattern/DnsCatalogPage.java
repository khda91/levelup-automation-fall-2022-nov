package ru.levelp.at.lesson0507.step.design.pattern;

import org.openqa.selenium.WebDriver;
import ru.levelp.at.lesson0507.step.design.pattern.composite.DnsSubcategoryItemComposite;

public class DnsCatalogPage extends DnsBasePage {

    private final DnsSubcategoryItemComposite subcategoryItems;

    public DnsCatalogPage(WebDriver driver) {
        super(driver);
        subcategoryItems = new DnsSubcategoryItemComposite(driver);
    }

    public DnsSubcategoryItemComposite getSubcategoryItems() {
        return subcategoryItems;
    }

    @Override
    public void open() {
        throw new UnsupportedOperationException("Not implemented");
    }
}
