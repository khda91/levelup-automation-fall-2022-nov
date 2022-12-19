package ru.levelp.at.lesson1011.allure;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.openqa.selenium.Capabilities;

public class EnvironmentGenerator {

    private static final String ENV_PROPERTIES_NAME = "environment.properties";
    private static final String ALLURE_RESULTS = "allure-results";

    private final Capabilities capabilities;

    public EnvironmentGenerator(Capabilities capabilities) {
        this.capabilities = capabilities;
    }

    public void createProperties() {
        List<String> properties;
        if (capabilities == null) {
            properties = List.of(
                "environment=test",
                "url=https://dns-shop.ru/",
                "os=" + System.getProperty("os.name")
            );
        } else {
            properties = List.of(
                "environment=test",
                "url=https://dns-shop.ru/",
                "os=" + System.getProperty("os.name"),
                "browser.name=" + capabilities.getBrowserName(),
                "browser.version=" + capabilities.getBrowserVersion()
            );
        }

        try {
            Path allureResults = Paths.get(ClassLoader.getSystemResource("").toURI()).getParent();
            allureResults = Paths.get(allureResults.toAbsolutePath().toString(), ALLURE_RESULTS, ENV_PROPERTIES_NAME);
            if (!Files.exists(allureResults.getParent())) {
                Files.createDirectories(allureResults.getFileName());
            }

            Files.write(allureResults, properties, StandardCharsets.UTF_8);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
