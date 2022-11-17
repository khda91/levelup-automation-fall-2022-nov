package ru.levelp.at.lesson0304.unit.parametrized;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import org.testng.annotations.DataProvider;

public class CalculatorDataProvider {

    @DataProvider
    public static Object[][] calculatorSumDataProvider() {
        List<String> dataFromCsv = readCsv("calculator_sum.csv");
        Object[][] data = new Object[dataFromCsv.size()][];
        for (int i = 0; i < dataFromCsv.size(); i++) {
            Object[] objects = Arrays.stream(dataFromCsv.get(i).split(";"))
                                     .map(Integer::parseInt)
                                     .toArray();
            data[i] = objects;
        }
        return data;
    }

    @DataProvider(name = "Multiply Data")
    public static Object[][] calculatorMultiplyDataProvider() {
        List<String> dataFromCsv = readCsv("calculator_multiply.csv");
        Object[][] data = new Object[dataFromCsv.size()][];
        for (int i = 0; i < dataFromCsv.size(); i++) {
            String[] elems = dataFromCsv.get(i).split(";");
            Object[] intsData = new Object[elems.length];
            for (int j = 0; j < elems.length; j++) {
                Integer number = Integer.parseInt(elems[j]);
                intsData[j] = number;
            }
            data[i] = intsData;
        }
        return data;
    }

    private static List<String> readCsv(String fileName) {
        try {
            return Files.readAllLines(Path.of(CalculatorDataProvider.class
                .getResource("/ru/levelp/at/lesson0304/unit/data/" + fileName).toURI()));
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
