package ru.levelp.at.lesson0507.selenium.step.design.pattern.steps;

import org.openqa.selenium.WebDriver;
import ru.levelp.at.lesson0507.step.design.pattern.DnsCatalogPage;
import ru.levelp.at.lesson0507.step.design.pattern.DnsComparePage;
import ru.levelp.at.lesson0507.step.design.pattern.DnsIndexPage;
import ru.levelp.at.lesson0507.step.design.pattern.DnsProductsCatalogPage;
import ru.levelp.at.lesson0507.step.design.pattern.DnsSubCatalogPage;

public abstract class BaseStep {

    protected final WebDriver driver;

    protected DnsIndexPage indexPage;
    protected DnsCatalogPage catalogPage;
    protected DnsSubCatalogPage subCatalogPage;
    protected DnsProductsCatalogPage productsPage;
    protected DnsComparePage comparePage;

    protected BaseStep(WebDriver driver) {
        this.driver = driver;
        indexPage = new DnsIndexPage(driver);
        catalogPage = new DnsCatalogPage(driver);
        subCatalogPage = new DnsSubCatalogPage(driver);
        productsPage = new DnsProductsCatalogPage(driver);
        comparePage = new DnsComparePage(driver);
    }
}
